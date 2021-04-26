package org.metaborg.sdf2table.grammar;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.TermFactory;

import org.metaborg.sdf2table.grammar.layoutconstraints.*;

@RunWith(Parameterized.class)
public class LayoutConstraintAttributeCorrectTest {

    final public IStrategoTerm term;
    final public ILayoutConstraint expected;

    public LayoutConstraintAttributeCorrectTest(String term, ILayoutConstraint expected) {
        this.term = new TermFactory().parseFromString(term);
        this.expected = expected;
    }

    @Parameters(name = "{index}: {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "IgnoreLayout()", null },
            { "Eq(Num(\"1\"), Num(\"2\"))", new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Lt(Num(\"1\"), Num(\"2\"))", new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.LT, new NumericLayoutConstraint(2)) },
            { "Gt(Num(\"1\"), Num(\"2\"))", new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.GT, new NumericLayoutConstraint(2)) },
            { "Le(Num(\"1\"), Num(\"2\"))", new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.LE, new NumericLayoutConstraint(2)) },
            { "Ge(Num(\"1\"), Num(\"2\"))", new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.GE, new NumericLayoutConstraint(2)) },
            { "And(Le(Num(\"1\"), Num(\"2\")), Ge(Num(\"3\"), Num(\"4\")))",
              new BooleanLayoutConstraint(
                  new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.LE, new NumericLayoutConstraint(2)),
                  LayoutConstraintBooleanOperator.AND,
                  new ComparisonLayoutConstraint(new NumericLayoutConstraint(3), LayoutConstraintComparisonOperator.GE, new NumericLayoutConstraint(4)))
            },
            { "Or(Lt(Num(\"1\"), Num(\"2\")), Gt(Num(\"3\"), Num(\"4\")))",
                new BooleanLayoutConstraint(
                    new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.LT, new NumericLayoutConstraint(2)),
                    LayoutConstraintBooleanOperator.OR,
                    new ComparisonLayoutConstraint(new NumericLayoutConstraint(3), LayoutConstraintComparisonOperator.GT, new NumericLayoutConstraint(4)))
            },
            { "Not(Eq(Num(\"1\"), Num(\"2\")))",
                new BooleanLayoutConstraint(
                    new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)),
                    LayoutConstraintBooleanOperator.NOT,
                    null)
            },
            { "Eq(Col(First(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.COL, ConstraintSelector.FIRST, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Col(Last(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.COL, ConstraintSelector.LAST, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Col(Left(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.COL, ConstraintSelector.LEFT, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Col(Right(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.COL, ConstraintSelector.RIGHT, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Line(First(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.LINE, ConstraintSelector.FIRST, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Line(Last(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.LINE, ConstraintSelector.LAST, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Line(Left(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.LINE, ConstraintSelector.LEFT, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Line(Right(PosRef(\"1\"))), Num(\"2\"))", new ComparisonLayoutConstraint(new TreeRef(ConstraintElement.LINE, ConstraintSelector.RIGHT, 1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
            { "Eq(Num(\"1\"), Add(Num(\"3\"), Num(\"2\")))",
              new ComparisonLayoutConstraint(
                  new NumericLayoutConstraint(1),
                  LayoutConstraintComparisonOperator.EQ,
                  new ArithmeticLayoutConstraint(new NumericLayoutConstraint(3), LayoutConstraintArithmeticOperator.ADD, new NumericLayoutConstraint(2)))
            },
            { "Eq(Num(\"1\"), Sub(Num(\"3\"), Num(\"2\")))",
                new ComparisonLayoutConstraint(
                    new NumericLayoutConstraint(1),
                    LayoutConstraintComparisonOperator.EQ,
                    new ArithmeticLayoutConstraint(new NumericLayoutConstraint(3), LayoutConstraintArithmeticOperator.SUB, new NumericLayoutConstraint(2)))
            },
            { "Eq(Num(\"1\"), Mul(Num(\"3\"), Num(\"2\")))",
                new ComparisonLayoutConstraint(
                    new NumericLayoutConstraint(1),
                    LayoutConstraintComparisonOperator.EQ,
                    new ArithmeticLayoutConstraint(new NumericLayoutConstraint(3), LayoutConstraintArithmeticOperator.MUL, new NumericLayoutConstraint(2)))
            },
            { "Eq(Num(\"1\"), Div(Num(\"3\"), Num(\"2\")))",
                new ComparisonLayoutConstraint(
                    new NumericLayoutConstraint(1),
                    LayoutConstraintComparisonOperator.EQ,
                    new ArithmeticLayoutConstraint(new NumericLayoutConstraint(3), LayoutConstraintArithmeticOperator.DIV, new NumericLayoutConstraint(2)))
            },
        });
    }

    @Test public void testTermEqualsConstraint() throws Exception {
        final LayoutConstraintAttribute c = new LayoutConstraintAttribute(this.term);
        assertEquals(c.getLayoutConstraint(), this.expected);
    }
}
