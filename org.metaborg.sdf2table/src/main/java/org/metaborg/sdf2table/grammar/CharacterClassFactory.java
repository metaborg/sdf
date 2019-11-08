package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.BitSet;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;

public class CharacterClassFactory implements ICharacterClassFactory, Serializable {
    
    private static final long serialVersionUID = -73296884457025056L;

    public static final ICharacterClass EMPTY_CHARACTER_CLASS = new CharacterClass(new BitSet());
    public static final ICharacterClass FULL_RANGE = fullRangeCC();
    public static final ICharacterClass EOF_SINGLETON = eofCC();
    
    
    @Override public ICharacterClass fromEmpty() {
        BitSet chars = new BitSet();
        return new CharacterClass(chars);
    }

    @Override public ICharacterClass fromSingle(int character) {
        BitSet chars = new BitSet();
        chars.set(character);
        return new CharacterClass(chars);
    }

    @Override public ICharacterClass fromRange(int from, int to) {
        BitSet chars = new BitSet();
        chars.set(from, to);
        return new CharacterClass(chars);
    }

    @Override public ICharacterClass finalize(ICharacterClass characterClass) {
        return characterClass;
    }

    private static ICharacterClass fullRangeCC() {
        BitSet chars = new BitSet();
        chars.set(0, 257);
        return new CharacterClass(chars);
    }

    private static ICharacterClass eofCC() {
        BitSet chars = new BitSet();
        chars.set(256);
        return new CharacterClass(chars);
    }

}
