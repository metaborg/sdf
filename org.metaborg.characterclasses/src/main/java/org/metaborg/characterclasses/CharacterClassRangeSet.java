package org.metaborg.characterclasses;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public final class CharacterClassRangeSet implements ICharacterClass, Serializable {

    private static final long serialVersionUID = 8553734625129300348L;

    protected static final int BITMAP_SEGMENT_SIZE = 6; // 2^6 = 64 = 1/4 * 256

    private ImmutableRangeSet<Integer> rangeSet; // Contains ranges in range [0, 255]
    private int min, max;

    private final boolean useCachedBitSet;
    private long word0; // [0, 63]
    private long word1; // [64, 127]
    private long word2; // [128, 191]
    private long word3; // [192, 255]
    private boolean containsEOF; // [256]

    static final CharacterClassRangeSet EMPTY_CONSTANT = new CharacterClassRangeSet();

    private CharacterClassRangeSet() {
        this(ImmutableRangeSet.copyOf(TreeRangeSet.create()), false);
    }

    private CharacterClassRangeSet(final ImmutableRangeSet<Integer> rangeSet, boolean containsEOF) {
        assert rangeSet.isEmpty() || rangeSet.span().lowerEndpoint() >= 0;
        assert rangeSet.isEmpty() || rangeSet.span().upperEndpoint() < CharacterClassFactory.EOF_INT;

        if(rangeSet.isEmpty()) {
            this.min = this.max = containsEOF ? CharacterClassFactory.EOF_INT : -1;
        } else {
            this.min = rangeSet.span().lowerEndpoint();
            this.max = Math.max(rangeSet.span().upperEndpoint(), containsEOF ? CharacterClassFactory.EOF_INT : -1);
        }

        this.rangeSet = rangeSet;
        this.containsEOF = containsEOF;

        this.useCachedBitSet = tryOptimize();
    }

    private final long wordAt(int wordIndex) {
        switch(wordIndex) {
            case 0:
                return word0;
            case 1:
                return word1;
            case 2:
                return word2;
            case 3:
                return word3;
            default:
                return 0L;
        }
    }

    @Override public final boolean contains(int character) {
        if(character == CharacterClassFactory.EOF_INT)
            return containsEOF;

        if(useCachedBitSet) {
            final int wordIndex = character >> BITMAP_SEGMENT_SIZE;
            final long word = wordAt(wordIndex);

            return (word & (1L << character)) != 0;
        } else
            return rangeSet.contains(character);
    }

    @Override public int min() {
        return min;
    }

    @Override public int max() {
        return max;
    }

    protected final CharacterClassRangeSet addRange(int from, int to) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create(rangeSet);

        mutableRangeSet.add(Range.closed(from, Math.min(255, to)));

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet),
            containsEOF || to == CharacterClassFactory.EOF_INT);
    }

    protected final CharacterClassRangeSet addSingle(int character) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create(rangeSet);

        if(character < CharacterClassFactory.EOF_INT)
            mutableRangeSet.add(Range.singleton(character));

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet),
            containsEOF || character == CharacterClassFactory.EOF_INT);
    }

    protected final CharacterClassRangeSet removeSingle(int character) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create(rangeSet);

        if(character < CharacterClassFactory.EOF_INT)
            mutableRangeSet.remove(Range.open(character - 1, character + 1));

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet),
            containsEOF && character != CharacterClassFactory.EOF_INT);
    }

    private boolean tryOptimize() {
        if(!rangeSet.isEmpty()) {
            final BitSet bitSet = convertToBitSet(rangeSet);

            final long[] words = bitSet.toLongArray();
            switch(words.length) {
                case 4:
                    word3 = words[3];
                case 3:
                    word2 = words[2];
                case 2:
                    word1 = words[1];
                case 1:
                    word0 = words[0];
            }
            return true;
        } else {
            return false;
        }
    }

    private final BitSet convertToBitSet(final RangeSet<Integer> rangeSet) {
        if(rangeSet.isEmpty()) {
            return new BitSet();
        }

        final BitSet bitSet = new BitSet(rangeSet.span().upperEndpoint());

        rangeSet.asRanges().forEach(range -> {
            if(!range.canonical(DiscreteDomain.integers()).isEmpty()) {
                Range<Integer> closedRange = ContiguousSet.create(range, DiscreteDomain.integers()).range();
                bitSet.set(closedRange.lowerEndpoint(), closedRange.upperEndpoint() + 1);
            }
        });

        return bitSet;
    }

    public final CharacterClassRangeSet rangeSetUnion(CharacterClassRangeSet other) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create();

        mutableRangeSet.addAll(this.rangeSet);
        mutableRangeSet.addAll(other.rangeSet);

        boolean containsEOF = this.containsEOF || other.containsEOF;

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF);
    }

    public CharacterClassRangeSet rangeSetIntersection(CharacterClassRangeSet other) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create();

        for(Range<Integer> range : this.rangeSet.asRanges()) {
            mutableRangeSet.addAll(other.rangeSet.subRangeSet(range));
        }

        boolean containsEOF = this.containsEOF && other.containsEOF;

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF);
    }

    public CharacterClassRangeSet rangeSetDifference(CharacterClassRangeSet other) {
        final RangeSet<Integer> mutableRangeSet = TreeRangeSet.create();

        mutableRangeSet.addAll(other.rangeSet);
        mutableRangeSet.removeAll(this.rangeSet);

        boolean containsEOF = other.containsEOF && !this.containsEOF;

        return new CharacterClassRangeSet(ImmutableRangeSet.copyOf(mutableRangeSet), containsEOF);
    }

    public final ICharacterClass optimized() {
        if(rangeSet.isEmpty())
            return containsEOF ? CharacterClassFactory.EOF_SINGLETON : new CharacterClassOptimized();
        else
            return new CharacterClassOptimized(word0, word1, word2, word3, containsEOF, min, max);
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

        rangeSet.asRanges().forEach(range -> {
            if(!range.isEmpty()) {
                Range<Integer> closedRange = ContiguousSet.create(range, DiscreteDomain.integers()).range();
                final int from = closedRange.lowerEndpoint();
                final int to = closedRange.upperEndpoint();

                if(from != to)
                    ranges.add("" + from + "-" + to);
                else
                    ranges.add("" + from);
            }
        });

        if(containsEOF)
            ranges.add("EOF");

        return "[" + String.join(",", ranges) + "]";
    }

}
