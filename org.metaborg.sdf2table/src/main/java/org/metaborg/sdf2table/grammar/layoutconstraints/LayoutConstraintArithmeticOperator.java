package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum LayoutConstraintArithmeticOperator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    final private String str;

    private LayoutConstraintArithmeticOperator(String str) {
        this.str = str;
    }

    @Override public String toString() {
        return str;
    }
}
