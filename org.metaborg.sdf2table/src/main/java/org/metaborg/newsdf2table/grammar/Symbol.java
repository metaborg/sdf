package org.metaborg.newsdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Symbol {

    Set<Symbol> followRestrictions;
    
    public boolean nullable = false;

    public abstract String name();

    @Override public String toString() {
        return name();
    }

    public Set<Symbol> followRestriction() {
        return followRestrictions;
    }

    public abstract int hashCode();
    public abstract boolean equals(Object s);

    public abstract IStrategoTerm toAterm(ITermFactory tf);
    public abstract IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val);
}
