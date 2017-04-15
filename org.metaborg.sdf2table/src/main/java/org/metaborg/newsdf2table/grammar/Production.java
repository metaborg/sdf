package org.metaborg.newsdf2table.grammar;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.Context;
import org.metaborg.newsdf2table.parsetable.TableSet;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;

public class Production implements IProduction {

    private final Symbol lhs;
    private final List<Symbol> rhs;

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

    @Override public void calculateRecursion(NormGrammar grammar) {

        // left recursion
        for(int i = 0; i < rhs.size(); i++) {
            if(grammar.leftRecursive.containsEntry(lhs, rhs.get(i))) {
                leftRecursivePos = i;
                break;
            }
            if(!rhs.get(i).nullable) {
                break;
            }
        }

        // right recursion
        for(int i = rhs.size() - 1; i >= 0; i--) {
            if(grammar.rightRecursive.containsEntry(lhs, rhs.get(i))) {
                rightRecursivePos = i;
                break;
            }
            if(!rhs.get(i).nullable) {
                break;
            }
        }
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(Symbol s : rhs) {
            rhs_terms.add(s.toSDF3Aterm(tf, ctx_vals, ctx_val));
        }

        for(IAttribute a : prod_attrs.get(this)) {
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

}
