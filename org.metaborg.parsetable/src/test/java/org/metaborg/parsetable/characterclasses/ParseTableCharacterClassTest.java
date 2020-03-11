package org.metaborg.parsetable.characterclasses;

import static org.junit.Assert.assertTrue;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.MAX_CHAR;

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

    @Test public void testOptimized() {
        ICharacterClass rangeListEOF = factory.fromEmpty().setEOF(true);
        ICharacterClass separateRange = factory.fromRange(100, 120).union(factory.fromRange(0x400, 0x420));
        ICharacterClass bigRange = factory.fromRange(0xffff, 0x1000f).union(factory.fromRange(0xfffff, 0x10000f));

        testCharacterClass(x, factory.finalize(x));
        testCharacterClass(AZ, factory.finalize(AZ));
        testCharacterClass(eof, factory.finalize(eof));
        testCharacterClass(rangeListEOF, factory.finalize(rangeListEOF));
        testCharacterClass(x.union(eof), factory.finalize(x.union(eof)));
        testCharacterClass(factory.fromRange(97, 97), factory.finalize(factory.fromRange(97, 97)));
        testCharacterClass(factory.fromRange(250, 260), factory.finalize(factory.fromRange(250, 260)));
        testCharacterClass(factory.fromRange(0xffff, 0x1000f), factory.finalize(factory.fromRange(0xffff, 0x1000f)));
        testCharacterClass(separateRange, factory.finalize(separateRange));
        testCharacterClass(bigRange, factory.finalize(bigRange));
        testCharacterClass(fullRange, factory.finalize(fullRange));

        assertTrue(factory.finalize(x) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(AZ) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(eof) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(rangeListEOF) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(x.union(eof)) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(factory.fromRange(97, 97)) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(separateRange) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(bigRange) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(fullRange) instanceof CharacterClassOptimized);
    }

    @Test(expected = IllegalStateException.class) public void testOptimizedEmpty() {
        factory.finalize(factory.fromEmpty());
    }

}
