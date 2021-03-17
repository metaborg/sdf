package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum ConstraintElement {
    LINE("line"),
    COL("col");

    final private String str;

    private ConstraintElement(String str) {
        this.str = str;
    }

    @Override public String toString() {
        return str;
    }
}
