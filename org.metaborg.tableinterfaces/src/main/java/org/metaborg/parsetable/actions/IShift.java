package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;

public interface IShift extends IAction {

    @Override default ActionType actionType() {
        return ActionType.SHIFT;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        return true;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return false;
    }

    int shiftStateId();
}
