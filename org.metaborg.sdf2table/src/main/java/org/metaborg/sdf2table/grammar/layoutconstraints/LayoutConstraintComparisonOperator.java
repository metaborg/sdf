package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintComparisonOperator {
    GT {
        @Override public String toString() {
            return ">";
        }
    },
    GE {
        @Override public String toString() {
            return ">=";
        }
    },
    LT {
        @Override public String toString() {
            return "<";
        }
    },
    LE {
        @Override public String toString() {
            return "<=";
        }
    },
    EQ {
        @Override public String toString() {
            return "==";
        }
    }
}
