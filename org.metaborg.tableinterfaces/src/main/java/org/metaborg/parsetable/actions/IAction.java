package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;

public interface IAction {

    ActionType actionType();

    static boolean allowsLookahead(IAction action, IActionQuery actionQuery) {
        return action.actionType() != ActionType.REDUCE_LOOKAHEAD
            || ((IReduceLookahead) action).allowsLookahead(actionQuery);
    }

    static boolean isApplicableReduce(IAction action, IActionQuery actionQuery) {
        return action.actionType() == ActionType.REDUCE || (action.actionType() == ActionType.REDUCE_LOOKAHEAD
            && ((IReduceLookahead) action).allowsLookahead(actionQuery));
    }

}
