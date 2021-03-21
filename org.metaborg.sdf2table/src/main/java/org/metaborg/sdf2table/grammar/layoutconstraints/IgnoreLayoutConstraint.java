package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;

import org.metaborg.sdf2table.grammar.ISymbol;

public class IgnoreLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 188679947180905283L;

    @Override public String toString() {
        return "ignore-layout";
    }

    @Override public void normalizeConstraint(List<ISymbol> rhs) {
    }

    @Override public boolean equals(Object other) {
        return other instanceof IgnoreLayoutConstraint;
    }
}
