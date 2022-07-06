package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;

import org.metaborg.sdf2table.grammar.ISymbol;

public interface ILayoutConstraint extends Serializable {
    void normalizeConstraint(List<ISymbol> rhs);
}
