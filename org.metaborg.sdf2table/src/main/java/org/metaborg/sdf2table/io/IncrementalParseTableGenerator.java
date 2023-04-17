package org.metaborg.sdf2table.io;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.parsetable.LRItem;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.sdf2table.parsetable.State;
import org.metaborg.sdf2table.parsetable.StateStatus;
import org.metaborg.util.collection.BiMap2;
import org.metaborg.util.collection.SetMultimap;
import org.metaborg.util.iterators.Iterables2;
import org.metaborg.util.stream.Collectors2;

public class IncrementalParseTableGenerator extends ParseTableIO {

    private Set<IProduction> additionalProds;
    private SetMultimap<IProduction, IAttribute> additionalProdAttributes = null;
    private Set<IProduction> removedProds;
    private Set<Symbol> changedSymbols;
    

    SetMultimap<Priority, Integer> additionalPrios;
    SetMultimap<Priority, Integer> removedPrios;

    // TODO: Handle changes in restrictions

    public IncrementalParseTableGenerator(FileObject grammarFile, ParseTable reference) throws Exception {
        super(grammarFile);
        
        ParseTable current = this.getParseTable();

        Set<IProduction> currentProductions = current.productionLabels().keySet();
        Set<IProduction> referenceProductions = reference.productionLabels().keySet();

        additionalProds = currentProductions.stream().filter(e -> !referenceProductions.contains(e)).collect(
            Collectors2.toHashSet());
        removedProds = referenceProductions.stream().filter(e -> !currentProductions.contains(e)).collect(
            Collectors2.toHashSet());
        
        if(!additionalProds.isEmpty()) {
            additionalProdAttributes = new SetMultimap<>();
        }
        
        
        for(IProduction p : additionalProds) {
            additionalProdAttributes.putAll(p, current.normalizedGrammar().getProductionAttributesMapping().get(p));
        }
        

        SetMultimap<Priority, Integer> currentPriorities = current.normalizedGrammar().priorities();
        SetMultimap<Priority, Integer> referencePriorities = reference.normalizedGrammar().priorities();

        additionalPrios = currentPriorities.entries().filter(e -> !referencePriorities.containsEntry(e.getKey(), e.getValue())).collect(SetMultimap.collector());
        removedPrios = referencePriorities.entries().filter(
            e -> !currentPriorities.containsEntry(e.getKey(), e.getValue())).collect(SetMultimap.collector());

        changedSymbols = new HashSet<Symbol>();

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
        additionalPrios.entries().forEach((Entry<Priority, Integer> f) -> {
            currentPT.normalizedGrammar().priorities().put(f.getKey(), f.getValue());
            changedSymbols.add((Symbol) f.getKey().lower().leftHand());
        });

        removedPrios.entries().forEach((Entry<Priority, Integer> f) -> {
            currentPT.normalizedGrammar().priorities().remove(f.getKey(), f.getValue());
            changedSymbols.add((Symbol) f.getKey().lower().leftHand());
        });

        // update productions
        BiMap2<IProduction, Integer> prod_labels = this.getParseTable().productionLabels();

        for(IProduction p : removedProds) {
            currentPT.getProdLabelFactory().releaseLabel(prod_labels.remove(p));
            changedSymbols.add((Symbol) p.leftHand());
        }
        for(IProduction p : additionalProds) {
            prod_labels.put(p, currentPT.getProdLabelFactory().getNextLabel());
            currentPT.normalizedGrammar().getProductionAttributesMapping().putAll(additionalProdAttributes);
            this.getParseTable().normalizedGrammar().getSymbolProductionsMapping().put((Symbol) p.leftHand(), p);
            changedSymbols.add((Symbol) p.leftHand());
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
        for(ISymbol symbol : changedSymbols) {
            for(LRItem item : state.getItems()) {
                if(item.getProd().rightHand().get(item.getDotPosition()).equals(symbol)) {
                    this.getParseTable().cachedItems().remove(item);
                }
            }
        }

    }



}
