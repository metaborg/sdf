package org.metaborg.parsetable.characterclasses;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;

import java.io.Serializable;

import org.metaborg.parsetable.Cache;

public class CharacterClassFactory implements ICharacterClassFactory, Serializable {

    private static final long serialVersionUID = 2540422015817167132L;

    final private boolean optimize;
    final private boolean cache;

    private Cache<ICharacterClass> characterClassCache;

    public static final ICharacterClass EOF_SINGLETON = new CharacterClassSingle(EOF_INT);
    public static final ICharacterClass FULL_RANGE =
        // CharacterClassRangeSet.EMPTY_CONSTANT.addRange(0, MAX_CHAR).setEOF(true);
        CharacterClassRangeList.EMPTY_CONSTANT.complement();
    public static final ICharacterClass EMPTY_CHARACTER_CLASS = CharacterClassRangeList.EMPTY_CONSTANT;
    // CharacterClassRangeSet.EMPTY_CONSTANT;

    public static String intToString(int character) {
        if(character == EOF_INT)
            return "EOF";
        else if(isNewLine(character))
            return "\\n";
        else if(isCarriageReturn(character))
            return "\\r";
        else if(isTab(character))
            return "\\t";
        else if(Character.isSupplementaryCodePoint(character))
            return new String(Character.toChars(character));
        else
            return "" + (char) character;
    }

    public static boolean isNewLine(int character) {
        return character == (int) '\n';
    }

    public static boolean isCarriageReturn(int character) {
        return character == (int) '\r';
    }

    public static boolean isTab(int character) {
        return character == (int) '\t';
    }

    public CharacterClassFactory() {
        this(true, true);
    }

    public CharacterClassFactory(boolean optimize, boolean cache) {
        this.optimize = optimize;
        this.cache = cache;

        if(cache)
            this.characterClassCache = new Cache<>();
    }

    @Override public CharacterClassRangeList fromEmpty() {
        return CharacterClassRangeList.EMPTY_CONSTANT;
    }

    @Override public final ICharacterClass fromSingle(int character) {
        return new CharacterClassSingle(character);
    }

    @Override public final ICharacterClass fromRange(int from, int to) {
        return new CharacterClassRangeList(new int[] { from, to }, false);
    }

    @Override public final ICharacterClass fromRanges(int[] ranges, boolean hasEOF) {
        assert ranges.length % 2 == 0;
        return new CharacterClassRangeList(ranges, hasEOF);
    }

    @Override public ICharacterClass finalize(ICharacterClass characterClass) {
        ICharacterClass optimized;

        if(characterClass instanceof CharacterClassRangeList && optimize)
            optimized = ((CharacterClassRangeList) characterClass).optimized();
        else
            optimized = characterClass;

        if(cache)
            return characterClassCache.cached(optimized);
        else
            return optimized;
    }


}
