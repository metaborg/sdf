package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.symbol.Symbol.Type;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Layout extends ConcreteNonTerminal{
	private static final StrategoConstructor CONS_LAYOUT = new StrategoConstructor("layout", 0);
	
	public Layout(){
		super();
	}
	
	public boolean nonEpsilon(){
		return false;
	}
	
	@Override
	public Type type(){
		return Type.UNDEF;
	}
	
	@Override
	public boolean isLayout(){
		return true;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Layout){
			return other != null;
		}
		return false;
	}

	@Override
	public String toString() {
		return "LAYOUT";
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(CONS_LAYOUT, new IStrategoTerm[]{}, null, 0);
	}
}
