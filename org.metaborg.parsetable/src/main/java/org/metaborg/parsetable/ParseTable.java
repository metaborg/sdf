package org.metaborg.parsetable;

import org.metaborg.parsetable.states.IState;

public class ParseTable implements IParseTable {

    final private IState[] states;
    final private int startStateId;

    public ParseTable(IState[] states, int startStateId) {
        this.states = states;
        this.startStateId = startStateId;
    }

    @Override public IState getStartState() {
        return getState(startStateId);
    }

    @Override public IState getState(int stateId) {
        return states[stateId];
    }

}
