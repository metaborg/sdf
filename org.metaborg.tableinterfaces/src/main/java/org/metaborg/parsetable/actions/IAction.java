package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IParseInput;

public interface IAction {

    ActionType actionType();

    static boolean allowsLookahead(IAction action, IParseInput parseInput) {
        return action.actionType() != ActionType.REDUCE_LOOKAHEAD
            || ((IReduceLookahead) action).allowsLookahead(parseInput);
    }

    static boolean isApplicableReduce(IAction action, IParseInput parseInput) {
        return action.actionType() == ActionType.REDUCE || (action.actionType() == ActionType.REDUCE_LOOKAHEAD
            && ((IReduceLookahead) action).allowsLookahead(parseInput));
    }

}
