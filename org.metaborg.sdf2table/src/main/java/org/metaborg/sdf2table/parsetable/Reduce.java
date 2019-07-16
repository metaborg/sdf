package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;

import org.metaborg.parsetable.IProduction;
import org.metaborg.parsetable.ProductionType;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.sdf2table.grammar.GeneralAttribute;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class Reduce extends Action implements IReduce, Serializable {

    private static final long serialVersionUID = 4938045344795755011L;

    int prod_label;
    ParseTableProduction prod;

    public Reduce(ParseTableProduction prod, int prod_label, ICharacterClass cc) {
        this.prod = prod;
        this.prod_label = prod_label;
        this.cc = cc;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, ParseTable pt) {
        return tf.makeAppl(tf.makeConstructor("reduce", 3), tf.makeInt(prod.getProduction().rightHand().size()),
            tf.makeInt(prod_label), tf.makeInt(getStatusFromParseTableProduction(pt)));
    }

    /**
     * @return A status integer that indicates whether the production rule is a "reject", "prefer", or "avoid" rule.
     */
    protected int getStatusFromParseTableProduction(ParseTable pt) {
        for(IAttribute attr : pt.normalizedGrammar().getProductionAttributesMapping().get(prod.getProduction())) {
            if(attr instanceof GeneralAttribute) {
                GeneralAttribute ga = (GeneralAttribute) attr;
                switch(ga.getName()) {
                    case "reject":
                        return 1;
                    case "prefer":
                        return 2;
                    case "avoid":
                        return 4;
                }
            }
        }
        return 0;
    }

    @Override public String toString() {
        return "reduce(" + prod.getProduction().rightHand().size() + "," + prod_label + "," + productionType() + ")";
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + prod_label;
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Reduce other = (Reduce) obj;
        if(prod_label != other.prod_label)
            return false;
        return true;
    }

    @Override public IProduction production() {
        return prod;
    }

    @Override public ProductionType productionType() {
        return prod.getProductionType();
    }

    @Override public int arity() {
        return prod.getProduction().rightHand().size();
    }

}
