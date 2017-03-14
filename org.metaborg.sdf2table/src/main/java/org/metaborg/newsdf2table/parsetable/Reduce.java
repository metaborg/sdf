package org.metaborg.newsdf2table.parsetable;

import org.metaborg.newsdf2table.grammar.CharacterClass;
import org.metaborg.newsdf2table.grammar.GeneralAttribute;
import org.metaborg.newsdf2table.grammar.IAttribute;
import org.metaborg.newsdf2table.grammar.IProduction;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class Reduce extends Action {

    int prod_label;
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
        Reduce other = (Reduce) obj;
        if(lookahead == null) {
            if(other.lookahead != null)
                return false;
        } else if(!lookahead.equals(other.lookahead))
            return false;
        if(prod_label != other.prod_label)
            return false;
        return true;
    }

    IProduction prod;
    CharacterClass lookahead = null;

    public Reduce(IProduction prod, int prod_label, CharacterClass cc, CharacterClass lookahead) {
        this.prod = prod;
        this.prod_label = prod_label;
        this.lookahead = lookahead;
        this.cc = cc;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, ParseTableGenerator pt) {
        int status = 0;
        for(IAttribute attr : pt.getGrammar().prod_attrs.get(prod)) {
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

        if(lookahead == null) {
            return tf.makeAppl(tf.makeConstructor("reduce", 3), tf.makeInt(prod.rightHand().size()),
                tf.makeInt(prod_label), tf.makeInt(status));
        } else {
            return tf.makeAppl(tf.makeConstructor("reduce", 4), tf.makeInt(prod.rightHand().size()),
                tf.makeInt(prod_label), tf.makeInt(status), tf.makeList(
                    tf.makeAppl(tf.makeConstructor("follow-restriction", 1), tf.makeList(lookahead.toAterm(tf)))));
        }

    }

    @Override public String toString() {
        if(lookahead == null) {
            return "reduce(" + prod.rightHand().size() + ", " + prod_label + ", status))";
        } else {
            return "reduce(" + prod.rightHand().size() + ", " + prod_label + ", status, " + lookahead
                + ")";
        }
        // return "";
    }





}
