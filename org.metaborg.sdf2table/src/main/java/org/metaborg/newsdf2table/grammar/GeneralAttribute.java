package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class GeneralAttribute implements IAttribute {
    
    String name;
    
    public GeneralAttribute(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor(name, 0));
    }
}
