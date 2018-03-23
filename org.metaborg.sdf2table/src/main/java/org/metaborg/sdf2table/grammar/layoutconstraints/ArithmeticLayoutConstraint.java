package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;

public class ArithmeticLayoutConstraint implements Serializable, ILayoutConstraint {
    private static final long serialVersionUID = -4493714282273340221L;

    ILayoutConstraint c1;
    LayoutConstraintArithmeticOperator op;
    ILayoutConstraint c2;    
    
    public ArithmeticLayoutConstraint(ILayoutConstraint c1, LayoutConstraintArithmeticOperator op,
        ILayoutConstraint c2) {
        this.c1 = c1;
        this.op = op;
        this.c2 = c2;
    }
    
    @Override public String toString() {        
        return c1.toString() + " " + op.toString() + " " + c2.toString();
    }
    
}
