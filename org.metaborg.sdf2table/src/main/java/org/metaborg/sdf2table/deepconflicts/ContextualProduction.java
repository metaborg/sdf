package org.metaborg.sdf2table.deepconflicts;

import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import org.metaborg.sdf2table.grammar.*;
import org.metaborg.sdf2table.io.ParseTableGenerator;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ContextualProduction implements IProduction, Serializable {

    private static final long serialVersionUID = -8597347751774753273L;

    private final IProduction orig_prod;
    private final Symbol lhs;
    private final List<Symbol> rhs;
    private final int originalProductionLabel;

    public ContextualProduction(IProduction orig_prod, Symbol lhs, List<Symbol> rhs, int originalProductionLabel) {
        this.orig_prod = orig_prod;
        this.originalProductionLabel = originalProductionLabel;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public ContextualProduction(IProduction orig_prod, Set<Context> contexts, Set<Integer> args,
        int originalProductionLabel) {
        // initial production with conflicting argument
        lhs = orig_prod.leftHand();
        this.orig_prod = orig_prod;
        this.originalProductionLabel = originalProductionLabel;
        rhs = Lists.newArrayList();

        for(int i = 0; i < orig_prod.rightHand().size(); i++) {
            if(args.contains(i)) {
                rhs.add(new ContextualSymbol(orig_prod.rightHand().get(i), contexts));
            } else {
                rhs.add(orig_prod.rightHand().get(i));
            }
        }
    }

    public ContextualProduction(IProduction orig_prod, Set<Context> contexts,
        Queue<ContextualSymbol> contextual_symbols, Set<ContextualSymbol> processed_symbols,
        SetMultimap<IProduction, IAttribute> prod_attrs, int originalProductionLabel, ParseTable pt) {
        this.orig_prod = orig_prod;
        this.originalProductionLabel = originalProductionLabel;
        rhs = Lists.newArrayList(orig_prod.rightHand());
        lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);

        // FIXME pass context considering nullable symbols
        for(Context c : contexts) {
            if(c.getType().equals(ContextType.DEEP)) {
                if(c.isIndirect()) {
                    Symbol lefthandSymbolFromContext = pt.productionLabels().inverse().get(c.getContext()).leftHand();
                    for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition()
                            && (c.getPosition().equals(ContextPosition.RIGHTMOST)))
                            || (i == getOrigProduction().rightHand().size() - 1
                                && i == getOrigProduction().rightRecursivePosition()
                                && (c.getPosition().equals(ContextPosition.LEFTMOST)))) {
                            ContextualSymbol new_symbol;
                            if(rhs.get(i) instanceof ContextualSymbol) {
                                Symbol nonContextualSymbol = ((ContextualSymbol) rhs.get(i)).getOrigSymbol();
                                if(lefthandSymbolFromContext.equals(nonContextualSymbol)) {
                                    new_symbol = ((ContextualSymbol) rhs.get(i))
                                        .addContext(new Context(c.getContext(), c.getType(), c.getPosition(), false,
                                            pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()));
                                } else {
                                    new_symbol = ((ContextualSymbol) rhs.get(i)).addContext(c);
                                }
                            } else {
                                if(lefthandSymbolFromContext.equals(rhs.get(i))) {
                                    new_symbol = new ContextualSymbol(rhs.get(i),
                                        new Context(c.getContext(), c.getType(), c.getPosition(), false,
                                            pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()));
                                } else {
                                    new_symbol = new ContextualSymbol(rhs.get(i), c);
                                }
                            }
                            rhs.set(i, new_symbol);
                        }
                    }
                } else {
                    for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                        if((i == 0 && i == orig_prod.leftRecursivePosition()
                            && (c.getPosition().equals(ContextPosition.LEFTMOST)))
                            || (i == orig_prod.rightHand().size() - 1 && i == orig_prod.rightRecursivePosition()
                                && (c.getPosition().equals(ContextPosition.RIGHTMOST)))) {
                            ContextualSymbol new_symbol;
                            if(rhs.get(i) instanceof ContextualSymbol) {
                                new_symbol = ((ContextualSymbol) rhs.get(i)).addContext(c);
                            } else {
                                new_symbol = new ContextualSymbol(rhs.get(i), c);
                            }
                            rhs.set(i, new_symbol);
                        }
                    }
                }
            }
        }

        for(Symbol s : rhs) {
            if(s instanceof ContextualSymbol) {
                ContextualSymbol new_symbol = (ContextualSymbol) s;
                // creating a new contextual symbol
                if((contextual_symbols != null && processed_symbols != null) && !processed_symbols.contains(new_symbol)
                    && !contextual_symbols.contains(new_symbol)) {
                    contextual_symbols.add(new_symbol);
                }
            }
        }


    }

    @Override public Symbol leftHand() {
        return lhs;
    }

    @Override public List<Symbol> rightHand() {
        return rhs;
    }

    public ContextualProduction addContext(Context context, Set<Integer> conflicting_args) {
        Symbol new_lhs = lhs;
        List<Symbol> new_rhs = Lists.newArrayList();
        Set<Context> contexts = Sets.newHashSet();
        contexts.add(context);

        // FIXME pass context considering nullable symbols
        // add context to all possible conflicting symbols
        if(conflicting_args.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                new_lhs = ((ContextualSymbol) lhs).addContext(context);
            } else {
                new_lhs = new ContextualSymbol(getOrigProduction().leftHand(), contexts);
            }

            for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                if((i == 0 && i == getOrigProduction().leftRecursivePosition())
                    || (i == getOrigProduction().rightHand().size() - 1 && i == orig_prod.rightRecursivePosition())) {
                    new_rhs.add(((ContextualSymbol) rhs.get(i)).addContext(context));
                } else {
                    new_rhs.add(getOrigProduction().rightHand().get(i));
                }
            }
        } else { // add context to conflicting args
            for(int i = 0; i < rhs.size(); i++) {
                if(conflicting_args.contains(i)) {
                    if(rhs.get(i) instanceof ContextualSymbol) {
                        new_rhs.add(((ContextualSymbol) rhs.get(i)).addContext(context));
                    } else {
                        new_rhs.add(new ContextualSymbol(rhs.get(i), contexts));
                    }
                } else {
                    new_rhs.add(rhs.get(i));
                }
            }
        }

        return new ContextualProduction(getOrigProduction(), new_lhs, new_rhs, getOriginalProductionLabel());

    }

    public ContextualProduction addContexts(Set<Context> contexts, Set<Integer> conflicting_args) {
        Symbol new_lhs = lhs;
        List<Symbol> new_rhs = Lists.newArrayList();

        // FIXME pass context considering nullable symbols
        // add context to all possible conflicting symbols
        if(conflicting_args.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                new_lhs = ((ContextualSymbol) lhs).addContexts(contexts);
            } else {
                new_lhs = new ContextualSymbol(getOrigProduction().leftHand(), contexts);
            }

            for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                if((i == 0 && i == getOrigProduction().leftRecursivePosition())
                    || (i == getOrigProduction().rightHand().size() - 1 && i == orig_prod.rightRecursivePosition())) {
                    new_rhs.add(((ContextualSymbol) rhs.get(i)).addContexts(contexts));
                } else {
                    new_rhs.add(getOrigProduction().rightHand().get(i));
                }
            }
        } else { // add context to conflicting args
            for(int i = 0; i < rhs.size(); i++) {
                if(conflicting_args.contains(i)) {
                    if(rhs.get(i) instanceof ContextualSymbol) {
                        new_rhs.add(((ContextualSymbol) rhs.get(i)).addContexts(contexts));
                    } else {
                        new_rhs.add(new ContextualSymbol(rhs.get(i), contexts));
                    }
                } else {
                    new_rhs.add(rhs.get(i));
                }
            }
        }

        return new ContextualProduction(getOrigProduction(), new_lhs, new_rhs, getOriginalProductionLabel());

    }

    public ContextualProduction mergeContext(Set<Context> context, Queue<ContextualSymbol> contextual_symbols,
        Set<ContextualSymbol> processed_symbols, SetMultimap<IProduction, IAttribute> prod_attrs, ParseTable pt) {

        List<Symbol> new_rhs = Lists.newArrayList(rhs);
        Set<Context> contexts = Sets.newHashSet();
        contexts.addAll(context);

        // FIXME pass context considering nullable symbols
        Symbol new_lhs = new ContextualSymbol(getOrigProduction().leftHand(), contexts);

        for(Context c : contexts) {
            if(c.getType().equals(ContextType.DEEP)) {
                // contexts for indirect recursion need to be propagated in the opposite direction
                // till they "reach" the recursive symbol
                if(c.isIndirect()) {
                    Symbol lefthandSymbolFromContext = pt.productionLabels().inverse().get(c.getContext()).leftHand();
                    for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition()
                            && (c.getPosition().equals(ContextPosition.RIGHTMOST)))
                            || (i == getOrigProduction().rightHand().size() - 1
                                && i == getOrigProduction().rightRecursivePosition()
                                && (c.getPosition().equals(ContextPosition.LEFTMOST)))) {
                            ContextualSymbol new_symbol;
                            if(new_rhs.get(i) instanceof ContextualSymbol) {
                                Symbol nonContextualSymbol = ((ContextualSymbol) new_rhs.get(i)).getOrigSymbol();
                                if(lefthandSymbolFromContext.equals(nonContextualSymbol)) {
                                    new_symbol = ((ContextualSymbol) new_rhs.get(i))
                                        .addContext(new Context(c.getContext(), c.getType(), c.getPosition(), false,
                                            pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()));
                                } else {
                                    new_symbol = ((ContextualSymbol) new_rhs.get(i)).addContext(c);
                                }
                            } else {
                                if(lefthandSymbolFromContext.equals(new_rhs.get(i))) {
                                    new_symbol = new ContextualSymbol(new_rhs.get(i),
                                        new Context(c.getContext(), c.getType(), c.getPosition(), false,
                                            pt.getLeftmostContextsMapping(), pt.getRightmostContextsMapping()));
                                } else {
                                    new_symbol = new ContextualSymbol(new_rhs.get(i), c);
                                }
                            }
                            new_rhs.set(i, new_symbol);
                        }
                    }
                } else {
                    for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                        if((i == 0 && i == getOrigProduction().leftRecursivePosition()
                            && (c.getPosition().equals(ContextPosition.LEFTMOST)))
                            || (i == getOrigProduction().rightHand().size() - 1
                                && i == getOrigProduction().rightRecursivePosition()
                                && (c.getPosition().equals(ContextPosition.RIGHTMOST)))) {
                            ContextualSymbol new_symbol;
                            if(new_rhs.get(i) instanceof ContextualSymbol) {
                                new_symbol = ((ContextualSymbol) new_rhs.get(i)).addContext(c);
                            } else {
                                new_symbol = new ContextualSymbol(new_rhs.get(i), c);
                            }
                            new_rhs.set(i, new_symbol);
                        }
                    }
                }
            }
        }

        for(Symbol s : new_rhs) {
            if(s instanceof ContextualSymbol) {
                ContextualSymbol new_symbol = (ContextualSymbol) s;
                // creating a new contextual symbol
                if((contextual_symbols != null && processed_symbols != null) && !processed_symbols.contains(new_symbol)
                    && !contextual_symbols.contains(new_symbol)) {
                    contextual_symbols.add(new_symbol);
                }
            }
        }


        return new ContextualProduction(getOrigProduction(), new_lhs, new_rhs, getOriginalProductionLabel());
    }

    public IProduction getOrigProduction() {
        return orig_prod;
    }

    public int getOriginalProductionLabel() {
        return originalProductionLabel;
    }

    @Override public String toString() {
        String prod = "";
        prod += lhs.name();

        prod += " -> ";

        for(Symbol s : rhs)
            prod += s.name() + " ";

        return prod;
    }



    @Override public int leftRecursivePosition() {
        return getOrigProduction().leftRecursivePosition();
    }

    @Override public int rightRecursivePosition() {
        return getOrigProduction().rightRecursivePosition();
    }

    @Override public void calculateRecursion(NormGrammar grammar) {
        // This should not be called in a Contextual production
        getOrigProduction().calculateRecursion(grammar);
    }

    @Override public IStrategoTerm toAterm(SetMultimap<IProduction, IAttribute> prod_attrs) {
        return getOrigProduction().toAterm(prod_attrs);
    }

    @Override public IStrategoTerm toSDF3Aterm(SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        ITermFactory tf = ParseTableGenerator.getTermfactory();
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(Symbol s : rhs) {
            rhs_terms.add(s.toSDF3Aterm(tf, ctx_vals, ctx_val));
        }

        for(IAttribute a : prod_attrs.get(getOrigProduction())) {
            attrs_terms.add(a.toSDF3Aterm(tf));
        }

        if(attrs_terms.isEmpty()) {
            return tf.makeAppl(tf.makeConstructor("SdfProduction", 3), lhs.toSDF3Aterm(tf, ctx_vals, ctx_val),
                tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
                tf.makeAppl(tf.makeConstructor("NoAttrs", 0)));
        } else {
            // with constructor
        }

        return tf.makeAppl(tf.makeConstructor("SdfProduction", 3), lhs.toSDF3Aterm(tf, ctx_vals, ctx_val),
            tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
            tf.makeAppl(tf.makeConstructor("Attrs", 1), tf.makeList(attrs_terms)));

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

}
