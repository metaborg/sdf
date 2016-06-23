package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.parsetable.Priority;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

public class Priorities{
	Set<Priority> _higher = new HashSet<Priority>();
	Set<Priority> _lower = new HashSet<Priority>();
	
	Set<PriorityLevel> _levels;
	
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
		
		for(PriorityLevel p : priorityLevels()){
			if(p.position() == -1 || p.position() == position)
				set.add(p);
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
	public boolean shallowConflicts(IProduction np, int position){
		for(Priority l : _lower){
			if((l.position() == -1 || l.position() == position) && l.production().equals(np))
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param np
	 * @param position
	 * @return
	 */
	public boolean deepConflicts(Production p, int position){
		for(Priority l : _lower){
			if((l.position() == -1 || l.position() == position) && l.production().equals(p))
				return true;
		}
		return false;
	}
	
	/*public boolean conflictsLeft(Symbol s){
		if(_production.rightSet().contains(s))
			return true;
		for(Priority p : _higher){
			if(p.production().rightSet().contains(s))
				return true;
		}
		return false;
	}
	
	public boolean conflictsRight(Symbol s){
		if(_production.leftSet().contains(s))
			return true;
		for(Priority p : _higher){
			if(p.production().leftSet().contains(s))
				return true;
		}
		return false;
	}*/
	
	public List<IStrategoTerm> toATerms(){
		List<IStrategoTerm> list = new LinkedList<>();
		
		for(Priority l : _lower){
			list.add(l.toATerm(_production));
		}
		
		return list;
	}
	
	public static void fromStrategoTerm(IStrategoTerm term, Syntax syntax){
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
								a.priorities.add(new Priority(Production.fromATerm(group.getSubterm(0), syntax), a.position, a.transitive));
							}else if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("ProdsGroup")){
								for(IStrategoTerm tp : (StrategoList)group.getSubterm(0)){
									a.priorities.add(new Priority(Production.fromATerm(tp, syntax), a.position, a.transitive));
								}
							}else{
								System.err.println("Priorities Section: Malformed term: SimpleGroup expected.");
							}
							
							for(Priority p : a.priorities){
								if(p != null){
									if(ascendant != null){
										for(Priority higher : ascendant.priorities){
											Priority lower = new Priority(p.production(), higher.position(), higher.isTransitive());
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
