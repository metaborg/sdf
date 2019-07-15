package org.metaborg.parsetable;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.parsetable.query.IActionQuery;

public interface IState {

    int id();

    boolean isRejectable();

    Iterable<IAction> getApplicableActions(IActionQuery actionQuery);

    Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery);

    int getGotoId(int productionId);

}
