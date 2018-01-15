package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class IterStarSepSymbol extends Symbol {

    private static final long serialVersionUID = 2024802620253703574L;

    private final Symbol symbol;
    private final Sort sep;

    public IterStarSepSymbol(Symbol symbol, Symbol sep) {
        this.symbol = symbol;
        this.sep = (Sort) sep;
        followRestrictionsLookahead = Lists.newArrayList();
        followRestrictionsNoLookahead = null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Sort getSeparator() {
        return sep;
    }

    @Override public String name() {
        return "{" + getSymbol().name() + " " + getSeparator().name() + "}*";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("iter-star-sep", 2), getSymbol().toAterm(tf), getSeparator().toAterm(tf));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("IterStarSep", 2), getSymbol().toSDF3Aterm(tf, ctx_vals, ctx_val), getSeparator().toSDF3Aterm(tf, ctx_vals, ctx_val));
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
        if(obj == null)
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
