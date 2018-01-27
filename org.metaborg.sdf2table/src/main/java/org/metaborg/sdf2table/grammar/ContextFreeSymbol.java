package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class ContextFreeSymbol extends Symbol {

    private static final long serialVersionUID = -3684899773909946148L;

    private final Symbol symbol;

    public ContextFreeSymbol(Symbol symbol) {
        this.symbol = symbol;
        followRestrictionsLookahead = Lists.newArrayList();
        followRestrictionsNoLookahead = null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override public String name() {
        return getSymbol().name() + "-CF";
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("cf", 1), getSymbol().toAterm(tf));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Cf", 1), getSymbol().toSDF3Aterm(tf, ctx_vals, ctx_val));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        ContextFreeSymbol other = (ContextFreeSymbol) obj;
        if(symbol == null) {
            if(other.symbol != null)
                return false;
        } else if(!symbol.equals(other.symbol))
            return false;
        return true;
    }
    
}
