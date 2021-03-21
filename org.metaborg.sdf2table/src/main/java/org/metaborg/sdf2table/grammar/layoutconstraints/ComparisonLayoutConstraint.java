package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.metaborg.sdf2table.grammar.ISymbol;

public class ComparisonLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 1242424170982278419L;

    private final ILayoutConstraint c1;
    private final LayoutConstraintComparisonOperator op;
    private final ILayoutConstraint c2;

    public ComparisonLayoutConstraint(ILayoutConstraint c1, LayoutConstraintComparisonOperator op, ILayoutConstraint c2) {
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

    public LayoutConstraintComparisonOperator getOp() {
        return op;
    }

    public ILayoutConstraint getC2() {
        return c2;
    }

    @Override public void normalizeConstraint(List<ISymbol> rhs) {
        c1.normalizeConstraint(rhs);
        c2.normalizeConstraint(rhs);
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof ComparisonLayoutConstraint)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        ComparisonLayoutConstraint c = (ComparisonLayoutConstraint) other;
        return Objects.equals(this.c1, c.c1) && this.op == c.op && Objects.equals(this.c2, c.c2);
    }
}
