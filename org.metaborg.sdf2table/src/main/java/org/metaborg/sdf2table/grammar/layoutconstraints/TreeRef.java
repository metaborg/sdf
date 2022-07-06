package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.util.List;

import org.metaborg.sdf2table.grammar.ISymbol;

public class TreeRef implements ILayoutConstraintExpression {

    private static final long serialVersionUID = 3882560568034774612L;

    private final ConstraintElement elem;
    private final ConstraintSelector token;
    private int tree;

    public TreeRef(ConstraintElement elem, ConstraintSelector token, int tree) {
        this.elem = elem;
        this.token = token;
        this.tree = tree;
    }

    @Override public String toString() {
        return this.tree + "." + this.token + "." + this.elem;
    }

    public ConstraintElement getElem() {
        return this.elem;
    }

    public ConstraintSelector getToken() {
        return this.token;
    }

    public int getTree() {
        return this.tree;
    }

    public void normalizeConstraint(List<ISymbol> rhs) {
        int normalizedtree = 0;
        int count = this.tree;
        for (ISymbol s : rhs) {
            if (s.toString().equals("LAYOUT?-CF")) {
                normalizedtree += 1;
                continue;
            } else {
                count -= 1;
            }
            if (count < 0) {
                this.tree = normalizedtree;
                return;
            }
            normalizedtree += 1;
        }
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof TreeRef)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        TreeRef c = (TreeRef) other;
        return this.elem == c.elem && this.token == c.token && this.tree == c.tree;
    }
}
