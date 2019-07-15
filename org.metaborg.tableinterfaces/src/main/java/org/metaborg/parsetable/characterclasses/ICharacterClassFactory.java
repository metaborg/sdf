package org.metaborg.parsetable.characterclasses;

public interface ICharacterClassFactory {

    ICharacterClass fromEmpty();

    ICharacterClass fromSingle(int character);

    ICharacterClass fromRange(int from, int to);

    /*
     * Character classes in the parse table can be composed by taking the union of multiple character classes. This
     * method is called after these operations on the result, e.g. to do optimizations.
     */
    ICharacterClass finalize(ICharacterClass characterClass);

}
