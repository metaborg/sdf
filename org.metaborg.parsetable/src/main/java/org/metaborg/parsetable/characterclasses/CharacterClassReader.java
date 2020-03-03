package org.metaborg.parsetable.characterclasses;

import static org.spoofax.terms.Term.*;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.util.TermUtils;

public class CharacterClassReader {

    private final ICharacterClassFactory characterClassFactory;

    public CharacterClassReader(ICharacterClassFactory characterClassFactory) {
        this.characterClassFactory = characterClassFactory;
    }

    public ICharacterClass read(IStrategoList characterClassTermList) {
        ICharacterClass characterClass = null;

        for(IStrategoTerm characterClassTerm : characterClassTermList.getSubterms()) {
            ICharacterClass characterClassForTerm;

            if(TermUtils.isInt(characterClassTerm)) {
                characterClassForTerm = characterClassFactory.fromSingle(javaInt(characterClassTerm));
            } else {
                int from = TermUtils.toJavaIntAt(characterClassTerm, 0);
                int to = TermUtils.toJavaIntAt(characterClassTerm, 1);

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
