package org.metaborg.sdf2table.deepconflicts;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.io.ParseTableIO;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public final class ContextualProduction implements IProduction, Serializable {

    private static final long serialVersionUID = -8597347751774753273L;

    private final ContextualFactory cf;
    private final Production originalProduction;
    private final int originalProductionLabel;
    private final ISymbol lhs;
    private final List<ISymbol> rhs;

    // create new contextual production given left hand side and right hand side
    public ContextualProduction(Production orig_prod, ISymbol lhs, List<ISymbol> rhs, int originalProductionLabel,
        ContextualFactory cf) {
        this.originalProduction = orig_prod;
        this.originalProductionLabel = originalProductionLabel;
        this.lhs = lhs;
        this.rhs = rhs;
        this.cf = cf;
    }

    @Override public ISymbol leftHand() {
        return lhs;
    }

    @Override public List<ISymbol> rightHand() {
        return rhs;
    }

    public ContextualProduction addContext(Context context, Set<Integer> conflictingArgs) {
        ISymbol newLhs = lhs;
        List<ISymbol> newRhs = Lists.newArrayList();
        Set<Context> contexts = Sets.newHashSet();
        contexts.add(context);

        // FIXME pass contextual tokens considering nullable symbols
        // add single contextual token to all possible conflicting symbols
        if(conflictingArgs.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                newLhs = ((ContextualSymbol) lhs).addContext(context);
            } else {
                newLhs = cf.createContextualSymbol(getOrigProduction().getLhs(), contexts, cf);
            }

            for(int i = 0; i < getOrigProduction().getRhs().size(); i++) {
                if((i == 0 && i == getOrigProduction().leftRecursivePosition())
                    || (i == getOrigProduction().getRhs().size() - 1
                        && i == originalProduction.rightRecursivePosition())) {
                    newRhs.add(((ContextualSymbol) rhs.get(i)).addContext(context));
                } else {
                    newRhs.add(getOrigProduction().getRhs().get(i));
                }
            }
        } else { // add single contextual token only to conflicting args
            for(int i = 0; i < rhs.size(); i++) {
                if(conflictingArgs.contains(i)) {
                    if(rhs.get(i) instanceof ContextualSymbol) {
                        newRhs.add(((ContextualSymbol) rhs.get(i)).addContext(context));
                    } else {
                        newRhs.add(cf.createContextualSymbol((Symbol) rhs.get(i), contexts, cf));
                    }
                } else {
                    newRhs.add(rhs.get(i));
                }
            }
        }

        return cf.createContextualProduction(getOrigProduction(), newLhs, newRhs, getOriginalProductionLabel(), cf);

    }

    public ContextualProduction addContexts(Set<Context> contexts, Set<Integer> conflictingArgs) {
        ISymbol newLhs = lhs;
        List<ISymbol> newRhs = Lists.newArrayList();

        // FIXME pass context considering nullable symbols
        // add context to all possible conflicting symbols
        if(conflictingArgs.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                newLhs = ((ContextualSymbol) lhs).addContexts(contexts);
            } else {
                newLhs = cf.createContextualSymbol(getOrigProduction().getLhs(), contexts, cf);
            }

            for(int i = 0; i < getOrigProduction().getRhs().size(); i++) {
                if((i == 0 && i == getOrigProduction().leftRecursivePosition())
                    || (i == getOrigProduction().getRhs().size() - 1
                        && i == originalProduction.rightRecursivePosition())) {
                    newRhs.add(((ContextualSymbol) rhs.get(i)).addContexts(contexts));
                } else {
                    newRhs.add(getOrigProduction().getRhs().get(i));
                }
            }
        } else { // add context to conflicting args
            for(int i = 0; i < rhs.size(); i++) {
                if(conflictingArgs.contains(i)) {
                    if(rhs.get(i) instanceof ContextualSymbol) {
                        newRhs.add(((ContextualSymbol) rhs.get(i)).addContexts(contexts));
                    } else {
                        newRhs.add(cf.createContextualSymbol((Symbol) rhs.get(i), contexts, cf));
                    }
                } else {
                    newRhs.add(rhs.get(i));
                }
            }
        }

        return cf.createContextualProduction(getOrigProduction(), newLhs, newRhs, getOriginalProductionLabel(), cf);

    }

    public ContextualProduction mergeContext(Set<Context> context, Queue<ContextualSymbol> contextualSymbols,
        Set<ContextualSymbol> processedSymbols, ParseTable pt) {

        List<ISymbol> newRhs = Lists.newArrayList(rhs);
        Set<Context> contexts = Sets.newHashSet();
        contexts.addAll(context);

        // FIXME pass contextual token considering nullable symbols
        ISymbol new_lhs = cf.createContextualSymbol(getOrigProduction().getLhs(), contexts, cf);

        for(Context c : contexts) {
            if(c.getType().equals(ContextType.DEEP)) {
                // contextual tokens for indirect recursion need to be propagated
                // in the opposite direction (i.e., if conflict occurs at the rightmost symbol, they need to be
                // propagated to the leftmost symbol) until they reach the recursive symbol
                if(c.isIndirect()) {
                    ISymbol lefthandSymbolFromContext = pt.productionLabels().inverse().get(c.getContext()).leftHand();
                    for(int i = 0; i < getOrigProduction().getRhs().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition()
                            && (c.getPosition().equals(ContextPosition.RIGHTMOST)))
                            || (i == getOrigProduction().getRhs().size() - 1
                                && i == getOrigProduction().rightRecursivePosition()
                                && (c.getPosition().equals(ContextPosition.LEFTMOST)))) {
                            ContextualSymbol new_symbol;
                            if(newRhs.get(i) instanceof ContextualSymbol) {
                                ISymbol nonContextualSymbol = ((ContextualSymbol) newRhs.get(i)).getOrigSymbol();
                                if(lefthandSymbolFromContext.equals(nonContextualSymbol)) {
                                    new_symbol = ((ContextualSymbol) newRhs.get(i))
                                        .addContext(cf.createContext(c.getContext(), c.getType(), c.getPosition(),
                                            false, pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()));
                                } else {
                                    new_symbol = ((ContextualSymbol) newRhs.get(i)).addContext(c);
                                }
                            } else {
                                if(lefthandSymbolFromContext.equals(newRhs.get(i))) {
                                    new_symbol = cf.createContextualSymbol((Symbol) newRhs.get(i),
                                        cf.createContext(c.getContext(), c.getType(), c.getPosition(), false,
                                            pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()),
                                        cf);
                                } else {
                                    new_symbol = cf.createContextualSymbol((Symbol) newRhs.get(i), c, cf);
                                }
                            }
                            newRhs.set(i, new_symbol);
                        }
                    }
                } else {
                    for(int i = 0; i < getOrigProduction().getRhs().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition()
                            && (c.getPosition().equals(ContextPosition.LEFTMOST)))
                            || (i == getOrigProduction().getRhs().size() - 1
                                && i == getOrigProduction().rightRecursivePosition()
                                && (c.getPosition().equals(ContextPosition.RIGHTMOST)))) {
                            ContextualSymbol new_symbol;
                            if(newRhs.get(i) instanceof ContextualSymbol) {
                                new_symbol = ((ContextualSymbol) newRhs.get(i)).addContext(c);
                            } else {
                                new_symbol = cf.createContextualSymbol((Symbol) newRhs.get(i), c, cf);
                            }
                            newRhs.set(i, new_symbol);
                        }
                    }
                }
            } else if(c.getType().equals(ContextType.DANGLING)) {
                if(c.isIndirect()) {
                    ISymbol lefthandSymbolFromContext = pt.productionLabels().inverse().get(c.getContext()).leftHand();
                    for(int i = 0; i < getOrigProduction().getRhs().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition())
                            || (i == getOrigProduction().getRhs().size() - 1
                                && i == getOrigProduction().rightRecursivePosition())) {
                            ContextualSymbol new_symbol;
                            if(newRhs.get(i) instanceof ContextualSymbol) {
                                ISymbol nonContextualSymbol = ((ContextualSymbol) newRhs.get(i)).getOrigSymbol();
                                if(lefthandSymbolFromContext.equals(nonContextualSymbol)) {
                                    new_symbol = ((ContextualSymbol) newRhs.get(i))
                                        .addContext(cf.createContext(c.getContext(), c.getType(), c.getPosition(),
                                            false, pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()));
                                } else {
                                    new_symbol = ((ContextualSymbol) newRhs.get(i)).addContext(c);
                                }
                            } else {
                                if(lefthandSymbolFromContext.equals(newRhs.get(i))) {
                                    new_symbol = cf.createContextualSymbol((Symbol) newRhs.get(i),
                                        cf.createContext(c.getContext(), c.getType(), c.getPosition(), false,
                                            pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()),
                                        cf);
                                } else {
                                    new_symbol = cf.createContextualSymbol((Symbol) newRhs.get(i), c, cf);
                                }
                            }
                            newRhs.set(i, new_symbol);
                        }
                    }
                } else {
                    for(int i = 0; i < getOrigProduction().getRhs().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition())
                            || (i == getOrigProduction().getRhs().size() - 1
                                && i == getOrigProduction().rightRecursivePosition())) {
                            ContextualSymbol new_symbol;
                            if(newRhs.get(i) instanceof ContextualSymbol) {
                                new_symbol = ((ContextualSymbol) newRhs.get(i)).addContext(c);
                            } else {
                                new_symbol = cf.createContextualSymbol((Symbol) newRhs.get(i), c, cf);
                            }
                            newRhs.set(i, new_symbol);
                        }
                    }
                }
            }
        }

        for(ISymbol s : newRhs) {
            if(s instanceof ContextualSymbol) {
                ContextualSymbol new_symbol = (ContextualSymbol) s;
                // creating a new contextual symbol
                if((contextualSymbols != null && processedSymbols != null) && !processedSymbols.contains(new_symbol)
                    && !contextualSymbols.contains(new_symbol)) {
                    contextualSymbols.add(new_symbol);
                }
            }
        }


        return cf.createContextualProduction(getOrigProduction(), new_lhs, newRhs, getOriginalProductionLabel(), cf);
    }

    public Production getOrigProduction() {
        return originalProduction;
    }

    public int getOriginalProductionLabel() {
        return originalProductionLabel;
    }

    @Override public String toString() {
        String prod = "";
        prod += lhs.name();

        prod += " -> ";

        for(ISymbol s : rhs)
            prod += s.name() + " ";

        return prod;
    }


    public IStrategoTerm toAterm(SetMultimap<IProduction, IAttribute> prod_attrs) {
        return getOrigProduction().toAterm(prod_attrs);
    }

    public IStrategoTerm toSDF3Aterm(SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        ITermFactory tf = ParseTableIO.getTermfactory();
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(ISymbol s : rhs) {
            if(s instanceof Symbol) {
                rhs_terms.add(((Symbol) s).toSDF3Aterm(tf, ctx_vals, ctx_val));
            } else if(s instanceof ContextualSymbol) {
                rhs_terms.add(((ContextualSymbol) s).toSDF3Aterm(tf, ctx_vals, ctx_val));

            }
        }

        for(IAttribute a : prod_attrs.get(getOrigProduction())) {
            attrs_terms.add(a.toSDF3Aterm(tf));
        }

        if(lhs instanceof Symbol) {
            if(attrs_terms.isEmpty()) {
                return tf.makeAppl(tf.makeConstructor("SdfProduction", 3),
                    ((Symbol) lhs).toSDF3Aterm(tf, ctx_vals, ctx_val),
                    tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
                    tf.makeAppl(tf.makeConstructor("NoAttrs", 0)));
            } else {
                // with constructor
            }

            return tf.makeAppl(tf.makeConstructor("SdfProduction", 3),
                ((Symbol) lhs).toSDF3Aterm(tf, ctx_vals, ctx_val),
                tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
                tf.makeAppl(tf.makeConstructor("Attrs", 1), tf.makeList(attrs_terms)));
        } else if(lhs instanceof ContextualSymbol) {
            if(attrs_terms.isEmpty()) {
                return tf.makeAppl(tf.makeConstructor("SdfProduction", 3),
                    ((ContextualSymbol) lhs).toSDF3Aterm(tf, ctx_vals, ctx_val),
                    tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
                    tf.makeAppl(tf.makeConstructor("NoAttrs", 0)));
            } else {
                // with constructor
            }

            return tf.makeAppl(tf.makeConstructor("SdfProduction", 3),
                ((ContextualSymbol) lhs).toSDF3Aterm(tf, ctx_vals, ctx_val),
                tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
                tf.makeAppl(tf.makeConstructor("Attrs", 1), tf.makeList(attrs_terms)));
        }

        return null;

    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
        result = prime * result + ((getOrigProduction() == null) ? 0 : getOrigProduction().hashCode());
        result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        ContextualProduction other = (ContextualProduction) obj;
        if(lhs == null) {
            if(other.lhs != null)
                return false;
        } else if(!lhs.equals(other.lhs))
            return false;
        if(getOrigProduction() == null) {
            if(other.getOrigProduction() != null)
                return false;
        } else if(!getOrigProduction().equals(other.getOrigProduction()))
            return false;
        if(rhs == null) {
            if(other.rhs != null)
                return false;
        } else if(!rhs.equals(other.rhs))
            return false;
        return true;
    }

    @Override public int arity() {
        return originalProduction.arity();
    }

}
