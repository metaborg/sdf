package org.metaborg.sdf2table.parsetable.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

/*
 * Groups a set of actions that are applicable to a single character class. This is the representation that maps
 * one-on-one to the representation from the original ATerm parse table format.
 */
public final class ActionsPerCharacterClass implements Serializable {

    private static final long serialVersionUID = -210867626533381716L;

    public final ICharacterClass characterClass;
    public final List<IAction> actions;

    public ActionsPerCharacterClass(ICharacterClass characterClass, IAction[] actions) {
        this.characterClass = characterClass;
        this.actions = Arrays.asList(actions);
    }

    public final boolean appliesTo(int character) {
        return characterClass.contains(character);
    }

    @Override
    public String toString() {
        return characterClass.toString() + "->" + actions.toString();
    }

}
