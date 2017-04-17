package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class StartSymbol extends Symbol {

    public StartSymbol() {
        followRestrictions = Sets.newHashSet();
    }

    @Override public String name() {
        return "<START>";
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("sort", 1), tf.makeString(name()));
    }

    @Override public int hashCode() {
        return "<START>".hashCode();
    }
}
