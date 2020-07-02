package org.metaborg.sdf2table.grammar;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
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
    private final Set<File> filesRead;

    // factory to create all symbols in the grammar
    private final GrammarFactory gf;

    private IProduction initialProduction;

    // all symbols in this grammar
    private final Set<ISymbol> symbols;

    // to handle Sort.Cons in priorities
    private final Map<ProductionReference, Production> sortConsProductionMapping;

    // merging same productions with different attributes
    private final SetMultimap<IProduction, IAttribute> productionAttributesMapping;

    // constructor attributes
    private final Map<IProduction, ConstructorAttribute> constructors;

    // necessary for calculating deep priority conflicts
    private final Map<UniqueProduction, Production> uniqueProductionMapping;
    private final BiMap<Production, ContextualProduction> prodContextualProdMapping;
    private final Set<ContextualProduction> derivedContextualProds;
    private final Set<ContextualSymbol> contextualSymbols;
    private final SetMultimap<ISymbol, ISymbol> leftRecursiveSymbolsMapping;
    private final SetMultimap<ISymbol, ISymbol> rightRecursiveSymbolsMapping;
    private final SetMultimap<Symbol, Production> longestMatchProdsFront;
    private final SetMultimap<Symbol, Production> shortestMatchProdsFront;
    private final SetMultimap<Symbol, Production> longestMatchProdsBack;
    private final SetMultimap<Symbol, Production> shortestMatchProdsBack;

    // priorities
    private final Set<Priority> transitivePriorities;
    private final Set<Priority> nonTransitivePriorities;
    private final SetMultimap<Priority, Integer> priorities;
    private final SetMultimap<Priority, Integer> indexedPriorities;

    // extra collections to calculate the transitive closure
    private final Set<Production> productionsOnPriorities;
    private final SetMultimap<Priority, Integer> transitivePriorityArgs;
    private final SetMultimap<Priority, Integer> nonTransitivePriorityArgs;
    private final SetMultimap<Production, Priority> higherPriorityProductions;

    // non-assoc and non-nested priorities that should shown as warnings to the user
    private final SetMultimap<String, String> nonAssocPriorities;
    private final SetMultimap<String, String> nonNestedPriorities;

    private final HashMap<String, Symbol> cacheSymbolsRead; // caching symbols read
    private final HashMap<String, Production> cacheProductionsRead; // caching productions read

    // get all productions for a certain symbol
    private final SetMultimap<ISymbol, IProduction> symbolProductionsMapping;

    // get all productions that contain a particular literal
    private final SetMultimap<ISymbol, IProduction> literalProductionsMapping;

    // expression grammars per non-terminal
    private final SetMultimap<ISymbol, IProduction> expressionGrammars;

    // expression grammars collapsed
    private final Set<Set<IProduction>> combinedExpressionGrammars;

    // indirectly recursive symbols
    private final SetMultimap<Symbol, Symbol> indirectlyRecursive;

    // non-recursive symbols
    private final SetMultimap<Symbol, Symbol> nonRecursive;
    
    // left and right derivable symbols from a symbol
    private final SetMultimap<ISymbol, ISymbol> leftDerivable;
    private final SetMultimap<ISymbol, ISymbol> rightDerivable;

    public NormGrammar() {
        this.filesRead = Sets.newHashSet();
        this.gf = new GrammarFactory();
        this.uniqueProductionMapping = Maps.newLinkedHashMap();
        this.sortConsProductionMapping = Maps.newHashMap();
        this.prodContextualProdMapping = HashBiMap.create();
        this.leftRecursiveSymbolsMapping = HashMultimap.create();
        this.rightRecursiveSymbolsMapping = HashMultimap.create();
        this.derivedContextualProds = Sets.newHashSet();
        this.contextualSymbols = Sets.newHashSet();
        this.longestMatchProdsFront = LinkedHashMultimap.create();
        this.longestMatchProdsBack = LinkedHashMultimap.create();
        this.shortestMatchProdsFront = LinkedHashMultimap.create();
        this.shortestMatchProdsBack = LinkedHashMultimap.create();
        this.productionAttributesMapping = HashMultimap.create();
        this.priorities = HashMultimap.create();
        this.indexedPriorities = HashMultimap.create();
        this.constructors = Maps.newHashMap();
        this.transitivePriorities = Sets.newHashSet();
        this.nonTransitivePriorities = Sets.newHashSet();
        this.productionsOnPriorities = Sets.newHashSet();
        this.transitivePriorityArgs = HashMultimap.create();
        this.nonTransitivePriorityArgs = HashMultimap.create();
        this.higherPriorityProductions = HashMultimap.create();
        this.nonAssocPriorities = HashMultimap.create();
        this.nonNestedPriorities = HashMultimap.create();
        this.symbolProductionsMapping = HashMultimap.create();
        this.cacheSymbolsRead = Maps.newHashMap();
        this.cacheProductionsRead = Maps.newHashMap();
        this.symbols = Sets.newHashSet();
        this.literalProductionsMapping = HashMultimap.create();
        this.expressionGrammars = HashMultimap.create();
        this.combinedExpressionGrammars = Sets.newHashSet();
        this.indirectlyRecursive = HashMultimap.create();
        this.nonRecursive = HashMultimap.create();
        this.leftDerivable = HashMultimap.create();
        this.rightDerivable = HashMultimap.create();
    }

    public Map<UniqueProduction, Production> syntax() {
        return getUniqueProductionMapping();
    }

    public void priorityTransitiveClosure() {

        // Floyd Warshall Algorithm to calculate the transitive closure
        for(Production intermediate_prod : getProductionsOnPriorities()) {
            for(Production first_prod : getProductionsOnPriorities()) {
                for(Production second_prod : getProductionsOnPriorities()) {
                    Priority first_sec = gf.createPriority(first_prod, second_prod, true);
                    Priority first_k = gf.createPriority(first_prod, intermediate_prod, true);
                    Priority k_second = gf.createPriority(intermediate_prod, second_prod, true);
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

    public SetMultimap<Priority, Integer> priorities() {
        return priorities;
    }

    public Set<File> getFilesRead() {
        return filesRead;
    }

    public Set<ISymbol> getSymbols() {
        return symbols;
    }

    public Map<ProductionReference, Production> getSortConsProductionMapping() {
        return sortConsProductionMapping;
    }

    public SetMultimap<IProduction, IAttribute> getProductionAttributesMapping() {
        return productionAttributesMapping;
    }

    public Map<UniqueProduction, Production> getUniqueProductionMapping() {
        return uniqueProductionMapping;
    }

    public BiMap<Production, ContextualProduction> getProdContextualProdMapping() {
        return prodContextualProdMapping;
    }

    public Set<ContextualProduction> getDerivedContextualProds() {
        return derivedContextualProds;
    }

    public Set<ContextualSymbol> getContextualSymbols() {
        return contextualSymbols;
    }

    public SetMultimap<ISymbol, ISymbol> getLeftRecursiveSymbolsMapping() {
        return leftRecursiveSymbolsMapping;
    }

    public SetMultimap<ISymbol, ISymbol> getRightRecursiveSymbolsMapping() {
        return rightRecursiveSymbolsMapping;
    }

    public SetMultimap<Symbol, Production> getLongestMatchProdsFront() {
        return longestMatchProdsFront;
    }

    public SetMultimap<Symbol, Production> getLongestMatchProdsBack() {
        return longestMatchProdsBack;
    }

    public SetMultimap<Symbol, Production> getShortestMatchProdsFront() {
        return shortestMatchProdsFront;
    }

    public SetMultimap<Symbol, Production> getShortestMatchProdsBack() {
        return shortestMatchProdsBack;
    }

    public Set<Priority> getTransitivePriorities() {
        return transitivePriorities;
    }

    public Set<Priority> getNonTransitivePriorities() {
        return nonTransitivePriorities;
    }

    public Set<Production> getProductionsOnPriorities() {
        return productionsOnPriorities;
    }

    public SetMultimap<Priority, Integer> getTransitivePriorityArgs() {
        return transitivePriorityArgs;
    }

    public SetMultimap<Priority, Integer> getNonTransitivePriorityArgs() {
        return nonTransitivePriorityArgs;
    }

    public HashMap<String, Symbol> getCacheSymbolsRead() {
        return cacheSymbolsRead;
    }

    public HashMap<String, Production> getCacheProductionsRead() {
        return cacheProductionsRead;
    }

    public SetMultimap<ISymbol, IProduction> getSymbolProductionsMapping() {
        return symbolProductionsMapping;
    }

    public SetMultimap<Production, Priority> getHigherPriorityProductions() {
        return higherPriorityProductions;
    }

    public void normalizeFollowRestrictionLookahead() {
        for(ISymbol s : symbols) {
            s.normalizeFollowRestrictionLookahead();
        }
    }

    public Map<IProduction, ConstructorAttribute> getConstructors() {
        return constructors;
    }

    public SetMultimap<ISymbol, IProduction> getLiteralProductionsMapping() {
        return literalProductionsMapping;
    }

    public SetMultimap<ISymbol, IProduction> getExpressionGrammars() {
        return expressionGrammars;
    }

    public SetMultimap<Symbol, Symbol> getIndirectlyRecursive() {
        return indirectlyRecursive;
    }

    public SetMultimap<Symbol, Symbol> getNonRecursive() {
        return nonRecursive;
    }

    public Set<Set<IProduction>> getCombinedExpressionGrammars() {
        return combinedExpressionGrammars;
    }

    public SetMultimap<String, String> getNonAssocPriorities() {
        return nonAssocPriorities;
    }

    public void setInitialProduction(Production prod) {
        this.initialProduction = prod;
    }

    public SetMultimap<Priority, Integer> getIndexedPriorities() {
        return indexedPriorities;
    }

    public SetMultimap<String, String> getNonNestedPriorities() {
        return nonNestedPriorities;
    }

    public GrammarFactory getGrammarFactory() {
        return gf;
    }

    public void cleanupGrammar() {
        this.cacheProductionsRead.clear();
        this.cacheSymbolsRead.clear();
        this.combinedExpressionGrammars.clear();
        this.contextualSymbols.clear();
        this.derivedContextualProds.clear();
        this.expressionGrammars.clear();
        this.indirectlyRecursive.clear();
        this.leftRecursiveSymbolsMapping.clear();
        this.rightRecursiveSymbolsMapping.clear();
        this.literalProductionsMapping.clear();
        this.longestMatchProdsBack.clear();
        this.longestMatchProdsFront.clear();
        this.nonAssocPriorities.clear();
        this.nonNestedPriorities.clear();
        this.nonRecursive.clear();
        this.nonTransitivePriorities.clear();
        this.nonTransitivePriorityArgs.clear();
        this.productionsOnPriorities.clear();
        this.symbolProductionsMapping.clear();
        this.transitivePriorities.clear();
        this.transitivePriorityArgs.clear();
        this.filesRead.clear();
    }

    public SetMultimap<ISymbol, ISymbol> getLeftDerivable() {
        return leftDerivable;
    }

    public SetMultimap<ISymbol, ISymbol> getRightDerivable() {
        return rightDerivable;
    }

}
