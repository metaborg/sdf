package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;
import java.util.List;

import org.metaborg.sdf2table.grammar.Symbol;

public class IgnoreLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 188679947180905283L;
    
    @Override public String toString() {        
        return "ignore-layout";
    }

    @Override public void normalizeConstraint(List<Symbol> rhs) {
    }
    
    
    
}
