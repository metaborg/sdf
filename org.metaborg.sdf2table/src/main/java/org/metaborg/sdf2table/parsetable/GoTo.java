package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;

import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.sdf2table.grammar.CharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class GoTo implements Serializable, IGoto {

    private static final long serialVersionUID = -6437393243737838862L;

    ParseTable pt;
    int label = -1;
    CharacterClass cc = null;
    private int state;

    public GoTo(CharacterClass cc, int toState, ParseTable pt) {
        this.pt = pt;
        this.cc = cc;
        this.setState(toState);
    }

    public GoTo(CharacterClass cc, ParseTable pt) {
        this.pt = pt;
        this.cc = cc;
    }

    public GoTo(int label, int toState, ParseTable pt) {
        this.pt = pt;
        this.label = label;
        this.setState(toState);
    }

    public GoTo(int label, ParseTable pt) {
        this.pt = pt;
        this.label = label;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override public String toString() {
        if(label == -1) {
            return "goto(" + cc + ", " + state + ")";
        }
        return "goto(" + label + ": " + pt.productionLabels().inverse().get(label) + ", " + state + ")";
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cc == null) ? 0 : cc.hashCode());
        result = prime * result + label;
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
        GoTo other = (GoTo) obj;
        if(cc == null) {
            if(other.cc != null)
                return false;
        } else if(!cc.equals(other.cc))
            return false;
        if(label != other.label)
            return false;
        if(state != other.state)
            return false;
        return true;
    }

    public IStrategoTerm toAterm(ITermFactory tf) {
        if(label != -1) {
            return tf.makeAppl(tf.makeConstructor("goto", 2), tf.makeList(tf.makeInt(label)), tf.makeInt(state));
        }
        return tf.makeAppl(tf.makeConstructor("goto", 2), cc.toStateAterm(tf), tf.makeInt(state));
    }

    @Override public int[] productionIds() {
        return new int[] { label };
    }

    @Override public int gotoStateId() {
        return state;
    }

}
