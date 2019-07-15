package org.metaborg.parsetable.query;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.metaborg.parsetable.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;
import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IShift;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

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

    IShift shift1 = () -> 1;
    IShift shift2 = () -> 2;
    IShift shift3 = () -> 3;

    IShift shift13 = () -> 13;
    IShift shift14 = () -> 14;
    IShift shift15 = () -> 15;

    @Test public void test1() {
        // @formatter:off
        ActionsPerCharacterClass[] actionsPerCharacterClasses =
            new ActionsPerCharacterClass[] {
                new ActionsPerCharacterClass(ab, new IAction[] { shift1, shift2 }),
                new ActionsPerCharacterClass(bc, new IAction[] { shift2, shift3 })
            };
        // @formatter:on

        test(actionsPerCharacterClasses);
    }

    @Test public void test2() {
        ICharacterClass union = a.union(ce).union(gz);
        // @formatter:off
        ActionsPerCharacterClass[] actionsPerCharacterClasses =
            new ActionsPerCharacterClass[] {
                new ActionsPerCharacterClass(union, new IAction[] { shift13 }),
                new ActionsPerCharacterClass(b, new IAction[] { shift15 }),
                new ActionsPerCharacterClass(f, new IAction[] { shift14 })
            };
        // @formatter:on

        test(actionsPerCharacterClasses);
    }

    public void test(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        IActionsForCharacter separated = new ActionsForCharacterSeparated(actionsPerCharacterClasses);
        IActionsForCharacter disjointSorted = new ActionsForCharacterDisjointSorted(actionsPerCharacterClasses);

        for(int character = 0; character <= CharacterClassFactory.EOF_INT; character++) {
            IActionQuery actionQuery = new MockActionQuery(character);

            Set<IAction> actionForSeparated = iterableToSet(separated.getApplicableActions(actionQuery));
            Set<IAction> actionForDisjointSorted = iterableToSet(disjointSorted.getApplicableActions(actionQuery));

            assertEquals("Action sets not equal for character " + character, actionForSeparated,
                actionForDisjointSorted);
        }
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

        @Override public String actionQueryLookahead(int length) {
            return "";
        }
    }
}
