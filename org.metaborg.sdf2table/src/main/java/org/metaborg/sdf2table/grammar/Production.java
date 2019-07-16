package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.metaborg.sdf2table.io.ParseTableIO;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;

public class Production implements IProduction, Serializable {

    private static final long serialVersionUID = 5887433349870067696L;

    final Symbol lhs;
    final List<Symbol> rhs;

    private int leftRecursivePos = -1;
    private int rightRecursivePos = -1;

    public Production(Symbol lhs, List<Symbol> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Production(Symbol lhs, List<Symbol> rhs, int leftRecPos, int rightRecPos) {
        this.lhs = lhs;
        this.rhs = rhs;
        leftRecursivePos = leftRecPos;
        rightRecursivePos = rightRecPos;
    }

    @Override public ISymbol leftHand() {
        return lhs;
    }

    @Override public List<ISymbol> rightHand() {
        List<ISymbol> result = Lists.newArrayList();
        result.addAll(rhs);
        return result;
    }

    public Symbol getLhs() {
        return lhs;
    }

    public List<Symbol> getRhs() {
        return rhs;
    }

    public int rightRecursivePosition() {
        return rightRecursivePos;
    }

    public int leftRecursivePosition() {
        return leftRecursivePos;
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
        ITermFactory tf = ParseTableIO.getTermfactory();
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(ISymbol s : rhs) {
            rhs_terms.add(((Symbol) s).toAterm(tf));
        }

        for(IAttribute a : prod_attrs.get(this)) {
            attrs_terms.add(a.toAterm(tf));
        }

        if(attrs_terms.isEmpty()) {
            return tf.makeAppl(tf.makeConstructor("prod", 3), tf.makeList(rhs_terms), ((Symbol) lhs).toAterm(tf),
                tf.makeAppl(tf.makeConstructor("no-attrs", 0)));
        }

        return tf.makeAppl(tf.makeConstructor("prod", 3), tf.makeList(rhs_terms), ((Symbol) lhs).toAterm(tf),
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

    public void calculateRecursion(NormGrammar grammar) {

        // left recursion
        for(int i = 0; i < rhs.size(); i++) {
            if(grammar.getLeftRecursiveSymbolsMapping().containsEntry(lhs, rhs.get(i))) {
                leftRecursivePos = i;
                break;
            }
            if(!((Symbol) rhs.get(i)).isNullable()) {
                break;
            }
        }

        // right recursion
        for(int i = rhs.size() - 1; i >= 0; i--) {
            if(grammar.getRightRecursiveSymbolsMapping().containsEntry(lhs, rhs.get(i))) {
                rightRecursivePos = i;
                break;
            }
            if(!((Symbol) rhs.get(i)).isNullable()) {
                break;
            }
        }
    }

    public IStrategoTerm toSDF3Aterm(SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        ITermFactory tf = ParseTableIO.getTermfactory();
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(ISymbol s : rhs) {
            rhs_terms.add(((Symbol) s).toSDF3Aterm(tf, ctx_vals, ctx_val));
        }

        for(IAttribute a : prod_attrs.get(this)) {
            attrs_terms.add(a.toSDF3Aterm(tf));
        }

        if(attrs_terms.isEmpty()) {
            return tf.makeAppl(tf.makeConstructor("SdfProduction", 3), ((Symbol) lhs).toSDF3Aterm(tf, ctx_vals, ctx_val),
                tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
                tf.makeAppl(tf.makeConstructor("NoAttrs", 0)));
        } else {
            // with constructor
        }

        return tf.makeAppl(tf.makeConstructor("SdfProduction", 3), ((Symbol) lhs).toSDF3Aterm(tf, ctx_vals, ctx_val),
            tf.makeAppl(tf.makeConstructor("Rhs", 1), tf.makeList(rhs_terms)),
            tf.makeAppl(tf.makeConstructor("Attrs", 1), tf.makeList(attrs_terms)));
    }
}
