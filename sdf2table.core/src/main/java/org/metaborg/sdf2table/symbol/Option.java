package org.metaborg.sdf2table.symbol;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Option extends NonTerminal {
	private static final StrategoConstructor CONS_OPT = new StrategoConstructor("opt", 1);
	
	private Symbol _symbol;
	
	public Option(Symbol symbol){
		super();
		_symbol = symbol;
	}
	
	public Symbol getSymbol(){
		return _symbol;
	}
	
	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Option){
			return other != null && _symbol != null && _symbol.equals(((Option)other).getSymbol());
		}
		return false;
	}

	@Override
	public String toString() {
		return _symbol.toString()+"?";
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(CONS_OPT, new IStrategoTerm[]{_symbol.toATerm()}, null, 0);
	}
}
