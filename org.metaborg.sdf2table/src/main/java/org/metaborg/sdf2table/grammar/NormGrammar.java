package org.metaborg.sdf2table.grammar;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.INormGrammar;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
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
    private Map<ProductionReference, Production> sortConsProductionMapping;

    // merging same productions with different attributes
    private SetMultimap<IProduction, IAttribute> productionAttributesMapping;
    
    // constructor attributes
    private Map<IProduction, ConstructorAttribute> constructors;

    // necessary for calculating deep priority conflicts
    private Map<UniqueProduction, Production> uniqueProductionMapping;
    private BiMap<Production, ContextualProduction> prodContextualProdMapping;
    private Set<ContextualProduction> derivedContextualProds;
    private Set<ContextualSymbol> contextualSymbols;
    private SetMultimap<ISymbol, ISymbol> leftRecursiveSymbolsMapping;
    private SetMultimap<ISymbol, ISymbol> rightRecursiveSymbolsMapping;
    private SetMultimap<Symbol, Production> longestMatchProds;
    private SetMultimap<Symbol, Production> shortestMatchProds;

    // priorities
    private Set<Priority> transitivePriorities;
    private Set<Priority> nonTransitivePriorities;
    private SetMultimap<Priority, Integer> priorities;

    // extra collections to calculate the transitive closure
    private Set<Production> productionsOnPriorities;
    private SetMultimap<Priority, Integer> transitivePriorityArgs;
    private SetMultimap<Priority, Integer> nonTransitivePriorityArgs;
    private SetMultimap<Production, Priority> higherPriorityProductions;


    private HashMap<String, Symbol> cacheSymbolsRead; // caching symbols read
    private HashMap<String, Production> cacheProductionsRead; // caching productions read

    // get all productions for a certain symbol
    private SetMultimap<ISymbol, IProduction> symbolProductionsMapping;

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
        this.setShortestMatchProds(LinkedHashMultimap.create());
        this.setProductionAttributesMapping(HashMultimap.create());
        this.priorities = HashMultimap.create();
        this.setConstructors(Maps.newHashMap());
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


    public Map<UniqueProduction, Production> syntax() {
        return getUniqueProductionMapping();
    }


    public SetMultimap<Priority, Integer> priorities() {
        return priorities;
    }

    public void priorityTransitiveClosure() {
        if(priorities == null) {
            priorities = HashMultimap.create();
        }

        // Floyd Warshall Algorithm to calculate the transitive closure
        for(Production intermediate_prod : getProductionsOnPriorities()) {
            for(Production first_prod : getProductionsOnPriorities()) {
                for(Production second_prod : getProductionsOnPriorities()) {
                    Priority first_sec = new Priority(first_prod, second_prod, true);
                    Priority first_k = new Priority(first_prod, intermediate_prod, true);
                    Priority k_second = new Priority(intermediate_prod, second_prod, true);
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


    public Map<ProductionReference, Production> getSortConsProductionMapping() {
        return sortConsProductionMapping;
    }


    public void setSortConsProductionMapping(Map<ProductionReference, Production> sortConsProductionMapping) {
        this.sortConsProductionMapping = sortConsProductionMapping;
    }


    public SetMultimap<IProduction, IAttribute> getProductionAttributesMapping() {
        return productionAttributesMapping;
    }


    public void setProductionAttributesMapping(SetMultimap<IProduction, IAttribute> productionAttributesMapping) {
        this.productionAttributesMapping = productionAttributesMapping;
    }


    public Map<UniqueProduction, Production> getUniqueProductionMapping() {
        return uniqueProductionMapping;
    }


    public void setUniqueProductionMapping(LinkedHashMap<UniqueProduction, Production> uniqueProductionMapping) {
        this.uniqueProductionMapping = uniqueProductionMapping;
    }


    public BiMap<Production, ContextualProduction> getProdContextualProdMapping() {
        return prodContextualProdMapping;
    }


    public void setProdContextualProdMapping(BiMap<Production, ContextualProduction> prodContextualProdMapping) {
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


    public SetMultimap<ISymbol, ISymbol> getLeftRecursiveSymbolsMapping() {
        return leftRecursiveSymbolsMapping;
    }


    public void setLeftRecursiveSymbolsMapping(SetMultimap<ISymbol, ISymbol> leftRecursiveSymbolsMapping) {
        this.leftRecursiveSymbolsMapping = leftRecursiveSymbolsMapping;
    }


    public SetMultimap<ISymbol, ISymbol> getRightRecursiveSymbolsMapping() {
        return rightRecursiveSymbolsMapping;
    }


    public void setRightRecursiveSymbolsMapping(SetMultimap<ISymbol, ISymbol> rightRecursiveSymbolsMapping) {
        this.rightRecursiveSymbolsMapping = rightRecursiveSymbolsMapping;
    }


    public SetMultimap<Symbol, Production> getLongestMatchProds() {
        return longestMatchProds;
    }


    public void setLongestMatchProds(SetMultimap<Symbol, Production> longestMatchProds) {
        this.longestMatchProds = longestMatchProds;
    }


    public Set<Priority> getTransitivePriorities() {
        return transitivePriorities;
    }


    public void setTransitivePriorities(Set<Priority> transitivePriorities) {
        this.transitivePriorities = transitivePriorities;
    }


    public Set<Priority> getNonTransitivePriorities() {
        return nonTransitivePriorities;
    }


    public void setNonTransitivePriorities(Set<Priority> nonTransitivePriorities) {
        this.nonTransitivePriorities = nonTransitivePriorities;
    }


    public Set<Production> getProductionsOnPriorities() {
        return productionsOnPriorities;
    }


    public void setProductionsOnPriorities(Set<Production> productionsOnPriorities) {
        this.productionsOnPriorities = productionsOnPriorities;
    }


    public SetMultimap<Priority, Integer> getTransitivePriorityArgs() {
        return transitivePriorityArgs;
    }


    public void setTransitivePriorityArgs(SetMultimap<Priority, Integer> transitivePriorityArgs) {
        this.transitivePriorityArgs = transitivePriorityArgs;
    }


    public SetMultimap<Priority, Integer> getNonTransitivePriorityArgs() {
        return nonTransitivePriorityArgs;
    }


    public void setNonTransitivePriorityArgs(SetMultimap<Priority, Integer> nonTransitivePriorityArgs) {
        this.nonTransitivePriorityArgs = nonTransitivePriorityArgs;
    }


    public HashMap<String, Symbol> getCacheSymbolsRead() {
        return cacheSymbolsRead;
    }


    public void setCacheSymbolsRead(HashMap<String, Symbol> cacheSymbolsRead) {
        this.cacheSymbolsRead = cacheSymbolsRead;
    }


    public HashMap<String, Production> getCacheProductionsRead() {
        return cacheProductionsRead;
    }


    public void setCacheProductionsRead(HashMap<String, Production> cacheProductionsRead) {
        this.cacheProductionsRead = cacheProductionsRead;
    }


    public SetMultimap<ISymbol, IProduction> getSymbolProductionsMapping() {
        return symbolProductionsMapping;
    }


    public void setSymbolProductionsMapping(SetMultimap<ISymbol, IProduction> symbolProductionsMapping) {
        this.symbolProductionsMapping = symbolProductionsMapping;
    }


    public SetMultimap<Production, Priority> getHigherPriorityProductions() {
        return higherPriorityProductions;
    }


    public void setHigherPriorityProductions(SetMultimap<Production, Priority> higherPriorityProductions) {
        this.higherPriorityProductions = higherPriorityProductions;
    }


    public void normalizeFollowRestrictionLookahead() {
        for(Symbol s : symbols) {
            s.normalizeFollowRestrictionLookahead();
        }

    }


    public Map<IProduction, ConstructorAttribute> getConstructors() {
        return constructors;
    }


    public void setConstructors(Map<IProduction, ConstructorAttribute> constructors) {
        this.constructors = constructors;
    }


    public SetMultimap<Symbol, Production> getShortestMatchProds() {
        return shortestMatchProds;
    }


    public void setShortestMatchProds(SetMultimap<Symbol, Production> shortestMatchProds) {
        this.shortestMatchProds = shortestMatchProds;
    }

}
