package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class LayoutConstraintNewAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = -6962864785117290116L;

    private final LayoutConstraintType typeExp1;
    private final int indexExp1;    
    private final LayoutConstraintType typeExp2;
    private final int indexExp2;
    private final String operator;
    
    private final boolean noLayoutConstraint;
    
    public LayoutConstraintNewAttribute(LayoutConstraintType typeExp1, int indexExp1, LayoutConstraintType typeExp2,
        int indexExp2, String operator) {
        this.typeExp1 = typeExp1;
        this.indexExp1 = indexExp1;
        this.typeExp2 = typeExp2;
        this.indexExp2 = indexExp2;
        this.operator = operator;
        this.noLayoutConstraint = false;
    }
    
    public LayoutConstraintNewAttribute(boolean noLayoutConstraint) {
        this.noLayoutConstraint = noLayoutConstraint;
        this.typeExp1 = null;
        this.indexExp1 = -1;
        this.typeExp2 = null;
        this.indexExp2 = -1;
        this.operator = null;
    }

    @Override public String toString() {
        return "lc(\"" + typeExp1 + "(" + indexExp1 + ")" + " " + operator + " " + typeExp2 + "(" + indexExp2 + ")" + "\")";
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("term", 1),
            tf.makeAppl(tf.makeConstructor("lc", 1), tf.makeString("" + typeExp1 + " " + operator + " " + typeExp2)));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        return tf.makeAppl(tf.makeConstructor("Term", 1),
            tf.makeAppl(tf.makeConstructor("lc", 1), tf.makeString("" + typeExp1 + " " + operator + " " + typeExp2)));
    }

    public LayoutConstraintType getTypeExp1() {
        return typeExp1;
    }

    public int getIndexExp1() {
        return indexExp1;
    }

    public LayoutConstraintType getTypeExp2() {
        return typeExp2;
    }

    public int getIndexExp2() {
        return indexExp2;
    }

    public String getOperator() {
        return operator;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + indexExp1;
        result = prime * result + indexExp2;
        result = prime * result + ((operator == null) ? 0 : operator.hashCode());
        result = prime * result + ((typeExp1 == null) ? 0 : typeExp1.hashCode());
        result = prime * result + ((typeExp2 == null) ? 0 : typeExp2.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        LayoutConstraintNewAttribute other = (LayoutConstraintNewAttribute) obj;
        if(indexExp1 != other.indexExp1)
            return false;
        if(indexExp2 != other.indexExp2)
            return false;
        if(operator == null) {
            if(other.operator != null)
                return false;
        } else if(!operator.equals(other.operator))
            return false;
        if(typeExp1 != other.typeExp1)
            return false;
        if(typeExp2 != other.typeExp2)
            return false;
        return true;
    }



    public boolean isNoLayoutConstraint() {
        return noLayoutConstraint;
    }
    
    
}
