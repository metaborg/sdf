package org.metaborg.sdf2table.jsglrinterfaces;

public interface ISGLRParseTable {

    public Iterable<ISGLRProduction> productions();
    
    public ISGLRState startState();
    
    public ISGLRState getState(int stateNumber);
    
}
