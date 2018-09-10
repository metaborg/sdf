package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum ConstraintElement {
    LINE {
        @Override public String toString() {
            return "line";
        }
    },
    COL {
        @Override public String toString() {
            return "col";
        }
    }
}
