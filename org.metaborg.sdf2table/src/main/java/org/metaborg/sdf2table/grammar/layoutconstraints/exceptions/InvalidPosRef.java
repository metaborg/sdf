package org.metaborg.sdf2table.grammar.layoutconstraints.exceptions;

public class InvalidPosRef extends LayoutConstraintException {

    private static final long serialVersionUID = 5788034833947234792L;

    public InvalidPosRef(String invalid) {
        super("Expected valid term corresponding to PosRef, got: " + invalid);
    }

    public InvalidPosRef(String invalid, Throwable cause) {
        super("Expected valid integer for PosRef, got: " + invalid, cause);
    }
}
