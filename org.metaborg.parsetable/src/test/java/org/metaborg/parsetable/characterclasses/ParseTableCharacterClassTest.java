package org.metaborg.parsetable.characterclasses;

import static org.junit.Assert.assertTrue;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.MAX_CHAR;

import org.junit.Ignore;
import org.junit.Test;

public class ParseTableCharacterClassTest extends AbstractCharacterClassTest {

    @Override protected ICharacterClassFactory getCharacterClassFactory() {
        return new CharacterClassFactory();
    }

    @Test public void testComplement() {
        testComplement(factory.fromEmpty(), factory.fromRange(0, MAX_CHAR));
        testComplement(factory.fromRange(0, 0), factory.fromRange(1, MAX_CHAR));
        testComplement(factory.fromRange(MAX_CHAR, MAX_CHAR), factory.fromRange(0, MAX_CHAR - 1));
        testComplement(factory.fromRange(0, 2), factory.fromRange(3, MAX_CHAR));
        testComplement(factory.fromRange(5, MAX_CHAR), factory.fromRange(0, 4));
        testComplement(factory.fromSingle(4).union(factory.fromSingle(6)),
            factory.fromRange(7, MAX_CHAR).union(factory.fromSingle(5)).union(factory.fromRange(0, 3)));
        testComplement(factory.fromRange(5, 10).union(factory.fromRange(20, 30)),
            factory.fromRange(31, MAX_CHAR).union(factory.fromRange(11, 19)).union(factory.fromRange(0, 4)));
    }

    private void testComplement(ICharacterClass one, ICharacterClass two) {
        CharacterClassRangeList a = ((CharacterClassRangeList) one);
        CharacterClassRangeList b = ((CharacterClassRangeList) two);
        CharacterClassRangeList ae = (CharacterClassRangeList) a.setEOF(true);
        CharacterClassRangeList be = (CharacterClassRangeList) b.setEOF(true);
        testCharacterClass(a.complement(), be);
        testCharacterClass(ae.complement(), b);
        testCharacterClass(ae, b.complement());
        testCharacterClass(a, be.complement());
    }

    // TODO fix optimized for Unicode
    @Ignore @Test public void testOptimized() {
        testCharacterClass(x, factory.finalize(x));
        testCharacterClass(AZ, factory.finalize(AZ));
        testCharacterClass(eof, factory.finalize(eof));
        testCharacterClass(x.union(eof), factory.finalize(x.union(eof)));
        testCharacterClass(factory.fromRange(97, 97), factory.finalize(factory.fromRange(97, 97)));
        testCharacterClass(fullRange, factory.finalize(fullRange));

        assertTrue(factory.finalize(x) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(AZ) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(eof) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(x.union(eof)) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(factory.fromRange(97, 97)) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(fullRange) instanceof CharacterClassOptimized);
    }

    @Test(expected = IllegalStateException.class) public void testOptimizedEmpty() {
        factory.finalize(factory.fromEmpty());
    }

}
