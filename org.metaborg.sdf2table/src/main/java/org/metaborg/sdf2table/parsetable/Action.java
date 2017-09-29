package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.CharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Action {
    
    CharacterClass cc;
    public abstract IStrategoTerm toAterm(ITermFactory tf, IParseTable pt);
    
    public abstract int hashCode();
    public abstract boolean equals(Object obj);

}
