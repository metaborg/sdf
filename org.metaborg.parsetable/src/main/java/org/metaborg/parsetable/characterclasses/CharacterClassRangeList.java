package org.metaborg.parsetable.characterclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public final class CharacterClassRangeList implements ICharacterClass, Serializable {

    private static final long serialVersionUID = 8553734625129300348L;

    static final CharacterClassRangeList EMPTY_CONSTANT = new CharacterClassRangeList();

    /** An ordered array of low-high pairs in range [0, MAX_CHAR]. Both ends of each range are inclusive. */
    private final int[] rangeList; // Should not be mutated after creation
    private final int min, max;

    /** @see ICharacterClass#EOF_INT */
    private final boolean containsEOF;

    private CharacterClassRangeList() {
        this(new int[0], false);
    }

    CharacterClassRangeList(final int[] rangeList, boolean containsEOF) {
        assert rangeList.length == 0
            || isDisjointSorted(rangeList) && rangeList[0] >= 0 && rangeList[rangeList.length - 1] < CHARACTERS;

        this.rangeList = rangeList;
        this.containsEOF = containsEOF;

        if(hasRanges()) {
            int min = rangeList[0];
            int max = rangeList[rangeList.length - 1];
            if(containsEOF) {
                this.min = Math.min(min, EOF_INT);
                this.max = Math.max(max, EOF_INT);
            } else {
                this.min = min;
                this.max = max;
            }
        } else {
            this.min = this.max = containsEOF ? EOF_INT : Integer.MIN_VALUE;
        }
    }

    private static boolean isDisjointSorted(int[] a) {
        int length = a.length;
        if((length & 1) != 0) // If length is odd
            return false;
        for(int i = 0; i < length - 1; i += 2)
            // Single ranges can have equal boundaries, but prev.high and next.low must be distinct and offset by one
            if(a[i] > a[i + 1] || i < length - 2 && a[i + 1] >= a[i + 2] + 1)
                return false;
        return true;
    }

    @Override public final boolean contains(int character) {
        if(character == EOF_INT)
            return containsEOF;
        return isCharacterInRange(character, rangeIndex(character));
    }

    private int rangeIndex(int character) {
        if(character == EOF_INT || !hasRanges() || character < rangeList[0])
            return -2;
        if(character > rangeList[rangeList.length - 1])
            return rangeList.length - 2;
        int low = 0, high = rangeList.length - 1, mid;
        while(low < high) {
            mid = (low + high) / 2;
            if(character < rangeList[mid])
                high = mid;
            else if(character >= rangeList[mid + 1])
                low = mid + 1;
            else
                return mid & -2; // -2 = 0b1111...1110, i.e. drop last bit
        }
        return low & -2;
    }

    private boolean isCharacterInRange(int character, int rangeIndex) {
        return rangeIndex >= 0 && rangeIndex < rangeList.length //
            && rangeList[rangeIndex] <= character && character <= rangeList[rangeIndex + 1];
    }

    @Override public int min() {
        return min;
    }

    @Override public int max() {
        return max;
    }

    @Override public boolean isEmpty() {
        return !hasRanges() && !containsEOF;
    }

    @Override public int[] getRanges() {
        return rangeList;
    }

    public boolean hasRanges() {
        return rangeList.length > 0;
    }

    @Override public ICharacterClass setEOF(boolean eof) {
        return new CharacterClassRangeList(rangeList, eof);
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        if(other.isEmpty())
            return this;
        if(other.min() == other.max())
            return addSingle(other.min());

        if(other instanceof CharacterClassRangeList) {
            CharacterClassRangeList that = ((CharacterClassRangeList) other);
            int[] newList = new int[this.rangeList.length + that.rangeList.length];

            int i = 0, j = 0, k = 0;
            int low = -1, high = -1, l, h;
            while(i < this.rangeList.length || j < that.rangeList.length) {
                if(i < this.rangeList.length
                    && this.rangeList[i] < (j >= that.rangeList.length ? Integer.MAX_VALUE : that.rangeList[j])) {
                    l = this.rangeList[i++];
                    h = this.rangeList[i++];
                } else if(j < that.rangeList.length
                    && (i >= this.rangeList.length ? Integer.MAX_VALUE : this.rangeList[i]) > that.rangeList[j]) {
                    l = that.rangeList[j++];
                    h = that.rangeList[j++];
                } else { // both ranges have equal start value
                    l = this.rangeList[i++];
                    j++;
                    h = Integer.max(this.rangeList[i++], that.rangeList[j++]);
                }
                if(low == -1) {
                    low = l;
                    high = h;
                } else {
                    if(high + 1 >= l) {
                        high = Integer.max(h, high);
                    } else {
                        newList[k++] = low;
                        newList[k++] = high;
                        low = l;
                        high = h;
                    }
                }
            }
            if(low != -1) {
                newList[k++] = low;
                newList[k++] = high;
            }

            boolean containsEOF = this.containsEOF || that.containsEOF;
            return new CharacterClassRangeList(Arrays.copyOf(newList, k), containsEOF);
        }

        throw new IllegalStateException("Union can only be done with Single and RangeList character classes");
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        if(other.isEmpty())
            return other;
        if(other.min() == other.max())
            if(contains(other.min()))
                return other;
            else
                return EMPTY_CONSTANT;

        if(other instanceof CharacterClassRangeList) {
            CharacterClassRangeList that = ((CharacterClassRangeList) other);
            int[] newList = new int[this.rangeList.length + that.rangeList.length];

            int i = 0, j = 0, k = 0;
            int low = -1, high = -1, l, h;
            while(i < this.rangeList.length || j < that.rangeList.length) {
                if(i < this.rangeList.length
                    && this.rangeList[i] < (j >= that.rangeList.length ? Integer.MAX_VALUE : that.rangeList[j])) {
                    l = this.rangeList[i++];
                    h = this.rangeList[i++];
                } else if(j < that.rangeList.length
                    && (i >= this.rangeList.length ? Integer.MAX_VALUE : this.rangeList[i]) > that.rangeList[j]) {
                    l = that.rangeList[j++];
                    h = that.rangeList[j++];
                } else { // both ranges have equal start value
                    newList[k++] = this.rangeList[i++];
                    j++;
                    l = this.rangeList[i++];
                    h = that.rangeList[j++];
                    low = Integer.min(l, h);
                    high = Integer.max(l, h);
                    newList[k++] = low++;
                    continue;
                }
                if(low == -1) {
                    low = l;
                    high = h;
                } else {
                    if(l <= high) {
                        newList[k++] = l;
                        if(h < high) {
                            newList[k++] = h;
                            low = h + 1;
                        } else if(h == high) {
                            newList[k++] = h;
                            low = -1;
                            high = -1;
                        } else {
                            newList[k++] = high;
                            low = high + 1;
                            high = h;
                        }
                    } else {
                        low = l;
                        high = h;
                    }
                }
            }

            boolean containsEOF = this.containsEOF && that.containsEOF;
            return new CharacterClassRangeList(Arrays.copyOf(newList, k), containsEOF);
        }

        throw new IllegalStateException("Intersection can only be done with Single and RangeList character classes");
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        if(other instanceof CharacterClassSingle)
            return removeSingle(other.min());

        if(other instanceof CharacterClassRangeList) {
            return this.intersection(((CharacterClassRangeList) other).complement());
        }

        throw new IllegalStateException("Difference can only be done with Single and RangeList character classes");
    }

    public ICharacterClass complement() {
        if(!hasRanges())
            return new CharacterClassRangeList(new int[] { 0, MAX_CHAR }, !containsEOF);
        int min = rangeList[0];
        int max = rangeList[rangeList.length - 1];
        int[] newList = new int[rangeList.length + 2 - (min == 0 ? 2 : 0) - (max == MAX_CHAR ? 2 : 0)];
        int k = 0;
        if(min != 0) {
            newList[k++] = 0;
            newList[k++] = rangeList[0] - 1;
        }
        for(int i = 1; i < rangeList.length - 1; i += 2) {
            newList[k++] = rangeList[i] + 1;
            newList[k++] = rangeList[i + 1] - 1;
        }
        if(max != MAX_CHAR) {
            newList[k++] = rangeList[rangeList.length - 1] + 1;
            newList[k] = MAX_CHAR;
        }
        return new CharacterClassRangeList(newList, !containsEOF);
    }

    protected final CharacterClassRangeList addSingle(int character) {
        if(character == EOF_INT)
            return new CharacterClassRangeList(rangeList, true);

        if(!hasRanges())
            return new CharacterClassRangeList(new int[] { character, character }, containsEOF);

        int rangeIndex = rangeIndex(character);
        if(isCharacterInRange(character, rangeIndex))
            return this;

        boolean charFitsInPrevRange = rangeIndex >= 0 && character - 1 == rangeList[rangeIndex + 1];
        boolean charFitsInNextRange = rangeIndex < rangeList.length - 2 && character + 1 == rangeList[rangeIndex + 2];
        if(charFitsInPrevRange && charFitsInNextRange) {
            return new CharacterClassRangeList(collapseRange(rangeIndex + 1), containsEOF);
        } else if(charFitsInNextRange) {
            int[] newList = rangeList.clone();
            newList[rangeIndex + 2]--;
            return new CharacterClassRangeList(newList, containsEOF);
        } else if(charFitsInPrevRange) {
            int[] newList = rangeList.clone();
            newList[rangeIndex + 1]++;
            return new CharacterClassRangeList(newList, containsEOF);
        } else {
            int[] newList = insertRange(rangeIndex + 2);
            newList[rangeIndex + 2] = character;
            newList[rangeIndex + 3] = character;
            return new CharacterClassRangeList(newList, containsEOF);
        }
    }

    protected final CharacterClassRangeList removeSingle(int character) {
        if(character == EOF_INT)
            return new CharacterClassRangeList(rangeList, false);

        int rangeIndex = rangeIndex(character);
        if(!isCharacterInRange(character, rangeIndex))
            return this;

        int low = rangeList[rangeIndex];
        int high = rangeList[rangeIndex + 1];
        if(low == character && high == character) {
            return new CharacterClassRangeList(collapseRange(rangeIndex), containsEOF);
        } else if(low == character) {
            int[] newList = rangeList.clone();
            newList[rangeIndex]++;
            return new CharacterClassRangeList(newList, containsEOF);
        } else if(high == character) {
            int[] newList = rangeList.clone();
            newList[rangeIndex + 1]--;
            return new CharacterClassRangeList(newList, containsEOF);
        } else {
            int[] newList = insertRange(rangeIndex + 1);
            newList[rangeIndex + 1] = character - 1;
            newList[rangeIndex + 2] = character + 1;
            return new CharacterClassRangeList(newList, containsEOF);
        }
    }

    private int[] insertRange(int rangeIndex) {
        assert 0 <= rangeIndex && rangeIndex <= rangeList.length;
        int[] newList = new int[rangeList.length + 2];
        if(rangeIndex > 0)
            System.arraycopy(rangeList, 0, newList, 0, rangeIndex);
        if(rangeIndex < rangeList.length)
            System.arraycopy(rangeList, rangeIndex, newList, rangeIndex + 2, rangeList.length - rangeIndex);
        return newList;
    }

    private int[] collapseRange(int rangeIndex) {
        assert 0 <= rangeIndex && rangeIndex <= rangeList.length - 2;
        int[] newList = new int[rangeList.length - 2];
        if(rangeIndex > 0)
            System.arraycopy(rangeList, 0, newList, 0, rangeIndex);
        if(rangeIndex < rangeList.length - 2)
            System.arraycopy(rangeList, rangeIndex + 2, newList, rangeIndex, rangeList.length - rangeIndex - 2);
        return newList;
    }

    public final ICharacterClass optimized() {
        if(rangeList.length == 0)
            if(containsEOF)
                return CharacterClassFactory.EOF_SINGLETON;
            else
                throw new IllegalStateException("Empty character classes are not allowed");

        // Reduce to single character, this is possible when it does not contain EOF and the range is a singleton
        if(!containsEOF && min == max) {
            return new CharacterClassSingle(min);
        }

        return new CharacterClassOptimized(this);
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) {
        IStrategoList.Builder terms = tf.arrayListBuilder(rangeList.length / 2 + 1);
        for(int i = 0; i < rangeList.length; i += 2) {
            final int from = rangeList[i];
            final int to = rangeList[i + 1];

            if(from == to)
                terms.add(tf.makeInt(from));
            else
                terms.add(tf.makeAppl(tf.makeConstructor("range", 2), tf.makeInt(from), tf.makeInt(to)));
        }

        if(containsEOF)
            terms.add(tf.makeAppl(tf.makeConstructor("eof", 0)));

        return tf.makeList(terms);
    }

    @Override public int hashCode() {
        return Arrays.hashCode(rangeList) ^ Boolean.hashCode(containsEOF);
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o instanceof CharacterClassSingle) {
            return this.min == this.max && this.min == ((CharacterClassSingle) o).min();
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        CharacterClassRangeList that = (CharacterClassRangeList) o;

        return Arrays.equals(rangeList, that.rangeList) && containsEOF == that.containsEOF;
    }

    @Override public String toString() {
        final List<String> ranges = new ArrayList<>();

        for(int i = 0; i < rangeList.length; i += 2) {
            final int from = rangeList[i];
            final int to = rangeList[i + 1];

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
