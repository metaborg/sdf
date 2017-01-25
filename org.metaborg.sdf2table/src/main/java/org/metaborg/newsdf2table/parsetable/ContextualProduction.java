package org.metaborg.newsdf2table.parsetable;

import java.util.List;
import java.util.Set;

import org.metaborg.newsdf2table.grammar.IAttribute;
import org.metaborg.newsdf2table.grammar.IPriority;
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

    public ContextualProduction(IProduction orig_prod, Set<IProduction> contexts, Set<Integer> args, boolean isBracket) {
        this.orig_prod = orig_prod;
        rhs = Lists.newArrayList();
        
        if(args.contains(-1)) {
            lhs = new ContextualSymbol(orig_prod.leftHand(), contexts);
            for(int i = 0; i < orig_prod.rightHand().size(); i++) {
                if(orig_prod.rightHand().get(i).equals(orig_prod.leftHand()) && !isBracket) {
                    rhs.add(new ContextualSymbol(orig_prod.rightHand().get(i), contexts));
                } else {
                    rhs.add(orig_prod.rightHand().get(i));
                }                
            }

        } else {
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

    @Override public boolean isRightRecursive() {
        return orig_prod.isRightRecursive();
    }

    @Override public boolean isLeftRecursive() {
        return orig_prod.isLeftRecursive();
    }

    @Override public boolean isLeftAssociative(SetMultimap<IPriority, Integer> priorities,
        Set<Integer> leftRecursivePositions) {
        return orig_prod.isLeftAssociative(priorities, leftRecursivePositions);
    }

    @Override public boolean isRightAssociative(SetMultimap<IPriority, Integer> priorities,
        Set<Integer> rightRecursivePositions) {
        return orig_prod.isRightAssociative(priorities, rightRecursivePositions);
    }

    @Override public Set<Integer> leftRecursivePositions() {
        return orig_prod.leftRecursivePositions();
    }

    @Override public Set<Integer> rightRecursivePositions() {
        return orig_prod.rightRecursivePositions();
    }

    @Override public void setCurrentDeepPriorityElements(boolean value) {
        orig_prod.setCurrentDeepPriorityElements(value);
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

    @Override public Set<Integer> isDeepPriorityConflict(ParseTable pt, IProduction p) {
        return orig_prod.isDeepPriorityConflict(pt, p);
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

            for(int i = 0; i < rhs.size(); i++) {
                if(rhs.get(i) instanceof ContextualSymbol) {
                    new_rhs.add(((ContextualSymbol) rhs.get(i)).addContext(context));
                } else {
                    new_rhs.add(new ContextualSymbol(rhs.get(i), contexts));
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
}
