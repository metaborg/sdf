package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.metaborg.sdf2table.grammar.layoutconstraints.ArithmeticLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.BooleanLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.ComparisonLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.ConstraintElement;
import org.metaborg.sdf2table.grammar.layoutconstraints.ConstraintSelector;
import org.metaborg.sdf2table.grammar.layoutconstraints.ILayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.IgnoreLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.LayoutConstraintArithmeticOperator;
import org.metaborg.sdf2table.grammar.layoutconstraints.LayoutConstraintBooleanOperator;
import org.metaborg.sdf2table.grammar.layoutconstraints.LayoutConstraintComparisonOperator;
import org.metaborg.sdf2table.grammar.layoutconstraints.NumericLayoutConstraint;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoString;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class LayoutConstraintAttribute implements IAttribute, Serializable {

    private static final long serialVersionUID = -6962864785117290116L;

    private final ILayoutConstraint lc;

    IStrategoTerm constraint;

    public LayoutConstraintAttribute(IStrategoTerm constraint) throws Exception {
        this.constraint = constraint;
        lc = createLayoutConstraint(constraint);
    }

    @Override public String toString() {
        if(constraint instanceof IStrategoAppl && ((IStrategoAppl) constraint).getName().equals("IgnoreLayout")) {
            return "ignore-layout";
        } else {
            return lc.toString();
        }
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if(constraint instanceof IStrategoAppl && ((IStrategoAppl) constraint).getName().equals("IgnoreLayout")) {
            return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor("ignore-layout", 0)));
        }

        try {
            IStrategoTerm sdf2Constraint = toSDF2constraint(constraint, tf);
            return tf.makeAppl(tf.makeConstructor("term", 1), tf.makeAppl(tf.makeConstructor("layout", 1),
                (sdf2Constraint != null ? sdf2Constraint : tf.makeAppl(tf.makeConstructor("null", 0)))));
        } catch(Exception e) {
            System.err.println("Layout constraint could not be transformed to SDF2 constraint.");
            return tf.makeAppl(tf.makeConstructor("layout", 1), tf.makeAppl(tf.makeConstructor("null", 0)));
        }
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf) {
        if(constraint instanceof IStrategoAppl && ((IStrategoAppl) constraint).getName().equals("IgnoreLayout")) {
            return tf.makeAppl(tf.makeConstructor("Term", 1), tf.makeAppl(tf.makeConstructor("IgnoreLayout", 0)));
        }

        return tf.makeAppl(tf.makeConstructor("Term", 1), tf.makeAppl(tf.makeConstructor("layout", 1), constraint));
    }

    public ILayoutConstraint getLayoutConstraint() {
        return lc;
    }

    private ILayoutConstraint createLayoutConstraint(IStrategoTerm constraintTerm) throws Exception {
        if(constraintTerm instanceof IStrategoAppl
            && ((IStrategoAppl) constraintTerm).getName().equals("IgnoreLayout")) {
            return new IgnoreLayoutConstraint();
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("And")) {
            return new BooleanLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintBooleanOperator.AND, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Or")) {
            return new BooleanLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintBooleanOperator.OR, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Not")) {
            return new BooleanLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintBooleanOperator.NOT, null);
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Lt")) {
            return new ComparisonLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintComparisonOperator.LT, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Gt")) {
            return new ComparisonLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintComparisonOperator.GT, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Le")) {
            return new ComparisonLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintComparisonOperator.LE, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Ge")) {
            return new ComparisonLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintComparisonOperator.GE, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Eq")) {
            return new ComparisonLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintComparisonOperator.EQ, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Add")) {
            return new ArithmeticLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintArithmeticOperator.ADD, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Sub")) {
            return new ArithmeticLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintArithmeticOperator.SUB, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Div")) {
            return new ArithmeticLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintArithmeticOperator.DIV, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Mul")) {
            return new ArithmeticLayoutConstraint(createLayoutConstraint(constraintTerm.getSubterm(0)),
                LayoutConstraintArithmeticOperator.ADD, createLayoutConstraint(constraintTerm.getSubterm(1)));
        } else if(constraintTerm instanceof IStrategoAppl
            && ((IStrategoAppl) constraintTerm).getName().equals("Line")) {
            return new NumericLayoutConstraint(ConstraintElement.LINE, createToken(constraintTerm.getSubterm(0)),
                createTree(constraintTerm.getSubterm(0).getSubterm(0)));
        } else if(constraintTerm instanceof IStrategoAppl && ((IStrategoAppl) constraintTerm).getName().equals("Col")) {
            return new NumericLayoutConstraint(ConstraintElement.COL, createToken(constraintTerm.getSubterm(0)),
                createTree(constraintTerm.getSubterm(0).getSubterm(0)));
        } else {
            throw new Exception("Not a valid Layout Constraint: " + constraint);
        }
    }

    private int createTree(IStrategoTerm term) throws Exception {
        if(term instanceof IStrategoAppl && ((IStrategoAppl) term).getName().equals("Tree")) {
            try {
                return Integer.parseInt(((IStrategoString) term.getSubterm(0)).stringValue());
            } catch(Exception e) {
                throw new Exception("Expected valid integer corresponding to tree.");
            }
        } else {
            throw new Exception("Expected valid integer corresponding to tree.");
        }
    }

    private ConstraintSelector createToken(IStrategoTerm t) throws Exception {
        if(t instanceof IStrategoAppl) {
            switch(((IStrategoAppl) t).getName()) {
                case "First":
                    return ConstraintSelector.FIRST;
                case "Last":
                    return ConstraintSelector.LAST;
                case "Left":
                    return ConstraintSelector.LEFT;
                case "Right":
                    return ConstraintSelector.RIGHT;
                default:
                    throw new Exception("Expected first, last, left or right as tree selector.");
            }
        } else {
            throw new Exception("Expected first, last, left or right as tree selector.");
        }
    }

    private IStrategoTerm toSDF2constraint(IStrategoTerm c, ITermFactory tf) throws Exception {
        if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("IgnoreLayout")) {
            return tf.makeAppl(tf.makeConstructor("ignore-layout", 0));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("And")) {
            return tf.makeAppl(tf.makeConstructor("and", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Or")) {
            return tf.makeAppl(tf.makeConstructor("or", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Not")) {
            return tf.makeAppl(tf.makeConstructor("not", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Lt")) {
            return tf.makeAppl(tf.makeConstructor("lt", 1), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Gt")) {
            return tf.makeAppl(tf.makeConstructor("gt", 1), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Le")) {
            return tf.makeAppl(tf.makeConstructor("le", 1), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Ge")) {
            return tf.makeAppl(tf.makeConstructor("ge", 1), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Eq")) {
            return tf.makeAppl(tf.makeConstructor("eq", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Add")) {
            return tf.makeAppl(tf.makeConstructor("add", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Sub")) {
            return tf.makeAppl(tf.makeConstructor("sub", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Div")) {
            return tf.makeAppl(tf.makeConstructor("div", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Mul")) {
            return tf.makeAppl(tf.makeConstructor("mul", 2), toSDF2constraint(c.getSubterm(0), tf),
                toSDF2constraint(c.getSubterm(1), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Line")) {
            return tf.makeAppl(tf.makeConstructor("line", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Col")) {
            return tf.makeAppl(tf.makeConstructor("col", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("First")) {
            return tf.makeAppl(tf.makeConstructor("first", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Last")) {
            return tf.makeAppl(tf.makeConstructor("last", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Left")) {
            return tf.makeAppl(tf.makeConstructor("left", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Right")) {
            return tf.makeAppl(tf.makeConstructor("right", 1), toSDF2constraint(c.getSubterm(0), tf));
        } else if(c instanceof IStrategoAppl && ((IStrategoAppl) c).getName().equals("Tree")) {
            String tree = c.getSubterm(0).toString();
            return tf.makeInt(Integer.parseInt(tree.substring(1, tree.length() - 1)));
        } else {
            throw new Exception("Not a valid Layout Constraint: " + c);
        }
    }
}
