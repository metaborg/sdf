package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;

public interface IReduceLookahead extends IReduce {

    @Override
    default public ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }

    boolean allowsLookahead(IActionQuery actionQuery);

}
