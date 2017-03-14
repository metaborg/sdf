package org.metaborg.newsdf2table.grammar;

import java.util.Map;

import com.google.common.collect.SetMultimap;

public interface INormGrammar {
    Map<UniqueProduction, IProduction> syntax();
    SetMultimap<IPriority, Integer> priorities();
}
