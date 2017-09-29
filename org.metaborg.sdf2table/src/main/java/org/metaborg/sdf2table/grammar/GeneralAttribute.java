package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class GeneralAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = 6844193956229562479L;

    private String name;

    public GeneralAttribute(String name) {
        this.setName(name);
    }

    @Override public String toString() {
        return getName();
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        GeneralAttribute other = (GeneralAttribute) obj;
        if(getName() == null) {
            if(other.getName() != null)
                return false;
        } else if(!getName().equals(other.getName()))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        switch(getName()) {
            case "right":
            case "assoc":
            case "left":
                return tf.makeAppl(tf.makeConstructor("assoc", 1), tf.makeAppl(tf.makeConstructor(getName(), 0)));
            case "prefer":
            case "reject":
            case "avoid":
                return tf.makeAppl(tf.makeConstructor(getName(), 0));
            default:
                return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor(getName(), 0)));
        }
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        switch(getName()) {
            case "right":
                return tf.makeAppl(tf.makeConstructor("Assoc", 1), tf.makeAppl(tf.makeConstructor("Right", 0)));
            case "assoc":
                return tf.makeAppl(tf.makeConstructor("Assoc", 1), tf.makeAppl(tf.makeConstructor("Assoc", 0)));
            case "left":
                return tf.makeAppl(tf.makeConstructor("Assoc", 1), tf.makeAppl(tf.makeConstructor("Left", 0)));
            case "prefer":
                return tf.makeAppl(tf.makeConstructor("Prefer", 0));
            case "reject":
                return tf.makeAppl(tf.makeConstructor("Reject", 0));
            case "avoid":
                return tf.makeAppl(tf.makeConstructor("Avoid", 0));
            case "recover":
                return tf.makeAppl(tf.makeConstructor("Recover", 0));
            default:
                return tf.makeAppl(tf.makeConstructor("Term", 1),
                    tf.makeAppl(tf.makeConstructor("Default", 1), tf.makeAppl(tf.makeConstructor("Fun", 1),
                        tf.makeAppl(tf.makeConstructor("Unquoted", 1), tf.makeString(name)))));
        }
    }
}
