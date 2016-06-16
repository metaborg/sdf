package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.parsetable.Priority;
import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

public class Priorities{
	Set<Priority> _higher = new HashSet<Priority>();
	Set<Priority> _lower = new HashSet<Priority>();
	
	Set<PriorityLevel> _levels = new HashSet<PriorityLevel>();
	
	Production _production;
	
	public Priorities(Production production){
		_production = production;
	}
	
	public Set<PriorityLevel> priorityLevels(){
		if(_levels == null){
			_levels = new HashSet<>();
			for(Priority p : _lower){
				_levels.add(new PriorityLevel(_production, p.position()));
			}
		}
		return _levels;
	}
	
	public Set<PriorityLevel> priorityLevels(int position){
		Set<PriorityLevel> set = new HashSet<>();
		
		for(PriorityLevel l : priorityLevels()){
			if(l.position() == -1 || l.position() == position)
				set.add(l);
		}
		
		return set;
	}
	
	Set<Priority> lowerPriorities(){
		return _lower;
	}
	
	Set<Priority> higherPriorities(){
		return _higher;
	}
	
	public boolean addHigher(Priority p){
		if(_higher.add(p)){
			if(p.isTransitive()){
				for(Priority l : _lower){
					l.production().priorities().addHigher(p);
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean addLower(Priority p){
		if(_lower.add(p)){
			if(p.isTransitive()){
				for(Priority l : _higher){
					l.production().priorities().addLower(p);
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Old priority conflict semantic.
	 * @param np
	 * @param position
	 * @return
	 */
	public boolean conflicts(IProduction np, int position){
		for(Priority l : _lower){
			if((l.position() == -1 || l.position() == position) && l.production().equals(np))
				return true;
		}
		return false;
	}
	
	public static void fromStrategoTerm(IStrategoTerm term, Syntax syntax, SymbolCollection symbols){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Priorities")){
				StrategoList chains = (StrategoList)app.getSubterm(0);
				
				for(IStrategoTerm chain : chains){
					if(chain instanceof StrategoAppl && ((StrategoAppl)chain).getName().equals("Chain")){
						StrategoList groups = (StrategoList)chain.getSubterm(0);
						
						class Ascendant{
							public int position = -1;
							public boolean transitive = true;
							public List<Priority> priorities = new LinkedList<>();
						}
						
						Ascendant ascendant = null;
						
						for(IStrategoTerm group : groups){
							Ascendant a = new Ascendant();
							
							if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("NonTransitive")){
								a.transitive = false;
								group = group.getSubterm(0);
							}
							if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("WithArguments")){
								StrategoAppl argv = (StrategoAppl)group.getSubterm(1);
								if(!argv.getName().equals("Default")){
									System.err.println("Priorities Section: Malformed term: Unknown priority parameter `"+argv.toString()+"'");
									continue;
								}
								StrategoList positions = (StrategoList)argv.getSubterm(0);
								if(positions.size() > 1){
									System.err.println("Priorities Section: Malformed term: Unsuported multi positions priority"); // TODO multi-positions priority ?
									continue;
								}
								a.position = Integer.parseInt(((StrategoString)positions.head()).stringValue());
								group = group.getSubterm(0);
							}
							if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("SimpleGroup")){
								a.priorities.add(new Priority(syntax.uniqueProduction(Production.fromATerm(group.getSubterm(0), symbols)), a.position, a.transitive));
							}else if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("ProdsGroup")){
								for(IStrategoTerm tp : (StrategoList)group.getSubterm(0)){
									a.priorities.add(new Priority(syntax.uniqueProduction(Production.fromATerm(tp, symbols)), a.position, a.transitive));
								}
							}else{
								System.err.println("Priorities Section: Malformed term: SimpleGroup expected.");
							}
							
							for(Priority p : a.priorities){
								if(p != null){
									if(ascendant != null){
										Priority lower = new Priority(p.production(), a.position, a.transitive);
										
										for(Priority higher : ascendant.priorities){
											//ap.addPriority(new Priority(ap, p, ascendant.position, ascendant.transitive));
											higher.production().priorities().addLower(lower);
											p.production().priorities().addHigher(higher);
										}
									}
								}else{
									System.err.println("Priorities Section: Malformed term: Undefined production.");
								}
							}
							
							ascendant = a;
						}
					}else{
						System.err.println("Priorities Section: Malformed term: Chain expected.");
					}
				}

			}
		}
	}
}
