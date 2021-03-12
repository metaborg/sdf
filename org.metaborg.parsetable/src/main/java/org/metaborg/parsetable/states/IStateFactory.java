package org.metaborg.parsetable.states;

import java.util.Set;

import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.parsetable.query.ActionsPerCharacterClass;

public interface IStateFactory {

    IState from(int stateId, IGoto[] gotos, ActionsPerCharacterClass[] actions, Set<Integer> recoveryStateIds);

}
