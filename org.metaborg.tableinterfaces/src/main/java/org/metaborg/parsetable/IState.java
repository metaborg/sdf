package org.metaborg.parsetable;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

public interface IState {

    int id();

    boolean isRejectable();

    Iterable<IAction> getApplicableActions(IParseInput parseInput);

    Iterable<IReduce> getApplicableReduceActions(IParseInput parseInput);

    int getGotoId(int productionId);

}
