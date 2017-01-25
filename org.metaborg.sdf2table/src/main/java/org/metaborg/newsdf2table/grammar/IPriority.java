package org.metaborg.newsdf2table.grammar;

public interface IPriority {
    
    IProduction higher();
    IProduction lower();
    boolean transitive();

}
