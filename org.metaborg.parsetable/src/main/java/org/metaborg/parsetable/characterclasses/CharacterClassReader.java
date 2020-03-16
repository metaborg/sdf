package org.metaborg.parsetable.characterclasses;

import static org.spoofax.terms.util.TermUtils.*;

import java.util.Arrays;

import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class CharacterClassReader {

    protected final ICharacterClassFactory characterClassFactory;

    public CharacterClassReader(ICharacterClassFactory characterClassFactory) {
        this.characterClassFactory = characterClassFactory;
    }

    public ICharacterClass read(IStrategoList characterClassTermList) {
        ICharacterClass characterClass = null;

        for(IStrategoTerm characterClassTerm : characterClassTermList) {
            ICharacterClass characterClassForTerm;

            if(isInt(characterClassTerm)) {
                int character = toJavaInt(characterClassTerm);
                if(character == 256) // The legacy way of representing EOF (parse table version 6 and below)
                    characterClassForTerm = characterClassFactory.fromEmpty().setEOF(true);
                else
                    characterClassForTerm = characterClassFactory.fromSingle(character);
            } else { // range(from,to)
                int from = toJavaIntAt(characterClassTerm, 0);
                int to = toJavaIntAt(characterClassTerm, 1);

                if(to == 256) // The legacy way of representing EOF (parse table version 6 and below)
                    characterClassForTerm = characterClassFactory.fromRange(from, 255).setEOF(true);
                else
                    characterClassForTerm = characterClassFactory.fromRange(from, to);
            }

            if(characterClass == null)
                characterClass = characterClassForTerm;
            else if(characterClassForTerm != null)
                characterClass = characterClass.union(characterClassForTerm);
        }

        return characterClassFactory.finalize(characterClass);
    }

    public static class V7 extends CharacterClassReader {
        public V7(ICharacterClassFactory characterClassFactory) {
            super(characterClassFactory);
        }

        // This method exploits the fact that the ranges are already sorted.
        @Override public ICharacterClass read(IStrategoList characterClassTermList) {
            int[] ranges = new int[characterClassTermList.getSubtermCount() * 2];

            int i = 0;
            for(IStrategoTerm characterClassTerm : characterClassTermList) {
                if(isInt(characterClassTerm)) {
                    int character = toJavaInt(characterClassTerm);
                    ranges[i++] = character;
                    ranges[i++] = character;
                } else if("eof".equals(((IStrategoAppl) characterClassTerm).getName())) {
                    // In the parse table, EOF is always the last entry in the character class
                    return characterClassFactory
                        .finalize(characterClassFactory.fromRanges(Arrays.copyOf(ranges, ranges.length - 2), true));
                } else { // range(from,to)
                    int from = toJavaIntAt(characterClassTerm, 0);
                    int to = toJavaIntAt(characterClassTerm, 1);
                    ranges[i++] = from;
                    ranges[i++] = to;
                }
            }

            return characterClassFactory.finalize(characterClassFactory.fromRanges(ranges, false));
        }
    }

}
