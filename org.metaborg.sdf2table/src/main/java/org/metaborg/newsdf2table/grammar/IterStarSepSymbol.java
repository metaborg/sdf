package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class IterStarSepSymbol extends Symbol {

    Symbol symbol;
    Sort sep;

    public IterStarSepSymbol(Symbol symbol, Symbol sep) {
        this.symbol = symbol;
        this.sep = (Sort) sep;
        followRestrictions = Sets.newHashSet();
    }

    @Override public String name() {
        return "{" + symbol.name() + " " + sep.name() + "}*";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("iter-star-sep", 2), symbol.toAterm(tf), sep.toAterm(tf));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sep == null) ? 0 : sep.hashCode());
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        IterStarSepSymbol other = (IterStarSepSymbol) obj;
        if(sep == null) {
            if(other.sep != null)
                return false;
        } else if(!sep.equals(other.sep))
            return false;
        if(symbol == null) {
            if(other.symbol != null)
                return false;
        } else if(!symbol.equals(other.symbol))
            return false;
        return true;
    }

}