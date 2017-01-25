package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class Layout extends Symbol {
    
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

    @Override public int hashCode() {
        return "LAYOUT".hashCode();
    }
}
