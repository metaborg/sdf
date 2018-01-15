package org.metaborg.sdf2table.jsglrinterfaces;

import org.metaborg.sdf2table.parsetable.ActionType;

public interface ISGLRShift extends ISGLRAction {
    
    default public ActionType actionType() {
        return ActionType.SHIFT;
    }

    int shiftState();
    
}
