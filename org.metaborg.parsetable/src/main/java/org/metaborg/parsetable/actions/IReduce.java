package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.productions.IProduction;
import org.metaborg.parsetable.productions.ProductionType;
import org.metaborg.parsetable.query.IActionQuery;

public interface IReduce extends IAction {

    @Override default ActionType actionType() {
        return ActionType.REDUCE;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        return true;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return true;
    }

    IProduction production();

    ProductionType productionType();

    int arity();

    default boolean isRejectProduction() {
        return productionType() == ProductionType.REJECT;
    }

}
