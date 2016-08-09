package org.metaborg.sdf2table.parsetable;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.symbol.NonTerminal;

public class Context{
	Set<PriorityLevel> _priorities;
	int _hash_code = -1;
	
	public Context(){
		_priorities = new TreeSet<>();
	}
	
	public Context(Set<PriorityLevel> priorities){
		_priorities = priorities;
	}
	
	public Context(Context other){
		_priorities = new TreeSet<>(other._priorities);
	}
	
	public boolean conflictsLeft(SyntaxProduction p){
		/*if(p.left() != null && p.left().nonEpsilon())
			return false;*/
		for(PriorityLevel l : _priorities){
			/*if(l.production().priorities().deepConflicts(p, l.position()))
				return true;*/
			if(l.conflicts(p))
				return true;
		}
		return false;
	}
	
	public boolean conflictsRight(SyntaxProduction p){
		/*if(p.right() != null && p.right().nonEpsilon())
			return false;*/
		for(PriorityLevel l : _priorities){
			/*if(l.production().priorities().deepConflicts(p, l.position()))
				return true;*/
			if(l.conflicts(p))
				return true;
		}
		return false;
	}
	
	public void leftSimplify(SyntaxProduction sp, NonTerminal nt, int pos/*Set<SyntaxProduction> derivations*/){
		/*Set<PriorityLevel> simplified = new TreeSet<>();
		for(PriorityLevel l : _priorities){
			for(SyntaxProduction p : derivations){
				if(p.left() == null || !p.left().nonEpsilon()){
					if(l.production().priorities().deepConflicts(p, l.position())){
						simplified.add(l);
						break;
					}
				}
			}
		}
		_priorities = simplified;*/
		
		Set<PriorityLevel> simplified = new TreeSet<>();
		
		for(PriorityLevel l : _priorities){
			for(Production p : nt.productions()){
				SyntaxProduction ntsp = p.syntaxProduction();
				
				if(!sp.directConflicts(ntsp, pos) && ntsp.potentialLeftDeepConflict(l)){
					simplified.add(l);
					break;
				}
			}
		}
		
		_priorities = simplified;
	}
	
	public void rightSimplify(SyntaxProduction sp, NonTerminal nt, int pos/*Set<SyntaxProduction> derivations*/){
		/*Set<PriorityLevel> simplified = new TreeSet<>();
		for(PriorityLevel l : _priorities){
			for(SyntaxProduction p : derivations){
				if(p.right() == null || !p.right().nonEpsilon()){
					if(l.production().priorities().deepConflicts(p, l.position())){
						simplified.add(l);
						break;
					}
				}
			}
		}
		_priorities = simplified;*/
		
		Set<PriorityLevel> simplified = new TreeSet<>();
		
		for(PriorityLevel l : _priorities){
			for(Production p : nt.productions()){
				SyntaxProduction ntsp = p.syntaxProduction();
				
				if(!sp.directConflicts(ntsp, pos) && ntsp.potentialRightDeepConflict(l)){
					simplified.add(l);
					break;
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
	
	public void computeHashCode(){
		_hash_code = 0;
		int[] hashs = new int[_priorities.size()];
		int i = 0;
		for(PriorityLevel l : _priorities){
			hashs[i] = l.hashCode();
        	++i;
		}
		Arrays.sort(hashs);
		_hash_code = Utilities.hashCode(hashs);
	}
	
	@Override
	public int hashCode(){
		if(_hash_code == -1)
			computeHashCode();
		return _hash_code;
	}

	public boolean isEmpty() {
		return _priorities.isEmpty();
	}
}