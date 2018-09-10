package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;

import org.metaborg.sdf2table.grammar.Symbol;

public class ArithmeticLayoutConstraint implements Serializable, ILayoutConstraint {
    private static final long serialVersionUID = -4493714282273340221L;

    private final ILayoutConstraint c1;
    private final LayoutConstraintArithmeticOperator op;
    private final ILayoutConstraint c2;    
    
    public ArithmeticLayoutConstraint(ILayoutConstraint c1, LayoutConstraintArithmeticOperator op,
        ILayoutConstraint c2) {
        this.c1 = c1;
        this.op = op;
        this.c2 = c2;
    }
    
    @Override public String toString() {        
        return c1.toString() + " " + op.toString() + " " + c2.toString();
    }

    public ILayoutConstraint getC1() {
        return c1;
    }

    public LayoutConstraintArithmeticOperator getOp() {
        return op;
    }

    public ILayoutConstraint getC2() {
        return c2;
    }

    @Override public void normalizeConstraint(List<Symbol> rhs) {
        c1.normalizeConstraint(rhs);
        c2.normalizeConstraint(rhs);
        
    }
    
}
