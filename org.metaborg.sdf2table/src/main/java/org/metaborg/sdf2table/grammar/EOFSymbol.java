package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.symbols.ISymbol;
import org.metaborg.parsetable.symbols.SortCardinality;
import org.metaborg.parsetable.symbols.SyntaxContext;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class EOFSymbol extends Symbol {

    private static final long serialVersionUID = -6397863074361783451L;

    protected EOFSymbol() {
        followRestrictionsLookahead = Lists.newArrayList();
        followRestrictionsNoLookahead = null;
    }

    @Override public String name() {
        return "<EOF>";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("sort", 1), tf.makeString(name()));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Sort", 1), tf.makeString(name()));
    }

    @Override public int hashCode() {
        return "<EOF>".hashCode();
    }

    @Override public boolean equals(Object s) {
        return s != null && s instanceof EOFSymbol;
    }

    @Override public ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        return new org.metaborg.parsetable.symbols.SortSymbol(syntaxContext, cardinality, name());
    }
}
