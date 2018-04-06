package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;

public class NumericLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 3882560568034774612L;
    
    private final ConstraintElement elem;
    private final ConstraintSelector token;
    private final int tree;
    
    public NumericLayoutConstraint(ConstraintElement elem, ConstraintSelector token, int tree) {
        this.elem = elem;
        this.token = token;
        this.tree = tree;
    }
    
    @Override public String toString() {        
        return tree + "." + token + "." + elem;
    }

    public ConstraintElement getElem() {
        return elem;
    }

    public ConstraintSelector getToken() {
        return token;
    }

    public int getTree() {
        return tree;
    }       
}
