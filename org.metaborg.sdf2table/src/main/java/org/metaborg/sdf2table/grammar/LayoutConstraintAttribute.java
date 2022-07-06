package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.metaborg.sdf2table.grammar.layoutconstraints.ArithmeticLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.BooleanLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.ComparisonLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.ConstraintElement;
import org.metaborg.sdf2table.grammar.layoutconstraints.ConstraintSelector;
import org.metaborg.sdf2table.grammar.layoutconstraints.ILayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.ILayoutConstraintExpression;
import org.metaborg.sdf2table.grammar.layoutconstraints.LayoutConstraintArithmeticOperator;
import org.metaborg.sdf2table.grammar.layoutconstraints.LayoutConstraintBooleanOperator;
import org.metaborg.sdf2table.grammar.layoutconstraints.LayoutConstraintComparisonOperator;
import org.metaborg.sdf2table.grammar.layoutconstraints.NumericLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.TreeRef;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidLayoutConstraintExpression;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidPosRef;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidTreeSelector;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.LayoutConstraintException;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoString;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.util.TermUtils;

public class LayoutConstraintAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = -6962864785117290116L;

    private final boolean ignoreLayout;
    private final ILayoutConstraint lc;

    private final IStrategoTerm constraint;

    protected LayoutConstraintAttribute(IStrategoTerm constraint) throws LayoutConstraintException {
        this.constraint = constraint;

        if (((IStrategoAppl) constraint).getName().equals("IgnoreLayout")) {
            this.ignoreLayout = true;
            this.lc = null;
        } else {
            this.ignoreLayout = false;
            this.lc = this.createLayoutConstraint(constraint);
        }
    }

    @Override public String toString() {
        if (this.ignoreLayout) {
            return "ignore-layout";
        } else {
            return this.lc.toString();
        }
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if (this.ignoreLayout) {
            return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor("ignore-layout", 0)));
        }

        try {
            IStrategoTerm sdf2Constraint = this.toSDF2constraint(this.constraint, tf);
            return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor("layout", 1),
                (sdf2Constraint != null ? sdf2Constraint : tf.makeAppl(tf.makeConstructor("null", 0)))));
        } catch(Exception e) {
            System.err.println("Layout constraint could not be transformed to SDF2 constraint.");
            return tf.makeAppl(tf.makeConstructor("layout", 1), tf.makeAppl(tf.makeConstructor("null", 0)));
        }
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        if (this.ignoreLayout) {
            return tf.makeAppl(tf.makeConstructor("Term", 1), tf.makeAppl(tf.makeConstructor("IgnoreLayout", 0)));
        }

        return tf.makeAppl(tf.makeConstructor("Term", 1), tf.makeAppl(tf.makeConstructor("layout", 1), this.constraint));
    }

    public boolean ignoreLayout() {
        return this.ignoreLayout;
    }

    public ILayoutConstraint getLayoutConstraint() {
        return this.lc;
    }

    private ILayoutConstraint createLayoutConstraint(IStrategoTerm c) throws LayoutConstraintException {
        if (!TermUtils.isAppl(c)) {
            throw new InvalidLayoutConstraint(c);
        }
        final String termName = ((IStrategoAppl) c).getName();
        try {
            switch (termName) {
                case "And":
                    return new BooleanLayoutConstraint(createLayoutConstraint(c.getSubterm(0)),
                        LayoutConstraintBooleanOperator.AND, createLayoutConstraint(c.getSubterm(1)));
                case "Or":
                    return new BooleanLayoutConstraint(createLayoutConstraint(c.getSubterm(0)),
                        LayoutConstraintBooleanOperator.OR, createLayoutConstraint(c.getSubterm(1)));
                case "Not":
                    return new BooleanLayoutConstraint(createLayoutConstraint(c.getSubterm(0)),
                        LayoutConstraintBooleanOperator.NOT, null);
                case "Lt":
                    return new ComparisonLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintComparisonOperator.LT, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Gt":
                    return new ComparisonLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintComparisonOperator.GT, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Le":
                    return new ComparisonLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintComparisonOperator.LE, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Ge":
                    return new ComparisonLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintComparisonOperator.GE, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Eq":
                    return new ComparisonLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintComparisonOperator.EQ, createLayoutConstraintExpression(c.getSubterm(1)));
                default:
                    throw new InvalidLayoutConstraint(c);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidLayoutConstraint(c.toString(), e);
        }
    }

    private ILayoutConstraintExpression createLayoutConstraintExpression(IStrategoTerm c) throws LayoutConstraintException {
        if (!TermUtils.isAppl(c)) {
            throw new InvalidLayoutConstraintExpression(c);
        }
        final String termName = ((IStrategoAppl) c).getName();
        try {
            switch (termName) {
                case "Num":
                    return new NumericLayoutConstraint(
                        Integer.parseInt(((IStrategoString) c.getSubterm(0)).stringValue()));
                case "Add":
                    return new ArithmeticLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintArithmeticOperator.ADD, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Sub":
                    return new ArithmeticLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintArithmeticOperator.SUB, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Div":
                    return new ArithmeticLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintArithmeticOperator.DIV, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Mul":
                    return new ArithmeticLayoutConstraint(createLayoutConstraintExpression(c.getSubterm(0)),
                        LayoutConstraintArithmeticOperator.MUL, createLayoutConstraintExpression(c.getSubterm(1)));
                case "Line":
                    return new TreeRef(ConstraintElement.LINE, createToken(c.getSubterm(0)),
                        createTree(c.getSubterm(0).getSubterm(0)));
                case "Col":
                    return new TreeRef(ConstraintElement.COL, createToken(c.getSubterm(0)),
                        createTree(c.getSubterm(0).getSubterm(0)));
                default:
                    throw new InvalidLayoutConstraintExpression(c);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new InvalidLayoutConstraintExpression(c.toString(), e);
        }
    }

    private int createTree(IStrategoTerm term) throws LayoutConstraintException {
        if (TermUtils.isAppl(term) && ((IStrategoAppl) term).getName().equals("PosRef")) {
            try {
                return Integer.parseInt(((IStrategoString) term.getSubterm(0)).stringValue());
            } catch(Exception e) {
                throw new InvalidPosRef(term.toString(), e);
            }
        } else {
            throw new InvalidPosRef(term.toString());
        }
    }

    private ConstraintSelector createToken(IStrategoTerm t) throws LayoutConstraintException {
        if (TermUtils.isAppl(t)) {
            final String termName = ((IStrategoAppl) t).getName();
            switch (termName) {
                case "First":
                    return ConstraintSelector.FIRST;
                case "Last":
                    return ConstraintSelector.LAST;
                case "Left":
                    return ConstraintSelector.LEFT;
                case "Right":
                    return ConstraintSelector.RIGHT;
                default:
                    throw new InvalidTreeSelector(termName);
            }
        } else {
            throw new InvalidTreeSelector(t.toString());
        }
    }

    private IStrategoTerm toSDF2constraint(IStrategoTerm c, ITermFactory tf) throws LayoutConstraintException {
        if (!TermUtils.isAppl(c)) {
            throw new InvalidLayoutConstraint(c);
        }
        final String termName = ((IStrategoAppl) c).getName();

        switch (termName) {
            case "Num":
                return tf.makeAppl(tf.makeConstructor("num", 1), tf.makeString(c.getSubterm(0).toString()));
            case "And":
                return tf.makeAppl(tf.makeConstructor("and", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Or":
                return tf.makeAppl(tf.makeConstructor("or", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Not":
                return tf.makeAppl(tf.makeConstructor("not", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "Lt":
                return tf.makeAppl(tf.makeConstructor("lt", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Gt":
                return tf.makeAppl(tf.makeConstructor("gt", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Le":
                return tf.makeAppl(tf.makeConstructor("le", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Ge":
                return tf.makeAppl(tf.makeConstructor("ge", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Eq":
                return tf.makeAppl(tf.makeConstructor("eq", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Add":
                return tf.makeAppl(tf.makeConstructor("add", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Sub":
                return tf.makeAppl(tf.makeConstructor("sub", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Div":
                return tf.makeAppl(tf.makeConstructor("div", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Mul":
                return tf.makeAppl(tf.makeConstructor("mul", 2), toSDF2constraint(c.getSubterm(0), tf),
                        toSDF2constraint(c.getSubterm(1), tf));
            case "Line":
                return tf.makeAppl(tf.makeConstructor("line", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "Col":
                return tf.makeAppl(tf.makeConstructor("col", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "First":
                return tf.makeAppl(tf.makeConstructor("first", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "Last":
                return tf.makeAppl(tf.makeConstructor("last", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "Left":
                return tf.makeAppl(tf.makeConstructor("left", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "Right":
                return tf.makeAppl(tf.makeConstructor("right", 1), toSDF2constraint(c.getSubterm(0), tf));
            case "PosRef":
                final String tree = c.getSubterm(0).toString();
                return tf.makeInt(Integer.parseInt(tree.substring(1, tree.length() - 1)));
            default:
                throw new InvalidLayoutConstraint(c);
        }
    }
}
