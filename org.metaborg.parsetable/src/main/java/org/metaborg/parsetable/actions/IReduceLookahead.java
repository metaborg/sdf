package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.query.IActionQuery;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

public interface IReduceLookahead extends IReduce {

    @Override default ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }

    @Override default boolean allowsLookahead(IActionQuery actionQuery) {
        ICharacterClass[] followRestriction = lookahead();
        String lookahead = actionQuery.actionQueryLookahead(followRestriction.length);

        for(int i = 0; i < followRestriction.length; i++) {
            if(!followRestriction[i].contains(i < lookahead.length() ? lookahead.charAt(i) : EOF_INT))
                return true;
        }

        return false;
    }

    @Override default boolean isApplicableReduce(IActionQuery actionQuery) {
        return allowsLookahead(actionQuery);
    }

    ICharacterClass[] lookahead();
}
