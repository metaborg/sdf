package org.metaborg.newsdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class Layout extends Symbol {

    private static final long serialVersionUID = -2539873583275536984L;

    public Layout() {
        followRestrictions = Sets.newHashSet();
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
