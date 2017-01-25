package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class AltSymbol extends Symbol {

    Symbol alt1;
    Symbol alt2;
        
    public AltSymbol(Symbol alt1, Symbol alt2) {
        this.alt1 = alt1;
        this.alt2 = alt2;
        followRestrictions = Sets.newHashSet();
    }

    @Override public String name() {
        return alt1.name() + " | " + alt2.name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("alt", 2), alt1.toAterm(tf), alt2.toAterm(tf));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alt1 == null) ? 0 : alt1.hashCode());
        result = prime * result + ((alt2 == null) ? 0 : alt2.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        AltSymbol other = (AltSymbol) obj;
        if(alt1 == null) {
            if(other.alt1 != null)
                return false;
        } else if(!alt1.equals(other.alt1))
            return false;
        if(alt2 == null) {
            if(other.alt2 != null)
                return false;
        } else if(!alt2.equals(other.alt2))
            return false;
        return true;
    }


}
