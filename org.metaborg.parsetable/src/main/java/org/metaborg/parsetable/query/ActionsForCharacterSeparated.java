package org.metaborg.parsetable.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

public final class ActionsForCharacterSeparated implements IActionsForCharacter, Serializable {

    private static final long serialVersionUID = -3200862105789432300L;

    private final ActionForCharacterClass[] actions;

    public ActionsForCharacterSeparated(ActionsPerCharacterClass[] actionsPerCharacterClasses) {
        List<ActionForCharacterClass> actionPerCharacterClasses = new ArrayList<>();

        for(ActionsPerCharacterClass actionsPerCharacterClass : actionsPerCharacterClasses) {
            for(IAction action : actionsPerCharacterClass.actions)
                actionPerCharacterClasses
                    .add(new ActionForCharacterClass(actionsPerCharacterClass.characterClass, action));
        }

        actions = new ActionForCharacterClass[actionPerCharacterClasses.size()];

        actionPerCharacterClasses.toArray(actions);
    }

    @Override
    public IAction[] getActions() {
        IAction[] res = new IAction[actions.length];

        for(int i = 0; i < actions.length; i++)
            res[i] = actions[i].action;

        return res;
    }

    @Override
    public Iterable<IAction> getApplicableActions(IActionQuery actionQuery) {
        return () -> new Iterator<IAction>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                while(index < actions.length && !(actions[index].appliesTo(actionQuery.actionQueryCharacter())
                    && actions[index].action.allowsLookahead(actionQuery))) {
                    index++;
                }
                return index < actions.length;
            }

            @Override
            public IAction next() {
                return actions[index++].action;
            }
        };
    }

    @Override
    public Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery) {
        return () -> new Iterator<IReduce>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                while(index < actions.length && !(actions[index].appliesTo(actionQuery.actionQueryCharacter())
                    && actions[index].action.isApplicableReduce(actionQuery))) {
                    index++;
                }
                return index < actions.length;
            }

            @Override
            public IReduce next() {
                return (IReduce) actions[index++].action;
            }
        };
    }

}
