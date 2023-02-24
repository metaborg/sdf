package org.metaborg.sdf2table.deepconflicts;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.symbols.ISymbol;
import org.metaborg.parsetable.symbols.SortCardinality;
import org.metaborg.parsetable.symbols.SyntaxContext;
import org.metaborg.sdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Sets;

public final class ContextualSymbol extends Symbol {

    private static final long serialVersionUID = -2886358954796970390L;

    private final Symbol s;
    private final Set<Context> contexts;
    private final ContextualFactory cf;

    private long deepContextBitmap = 0L;

    public ContextualSymbol(Symbol s, Set<Context> contexts, long deepContextBitmap, ContextualFactory cf) {
        this.s = s;
        this.contexts = contexts;
        this.deepContextBitmap = deepContextBitmap;
        this.cf = cf;
    }

    public ContextualSymbol(Symbol s, Set<Context> contexts, ContextualFactory cf) {
        this.s = s;
        this.contexts = contexts;
        this.cf = cf;

        for(Context context : contexts) {
            if(context.getType() == ContextType.DEEP|| context.getType() == ContextType.DANGLING) {
                deepContextBitmap |= context.getContextBitmap();
            }
        }
    }

    public ContextualSymbol(Symbol s, Context context, ContextualFactory cf) {
        this.s = s;
        this.contexts = Sets.newHashSet(context);
        this.cf = cf;

        if(context.getType() == ContextType.DEEP || context.getType() == ContextType.DANGLING) {
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

    @Override public ICharacterClass followRestriction() {
        return getOrigSymbol().followRestriction();
    }

    @Override public List<ICharacterClass[]> followRestrictionLookahead() {
        return getOrigSymbol().followRestrictionLookahead();
    }

    public void setDeepContextBitmap(long deepContextBitmap) {
        this.deepContextBitmap = deepContextBitmap;
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
        Set<Context> newContexts = new HashSet<Context>();
        newContexts.addAll(this.getContexts());
        newContexts.add(context);

        if(context.getType() == ContextType.DEEP || context.getType() == ContextType.DANGLING) {
            return cf.createContextualSymbol(getOrigSymbol(), newContexts,
                deepContextBitmap | context.getContextBitmap(), cf);
        }

        return cf.createContextualSymbol(getOrigSymbol(), newContexts, deepContextBitmap, cf);
    }

    public ContextualSymbol addContexts(Set<Context> contexts) {
        Set<Context> newContexts = new HashSet<Context>();
        newContexts.addAll(this.getContexts());
        newContexts.addAll(contexts);

        long updatedDeepContextBitmap = deepContextBitmap;

        for(Context context : contexts) {
            if(context.getType() == ContextType.DEEP || context.getType() == ContextType.DANGLING) {
                updatedDeepContextBitmap |= context.getContextBitmap();
            }
        }

        return cf.createContextualSymbol(getOrigSymbol(), newContexts, updatedDeepContextBitmap, cf);
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

    @Override public ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        return s.toParseTableSymbol(syntaxContext, cardinality);
    }

    public boolean containsProduction(int label) {
        for (Context c : this.contexts) {
            if (c.getContext() == label) {
                return true;
            }
        }
        return false;
    }

}
