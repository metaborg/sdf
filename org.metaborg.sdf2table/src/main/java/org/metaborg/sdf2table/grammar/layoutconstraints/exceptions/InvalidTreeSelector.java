package org.metaborg.sdf2table.grammar.layoutconstraints.exceptions;

public class InvalidTreeSelector extends LayoutConstraintException {

    private static final long serialVersionUID = -7631327537669452625L;

    public InvalidTreeSelector(String invalid) {
        super("Expected first, last, left or right as tree selector, got: " + invalid);
    }

}
