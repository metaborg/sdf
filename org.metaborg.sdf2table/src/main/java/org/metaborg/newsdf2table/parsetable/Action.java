package org.metaborg.newsdf2table.parsetable;

import org.metaborg.newsdf2table.grammar.CharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Action {
    
    CharacterClass cc;
    public abstract IStrategoTerm toAterm(ITermFactory tf, ITableGenerator pt);
    
    public abstract int hashCode();
    public abstract boolean equals(Object obj);

}
