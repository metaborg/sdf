package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;

import org.metaborg.parsetable.actions.IShift;
import org.metaborg.sdf2table.grammar.CharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class Shift extends Action implements IShift, Serializable {

	private static final long serialVersionUID = -8243181585007870077L;
	private int state;

    public Shift(CharacterClass cc, int state) {
        this.cc = cc;
        this.setState(state);
    }

    public Shift(CharacterClass cc) {
        this.cc = cc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf, ParseTable pt) {
        return tf.makeAppl(tf.makeConstructor("shift", 1), tf.makeInt(state));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + state;
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Shift other = (Shift) obj;
        if(state != other.state)
            return false;
        return true;
    }

    @Override public String toString() {
        return "shift(" + state + ")";
    }

    @Override public int shiftStateId() {
        return state;
    }

}
