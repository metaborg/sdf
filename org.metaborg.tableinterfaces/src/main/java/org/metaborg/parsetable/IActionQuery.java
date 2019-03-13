package org.metaborg.parsetable;

public interface IActionQuery {

    /**
     * The lookahead character to query actions for.
     */
    int actionQueryCharacter();

    /**
     * Retrieve lookahead with a given length for the current action query. During a parse round, when a character is
     * shifted, that character is the actual first character of lookahead (as returned by actionQueryCharacter). The
     * lookahead returned by this function starts after that character.
     */
    String actionQueryLookahead(int length);

}
