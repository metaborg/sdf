package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class ContextFreeSymbol extends Symbol {

    Symbol symbol;

    public ContextFreeSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override public String name() {
        return symbol.name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("cf", 1), symbol.toAterm(tf));
    }
    
}
