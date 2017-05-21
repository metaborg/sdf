package org.metaborg.sdf2table.dynamic;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.NormGrammar;
import org.metaborg.sdf2table.parsetable.ITableGenerator;
import org.metaborg.sdf2table.parsetable.LRItem;
import org.metaborg.sdf2table.parsetable.State;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;

import com.google.common.collect.BiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DynamicParseTableGenerator implements ITableGenerator {

    private static final ILogger logger = LoggerUtils.logger(DynamicParseTableGenerator.class);

    
//    ParseTableGenerator pt;
    private NormGrammar grammar;

    Map<Integer, State> state_labels = Maps.newHashMap();

    Queue<State> stateQueue = Lists.newLinkedList();
    private Map<Set<LRItem>, State> kernel_states = Maps.newHashMap();
    private int totalStates = 0;
    private int processedStates = 0;

    Map<LRItem, Set<LRItem>> cachedItems = Maps.newHashMap();

    public DynamicParseTableGenerator(FileObject grammarFile) {
        try {
            InputStream out = grammarFile.getContent().getInputStream();
            ObjectInputStream ois = new ObjectInputStream(out);
            // read persisted normalized grammar
            grammar = (NormGrammar) ois.readObject();
            ois.close();
            out.close();
        } catch(Exception e) {
            logger.error("Could not load initial table.");
            e.printStackTrace();
        }
        
    }
    
    public DynamicParseTableGenerator(NormGrammar grammar) {
        this.grammar = grammar;
    }

    public State getInitialState() {
        State s0;
        if(totalStates == 0) {
            s0 = new State(initialProduction(), this);
            s0.doShift();
            s0.doReduces();
            s0.setProcessed(true);
            processedStates++;
        } else {
            return state_labels.get(0);
        }
        return s0;
    }

    public State getState(int index) {
        State s = state_labels.get(index);
        if(!s.isProcessed()) {
            s.doShift();
            s.doReduces();
            s.setProcessed(true);
            processedStates++;
        }        
        return s;
    }

    @Override public int totalStates() {
        return totalStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }

    @Override public void incTotalStates() {
        totalStates++;
    }

    @Override public Map<Set<LRItem>, State> kernelMap() {
        return kernel_states;
    }

    @Override public IProduction initialProduction() {
        return grammar.initial_prod;
    }

    @Override public NormGrammar normalizedGrammar() {
        return grammar;
    }

    @Override public BiMap<IProduction, Integer> labels() {
        return grammar.getProdLabels();
    }

    @Override public Map<LRItem, Set<LRItem>> cachedItems() {
        return cachedItems;
    }

    @Override public Queue<State> stateQueue() {
        return stateQueue;
    }

    @Override public Map<Integer, State> state_labels() {
        return state_labels;
    }

}
