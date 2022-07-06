package org.metaborg.sdf2table.grammar.layoutconstraints.exceptions;

public class LayoutConstraintException extends Exception {

    private static final long serialVersionUID = 7161665365057577606L;

    public LayoutConstraintException(String msg) {
        super(msg);
    }

    public LayoutConstraintException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
