package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.core.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;

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
}
