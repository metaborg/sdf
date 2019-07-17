package org.metaborg.parsetable;

import org.metaborg.parsetable.states.IState;
import org.spoofax.interpreter.terms.IStrategoTerm;

public interface IParseTableGenerator {

    IParseTable getParseTable();

    IStrategoTerm getStateAterm(IState s);
}
