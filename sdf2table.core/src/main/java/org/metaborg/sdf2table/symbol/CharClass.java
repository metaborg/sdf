package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.grammar.Trigger;
import org.spoofax.interpreter.terms.IStrategoTerm;

public abstract class CharClass extends Symbol implements Trigger{
	@Override
	public boolean nonEpsilon(){
		return true;
	}
	
	@Override
	public boolean isLayout(){
		return false;
	}
	
	@Override
	public boolean isEpsilon(){
		return false;
	}
	
	@Override
	public Type type(){
		return Type.TERMINAL;
	}
	
	public abstract boolean contains(int c);
	
	public boolean intersects(CharClass cc){
		for(int c = minimum(); c <= maximum(); ++c){
			if(contains(c) && cc.contains(c))
				return true;
		}
		return false;
	}
	
	public abstract Terminal firstTerminal();
	
	public abstract int minimum();
	public abstract int maximum();
	
	public static int minimum(CharClass... ary){
		int min = ary[0].minimum();
		for(int i = 1; i < ary.length; ++i){
			if(ary[i].minimum() < min)
				min = ary[i].minimum();
		}
		
		return min;
	}
	
	public static int maximum(CharClass... ary){
		int max = ary[0].maximum();
		for(int i = 1; i < ary.length; ++i){
			if(ary[i].maximum() > max)
				max = ary[i].maximum();
		}
		
		return max;
	}
	
	@Override
	public Trigger inter(Trigger t){
		if(t instanceof CharClass)
			return Terminal.inter(this, (CharClass)t);
		return null;
	}
	
	@Override
	public Trigger except(Trigger t){
		if(this instanceof Terminal && t instanceof CharClass)
			return ((Terminal)this).doExcept((CharClass)t);
		return this;
	}
	
	public Terminal union(CharClass cc){
		return Terminal.union(this, cc);
	}
	
	public static Terminal union(CharClass... ary){
		int _min = minimum(ary);
		int _max = maximum(ary);
		
		// We want to find all sub ranges that are not included in {restrictions}.
		// min and max correspond to the current valid range.
		int min = -1;
		int max = -1;
		
		// The final restricted terminal.
		Terminal rt = null;

		// For each value of the range (plus a last iteration).
		for(int c = _min; c <=_max+1; ++c){
			boolean ok = false; // The value is valid or not (restricted or not).
			
			// if we are in the range...
			if(c <= _max){
				ok = false;
				for(CharClass cc : ary){
					if(cc.contains(c)){
						ok = true; // valid.
						break;
					}
				}
				
				if(ok){ // We augment our current range (or create it if min == -1).
					if(min == -1)
						min = c;
					max = c;
				}
			}
			
			// We are out of a valid range, but we have detected one.
			if(!ok && min != -1){
				Terminal t;
				if(min == max)
					t = new Numeric(min); // Single-value range, a numeric.
				else
					t = new Range(min, max);
				
				if(rt == null)
					rt = t; // it's the first, and may be the only, range.
				else
					rt = new Union(rt, t); // Not the first one, we merge them.
				min = max = -1;
			}
		}
		
		return rt;
	}
	
	public static Terminal inter(CharClass... ary){
		int _min = minimum(ary);
		int _max = maximum(ary);
		
		// We want to find all sub ranges that are not included in {restrictions}.
		// min and max correspond to the current valid range.
		int min = -1;
		int max = -1;
		
		// The final restricted terminal.
		Terminal rt = null;

		// For each value of the range (plus a last iteration).
		for(int c = _min; c <=_max+1; ++c){
			boolean ok = false; // The value is valid or not (restricted or not).
			
			// if we are in the range...
			if(c <= _max){
				ok = true;
				for(CharClass cc : ary){
					if(!cc.contains(c)){
						ok = false; // invalid.
						break;
					}
				}
				
				if(ok){ // We augment our current range (or create it if min == -1).
					if(min == -1)
						min = c;
					max = c;
				}
			}
			
			// We are out of a valid range, but we have detected one.
			if(!ok && min != -1){
				Terminal t;
				if(min == max)
					t = new Numeric(min); // Single-value range, a numeric.
				else
					t = new Range(min, max);
				
				if(rt == null)
					rt = t; // it's the first, and may be the only, range.
				else
					rt = new Union(rt, t); // Not the first one, we merge them.
				min = max = -1;
			}
		}
		
		return rt;
	}
	
	public abstract IStrategoTerm toATerm();
} 
