package org.metaborg.sdf2table.symbol;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Layout extends NonTerminal {
	private static final StrategoConstructor CONS_LAYOUT = new StrategoConstructor("layout", 0);
	
	public Layout(){
		super();
	}
	
	@Override
	public boolean equals(Symbol other) {
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
