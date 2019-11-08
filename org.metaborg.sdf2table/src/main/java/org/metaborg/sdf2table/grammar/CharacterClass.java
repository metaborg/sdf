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
    
    private BitSet chars;
    
    public CharacterClass(BitSet chars) {
        this.chars = chars;
    }
    
    @Override public boolean contains(int character) {
        return chars.get(character);
    }

    @Override public int min() {
        return chars.nextSetBit(0);
    }

    @Override public int max() {
        return chars.previousSetBit(256);
    }

    @Override public boolean isEmpty() {
        return chars.isEmpty();
    }

    @Override public ICharacterClass union(ICharacterClass other) {
        if(other instanceof CharacterClass) {
            BitSet result = (BitSet) chars.clone();
            result.or(((CharacterClass) other).chars);
            return new CharacterClass(result);
        } else {
            logger.error("Cannot perform operation on different character class.");
        }
        
        return null;
    }

    @Override public ICharacterClass intersection(ICharacterClass other) {
        if(other instanceof CharacterClass) {
            BitSet result = (BitSet) chars.clone();
            result.and(((CharacterClass) other).chars);
            return new CharacterClass(result);
        } else {
            logger.error("Cannot perform operation on different character class.");
        }
        
        return null;
    }

    @Override public ICharacterClass difference(ICharacterClass other) {
        if(other instanceof CharacterClass) {
            BitSet result = (BitSet) chars.clone();
            BitSet otherComplement = (BitSet) ((CharacterClass) other).chars.clone();
            otherComplement.flip(0, 257);
            result.and(otherComplement);
            return new CharacterClass(result);
        } else {
            logger.error("Cannot perform operation on different character class.");
        }
        
        return null;
    }

    @Override public IStrategoTerm toAtermList(ITermFactory tf) {
        List<IStrategoTerm> terms = new ArrayList<>();
        int lowerBound = chars.nextSetBit(0);
        while (lowerBound != -1 && lowerBound <= 256) {
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
