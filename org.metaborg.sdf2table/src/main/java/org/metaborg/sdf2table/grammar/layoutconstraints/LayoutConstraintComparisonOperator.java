package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintComparisonOperator {
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<="),
    EQ("==");

    final private String str;

    private LayoutConstraintComparisonOperator(String str) {
        this.str = str;
    }

    @Override public String toString() {
        return str;
    }
}
