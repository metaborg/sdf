package org.metaborg.sdf2table.grammar;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


import org.metaborg.parsetable.symbols.ISymbol;
import org.metaborg.parsetable.symbols.SortCardinality;
import org.metaborg.parsetable.symbols.SyntaxContext;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class IterSepSymbol extends Symbol {

    private static final long serialVersionUID = -3470718150418144669L;

    private final Symbol symbol;
    private final Sort sep;

    protected IterSepSymbol(Symbol symbol, Sort sep) {
        this.symbol = symbol;
        this.sep = sep;
        followRestrictionsLookahead = new ArrayList<>();
        followRestrictionsNoLookahead = null;
    }

    @Override public String name() {
        return "{" + symbol.name() + " " + sep.name() + "}+";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("iter-sep", 2), symbol.toAterm(tf), sep.toAterm(tf));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("IterSep", 2), symbol.toSDF3Aterm(tf, ctx_vals, ctx_val), sep.toSDF3Aterm(tf, ctx_vals, ctx_val));
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
        IterSepSymbol other = (IterSepSymbol) obj;
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

    public Symbol getSymbol() {
        return symbol;
    }

    @Override public ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        return symbol.toParseTableSymbol(syntaxContext, SortCardinality.IterSep);
    }
}
