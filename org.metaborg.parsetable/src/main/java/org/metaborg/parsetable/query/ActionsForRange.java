package org.metaborg.parsetable.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;
import org.metaborg.parsetable.characterclasses.CharacterClassFactory;

public class ActionsForRange implements Serializable {

    private static final long serialVersionUID = -1143306908480814413L;

    public final IAction[] actions;
    /** Both `from` and `to` are inclusive. */
    public final int from, to;

    public ActionsForRange(IAction[] actions, int from, int to) {
        this.actions = actions;
        this.from = from;
        this.to = to;
    }

    public final Iterable<IAction> getApplicableActions(IActionQuery actionQuery) {
        return () -> new Iterator<IAction>() {
            int index = 0;

            @Override public boolean hasNext() {
                while(index < actions.length && !actions[index].allowsLookahead(actionQuery)) {
                    index++;
                }
                return index < actions.length;
            }

            @Override public IAction next() {
                return actions[index++];
            }
        };
    }

    public final Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery) {
        return () -> new Iterator<IReduce>() {
            int index = 0;

            @Override public boolean hasNext() {
                while(index < actions.length && !actions[index].isApplicableReduce(actionQuery)) {
                    index++;
                }
                return index < actions.length;
            }

            @Override public IReduce next() {
                return (IReduce) actions[index++];
            }
        };
    }

    @Override public String toString() {
        return "{" + CharacterClassFactory.intToString(from) + "," + CharacterClassFactory.intToString(to) + "}->"
            + Arrays.toString(actions);
    }

}
