package org.metaborg.sdf2table.grammar;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertThrows;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.TermFactory;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidLayoutConstraint;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidLayoutConstraintExpression;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidPosRef;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.InvalidTreeSelector;
import org.metaborg.sdf2table.grammar.layoutconstraints.exceptions.LayoutConstraintException;

@RunWith(Parameterized.class)
public class LayoutConstraintAttributeIncorrectTest {

    final public IStrategoTerm term;
    final public Class<LayoutConstraintException> expected;

    public LayoutConstraintAttributeIncorrectTest(String term, Class<LayoutConstraintException> expected) {
        this.term = new TermFactory().parseFromString(term);
        this.expected = expected;
    }

    @Parameters(name = "{index}: {0} throws {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "ThisIsAnInvalidLayoutConstraint()", InvalidLayoutConstraint.class },
            { "Not", InvalidLayoutConstraint.class },
            { "Not()", InvalidLayoutConstraint.class },
            { "And(Eq(Num(\"1\"), Num(\"2\")))", InvalidLayoutConstraint.class },
            { "Or(Eq(Num(\"1\"), Num(\"2\")))", InvalidLayoutConstraint.class },
            { "Eq(Num(\"1\"))", InvalidLayoutConstraint.class },
            { "Lt(Num(\"1\"))", InvalidLayoutConstraint.class },
            { "Gt(Num(\"1\"))", InvalidLayoutConstraint.class },
            { "Le(Num(\"1\"))", InvalidLayoutConstraint.class },
            { "Ge(Num(\"1\"))", InvalidLayoutConstraint.class },
            { "Eq(Add(Num(\"1\")), Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Eq(Sub(Num(\"1\")), Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Eq(Div(Num(\"1\")), Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Eq(Mul(Num(\"1\")), Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Eq(Num, Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Eq(Num(\"1\"), Num(\"notanumber\"))", InvalidLayoutConstraintExpression.class },
            { "Eq(InvalidExpression(), Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Lt(Line(), Num(\"1\"))", InvalidLayoutConstraintExpression.class },
            { "Lt(Col(First(PosRef(\"notanumber\"))), Num(\"1\"))", InvalidPosRef.class },
            { "Le(Col(First(PosRef())), Num(\"1\"))", InvalidPosRef.class },
            { "Gt(Col(First(PosRef)), Num(\"1\"))", InvalidPosRef.class },
            { "Ge(Col(First(Pos())), Num(\"1\"))", InvalidPosRef.class },
            { "Eq(Col(First(LabelRef(\"label\"))), Num(\"1\"))", InvalidPosRef.class },
            { "Eq(Col(Center(PosRef(\"1\"))), Num(\"1\"))", InvalidTreeSelector.class },
            { "Eq(Col(Center), Num(\"1\"))", InvalidTreeSelector.class },
        });
    }

    @Test public void testTermEqualsConstraint() throws Exception {
        assertThrows(this.expected, () -> {
            new LayoutConstraintAttribute(this.term);
        });
    }
}
