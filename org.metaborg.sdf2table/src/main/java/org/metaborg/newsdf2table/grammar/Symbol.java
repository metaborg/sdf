package org.metaborg.newsdf2table.grammar;

import java.util.Set;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Symbol {

    Set<Symbol> followRestrictions;
    
    public boolean nullable = false;

    public abstract String name();

    public abstract IStrategoTerm toAterm(ITermFactory tf);

    @Override public String toString() {
        return name();
    }

    public Set<Symbol> followRestriction() {
        return followRestrictions;
    }

    public abstract int hashCode();

    @Override public boolean equals(Object s) {
        if(s instanceof Symbol) {
            Symbol symb = (Symbol) s;
            if(symb.name().equals(this.name())) {
                return true;
            }
        }
        return false;
    }
}
