package org.metaborg.newsdf2table.grammar;

import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class SequenceSymbol extends Symbol {

    Symbol first;
    List<Symbol> tail;

    public SequenceSymbol(Symbol first, List<Symbol> tail) {
        this.first = first;
        this.tail = tail;
    }

    @Override public String name() {
        String name = first.name() + " ";
        for(Symbol s : tail) {
            name += s.name() + " ";
        }
        return name;
    }

    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        List<IStrategoTerm> tail_aterm = Lists.newArrayList();

        for(Symbol s : tail) {
            tail_aterm.add(s.toAterm(tf));
        }

        return tf.makeAppl(tf.makeConstructor("seq", 2), first.toAterm(tf), tf.makeList(tail_aterm));
    }
}
