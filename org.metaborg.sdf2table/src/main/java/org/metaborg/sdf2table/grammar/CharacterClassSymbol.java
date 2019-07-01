package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassSymbol extends Symbol {

    private static final long serialVersionUID = 1619024888383357090L;
    private final ICharacterClass cc;

    public CharacterClassSymbol(ICharacterClass cc) {
        this.cc = cc;
    }

    public ICharacterClass getCC() {
        return cc;
    }

    @Override public String name() {
        return cc.toString();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("char-class", 1), toAtermList(tf));
    }

    public IStrategoTerm toAtermList(ITermFactory tf) {
        return cc == null ? tf.makeList() : cc.toAtermList(tf);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("CharClass", 1),
            tf.makeAppl(tf.makeConstructor("Simple", 1), tf.makeAppl(tf.makeConstructor("Absent", 0))));

    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cc == null) ? 0 : cc.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        CharacterClassSymbol other = (CharacterClassSymbol) obj;
        if(cc == null) {
            if(other.cc != null)
                return false;
        } else if(!cc.equals(other.cc))
            return false;
        return true;
    }
}
