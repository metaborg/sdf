package org.metaborg.newsdf2table.parsetable;

import java.util.Set;

import org.metaborg.newsdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class ContextualSymbol extends Symbol {

    Symbol s;
    Set<Context> contexts;

    public ContextualSymbol(Symbol s, Set<Context> context) {
        this.s = s;
        this.contexts = context;
    }
    
    public ContextualSymbol(Symbol s, Context context) {
        this.s = s;
        Set<Context> contexts = Sets.newHashSet(context);
        this.contexts = contexts;
    }
    
    @Override public String name() {
        String buf = "";
        buf += s.name();
        if(!contexts.isEmpty()) {
            int i = 0;
            buf += "[";
            for(Context p : contexts) {
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
        result = prime * result + ((contexts == null) ? 0 : contexts.hashCode());
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
        if(contexts == null) {
            if(other.contexts != null)
                return false;
        } else if(!contexts.equals(other.contexts))
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

    public ContextualSymbol addContext(Context new_context) {
        Set<Context> new_contexts = Sets.newHashSet();
        new_contexts.addAll(contexts);
        new_contexts.add(new_context);
        
        return new ContextualSymbol(s, new_contexts);
    }
    
    
    public ContextualSymbol addContexts(Set<Context> contexts) {
        Set<Context> new_contexts = Sets.newHashSet();
        new_contexts.addAll(contexts);
        new_contexts.addAll(this.contexts);
        
        return new ContextualSymbol(s, new_contexts);
    }
    
}
