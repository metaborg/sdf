package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.productions.IProduction;
import org.metaborg.parsetable.productions.ProductionType;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

public interface IActionsFactory {

    IShift getShift(int shiftStateId);

    IReduce getReduce(IProduction production, ProductionType productionType, int arity);

    IReduceLookahead getReduceLookahead(IProduction production, ProductionType productionType, int arity,
        ICharacterClass[] followRestriction);

    IAccept getAccept();

}
