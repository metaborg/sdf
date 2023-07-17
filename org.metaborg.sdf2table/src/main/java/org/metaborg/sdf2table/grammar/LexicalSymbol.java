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

public class LexicalSymbol extends Symbol {
    
    private static final long serialVersionUID = 1481976564637864975L;

    private final Symbol symbol;

    protected LexicalSymbol(Symbol symbol) {
        this.symbol = symbol;
        followRestrictionsLookahead = new ArrayList<>();
        followRestrictionsNoLookahead = null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override public String name() {
        return getSymbol().name() + "-LEX";
    }    
    
    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("lex", 1), getSymbol().toAterm(tf));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Lex", 1), getSymbol().toSDF3Aterm(tf, ctx_vals, ctx_val));
    }

   

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        LexicalSymbol other = (LexicalSymbol) obj;
        if(symbol == null) {
            if(other.symbol != null)
                return false;
        } else if(!symbol.equals(other.symbol))
            return false;
        return true;
    }

    @Override public ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        return symbol.toParseTableSymbol(SyntaxContext.Lexical, cardinality);
    }
}
