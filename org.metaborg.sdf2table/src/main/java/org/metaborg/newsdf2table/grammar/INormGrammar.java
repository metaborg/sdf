package org.metaborg.newsdf2table.grammar;

import java.util.Set;

public interface INormGrammar {
    Set<IProduction> syntax();
    Set<IRestriction> restrictions();
    Set<IPriority> priorities();
}
