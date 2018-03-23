package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;

public class BooleanLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = -3495667446825489885L;

    ILayoutConstraint c1;
    LayoutConstraintBooleanOperator op;
    ILayoutConstraint c2;

    public BooleanLayoutConstraint(ILayoutConstraint c1, LayoutConstraintBooleanOperator op, ILayoutConstraint c2) {
        this.c1 = c1;
        this.op = op;
        this.c2 = c2;
    }

    @Override public String toString() {
        if(op == LayoutConstraintBooleanOperator.NOT) {
            return op.toString() + c1.toString();
        } else {
            return c1.toString() + " " + op.toString() + " " + c2.toString();
        }
    }
}
