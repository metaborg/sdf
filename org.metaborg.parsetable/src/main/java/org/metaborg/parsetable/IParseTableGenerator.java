package org.metaborg.parsetable;

import org.metaborg.parsetable.IParseTable;
import org.metaborg.parsetable.IState;
import org.spoofax.interpreter.terms.IStrategoTerm;

public interface IParseTableGenerator {

    IParseTable getParseTable();

    IStrategoTerm getStateAterm(IState s);
}
