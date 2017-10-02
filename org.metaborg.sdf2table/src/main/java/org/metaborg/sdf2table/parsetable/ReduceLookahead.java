package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;

import org.metaborg.sdf2table.grammar.CharacterClass;
import org.metaborg.sdf2table.grammar.GeneralAttribute;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class ReduceLookahead extends Action implements Serializable {

    private static final long serialVersionUID = 4938045344795755011L;

    int prod_label;
    IProduction prod;
    CharacterClass[] lookahead = null;

    public ReduceLookahead(IProduction prod, int prod_label, CharacterClass cc, CharacterClass[] lookahead) {
        this.prod = prod;
        this.prod_label = prod_label;
        this.lookahead = lookahead;
        this.cc = cc;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, IParseTable pt) {
        int status = 0;
        for(IAttribute attr : pt.normalizedGrammar().getProductionAttributesMapping().get(prod)) {
            if(attr instanceof GeneralAttribute) {
                GeneralAttribute ga = (GeneralAttribute) attr;
                if(ga.getName().equals("reject")) {
                    status = 1;
                } else if(ga.getName().equals("prefer")) {
                    status = 2;
                } else if(ga.getName().equals("avoid")) {
                    status = 4;
                }
            }
        }


        IStrategoTerm[] lookaheadTerm = new IStrategoTerm[lookahead.length];
        for(int i = 0; i < lookahead.length; i++) {
            lookaheadTerm[i] = lookahead[i].toAterm(tf);
        }
        return tf.makeAppl(tf.makeConstructor("reduce", 4), tf.makeInt(prod.rightHand().size()), tf.makeInt(prod_label),
            tf.makeInt(status),
            tf.makeList(tf.makeAppl(tf.makeConstructor("follow-restriction", 1), tf.makeList(lookaheadTerm))));
    }

    @Override public String toString() {
        return "reduce(" + prod.rightHand().size() + ", " + prod_label + ", status, " + lookahead + ")";
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lookahead == null) ? 0 : lookahead.hashCode());
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
        ReduceLookahead other = (ReduceLookahead) obj;
        if(lookahead == null) {
            if(other.lookahead != null)
                return false;
        } else if(!lookahead.equals(other.lookahead))
            return false;
        if(prod_label != other.prod_label)
            return false;
        return true;
    }



}
