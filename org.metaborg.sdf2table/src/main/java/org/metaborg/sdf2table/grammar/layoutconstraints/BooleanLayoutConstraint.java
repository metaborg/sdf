package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.util.List;
import java.util.Objects;

import org.metaborg.sdf2table.grammar.ISymbol;

public class BooleanLayoutConstraint implements ILayoutConstraint {

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
        if (this.op == LayoutConstraintBooleanOperator.NOT) {
            return this.op.toString() + " " + this.c1.toString();
        } else {
            return this.c1.toString() + " " + this.op.toString() + " " + this.c2.toString();
        }
    }

    public ILayoutConstraint getC1() {
        return this.c1;
    }

    public LayoutConstraintBooleanOperator getOp() {
        return this.op;
    }

    public ILayoutConstraint getC2() {
        return this.c2;
    }

    @Override public void normalizeConstraint(List<ISymbol> rhs) {
        this.c1.normalizeConstraint(rhs);
        this.c2.normalizeConstraint(rhs);
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof BooleanLayoutConstraint)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        BooleanLayoutConstraint c = (BooleanLayoutConstraint) other;
        return Objects.equals(this.c1, c.c1) && this.op == c.op && Objects.equals(this.c2, c.c2);
    }
}
