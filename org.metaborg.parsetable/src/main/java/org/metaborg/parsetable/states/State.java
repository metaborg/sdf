package org.metaborg.parsetable.states;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.parsetable.query.IActionQuery;
import org.metaborg.parsetable.query.IActionsForCharacter;
import org.metaborg.parsetable.query.IProductionToGoto;
import org.metaborg.parsetable.query.ParsingMode;

public final class State implements IState {

    private final int stateId;
    private boolean rejectable;

    private final IActionsForCharacter actionsForCharacter;
    private final IProductionToGoto productionToGoto;

    public State(int stateId, IActionsForCharacter actionsForCharacter, IProductionToGoto productionToGoto) {
        this.stateId = stateId;
        this.actionsForCharacter = actionsForCharacter;
        this.productionToGoto = productionToGoto;
        this.rejectable = false;
    }

    @Override public int id() {
        return stateId;
    }

    @Override public boolean isRejectable() {
        return rejectable;
    }

    public void markRejectable() {
        this.rejectable = true;
    }

    public IAction[] actions() {
        return actionsForCharacter.getActions();
    }

    @Override public Iterable<IAction> getApplicableActions(IActionQuery actionQuery, ParsingMode parsingMode) {
        return actionsForCharacter.getApplicableActions(actionQuery, parsingMode);
    }

    @Override public Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery, ParsingMode parsingMode) {
        return actionsForCharacter.getApplicableReduceActions(actionQuery, parsingMode);
    }

    public boolean hasGoto(int productionId) {
        return productionToGoto.contains(productionId);
    }

    @Override public int getGotoId(int productionId) {
        return productionToGoto.get(productionId);
    }

    @Override public int getGotoId(int productionId, int defaultValue) {
        return productionToGoto.get(productionId, defaultValue);
    }

    @Override public boolean equals(Object obj) {
        if(!(obj instanceof State))
            return false;

        State otherState = (State) obj;

        return this.stateId == otherState.stateId;
    }

}
