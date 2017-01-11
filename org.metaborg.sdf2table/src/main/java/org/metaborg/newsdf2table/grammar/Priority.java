package org.metaborg.newsdf2table.grammar;

import java.util.List;

public class Priority implements IPriority {

    IProduction greater;
    IProduction lower;
    List<Integer> arguments;
    boolean transitive;
    
    public Priority(IProduction greater, IProduction lower, List<Integer> arguments, boolean transitive) {
        this.greater = greater;
        this.lower = lower;
        this.arguments = arguments;
        this.transitive = transitive;
    }

    @Override public IProduction greater() {
        return greater;
    }

    @Override public IProduction lower() {
        return lower;
    }

    @Override public List<Integer> arguments() {
        return arguments;
    }

    @Override public boolean transitive() {
        return transitive;
    }

}
