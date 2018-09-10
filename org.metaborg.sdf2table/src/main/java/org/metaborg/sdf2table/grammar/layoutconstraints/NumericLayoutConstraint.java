package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;

import org.metaborg.sdf2table.grammar.Symbol;

public class NumericLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 3882560568034774612L;
    
    private final ConstraintElement elem;
    private final ConstraintSelector token;
    private int tree;
    
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
    
    public void normalizeConstraint(List<Symbol> rhs) {
        int normalizedtree = 0;
        int count = tree;
        for(Symbol s : rhs) {
            if(s.toString().equals("LAYOUT?-CF")) {
                normalizedtree++;
                continue;
            } else {
                count--;
            } 
            if(count == 0) {
                tree = normalizedtree;
                return;
            }
            normalizedtree++;
        }
    }
}
