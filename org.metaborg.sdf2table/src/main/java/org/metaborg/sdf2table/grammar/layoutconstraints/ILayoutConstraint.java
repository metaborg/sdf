package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.util.List;

import org.metaborg.sdf2table.grammar.ISymbol;

public interface ILayoutConstraint {
    public void normalizeConstraint(List<ISymbol> rhs);
}
