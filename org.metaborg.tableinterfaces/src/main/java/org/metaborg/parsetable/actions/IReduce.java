package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;
import org.metaborg.parsetable.IProduction;
import org.metaborg.parsetable.ProductionType;

public interface IReduce extends IAction {

    @Override default ActionType actionType() {
        return ActionType.REDUCE;
    }

    IProduction production();

    ProductionType productionType();

    int arity();

    default boolean isRejectProduction() {
        return productionType() == ProductionType.REJECT;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        return true;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return true;
    }
}
