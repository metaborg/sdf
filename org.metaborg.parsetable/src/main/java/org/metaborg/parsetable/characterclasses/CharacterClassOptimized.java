package org.metaborg.parsetable.characterclasses;

import java.io.Serializable;
import java.util.Arrays;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public final class CharacterClassOptimized implements ICharacterClass, Serializable {

    private static final long serialVersionUID = -7493425262859611574L;

    // Note that the entries in the `words` array should be immutable as well, but Java doesn't allow that
    private final long[] words; // [0-63], [64-127], [128-191], [192-255]
    private final boolean containsEOF; // [256]

    private final int min, max;

    public CharacterClassOptimized(long[] words, boolean containsEOF, int min, int max) {
        if(words.length != 4)
            throw new IllegalStateException("The words array should have length 4");

        if(words[0] == 0 && words[1] == 0 && words[2] == 0 && words[3] == 0 && !containsEOF)
            throw new IllegalStateException("Empty character classes are not allowed");

        this.words = words;
        this.containsEOF = containsEOF;
        this.min = min;
        this.max = max;
    }

    @Override public final boolean contains(int character) {
        if(character == ICharacterClass.EOF_INT)
            return containsEOF;

        final int wordIndex = character >> CharacterClassRangeSet.BITMAP_SEGMENT_SIZE;
        if(wordIndex < 0 || wordIndex > 3)
            return false;

        final long word = words[wordIndex];
        return (word & (1L << character)) != 0;
    }

    @Override public int min() {
        return min;
    }

    @Override public int max() {
        return max;
    }

    @Override public boolean isEmpty() {
        return false;
    }

    @Override public ICharacterClass setEOF(boolean eof) {
        throw new IllegalStateException("CharacterClassOptimized is not mutable");
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        throw new IllegalStateException("Union can only be done with Single and RangeSet character classes");
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        throw new IllegalStateException("Intersection can only be done with Single and RangeSet character classes");
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        throw new IllegalStateException("Difference can only be done with Single and RangeSet character classes");
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) {
        throw new IllegalStateException("Optimized character class cannot be converted to ATerm");
    }

    @Override public int hashCode() {
        return (int) (words[0] ^ words[1] ^ words[2] ^ words[3] ^ Boolean.hashCode(containsEOF));
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        CharacterClassOptimized that = (CharacterClassOptimized) o;

        return Arrays.equals(this.words, that.words) && containsEOF == that.containsEOF;
    }

    @Override public final String toString() {
        // This is an optimized representation of character classes. If you want nice toString results, disable
        // optimizing in CharacterClassFactory.

        return "[...optimized-character-class...]";
    }

}
