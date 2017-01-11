package org.metaborg.newsdf2table.grammar;

import java.util.List;

public interface IPriority {
    
    IProduction greater();
    IProduction lower();
    List<Integer> arguments();
    boolean transitive();

}
