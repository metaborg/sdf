package org.metaborg.parsetable;

import org.metaborg.parsetable.states.IState;

public interface IParseTable {

    IState getStartState();

    IState getState(int stateId);

    int totalStates();
    

}
