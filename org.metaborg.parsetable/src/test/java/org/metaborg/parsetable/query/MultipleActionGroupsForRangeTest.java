package org.metaborg.parsetable.query;

import static org.junit.Assert.assertEquals;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.CHARACTERS;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IShift;
import org.metaborg.parsetable.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;

public class MultipleActionGroupsForRangeTest {

    ICharacterClassFactory characterClassFactory = new CharacterClassFactory();

    ICharacterClass AZ = characterClassFactory.fromRange(65, 90);
    ICharacterClass az = characterClassFactory.fromRange(97, 122);

    ICharacterClass ab = characterClassFactory.fromRange(97, 98);
    ICharacterClass bc = characterClassFactory.fromRange(98, 99);

    ICharacterClass a = characterClassFactory.fromSingle(97);
    ICharacterClass b = characterClassFactory.fromSingle(98);
    ICharacterClass ce = characterClassFactory.fromRange(99, 101);
    ICharacterClass f = characterClassFactory.fromSingle(102);
    ICharacterClass gz = characterClassFactory.fromRange(103, 122);

    ICharacterClass eof = characterClassFactory.fromSingle(EOF_INT);

    IShift shift1 = () -> 1;
    IShift shift2 = () -> 2;
    IShift shift3 = () -> 3;

    IShift shift13 = () -> 13;
    IShift shift14 = () -> 14;
    IShift shift15 = () -> 15;

    @Test public void testSingleOverlap() {
        ActionsPerCharacterClass[] actionsPerCharacterClasses = new ActionsPerCharacterClass[] { //
            new ActionsPerCharacterClass(ab, new IAction[] { shift1, shift2 }),
            new ActionsPerCharacterClass(bc, new IAction[] { shift2, shift3 }) };

        test(actionsPerCharacterClasses);
    }

    @Test public void testDisjointRanges() {
        ICharacterClass union = a.union(ce).union(gz);
        ActionsPerCharacterClass[] actionsPerCharacterClasses = new ActionsPerCharacterClass[] { //
            new ActionsPerCharacterClass(union, new IAction[] { shift13 }),
            new ActionsPerCharacterClass(b, new IAction[] { shift14 }),
            new ActionsPerCharacterClass(f, new IAction[] { shift15 }) };

        test(actionsPerCharacterClasses);
    }

    @Test public void testMultipleOverlap() {
        ActionsPerCharacterClass[] actionsPerCharacterClasses = new ActionsPerCharacterClass[] { //
            new ActionsPerCharacterClass(az, new IAction[] { shift13 }),
            new ActionsPerCharacterClass(b, new IAction[] { shift14 }),
            new ActionsPerCharacterClass(f, new IAction[] { shift15 }) };

        test(actionsPerCharacterClasses);
    }

    @Test public void testEOF() {
        ActionsPerCharacterClass[] actionsPerCharacterClasses = new ActionsPerCharacterClass[] { //
            new ActionsPerCharacterClass(eof, new IAction[] { shift13 }),
            new ActionsPerCharacterClass(AZ, new IAction[] { shift14 }),
            new ActionsPerCharacterClass(az, new IAction[] { shift15 }) };

        test(actionsPerCharacterClasses);
    }

    public void test(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        IActionsForCharacter separated = new ActionsForCharacterSeparated(actionsPerCharacterClasses);
        IActionsForCharacter disjointSorted = new ActionsForCharacterDisjointSorted(actionsPerCharacterClasses);

        for(int character = 0; character < CHARACTERS; character++) {
            IActionQuery actionQuery = new MockActionQuery(character);

            Set<IAction> actionForSeparated = iterableToSet(separated.getApplicableActions(actionQuery));
            Set<IAction> actionForDisjointSorted = iterableToSet(disjointSorted.getApplicableActions(actionQuery));

            assertEquals("Action sets not equal for character " + character, actionForSeparated,
                actionForDisjointSorted);
        }

        IActionQuery actionQuery = new MockActionQuery(EOF_INT);

        Set<IAction> actionForSeparated = iterableToSet(separated.getApplicableActions(actionQuery));
        Set<IAction> actionForDisjointSorted = iterableToSet(disjointSorted.getApplicableActions(actionQuery));

        assertEquals("Action sets not equal for EOF", actionForSeparated, actionForDisjointSorted);
    }

    private <T> Set<T> iterableToSet(Iterable<T> iterable) {
        Set<T> set = new HashSet<>();

        for(T t : iterable)
            set.add(t);

        return set;
    }

    private static class MockActionQuery implements IActionQuery {

        private final int character;

        MockActionQuery(int character) {
            this.character = character;
        }

        @Override public int actionQueryCharacter() {
            return character;
        }

        @Override public int[] actionQueryLookahead(int length) {
            return new int[0];
        }
    }
}
