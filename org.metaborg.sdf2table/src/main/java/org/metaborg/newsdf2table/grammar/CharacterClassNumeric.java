package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassNumeric extends Symbol {

    Integer character;
    
    public CharacterClassNumeric() {
        character = null;
    }
    
    public CharacterClassNumeric(Integer c) {
        character = c;
    }

    @Override public String name() {
        String name = "\\";
        name += character.intValue();
        return name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {        
        return tf.makeInt(character);
    }
    
}
