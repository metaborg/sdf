package org.metaborg.sdf2table.io;

import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IPriority;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.parsetable.LRItem;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.sdf2table.parsetable.State;
import org.metaborg.sdf2table.parsetable.StateStatus;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class IncrementalParseTableGenerator extends ParseTableGenerator {

    private Set<IProduction> additionalProds;
    private SetMultimap<IProduction, IAttribute> additionalProdAttributes = null;
    private Set<IProduction> removedProds;
    private Set<Symbol> changedSymbols;
    

    SetMultimap<IPriority, Integer> additionalPrios;
    SetMultimap<IPriority, Integer> removedPrios;

    // TODO: Handle changes in restrictions

    public IncrementalParseTableGenerator(FileObject grammarFile, ParseTable reference) throws Exception {
        super(grammarFile);
        
        ParseTable current = this.getParseTable();

        Set<IProduction> currentProductions = current.productionLabels().keySet();
        Set<IProduction> referenceProductions = reference.productionLabels().keySet();

        additionalProds = Sets.newHashSet(Sets.filter(currentProductions, e -> !referenceProductions.contains(e)));
        removedProds = Sets.newHashSet(Sets.filter(referenceProductions, e -> !currentProductions.contains(e)));
        
        if(!additionalProds.isEmpty()) {
            additionalProdAttributes = HashMultimap.create();
        }
        
        
        for(IProduction p : additionalProds) {
            additionalProdAttributes.putAll(p, current.normalizedGrammar().getProductionAttributesMapping().get(p));
        }
        

        SetMultimap<IPriority, Integer> currentPriorities = current.normalizedGrammar().priorities();
        SetMultimap<IPriority, Integer> referencePriorities = reference.normalizedGrammar().priorities();

        additionalPrios = HashMultimap.create(Multimaps.filterEntries(currentPriorities,
            e -> !referencePriorities.containsEntry(e.getKey(), e.getValue())));
        removedPrios = HashMultimap.create(Multimaps.filterEntries(referencePriorities,
            e -> !currentPriorities.containsEntry(e.getKey(), e.getValue())));

        changedSymbols = Sets.newHashSet();

        boolean changed = !(additionalPrios.isEmpty() && removedPrios.isEmpty() && additionalProds.isEmpty()
            && removedProds.isEmpty());
        if(changed) {
            updateParseTable(reference);
        }
    }

    private void updateParseTable(ParseTable reference) {
        this.setParseTable(reference);
        ParseTable currentPT = (ParseTable) this.getParseTable();
        
        // update priorities
        for(Entry<IPriority, Integer> f : additionalPrios.entries()) {
            currentPT.normalizedGrammar().priorities().put(f.getKey(), f.getValue());
            changedSymbols.add(f.getKey().lower().leftHand());
        }
        
        for(Entry<IPriority, Integer> f : removedPrios.entries()) {
            currentPT.normalizedGrammar().priorities().remove(f.getKey(), f.getValue());
            changedSymbols.add(f.getKey().lower().leftHand());
        }

        // update productions
        BiMap<IProduction, Integer> prod_labels = this.getParseTable().productionLabels();

        for(IProduction p : removedProds) {
            currentPT.getProdLabelFactory().releaseLabel(prod_labels.remove(p));
            changedSymbols.add(p.leftHand());
        }
        for(IProduction p : additionalProds) {
            prod_labels.put(p, currentPT.getProdLabelFactory().getNextLabel());
            currentPT.normalizedGrammar().getProductionAttributesMapping().putAll(additionalProdAttributes);
            this.getParseTable().normalizedGrammar().getSymbolProductionsMapping().put(p.leftHand(), p);
            changedSymbols.add(p.leftHand());
        }

        // TODO: update states
        // if state has an item A = α . X β, and there is an additional production X = γ and
        // there is no priority A = α X β > X = γ the state should be marked as dirty

        for(IProduction p : additionalProds) {
            for(State s : currentPT.getSymbolStatesMapping().getStatesfromProduction(p,
                currentPT.normalizedGrammar().priorities())) {
                if(s.status().equals(StateStatus.PROCESSED)) {
                    invalidateCacheItemSets(s);
                    s.markDirty();
                }
            }
        }

        // if state has an item A = α . X β, and there is a removed production X = γ and
        // there was no priority A = α X β > X = γ the state should be marked as dirty



        // TODO: update restrictions

    }

    private void invalidateCacheItemSets(State state) {
        for(Symbol symbol : changedSymbols) {
            for(LRItem item : state.getItems()) {
                if(item.getProd().rightHand().get(item.getDotPosition()).equals(symbol)) {
                    this.getParseTable().cachedItems().remove(item);
                }
            }
        }

    }



}
