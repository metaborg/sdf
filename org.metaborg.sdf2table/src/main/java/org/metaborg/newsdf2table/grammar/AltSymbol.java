package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class AltSymbol extends Symbol {

    Symbol alt1;
    Symbol alt2;
        
    public AltSymbol(Symbol alt1, Symbol alt2) {
        this.alt1 = alt1;
        this.alt2 = alt2;
    }

    @Override public String name() {
        return alt1.name() + " | " + alt2.name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("alt", 2), alt1.toAterm(tf), alt2.toAterm(tf));
    }


}
