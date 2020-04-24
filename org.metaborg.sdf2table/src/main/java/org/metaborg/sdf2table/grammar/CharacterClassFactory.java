package org.metaborg.sdf2table.grammar;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.CHARACTERS;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

import java.io.Serializable;
import java.util.BitSet;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;

public class CharacterClassFactory implements ICharacterClassFactory, Serializable {

    private static final long serialVersionUID = -73296884457025056L;

    public static final ICharacterClass EMPTY_CHARACTER_CLASS = new CharacterClass(new BitSet(), false);
    public static final ICharacterClass FULL_RANGE = fullRangeCC();
    public static final ICharacterClass EOF_SINGLETON = eofCC();


    @Override public ICharacterClass fromEmpty() {
        return new CharacterClass(new BitSet(), false);
    }

    @Override public ICharacterClass fromSingle(int character) {
        if(character == EOF_INT)
            return EOF_SINGLETON;
        BitSet chars = new BitSet(CHARACTERS);
        chars.set(character);
        return new CharacterClass(chars, false);
    }

    @Override public ICharacterClass fromRange(int from, int to) {
        BitSet chars = new BitSet(CHARACTERS);
        chars.set(from, to + 1);
        return new CharacterClass(chars, false);
    }

    @Override public ICharacterClass fromRanges(int[] ranges, boolean hasEOF) {
        BitSet chars = new BitSet(CHARACTERS);
        for(int i = 0; i < ranges.length; i += 1) {
            chars.set(ranges[i], ranges[i + 1] + 1);
        }
        return new CharacterClass(chars, hasEOF);
    }

    @Override public ICharacterClass finalize(ICharacterClass characterClass) {
        return characterClass;
    }

    private static ICharacterClass fullRangeCC() {
        BitSet chars = new BitSet(CHARACTERS);
        chars.set(0, CHARACTERS);
        return new CharacterClass(chars, true);
    }

    private static ICharacterClass eofCC() {
        return new CharacterClass(new BitSet(), true);
    }

}
