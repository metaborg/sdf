package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class Layout extends Symbol {

    private static final long serialVersionUID = -2539873583275536984L;

    public Layout() {
        followRestrictionsLookahead = Lists.newArrayList();
        followRestrictionsNoLookahead = null;
    }

    @Override public String name() {
        return "LAYOUT";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("layout", 0));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Layout", 0));
    }

    @Override public int hashCode() {
        return "LAYOUT".hashCode();
    }

    @Override public boolean equals(Object s) {
        if(s == null)
            return false;
        return(s instanceof Layout);
    }
}
