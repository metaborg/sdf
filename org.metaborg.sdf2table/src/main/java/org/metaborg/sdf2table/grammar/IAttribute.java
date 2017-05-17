package org.metaborg.sdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public interface IAttribute {
    public IStrategoTerm toAterm(ITermFactory tf);
    public IStrategoTerm toSDF3Aterm(ITermFactory tf);
    
    @Override int hashCode();
    @Override boolean equals(Object obj);
}
