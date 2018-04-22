package org.metaborg.characterclasses;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

import java.io.Serializable;

import org.metaborg.characterclasses.util.Cache;

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

    @Override public final ICharacterClass union(ICharacterClass one, ICharacterClass two) {
        boolean aIsRangeSet = one instanceof CharacterClassRangeSet;
        boolean bIsRangeSet = two instanceof CharacterClassRangeSet;

        if(aIsRangeSet || bIsRangeSet) {
            CharacterClassRangeSet rangeSet;
            ICharacterClass other;

            if(aIsRangeSet) {
                rangeSet = (CharacterClassRangeSet) one;
                other = two;
            } else {
                rangeSet = (CharacterClassRangeSet) two;
                other = one;
            }

            return rangeSetUnion(rangeSet, other);
        } else {
            CharacterClassRangeSet result = fromEmpty();

            result = rangeSetUnion(result, one);
            result = rangeSetUnion(result, two);

            return result;
        }
    }

    @Override public final ICharacterClass intersection(ICharacterClass a, ICharacterClass b) {
        boolean aIsRangeSet = a instanceof CharacterClassRangeSet;
        boolean bIsRangeSet = b instanceof CharacterClassRangeSet;

        if(aIsRangeSet || bIsRangeSet) {
            CharacterClassRangeSet rangeSet;
            ICharacterClass other;

            if(aIsRangeSet) {
                rangeSet = (CharacterClassRangeSet) a;
                other = b;
            } else {
                rangeSet = (CharacterClassRangeSet) b;
                other = a;
            }

            return rangeSetIntersection(rangeSet, other);
        } else {
            CharacterClassRangeSet result = fromEmpty();

            result = rangeSetUnion(result, a);
            result = rangeSetIntersection(result, b);

            return result;
        }
    }

    @Override public final ICharacterClass difference(ICharacterClass a, ICharacterClass b) {
        CharacterClassRangeSet aRangeSet;

        if(a instanceof CharacterClassRangeSet)
            aRangeSet = (CharacterClassRangeSet) a;
        else {
            aRangeSet = fromEmpty();

            aRangeSet = rangeSetUnion(aRangeSet, a);
        }

        return rangeSetDifference(aRangeSet, b);
    }

    private final CharacterClassRangeSet rangeSetUnion(CharacterClassRangeSet rangeSet, ICharacterClass other) {
        if(other instanceof CharacterClassRangeSet)
            return ((CharacterClassRangeSet) other).rangeSetUnion(rangeSet);
        else if(other instanceof CharacterClassSingle)
            return ((CharacterClassSingle) other).rangeSetUnion(rangeSet);
        else
            throw new IllegalStateException();
    }

    private final CharacterClassRangeSet rangeSetIntersection(CharacterClassRangeSet rangeSet, ICharacterClass other) {
        if(other instanceof CharacterClassRangeSet)
            return ((CharacterClassRangeSet) other).rangeSetIntersection(rangeSet);
        else if(other instanceof CharacterClassSingle)
            return ((CharacterClassSingle) other).rangeSetIntersection(rangeSet);
        else
            throw new IllegalStateException();
    }

    private final CharacterClassRangeSet rangeSetDifference(CharacterClassRangeSet rangeSet, ICharacterClass other) {
        if(other instanceof CharacterClassRangeSet)
            return ((CharacterClassRangeSet) other).rangeSetDifference(rangeSet);
        else if(other instanceof CharacterClassSingle)
            return ((CharacterClassSingle) other).rangeSetDifference(rangeSet);
        else
            throw new IllegalStateException();
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
