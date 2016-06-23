package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.parsetable.Priority;

public class PriorityLevel implements Comparable<Object>{
	Production _production;
	int _position;
	
	String _str;
	
	public PriorityLevel(Production production, int position){
		_production = production;
		_position = position;
	}
	
	public Production production(){
		return _production;
	}
	
	public int position(){
		return _position;
	}
	
	public boolean greaterThan(PriorityLevel l){
		for(Priority p : l._production.priorities().higherPriorities()){
			if(p.position() == _position && p.production().equals(_production))
				return true;
		}
		return false;
	}
	
	public boolean greaterThan(Production prod){
		for(Priority p : _production.priorities().lowerPriorities()){
			if(p.position() == _position && p.production().equals(prod))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object other){
		if(other != null && other instanceof PriorityLevel){
			PriorityLevel l = (PriorityLevel)other;
			if(l._position == _position && l._production.equals(_production))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public String toString(){
		if(_str == null){
			_str = _production.shortString();
			if(_position != -1)
				_str += "<"+String.valueOf(_position)+">";
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
