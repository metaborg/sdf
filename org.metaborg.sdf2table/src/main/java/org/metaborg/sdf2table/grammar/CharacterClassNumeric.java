package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.parsetable.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassNumeric extends Symbol {

    private static final long serialVersionUID = 3189979808970159756L;

    private final Integer character;

    public CharacterClassNumeric(Integer c) {
        character = c;
    }

    @Override public String name() {
        String name = "\\";
        name += getCharacter().intValue();
        return name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeInt(getCharacter());
    }    

    public boolean contains(int c) {
        return getCharacter() == c;
    }

    public int minimum() {
        return getCharacter();
    }

    public int maximum() {
        return getCharacter();
    }

    public CharacterClass difference(CharacterClass[] ary) {
        for(CharacterClass r : ary) {
            if(r.contains(getCharacter()))
                return new CharacterClass(null);
        }
        return new CharacterClass(this);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Numeric", 1), tf.makeString("\\" + getCharacter()));
    }

    public Integer getCharacter() {
        return character;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((character == null) ? 0 : character.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
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

}
