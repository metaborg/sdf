package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintBooleanOperator {
    AND("&&"),
    OR("||"),
    NOT("!");

    private final String str;

    private LayoutConstraintBooleanOperator(String str) {
        this.str = str;
    }

    @Override public String toString() {
        return this.str;
    }
}
