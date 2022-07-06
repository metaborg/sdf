package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.util.List;
import java.util.Objects;

import org.metaborg.sdf2table.grammar.ISymbol;

public class ArithmeticLayoutConstraint implements ILayoutConstraintExpression {

    private static final long serialVersionUID = -4493714282273340221L;

    private final ILayoutConstraintExpression c1;
    private final LayoutConstraintArithmeticOperator op;
    private final ILayoutConstraintExpression c2;

    public ArithmeticLayoutConstraint(ILayoutConstraintExpression c1, LayoutConstraintArithmeticOperator op,
            ILayoutConstraintExpression c2) {
        this.c1 = c1;
        this.op = op;
        this.c2 = c2;
    }

    @Override public String toString() {
        return this.c1.toString() + " " + this.op.toString() + " " + this.c2.toString();
    }

    public ILayoutConstraintExpression getC1() {
        return this.c1;
    }

    public LayoutConstraintArithmeticOperator getOp() {
        return this.op;
    }

    public ILayoutConstraintExpression getC2() {
        return this.c2;
    }

    @Override public void normalizeConstraint(List<ISymbol> rhs) {
        this.c1.normalizeConstraint(rhs);
        this.c2.normalizeConstraint(rhs);
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof ArithmeticLayoutConstraint)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        ArithmeticLayoutConstraint c = (ArithmeticLayoutConstraint) other;
        return Objects.equals(this.c1, c.c1) && this.op == c.op && Objects.equals(this.c2, c.c2);
    }
}
