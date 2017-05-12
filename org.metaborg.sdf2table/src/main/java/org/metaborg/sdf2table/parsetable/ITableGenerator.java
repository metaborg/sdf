package org.metaborg.sdf2table.parsetable;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.NormGrammar;

import com.google.common.collect.BiMap;

public interface ITableGenerator {

    int totalStates();
    void incTotalStates();
    
    public Map<Set<LRItem>, State> kernelMap();
    public IProduction initialProduction();
    public NormGrammar normalizedGrammar();
    public BiMap<IProduction, Integer> labels();
    public Map<Integer, State> state_labels();
    public Map<LRItem, Set<LRItem>> cachedItems();
    public Queue<State> stateQueue();
    
}
