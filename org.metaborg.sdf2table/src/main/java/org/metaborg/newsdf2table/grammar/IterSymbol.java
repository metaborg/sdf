package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class IterSymbol extends Symbol {
    
    Symbol symbol;
    
    public IterSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override public String name() {
        return symbol.name() + "+";
    }
    
    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("iter", 1), symbol.toAterm(tf));
    }

}
