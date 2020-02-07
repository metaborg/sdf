package org.metaborg.parsetable.characterclasses;

import static org.junit.Assert.assertEquals;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.*;

import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.Test;
import org.spoofax.terms.TermFactory;

public abstract class AbstractCharacterClassTest {

    ICharacterClassFactory factory = getCharacterClassFactory();

    ICharacterClass AZ = factory.fromRange(65, 90);
    ICharacterClass az = factory.fromRange(97, 122);
    ICharacterClass fullRange = factory.fromRange(0, MAX_CHAR);

    ICharacterClass c = factory.fromSingle(99);
    ICharacterClass x = factory.fromSingle(120);
    ICharacterClass eof = factory.fromSingle(EOF_INT);

    protected abstract ICharacterClassFactory getCharacterClassFactory();

    protected void testCharacterClass(ICharacterClass characters, Predicate<Integer> contains) {
        for(int i = 0; i < CHARACTERS; i++) {
            assertEquals("Character " + i + " ('" + CharacterClassFactory.intToString(i) + "') for character class "
                + characters.toString() + ":", contains.test(i), characters.contains(i));
        }
        assertEquals("Character EOF for character class " + characters.toString() + ":", contains.test(EOF_INT),
            characters.contains(EOF_INT));
    }

    protected void testCharacterClass(ICharacterClass one, ICharacterClass two) {
        for(int i = 0; i < CHARACTERS; i++) {
            assertEquals("Character " + i + " ('" + CharacterClassFactory.intToString(i) + "') for character classes "
                + one.toString() + " vs. " + two.toString() + ":", two.contains(i), one.contains(i));
        }
        assertEquals("Character EOF for character classes " + one.toString() + " vs. " + two.toString() + ":",
            two.contains(EOF_INT), one.contains(EOF_INT));
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
        ICharacterClass characters = factory.fromSingle(EOF_INT);

        testCharacterClass(characters, character -> character == EOF_INT);
    }

    @Test public void testRangeEOFunion() {
        ICharacterClass characters = az.union(factory.fromSingle(EOF_INT));

        testCharacterClass(characters, character -> 97 <= character && character <= 122 || character == EOF_INT);
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
        assertEquals("[256]", eof.toAtermList(tf).toString()); // TODO proper EOF
        assertEquals("[range(0,256)]", fullRange.union(eof).toAtermList(tf).toString());
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
