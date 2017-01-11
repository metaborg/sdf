package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClass extends Symbol {

    Symbol cc;
    
    public CharacterClass() {
        cc = null;
    }
    
    public CharacterClass(Symbol s) {
        this.cc = s;
    }

    @Override public String name() {
        String name = "[";
        name += cc.name() + "]";
        return name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("char-class", 1), tf.makeList(cc.toAterm(tf)));
    }
    
    
    
}
