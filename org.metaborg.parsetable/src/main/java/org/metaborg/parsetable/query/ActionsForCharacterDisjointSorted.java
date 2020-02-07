package org.metaborg.parsetable.query;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.CHARACTERS;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

import java.io.Serializable;
import java.util.*;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

public final class ActionsForCharacterDisjointSorted implements IActionsForCharacter, Serializable {

    private static final long serialVersionUID = -619727965728365810L;

    private final ActionsForRange actionsForEOF;
    private final ActionsForRange[] actionsForSortedDisjointRanges;

    public ActionsForCharacterDisjointSorted(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        this.actionsForSortedDisjointRanges = toDisjointSortedRanges(actionsPerCharacterClasses);
        this.actionsForEOF = new ActionsForRange(
            getActionsForCharacter(actionsPerCharacterClasses, EOF_INT).toArray(new IAction[0]), EOF_INT, EOF_INT);
    }

    public static ActionsForRange[] toDisjointSortedRanges(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        List<ActionsForRange> actionsForRanges = new ArrayList<>();

        int newRangeFromCharacter = -1; // Contains the start character for the next range that will be added
        Set<IAction> newRangeActions = null; // Contains the actions for the next range that will be added

        for(int character = 0; character < CHARACTERS; character++) {
            Set<IAction> actionsForCharacter = getActionsForCharacter(actionsPerCharacterClasses, character);

            /*
             * Based on the applicable actions for the current character and if a new range already started before: do
             * nothing, create the range that was already started, start a new range or both of the latter.
             */
            if(actionsForCharacter.isEmpty()) {
                if(newRangeFromCharacter != -1) { // A range ended on the previous character
                    actionsForRanges.add(new ActionsForRange(newRangeActions.toArray(new IAction[0]),
                        newRangeFromCharacter, character - 1));

                    newRangeFromCharacter = -1;
                    newRangeActions = null;
                } // else { /* no current range is maintained, so nothing changes */ }
            } else {
                if(newRangeFromCharacter != -1) {
                    if(!actionsForCharacter.equals(newRangeActions)) { // Different actions, thus a range ended on the
                                                                       // previous character and a new one starts at the
                                                                       // current character
                        actionsForRanges.add(new ActionsForRange(newRangeActions.toArray(new IAction[0]),
                            newRangeFromCharacter, character - 1));

                        newRangeFromCharacter = character;
                        newRangeActions = actionsForCharacter;
                    } // else { /* same actions, so maintain current range */ }
                } else { // A new range starts at the current character
                    newRangeFromCharacter = character;
                    newRangeActions = actionsForCharacter;
                }
            }
        }

        // If we still have a range after processing all characters, add it
        if(newRangeFromCharacter != -1) {
            actionsForRanges
                .add(new ActionsForRange(newRangeActions.toArray(new IAction[0]), newRangeFromCharacter, CHARACTERS));
        }

        return actionsForRanges.toArray(new ActionsForRange[0]);
    }

    private static Set<IAction> getActionsForCharacter(ActionsPerCharacterClass[] actionsPerCharacterClasses,
        int character) {
        Set<IAction> actionsForCharacter = new HashSet<>();

        for(ActionsPerCharacterClass actionsPerCharacterClass : actionsPerCharacterClasses) {
            if(actionsPerCharacterClass.appliesTo(character)) {
                actionsForCharacter.addAll(actionsPerCharacterClass.actions);
            }
        }

        return actionsForCharacter;
    }

    @Override public IAction[] getActions() {
        List<IAction> res = new ArrayList<>();

        for(ActionsForRange actionsForRange : actionsForSortedDisjointRanges) {
            Collections.addAll(res, actionsForRange.actions);
        }
        Collections.addAll(res, actionsForEOF.actions);

        return res.toArray(new IAction[0]);
    }

    @Override public Iterable<IAction> getApplicableActions(IActionQuery actionQuery) {
        if(actionQuery.actionQueryCharacter() == EOF_INT)
            return actionsForEOF.getApplicableActions(actionQuery);

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
                else
                    low = mid + 1;
            }
        }

        return Collections.emptyList();
    }

    @Override public Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery) {
        if(actionQuery.actionQueryCharacter() == EOF_INT)
            return actionsForEOF.getApplicableReduceActions(actionQuery);

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
