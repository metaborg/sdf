package org.metaborg.parsetable.actions;

import org.metaborg.parsetable.query.IActionQuery;

public interface IAction {

    ActionType actionType();

    boolean allowsLookahead(IActionQuery actionQuery);

    boolean isApplicableReduce(IActionQuery actionQuery);
}
