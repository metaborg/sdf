package org.metaborg.sdf2table.jsglrinterfaces;

import org.metaborg.sdf2table.parsetable.ActionType;

public interface ISGLRAccept extends ISGLRAction {
    
    default public ActionType actionType() {
        return ActionType.ACCEPT;
    }

}
