package org.metaborg.sdf2table.deepconflicts;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.grammar.CharacterClass;
import org.metaborg.sdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public class ContextualSymbol extends Symbol {

    private static final long serialVersionUID = -2886358954796970390L;

    private final Symbol s;
    private final Set<Context> contexts;

    private long deepContextBitmap = 0L;

    public ContextualSymbol(Symbol s, Set<Context> contexts, long deepContextBitmap) {
        this.s = s;
        this.contexts = contexts;
        this.deepContextBitmap = deepContextBitmap;
        
    }

    public ContextualSymbol(Symbol s, Context context, long deepContextBitmap) {
        this.s = s;
        this.contexts = Sets.newHashSet(context);
        this.deepContextBitmap = deepContextBitmap;
    }

    public ContextualSymbol(Symbol s, Set<Context> contexts) {
        this.s = s;
        this.contexts = contexts;

        for (Context context : contexts) {
            if (context.getType() == ContextType.DEEP) {
                deepContextBitmap |= context.getContextBitmap();
            }
        }
    }

    public ContextualSymbol(Symbol s, Context context) {
        this.s = s;
        this.contexts = Sets.newHashSet(context);

        if (context.getType() == ContextType.DEEP) {
            deepContextBitmap |= context.getContextBitmap();
        }
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

    @Override public CharacterClass followRestriction() {
        return getOrigSymbol().followRestriction();
    }

    @Override public List<CharacterClass[]> followRestrictionLookahead() {
        return getOrigSymbol().followRestrictionLookahead();
    }

    public Set<Context> getContexts() {
        return contexts;
    }

    public long deepContexts() {
        return deepContextBitmap;
    }

    public Symbol getOrigSymbol() {
        return s;
    }

    public ContextualSymbol addContext(Context context) {
        Set<Context> new_contexts = Sets.newHashSet();
        new_contexts.addAll(this.getContexts());
        new_contexts.add(context);

        if (context.getType() == ContextType.DEEP) {
            return new ContextualSymbol(getOrigSymbol(), new_contexts, deepContextBitmap | context.getContextBitmap());
        }

        return new ContextualSymbol(getOrigSymbol(), new_contexts, deepContextBitmap);
    }

    public ContextualSymbol addContexts(Set<Context> contexts) {
        Set<Context> new_contexts = Sets.newHashSet();
        new_contexts.addAll(this.getContexts());
        new_contexts.addAll(contexts);

        long updatedDeepContextBitmap = deepContextBitmap;

        for (Context context : contexts) {
            if (context.getType() == ContextType.DEEP) {
                updatedDeepContextBitmap |= context.getContextBitmap();
            }
        }

        return new ContextualSymbol(getOrigSymbol(), new_contexts, updatedDeepContextBitmap);
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
