package org.metaborg.sdf2table.jsglrinterfaces;

import org.metaborg.sdf2table.parsetable.ActionType;

public interface ISGLRReduceLookahead extends ISGLRReduce {
    
    default public ActionType actionType() {
        return ActionType.REDUCE_LOOKAHEAD;
    }
    
    boolean allowsLookahead(String lookahead);
    int lookaheadSize();

}
