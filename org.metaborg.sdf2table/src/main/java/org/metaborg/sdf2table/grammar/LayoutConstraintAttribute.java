package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class LayoutConstraintAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = -6962864785117290116L;

    String constraint;

    public LayoutConstraintAttribute(String constraint) {
        this.constraint = constraint;
    }

    @Override public String toString() {
        if(constraint == "ignore-layout") {
            return constraint;
        } else
            return "layout(\"" + constraint + "\")";
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if (constraint == "ignore-layout") {
            return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor("ignore-layout", 0)));
        }
        
        return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor("layout", 1), tf.makeString(constraint)));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        if (constraint == "ignore-layout") {
            return tf.makeAppl(tf.makeConstructor("Term", 1), tf.makeAppl(tf.makeConstructor("IgnoreLayout", 0)));
        }
        
        return tf.makeAppl(tf.makeConstructor("Term", 1), tf.makeAppl(tf.makeConstructor("layout", 1), tf.makeString(constraint)));
    }
}
