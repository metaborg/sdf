package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class ConstructorAttribute implements IAttribute {

    String constructor;

    public ConstructorAttribute(String constructor) {
        this.constructor = constructor;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {

        return tf.makeAppl(tf.makeConstructor("term", 1),
            tf.makeAppl(tf.makeConstructor("cons", 1), tf.makeString(constructor)));

    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((constructor == null) ? 0 : constructor.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        ConstructorAttribute other = (ConstructorAttribute) obj;
        if(constructor == null) {
            if(other.constructor != null)
                return false;
        } else if(!constructor.equals(other.constructor))
            return false;
        return true;
    }

}
