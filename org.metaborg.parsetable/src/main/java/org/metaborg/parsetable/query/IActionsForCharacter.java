package org.metaborg.parsetable.query;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IReduce;

public interface IActionsForCharacter {

    /*
     * Returns all actions. Only used during parse table loading for marking rejectable states, thus the implementation
     * of this method does not influence parsing performance.
     */
    IAction[] getActions();

    /*
     * Returns actions applicable to the given configuration (i.e. current character and lookahead) and parsing mode.
     */
    Iterable<IAction> getApplicableActions(IActionQuery actionQuery, ParsingMode parsingMode);

    /*
     * Returns reduce actions (possibly with lookahead) applicable to the given configuration (i.e. current character
     * and lookahead) and parsing mode.
     */
    Iterable<IReduce> getApplicableReduceActions(IActionQuery actionQuery, ParsingMode parsingMode);

}