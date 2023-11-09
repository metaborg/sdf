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

public class FileStartSymbol extends Symbol {

    private static final long serialVersionUID = 3822777948371151629L;

    protected FileStartSymbol() {
        followRestrictionsLookahead = new ArrayList<>();
        followRestrictionsNoLookahead = null;
    }

    @Override public String name() {
        return "<Start>";
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
        return "<Start>".hashCode();
    }

    @Override public boolean equals(Object s) {
        return s != null && s instanceof FileStartSymbol;
    }

    @Override public ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        return new org.metaborg.parsetable.symbols.SortSymbol(syntaxContext, cardinality, name());
    }
}
