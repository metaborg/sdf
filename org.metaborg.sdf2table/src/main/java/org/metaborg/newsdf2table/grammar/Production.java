package org.metaborg.newsdf2table.grammar;

import java.util.List;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.ParseTable;
import org.metaborg.newsdf2table.parsetable.TableSet;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class Production implements IProduction {

    Symbol lhs;
    List<Symbol> rhs;

    // First and Follow Sets
    TableSet firstSet = new TableSet(this);
    TableSet followSet = new TableSet(this);

    // Only calculate once when necessary
    boolean calculatedDeepPriorityElements = false;
    boolean isLeftRecursive = false;
    boolean isRightRecursive = false;
    boolean isLeftAssociative = false;
    boolean isRightAssociative = false;
    Set<Integer> leftRecursivePos = Sets.newHashSet();
    Set<Integer> rightRecursivePos = Sets.newHashSet();



    public Production(Symbol lhs, List<Symbol> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override public Symbol leftHand() {
        return lhs;
    }

    @Override public List<Symbol> rightHand() {
        return rhs;
    }

    @Override public TableSet firstSet() {
        return firstSet;
    }

    @Override public TableSet followSet() {
        return followSet;
    }

    @Override public void calculateDependencies(NormGrammar g) {
        // first dependencies
        calculateFirstSetDependencies(g, 0);
        // if rhs = A1 ... AN
        // if A1 is a CharacterClass
        // firstSet.add(A1);
        // else firstSet.AddDependency(A1)
        // if A1 is nullable
        // calculateDependency(A2)

    }

    private void calculateFirstSetDependencies(NormGrammar g, int symbol) {
        if(symbol < rhs.size()) {
            Symbol s = rhs.get(symbol);
            if(s instanceof CharacterClass) {
                firstSet.add((CharacterClass) s);
            } else {
                for(IProduction p : g.symbol_prods.get(s)) {
                    firstSet.addDependency(p.firstSet());
                }
                if(s.nullable) {
                    calculateFirstSetDependencies(g, symbol + 1);
                }
            }
        }
    }

    @Override public Set<Integer> isDeepPriorityConflict(ParseTable pt, IProduction p) {
        DeepPriority prio = new DeepPriority(this, p, false);

        if(pt.getGrammar().deep_priorities().containsKey(prio)) {
            return pt.getGrammar().deep_priorities().get(prio);
        }

        Set<Integer> result = Sets.newHashSet();

        // calculate information about both productions
        Set<Integer> higher_leftRecursivePositions = this.leftRecursivePositions();
        Set<Integer> lower_leftRecursivePositions = p.leftRecursivePositions();
        Set<Integer> higher_rightRecursivePositions = this.rightRecursivePositions();
        Set<Integer> lower_rightRecursivePositions = p.rightRecursivePositions();
        boolean higher_leftAssociative =
            this.isLeftAssociative(pt.getGrammar().priorities(), higher_leftRecursivePositions);
        boolean lower_leftAssociative = p.isLeftAssociative(pt.getGrammar().priorities(), lower_leftRecursivePositions);
        boolean higher_rightAssociative =
            this.isRightAssociative(pt.getGrammar().priorities(), higher_rightRecursivePositions);
        boolean lower_rightAssociative =
            p.isRightAssociative(pt.getGrammar().priorities(), lower_rightRecursivePositions);
        this.setCurrentDeepPriorityElements(true);
        p.setCurrentDeepPriorityElements(true);

        // check if item.prod is left and right recursive
        // check if Symbol_left (item.prod) =>
        // check if p is right recursive
        if(!higher_leftRecursivePositions.isEmpty() && !higher_rightRecursivePositions.isEmpty()
            && lower_rightAssociative && higher_leftAssociative) {
            // add item.prod > p as a deep priority conflict
            pt.getGrammar().deep_priorities().putAll(prio, higher_leftRecursivePositions);
            result.addAll(higher_leftRecursivePositions);
        }

        // check the mirrored option
        if(!higher_leftRecursivePositions.isEmpty() && !higher_rightRecursivePositions.isEmpty()
            && lower_leftAssociative && higher_rightAssociative) {
            // add item.prod > p as a deep priority conflict
            pt.getGrammar().deep_priorities().putAll(prio, higher_rightRecursivePositions);
            result.addAll(higher_rightRecursivePositions);
        }

        boolean matchPrefix = false;
        int conflicting_p = -1;
        // dangling else case
        if(!lower_rightRecursivePositions.isEmpty() && lower_rightAssociative) {
            for(int i : lower_rightRecursivePositions) {
                if(this.rightHand().size() <= i)
                    continue;
                for(int j = 0; j <= i; j++) {
                    if(this.rhs.get(j).equals(p.rightHand().get(j))) {
                        matchPrefix = true;
                        conflicting_p = i;
                    } else {
                        matchPrefix = false;
                        break;
                    }
                }
                if(matchPrefix)
                    break;
            }
        }
        if(matchPrefix && !this.equals(p)) {
            Set<Integer> conflicting_ps = Sets.newHashSet(conflicting_p);
            pt.getGrammar().deep_priorities().putAll(prio, conflicting_ps);
            result.addAll(conflicting_ps);
        }

        // check if the item.prod is recursive
        // check if the prefix of its recursion matches the prefix of p (prior to its recursion)
        // add item.prod > p as a deep priority conflict

        return result;
    }

    @Override public boolean isBracket(ParseTable pt) {
        return pt.getGrammar().prod_attrs.get(this).contains(new GeneralAttribute("bracket"));
    }


    @Override public boolean isRightAssociative(SetMultimap<IPriority, Integer> priorities,
        Set<Integer> rightRecursivePositions) {

        if(calculatedDeepPriorityElements)
            return isRightAssociative;

        // there is a priority that does not allow recursion
        if(priorities.containsEntry(new Priority(this, this, true), -1)) {
            isRightAssociative = false;
            return isRightAssociative;
        }

        // if there is a priority that allows a left recursive derivation
        for(int i : rightRecursivePositions) {
            if(!priorities.containsEntry(new Priority(this, this, true), i)) {
                isRightAssociative = true;
                return isRightAssociative;
            }
        }

        return isRightAssociative;
    }

    @Override public Set<Integer> rightRecursivePositions() {
        // TODO Considers indirect recursion?

        if(calculatedDeepPriorityElements)
            return rightRecursivePos;

        boolean nullable = true;
        for(int i = rhs.size() - 1; i >= 0; i--) {
            Symbol symbol = rhs.get(i);
            if(symbol.nullable && nullable) {
                continue;
            }
            if(nullable && !symbol.nullable && symbol.equals(lhs)) {
                rightRecursivePos.add(i);
            }
            if(!symbol.nullable) {
                break;
            }
        }

        return rightRecursivePos;
    }

    @Override public boolean isLeftAssociative(SetMultimap<IPriority, Integer> priorities,
        Set<Integer> leftRecursivePositions) {

        if(calculatedDeepPriorityElements)
            return isLeftAssociative;

        // there is a priority that does not allow recursion
        if(priorities.containsEntry(new Priority(this, this, true), -1)) {
            isLeftAssociative = false;
            return isLeftAssociative;
        }

        // if there is a priority that allows a left recursive derivation
        for(int i : leftRecursivePositions) {
            if(!priorities.containsEntry(new Priority(this, this, true), i)) {
                isLeftAssociative = true;
                return isLeftAssociative;
            }
        }

        return isLeftAssociative;
    }

    @Override public Set<Integer> leftRecursivePositions() {
        // TODO Considers indirect recursion?

        if(calculatedDeepPriorityElements)
            return leftRecursivePos;

        boolean nullable = true;
        for(int i = 0; i < rhs.size(); i++) {
            Symbol symbol = rhs.get(i);
            if(symbol.nullable && nullable) {
                continue;
            }
            if(nullable && !symbol.nullable && symbol.equals(lhs)) {
                leftRecursivePos.add(i);
            }
            if(!symbol.nullable) {
                break;
            }
        }

        return leftRecursivePos;
    }

    @Override public void setCurrentDeepPriorityElements(boolean value) {
        this.calculatedDeepPriorityElements = value;
    }

    @Override public String toString() {

        String prod = "";
        prod += lhs.name();

        prod += " -> ";

        for(Symbol s : rhs)
            prod += s.name() + " ";

        return prod;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs) {
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(Symbol s : rhs) {
            rhs_terms.add(s.toAterm(tf));
        }

        for(IAttribute a : prod_attrs.get(this)) {
            attrs_terms.add(a.toAterm(tf));
        }

        if(attrs_terms.isEmpty()) {
            return tf.makeAppl(tf.makeConstructor("prod", 3), tf.makeList(rhs_terms), lhs.toAterm(tf),
                tf.makeAppl(tf.makeConstructor("no-attrs", 0)));
        }

        return tf.makeAppl(tf.makeConstructor("prod", 3), tf.makeList(rhs_terms), lhs.toAterm(tf),
            tf.makeAppl(tf.makeConstructor("attrs", 1), tf.makeList(attrs_terms)));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
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
        Production other = (Production) obj;
        if(lhs == null) {
            if(other.lhs != null)
                return false;
        } else if(!lhs.equals(other.lhs))
            return false;
        if(rhs == null) {
            if(other.rhs != null)
                return false;
        } else if(!rhs.equals(other.rhs))
            return false;
        return true;
    }

}
