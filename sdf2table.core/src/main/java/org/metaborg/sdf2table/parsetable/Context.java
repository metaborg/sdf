package org.metaborg.sdf2table.parsetable;

import java.util.Set;
import java.util.TreeSet;

import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.Production;

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
	
	public boolean conflictsLeft(Production p){
		if(p.left() != null && p.left().nonEpsilon())
			return false;
		for(PriorityLevel l : _priorities){
			if(l.production().priorities().deepConflicts(p, l.position()))
				return true;
		}
		return false;
	}
	
	public boolean conflictsRight(Production p){
		if(p.right() != null && p.right().nonEpsilon())
			return false;
		for(PriorityLevel l : _priorities){
			if(l.production().priorities().deepConflicts(p, l.position()))
				return true;
		}
		return false;
	}
	
	public void leftSimplify(Set<Production> derivations){
		Set<PriorityLevel> simplified = new TreeSet<>();
		for(PriorityLevel l : _priorities){
			for(Production p : derivations){
				if(p.left() == null || !p.left().nonEpsilon()){
					if(l.production().priorities().deepConflicts(p, l.position())){
						simplified.add(l);
						break;
					}
				}
			}
		}
		_priorities = simplified;
	}
	
	public void rightSimplify(Set<Production> derivations){
		Set<PriorityLevel> simplified = new TreeSet<>();
		for(PriorityLevel l : _priorities){
			for(Production p : derivations){
				if(p.right() == null || !p.right().nonEpsilon()){
					if(l.production().priorities().deepConflicts(p, l.position())){
						simplified.add(l);
						break;
					}
				}
			}
		}
		_priorities = simplified;
	}
	
	public boolean contains(PriorityLevel prio){
		for(PriorityLevel p : _priorities){
			if(p.equals(prio) || p.greaterThan(prio))
				return true;
		}
		return false;
	}
	
	public Context union(Context c){
		if(c == null)
			return this;
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

	public boolean isEmpty() {
		return _priorities.isEmpty();
	}
}