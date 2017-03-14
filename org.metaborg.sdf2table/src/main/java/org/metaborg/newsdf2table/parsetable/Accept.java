package org.metaborg.newsdf2table.parsetable;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class Accept extends Action {

    public Accept() {
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, ParseTableGenerator pt) {
        return tf.makeAppl(tf.makeConstructor("accept", 0));
    }
    
    @Override public String toString() {        
        return "accept()";
    }

    @Override public int hashCode() {
        return "accept".hashCode();
    }

    @Override public boolean equals(Object obj) {
        return true;
    }

}
