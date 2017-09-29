package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class DeprecatedAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = -7202401718360224664L;
    
    String message;

    public DeprecatedAttribute(String message) {
        this.message = message;
    }

    public DeprecatedAttribute() {

    }

    @Override public String toString() {
        if(message == null) {
            return "deprecated";
        }
        return "deprecated(\"" + message + "\")";
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if(message == null) {
            return tf.makeAppl(tf.makeConstructor("deprecated", 0));
        } else {
            return tf.makeAppl(tf.makeConstructor("deprecated", 1), tf.makeString(message));
        }
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        if(message == null) {
            return tf.makeAppl(tf.makeConstructor("Deprecated", 0));
        } else {
            return tf.makeAppl(tf.makeConstructor("Deprecated", 1), tf.makeString("\"" + message + "\""));
        }
    }

}
