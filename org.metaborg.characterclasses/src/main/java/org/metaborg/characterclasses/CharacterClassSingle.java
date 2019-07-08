package org.metaborg.characterclasses;

import java.io.Serializable;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public final class CharacterClassSingle implements ICharacterClass, Serializable {

    private static final long serialVersionUID = -9025374026984306930L;
    private final int character;

    public CharacterClassSingle(int character) {
        this.character = character;
    }

    @Override public final boolean contains(int character) {
        return this.character == character;
    }

    @Override public int min() {
        return character;
    }

    @Override public int max() {
        return character;
    }

    @Override public boolean isEmpty() {
        return false;
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        if(other instanceof CharacterClassSingle) {
            CharacterClassRangeSet result = CharacterClassRangeSet.EMPTY_CONSTANT;
            result = result.addSingle(this.character);
            result = result.addSingle(other.min());
            return result;
        }

        if(other instanceof CharacterClassRangeSet)
            return ((CharacterClassRangeSet) other).addSingle(character);

        throw new IllegalStateException("Union can only be done with Single and RangeSet character classes");
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        if(other instanceof CharacterClassOptimized)
            throw new IllegalStateException("Intersection can only be done with Single and RangeSet character classes");

        if(other.contains(character))
            return this;
        else
            return CharacterClassRangeSet.EMPTY_CONSTANT;
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        if(other instanceof CharacterClassOptimized)
            throw new IllegalStateException("Difference can only be done with Single and RangeSet character classes");

        if(other.contains(character))
            return CharacterClassRangeSet.EMPTY_CONSTANT;
        else
            return this;
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) {
        return tf.makeList(tf.makeInt(character));
    }

    @Override public int hashCode() {
        return Integer.hashCode(character);
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o instanceof CharacterClassRangeSet) {
            if(((CharacterClassRangeSet) o).min() == min() && ((CharacterClassRangeSet) o).max() == min()) {
                return true;
            } else {
                return false;
            }
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        CharacterClassSingle that = (CharacterClassSingle) o;

        return this.character == that.character;
    }

    @Override public final String toString() {
        return "[" + character + "]";
    }

}
