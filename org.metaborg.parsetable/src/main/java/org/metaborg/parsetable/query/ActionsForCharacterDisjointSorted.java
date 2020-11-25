package org.metaborg.parsetable.query;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

import java.io.Serializable;
import java.util.*;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

public final class ActionsForCharacterDisjointSorted implements IActionsForCharacter, Serializable {

    private static final long serialVersionUID = -619727965728365810L;

    private final ActionsForRange actionsForEOF;
    private final ActionsForRange[] actionsForSortedDisjointRanges;
    private final ActionsForRange[] recoveryActionsForSortedDisjointRanges;

    public ActionsForCharacterDisjointSorted(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        this.actionsForSortedDisjointRanges =
            toDisjointSortedRanges(filterNonRecoveryActions(actionsPerCharacterClasses));
        this.recoveryActionsForSortedDisjointRanges = toDisjointSortedRanges(actionsPerCharacterClasses);
        this.actionsForEOF =
            new ActionsForRange(getActionsForEOF(actionsPerCharacterClasses).toArray(new IAction[0]), EOF_INT, EOF_INT);
    }

    public static ActionsForRange[] toDisjointSortedRanges(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        List<ActionsForRange> actionsForRanges = new ArrayList<>();

        int[][] ranges = new int[actionsPerCharacterClasses.length][];
        for(int i = 0; i < ranges.length; i++) {
            ranges[i] = actionsPerCharacterClasses[i].characterClass.getRanges();
        }
        int[] indices = new int[ranges.length];
        Multiset<IAction> newRangeActions = HashMultiset.create();

        int previous = 0;
        int minIndex;
        while((minIndex = getMinIndex(ranges, indices)) != -1) {
            int j = indices[minIndex]++;
            int currChar = ranges[minIndex][j] + (j & 1); // If j is odd, add one
            assert currChar >= previous;
            if(currChar > previous) {
                // Finish current range
                if(!newRangeActions.isEmpty()) {
                    actionsForRanges.add(new ActionsForRange(newRangeActions.elementSet().toArray(new IAction[0]),
                        previous, currChar - 1));
                }
                // Start a new range
                previous = currChar;
            }
            if((j & 1) == 0) // We're currently at the start of the range; add actions
                newRangeActions.addAll(actionsPerCharacterClasses[minIndex].actions);
            else // We're currently after the end of the range; remove actions
                Multisets.removeOccurrences(newRangeActions, actionsPerCharacterClasses[minIndex].actions);
        }

        assert newRangeActions.isEmpty();

        return actionsForRanges.toArray(new ActionsForRange[0]);
    }

    private static int getMinIndex(int[][] ranges, int[] indices) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < ranges.length; i++) {
            int j = indices[i];
            if(j < ranges[i].length) {
                int curr = ranges[i][j] + (j & 1); // If j is odd, add one
                if(curr < min) {
                    min = curr;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    private static Set<IAction> getActionsForEOF(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        Set<IAction> actionsForCharacter = new HashSet<>();

        for(ActionsPerCharacterClass actionsPerCharacterClass : actionsPerCharacterClasses) {
            if(actionsPerCharacterClass.appliesTo(EOF_INT)) {
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

    @Override public Iterable<IAction> getApplicableActions(IActionQuery actionQuery, ParsingMode parsingMode) {
        if(actionQuery.actionQueryCharacter() == EOF_INT)
            return actionsForEOF.getApplicableActions(actionQuery);

        ActionsForRange[] actions = parsingMode == ParsingMode.Recovery ? recoveryActionsForSortedDisjointRanges
            : actionsForSortedDisjointRanges;

        if(actions.length > 0) {
            int low = 0, high = actions.length - 1;

            while(low <= high) {
                int mid = (low + high) / 2;

                ActionsForRange actionsForMidRange = actions[mid];

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

    @Override public Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery, ParsingMode parsingMode) {
        if(actionQuery.actionQueryCharacter() == EOF_INT)
            return actionsForEOF.getApplicableReduceActions(actionQuery);

        ActionsForRange[] actions = parsingMode == ParsingMode.Recovery ? recoveryActionsForSortedDisjointRanges
            : actionsForSortedDisjointRanges;

        if(actions.length > 0) {
            int low = 0, high = actions.length - 1;
            int currentChar = actionQuery.actionQueryCharacter();

            while(low <= high) {
                int mid = (low + high) / 2;

                ActionsForRange actionsForMidRange = actions[mid];

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
