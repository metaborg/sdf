package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.symbol.Symbol.Type;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Alternative extends ConcreteNonTerminal{
	private static final StrategoConstructor CONS_ALT = new StrategoConstructor("alt", 1);
	
	private Symbol _a, _b;
	
	public Alternative(Symbol a, Symbol b){
		super();
		_a = a;
		_b = b;
	}
	
	@Override
	public Type type(){
		return Type.CONTEXT_FREE;
	}
	
	@Override
	public boolean nonEpsilon(){
		return _a.nonEpsilon() && _b.nonEpsilon();
	}
	
	@Override
	public boolean isLayout() {
		return _a.isLayout() && _b.isLayout();
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Alternative){
			Alternative a = (Alternative)other;
			return other != null && ((_a.equals(a._a) && _b.equals(a._b)) || (_a.equals(a._b) && _b.equals(a._a)));
		}
		return false;
	}

	@Override
	public String toString() {
		return "("+_a.toString()+" | "+_b.toString()+")";
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(CONS_ALT, new IStrategoTerm[]{_a.toATerm(), _b.toATerm()}, null, 0);
	}
}
