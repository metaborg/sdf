package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoInt;

public class Range extends Terminal{
	private static final StrategoConstructor CONS_RANGE = new StrategoConstructor("range", 2);
	
	private int _min;
	private int _max;
	
	public Range(int min, int max){
		super();
		_min = min;
		_max = max;
	}
	
	public int minimum(){
		return _min;
	}
	
	public int maximum(){
		return _max;
	}
	
	@Override
	public boolean contains(int c) {
		return c >= _min && c <= _max;
	}

	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Range){
			Range r = (Range)other;
			return other != null && _min == r.minimum() && _max == r.maximum();
		}
		return false;
	}

	@Override
	public String terminalString() {
		return Numeric.toString(_min)+"-"+Numeric.toString(_max);
	}
	
	public List<IStrategoTerm> getATermCC(){
		List<IStrategoTerm> terms = new ArrayList<>();
		
		terms.add(new StrategoAppl(
				CONS_RANGE,
				new IStrategoTerm[]{
					new StrategoInt(_min, null, 0),
					new StrategoInt(_max, null, 0)
				},
				null,
				0
		));
		
		return terms;
	}
	
	@Override
	public Terminal except(CharClass... restrictions){
		// We want to find all sub ranges that are not included in {restrictions}.
		// min and max correspond to the current valid range.
		int min = -1;
		int max = -1;
		
		// The final restricted terminal.
		Terminal rt = null;

		// For each value of the range (plus a last iteration).
		for(int i = _min; i <=_max+1; ++i){
			boolean ok = false; // The value is valid or not (restricted or not).
			
			// if we are in the range...
			if(i <= _max){
				ok = true;
				for(CharClass r : restrictions){
					if(r.contains(i)){
						ok = false; // invalid.
						break;
					}
				}
				
				if(ok){ // We augment our current range (or create it if min == -1).
					if(min == -1)
						min = i;
					max = i;
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
}
