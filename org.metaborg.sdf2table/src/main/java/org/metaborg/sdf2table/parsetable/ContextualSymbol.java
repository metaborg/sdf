package org.metaborg.sdf2table.parsetable;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class ContextualSymbol extends Symbol {

    private static final long serialVersionUID = -2886358954796970390L;

    private final Symbol s;
    private final Set<Context> contexts;

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
        if(!getContexts().isEmpty()) {
            boolean hasLeftContext = false;
            for(Context p : getContexts()) {
                if(p.getPosition() == ContextPosition.LEFTMOST) {
                    hasLeftContext = true;
                    break;
                }
            }
            if(hasLeftContext) {
                int i = 0;
                buf += "{";
                for(Context p : getContexts()) {
                    if(p.getPosition() == ContextPosition.RIGHTMOST)
                        continue;
                    if(i != 0)
                        buf += ", ";
                    buf += p;
                    i++;
                }
                buf += "}";
            }
        }
        buf += getOrigSymbol().name();
        if(!getContexts().isEmpty()) {
            boolean hasRightContext = false;
            for(Context p : getContexts()) {
                if(p.getPosition() == ContextPosition.RIGHTMOST) {
                    hasRightContext = true;
                    break;
                }
            }
            if(hasRightContext) {
                int i = 0;
                buf += "{";
                for(Context p : getContexts()) {
                    if(p.getPosition() == ContextPosition.LEFTMOST)
                        continue;
                    if(i != 0)
                        buf += ", ";
                    buf += p;
                    i++;
                }
                buf += "}";
            }
        }
        return buf;
    }

    @Override public Set<Symbol> followRestriction() {
        return getOrigSymbol().followRestriction();
    }

    public Set<Context> getContexts() {
        return contexts;
    }

    public Symbol getOrigSymbol() {
        return s;
    }

    public ContextualSymbol addContext(Context new_context) {
        Set<Context> new_contexts = Sets.newHashSet();
        new_contexts.addAll(getContexts());
        new_contexts.add(new_context);

        return new ContextualSymbol(getOrigSymbol(), new_contexts);
    }

    public ContextualSymbol addContexts(Set<Context> contexts) {
        Set<Context> new_contexts = Sets.newHashSet();
        new_contexts.addAll(contexts);
        new_contexts.addAll(this.getContexts());

        return new ContextualSymbol(getOrigSymbol(), new_contexts);
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return getOrigSymbol().toAterm(tf);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return getOrigSymbol().toSDF3Aterm(tf, ctx_vals, ctx_vals.get(getContexts()));
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
        if(obj == null)
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

}
