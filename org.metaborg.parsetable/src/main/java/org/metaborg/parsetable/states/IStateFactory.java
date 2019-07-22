package org.metaborg.parsetable.states;

import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.parsetable.query.ActionsPerCharacterClass;

public interface IStateFactory {

    IState from(int stateId, IGoto[] gotos, ActionsPerCharacterClass[] actions);

}
