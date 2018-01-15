package org.metaborg.sdf2table.jsglrinterfaces;

import org.metaborg.sdf2table.parsetable.ActionType;
import org.metaborg.sdf2table.parsetable.ProductionType;

public interface ISGLRReduce extends ISGLRAction {
    
    default public ActionType actionType() {
        return ActionType.REDUCE;
    }

    ISGLRProduction production();
    
    ProductionType productionType();
    
    int arity();
    
    default public boolean isRejectProduction() {
        return productionType() == ProductionType.REJECT;
    }
    
}
