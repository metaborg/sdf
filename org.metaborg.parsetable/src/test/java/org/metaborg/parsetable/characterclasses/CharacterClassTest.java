package org.metaborg.parsetable.characterclasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.metaborg.parsetable.characterclasses.CharacterClassFactory.FULL_RANGE;

import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.Test;
import org.spoofax.terms.TermFactory;

public class CharacterClassTest {

    ICharacterClassFactory factory = new CharacterClassFactory();

    ICharacterClass AZ = factory.fromRange(65, 90);
    ICharacterClass az = factory.fromRange(97, 122);

    ICharacterClass c = factory.fromSingle(99);
    ICharacterClass x = factory.fromSingle(120);
    ICharacterClass eof = factory.fromSingle(CharacterClassFactory.EOF_INT);

    private void testCharacterClass(ICharacterClass characters, Predicate<Integer> contains) {
        for(int i = 0; i <= CharacterClassFactory.EOF_INT; i++) {
            boolean expected = characters.contains(i);

            assertEquals("Character " + i + " ('" + CharacterClassFactory.intToString(i) + "') for characters "
                + characters.toString() + ":", contains.test(i), expected);
        }
    }

    private void testCharacterClass(ICharacterClass one, ICharacterClass two) {
        for(int i = 0; i <= CharacterClassFactory.EOF_INT; i++) {
            boolean expected = one.contains(i);
            boolean actual = two.contains(i);

            assertEquals("Character " + i + " ('" + CharacterClassFactory.intToString(i) + "') for characters "
                + one.toString() + " vs. " + two.toString() + ":", actual, expected);
        }
    }

    @Test public void testLowerCaseLettersRange() {
        testCharacterClass(az, character -> 97 <= character && character <= 122);

        assertEquals(az.contains('a'), true);
        assertEquals(az.contains('A'), false);
    }

    @Test public void testUppercaseCaseLettersRange() {
        testCharacterClass(AZ, character -> 65 <= character && character <= 90);
    }

    @Test public void testLettersUnionRange() {
        ICharacterClass letters = az.union(AZ);

        testCharacterClass(letters,
            character -> 65 <= character && character <= 90 || 97 <= character && character <= 122);
    }

    @Test public void testLettersIntersectionRange() {
        ICharacterClass letters = az.intersection(AZ);

        testCharacterClass(letters, factory.fromEmpty());
    }

    @Test public void testLettersDifferenceRange() {
        ICharacterClass letters = az.intersection(AZ);

        testCharacterClass(letters, factory.fromEmpty());
    }

    @Test public void testSingletonRange() {
        testCharacterClass(x, character -> character == 120);
    }

    @Test public void testSingletonRangeUnion() {
        ICharacterClass characters = x.union(AZ);

        testCharacterClass(characters, character -> 65 <= character && character <= 90 || character == 120);

        assertEquals(characters.contains('a'), false);
        assertEquals(characters.contains('B'), true);
        assertEquals(characters.contains('x'), true);
    }

    @Test public void testEOF() {
        ICharacterClass characters = factory.fromSingle(CharacterClassFactory.EOF_INT);

        testCharacterClass(characters, character -> character == CharacterClassFactory.EOF_INT);
    }

    @Test public void testRangeEOFunion() {
        ICharacterClass characters = az.union(factory.fromSingle(CharacterClassFactory.EOF_INT));

        testCharacterClass(characters,
            character -> 97 <= character && character <= 122 || character == CharacterClassFactory.EOF_INT);
    }

    @Test public void testRangeEOFintersect() {
        testCharacterClass(az.union(eof).intersection(eof), eof);
        testCharacterClass(eof.intersection(az.union(eof)), eof);
    }

    @Test public void testRangeEOFdifference() {
        testCharacterClass(az.union(eof).difference(eof), az);
        testCharacterClass(eof.difference(az.union(eof)), factory.fromEmpty());
    }

    @Test public void testRangeIntersect() {
        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromSingle(15)), factory.fromSingle(15));
        testCharacterClass(factory.fromSingle(15).intersection(factory.fromRange(10, 20)), factory.fromSingle(15));

        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromRange(15, 25)),
            factory.fromRange(15, 20));

        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromRange(20, 30)), factory.fromSingle(20));
        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromSingle(20)), factory.fromSingle(20));
        testCharacterClass(factory.fromSingle(20).intersection(factory.fromRange(10, 20)), factory.fromSingle(20));
    }

    @Test public void testRangeDifference() {
        testCharacterClass(factory.fromRange(65, 75).difference(factory.fromSingle(70)),
            factory.fromRange(65, 69).union(factory.fromRange(71, 75)));

        testCharacterClass(factory.fromSingle(15).difference(factory.fromRange(10, 20)), factory.fromEmpty());

        testCharacterClass(factory.fromRange(65, 70).difference(factory.fromSingle(70)), factory.fromRange(65, 69));

        testCharacterClass(factory.fromRange(65, 75).difference(factory.fromRange(68, 73)),
            factory.fromRange(65, 67).union(factory.fromRange(74, 75)));

        testCharacterClass(factory.fromRange(65, 75).difference(factory.fromRange(70, 80)), factory.fromRange(65, 69));

        testCharacterClass(factory.fromRange(75, 85).difference(factory.fromRange(70, 80)), factory.fromRange(81, 85));
    }

    @Test public void testOptimized() {
        testCharacterClass(x, factory.finalize(x));
        testCharacterClass(AZ, factory.finalize(AZ));
        testCharacterClass(eof, factory.finalize(eof));
        testCharacterClass(x.union(eof), factory.finalize(x.union(eof)));
        testCharacterClass(factory.fromRange(97, 97), factory.finalize(factory.fromRange(97, 97)));
        testCharacterClass(factory.fromRange(0, 256), factory.finalize(factory.fromRange(0, 256)));

        assertTrue(factory.finalize(x) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(AZ) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(eof) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(x.union(eof)) instanceof CharacterClassOptimized);
        assertTrue(factory.finalize(factory.fromRange(97, 97)) instanceof CharacterClassSingle);
        assertTrue(factory.finalize(factory.fromRange(0, 256)) instanceof CharacterClassOptimized);
    }

    @Test(expected = IllegalStateException.class) public void testOptimizedEmpty() {
        factory.finalize(factory.fromEmpty());
    }

    @Test public void testNewLineDetection() {
        char newLineChar = '\n';
        int newLineInt = (int) newLineChar;

        assertEquals(CharacterClassFactory.isNewLine(newLineChar), true);
        assertEquals(CharacterClassFactory.isNewLine(newLineInt), true);
    }

    @Test public void testComparisons() {
        assertEquals(ICharacterClass.comparator().compare(AZ, az), -1);
        assertEquals(ICharacterClass.comparator().compare(az, AZ), 1);
        assertEquals(ICharacterClass.comparator().compare(az, az), 0);
        assertEquals(ICharacterClass.comparator().compare(AZ, AZ), 0);
        assertEquals(ICharacterClass.comparator().compare(AZ, x), -1);
        assertEquals(ICharacterClass.comparator().compare(x, AZ), 1);
        assertEquals(ICharacterClass.comparator().compare(x, az), 1);
        assertEquals(ICharacterClass.comparator().compare(az, x), -1);
        assertEquals(ICharacterClass.comparator().compare(az, eof), -1);
        assertEquals(ICharacterClass.comparator().compare(eof, az), 1);
    }

    @Test public void testDisjointSortable() {
        assertEquals(ICharacterClass.disjointSorted(Arrays.asList(AZ, az)), true);
        assertEquals(ICharacterClass.disjointSorted(Arrays.asList(az, AZ)), false);
        assertEquals(ICharacterClass.disjointSorted(Arrays.asList(AZ, AZ)), false);

        assertEquals(ICharacterClass.disjointSortable(Arrays.asList(AZ, az)), true);
        assertEquals(ICharacterClass.disjointSortable(Arrays.asList(az, AZ)), true);
        assertEquals(ICharacterClass.disjointSortable(Arrays.asList(AZ, AZ)), false);

        assertEquals(ICharacterClass.disjointSortable(Arrays.asList(az, x)), false);
        assertEquals(ICharacterClass.disjointSortable(Arrays.asList(az, AZ, eof)), true);
    }

    @Test public void testToAterm() {
        TermFactory tf = new TermFactory();
        assertEquals("[120]", x.toAtermList(tf).toString());
        assertEquals("[range(65,90)]", AZ.toAtermList(tf).toString());
        assertEquals("[256]", eof.toAtermList(tf).toString());
        assertEquals("[range(0,256)]", FULL_RANGE.union(eof).toAtermList(tf).toString());
        assertEquals("[range(65,90),256]", AZ.union(eof).toAtermList(tf).toString());
        assertEquals("[range(65,90),range(97,122)]", AZ.union(az).toAtermList(tf).toString());
        assertEquals("[range(65,90),range(97,122),256]", AZ.union(az).union(eof).toAtermList(tf).toString());
        assertEquals("[range(97,119),range(121,122)]", az.difference(x).toAtermList(tf).toString());

        // In Guava's Rangeset, {[97,122]} - {[99],[120]} = {[97,99),(99,120),(120,122]}
        // This test checks whether the open ranges are correctly normalized to closed ranges when converting to ATerm.
        assertEquals("[range(97,98),range(100,119),range(121,122)]",
            az.difference(c.union(x)).toAtermList(tf).toString());
        // {[97,99),(99,120),(120,122]} - {[100],[120]} = {[97,99),(99,100),(100,120),(120,122]}
        // The empty range (99,100) must be removed
        assertEquals("[range(97,98),range(101,119),range(121,122)]",
            az.difference(c.union(x)).difference(factory.fromSingle(100).union(x)).toAtermList(tf).toString());
    }

}
