package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IParseInput;

public interface IReduceLookahead extends IReduce {

    @Override
    default public ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }

    boolean allowsLookahead(IParseInput parseInput);

}
