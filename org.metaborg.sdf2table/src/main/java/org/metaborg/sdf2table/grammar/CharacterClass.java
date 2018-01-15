package org.metaborg.sdf2table.grammar;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.metaborg.sdf2table.jsglrinterfaces.ISGLRCharacters;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class CharacterClass extends Symbol implements ISGLRCharacters {

    private static final long serialVersionUID = 1619024888383357090L;

    private final BitSet bs;

    public CharacterClass(BitSet bs) {
        this.bs = bs;
    }

    public BitSet getBitSet() {
        return bs;
    }

    public static CharacterClass union(CharacterClass... ary) {
        BitSet bs = new BitSet(257);

        for(CharacterClass i : ary) {
            if(i.bs != null) {
                bs.or(i.bs);
            }
        }

        return new CharacterClass(bs);
    }

    public static CharacterClass intersection(CharacterClass... ary) {
        BitSet bs = new BitSet(257);
        bs.set(0, 257);

        for(CharacterClass i : ary) {
            if(i.bs != null) {
                bs.and(i.bs);
            }
        }

        return new CharacterClass(bs);
    }

    @Override public boolean containsCharacter(int character) {
        if(bs == null)
            return false;

        return bs.get(character);
    }

    public CharacterClass difference(CharacterClass... ary) {
        if(bs == null)
            return this;

        BitSet diff = (BitSet) bs.clone();

        for(CharacterClass i : ary) {
            BitSet temp = (BitSet) diff.clone();
            temp.and(i.bs);
            diff.xor(temp);
        }

        return new CharacterClass(diff);
    }

    @Override public String name() {
        if(bs == null)
            return "[]";

        String name = "[";
        for(int i = 0; i < 257; i++) {
            if(bs.get(i)) {
                name += "\\" + i;
                int next = bs.nextClearBit(i);
                if(next != i + 1) {
                    name += "-\\" + (next - 1);
                }
                i = next;
            }
        }
        name += "]";
        return name;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if(bs == null) {
            return tf.makeAppl(tf.makeConstructor("char-class", 1), tf.makeList());
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
        if(bs == null) {
            return tf.makeList();
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

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bs == null) ? 0 : bs.hashCode());
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
        if(bs == null) {
            if(other.bs != null)
                return false;
        } else if(!bs.equals(other.bs))
            return false;
        return true;
    }

    public static CharacterClass getFullCharacterClass() {
        BitSet bs = new BitSet(257);
        bs.set(0, 257);
        return new CharacterClass(bs);
    }

    public boolean isEmptyCC() {
        if(bs == null) {
            return true;
        }
        
        if(bs.isEmpty()) {
            return true;
        }
        
        return false;
    }

}
