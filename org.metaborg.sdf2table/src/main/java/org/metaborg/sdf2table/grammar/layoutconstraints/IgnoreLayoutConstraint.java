package org.metaborg.sdf2table.grammar.layoutconstraints;

import java.io.Serializable;

public class IgnoreLayoutConstraint implements Serializable, ILayoutConstraint {

    private static final long serialVersionUID = 188679947180905283L;
    
    @Override public String toString() {        
        return "ignore-layout";
    }
    
}
