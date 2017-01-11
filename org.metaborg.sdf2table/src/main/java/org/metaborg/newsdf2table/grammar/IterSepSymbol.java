package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class IterSepSymbol extends Symbol {

    Symbol symbol;
    NonTerminal sep;

    public IterSepSymbol(Symbol symbol, Symbol iSymbol) {
        this.symbol = symbol;
        this.sep = (NonTerminal) iSymbol;
    }

    @Override public String name() {
        return "{" + symbol.name() + " " + sep.name() + "}+";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("iter-sep", 2), symbol.toAterm(tf), sep.toAterm(tf));
    }

}
