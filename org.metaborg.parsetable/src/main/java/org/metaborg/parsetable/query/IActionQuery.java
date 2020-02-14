package org.metaborg.parsetable.query;

public interface IActionQuery {

    /**
     * The lookahead character to query actions for.
     */
    int actionQueryCharacter();

    /**
     * Retrieve lookahead with a given length for the current action query. During a parse round, when a character is
     * shifted, that character is the actual first character of lookahead (as returned by actionQueryCharacter). The
     * lookahead returned by this function starts after that character.
     *
     * If the remaining input is shorter than the requested length, the returned array will be shorter than this length.
     */
    int[] actionQueryLookahead(int length);

}
