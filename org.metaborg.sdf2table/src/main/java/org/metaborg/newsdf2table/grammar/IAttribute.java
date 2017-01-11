package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public interface IAttribute {
    public IStrategoTerm toAterm(ITermFactory tf);
}
