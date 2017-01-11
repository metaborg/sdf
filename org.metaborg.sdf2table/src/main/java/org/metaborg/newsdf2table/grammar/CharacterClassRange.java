package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassRange extends Symbol {

    Symbol start;
    Symbol end;
    
    public CharacterClassRange(Symbol iSymbol, Symbol  iSymbol2) {
        this.start = iSymbol;
        this.end =  iSymbol2;
    }

    public String name() {
        return start.name() + "-" + end.name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("range", 2), start.toAterm(tf), end.toAterm(tf));
    }
    
}
