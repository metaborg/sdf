package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.IActionQuery;

public interface IAction {

    ActionType actionType();

    boolean allowsLookahead(IActionQuery actionQuery);

    boolean isApplicableReduce(IActionQuery actionQuery);
}
