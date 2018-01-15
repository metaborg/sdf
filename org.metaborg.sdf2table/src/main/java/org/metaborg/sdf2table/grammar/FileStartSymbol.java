package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class FileStartSymbol extends Symbol {

    private static final long serialVersionUID = 3822777948371151629L;

    public FileStartSymbol() {
        followRestrictionsLookahead = Lists.newArrayList();
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

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Sort", 1), tf.makeString(name()));
    }
    
    @Override public int hashCode() {
        return "<Start>".hashCode();
    }
    
    @Override public boolean equals(Object s) {
        if(s == null) return false;
        return (s instanceof FileStartSymbol);
    }
}
