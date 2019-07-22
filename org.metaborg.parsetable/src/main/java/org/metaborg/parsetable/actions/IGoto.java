package org.metaborg.parsetable.actions;

/*
 * Represents the goto state for a set of productions.
 */
public interface IGoto {

    int[] productionIds();

    int gotoStateId();

}
