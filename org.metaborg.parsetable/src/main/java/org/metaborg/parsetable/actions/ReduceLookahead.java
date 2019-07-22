package org.metaborg.parsetable.actions;

import java.util.Arrays;

import org.metaborg.parsetable.productions.IProduction;
import org.metaborg.parsetable.productions.ProductionType;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

public class ReduceLookahead extends Reduce implements IReduceLookahead {

    private final ICharacterClass[] followRestriction;

    public ReduceLookahead(IProduction production, ProductionType productionType, int arity,
        ICharacterClass[] followRestriction) {
        super(production, productionType, arity);

        this.followRestriction = followRestriction;
    }

    @Override public String toString() {
        return "reduce(" + arity + "," + production.id() + "," + productionType + ",follow-restriction"
            + Arrays.toString(followRestriction) + ")";
    }

    @Override public int hashCode() {
        return super.hashCode() ^ followRestriction.hashCode();
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        ReduceLookahead that = (ReduceLookahead) o;

        return production.equals(that.production) && productionType.equals(that.productionType) && arity == that.arity
            && Arrays.equals(followRestriction, that.followRestriction);
    }

    @Override public ICharacterClass[] lookahead() {
        return followRestriction;
    }

}
