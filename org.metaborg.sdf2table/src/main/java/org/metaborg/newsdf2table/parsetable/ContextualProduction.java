package org.metaborg.newsdf2table.parsetable;

import java.util.List;
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

    IProduction orig_prod;
    Symbol lhs;
    List<Symbol> rhs;

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
                if(hasConstructor) continue;
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

    @Override public Symbol leftHand() {
        return lhs;
    }

    @Override public List<Symbol> rightHand() {
        return rhs;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs) {
        return orig_prod.toAterm(tf, prod_attrs);
    }

    @Override public void calculateDependencies(NormGrammar g) {
        orig_prod.calculateDependencies(g);

    }

    @Override public TableSet firstSet() {
        return orig_prod.firstSet();
    }

    @Override public TableSet followSet() {
        return orig_prod.followSet();
    }

    public void addContext(Context context, Set<Integer> conflicting_args) {
        Symbol new_lhs = null;
        List<Symbol> new_rhs = Lists.newArrayList();
        Set<Context> contexts = Sets.newHashSet();
        contexts.add(context);

        // add context to all possible conflicting symbols
        if(conflicting_args.contains(-1)) {
            if(lhs instanceof ContextualSymbol) {
                new_lhs = ((ContextualSymbol) lhs).addContext(context);
            } else {
                new_lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);
            }

            for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                if(i == orig_prod.leftRecursivePosition() || i == orig_prod.rightRecursivePosition()) {
                    new_rhs.add(((ContextualSymbol) rhs.get(i)).addContext(context));
                } else {
                    new_rhs.add(orig_prod.rightHand().get(i));
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

        if(new_lhs != null) {
            lhs = new_lhs;
        }
        rhs = new_rhs;

    }

    public ContextualProduction mergeContext(Set<Context> context, Queue<ContextualSymbol> contextual_symbols,
        Set<ContextualSymbol> processed_symbols, SetMultimap<IProduction, IAttribute> prod_attrs) {

        List<Symbol> new_rhs = Lists.newArrayList(rhs);
        Set<Context> contexts = Sets.newHashSet();
        contexts.addAll(context);

        Symbol new_lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);

        for(Context c : contexts) {
            if(c.type.equals(ContextType.DEEP)) {
                for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                    if(i == orig_prod.leftRecursivePosition() || i == orig_prod.rightRecursivePosition()) {
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
                if(hasConstructor) continue;
                for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                    // shallow context should be passed to correct position
                    if((i == orig_prod.leftRecursivePosition() && c.position.equals(ContextPosition.LEFTMOST))
                        || (i == orig_prod.rightRecursivePosition() && c.position.equals(ContextPosition.RIGHTMOST))) {
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


        return new ContextualProduction(orig_prod, new_lhs, new_rhs);
    }

    @Override public String toString() {
        String prod = "";
        prod += lhs.name();

        prod += " -> ";

        for(Symbol s : rhs)
            prod += s.name() + " ";

        return prod;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
        result = prime * result + ((orig_prod == null) ? 0 : orig_prod.hashCode());
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
        if(orig_prod == null) {
            if(other.orig_prod != null)
                return false;
        } else if(!orig_prod.equals(other.orig_prod))
            return false;
        if(rhs == null) {
            if(other.rhs != null)
                return false;
        } else if(!rhs.equals(other.rhs))
            return false;
        return true;
    }

    @Override public int leftRecursivePosition() {
        return orig_prod.leftRecursivePosition();
    }

    @Override public int rightRecursivePosition() {
        return orig_prod.rightRecursivePosition();
    }

    @Override public void calculateRecursion(NormGrammar grammar) {
        // This should not be called in a Contextual production
        orig_prod.calculateRecursion(grammar);
    }
}
