package org.metaborg.sdf2table.grammar;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import org.metaborg.sdf2table.deepconflicts.ContextualProduction;
import org.metaborg.sdf2table.deepconflicts.ContextualSymbol;

import org.metaborg.util.collection.BiMap2;
import org.metaborg.util.collection.LinkedSetMultimap;
import org.metaborg.util.collection.SetMultimap;

public class NormGrammar implements INormGrammar, Serializable {

    private static final long serialVersionUID = -13739894962185282L;

    // all module names used in this grammar
    private final Set<String> modulesRead;

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
    private final BiMap2<IProduction, ContextualProduction> prodContextualProdMapping;
    private final Set<ContextualProduction> derivedContextualProds;
    private final Set<ContextualSymbol> contextualSymbols;
    private final SetMultimap<ISymbol, ISymbol> leftRecursiveSymbolsMapping;
    private final SetMultimap<ISymbol, ISymbol> rightRecursiveSymbolsMapping;
    private final LinkedSetMultimap<Symbol, Production> longestMatchProdsFront;
    private final LinkedSetMultimap<Symbol, Production> shortestMatchProdsFront;
    private final LinkedSetMultimap<Symbol, Production> longestMatchProdsBack;
    private final LinkedSetMultimap<Symbol, Production> shortestMatchProdsBack;

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

    private final HashMap<String, Symbol> cacheSymbolsRead; // caching symbols read
    private final HashMap<String, Production> cacheProductionsRead; // caching productions read

    // get all productions for a certain symbol
    // N.B. for some sick reason, if you preserve insertion-order in this multimap, there are edgecases where JSGLR2 will exhibit a bug in org.spoofax.jsglr2.integrationtest.features.RejectTest#testBoth
    private final SetMultimap<ISymbol, IProduction> symbolProductionsMapping;

    // get all productions that contain a particular literal
    private final SetMultimap<ISymbol, IProduction> literalProductionsMapping;

    // expression grammars per non-terminal
    private final SetMultimap<ISymbol, IProduction> expressionGrammars;

    // expression grammars collapsed
    private final Set<Set<IProduction>> combinedExpressionGrammars;

    // left and right derivable symbols from a symbol
    private final SetMultimap<ISymbol, ISymbol> leftDerivable;
    private final SetMultimap<ISymbol, ISymbol> rightDerivable;

    public NormGrammar() {
        this.modulesRead = new HashSet<>();
        this.gf = new GrammarFactory();
        this.uniqueProductionMapping = new LinkedHashMap<>();
        this.sortConsProductionMapping = new HashMap<>();
        this.prodContextualProdMapping = new BiMap2<>();
        this.leftRecursiveSymbolsMapping = new SetMultimap<>();
        this.rightRecursiveSymbolsMapping = new SetMultimap<>();
        this.derivedContextualProds = new HashSet<>();
        this.contextualSymbols = new HashSet<>();
        this.longestMatchProdsFront = new LinkedSetMultimap<>();
        this.longestMatchProdsBack = new LinkedSetMultimap<>();
        this.shortestMatchProdsFront = new LinkedSetMultimap<>();
        this.shortestMatchProdsBack = new LinkedSetMultimap<>();
        this.productionAttributesMapping = new SetMultimap<>();
        this.priorities = new SetMultimap<>();
        this.indexedPriorities = new SetMultimap<>();
        this.constructors = new HashMap<>();
        this.transitivePriorities = new HashSet<>();
        this.nonTransitivePriorities = new HashSet<>();
        this.productionsOnPriorities = new HashSet<>();
        this.transitivePriorityArgs = new SetMultimap<>();
        this.nonTransitivePriorityArgs = new SetMultimap<>();
        this.higherPriorityProductions = new SetMultimap<>();
        this.symbolProductionsMapping = new SetMultimap<>();
        this.cacheSymbolsRead = new HashMap<>();
        this.cacheProductionsRead = new HashMap<>();
        this.symbols = new HashSet<>();
        this.literalProductionsMapping = new SetMultimap<>();
        this.expressionGrammars = new SetMultimap<>();
        this.combinedExpressionGrammars = new HashSet<>();
        this.leftDerivable = new SetMultimap<>();
        this.rightDerivable = new SetMultimap<>();
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

    public Set<String> getModulesRead() {
        return modulesRead;
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

    public BiMap2<IProduction, ContextualProduction> getProdContextualProdMapping() {
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

    public LinkedSetMultimap<Symbol, Production> getLongestMatchProdsFront() {
        return longestMatchProdsFront;
    }

    public LinkedSetMultimap<Symbol, Production> getLongestMatchProdsBack() {
        return longestMatchProdsBack;
    }

    public LinkedSetMultimap<Symbol, Production> getShortestMatchProdsFront() {
        return shortestMatchProdsFront;
    }

    public LinkedSetMultimap<Symbol, Production> getShortestMatchProdsBack() {
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

    public Set<Set<IProduction>> getCombinedExpressionGrammars() {
        return combinedExpressionGrammars;
    }

    public void setInitialProduction(Production prod) {
        this.initialProduction = prod;
    }

    public SetMultimap<Priority, Integer> getIndexedPriorities() {
        return indexedPriorities;
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
        this.leftRecursiveSymbolsMapping.clear();
        this.rightRecursiveSymbolsMapping.clear();
        this.literalProductionsMapping.clear();
        this.longestMatchProdsBack.clear();
        this.longestMatchProdsFront.clear();
        this.nonTransitivePriorities.clear();
        this.nonTransitivePriorityArgs.clear();
        this.productionsOnPriorities.clear();
        this.symbolProductionsMapping.clear();
        this.transitivePriorities.clear();
        this.transitivePriorityArgs.clear();
    }

    public SetMultimap<ISymbol, ISymbol> getLeftDerivable() {
        return leftDerivable;
    }

    public SetMultimap<ISymbol, ISymbol> getRightDerivable() {
        return rightDerivable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormGrammar that = (NormGrammar) o;
        return Objects.equals(filesRead, that.filesRead) && Objects.equals(gf, that.gf) && Objects.equals(initialProduction, that.initialProduction) && Objects.equals(symbols, that.symbols) && Objects.equals(sortConsProductionMapping, that.sortConsProductionMapping) && Objects.equals(productionAttributesMapping, that.productionAttributesMapping) && Objects.equals(constructors, that.constructors) && Objects.equals(uniqueProductionMapping, that.uniqueProductionMapping) && Objects.equals(prodContextualProdMapping, that.prodContextualProdMapping) && Objects.equals(derivedContextualProds, that.derivedContextualProds) && Objects.equals(contextualSymbols, that.contextualSymbols) && Objects.equals(leftRecursiveSymbolsMapping, that.leftRecursiveSymbolsMapping) && Objects.equals(rightRecursiveSymbolsMapping, that.rightRecursiveSymbolsMapping) && Objects.equals(longestMatchProdsFront, that.longestMatchProdsFront) && Objects.equals(shortestMatchProdsFront, that.shortestMatchProdsFront) && Objects.equals(longestMatchProdsBack, that.longestMatchProdsBack) && Objects.equals(shortestMatchProdsBack, that.shortestMatchProdsBack) && Objects.equals(transitivePriorities, that.transitivePriorities) && Objects.equals(nonTransitivePriorities, that.nonTransitivePriorities) && Objects.equals(priorities, that.priorities) && Objects.equals(indexedPriorities, that.indexedPriorities) && Objects.equals(productionsOnPriorities, that.productionsOnPriorities) && Objects.equals(transitivePriorityArgs, that.transitivePriorityArgs) && Objects.equals(nonTransitivePriorityArgs, that.nonTransitivePriorityArgs) && Objects.equals(higherPriorityProductions, that.higherPriorityProductions) && Objects.equals(cacheSymbolsRead, that.cacheSymbolsRead) && Objects.equals(cacheProductionsRead, that.cacheProductionsRead) && Objects.equals(symbolProductionsMapping, that.symbolProductionsMapping) && Objects.equals(literalProductionsMapping, that.literalProductionsMapping) && Objects.equals(expressionGrammars, that.expressionGrammars) && Objects.equals(combinedExpressionGrammars, that.combinedExpressionGrammars) && Objects.equals(leftDerivable, that.leftDerivable) && Objects.equals(rightDerivable, that.rightDerivable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filesRead, gf, initialProduction, symbols, sortConsProductionMapping, productionAttributesMapping, constructors, uniqueProductionMapping, prodContextualProdMapping, derivedContextualProds, contextualSymbols, leftRecursiveSymbolsMapping, rightRecursiveSymbolsMapping, longestMatchProdsFront, shortestMatchProdsFront, longestMatchProdsBack, shortestMatchProdsBack, transitivePriorities, nonTransitivePriorities, priorities, indexedPriorities, productionsOnPriorities, transitivePriorityArgs, nonTransitivePriorityArgs, higherPriorityProductions, cacheSymbolsRead, cacheProductionsRead, symbolProductionsMapping, literalProductionsMapping, expressionGrammars, combinedExpressionGrammars, leftDerivable, rightDerivable);
    }
}
