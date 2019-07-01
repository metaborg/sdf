package org.metaborg.characterclasses;

import java.io.Serializable;

import org.metaborg.characterclasses.util.Cache;
import org.metaborg.parsetable.characterclasses.ICharacterClass;

public class CharacterClassFactory implements ICharacterClassFactory, Serializable {

    private static final long serialVersionUID = 2540422015817167132L;

    final private boolean optimize;
    final private boolean cache;

    private Cache<ICharacterClass> characterClassCache;

    public static int EOF_INT = 256;

    public static final ICharacterClass EOF_SINGLETON = new CharacterClassSingle(EOF_INT);
    public static final ICharacterClass FULL_RANGE = CharacterClassRangeSet.EMPTY_CONSTANT.addRange(0, 256);
    public static final ICharacterClass EMPTY_CHARACTER_CLASS = CharacterClassRangeSet.EMPTY_CONSTANT;

    public static String intToString(int character) {
        if(character == EOF_INT)
            return "EOF";
        else
            return "" + (char) character;
    }

    public static boolean isNewLine(int character) {
        return character != EOF_INT && ((char) character) == '\n';
    }

    public static boolean isTab(int character) {
        return character != EOF_INT && ((char) character) == '\t';
    }

    public CharacterClassFactory(boolean optimize, boolean cache) {
        this.optimize = optimize;
        this.cache = cache;

        if(cache)
            this.characterClassCache = new Cache<>();
    }

    @Override public CharacterClassRangeSet fromEmpty() {
        return CharacterClassRangeSet.EMPTY_CONSTANT;
    }

    @Override public final ICharacterClass fromSingle(int character) {
        return new CharacterClassSingle(character);
    }

    @Override public final ICharacterClass fromRange(int from, int to) {
        return fromEmpty().addRange(from, to);
    }

    @Override public ICharacterClass finalize(ICharacterClass characterClass) {
        ICharacterClass optimized;

        if(characterClass instanceof CharacterClassRangeSet && optimize)
            optimized = ((CharacterClassRangeSet) characterClass).optimized();
        else
            optimized = characterClass;

        if(cache)
            return characterClassCache.cached(optimized);
        else
            return optimized;
    }


}
