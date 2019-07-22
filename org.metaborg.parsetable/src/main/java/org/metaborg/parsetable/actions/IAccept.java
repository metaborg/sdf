package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.query.IActionQuery;

public interface IAccept extends IAction {

    @Override default ActionType actionType() {
        return ActionType.ACCEPT;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        return true;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return false;
    }
}
