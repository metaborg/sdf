package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClass implements ICharacterClass, Serializable {

    private static final long serialVersionUID = 418963364528944597L;

    private static final ILogger logger = LoggerUtils.logger(ParseTable.class);

    private final BitSet chars;
    private final boolean containsEOF;

    public CharacterClass(BitSet chars, boolean eof) {
        this.chars = chars;
        this.containsEOF = eof;
    }

    @Override public boolean contains(int character) {
        return character == EOF_INT ? containsEOF : chars.get(character);
    }

    @Override public int min() {
        return chars.nextSetBit(0);
    }

    @Override public int max() {
        return chars.previousSetBit(CHARACTERS - 1);
    }

    @Override public boolean isEmpty() {
        return chars.isEmpty();
    }

    @Override public ICharacterClass setEOF(boolean eof) {
        return eof == this.containsEOF ? this : new CharacterClass((BitSet) chars.clone(), eof);
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        if(other instanceof CharacterClass) {
            BitSet result = (BitSet) chars.clone();
            result.or(((CharacterClass) other).chars);
            return new CharacterClass(result, this.containsEOF || ((CharacterClass) other).containsEOF);
        } else {
           throw new IllegalStateException("Cannot perform operation on different character class.");
        }
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        if(other instanceof CharacterClass) {
            BitSet result = (BitSet) chars.clone();
            result.and(((CharacterClass) other).chars);
            return new CharacterClass(result, this.containsEOF && ((CharacterClass) other).containsEOF);
        } else {
            throw new IllegalStateException("Cannot perform operation on different character class.");
        }
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        if(other instanceof CharacterClass) {
            BitSet result = (BitSet) chars.clone();
            BitSet otherComplement = (BitSet) ((CharacterClass) other).chars.clone();
            otherComplement.flip(0, CHARACTERS);
            result.and(otherComplement);
            return new CharacterClass(result, this.containsEOF && !((CharacterClass) other).containsEOF);
        } else {
            throw new IllegalStateException("Cannot perform operation on different character class.");
        }
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) { // TODO include EOF
        List<IStrategoTerm> terms = new ArrayList<>();
        int lowerBound = chars.nextSetBit(0);
        while(lowerBound != -1 && lowerBound <= 256) {
            int upperBound = chars.nextClearBit(lowerBound);

            if(lowerBound == upperBound + 1) {
                terms.add(tf.makeInt(lowerBound));
            } else {
                terms.add(tf.makeAppl(tf.makeConstructor("range", 2), tf.makeInt(lowerBound), tf.makeInt(upperBound)));
            }

            lowerBound = chars.nextSetBit(upperBound);
        }

        return tf.makeList(terms);
    }

}
