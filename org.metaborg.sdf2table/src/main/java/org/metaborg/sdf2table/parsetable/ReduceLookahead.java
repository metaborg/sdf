package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.Arrays;

import org.metaborg.parsetable.actions.IReduceLookahead;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class ReduceLookahead extends Reduce implements IReduceLookahead, Serializable {

    private static final long serialVersionUID = 4938045344795755011L;

    private ICharacterClass[] lookahead;

    public ReduceLookahead(ParseTableProduction prod, int prod_label, ICharacterClass cc, ICharacterClass[] lookahead) {
        super(prod, prod_label, cc);
        this.lookahead = lookahead;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, ParseTable pt) {
        IStrategoTerm[] lookaheadTerm = new IStrategoTerm[lookahead.length];
        for(int i = 0; i < lookahead.length; i++) {
            lookaheadTerm[i] = lookahead[i].toAterm(tf);
        }

        return tf.makeAppl(tf.makeConstructor("reduce", 4), tf.makeInt(prod.getProduction().arity()),
            tf.makeInt(prod_label), tf.makeInt(getStatusFromParseTableProduction(pt)),
            tf.makeList(tf.makeAppl(tf.makeConstructor("follow-restriction", 1), tf.makeList(lookaheadTerm))));
    }

    @Override public String toString() {
        return "reduce(" + prod.getProduction().arity() + "," + prod_label + "," + productionType()
            + ",follow-restriction" + Arrays.toString(lookahead) + ")";
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
        } else if(!Arrays.equals(lookahead, other.lookahead))
            return false;
        if(prod_label != other.prod_label)
            return false;
        return true;
    }

    @Override public ICharacterClass[] lookahead() {
        return lookahead;
    }

}
