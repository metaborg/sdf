package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class TermAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = 7822056824144207749L;

    IStrategoTerm term;
    String term_name;    

    public TermAttribute(IStrategoTerm term, String term_name) {
        this.term = term;
        this.term_name = term_name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("term", 1), term);
    }
    
    @Override public String toString() {
        return term.toString();
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((term_name == null) ? 0 : term_name.hashCode());
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
        if(term_name == null) {
            if(other.term_name != null)
                return false;
        } else if(!term_name.equals(other.term_name))
            return false;
        return true;
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("Term", 1), term);
    }   
}
