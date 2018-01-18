package org.metaborg.characterclasses;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

public interface ICharacterClassFactory {

    ICharacterClass fromEmpty();

    ICharacterClass fromSingle(int character);

    ICharacterClass fromRange(int from, int to);

    /*
     * Returns the union of characters in character classes one and two
     */
    ICharacterClass union(ICharacterClass one, ICharacterClass two);
    
    /*
     * Returns the intersection of characters in character classes one and two
     */
    ICharacterClass intersection(ICharacterClass one, ICharacterClass two);
    
    /*
     * Returns the difference of characters in character classes one and two
     */
    ICharacterClass difference(ICharacterClass one, ICharacterClass two);

    /*
     * Character classes in the parse table can be composed by taking the union of multiple character classes. This
     * method is called after these operations on the result, e.g. to do optimizations.
     */
    ICharacterClass finalize(ICharacterClass characterClass);

}
