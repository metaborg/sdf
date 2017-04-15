package org.metaborg.newsdf2table.parsetable;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.metaborg.newsdf2table.grammar.ConstructorAttribute;
import org.metaborg.newsdf2table.grammar.IAttribute;
import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.NormGrammar;
import org.metaborg.newsdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class ContextualProduction implements IProduction {

    private final IProduction orig_prod;
    private final Symbol lhs;
    private final List<Symbol> rhs;

    public ContextualProduction(IProduction orig_prod, Symbol lhs, List<Symbol> rhs) {
        this.orig_prod = orig_prod;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public ContextualProduction(IProduction orig_prod, Set<Context> contexts, Set<Integer> args) {
        // initial production with conflicting argument
        lhs = orig_prod.leftHand();
        this.orig_prod = orig_prod;
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
        SetMultimap<IProduction, IAttribute> prod_attrs) {
        this.orig_prod = orig_prod;
        rhs = Lists.newArrayList(orig_prod.rightHand());
        lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);

        for(Context c : contexts) {
            if(c.type.equals(ContextType.DEEP)) {
                for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                    if(i == orig_prod.leftRecursivePosition() || i == orig_prod.rightRecursivePosition()) {
                        ContextualSymbol new_symbol;
                        if(rhs.get(i) instanceof ContextualSymbol) {
                            new_symbol = ((ContextualSymbol) rhs.get(i)).addContext(c);
                        } else {
                            new_symbol = new ContextualSymbol(rhs.get(i), c);
                        }
                        rhs.set(i, new_symbol);
                    }
                }
            } else if(c.type.equals(ContextType.SHALLOW)) {
                if(c.context.leftHand().equals(orig_prod.leftHand())) { // stop passing the shallow context
                    continue;
                }
                // if production has a constructor, do not pass the shallow context
                boolean hasConstructor = false;
                for(IAttribute attr : prod_attrs.get(orig_prod)) {
                    if(attr instanceof ConstructorAttribute) {
                        hasConstructor = true;
                        break;
                    }
                }
                if(hasConstructor)
                    continue;
                for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                    // shallow context should be passed to correct position
                    if((i == orig_prod.leftRecursivePosition() && c.position.equals(ContextPosition.LEFTMOST))
                        || (i == orig_prod.rightRecursivePosition() && c.position.equals(ContextPosition.RIGHTMOST))) {
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

    public IProduction getOrigProduction() {
        return getOrig_prod();
    }

    @Override public Symbol leftHand() {
        return lhs;
    }

    @Override public List<Symbol> rightHand() {
        return rhs;
    }

    @Override public void calculateDependencies(NormGrammar g) {
        getOrigProduction().calculateDependencies(g);

    }

    @Override public TableSet firstSet() {
        return getOrigProduction().firstSet();
    }

    @Override public TableSet followSet() {
        return getOrigProduction().followSet();
    }

    public ContextualProduction addContext(Context context, Set<Integer> conflicting_args) {
        Symbol new_lhs = lhs;
        List<Symbol> new_rhs = Lists.newArrayList();
        Set<Context> contexts = Sets.newHashSet();
        contexts.add(context);

        // add context to all possible conflicting symbols
        if(conflicting_args.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                new_lhs = ((ContextualSymbol) lhs).addContext(context);
            } else {
                new_lhs = new ContextualSymbol(getOrigProduction().leftHand(), contexts);
            }

            for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                if(i == getOrigProduction().leftRecursivePosition()
                    || i == getOrigProduction().rightRecursivePosition()) {
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

        return new ContextualProduction(getOrigProduction(), new_lhs, new_rhs);

    }

    public ContextualProduction addContexts(Set<Context> contexts, Set<Integer> conflicting_args) {
        Symbol new_lhs = lhs;
        List<Symbol> new_rhs = Lists.newArrayList();

        // add context to all possible conflicting symbols
        if(conflicting_args.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                new_lhs = ((ContextualSymbol) lhs).addContexts(contexts);
            } else {
                new_lhs = new ContextualSymbol(getOrigProduction().leftHand(), contexts);
            }

            for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                if(i == getOrigProduction().leftRecursivePosition()
                    || i == getOrigProduction().rightRecursivePosition()) {
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

        return new ContextualProduction(getOrigProduction(), new_lhs, new_rhs);

    }

    public ContextualProduction mergeContext(Set<Context> context, Queue<ContextualSymbol> contextual_symbols,
        Set<ContextualSymbol> processed_symbols, SetMultimap<IProduction, IAttribute> prod_attrs) {

        List<Symbol> new_rhs = Lists.newArrayList(rhs);
        Set<Context> contexts = Sets.newHashSet();
        contexts.addAll(context);

        Symbol new_lhs = new ContextualSymbol(getOrigProduction().leftHand(), contexts);

        for(Context c : contexts) {
            if(c.type.equals(ContextType.DEEP)) {
                for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                    if(i == getOrigProduction().leftRecursivePosition()
                        || i == getOrigProduction().rightRecursivePosition()) {
                        ContextualSymbol new_symbol;
                        if(new_rhs.get(i) instanceof ContextualSymbol) {
                            new_symbol = ((ContextualSymbol) new_rhs.get(i)).addContext(c);
                        } else {
                            new_symbol = new ContextualSymbol(new_rhs.get(i), c);
                        }
                        new_rhs.set(i, new_symbol);
                    }
                }
            } else if(c.type.equals(ContextType.SHALLOW)) {
                if(c.context.leftHand().equals(getOrigProduction().leftHand())) { // stop passing the shallow context
                    continue;
                }
                // if production has a constructor, do not pass the shallow context
                boolean hasConstructor = false;
                for(IAttribute attr : prod_attrs.get(getOrigProduction())) {
                    if(attr instanceof ConstructorAttribute) {
                        hasConstructor = true;
                        break;
                    }
                }
                if(hasConstructor)
                    continue;
                for(int i = 0; i < getOrigProduction().rightHand().size(); i++) {
                    // shallow context should be passed to correct position
                    if((i == getOrigProduction().leftRecursivePosition() && c.position.equals(ContextPosition.LEFTMOST))
                        || (i == getOrigProduction().rightRecursivePosition()
                            && c.position.equals(ContextPosition.RIGHTMOST))) {
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


        return new ContextualProduction(getOrigProduction(), new_lhs, new_rhs);
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

    @Override public IStrategoTerm toAterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs) {
        return getOrigProduction().toAterm(tf, prod_attrs);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
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
        result = prime * result + ((getOrig_prod() == null) ? 0 : getOrig_prod().hashCode());
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
        if(getOrig_prod() == null) {
            if(other.getOrig_prod() != null)
                return false;
        } else if(!getOrig_prod().equals(other.getOrig_prod()))
            return false;
        if(rhs == null) {
            if(other.rhs != null)
                return false;
        } else if(!rhs.equals(other.rhs))
            return false;
        return true;
    }

    public IProduction getOrig_prod() {
        return orig_prod;
    }
}
