package org.metaborg.parsetable;

import java.util.List;

import org.metaborg.parsetable.productions.IProduction;
import org.metaborg.parsetable.states.IState;

public interface IParseTable {

    IState getStartState();

    IState getState(int stateId);

    int totalStates();

    List<IProduction> productions();

    boolean isLayoutSensitive();

}
