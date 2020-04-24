package org.metaborg.parsetable.characterclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

/**
 * Unicode characters: integer representation [0, 0x10ffff]
 *
 * End-of-file marker (EOF): integer representation -1
 */
public interface ICharacterClass {

    int EOF_INT = -1;
    int MAX_CHAR = 0x10ffff;
    int CHARACTERS = MAX_CHAR + 1;

    boolean contains(int character);

    int min();

    int max();

    boolean isEmpty();

    /** Does not include EOF */
    int[] getRanges();

    /**
     * @return A character class that is equal to this character class, except that `eof` is set as given.<br>
     *         May return `this` if there are no changes.
     */
    ICharacterClass setEOF(boolean eof);

    /**
     * @return The union of characters in character classes this and other.
     */
    ICharacterClass union(ICharacterClass other);

    /**
     * @return The intersection of characters in character classes this and other.
     */
    ICharacterClass intersection(ICharacterClass other);

    /**
     * @return The difference of characters in character classes this and other.
     */
    ICharacterClass difference(ICharacterClass other);

    static Comparator<ICharacterClass> comparator() {
        return Comparator.comparingInt(ICharacterClass::min);
    }

    static boolean disjointSortable(List<ICharacterClass> original) {
        List<ICharacterClass> sorted = new ArrayList<>(original);

        Collections.sort(sorted, comparator());

        return disjointSorted(sorted);
    }

    /**
     * @return true if each character class only contains characters bigger than the characters in the previous
     *         character class.
     */
    static boolean disjointSorted(List<ICharacterClass> characterClasses) {
        for(int i = 0; i < characterClasses.size() - 1; i++) {
            if(characterClasses.get(i).max() >= characterClasses.get(i + 1).min())
                return false;
        }

        return true;
    }

    default IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("char-class", 1), toAtermList(tf));
    }

    IStrategoTerm toAtermList(ITermFactory tf);

    @Override boolean equals(Object obj);

    @Override int hashCode();

}
