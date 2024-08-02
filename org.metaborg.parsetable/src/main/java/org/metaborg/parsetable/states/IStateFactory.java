package org.metaborg.parsetable.states;

import java.util.Set;

import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.parsetable.query.ActionsPerCharacterClass;

public interface IStateFactory {

    IMutableState from(int stateId, IGoto[] gotos, ActionsPerCharacterClass[] actions, Set<Integer> recoveryStateIds);

}
