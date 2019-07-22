package org.metaborg.sdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public interface IAttribute {
    IStrategoTerm toAterm(ITermFactory tf);
    IStrategoTerm toSDF3Aterm(ITermFactory tf);
    
    @Override int hashCode();
    @Override boolean equals(Object obj);
}
