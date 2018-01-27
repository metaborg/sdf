package org.metaborg.sdf2table.grammar;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.metaborg.sdf2table.io.ParseTableGenerator;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class CharacterClass extends Symbol implements ICharacterClass {

    private static final long serialVersionUID = 1619024888383357090L;
    private ICharacterClass cc;

    // private final BitSet bs;

    public CharacterClass(ICharacterClass cc) {
        this.cc = cc;
    }

    public boolean contains(int character) {
        return cc.contains(character);
    }

    @Override public String name() {
        return cc.toString();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if(cc == null) {
            return tf.makeAppl(tf.makeConstructor("char-class", 1), tf.makeList());
        }

        // FIXME optimize this based on the concrete implementation of CharacterClass
        BitSet bs = new BitSet();
        for(int i = 0; i < 257; i++) {
            if(cc.contains(i)) {
                bs.set(i);
            }
        }

        List<IStrategoTerm> terms = Lists.newArrayList();
        for(int i = 0; i < 257; i++) {
            if(bs.get(i)) {
                int next = bs.nextClearBit(i);
                if(next != i + 1) {
                    terms.add(tf.makeAppl(tf.makeConstructor("range", 2), tf.makeInt(i), tf.makeInt(next - 1)));
                } else {
                    terms.add(tf.makeInt(i));
                }
                i = next;
            }
        }

        return tf.makeAppl(tf.makeConstructor("char-class", 1), tf.makeList(terms));
    }

    public IStrategoTerm toStateAterm(ITermFactory tf) {
        if(cc == null) {
            return tf.makeList();
        }

        // FIXME optimize this based on the concrete implementation of CharacterClass
        BitSet bs = new BitSet();
        for(int i = 0; i < 257; i++) {
            if(cc.contains(i)) {
                bs.set(i);
            }
        }

        List<IStrategoTerm> terms = Lists.newArrayList();
        for(int i = 0; i < 257; i++) {
            if(bs.get(i)) {
                int next = bs.nextClearBit(i);
                if(next != i + 1) {
                    terms.add(tf.makeAppl(tf.makeConstructor("range", 2), tf.makeInt(i), tf.makeInt(next - 1)));
                } else {
                    terms.add(tf.makeInt(i));
                }
                i = next;
            }
        }


        return tf.makeList(terms);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("CharClass", 1),
            tf.makeAppl(tf.makeConstructor("Simple", 1), tf.makeAppl(tf.makeConstructor("Absent", 0))));

    }

    public static CharacterClass getFullCharacterClass() {
        return new CharacterClass(CharacterClassFactory.FULL_RANGE);
    }

    public boolean isEmptyCC() {
        if(cc == null) {
            return true;
        }

        if(cc.min() == -1 && cc.max() == -1) {
            return true;
        }

        return false;
    }

    public static CharacterClass union(CharacterClass cc1, CharacterClass cc2) {
        if(cc1.cc == null && cc2.cc != null) {
            return cc2;
        }
        if(cc2.cc == null && cc1.cc != null) {
            return cc1;
        }
        if(cc1.cc == null && cc2.cc == null) {
            return new CharacterClass(CharacterClassFactory.EMPTY_CHARACTER_CLASS);
        }

        return new CharacterClass(ParseTableGenerator.getCharacterClassFactory().union(cc1.cc, cc2.cc));
    }

    @Override public int min() {
        return cc.min();
    }

    @Override public int max() {
        return cc.max();
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
        CharacterClass other = (CharacterClass) obj;
        if(cc == null) {
            if(other.cc != null)
                return false;
        } else if(!cc.equals(other.cc))
            return false;
        return true;
    }

    public static CharacterClass intersection(CharacterClass cc1, CharacterClass cc2) {
        return new CharacterClass(ParseTableGenerator.getCharacterClassFactory().intersection(cc1.cc, cc2.cc));
    }

    public CharacterClass difference(CharacterClass cc2) {
        CharacterClass result = new CharacterClass(ParseTableGenerator.getCharacterClassFactory().difference(cc, cc2.cc));
   
        return result;
    }

    @Deprecated public BitSet getBitSet() {
        BitSet bs = new BitSet();
        for(int i = 0; i < 257; i++) {
            if(cc.contains(i)) {
                bs.set(i);
            }
        }
        return bs;
    }
}
