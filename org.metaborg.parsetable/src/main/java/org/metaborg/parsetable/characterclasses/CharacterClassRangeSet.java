package org.metaborg.parsetable.characterclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.*;

public final class CharacterClassRangeSet implements ICharacterClass, Serializable {

    private static final long serialVersionUID = 8553734625129300348L;

    static final int BITMAP_SEGMENT_SIZE = 6; // 2^6 = 64 = 1/4 * 256
    static final long[] EMPTY_WORDS_ARRAY = new long[4];
    static final CharacterClassRangeSet EMPTY_CONSTANT = new CharacterClassRangeSet();

    private final ImmutableRangeSet<Integer> rangeSet; // Contains ranges in range [0, 255]
    private final int min, max;

    // Note that the entries in the `words` array should be immutable as well, but Java doesn't allow that
    private final long[] words; // [0-63], [64-127], [128-191], [192-255]
    private final boolean containsEOF; // [256]

    private CharacterClassRangeSet() {
        this(ImmutableRangeSet.copyOf(TreeRangeSet.create()), false);
    }

    private CharacterClassRangeSet(final ImmutableRangeSet<Integer> rangeSet, boolean containsEOF) {
        assert rangeSet.isEmpty() || rangeSet.span().lowerEndpoint() >= 0;
        assert rangeSet.isEmpty() || rangeSet.span().upperEndpoint() < EOF_INT;

        if(rangeSet.isEmpty()) {
            this.min = this.max = containsEOF ? EOF_INT : -1;
        } else {
            this.min = rangeSet.span().lowerEndpoint();
            this.max = Math.max(rangeSet.span().upperEndpoint(), containsEOF ? EOF_INT : -1);
        }

        this.rangeSet = rangeSet;
        this.containsEOF = containsEOF;

        if(this.rangeSet.isEmpty())
            this.words = EMPTY_WORDS_ARRAY;
        else
            this.words = Arrays.copyOf(convertToBitSet().toLongArray(), 4);
    }

    @Override public final boolean contains(int character) {
        if(character == EOF_INT)
            return containsEOF;

        if(rangeSet.isEmpty()) // In this case, all cached words are empty as well, so no need to check them
            return false;

        final int wordIndex = character >> BITMAP_SEGMENT_SIZE;
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
        return Arrays.equals(words, EMPTY_WORDS_ARRAY) && !containsEOF;
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        if(other instanceof CharacterClassSingle)
            return addSingle(other.min());

        if(other instanceof CharacterClassRangeSet) {
            final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create();
            CharacterClassRangeSet otherRangeSet = (CharacterClassRangeSet) other;

            mutableRangeSet.addAll(this.rangeSet);
            mutableRangeSet.addAll(otherRangeSet.rangeSet);

            boolean containsEOF = this.containsEOF || otherRangeSet.containsEOF;

            return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF);
        }

        throw new IllegalStateException("Union can only be done with Single and RangeSet character classes");
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        if(other instanceof CharacterClassSingle)
            if(contains(other.min()))
                return other;
            else
                return EMPTY_CONSTANT;

        if(other instanceof CharacterClassRangeSet) {
            final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create();
            CharacterClassRangeSet otherRangeSet = (CharacterClassRangeSet) other;

            for(Range<Integer> range : this.rangeSet.asRanges()) {
                mutableRangeSet.addAll(otherRangeSet.rangeSet.subRangeSet(range));
            }

            boolean containsEOF = this.containsEOF && otherRangeSet.containsEOF;

            return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF);
        }

        throw new IllegalStateException("Intersection can only be done with Single and RangeSet character classes");
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        if(other instanceof CharacterClassSingle)
            return removeSingle(other.min());

        if(other instanceof CharacterClassRangeSet) {
            final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create();
            CharacterClassRangeSet otherRangeSet = (CharacterClassRangeSet) other;

            mutableRangeSet.addAll(this.rangeSet);
            mutableRangeSet.removeAll(otherRangeSet.rangeSet);

            boolean containsEOF = this.containsEOF && !otherRangeSet.containsEOF;

            return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF);
        }

        throw new IllegalStateException("Difference can only be done with Single and RangeSet character classes");
    }

    protected final CharacterClassRangeSet addRange(int from, int to) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create(rangeSet);

        mutableRangeSet.add(Range.closed(from, Math.min(255, to)));

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF || to == EOF_INT);
    }

    protected final CharacterClassRangeSet addSingle(int character) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create(rangeSet);

        if(character < EOF_INT)
            mutableRangeSet.add(Range.singleton(character));

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet),
            containsEOF || character == EOF_INT);
    }

    protected final CharacterClassRangeSet removeSingle(int character) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create(rangeSet);

        if(character < EOF_INT)
            mutableRangeSet.remove(Range.open(character - 1, character + 1));

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet),
            containsEOF && character != EOF_INT);
    }

    private final BitSet convertToBitSet() {
        if(rangeSet.isEmpty()) {
            return new BitSet();
        }

        final BitSet bitSet = new BitSet(rangeSet.span().upperEndpoint());

        for(Range<Integer> range : rangeSet.asRanges()) {
            Range<Integer> canonical = range.canonical(DiscreteDomain.integers());
            if(!canonical.isEmpty()) {
                bitSet.set(canonical.lowerEndpoint(), canonical.upperEndpoint());
            }
        }

        return bitSet;
    }

    public final ICharacterClass optimized() {
        if(rangeSet.isEmpty())
            if(containsEOF)
                return CharacterClassFactory.EOF_SINGLETON;
            else
                throw new IllegalStateException("Empty character classes are not allowed");

        // Reduce to single character, this is possible when it does not contain EOF and the canonical span is [x,x+1)
        if(!containsEOF) {
            Range<Integer> span = rangeSet.span().canonical(DiscreteDomain.integers());
            if(span.lowerEndpoint() == span.upperEndpoint() - 1)
                return new CharacterClassSingle(span.lowerEndpoint());
        }

        return new CharacterClassOptimized(words, containsEOF, min, max);
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) {
        List<IStrategoTerm> terms = new ArrayList<>();
        boolean hasEOF = false;
        for(Range<Integer> range : rangeSet.asRanges()) {
            // In a RangeSet, ranges are represented using mixed open and closed boundaries.
            // Converting to canonical will always return a range of the form [x,y).
            Range<Integer> canonical = range.canonical(DiscreteDomain.integers());
            if(canonical.isEmpty()) {
                continue;
            }

            int from = canonical.lowerEndpoint();
            int to = canonical.upperEndpoint() - 1;

            if(containsEOF && to == EOF_INT - 1) {
                // Make EOF (256) be included in the range if it ends with 255
                to++;
                hasEOF = true;
            }

            if(from == to)
                terms.add(tf.makeInt(from));
            else
                terms.add(tf.makeAppl(tf.makeConstructor("range", 2), tf.makeInt(from), tf.makeInt(to)));
        }

        if(containsEOF && !hasEOF)
            terms.add(tf.makeInt(EOF_INT));

        return tf.makeList(terms);
    }

    @Override public int hashCode() {
        return rangeSet.hashCode() ^ Boolean.hashCode(containsEOF);
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o instanceof CharacterClassSingle) {
            if(this.min == this.max && this.min == ((CharacterClassSingle) o).min()) {
                return true;
            } else {
                return false;
            }
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        CharacterClassRangeSet that = (CharacterClassRangeSet) o;

        return rangeSet.equals(that.rangeSet) && containsEOF == that.containsEOF;
    }

    @Override public String toString() {
        final List<String> ranges = new ArrayList<>();

        for(Range<Integer> range : rangeSet.asRanges()) {
            Range<Integer> canonical = range.canonical(DiscreteDomain.integers());
            if(canonical.isEmpty()) {
                continue;
            }

            final int from = canonical.lowerEndpoint();
            final int to = canonical.upperEndpoint() - 1;

            if(from != to)
                ranges.add("" + from + "-" + to);
            else
                ranges.add("" + from);
        }

        if(containsEOF)
            ranges.add("EOF");

        return "[" + String.join(",", ranges) + "]";
    }

}
