package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.CharacterClass;
import org.metaborg.sdf2table.jsglrinterfaces.ISGLRAction;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Action implements ISGLRAction {
    
    CharacterClass cc;
    public abstract IStrategoTerm toAterm(ITermFactory tf, ParseTable pt);
    
    public abstract int hashCode();
    public abstract boolean equals(Object obj);

}
