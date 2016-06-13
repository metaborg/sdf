package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class ContextualSymbol extends NonTerminal{
	Symbol _symbol;
	
	Context _left_context;
	Context _right_context;
	
	public ContextualSymbol(Context left, Symbol symbol, Context right){
		_left_context = left;
		_symbol = symbol;
		_right_context = right;
	}

	@Override
	public boolean equals(Symbol other){
		if(other != null && other instanceof ContextualSymbol){
			ContextualSymbol cs = (ContextualSymbol)other;
			return other == this || (cs._symbol.equals(_symbol) && cs._left_context.equals(_left_context) && cs._right_context.equals(_right_context));
		}
		return false;
	}

	@Override
	public String toString() {
		return "<L:"+_symbol.toString()+":R>";
	}

	@Override
	public IStrategoTerm toATerm() {
		return _symbol.toATerm();
	}
}
