package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintArithmeticOperator {
    ADD {
        @Override public String toString() {
            return "+";
        }
    },
    SUB {
        @Override public String toString() {
            return "-";
        }
    },
    MUL {
        @Override public String toString() {
            return "*";
        }
    },
    DIV {
        @Override public String toString() {
            return "/";
        }
    }
}
