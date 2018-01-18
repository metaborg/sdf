package org.metaborg.sdf2table.parsetable.query;

import java.io.Serializable;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

/*
 * Basically a tuple of a character class and an action.
 */
public final class ActionForCharacterClass implements Serializable {

    private static final long serialVersionUID = 7681264059515606288L;

    public final ICharacterClass characterClass;
    public final IAction action;

    public ActionForCharacterClass(ICharacterClass characterClass, IAction action) {
        this.characterClass = characterClass;
        this.action = action;
    }

    public final boolean appliesTo(int character) {
        return characterClass.contains(character);
    }

    @Override
    public String toString() {
        return characterClass.toString() + "->" + action.toString();
    }

}
