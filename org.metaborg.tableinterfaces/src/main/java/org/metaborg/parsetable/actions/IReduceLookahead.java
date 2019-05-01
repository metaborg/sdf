package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

public interface IReduceLookahead extends IReduce {

    @Override default ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        ICharacterClass[] followRestriction = lookahead();
        String lookahead = actionQuery.actionQueryLookahead(followRestriction.length);

        if(lookahead.length() != followRestriction.length)
            return true;

        for(int i = 0; i < followRestriction.length; i++) {
            if(!followRestriction[i].contains(lookahead.charAt(i)))
                return true;
        }

        return false;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return allowsLookahead(actionQuery);
    }

    ICharacterClass[] lookahead();
}
