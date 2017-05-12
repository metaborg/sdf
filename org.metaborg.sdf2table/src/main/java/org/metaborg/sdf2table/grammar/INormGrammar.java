package org.metaborg.sdf2table.grammar;

import java.util.Map;

import com.google.common.collect.SetMultimap;

public interface INormGrammar {
    Map<UniqueProduction, IProduction> syntax();
    SetMultimap<IPriority, Integer> priorities();
}
