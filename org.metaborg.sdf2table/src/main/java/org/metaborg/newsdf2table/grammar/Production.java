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

    private Symbol lhs;
    private List<Symbol> rhs;

    // First and Follow Sets
    private TableSet firstSet = new TableSet(this);
    private TableSet followSet = new TableSet(this);

    private int leftRecursivePos = -1;
    private int rightRecursivePos = -1;

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

    @Override public Set<Integer> deepConflictingArgs(ParseTable pt, IProduction p) {
        DeepPriority prio = new DeepPriority(this, p, false);

        if(pt.getGrammar().deep_priorities().containsKey(prio)) {
            return pt.getGrammar().deep_priorities().get(prio);
        }

        Set<Integer> result = Sets.newHashSet();

        // calculate information about both productions
        // int lower_leftRecursivePos = p.leftRecursivePosition();
        // int lower_rightRecursivePos = p.rightRecursivePosition();

        // check if item.prod is left and right recursive
        // check if Symbol_left (item.prod) =>
        // check if p is right recursive


        // boolean matchPrefix = false;
        // int conflicting_p = -1;
        // dangling else case
        // if(!lower_rightRecursivePositions.isEmpty()) {
        // for(int i : lower_rightRecursivePositions) {
        // if(this.rightHand().size() <= i)
        // continue;
        // for(int j = 0; j <= i; j++) {
        // if(this.rhs.get(j).equals(p.rightHand().get(j))) {
        // matchPrefix = true;
        // conflicting_p = i;
        // } else {
        // matchPrefix = false;
        // break;
        // }
        // }
        // if(matchPrefix)
        // break;
        // }
        // }
        // if(matchPrefix && !this.equals(p)) {
        // Set<Integer> conflicting_ps = Sets.newHashSet(conflicting_p);
        // pt.getGrammar().deep_priorities().putAll(prio, conflicting_ps);
        // result.addAll(conflicting_ps);
        // }

        // check if the item.prod is recursive
        // check if the prefix of its recursion matches the prefix of p (prior to its recursion)
        // add item.prod > p as a deep priority conflict

        return result;
    }

    @Override public boolean isBracket(ParseTable pt) {
        return pt.getGrammar().prod_attrs.get(this).contains(new GeneralAttribute("bracket"));
    }



    @Override public int rightRecursivePosition() {
        // TODO Consider indirect recursion?
        return rightRecursivePos;
    }


    @Override public int leftRecursivePosition() {
        // TODO Consider indirect recursion?
        return leftRecursivePos;
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

    @Override public void calculateRecursivity(NormGrammar grammar) {
        // TODO: consider indirect recursion

        // left recursion
        for(int i = 0; i < rhs.size(); i++) {
            if(rhs.get(i).equals(lhs)) {
                leftRecursivePos = i;
                break;
            }
            if(!rhs.get(i).nullable) {
                break;
            }
        }

        // right recursion
        for(int i = rhs.size() - 1; i >= 0; i--) {
            if(rhs.get(i).equals(lhs)) {
                rightRecursivePos = i;
                break;
            }
            if(!rhs.get(i).nullable) {
                break;
            }
        }
    }

}
