package org.metaborg.parsetable;

import org.metaborg.parsetable.states.IState;

public class ParseTable implements IParseTable {

    final private IState[] states;
    final private int startStateId;
    final private boolean isLayoutSensitive;

    public ParseTable(IState[] states, int startStateId, boolean isLayoutSensitive) {
        this.states = states;
        this.startStateId = startStateId;
        this.isLayoutSensitive = isLayoutSensitive;
    }

    @Override public IState getStartState() {
        return getState(startStateId);
    }

    @Override public IState getState(int stateId) {
        return states[stateId];
    }
    
    @Override public int totalStates() {
        return states.length;
    }

    @Override public boolean isLayoutSensitive() {
        return isLayoutSensitive;
    }

}
