package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;

public interface IReduceLookahead extends IReduce {

    @Override default ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }

    @Override boolean allowsLookahead(IActionQuery actionQuery);

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return this.allowsLookahead(actionQuery);
    }
}
