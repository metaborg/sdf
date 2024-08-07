package org.metaborg.parsetable.states;

import java.util.Set;

import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.parsetable.query.*;

public class StateFactory implements IStateFactory {

    private final ActionsForCharacterRepresentation actionsForCharacterRepresentation;
    private final ProductionToGotoRepresentation productionToGotoRepresentation;

    public StateFactory() {
        this(ActionsForCharacterRepresentation.standard(), ProductionToGotoRepresentation.standard());
    }

    public StateFactory(ActionsForCharacterRepresentation actionsForCharacterRepresentation,
        ProductionToGotoRepresentation productionToGotoType) {
        this.actionsForCharacterRepresentation = actionsForCharacterRepresentation;
        this.productionToGotoRepresentation = productionToGotoType;
    }

    @Override public IMutableState from(int stateId, IGoto[] gotos, ActionsPerCharacterClass[] actionsPerCharacterClass,
        Set<Integer> recoveryStateIds) {
        IActionsForCharacter actionsForCharacter;
        IProductionToGoto productionToGoto;

        switch(actionsForCharacterRepresentation) {
            case DisjointSorted:
                actionsForCharacter = new ActionsForCharacterDisjointSorted(actionsPerCharacterClass, recoveryStateIds);
                break;
            case Separated:
                actionsForCharacter = new ActionsForCharacterSeparated(actionsPerCharacterClass, recoveryStateIds);
                break;
            default:
                actionsForCharacter = null;
                break;
        }

        switch(productionToGotoRepresentation) {
            case ForLoop:
                productionToGoto = new ProductionToGotoForLoop(gotos);
                break;
            case JavaHashMap:
                productionToGoto = new ProductionToGotoJavaHashMap(gotos);
                break;
            default:
                productionToGoto = null;
                break;
        }

        return new State(stateId, actionsForCharacter, productionToGoto);
    }

}
