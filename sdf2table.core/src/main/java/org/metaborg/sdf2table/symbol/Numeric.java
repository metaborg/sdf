package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoInt;

public class Numeric extends Terminal{
	private int _value;
	
	public Numeric(int value){
		super();
		_value = value;
	}
	
	public int getValue(){
		return _value;
	}
	
	public int minimum(){
		return _value;
	}
	
	public int maximum(){
		return _value;
	}
	
	@Override
	public boolean contains(int c) {
		return _value == c;
	}

	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Numeric){
			Numeric n = (Numeric)other;
			return other != null && _value == n.getValue();
		}
		return false;
	}
	
	public static String toString(int value){
		if(value >= '!' && value <= '~')
			return "\\"+String.valueOf((char)value);
		if(value == 256)
			return "$eof";
		return "\\"+String.valueOf(value);
	}

	@Override
	public String terminalString() {
		return toString(_value);
	}
	
	public List<IStrategoTerm> getATermCC(){
		List<IStrategoTerm> terms = new ArrayList<>();
		
		terms.add(new StrategoInt(_value, null, 0));
		
		return terms;
	}
	
	public Terminal except(CharClass... restrictions){
		for(CharClass r : restrictions){
			if(r.contains(_value))
				return null;
		}
		return this;
	}
}
