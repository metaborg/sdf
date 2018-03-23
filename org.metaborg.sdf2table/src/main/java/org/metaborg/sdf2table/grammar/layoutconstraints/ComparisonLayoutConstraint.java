package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;

public class ComparisonLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 1242424170982278419L;

    ILayoutConstraint c1;
    LayoutConstraintComparisonOperator op;
    ILayoutConstraint c2;
    
    public ComparisonLayoutConstraint(ILayoutConstraint c1, LayoutConstraintComparisonOperator op, ILayoutConstraint c2) {
        this.c1 = c1;
        this.op = op;
        this.c2 = c2;
    }
    
    @Override public String toString() {        
        return c1.toString() + " " + op.toString() + " " + c2.toString();
    }
}
