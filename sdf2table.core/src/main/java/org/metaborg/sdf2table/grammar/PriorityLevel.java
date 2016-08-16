package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.Set;

import org.metaborg.sdf2table.core.CollisionSet;
import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Priorities.PosPriorityLevel;

/**
 * Priority level class
 * 
 * Note that this class extends Comparable, but it doesn't
 * correspond to the priority level comparison, but only to a
 * lexical order comparison to be used with the TreeSet class.
 */
public class PriorityLevel implements Comparable<Object>{
	static final private CollisionSet<PriorityLevel> _levels = new CollisionSet<>();
	
	public static PriorityLevel unique(SyntaxProduction production, int position){
		PriorityLevel l = new PriorityLevel(production, position);
		PriorityLevel u = _levels.push(l);
		if(u == null)
			u = l;
		else
			u._productions.addAll(l._productions);
		return u;
	}
	
	public static void reset(){
		_levels.clear();
	}
	
	public static int count(){
		return _levels.size();
	}
	
	private static class PosProduction{
		SyntaxProduction _production;
		int _position;
		int _hash_code = -1;
		
		public PosProduction(SyntaxProduction production, int position){
			_production = production;
			_position = position;
		}
		
		public int position(){
			return _position;
		}
		
		public SyntaxProduction production(){
			return _production;
		}
		
		@Override
		public int hashCode(){
			if(_hash_code == -1){
				_hash_code = Utilities.hashCode(_position, _production.hashCode());
			}
			return _hash_code;
		}
		
		@Override
		public boolean equals(Object o){
			if(o == this)
				return true;
			if(o != null && o instanceof PosProduction){
				PosProduction p = (PosProduction)o;
				return _production == p._production && _position == p._position;
			}
			return false;
		}
		
		Set<Priority> higherProductions(){
			return _production.priorities().higherPriorities();
		}
		
		Set<Priority> lowerProductions(){
			Set<Priority> set = new HashSet<>();
			for(Priority p : _production.priorities().lowerPriorities()){
				if(p.position() == -1 || p.position() == _position){
					set.add(p);
				}
			}
			return set;
		}
	}
	
	int _hash_code = -1;
	String _str = null;
	
	Set<Priority> _higher_p;
	Set<Priority> _lower_p;
	
	Set<PosProduction> _productions = new HashSet<>();
	
	Set<PriorityLevel> _lower = null;
	
	public PriorityLevel(SyntaxProduction production, int position){
		PosProduction agent = new PosProduction(production, position);
		_higher_p = agent.higherProductions();
		_lower_p = agent.lowerProductions();
		_productions.add(agent);
	}
	
	Set<PriorityLevel> lowerLevels(){
		if(_lower == null)
			computeLowerLevels();
		return _lower;
	}
	
	void addTo(Set<PriorityLevel> set, boolean transitive){
		if(set.add(this) && transitive){
			for(Priority p : lowerProductions()){
				if(p.isTransitive()){
					for(PosPriorityLevel l : p.production().priorities().priorityLevels()){
						l.level().addTo(set, transitive);
					}
				}
			}
		}
	}
	
	boolean isRoot(){
		return lowerProductions().isEmpty();
	}
	
	void computeLowerLevels(){
		_lower = new HashSet<>();
		
		for(Priority p : lowerProductions()){
			for(PosPriorityLevel l : p.production().priorities().priorityLevels()){
				l.level().addTo(_lower, p.isTransitive());
			}
		}
	}
	
	void computeHashCode(){
		int[] hashs = new int[lowerProductions().size()*3 + higherProductions().size()*3];
		int i = 0;
		for(Priority p : lowerProductions()){
			hashs[i++] = p.production().hashCode();
			hashs[i++] = p.position();
			hashs[i++] = p.isTransitive() ? 0 : 1;
		}
		for(Priority p : higherProductions()){
			hashs[i++] = p.production().hashCode();
			hashs[i++] = p.position();
			hashs[i++] = p.isTransitive() ? 0 : 1;
		}
		_hash_code = Utilities.hashCode(hashs);
	}
	
	@Override
	public int hashCode(){
		if(_hash_code == -1)
			computeHashCode();
		return _hash_code;
	}
	
	@Override
	public boolean equals(Object other){
		if(other != null && other instanceof PriorityLevel){
			PriorityLevel l = (PriorityLevel)other;
			if(higherProductions().equals(l.higherProductions()) && lowerProductions().equals(l.lowerProductions()))
				return true;
		}
		return false;
	}
	
	Set<Priority> higherProductions(){
		return _higher_p;
	}
	
	Set<Priority> lowerProductions(){
		return _lower_p;
	}
	
	public void addProduction(PosProduction pp){
		_productions.add(pp);
		_str = null;
	}
	
	public Set<PosProduction> productions(){
		return _productions;
	}
	
	public boolean conflicts(SyntaxProduction p){
		for(PosPriorityLevel l : p.priorities().priorityLevels()){
			if(greaterThan(l.level()))
				return true;
		}
		
		return false;
	}
	
	public boolean greaterThan(PriorityLevel l){
		return lowerLevels().contains(l);
	}
	
	/*public boolean greaterThan(PriorityLevel l){
		for(Priority p : l._production.priorities().higherPriorities()){
			if(p.position() == _position && p.production().equals(_production))
				return true;
		}
		return false;
	}
	
	public boolean greaterThan(SyntaxProduction prod){
		for(Priority p : _production.priorities().lowerPriorities()){
			if(p.position() == _position && p.production().equals(prod))
				return true;
		}
		return false;
	}*/
	
	@Override
	public String toString(){
		if(_str == null){
			_str = "";
			
			for(PosProduction p : _productions){
				if(!_str.isEmpty())
					_str += ",";
				_str += p.production().shortString();
				if(p.position() != -1)
					_str += "<"+String.valueOf(p.position())+">";
			}
		}
		return _str;
	}

	@Override
	public int compareTo(Object obj) {
		if(obj == null)
			throw new NullPointerException();
		if(!(obj instanceof PriorityLevel))
			throw new ClassCastException();
		return ((PriorityLevel)obj).toString().compareTo(toString());
	}
}
