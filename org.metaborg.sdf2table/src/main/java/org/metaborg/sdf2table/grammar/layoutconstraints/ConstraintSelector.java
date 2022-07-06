package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum ConstraintSelector {
    FIRST("first"),
    LEFT("left"),
    RIGHT("right"),
    LAST("last");

    private final String str;

    private ConstraintSelector(String str) {
        this.str = str;
    }

    @Override public String toString() {
        return this.str;
    }
}
