package org.metaborg.newsdf2table.parsetable;

import java.util.Set;

import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class ContextualSymbol extends Symbol {

    Symbol s;
    Set<IProduction> context;

    public ContextualSymbol(Symbol s, Set<IProduction> context) {
        this.s = s;
        this.context = context;
    }
    
    @Override public String name() {
        String buf = "";
        buf += s.name();
        if(!context.isEmpty()) {
            int i = 0;
            buf += "[";
            for(IProduction p : context) {
                if(i != 0)
                    buf += ", ";
                buf += p;
                i++;
            }
            buf += "]";
        }
        return buf;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return s.toAterm(tf);
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((s == null) ? 0 : s.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        ContextualSymbol other = (ContextualSymbol) obj;
        if(context == null) {
            if(other.context != null)
                return false;
        } else if(!context.equals(other.context))
            return false;
        if(s == null) {
            if(other.s != null)
                return false;
        } else if(!s.equals(other.s))
            return false;
        return true;
    }
    
    @Override public Set<Symbol> followRestriction() {
        return s.followRestriction();
    }

    public Symbol addContext(IProduction new_context) {
        Set<IProduction> new_contexts = Sets.newHashSet();
        new_contexts.addAll(context);
        new_contexts.add(new_context);
        
        return new ContextualSymbol(s, new_contexts);
    }
    
    
    public ContextualSymbol addContexts(Set<IProduction> contexts) {
        Set<IProduction> new_contexts = Sets.newHashSet();
        new_contexts.addAll(context);
        new_contexts.addAll(contexts);
        
        return new ContextualSymbol(s, new_contexts);
    }
    
}
