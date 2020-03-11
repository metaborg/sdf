package org.metaborg.parsetable.actions;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.query.IActionQuery;

public interface IReduceLookahead extends IReduce {

    @Override default ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        ICharacterClass[] followRestriction = lookahead();
        int[] lookahead = actionQuery.actionQueryLookahead(followRestriction.length);

        for(int i = 0; i < followRestriction.length; i++) {
            if(!followRestriction[i].contains(i < lookahead.length ? lookahead[i] : EOF_INT))
                return true;
        }

        return false;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return allowsLookahead(actionQuery);
    }

    ICharacterClass[] lookahead();
}
