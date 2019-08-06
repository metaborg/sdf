package org.metaborg.parsetable;

import org.metaborg.parsetable.states.IState;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.google.common.collect.SetMultimap;

public interface IParseTableGenerator {

    IParseTable getParseTable();

    IStrategoTerm getStateAterm(IState s);
    
    SetMultimap<String, String> getNonAssocPriorities();
}
