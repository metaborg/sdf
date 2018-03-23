package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;

public class NumericLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 3882560568034774612L;
    
    ConstraintElement elem;
    ConstraintSelector token;
    int tree;
    
    public NumericLayoutConstraint(ConstraintElement elem, ConstraintSelector token, int tree) {
        this.elem = elem;
        this.token = token;
        this.tree = tree;
    }
    @Override public String toString() {        
        return tree + "." + token + "." + elem;
    }
    
}
