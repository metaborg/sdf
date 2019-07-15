package org.metaborg.parsetable;

public interface IParseTable {

    public IState getStartState();

    public IState getState(int stateId);

}
