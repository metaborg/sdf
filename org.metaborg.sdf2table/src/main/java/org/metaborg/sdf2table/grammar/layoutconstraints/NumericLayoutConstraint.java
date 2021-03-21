package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.util.List;

import org.metaborg.sdf2table.grammar.ISymbol;

public class NumericLayoutConstraint implements ILayoutConstraintExpression {

    private static final long serialVersionUID = 1761165101221716899L;

    private final int num;

    public NumericLayoutConstraint(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    @Override public String toString() {
        return String.valueOf(this.num);
    }

    @Override public void normalizeConstraint(List<ISymbol> rhs) {}

    @Override public boolean equals(Object other) {
        if (!(other instanceof NumericLayoutConstraint)) {
            return false;
        }
        NumericLayoutConstraint c = (NumericLayoutConstraint) other;
        return this.num == c.num;
    }
}
