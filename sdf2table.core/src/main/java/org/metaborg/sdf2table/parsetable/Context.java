package org.metaborg.sdf2table.parsetable;

import java.util.Set;
import java.util.TreeSet;

import org.metaborg.sdf2table.grammar.PriorityLevel;

public class Context{
	Set<PriorityLevel> _priorities;
	
	public Context(){
		_priorities = new TreeSet<>();
	}
	
	public Context(Set<PriorityLevel> priorities){
		_priorities = priorities;
	}
	
	public Context(Context other){
		_priorities = new TreeSet<>(other._priorities);
	}
	
	public boolean contains(PriorityLevel prio){
		for(PriorityLevel p : _priorities){
			if(p.greaterThan(prio))
				return true;
		}
		return false;
	}
	
	public Context without(Context c){
		Set<PriorityLevel> set = new TreeSet<>();
		
		for(PriorityLevel p : _priorities){
			if(!c.contains(p))
				set.add(p);
		}
		
		return new Context(set);
	}
	
	public Context without(Set<PriorityLevel> priorities){
		return without(new Context(priorities));
	}
	
	public Context union(Context c){
		Set<PriorityLevel> set = new TreeSet<>();
		
		for(PriorityLevel p : _priorities){
			if(!c.contains(p))
				set.add(p);
		}
		
		for(PriorityLevel p : c._priorities){
			if(!contains(p))
				set.add(p);
		}
		
		return new Context(set);
	}
	
	public Context union(Set<PriorityLevel> priorities){
		return union(new Context(priorities));
	}
	
	@Override
	public boolean equals(Object other){
		if(other != null && other instanceof Context){
			Context c = (Context)other;
			return c._priorities.equals(_priorities);
		}
		return false;
	}
	
	@Override
	public String toString(){
		String str = "";
		for(PriorityLevel l : _priorities){
			if(!str.isEmpty())
				str += ",";
			str += l.toString();
		}
		return "{"+str+"}";
	}
}