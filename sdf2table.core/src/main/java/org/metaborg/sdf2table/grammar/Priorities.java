package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.core.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

public class Priorities{
	/**
	 * PriorityLevel associated to a position inside a production.
	 */
	public static class PosPriorityLevel{
		/**
		 * The priority level
		 */
		private PriorityLevel _level;
		
		/**
		 * The position inside the production
		 */
		private int _position;
		
		/**
		 * Hash code for HashSet.
		 */
		private int _hash_code = -1;
		
		public PosPriorityLevel(PriorityLevel level, int position){
			_level = level;
			_position = position;
		}
		
		public PriorityLevel level(){
			return _level;
		}
		
		public int position(){
			return _position;
		}
		
		@Override
		public int hashCode(){
			if(_hash_code == -1){
				int[] ary = {_level.hashCode(), _position};
				_hash_code = Utilities.hashCode(ary);
			}
			return _hash_code;
		}
		
		@Override
		public boolean equals(Object o){
			if(o != null && o instanceof PosPriorityLevel){
				PosPriorityLevel l = (PosPriorityLevel)o;
				return l._position == _position && _level == l._level;
			}
			
			return false;
		}
	}
	
	/**
	 * The production associated to theses priorities informations.
	 */
	private SyntaxProduction _production;
	
	/**
	 * Direct higher productions.
	 */
	private Set<Priority> _higher = new HashSet<Priority>();
	
	/**
	 * Direct lower productions.
	 */
	private Set<Priority> _lower = new HashSet<Priority>();
	
	/**
	 * Priority levels.
	 */
	private Set<PosPriorityLevel> _levels;
	
	public Priorities(SyntaxProduction production){
		_production = production;
	}
	
	/**
	 * Compute the priority levels.
	 * This method is automatically called the first time {@link #priorityLevels()} is called.
	 */
	public void computePriorityLevels(){
		if(_levels == null){
			_levels = new HashSet<>();

			if(_lower.isEmpty()){
				_levels.add(new PosPriorityLevel(PriorityLevel.unique(_production, -1), -1));
			}else{
				for(Priority p : _lower){
					_levels.add(new PosPriorityLevel(PriorityLevel.unique(_production, p.position()), p.position()));
				}
			}
		}
	}
	
	/**
	 * Get priority levels.
	 * @return The priority levels associated to the production.
	 */
	public Set<PosPriorityLevel> priorityLevels(){
		if(_levels == null)
			computePriorityLevels();
		
		return _levels;
	}
	
	public Set<PriorityLevel> priorityLevels(int position){
		Set<PriorityLevel> set = new HashSet<>();
		
		for(PosPriorityLevel p : priorityLevels()){
			if(!p.level().isRoot() && (p.position() == -1 || p.position() == position))
				set.add(p.level());
		}
		
		return set;
	}
	
	public Set<Priority> lowerPriorities(){
		return _lower;
	}
	
	public Set<Priority> higherPriorities(){
		return _higher;
	}
	
	public boolean addHigher(Priority p){
		if(_higher.add(p)){
			/*_higher.addAll(p.production().priorities().higherPriorities());
			if(p.isTransitive()){
				for(Priority l : _lower){
					l.production().priorities().addHigher(p);
				}
			}*/
			return true;
		}
		return false;
	}
	
	public boolean addLower(Priority p){
		if(_lower.add(p)){
			/*_lower.addAll(p.production().priorities().lowerPriorities());
			if(p.isTransitive()){
				for(Priority l : _higher){
					l.production().priorities().addLower(p);
				}
			}*/
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
	/*public boolean shallowConflicts(SyntaxProduction np, int position){
		for(Priority l : _lower){
			if((l.position() == -1 || l.position() == position) && l.production().equals(np))
				return true;
		}
		return false;
	}*/
	
	/**
	 * 
	 * @param np
	 * @param position
	 * @return
	 */
	/*public boolean deepConflicts(SyntaxProduction p, int position){
		for(Priority l : _lower){
			if((l.position() == -1 || l.position() == position) && l.production().equals(p))
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
								a.priorities.add(new Priority(SyntaxProduction.fromATerm(group.getSubterm(0), syntax), a.position, a.transitive));
							}else if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("ProdsGroup")){
								for(IStrategoTerm tp : (StrategoList)group.getSubterm(0)){
									a.priorities.add(new Priority(SyntaxProduction.fromATerm(tp, syntax), a.position, a.transitive));
								}
							}else{
								System.err.println("Priorities Section: Malformed term: SimpleGroup expected.");
							}
							
							for(Priority p : a.priorities){
								if(p != null){
									if(ascendant != null){
										for(Priority higher : ascendant.priorities){
											Priority lower = new Priority(p.production(), higher.position(), higher.isTransitive());
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
