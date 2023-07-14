package org.metaborg.sdf2table.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.symbols.ISymbol;
import org.metaborg.parsetable.symbols.SortCardinality;
import org.metaborg.parsetable.symbols.SyntaxContext;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class SequenceSymbol extends Symbol {

    private static final long serialVersionUID = -1328952925094286799L;

    private final Symbol first;
    private final List<Symbol> tail;


    protected SequenceSymbol(Symbol first, List<Symbol> tail) {        
        this.first = first;
        this.tail = tail;
        followRestrictionsLookahead = new ArrayList<>();
        followRestrictionsNoLookahead = null;
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
        IStrategoList.Builder tail_aterm = tf.arrayListBuilder(tail.size());

        for(Symbol s : tail) {
            tail_aterm.add(s.toAterm(tf));
        }

        return tf.makeAppl(tf.makeConstructor("seq", 2), first.toAterm(tf), tf.makeList(tail_aterm));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        IStrategoList.Builder tail_aterm = tf.arrayListBuilder(tail.size());

        for(Symbol s : tail) {
            tail_aterm.add(s.toSDF3Aterm(tf, ctx_vals, ctx_val));
        }

        return tf.makeAppl(tf.makeConstructor("Sequence", 2), first.toSDF3Aterm(tf, ctx_vals, ctx_val),
            tf.makeList(tail_aterm));
    }

  

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((tail == null) ? 0 : tail.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        SequenceSymbol other = (SequenceSymbol) obj;
        if(first == null) {
            if(other.first != null)
                return false;
        } else if(!first.equals(other.first))
            return false;
        if(tail == null) {
            if(other.tail != null)
                return false;
        } else if(!tail.equals(other.tail))
            return false;
        return true;
    }

    @Override public ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        List<ISymbol> symbols = new ArrayList<>();

        symbols.add(first.toParseTableSymbol(syntaxContext, cardinality));
        for(Symbol tailSymbol : tail) {
            symbols.add(tailSymbol.toParseTableSymbol(syntaxContext, cardinality));
        }

        return new org.metaborg.parsetable.symbols.SequenceSymbol(syntaxContext, cardinality, symbols);
    }
}
