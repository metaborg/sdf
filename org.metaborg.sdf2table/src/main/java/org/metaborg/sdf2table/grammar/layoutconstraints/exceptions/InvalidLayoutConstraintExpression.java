package org.metaborg.sdf2table.grammar.layoutconstraints.exceptions;

import org.spoofax.interpreter.terms.IStrategoTerm;

public class InvalidLayoutConstraintExpression extends LayoutConstraintException {

    private static final long serialVersionUID = -3440718716034087519L;

    public InvalidLayoutConstraintExpression(IStrategoTerm c) {
        super("Not a valid Layout Constraint Expression: " + c.toString());
    }

    public InvalidLayoutConstraintExpression(String invalid, Throwable cause) {
        super("Not a valid Layout Constraint: " + invalid, cause);
    }
}
