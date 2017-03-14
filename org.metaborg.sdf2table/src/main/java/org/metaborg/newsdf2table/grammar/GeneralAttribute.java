package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class GeneralAttribute implements IAttribute {

    private String name;

    public GeneralAttribute(String name) {
        this.setName(name);
    }

    @Override public String toString() {
        return getName();
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
}
