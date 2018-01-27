package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IProduction;
import org.metaborg.parsetable.ProductionType;

public interface IReduce extends IAction {

    @Override
    default ActionType actionType() {
        return ActionType.REDUCE;
    }

    IProduction production();

    ProductionType productionType();

    int arity();

    default boolean isRejectProduction() {
        return productionType() == ProductionType.REJECT;
    }

}
