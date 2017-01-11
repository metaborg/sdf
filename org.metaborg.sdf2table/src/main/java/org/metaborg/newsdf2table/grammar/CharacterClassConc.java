package org.metaborg.newsdf2table.grammar;

import java.util.List;

import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class CharacterClassConc extends Symbol {

    Symbol first;
    Symbol second;

    public CharacterClassConc(Symbol first, Symbol second) {
        this.first = first;
        this.second = second;
    }

    public String name() {
        return first.name() + second.name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        List<IStrategoTerm> terms = Lists.newArrayList();

        IStrategoTerm firstAterm = first.toAterm(tf);
        IStrategoTerm secondAterm = second.toAterm(tf);

        if(firstAterm instanceof IStrategoList) {
            for(IStrategoTerm t : firstAterm.getAllSubterms()) {
                terms.add(t);
            }
        } else {
            terms.add(firstAterm);
        }
        
        if(secondAterm instanceof IStrategoList) {
            for(IStrategoTerm t : secondAterm.getAllSubterms()) {
                terms.add(t);
            }
        } else {
            terms.add(secondAterm);
        }

        return tf.makeList(terms);
    }

}
