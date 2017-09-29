package org.metaborg.sdf2table.grammar;

public interface IPriority {
    
    IProduction higher();
    IProduction lower();
    boolean transitive();

}
