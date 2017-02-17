package org.metaborg.newsdf2table.parsetable;

import java.util.List;
import java.util.Queue;
import java.util.Set;

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

    public ContextualProduction(IProduction orig_prod, Set<IProduction> contexts, Set<Integer> args,
        boolean isBracket) {
        this.orig_prod = orig_prod;
        rhs = Lists.newArrayList();

        if(args.contains(-1)) {
            // derived production passing the context to possible conflicting arguments (left and right recursive)
            lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);
            for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                if(i == orig_prod.leftRecursivePosition() || i == orig_prod.rightRecursivePosition()) {
                    rhs.add(new ContextualSymbol(orig_prod.rightHand().get(i), contexts));
                } else {
                    rhs.add(orig_prod.rightHand().get(i));
                }
            }

        } else {
            // initial production with conflicting argument
            lhs = orig_prod.leftHand();
            for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                if(args.contains(i)) {
                    rhs.add(new ContextualSymbol(orig_prod.rightHand().get(i), contexts));
                } else {
                    rhs.add(orig_prod.rightHand().get(i));
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

    @Override public boolean isBracket(ParseTable pt) {
        return orig_prod.isBracket(pt);
    }

    @Override public Set<Integer> deepConflictingArgs(ParseTable pt, IProduction p) {
        return orig_prod.deepConflictingArgs(pt, p);
    }

    public void addContext(IProduction context, Set<Integer> conflicting_args) {
        Symbol new_lhs = null;
        List<Symbol> new_rhs = Lists.newArrayList();
        Set<IProduction> contexts = Sets.newHashSet();
        contexts.add(context);

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
        } else {
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

    public ContextualProduction mergeContext(Set<IProduction> context, Queue<ContextualSymbol> contextual_symbols, Set<ContextualSymbol> processed_symbols) {
        Symbol new_lhs = null;
        List<Symbol> new_rhs = Lists.newArrayList();
        Set<IProduction> contexts = Sets.newHashSet();
        contexts.addAll(context);

        new_lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);

        for(int i = 0; i < orig_prod.rightHand().size(); i++) {
            if(i == orig_prod.leftRecursivePosition() || i == orig_prod.rightRecursivePosition()) {
                if(rhs.get(i) instanceof ContextualSymbol) {
                    ContextualSymbol mergedSymbol = ((ContextualSymbol) rhs.get(i)).addContexts(context);
                    if(!processed_symbols.contains(mergedSymbol) && !contextual_symbols.contains(mergedSymbol)) {
                        contextual_symbols.add(mergedSymbol);
                    }
                    new_rhs.add(mergedSymbol);
                } else {
                    new_rhs.add(new ContextualSymbol(orig_prod.rightHand().get(i), contexts));
                }
            } else {
                new_rhs.add(rhs.get(i));
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

    @Override public void calculateRecursivity(NormGrammar grammar) {
        // This should not be called in a Contextual production
        orig_prod.calculateRecursivity(grammar);
    }
}
