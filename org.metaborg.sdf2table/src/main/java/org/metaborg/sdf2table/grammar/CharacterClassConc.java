package org.metaborg.sdf2table.grammar;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.parsetable.Context;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class CharacterClassConc extends Symbol {

    private static final long serialVersionUID = 2234615652745897097L;

    private final Symbol first;
    private final Symbol second;

    public CharacterClassConc(Symbol first, Symbol second) {
        this.first = first;
        this.second = second;
    }

    public String name() {
        return first.name() + second.name();
    }

    public boolean contains(int c) {
        boolean contains_first = false, contains_second = false;

        if(first instanceof CharacterClassNumeric) {
            contains_first = ((CharacterClassNumeric) first).contains(c);
        } else if(first instanceof CharacterClassRange) {
            contains_first = ((CharacterClassRange) first).contains(c);
        } else {
            contains_first = ((CharacterClassConc) first).contains(c);
        }

        if(second instanceof CharacterClassNumeric) {
            contains_second = ((CharacterClassNumeric) second).contains(c);
        } else if(second instanceof CharacterClassRange) {
            contains_second = ((CharacterClassRange) second).contains(c);
        } else {
            contains_second = ((CharacterClassConc) second).contains(c);
        }

        return contains_first || contains_second;
    }

    public Symbol union(Symbol cc) {
        // TODO Create union method
        return null;
    }

    public int minimum() {
        int minimum = Integer.MAX_VALUE;

        if(first instanceof CharacterClassNumeric) {
            minimum = ((CharacterClassNumeric) first).minimum();
        } else if(first instanceof CharacterClassRange) {
            minimum = ((CharacterClassRange) first).minimum();
        } else {
            minimum = ((CharacterClassConc) first).minimum();
        }

        return minimum;
    }

    public int maximum() {
        int maximum = Integer.MIN_VALUE;

        if(second instanceof CharacterClassNumeric) {
            maximum = ((CharacterClassNumeric) second).maximum();
        } else if(second instanceof CharacterClassRange) {
            maximum = ((CharacterClassRange) second).maximum();
        } else {
            maximum = ((CharacterClassConc) second).maximum();
        }

        return maximum;
    }

    public CharacterClass difference(CharacterClass[] ary) {
        CharacterClass cc_first;
        CharacterClass cc_second;


        if(first instanceof CharacterClassNumeric) {
            cc_first = ((CharacterClassNumeric) first).difference(ary);
        } else if(first instanceof CharacterClassRange) {
            cc_first = ((CharacterClassRange) first).difference(ary);
        } else {
            cc_first = ((CharacterClassConc) first).difference(ary);
        }

        if(second instanceof CharacterClassNumeric) {
            cc_second = ((CharacterClassNumeric) second).difference(ary);
        } else if(second instanceof CharacterClassRange) {
            cc_second = ((CharacterClassRange) second).difference(ary);
        } else {
            cc_second = ((CharacterClassConc) second).difference(ary);
        }

        if(cc_first != null && cc_second == null)
            return cc_first;
        if(cc_first == null && cc_second != null)
            return cc_second;
        if(cc_first != null && cc_second != null)
            return CharacterClass.union(cc_first, cc_second);

        return new CharacterClass(null);
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        List<IStrategoTerm> terms = Lists.newArrayList();

        IStrategoTerm firstAterm = first.toAterm(tf);
        IStrategoTerm secondAterm = second.toAterm(tf);

        if(firstAterm instanceof IStrategoList) {
            for(IStrategoTerm t : firstAterm.getAllSubterms()) {
                terms.add(t);
            }
        } else {
            terms.add(firstAterm);
        }

        if(secondAterm instanceof IStrategoList) {
            for(IStrategoTerm t : secondAterm.getAllSubterms()) {
                terms.add(t);
            }
        } else {
            terms.add(secondAterm);
        }

        return tf.makeList(terms);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Conc", 2), first.toSDF3Aterm(tf, ctx_vals, ctx_val), second.toSDF3Aterm(tf, ctx_vals, ctx_val));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        CharacterClassConc other = (CharacterClassConc) obj;
        if(first == null) {
            if(other.first != null)
                return false;
        } else if(!first.equals(other.first))
            return false;
        if(second == null) {
            if(other.second != null)
                return false;
        } else if(!second.equals(other.second))
            return false;
        return true;
    }

}
