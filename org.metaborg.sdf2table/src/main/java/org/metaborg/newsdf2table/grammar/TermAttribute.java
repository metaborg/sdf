package org.metaborg.newsdf2table.grammar;

import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class TermAttribute implements IAttribute {

    private String name;
    private List<String> elems;

    public TermAttribute(String name, List<String> elems) {
        this.name = name;
        this.elems = elems;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        List<IStrategoTerm> elems_aterm = Lists.newArrayList();
        for (String s : elems) {
            tf.makeString(s);
        }
        return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor(getName(), elems.size()), tf.makeList(elems_aterm)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((elems == null) ? 0 : elems.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        TermAttribute other = (TermAttribute) obj;
        if(elems == null) {
            if(other.elems != null)
                return false;
        } else if(!elems.equals(other.elems))
            return false;
        if(name == null) {
            if(other.name != null)
                return false;
        } else if(!name.equals(other.name))
            return false;
        return true;
    }
    
    @Override public String toString() {
        String buf = "";
        buf += name + "(";
        int i = 0;
        for (String s : elems) {
            if (i != 0) buf += ", ";
            buf += s;
            i++;
        }
        return buf;
    }
}
