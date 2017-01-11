package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Symbol {
    
    /**
     * Name of the symbol
     *
     * @return the String corresponding to the symbol name.
     */
    public abstract String name();  
    public abstract IStrategoTerm toAterm(ITermFactory tf);
    
    @Override public String toString() {
        return name();
    }
    
    @Override public boolean equals(Object s) {
        if (s instanceof Symbol) {
            Symbol symb = (Symbol) s;
            if (symb.name().equals(this.name())){
                return true;
            }
        }
        return false;
    }
}
 