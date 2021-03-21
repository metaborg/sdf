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
public class LayoutConstraintAttributeTest {

    final public IStrategoTerm term;
    final public ILayoutConstraint expected;

    public LayoutConstraintAttributeTest(String term, ILayoutConstraint expected) {
        this.term = new TermFactory().parseFromString(term);
        this.expected = expected;
    }

    @Parameters(name = "{index}: {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { "IgnoreLayout()", new IgnoreLayoutConstraint() },
            { "Eq(Num(\"1\"), Num(\"2\"))", new ComparisonLayoutConstraint(new NumericLayoutConstraint(1), LayoutConstraintComparisonOperator.EQ, new NumericLayoutConstraint(2)) },
        });
    }

    @Test public void testTermEqualsConstraint() throws Exception {
        final LayoutConstraintAttribute c = new LayoutConstraintAttribute(this.term);
        assertEquals(c.getLayoutConstraint(), this.expected);
    }
}
