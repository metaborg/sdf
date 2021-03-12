package org.metaborg.parsetable;

import java.util.List;

import org.metaborg.parsetable.productions.IProduction;
import org.metaborg.parsetable.states.IState;

public class ParseTable implements IParseTable {

    final private IState[] states;
    final private int startStateId;
    final private List<IProduction> productions;
    final private boolean isLayoutSensitive;

    public ParseTable(IState[] states, int startStateId, List<IProduction> productions, boolean isLayoutSensitive) {
        this.states = states;
        this.startStateId = startStateId;
        this.productions = productions;
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

    @Override public List<IProduction> productions() {
        return productions;
    }

    @Override public boolean isLayoutSensitive() {
        return isLayoutSensitive;
    }

}
