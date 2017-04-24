package org.metaborg.newsdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassRange extends Symbol {

    private static final long serialVersionUID = -2780861845660502755L;

    private final Symbol start;
    private final Symbol end;

    public CharacterClassRange(Symbol iSymbol, Symbol iSymbol2) {
        this.start = iSymbol;
        this.end = iSymbol2;
    }

    public String name() {
        return start.name() + "-" + end.name();
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("range", 2), start.toAterm(tf), end.toAterm(tf));
    }

    public Symbol union(Symbol cc) {
        // TODO Create union method
        return null;
    }

    public boolean contains(int c) {
        return c >= minimum() && c <= maximum();
    }

    public int minimum() {
        int minimum = Integer.MAX_VALUE;

        if(start instanceof CharacterClassNumeric) {
            minimum = ((CharacterClassNumeric) start).minimum();
        } else if(start instanceof CharacterClassRange) {
            minimum = ((CharacterClassRange) start).minimum();
        } else {
            minimum = ((CharacterClassConc) start).minimum();
        }
        return minimum;
    }

    public int maximum() {
        int maximum = Integer.MIN_VALUE;
        if(end instanceof CharacterClassNumeric) {
            maximum = ((CharacterClassNumeric) end).maximum();
        } else if(end instanceof CharacterClassRange) {
            maximum = ((CharacterClassRange) end).maximum();
        } else {
            maximum = ((CharacterClassConc) end).maximum();
        }
        return maximum;
    }

    public CharacterClass difference(CharacterClass[] ary) {
        // We want to find all sub ranges that are not included in {restrictions}.
        // min and max correspond to the current valid range.
        int min = -1;
        int max = -1;

        // The final restricted terminal.
        Symbol rt = null;

        if(!(start instanceof CharacterClassNumeric && end instanceof CharacterClassNumeric)) {
            return null;
        }

        int start_value = ((CharacterClassNumeric) start).getCharacter();
        int end_value = ((CharacterClassNumeric) end).getCharacter();


        // For each value of the range (plus a last iteration).
        for(int i = start_value; i <= end_value + 1; ++i) {
            boolean ok = false; // The value is valid or not (restricted or not).

            // if we are in the range...
            if(i <= end_value) {
                ok = true;
                for(CharacterClass r : ary) {
                    if(r.contains(i)) {
                        ok = false; // invalid.
                        break;
                    }
                }

                if(ok) { // We augment our current range (or create it if min == -1).
                    if(min == -1)
                        min = i;
                    max = i;
                }
            }

            // We are out of a valid range, but we have detected one.
            if(!ok && min != -1) {
                Symbol t;
                if(min == max)
                    t = new CharacterClassNumeric(min); // Single-value range, a numeric.
                else
                    t = new CharacterClassRange(new CharacterClassNumeric(min), new CharacterClassNumeric(max));

                if(rt == null)
                    rt = t; // it's the first, and may be the only, range.
                else
                    rt = new CharacterClassConc(rt, t); // Not the first one, we merge them.
                min = max = -1;
            }
        }

        return new CharacterClass(rt);
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        return tf.makeAppl(tf.makeConstructor("Range", 2), start.toSDF3Aterm(tf, ctx_vals, ctx_val),
            end.toSDF3Aterm(tf, ctx_vals, ctx_val));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        CharacterClassRange other = (CharacterClassRange) obj;
        if(end == null) {
            if(other.end != null)
                return false;
        } else if(!end.equals(other.end))
            return false;
        if(start == null) {
            if(other.start != null)
                return false;
        } else if(!start.equals(other.start))
            return false;
        return true;
    }
}
