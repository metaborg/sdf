package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintBooleanOperator {
    AND("&&"),
    OR("||"),
    NOT("!");

    private String str;

    LayoutConstraintBooleanOperator(String str) {
        this.str = str;
    }

    @Override public String toString() {
        return str;
    }
}
