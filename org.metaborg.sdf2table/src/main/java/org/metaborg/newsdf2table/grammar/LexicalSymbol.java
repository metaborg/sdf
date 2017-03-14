package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class LexicalSymbol extends Symbol {
    
    Symbol symbol;

    public LexicalSymbol(Symbol symbol) {
        this.symbol = symbol;
        followRestrictions = Sets.newHashSet();     
    }

    @Override public String name() {
        return symbol.name() + "-LEX";
    }    
    
    @Override public String toString() {
        return name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("lex", 1), symbol.toAterm(tf));
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
        if(!super.equals(obj))
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
}
