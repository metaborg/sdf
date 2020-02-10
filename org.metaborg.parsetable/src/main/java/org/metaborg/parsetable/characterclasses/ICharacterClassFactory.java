package org.metaborg.parsetable.characterclasses;

public interface ICharacterClassFactory {

    ICharacterClass fromEmpty();

    ICharacterClass fromSingle(int character);

    /**
     * @param from
     *            The start of the range, inclusive.
     * @param to
     *            The end of the range, inclusive.
     * @return A character class representing the range [from-to].
     */
    ICharacterClass fromRange(int from, int to);

    /*
     * Character classes in the parse table can be composed by taking the union of multiple character classes. This
     * method is called after these operations on the result, e.g. to do optimizations.
     */
    ICharacterClass finalize(ICharacterClass characterClass);

}
