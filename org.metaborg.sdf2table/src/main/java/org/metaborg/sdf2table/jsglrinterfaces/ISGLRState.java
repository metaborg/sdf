package org.metaborg.sdf2table.jsglrinterfaces;

public interface ISGLRState {

    int stateNumber();
    
    Iterable<ISGLRGoto> gotos();
    
    Iterable<ISGLRAction> actions();
    
    boolean isRejectable();
    
    Iterable<ISGLRAction> applicableActions(int character);
    
    Iterable<ISGLRReduce> applicableReduceActions(int character);
    
    ISGLRGoto getGoto(int productionNumber);
    
}
