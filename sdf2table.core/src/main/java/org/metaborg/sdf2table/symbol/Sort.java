package org.metaborg.sdf2table.symbol;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoString;

public class Sort extends NonTerminal {
	private static final StrategoConstructor CONS_SORT = new StrategoConstructor("sort", 1);
	
	String _name;
	
	public Sort(String name){
		super();
		_name = name;
	}
	
	public String getName(){
		return _name;
	}
	
	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Sort){
			return other != null && _name != null && _name.equals(((Sort)other).getName());
		}
		return false;
	}

	@Override
	public String toString() {
		return _name;
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(CONS_SORT, new IStrategoTerm[]{new StrategoString(_name, null, 0)}, null, 0);
	}
}
