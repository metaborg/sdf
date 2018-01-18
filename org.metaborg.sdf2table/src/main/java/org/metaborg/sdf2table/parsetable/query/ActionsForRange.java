package org.metaborg.sdf2table.parsetable.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import org.metaborg.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.IParseInput;
import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

public class ActionsForRange implements Serializable {

    private static final long serialVersionUID = -1143306908480814413L;

    public final IAction[] actions;
    public final int from, to;

    public ActionsForRange(IAction[] actions, int from, int to) {
        this.actions = actions;
        this.from = from;
        this.to = to;
    }

    public final Iterable<IAction> getApplicableActions(IParseInput parseInput) {
        return () -> new Iterator<IAction>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                while(index < actions.length && !IAction.allowsLookahead(actions[index], parseInput)) {
                    index++;
                }
                return index < actions.length;
            }

            @Override
            public IAction next() {
                return actions[index++];
            }
        };
    }

    public final Iterable<IReduce> getApplicableReduceActions(IParseInput parseInput) {
        return () -> new Iterator<IReduce>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                while(index < actions.length && !IAction.isApplicableReduce(actions[index], parseInput)) {
                    index++;
                }
                return index < actions.length;
            }

            @Override
            public IReduce next() {
                return (IReduce) actions[index++];
            }
        };
    }

    @Override
    public String toString() {
        return "{" + CharacterClassFactory.intToString(from) + "," + CharacterClassFactory.intToString(to) + "}->"
            + Arrays.toString(actions);
    }

}
