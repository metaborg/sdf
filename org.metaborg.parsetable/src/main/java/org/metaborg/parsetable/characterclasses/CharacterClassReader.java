package org.metaborg.parsetable.characterclasses;

import static org.metaborg.parsetable.characterclasses.ICharacterClass.EOF_INT;
import static org.spoofax.terms.util.TermUtils.*;

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

        @Override public ICharacterClass read(IStrategoList characterClassTermList) {
            ICharacterClass characterClass = null;

            for(IStrategoTerm characterClassTerm : characterClassTermList) {
                ICharacterClass characterClassForTerm;

                if(isInt(characterClassTerm)) {
                    characterClassForTerm = characterClassFactory.fromSingle(toJavaInt(characterClassTerm));
                } else if("eof".equals(((IStrategoAppl) characterClassTerm).getName())) {
                    characterClassForTerm = characterClassFactory.fromSingle(EOF_INT);
                } else { // range(from,to)
                    int from = toJavaIntAt(characterClassTerm, 0);
                    int to = toJavaIntAt(characterClassTerm, 1);
                    characterClassForTerm = characterClassFactory.fromRange(from, to);
                }

                if(characterClass == null)
                    characterClass = characterClassForTerm;
                else if(characterClassForTerm != null)
                    characterClass = characterClass.union(characterClassForTerm);
            }

            return characterClassFactory.finalize(characterClass);
        }
    }

}
