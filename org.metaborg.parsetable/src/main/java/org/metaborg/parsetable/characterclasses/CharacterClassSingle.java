package org.metaborg.parsetable.characterclasses;

import java.io.Serializable;

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

    @Override public ICharacterClass setEOF(boolean eof) {
        if(character == EOF_INT) {
            return eof ? this : CharacterClassRangeList.EMPTY_CONSTANT;
        }
        return eof ? union(new CharacterClassSingle(EOF_INT)) : this;
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        if(other instanceof CharacterClassSingle) {
            if(other.contains(character))
                return this;

            CharacterClassRangeList result = CharacterClassRangeList.EMPTY_CONSTANT;
            result = result.addSingle(this.character);
            result = result.addSingle(other.min());
            return result;
        }

        if(other instanceof CharacterClassRangeSet)
            return ((CharacterClassRangeSet) other).addSingle(character);
        if(other instanceof CharacterClassRangeList)
            return ((CharacterClassRangeList) other).addSingle(character);

        throw new IllegalStateException("Union can only be done with Single and RangeSet character classes");
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        if(other instanceof CharacterClassOptimized)
            throw new IllegalStateException("Intersection can only be done with Single and RangeSet character classes");

        if(other.contains(character))
            return this;
        else
            return CharacterClassRangeList.EMPTY_CONSTANT;
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        if(other instanceof CharacterClassOptimized)
            throw new IllegalStateException("Difference can only be done with Single and RangeSet character classes");

        if(other.contains(character))
            return CharacterClassRangeList.EMPTY_CONSTANT;
        else
            return this;
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) {
        return tf.makeList(character == EOF_INT ? tf.makeAppl(tf.makeConstructor("eof", 0)) : tf.makeInt(character));
    }

    @Override public int hashCode() {
        return Integer.hashCode(character);
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(!(o instanceof ICharacterClass)) {
            return false;
        }
        return ((ICharacterClass) o).min() == min() && ((ICharacterClass) o).max() == min();
    }

    @Override public final String toString() {
        return "[" + character + "]";
    }

}
