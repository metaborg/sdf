package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.util.List;

import org.metaborg.sdf2table.grammar.Symbol;

public interface ILayoutConstraint {
    void normalizeConstraint(List<Symbol> rhs);
}
