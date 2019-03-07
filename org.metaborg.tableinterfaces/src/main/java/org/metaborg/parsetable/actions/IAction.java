package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;

public interface IAction {

    ActionType actionType();

    default boolean allowsLookahead(IActionQuery actionQuery) {
        return true;
    }

    default boolean isApplicableReduce(IActionQuery actionQuery) {
        return false;
    }

}
