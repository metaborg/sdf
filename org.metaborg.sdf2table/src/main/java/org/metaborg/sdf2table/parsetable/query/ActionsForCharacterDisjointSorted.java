package org.metaborg.sdf2table.parsetable.query;

import java.io.Serializable;
import java.util.*;

import org.metaborg.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.IActionQuery;
import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

public final class ActionsForCharacterDisjointSorted implements IActionsForCharacter, Serializable {

    private static final long serialVersionUID = -619727965728365810L;

    private final ActionsForRange[] actionsForSortedDisjointRanges;

    public ActionsForCharacterDisjointSorted(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        this.actionsForSortedDisjointRanges = toDisjointSortedRanges(actionsPerCharacterClasses);
    }

    public static ActionsForRange[] toDisjointSortedRanges(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        List<ActionsForRange> actionsForRanges = new ArrayList<>();

        int newRangeFromCharacter = -1; // Contains the start character for the next range that will be added
        Set<IAction> newRangeActions = null; // Contains the actions for the next range that will be added

        for(int character = 0; character <= CharacterClassFactory.EOF_INT; character++) {
            Set<IAction> actionsForCharacter = null;

            for(ActionsPerCharacterClass actionsPerCharacterClass : actionsPerCharacterClasses) {
                if(actionsPerCharacterClass.appliesTo(character)) {
                    if(actionsForCharacter == null)
                        actionsForCharacter = new HashSet<>();

                    actionsForCharacter.addAll(actionsPerCharacterClass.actions);
                }
            }

            /*
             * Based on the applicable actions for the current character and if a new range already started before: do
             * nothing, create the range that was already started, start a new range or both of the latter.
             */
            if(actionsForCharacter == null || actionsForCharacter.isEmpty()) {
                if(newRangeFromCharacter != -1) { // A range ended on the previous character
                    actionsForRanges
                        .add(new ActionsForRange(newRangeActions.toArray(new IAction[newRangeActions.size()]),
                            newRangeFromCharacter, character - 1));

                    newRangeFromCharacter = -1;
                    newRangeActions = null;
                }
            } else {
                if(newRangeFromCharacter != -1) {
                    if(!actionsForCharacter.equals(newRangeActions)) { // Different actions, thus a range ended on the
                                                                       // previous character and a new one starts at the
                                                                       // current character
                        actionsForRanges
                            .add(new ActionsForRange(newRangeActions.toArray(new IAction[newRangeActions.size()]),
                                newRangeFromCharacter, character - 1));

                        newRangeFromCharacter = character;
                        newRangeActions = actionsForCharacter;
                    }
                } else { // A new range starts at the current character
                    newRangeFromCharacter = character;
                    newRangeActions = actionsForCharacter;
                }

                if(character == CharacterClassFactory.EOF_INT && newRangeFromCharacter != -1) {
                    actionsForRanges
                        .add(new ActionsForRange(newRangeActions.toArray(new IAction[newRangeActions.size()]),
                            newRangeFromCharacter, character));
                }
            }
        }

        return actionsForRanges.toArray(new ActionsForRange[actionsForRanges.size()]);
    }

    @Override public IAction[] getActions() {
        List<IAction> res = new ArrayList<>();

        for(ActionsForRange actionsForRange : actionsForSortedDisjointRanges) {
            for(IAction action : actionsForRange.actions)
                res.add(action);
        }

        return res.toArray(new IAction[res.size()]);
    }

    @Override public Iterable<IAction> getApplicableActions(IActionQuery actionQuery) {
        if(actionsForSortedDisjointRanges.length > 0) {
            int low = 0, high = actionsForSortedDisjointRanges.length - 1;

            while(low <= high) {
                int mid = (low + high) / 2;

                ActionsForRange actionsForMidRange = actionsForSortedDisjointRanges[mid];

                int currentChar = actionQuery.actionQueryCharacter();

                if(actionsForMidRange.from <= currentChar && currentChar <= actionsForMidRange.to)
                    return actionsForMidRange.getApplicableActions(actionQuery);
                else if(currentChar < actionsForMidRange.from)
                    high = mid - 1;
                else if(actionsForMidRange.to < currentChar)
                    low = mid + 1;
                else
                    break;
            }
        }

        return Collections.emptyList();
    }

    @Override public Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery) {
        if(actionsForSortedDisjointRanges.length > 0) {
            int low = 0, high = actionsForSortedDisjointRanges.length - 1;
            int currentChar = actionQuery.actionQueryCharacter();

            while(low <= high) {
                int mid = (low + high) / 2;

                ActionsForRange actionsForMidRange = actionsForSortedDisjointRanges[mid];

                if(actionsForMidRange.from <= currentChar && currentChar <= actionsForMidRange.to)
                    return actionsForMidRange.getApplicableReduceActions(actionQuery);
                else if(currentChar < actionsForMidRange.from)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return Collections.emptyList();
    }

}
