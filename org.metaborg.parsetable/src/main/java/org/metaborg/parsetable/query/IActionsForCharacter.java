package org.metaborg.parsetable.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.metaborg.parsetable.actions.ActionType;
import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.parsetable.actions.IShift;

public interface IActionsForCharacter {

    /*
     * Returns all actions. Only used during parse table loading for marking rejectable states, thus the implementation
     * of this method does not influence parsing performance.
     */
    IAction[] getActions();

    /*
     * Returns actions applicable to the given configuration (i.e. current character and lookahead) and parsing mode.
     */
    Iterable<IAction> getApplicableActions(IActionQuery actionQuery, ParsingMode parsingMode);

    /*
     * Returns reduce actions (possibly with lookahead) applicable to the given configuration (i.e. current character
     * and lookahead) and parsing mode.
     */
    Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery, ParsingMode parsingMode);

    default ActionsPerCharacterClass[] filterNonRecoveryActions(ActionsPerCharacterClass[] actionsPerCharacterClasses,
        Set<Integer> recoveryStateIds) {
        ActionsPerCharacterClass[] filteredActionsPerCharacterClasses =
            new ActionsPerCharacterClass[actionsPerCharacterClasses.length];

        int i = 0;
        for(ActionsPerCharacterClass actionsPerCharacterClass : actionsPerCharacterClasses) {
            List<IAction> filteredActions = new ArrayList<>(actionsPerCharacterClass.actions);

            filteredActions.removeIf(action -> {
                boolean isRecoveryReduce =
                    (action.actionType() == ActionType.REDUCE || action.actionType() == ActionType.REDUCE_LOOKAHEAD)
                        && ((IReduce) action).production().isRecovery();

                boolean isShiftToRecoveryState = (action.actionType() == ActionType.SHIFT) && recoveryStateIds.stream()
                    .anyMatch(recoveryStateId -> recoveryStateId == ((IShift) action).shiftStateId());

                return isRecoveryReduce || isShiftToRecoveryState;
            });

            if(filteredActions.size() == actionsPerCharacterClass.actions.size())
                filteredActionsPerCharacterClasses[i++] = actionsPerCharacterClass;
            else if(filteredActions.size() > 0)
                filteredActionsPerCharacterClasses[i++] =
                    new ActionsPerCharacterClass(actionsPerCharacterClass.characterClass, filteredActions);
        }

        return Arrays.copyOf(filteredActionsPerCharacterClasses, i);
    }

}