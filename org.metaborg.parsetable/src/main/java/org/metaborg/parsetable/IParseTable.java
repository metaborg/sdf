package org.metaborg.parsetable;

public interface IParseTable {

    IState getStartState();

    IState getState(int stateId);

}
