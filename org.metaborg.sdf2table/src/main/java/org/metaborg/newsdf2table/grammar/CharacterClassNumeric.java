package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassNumeric extends Symbol {

    Integer character;
    
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
    
//    public Symbol union(Symbol cc) {
//        return null;
//    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((character == null) ? 0 : character.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        CharacterClassNumeric other = (CharacterClassNumeric) obj;
        if(character == null) {
            if(other.character != null)
                return false;
        } else if(!character.equals(other.character))
            return false;
        return true;
    }

    public boolean contains(int c) {
        return character == c;
    }

    public int minimum() {
        return character;
    }

    public int maximum() {
        return character;
    }

    public CharacterClass difference(CharacterClass[] ary) {
        for(CharacterClass r : ary){
            if(r.contains(character))
                return null;
        }
        return new CharacterClass(this);
    }
    
}
