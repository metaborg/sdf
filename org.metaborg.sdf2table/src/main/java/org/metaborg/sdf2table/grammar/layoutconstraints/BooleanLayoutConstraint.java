package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;

import org.metaborg.sdf2table.grammar.Symbol;

public class BooleanLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = -3495667446825489885L;

    private final ILayoutConstraint c1;
    private final LayoutConstraintBooleanOperator op;
    private final ILayoutConstraint c2;

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

    public ILayoutConstraint getC1() {
        return c1;
    }

    public LayoutConstraintBooleanOperator getOp() {
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
