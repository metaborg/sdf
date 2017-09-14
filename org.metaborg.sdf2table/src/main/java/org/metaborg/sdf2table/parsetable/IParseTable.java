package org.metaborg.sdf2table.parsetable;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.NormGrammar;

import com.google.common.collect.BiMap;

public interface IParseTable {

    int totalStates();

    void incTotalStates();

    public Map<Set<LRItem>, State> kernelMap();

    public State initialState();
    
    public IProduction initialProduction();

    public NormGrammar normalizedGrammar();

    public BiMap<IProduction, Integer> productionLabels();

    public Map<Integer, State> stateLabels();

    public Map<LRItem, Set<LRItem>> cachedItems();

    public Queue<State> stateQueue();
    
    public State getState(int index);
    
}
