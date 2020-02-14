package org.metaborg.parsetable.characterclasses;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class ParseTableCharacterClassTest extends AbstractCharacterClassTest {

    @Override protected ICharacterClassFactory getCharacterClassFactory() {
        return new CharacterClassFactory();
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
