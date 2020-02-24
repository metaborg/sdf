package org.metaborg.parsetable.characterclasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.metaborg.parsetable.characterclasses.ICharacterClass.*;

import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.Test;
import org.spoofax.terms.TermFactory;

public abstract class AbstractCharacterClassTest {

    final ICharacterClassFactory factory = getCharacterClassFactory();

    final ICharacterClass empty = factory.fromEmpty();

    final ICharacterClass AZ = factory.fromRange('A', 'Z');
    final ICharacterClass az = factory.fromRange('a', 'z');
    final ICharacterClass fullRange = factory.fromRange(0, MAX_CHAR);

    final ICharacterClass c = factory.fromSingle('c');
    final ICharacterClass d = factory.fromSingle('d');
    final ICharacterClass x = factory.fromSingle('x');
    final ICharacterClass eof = factory.fromSingle(EOF_INT);

    protected abstract ICharacterClassFactory getCharacterClassFactory();

    protected void testCharacterClass(ICharacterClass characters, Predicate<Integer> contains) {
        for(int i = 0; i < CHARACTERS; i++) {
            if(contains.test(i) != characters.contains(i))
                fail("Character class " + characters.toString() + " failed: expected it to"
                    + (contains.test(i) ? "" : " NOT") + " contain character " + i + " ('"
                    + CharacterClassFactory.intToString(i) + "')");
        }
        assertEquals("Character EOF for character class " + characters.toString() + ":", contains.test(EOF_INT),
            characters.contains(EOF_INT));
    }

    protected void testCharacterClass(ICharacterClass one, ICharacterClass two) {
        for(int i = 0; i < CHARACTERS; i++) {
            if(one.contains(i) != two.contains(i))
                fail("Character classes " + one.toString() + " and " + two.toString() //
                    + " are not equal: Character " + i + " ('" + CharacterClassFactory.intToString(i) + "') is" //
                    + (one.contains(i) ? "" : " NOT") + " in the first but is" //
                    + (two.contains(i) ? "" : " NOT") + " in the second");
        }
        assertEquals("Character EOF for character classes " + one.toString() + " vs. " + two.toString() + ":",
            two.contains(EOF_INT), one.contains(EOF_INT));
    }

    @Test public void testLowerCaseLettersRangeContains() {
        testCharacterClass(az, character -> 97 <= character && character <= 122);

        assertEquals(az.contains('a'), true);
        assertEquals(az.contains('A'), false);
    }

    @Test public void testUppercaseCaseLettersRangeContains() {
        testCharacterClass(AZ, character -> 65 <= character && character <= 90);
    }

    @Test public void testLettersUnionRange() {
        ICharacterClass letters = az.union(AZ);

        testCharacterClass(letters,
            character -> 65 <= character && character <= 90 || 97 <= character && character <= 122);
    }

    @Test public void testLettersIntersectionRange() {
        ICharacterClass letters = az.intersection(AZ);

        testCharacterClass(letters, empty);
    }

    @Test public void testLettersDifferenceRange() {
        ICharacterClass letters = az.intersection(AZ);

        testCharacterClass(letters, empty);
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
        testCharacterClass(factory.fromSingle(EOF_INT), character -> character == EOF_INT);
        testCharacterClass(factory.fromSingle(EOF_INT).setEOF(true), character -> character == EOF_INT);
        testCharacterClass(factory.fromSingle(EOF_INT).setEOF(false), character -> false);
        testCharacterClass(c.setEOF(true), character -> character == 'c' || character == EOF_INT);
        testCharacterClass(c.setEOF(false), character -> character == 'c');
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
        testCharacterClass(eof.difference(az.union(eof)), empty);
    }

    @Test public void testOperationsWithEmpty() {
        testCharacterClass(factory.fromRange(10, 20).union(empty), factory.fromRange(10, 20));
        testCharacterClass(factory.fromRange(10, 20).intersection(empty), empty);
        testCharacterClass(factory.fromRange(10, 20).difference(empty), factory.fromRange(10, 20));

        testCharacterClass(empty.union(factory.fromRange(10, 20)), factory.fromRange(10, 20));
        testCharacterClass(empty.intersection(factory.fromRange(10, 20)), empty);
        testCharacterClass(empty.difference(factory.fromRange(10, 20)), empty);
    }

    @Test public void testRangeUnion() {
        testCharacterClass(c.union(c), c);
        testCharacterClass(factory.fromRange('a', 'g').union(c), c -> 'a' <= c && c <= 'g');
        testCharacterClass(factory.fromRange('c', 'e').union(factory.fromRange('f', 'g')), c -> 'c' <= c && c <= 'g');
        testCharacterClass(factory.fromRange('c', 'g').union(factory.fromRange('c', 'e')), c -> 'c' <= c && c <= 'g');
        testCharacterClass(factory.fromRange('d', 'g').union(c), c -> 'c' <= c && c <= 'g');
        testCharacterClass(factory.fromRange('q', 'w').union(x), c -> 'q' <= c && c <= 'x');
        testCharacterClass(factory.fromRange('a', 'b').union(factory.fromRange('d', 'z')).union(c), az);
    }

    @Test public void testRangeIntersect() {
        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromSingle(15)), factory.fromSingle(15));
        testCharacterClass(factory.fromSingle(15).intersection(factory.fromRange(10, 20)), factory.fromSingle(15));

        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromRange(15, 25)),
            factory.fromRange(15, 20));
        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromRange(15, 20)),
            factory.fromRange(15, 20));
        testCharacterClass(factory.fromRange(15, 20).intersection(factory.fromRange(15, 25)),
            factory.fromRange(15, 20));

        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromRange(20, 30)), factory.fromSingle(20));
        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromSingle(20)), factory.fromSingle(20));
        testCharacterClass(factory.fromSingle(20).intersection(factory.fromRange(10, 20)), factory.fromSingle(20));
        testCharacterClass(factory.fromRange(10, 20).intersection(factory.fromSingle(30)), empty);
        testCharacterClass(factory.fromSingle(30).intersection(factory.fromRange(10, 20)), empty);
    }

    @Test public void testRangeDifference() {
        testCharacterClass(c.difference(x), c);
        testCharacterClass(c.union(x).difference(c), x);
        testCharacterClass(c.union(x).difference(x), c);

        testCharacterClass(factory.fromRange(65, 75).difference(factory.fromSingle(70)),
            factory.fromRange(65, 69).union(factory.fromRange(71, 75)));

        testCharacterClass(factory.fromRange(65, 75).difference(factory.fromSingle(80)), factory.fromRange(65, 75));

        testCharacterClass(factory.fromSingle(15).difference(factory.fromRange(10, 20)), empty);

        testCharacterClass(factory.fromRange(65, 70).difference(factory.fromSingle(70)), factory.fromRange(65, 69));

        testCharacterClass(factory.fromRange(65, 70).difference(factory.fromSingle(65)), factory.fromRange(66, 70));

        testCharacterClass(az.difference(c.union(x)).difference(d.union(x)),
            c -> c == 'a' || c == 'b' || 'e' <= c && c <= 'w' || c == 'y' || c == 'z');

        testCharacterClass(az.difference(d.union(x)).difference(c.union(x)),
            c -> c == 'a' || c == 'b' || 'e' <= c && c <= 'w' || c == 'y' || c == 'z');

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
        assertEquals(ICharacterClass.comparator().compare(az, eof), 1);
        assertEquals(ICharacterClass.comparator().compare(eof, az), -1);
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
        assertEquals("[eof]", eof.toAtermList(tf).toString());
        assertEquals("[range(0,1114111),eof]", fullRange.union(eof).toAtermList(tf).toString());
        assertEquals("[range(65,90),eof]", AZ.union(eof).toAtermList(tf).toString());
        assertEquals("[range(65,90),range(97,122)]", AZ.union(az).toAtermList(tf).toString());
        assertEquals("[range(65,90),range(97,122),eof]", AZ.union(az).union(eof).toAtermList(tf).toString());
        assertEquals("[range(97,119),range(121,122)]", az.difference(x).toAtermList(tf).toString());

        assertEquals("[range(97,98),range(100,119),range(121,122)]",
            az.difference(c.union(x)).toAtermList(tf).toString());
        assertEquals("[range(97,98),range(101,119),range(121,122)]",
            az.difference(c.union(x)).difference(d.union(x)).toAtermList(tf).toString());
        assertEquals("[range(97,98),100,range(102,122)]",
            az.difference(factory.fromSingle('e').union(c)).toAtermList(tf).toString());
    }

}
