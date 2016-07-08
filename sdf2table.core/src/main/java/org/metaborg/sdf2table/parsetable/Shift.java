package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.Trigger;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoInt;

public class Shift extends Action{
	private static final StrategoConstructor CONS_SHIFT = new StrategoConstructor("shift", 1);
	State _dest;
	
	public Shift(Trigger trigger, State dest){
		super(trigger);
		_dest = dest;
	}
	
	public State getDestination(){
		return _dest;
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(
				CONS_SHIFT,
				new IStrategoTerm[]{new StrategoInt(_dest.id(), null, 0)},
				null,
				0
		);
	}
}
