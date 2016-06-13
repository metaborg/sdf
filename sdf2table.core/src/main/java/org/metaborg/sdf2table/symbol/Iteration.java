package org.metaborg.sdf2table.symbol;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Iteration extends NonTerminal {
	private static final StrategoConstructor CONS_ITER = new StrategoConstructor("iter", 1);
	private static final StrategoConstructor CONS_ITER_SEP = new StrategoConstructor("iter-sep", 2);
	private static final StrategoConstructor CONS_ITER_STAR = new StrategoConstructor("iter-star", 1);
	private static final StrategoConstructor CONS_ITER_STAR_SEP = new StrategoConstructor("iter-star-sep", 2);
	
	private Symbol _symbol;
	private Symbol _sep;
	private int _min; // Minimum iteration
	
	public Iteration(Symbol symbol, int min, Symbol separator){
		super();
		_symbol = symbol;
		_sep = separator;
		_min = min;
	}
	
	public Symbol getSeparator(){
		return _sep;
	}
	
	public Symbol getSymbol(){
		return _symbol;
	}
	
	public int getMinimum(){
		return _min;
	}
	
	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Iteration){
			Iteration i = (Iteration)other;
			return other != null && _symbol != null && _min == i.getMinimum() && _symbol.equals(i.getSymbol());
		}
		return false;
	}

	@Override
	public String toString() {
		String str = "";
		if(_sep != null)
			str += "{";
		str += _symbol.toString();
		if(_sep != null){
			str += ", "+_sep.toString()+"}";
		}
		if(_min == 0)
			str += "*";
		else
			str += "+";
		return str;
	}
	
	public IStrategoTerm toATerm(){
		if(_sep != null)
			return new StrategoAppl(_min == 1 ? CONS_ITER_SEP : CONS_ITER_STAR_SEP, new IStrategoTerm[]{_symbol.toATerm(), _sep.toATerm()}, null, 0);
		return new StrategoAppl(_min == 1 ? CONS_ITER : CONS_ITER_STAR, new IStrategoTerm[]{_symbol.toATerm()}, null, 0);
	}
}
