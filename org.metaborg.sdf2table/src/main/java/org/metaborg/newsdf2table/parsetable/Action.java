package org.metaborg.newsdf2table.parsetable;

import org.metaborg.newsdf2table.grammar.CharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Action {
    
    CharacterClass cc;
    abstract IStrategoTerm toAterm(ITermFactory tf, ParseTableGenerator pt);
    
    public abstract int hashCode();
    public abstract boolean equals(Object obj);

}
