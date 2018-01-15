package org.metaborg.sdf2table.grammar;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.ContextualProduction;
import org.metaborg.sdf2table.deepconflicts.ContextualSymbol;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class NormGrammar implements INormGrammar, Serializable {

    private static final long serialVersionUID = -13739894962185282L;

    // all files used in this grammar
    private Set<File> filesRead;

    private IProduction initialProduction;

    // all symbols in this grammar
    private Set<Symbol> symbols;

    // to handle Sort.Cons in priorities
    private Map<ProductionReference, IProduction> sortConsProductionMapping;

    // merging same productions with different attributes
    private SetMultimap<IProduction, IAttribute> productionAttributesMapping;

    // necessary for calculating deep priority conflicts
    private Map<UniqueProduction, IProduction> uniqueProductionMapping;
    private BiMap<IProduction, ContextualProduction> prodContextualProdMapping;
    private Set<ContextualProduction> derivedContextualProds;
    private Set<ContextualSymbol> contextualSymbols;
    private SetMultimap<Symbol, Symbol> leftRecursiveSymbolsMapping;
    private SetMultimap<Symbol, Symbol> rightRecursiveSymbolsMapping;
    private SetMultimap<Symbol, IProduction> longestMatchProds;

    // priorities
    private Set<IPriority> transitivePriorities;
    private Set<IPriority> nonTransitivePriorities;
    private SetMultimap<IPriority, Integer> priorities;

    // extra collections to calculate the transitive closure
    private Set<IProduction> productionsOnPriorities;
    private SetMultimap<IPriority, Integer> transitivePriorityArgs;
    private SetMultimap<IPriority, Integer> nonTransitivePriorityArgs;
    private SetMultimap<IProduction, IPriority> higherPriorityProductions;


    private HashMap<String, Symbol> cacheSymbolsRead; // caching symbols read
    private HashMap<String, IProduction> cacheProductionsRead; // caching productions read

    // get all productions for a certain symbol
    private SetMultimap<Symbol, IProduction> symbolProductionsMapping;

    public NormGrammar() {
        this.setFilesRead(Sets.newHashSet());
        this.setUniqueProductionMapping(Maps.newLinkedHashMap());
        this.setSortConsProductionMapping(Maps.newHashMap());
        this.setProdContextualProdMapping(HashBiMap.create());
        this.setLeftRecursiveSymbolsMapping(HashMultimap.create());
        this.setRightRecursiveSymbolsMapping(HashMultimap.create());
        this.setDerivedContextualProds(Sets.newHashSet());
        this.setContextualSymbols(Sets.newHashSet());
        this.setLongestMatchProds(LinkedHashMultimap.create());
        this.setProductionAttributesMapping(HashMultimap.create());
        this.priorities = HashMultimap.create();
        this.setTransitivePriorities(Sets.newHashSet());
        this.setNonTransitivePriorities(Sets.newHashSet());
        this.setProductionsOnPriorities(Sets.newHashSet());
        this.setTransitivePriorityArgs(HashMultimap.create());
        this.setNonTransitivePriorityArgs(HashMultimap.create());
        this.setHigherPriorityProductions(HashMultimap.create());
        this.setSymbolProductionsMapping(HashMultimap.create());
        this.setCacheSymbolsRead(Maps.newHashMap());
        this.setCacheProductionsRead(Maps.newHashMap());
        this.setSymbols(Sets.newHashSet());
    }


    @Override public Map<UniqueProduction, IProduction> syntax() {
        return getUniqueProductionMapping();
    }


    @Override public SetMultimap<IPriority, Integer> priorities() {
        return priorities;
    }

    public void priorityTransitiveClosure() {
        if(priorities == null) {
            priorities = HashMultimap.create();
        }

        // Floyd Warshall Algorithm to calculate the transitive closure
        for(IProduction intermediate_prod : getProductionsOnPriorities()) {
            for(IProduction first_prod : getProductionsOnPriorities()) {
                for(IProduction second_prod : getProductionsOnPriorities()) {
                    IPriority first_sec = new Priority(first_prod, second_prod, true);
                    IPriority first_k = new Priority(first_prod, intermediate_prod, true);
                    IPriority k_second = new Priority(intermediate_prod, second_prod, true);
                    // if there is no priority first_prod > second_prod
                    if(!getTransitivePriorities().contains(first_sec)) {
                        // if there are priorities first_prod > intermediate_prod and
                        // intermediate_prod > second_prod
                        // add priority first_prod > second_prod
                        if(getTransitivePriorities().contains(first_k)
                            && getTransitivePriorities().contains(k_second)) {
                            getTransitivePriorities().add(first_sec);
                            getTransitivePriorityArgs().putAll(first_sec, getTransitivePriorityArgs().get(first_k));
                        }
                    } else {
                        if(getTransitivePriorities().contains(first_k)
                            && getTransitivePriorities().contains(k_second)) {
                            getTransitivePriorityArgs().putAll(first_sec, getTransitivePriorityArgs().get(first_k));
                        }
                    }
                }
            }
        }

        priorities.putAll(getNonTransitivePriorityArgs());
        priorities.putAll(getTransitivePriorityArgs());
    }


    public IProduction getInitialProduction() {
        return initialProduction;
    }


    public void setInitialProduction(IProduction initialProduction) {
        this.initialProduction = initialProduction;
    }


    public Set<File> getFilesRead() {
        return filesRead;
    }


    public void setFilesRead(Set<File> filesRead) {
        this.filesRead = filesRead;
    }


    public Set<Symbol> getSymbols() {
        return symbols;
    }


    public void setSymbols(Set<Symbol> symbols) {
        this.symbols = symbols;
    }


    public Map<ProductionReference, IProduction> getSortConsProductionMapping() {
        return sortConsProductionMapping;
    }


    public void setSortConsProductionMapping(Map<ProductionReference, IProduction> sortConsProductionMapping) {
        this.sortConsProductionMapping = sortConsProductionMapping;
    }


    public SetMultimap<IProduction, IAttribute> getProductionAttributesMapping() {
        return productionAttributesMapping;
    }


    public void setProductionAttributesMapping(SetMultimap<IProduction, IAttribute> productionAttributesMapping) {
        this.productionAttributesMapping = productionAttributesMapping;
    }


    public Map<UniqueProduction, IProduction> getUniqueProductionMapping() {
        return uniqueProductionMapping;
    }


    public void setUniqueProductionMapping(LinkedHashMap<UniqueProduction, IProduction> uniqueProductionMapping) {
        this.uniqueProductionMapping = uniqueProductionMapping;
    }


    public BiMap<IProduction, ContextualProduction> getProdContextualProdMapping() {
        return prodContextualProdMapping;
    }


    public void setProdContextualProdMapping(BiMap<IProduction, ContextualProduction> prodContextualProdMapping) {
        this.prodContextualProdMapping = prodContextualProdMapping;
    }


    public Set<ContextualProduction> getDerivedContextualProds() {
        return derivedContextualProds;
    }


    public void setDerivedContextualProds(Set<ContextualProduction> derivedContextualProds) {
        this.derivedContextualProds = derivedContextualProds;
    }


    public Set<ContextualSymbol> getContextualSymbols() {
        return contextualSymbols;
    }


    public void setContextualSymbols(Set<ContextualSymbol> contextualSymbols) {
        this.contextualSymbols = contextualSymbols;
    }


    public SetMultimap<Symbol, Symbol> getLeftRecursiveSymbolsMapping() {
        return leftRecursiveSymbolsMapping;
    }


    public void setLeftRecursiveSymbolsMapping(SetMultimap<Symbol, Symbol> leftRecursiveSymbolsMapping) {
        this.leftRecursiveSymbolsMapping = leftRecursiveSymbolsMapping;
    }


    public SetMultimap<Symbol, Symbol> getRightRecursiveSymbolsMapping() {
        return rightRecursiveSymbolsMapping;
    }


    public void setRightRecursiveSymbolsMapping(SetMultimap<Symbol, Symbol> rightRecursiveSymbolsMapping) {
        this.rightRecursiveSymbolsMapping = rightRecursiveSymbolsMapping;
    }


    public SetMultimap<Symbol, IProduction> getLongestMatchProds() {
        return longestMatchProds;
    }


    public void setLongestMatchProds(SetMultimap<Symbol, IProduction> longestMatchProds) {
        this.longestMatchProds = longestMatchProds;
    }


    public Set<IPriority> getTransitivePriorities() {
        return transitivePriorities;
    }


    public void setTransitivePriorities(Set<IPriority> transitivePriorities) {
        this.transitivePriorities = transitivePriorities;
    }


    public Set<IPriority> getNonTransitivePriorities() {
        return nonTransitivePriorities;
    }


    public void setNonTransitivePriorities(Set<IPriority> nonTransitivePriorities) {
        this.nonTransitivePriorities = nonTransitivePriorities;
    }


    public Set<IProduction> getProductionsOnPriorities() {
        return productionsOnPriorities;
    }


    public void setProductionsOnPriorities(Set<IProduction> productionsOnPriorities) {
        this.productionsOnPriorities = productionsOnPriorities;
    }


    public SetMultimap<IPriority, Integer> getTransitivePriorityArgs() {
        return transitivePriorityArgs;
    }


    public void setTransitivePriorityArgs(SetMultimap<IPriority, Integer> transitivePriorityArgs) {
        this.transitivePriorityArgs = transitivePriorityArgs;
    }


    public SetMultimap<IPriority, Integer> getNonTransitivePriorityArgs() {
        return nonTransitivePriorityArgs;
    }


    public void setNonTransitivePriorityArgs(SetMultimap<IPriority, Integer> nonTransitivePriorityArgs) {
        this.nonTransitivePriorityArgs = nonTransitivePriorityArgs;
    }


    public HashMap<String, Symbol> getCacheSymbolsRead() {
        return cacheSymbolsRead;
    }


    public void setCacheSymbolsRead(HashMap<String, Symbol> cacheSymbolsRead) {
        this.cacheSymbolsRead = cacheSymbolsRead;
    }


    public HashMap<String, IProduction> getCacheProductionsRead() {
        return cacheProductionsRead;
    }


    public void setCacheProductionsRead(HashMap<String, IProduction> cacheProductionsRead) {
        this.cacheProductionsRead = cacheProductionsRead;
    }


    public SetMultimap<Symbol, IProduction> getSymbolProductionsMapping() {
        return symbolProductionsMapping;
    }


    public void setSymbolProductionsMapping(SetMultimap<Symbol, IProduction> symbolProductionsMapping) {
        this.symbolProductionsMapping = symbolProductionsMapping;
    }


    public SetMultimap<IProduction, IPriority> getHigherPriorityProductions() {
        return higherPriorityProductions;
    }


    public void setHigherPriorityProductions(SetMultimap<IProduction, IPriority> higherPriorityProductions) {
        this.higherPriorityProductions = higherPriorityProductions;
    }


    public void normalizeFollowRestrictionLookahead() {
        for(Symbol s : symbols) {
            s.normalizeFollowRestrictionLookahead();
        }

    }

}
