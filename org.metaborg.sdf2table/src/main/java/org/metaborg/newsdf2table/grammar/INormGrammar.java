package org.metaborg.newsdf2table.grammar;

import java.util.Set;

import com.google.common.collect.SetMultimap;

public interface INormGrammar {
    Set<IProduction> syntax();
    SetMultimap<IPriority, Integer> priorities();
}
