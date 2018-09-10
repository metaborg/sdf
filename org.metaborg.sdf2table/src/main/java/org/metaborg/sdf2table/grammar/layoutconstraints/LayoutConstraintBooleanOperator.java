package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintBooleanOperator {
    AND {
        @Override public String toString() {
            return "&&";
        }
    },
    OR {
        @Override public String toString() {
            return "||";
        }
    },
    NOT {
        @Override public String toString() {
            return "!";
        }
    }
}
