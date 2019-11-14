package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.metaborg.sdf2table.grammar.IAttribute;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class DeprecatedAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = -7202401718360224664L;
    
    private final String message;

    protected DeprecatedAttribute(String message) {
        this.message = message;
    }

    public DeprecatedAttribute() {
        message = "";
    }

    @Override public String toString() {
        if(message == null) {
            return "deprecated";
        }
        return "deprecated(\"" + message + "\")";
    }
    

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        DeprecatedAttribute other = (DeprecatedAttribute) obj;
        if(message == null) {
            if(other.message != null)
                return false;
        } else if(!message.equals(other.message))
            return false;
        return true;
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
