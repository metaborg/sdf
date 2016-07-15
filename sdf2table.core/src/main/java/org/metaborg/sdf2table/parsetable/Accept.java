package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.Trigger;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Accept extends Action{
	private static final StrategoConstructor CONS_ACCEPT = new StrategoConstructor("accept", 0);
	
	public Accept(Trigger trigger){
		super(trigger);
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(
				CONS_ACCEPT,
				new IStrategoTerm[]{},
				null,
				0
		);
	}
}
