package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Symbol;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

public class SymbolStatesMapping implements Serializable {

    private static final long serialVersionUID = 1109889933255986338L;

    public SetMultimap<ISymbol, LRItem> symbolItems;
    public SetMultimap<LRItem, State> itemStates;

    public SymbolStatesMapping() {
        this.symbolItems = HashMultimap.create();
        this.itemStates = HashMultimap.create();
    }

    public Set<State> getStatesfromSymbol(Symbol symb) {
        Set<State> result = new HashSet<State>();

        for(LRItem item : symbolItems.get(symb)) {
            result.addAll(itemStates.get(item));
        }
        return result;
    }

    public Set<State> getStatesfromProduction(IProduction prod, SetMultimap<Priority, Integer> priorities) {
        Set<State> result = new HashSet<State>();

        for(LRItem item : symbolItems.get(prod.leftHand())) {
            if(!item.isPriorityConflict(prod)) {
                result.addAll(itemStates.get(item));
            }
        }
        return result;
    }

    public Set<State> getStatesfromItem(LRItem item) {
        return itemStates.get(item);
    }

    public Set<LRItem> getItemsfromSymbol(Symbol symb) {
        return symbolItems.get(symb);
    }

    public void addLink(Symbol symb, LRItem item, State state) {
        symbolItems.put(symb, item);
        itemStates.put(item, state);
    }
}
