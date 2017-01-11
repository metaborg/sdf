package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class IterStarSepSymbol extends Symbol {

    Symbol symbol;
    NonTerminal sep;

    public IterStarSepSymbol(Symbol symbol, Symbol sep) {
        this.symbol = symbol;
        this.sep = (NonTerminal) sep;
    }

    @Override public String name() {
        return "{" + symbol.name() + " " + sep.name() + "}*";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("iter-star-sep", 2), symbol.toAterm(tf), sep.toAterm(tf));
    }

}
