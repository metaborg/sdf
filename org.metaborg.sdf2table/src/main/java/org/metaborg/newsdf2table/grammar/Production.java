package org.metaborg.newsdf2table.grammar;

import java.util.List;
import java.util.Set;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Production implements IProduction {

    Symbol lhs;
    String constructor;
    List<Symbol> rhs;
    Set<IAttribute> attrs;

    public Production(Symbol lhs, String constructor, List<Symbol> rhs) {
        this.lhs = lhs;
        this.constructor = constructor;
        this.rhs = rhs;
        this.attrs = Sets.newHashSet();
    }

    @Override public Symbol leftHand() {
        return lhs;
    }

    @Override public String constructor() {
        return constructor;
    }

    @Override public List<Symbol> rightHand() {
        return rhs;
    }

    @Override public Set<IAttribute> attributes() {
        return attrs;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((constructor == null) ? 0 : constructor.hashCode());
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
        final Production other = (Production) obj;
        if(constructor == null) {
            if(other.constructor != null)
                return false;
        } else if(!constructor.equals(other.constructor))
            return false;
        if(!lhs.equals(other.lhs))
            return false;
        if(!rhs.equals(other.rhs))
            return false;
        return true;
    }

    @Override public String toString() {

        String prod = "";
        prod += lhs.name();

        if(constructor != null)
            prod += "." + constructor + " ";

        prod += " -> ";

        for(Symbol s : rhs)
            prod += s.name() + " ";


        if(!attrs.isEmpty()) {
            int i = 0;
            prod += " {";
            for(IAttribute attr : attrs) {
                if(i > 0)
                    prod += ", ";
                prod += attr;
                ++i;
            }
            prod += "}";
        }


        return prod;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        List<IStrategoTerm> rhs_terms = Lists.newArrayList();
        List<IStrategoTerm> attrs_terms = Lists.newArrayList();
        for(Symbol s : rhs) {
            rhs_terms.add(s.toAterm(tf));
        }
        for(IAttribute a : attrs) {
            attrs_terms.add(a.toAterm(tf));
        }
        return tf.makeAppl(tf.makeConstructor("prod", 3), tf.makeList(rhs_terms), lhs.toAterm(tf),
            tf.makeAppl(tf.makeConstructor("attrs", 1), tf.makeList(attrs_terms)));
    }



}
