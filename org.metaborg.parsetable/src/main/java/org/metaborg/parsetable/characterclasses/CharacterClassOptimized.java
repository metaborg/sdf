package org.metaborg.parsetable.characterclasses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public final class CharacterClassOptimized implements ICharacterClass, Serializable {

    private static final long serialVersionUID = -7493425262859611574L;

    static final int BITMAP_SIZE = 256;
    static final int BITMAP_SEGMENT_SIZE = 6; // 2^6 = 64 = 1/4 * 256

    static final CharacterClassRangeList OPTIMIZED_RANGE =
        new CharacterClassRangeList(new int[] { 0, BITMAP_SIZE - 1 }, false);

    // Note that the entries in the `words` array should be immutable as well, but Java doesn't allow that
    private final long[] words; // [0-63], [64-127], [128-191], [192-255]
    private final int[] originalRanges;
    private final int[] optimizedRanges;
    private final boolean containsEOF;

    private final int min, max;

    public CharacterClassOptimized(CharacterClassRangeList cc) {
        if(cc.isEmpty())
            throw new IllegalStateException("Empty character classes are not allowed");

        this.originalRanges = cc.getRanges();
        if(originalRanges.length == 0) {
            this.words = new long[0];
        } else {
            BitSet bitSet = new BitSet(BITMAP_SIZE);
            for(int i = 0; i < originalRanges.length && originalRanges[i] < BITMAP_SIZE; i += 2) {
                bitSet.set(originalRanges[i], Integer.min(BITMAP_SIZE, originalRanges[i + 1] + 1));
            }
            this.words = bitSet.toLongArray();
            assert this.words.length <= (BITMAP_SIZE >> BITMAP_SEGMENT_SIZE);
        }

        if(this.words.length == 0)
            this.optimizedRanges = originalRanges;
        else
            this.optimizedRanges = cc.difference(OPTIMIZED_RANGE).getRanges();

        this.containsEOF = cc.contains(EOF_INT);
        this.min = cc.min();
        this.max = cc.max();
    }

    @Override public final boolean contains(int character) {
        // NOTE: we are exploiting the fact that EOF_INT is equal to -1.
        // This method will also return `containsEOF` for any other negative number, but that will never happen.
        if(character <= EOF_INT)
            return containsEOF;

        final int wordIndex = character >> BITMAP_SEGMENT_SIZE;
        if(wordIndex < words.length)
            return (words[wordIndex] & (1L << (character & 0x3f))) != 0;

        if(optimizedRanges.length == 0 || character < optimizedRanges[0]
            || character > optimizedRanges[optimizedRanges.length - 1])
            return false;
        if(optimizedRanges.length == 2)
            return optimizedRanges[0] <= character && character <= optimizedRanges[1];

        int low = 0, high = optimizedRanges.length - 1, mid = -1;
        while(low < high) {
            mid = (low + high) / 2;
            if(character < optimizedRanges[mid])
                high = mid;
            else if(character >= optimizedRanges[mid + 1])
                low = mid + 1;
            else
                break;
        }
        return (mid & 1) == 0 // Return true if the current index is even
            || character == optimizedRanges[mid]; // or if the character is the end of a range (odd index)
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

    @Override public int[] getRanges() {
        return originalRanges;
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
        return Arrays.hashCode(originalRanges) ^ Boolean.hashCode(containsEOF);
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
