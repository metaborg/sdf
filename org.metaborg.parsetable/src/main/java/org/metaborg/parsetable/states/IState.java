package org.metaborg.parsetable.states;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.parsetable.query.IActionQuery;
import org.metaborg.parsetable.query.ParsingMode;

public interface IState {

    int id();

    boolean isRejectable();

    Iterable<IAction> getApplicableActions(IActionQuery actionQuery, ParsingMode parsingMode);

    Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery, ParsingMode parsingMode);

    int getGotoId(int productionId);

    int getGotoId(int productionId, int defaultValue);

}
