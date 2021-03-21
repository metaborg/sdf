package org.metaborg.sdf2table.grammar.layoutconstraints.exceptions;

import org.spoofax.interpreter.terms.IStrategoTerm;

public class InvalidLayoutConstraint extends LayoutConstraintException {

    private static final long serialVersionUID = -5989445925533581655L;

    public InvalidLayoutConstraint(IStrategoTerm c) {
        super("Not a valid Layout Constraint: " + c.toString());
    }
}
