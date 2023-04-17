package org.metaborg.sdf2table.deepconflicts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.grammar.ContextFreeSymbol;
import org.metaborg.sdf2table.grammar.GrammarFactory;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.IterStarSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSymbol;
import org.metaborg.sdf2table.grammar.LexicalSymbol;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.grammar.UniqueProduction;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.util.collection.BiMap2;
import org.metaborg.util.collection.SetMultimap;

public class DeepConflictsAnalyzer {

    public static DeepConflictsAnalyzer fromParseTable(ParseTable pt) {
        final DeepConflictsAnalyzer phase1 = new DeepConflictsAnalyzer(pt);
        phase1.deepConflictAnalysis();

        // TODO: due to usage of factory labels might be different from one phase to another; needs checking.
        Set<Integer> newLabels = new HashSet<>(phase1.productionLabels.inverse().keySet());
        Set<Integer> oldLabels = new HashSet<>(pt.productionLabels().inverse().keySet());

        Set<Integer> diffLabels = new HashSet<>(newLabels);
        diffLabels.removeAll(oldLabels);

        diffLabels.forEach(pt.getProdLabelFactory()::releaseLabel);

        final DeepConflictsAnalyzer phase2 =
            new DeepConflictsAnalyzer(pt, phase1.leftmostContextsMapping, phase1.rightmostContextsMapping);
        phase2.deepConflictAnalysis();

        return phase2;
    }

    private DeepConflictsAnalyzer(ParseTable pt) {
        this.pt = pt;

        this.isContextMappingStable = false;
        this.leftmostContextsMapping = new LinkedHashMap<>();
        this.rightmostContextsMapping = new LinkedHashMap<>();

        this.uniqueProductionMapping = new LinkedHashMap<>(pt.normalizedGrammar().getUniqueProductionMapping());
        this.prodContextualProdMapping = new BiMap2<>(pt.normalizedGrammar().getProdContextualProdMapping());
        this.productionLabels = new BiMap2<>(pt.productionLabels());
        this.symbolProductionsMapping = new SetMultimap<>(pt.normalizedGrammar().getSymbolProductionsMapping());
        this.productionAttributesMapping = new SetMultimap<>(pt.normalizedGrammar().getProductionAttributesMapping());
        this.priorities = new SetMultimap<>(pt.normalizedGrammar().priorities());
    }

    private DeepConflictsAnalyzer(ParseTable pt, Map<Integer, Integer> leftmostContextsMapping,
        Map<Integer, Integer> rightmostContextsMapping) {
        this.pt = pt;

        this.isContextMappingStable = true;
        this.leftmostContextsMapping = Collections.unmodifiableMap(new LinkedHashMap<>(leftmostContextsMapping));
        this.rightmostContextsMapping = Collections.unmodifiableMap(new LinkedHashMap<>(rightmostContextsMapping));

        this.uniqueProductionMapping = new HashMap<>(pt.normalizedGrammar().getUniqueProductionMapping());
        this.prodContextualProdMapping = new BiMap2<>(pt.normalizedGrammar().getProdContextualProdMapping());
        this.productionLabels = new BiMap2<>(pt.productionLabels());
        this.symbolProductionsMapping = new SetMultimap<>(pt.normalizedGrammar().getSymbolProductionsMapping());
        this.productionAttributesMapping = new SetMultimap<>(pt.normalizedGrammar().getProductionAttributesMapping());
        this.priorities = new SetMultimap<>(pt.normalizedGrammar().priorities());
    }

    private final ParseTable pt;
    private final boolean isContextMappingStable;

    // phase 1
    /* rw */ private final Map<Integer, Integer> leftmostContextsMapping;
    /* rw */ private final Map<Integer, Integer> rightmostContextsMapping;

    // phase 2
    /* -w */ private final Map<UniqueProduction, Production> uniqueProductionMapping;
    /* rw */ private final BiMap2<IProduction, ContextualProduction> prodContextualProdMapping;
    /* rw */ private final BiMap2<IProduction, Integer> productionLabels;
    /* rw */ private final SetMultimap<ISymbol, IProduction> symbolProductionsMapping;
    /* rw */ private final SetMultimap<IProduction, IAttribute> productionAttributesMapping;
    /* rw */ private final SetMultimap<Priority, Integer> priorities;

    public void patchParseTable() {
        /*
         * int sizeDiff_uniqueProductionToProduction = uniqueProductionMapping.size() -
         * pt.normalizedGrammar().getUniqueProductionMapping().size(); int sizeDiff_symbolToProductions =
         * symbolProductionsMapping.size() - pt.normalizedGrammar().getSymbolProductionsMapping().size(); int
         * sizeDiff_productionToLabel = productionLabels.size() - pt.productionLabels().size();
         * 
         * int sizeDiff_productionToAttributes = productionAttributesMapping.size() -
         * pt.normalizedGrammar().getProductionAttributesMapping().size(); int sizeDiff_productionToContextualProduction
         * = prodContextualProdMapping.size() - pt.normalizedGrammar().getProdContextualProdMapping().size();
         */

        pt.normalizedGrammar().getUniqueProductionMapping().putAll(uniqueProductionMapping);
        pt.normalizedGrammar().getSymbolProductionsMapping().putAll(symbolProductionsMapping);
        pt.productionLabels().putAll(productionLabels);
        pt.normalizedGrammar().getProductionAttributesMapping().putAll(productionAttributesMapping);
        pt.normalizedGrammar().getProdContextualProdMapping().putAll(prodContextualProdMapping);
        pt.normalizedGrammar().priorities().putAll(priorities);

        pt.getLeftmostContextsMapping().putAll(leftmostContextsMapping);
        pt.getRightmostContextsMapping().putAll(rightmostContextsMapping);
    }

    public void deepConflictAnalysis() {
        deepConflictAnalysis(pt, true, true, true);

        /*
         * int sizeDiff_uniqueProductionToProduction = uniqueProductionMapping.size() -
         * pt.normalizedGrammar().getUniqueProductionMapping().size(); int sizeDiff_symbolToProductions =
         * symbolProductionsMapping.size() - pt.normalizedGrammar().getSymbolProductionsMapping().size(); int
         * sizeDiff_productionToLabel = productionLabels.size() - pt.productionLabels().size();
         * 
         * int sizeDiff_productionToAttributes = productionAttributesMapping.size() -
         * pt.normalizedGrammar().getProductionAttributesMapping().size(); int sizeDiff_productionToContextualProduction
         * = prodContextualProdMapping.size() - pt.normalizedGrammar().getProdContextualProdMapping().size();
         * 
         * Set<Integer> newLabels = new HashSet<>(productionLabels.inverse().keySet()); Set<Integer> oldLabels = new
         * HashSet<>(pt.productionLabels().inverse().keySet());
         * 
         * Set<Integer> diffLabels = new HashSet<>(newLabels); diffLabels.removeAll(oldLabels);
         */
    }

    public void deepConflictAnalysis(ParseTable pt, boolean operatorStyle, boolean danglingPrefixOrSuffix,
        boolean longestMatch) {

        fixNullableRecursive();

        for(Priority prio : pt.normalizedGrammar().priorities().keySet()) {
            Production higher = prio.higher();
            Production lower = prio.lower();

            if(operatorStyle) {
                // postfix-prefix conflict
                if(higher.leftRecursivePosition() != -1 && // higher is postfix
                    lower.leftRecursivePosition() == -1 && lower.rightRecursivePosition() != -1 && // lower is prefix
                    mutuallyRecursive(pt, prio) && // the productions are mutually recursive
                    pt.normalizedGrammar().priorities().containsEntry(prio, 0)) { // the priority is E.In right E.Pre

                    handleInfixPrefixConflict(pt, prio, higher, lower);
                } // prefix-postfix conflict
                else if(higher.rightRecursivePosition() != -1 && // higher is prefix
                    lower.leftRecursivePosition() != -1 && lower.rightRecursivePosition() == -1 && // lower is postfix
                    mutuallyRecursive(pt, prio) && // the productions are mutually recursive
                    pt.normalizedGrammar().priorities().containsEntry(prio, higher.getRhs().size() - 1)) { // the
                    // priority
                    // is
                    // E.In left E.Pos
                    handleInfixPostFixConflict(pt, prio, higher, lower);
                }

                // regular priority indirect recursion conflict
                handleIndirectRecursionConflict(pt, prio, higher);
            }

            if(danglingPrefixOrSuffix) {
                // dangling suffix conflict
                if(!higher.equals(lower) && pt.getDanglingSuffix().contains(higher)
                    && pt.getDanglingSuffix().contains(lower)) {
                    handleDanglingSuffixConflict(pt, prio, higher, lower);
                }

                // dangling prefix conflict
                if(!higher.equals(lower) && pt.getDanglingPrefix().contains(higher)
                    && pt.getDanglingPrefix().contains(lower)) {
                    handleDanglingPrefixConflict(pt, prio, higher, lower);
                }
            }

        }

        if(longestMatch) {
            // longest and shortest match conflicts
            for(Symbol s : pt.normalizedGrammar().getLongestMatchProdsFront().keySet()) {
                handleLongestMatchConflictFront(pt, s);
            }

            for(Symbol s : pt.normalizedGrammar().getLongestMatchProdsBack().keySet()) {
                handleLongestMatchConflictBack(pt, s);
            }
        }
    }

    private void fixNullableRecursive() {

        // FIXME: only works for a single nullable symbol

        // TODO:
        // check if production has hidden recursion
        // make recursion explicit using deep priority conflicts
        // deal with overlap between new productions



        // adding new production
        // UniqueProduction uniqueProd = new UniqueProduction(p.getLhs(), new_rhs);
        // uniqueProductionMapping.put(uniqueProd, newProd);
        // productionAttributesMapping.putAll(newProd, productionAttributesMapping.get(p));
        // symbolProductionsMapping.put(p.leftHand(), newProd);
        // productionLabels.put(newProd, pt.getProdLabelFactory().getNextLabel());
        //


    }

    private boolean mutuallyRecursive(ParseTable pt, Priority p) {
        return pt.normalizedGrammar().getLeftRecursiveSymbolsMapping().get(p.higher().leftHand())
            .contains(p.lower().leftHand())
            || pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(p.higher().leftHand())
                .contains(p.lower().leftHand());
    }

    private Context deepContextFrom(int productionId, ContextPosition position) {
        if(isContextMappingStable) {
            return pt.getContextualFactory().createContext(productionId, ContextType.DEEP, position, 
                leftmostContextsMapping, rightmostContextsMapping);
        } else {
            // use dummy values
            return pt.getContextualFactory().createContext(productionId, ContextType.DEEP, position,
                Collections.emptyMap(), Collections.emptyMap());
        }
    }

    private Context danglingContextFrom(int productionId, ContextPosition position) {
        if(isContextMappingStable) {
            return pt.getContextualFactory().createContext(productionId, ContextType.DANGLING, position,
                leftmostContextsMapping, rightmostContextsMapping);
        } else {
            // use dummy values
            return pt.getContextualFactory().createContext(productionId, ContextType.DANGLING, position,
                Collections.emptyMap(), Collections.emptyMap());
        }
    }

    private void handleInfixPrefixConflict(ParseTable pt, Priority prio, Production higher, Production lower) {
        // check whether the priorities that remove the conflict exist
        Priority inverse = pt.normalizedGrammar().getGrammarFactory().createPriority(lower, higher, false);
        // checking E.Pre left E.In
        if(pt.normalizedGrammar().priorities().get(inverse).contains(lower.rightRecursivePosition())) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.leftRecursivePosition();

        Set<Context> contexts = new HashSet<Context>();
        int labelLower = productionLabels.get(prio.lower());
        if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelLower)) {
            rightmostContextsMapping.put(labelLower, rightmostContextsMapping.size());
        }
        Context new_context = deepContextFrom(labelLower, ContextPosition.RIGHTMOST);
        contexts.add(new_context);

        Set<Integer> conflicting_args = new HashSet<Integer>();
        conflicting_args.add(conflict_pos);

        // create production E = E<lower> in E
        ContextualProduction p = pt.getContextualFactory().createContextualProduction(prio.higher(), contexts,
            conflicting_args, productionLabels.get(prio.higher()), pt.getContextualFactory());

        // if contextual production does not exist add it
        if(!prodContextualProdMapping.containsKey(prio.higher())) {
            prodContextualProdMapping.put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
            prodContextualProdMapping.replace(prio.higher(), existing_prod.addContext(new_context, conflicting_args));
        }
    }

    private void handleInfixPostFixConflict(ParseTable pt, Priority prio, Production higher, Production lower) {
        // check whether the priorities that remove the conflict exist
        Priority inverse = pt.normalizedGrammar().getGrammarFactory().createPriority(lower, higher, false);
        // checking E.Pos right E.In
        if(pt.normalizedGrammar().priorities().get(inverse).contains(0)) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.rightRecursivePosition();

        Set<Context> contexts = new HashSet<Context>();
        int labelLower = productionLabels.get(prio.lower());
        if(!isContextMappingStable && !leftmostContextsMapping.containsKey(labelLower)) {
            leftmostContextsMapping.put(labelLower, leftmostContextsMapping.size());
        }
        Context new_context = deepContextFrom(labelLower, ContextPosition.LEFTMOST);
        contexts.add(new_context);

        Set<Integer> conflicting_args = new HashSet<Integer>();
        conflicting_args.add(conflict_pos);

        // create production E = E in E<lower>
        ContextualProduction p = pt.getContextualFactory().createContextualProduction(prio.higher(), contexts,
            conflicting_args, productionLabels.get(prio.higher()), pt.getContextualFactory());

        // if contextual production does not exist add it
        if(!prodContextualProdMapping.containsKey(prio.higher())) {
            prodContextualProdMapping.put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
            prodContextualProdMapping.replace(prio.higher(), existing_prod.addContext(new_context, conflicting_args));
        }
    }

    private void handleDanglingSuffixConflict(ParseTable pt, Priority prio, Production higher, Production lower) {

        for(int conflict : pt.normalizedGrammar().priorities().get(prio)) {
            if(conflict < 0)
                continue;

            Set<Context> contexts = new HashSet<Context>();
            int labelLower = productionLabels.get(prio.lower());
            if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelLower)) {
                rightmostContextsMapping.put(labelLower, rightmostContextsMapping.size());
            }
            Context new_context_right = danglingContextFrom(labelLower, ContextPosition.RIGHTMOST);
            Context new_context_left = danglingContextFrom(labelLower, ContextPosition.LEFTMOST);
            contexts.add(new_context_right);
            contexts.add(new_context_left);

            Set<Integer> conflicting_args = new HashSet<Integer>();
            conflicting_args.add(conflict);

            // create production E = pre E<lower> in E
            ContextualProduction p = pt.getContextualFactory().createContextualProduction(prio.higher(), contexts,
                conflicting_args, productionLabels.get(prio.higher()), pt.getContextualFactory());

            // if contextual production does not exist add it
            if(!prodContextualProdMapping.containsKey(prio.higher())) {
                prodContextualProdMapping.put(prio.higher(), p);
            } else {
                // add new context to correct arguments of existing contextual production
                ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
                existing_prod = existing_prod.addContext(new_context_right, conflicting_args);
                prodContextualProdMapping.replace(prio.higher(),
                    existing_prod.addContext(new_context_left, conflicting_args));
                // existing_prod.addContext(new_context, conflicting_args);
            }

        }
    }

    private void handleDanglingPrefixConflict(ParseTable pt, Priority prio, Production higher, Production lower) {
        for(int conflict : pt.normalizedGrammar().priorities().get(prio)) {

            if(conflict < 0 || lower.getRhs().size() < (higher.getRhs().size() - conflict))
                continue;

            Set<Context> contexts = new HashSet<Context>();
            int labelLower = productionLabels.get(prio.lower());
            if(!isContextMappingStable && !leftmostContextsMapping.containsKey(labelLower)) {
                leftmostContextsMapping.put(labelLower, leftmostContextsMapping.size());
            }
            Context new_context_right = danglingContextFrom(labelLower, ContextPosition.RIGHTMOST);
            Context new_context_left = danglingContextFrom(labelLower, ContextPosition.LEFTMOST);
            contexts.add(new_context_right);
            contexts.add(new_context_left);

            Set<Integer> conflicting_args = new HashSet<Integer>();
            conflicting_args.add(conflict);

            // create production E = E in E<lower> pos
            ContextualProduction p = pt.getContextualFactory().createContextualProduction(prio.higher(), contexts,
                conflicting_args, productionLabels.get(prio.higher()), pt.getContextualFactory());

            // if contextual production does not exist add it
            if(!prodContextualProdMapping.containsKey(prio.higher())) {
                prodContextualProdMapping.put(prio.higher(), p);
            } else {
                // add new context to correct arguments of existing contextual production
                ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
                existing_prod = existing_prod.addContext(new_context_right, conflicting_args);
                prodContextualProdMapping.replace(prio.higher(),
                    existing_prod.addContext(new_context_left, conflicting_args));
            }

        }
    }

    private void handleIndirectRecursionConflict(ParseTable pt, Priority prio, Production higher) {
        for(Integer arg : pt.normalizedGrammar().priorities().get(prio)) {
            if(arg < 0 || arg >= higher.getRhs().size())
                continue;

            // the priority refers to a left recursive conflict
            if(arg == higher.leftRecursivePosition()
                // higher production is left recursive
                && pt.normalizedGrammar().getLeftRecursiveSymbolsMapping().get(higher.leftHand())
                    .contains(higher.getRhs().get(arg))
                // is and indirect conflict
                && !higher.getRhs().get(arg).equals(prio.lower().leftHand())) {

                Set<Integer> conflicting_args = new HashSet<Integer>();
                conflicting_args.add(arg);

                Set<Context> contexts = new HashSet<Context>();
                int labelLower = productionLabels.get(prio.lower());
                // if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelLower)) {
                // rightmostContextsMapping.put(labelLower, rightmostContextsMapping.size());
                // }
                Context new_context = deepContextFrom(labelLower, ContextPosition.RIGHTMOST);
                contexts.add(new_context);

                // create production E = A<lower> beta
                ContextualProduction p = pt.getContextualFactory().createContextualProduction(prio.higher(), contexts,
                    conflicting_args, productionLabels.get(prio.higher()), pt.getContextualFactory());

                // if contextual production does not exist add it
                if(!prodContextualProdMapping.containsKey(prio.higher())) {
                    prodContextualProdMapping.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
                    prodContextualProdMapping.replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                }
            }
            // the priority refers to a right recursive conflict
            if(arg == higher.rightRecursivePosition()
                // the the production is right recursive
                && pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(higher.leftHand())
                    .contains(higher.getRhs().get(arg))
                // is an indirect conflict
                && !higher.getRhs().get(arg).equals(prio.lower().leftHand())) {

                Set<Integer> conflicting_args = new HashSet<Integer>();
                conflicting_args.add(arg);

                Set<Context> contexts = new HashSet<Context>();
                int labelLower = productionLabels.get(prio.lower());
                if(!isContextMappingStable && !leftmostContextsMapping.containsKey(labelLower)) {
                    leftmostContextsMapping.put(labelLower, leftmostContextsMapping.size());
                }
                Context new_context = deepContextFrom(labelLower, ContextPosition.LEFTMOST);
                contexts.add(new_context);

                // create production E = alpha B<lower>
                ContextualProduction p = pt.getContextualFactory().createContextualProduction(prio.higher(), contexts,
                    conflicting_args, productionLabels.get(prio.higher()), pt.getContextualFactory());

                // if contextual production does not exist add it
                if(!prodContextualProdMapping.containsKey(prio.higher())) {
                    prodContextualProdMapping.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
                    prodContextualProdMapping.replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                }
            }
        }
    }

    private void handleLongestMatchConflictFront(ParseTable pt2, Symbol s) {
        Set<Context> contexts = new HashSet<Context>();
        GrammarFactory gf = this.pt.normalizedGrammar().getGrammarFactory();

        Set<Production> longestMatchProds = pt.normalizedGrammar().getLongestMatchProdsFront().get(s);
        for(Production p : longestMatchProds) {
            int labelP = productionLabels.get(p);
            if(!isContextMappingStable && !leftmostContextsMapping.containsKey(labelP)) {
                leftmostContextsMapping.put(labelP, leftmostContextsMapping.size());
            }
            Context new_context = deepContextFrom(labelP, ContextPosition.LEFTMOST);
            contexts.add(new_context);
        }

        Symbol iterList = s;

        if(s instanceof LexicalSymbol) {
            // check whether s is a * list
            ISymbol list = ((LexicalSymbol) s).getSymbol();
            if(list instanceof IterStarSymbol) {
                iterList = gf.createLexicalSymbol(gf.createIterSymbol(((IterStarSymbol) list).getSymbol()));
            } else if(list instanceof IterStarSepSymbol) {
                iterList = gf.createLexicalSymbol(gf.createIterSepSymbol(((IterStarSepSymbol) list).getSymbol(),
                    ((IterStarSepSymbol) list).getSeparator()));
            }
        }

        // change production A+ -> A+ A to A+ -> A+ <ctx>A
        for(IProduction p : symbolProductionsMapping.get(iterList)) {

            if(p.arity() > 1) {
                ContextualProduction ctx_p = pt.getContextualFactory().createContextualProduction((Production) p,
                    contexts, new HashSet<>(Arrays.asList(2)), productionLabels.get(p), pt.getContextualFactory());

                // if contextual production does not exist add it
                if(!prodContextualProdMapping.containsKey(p)) {
                    prodContextualProdMapping.put((Production) p, ctx_p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = prodContextualProdMapping.get(p);
                    prodContextualProdMapping.replace((Production) p,
                        existing_prod.addContexts(contexts, new HashSet<>(Arrays.asList(2))));
                }
            }
        }

    }

    private void handleLongestMatchConflictBack(ParseTable pt, Symbol s) {
        Set<Context> contexts = new HashSet<Context>();
        GrammarFactory gf = this.pt.normalizedGrammar().getGrammarFactory();

        Set<Production> longestMatchProds = pt.normalizedGrammar().getLongestMatchProdsBack().get(s);
        for(Production p : longestMatchProds) {
            int labelP = productionLabels.get(p);
            if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelP)) {
                rightmostContextsMapping.put(labelP, rightmostContextsMapping.size());
            }
            Context new_context = deepContextFrom(labelP, ContextPosition.RIGHTMOST);
            contexts.add(new_context);
        }

        Symbol iterList = s;
        Map<Production, Production> newProductions = new LinkedHashMap<>();

        if(s instanceof ContextFreeSymbol) {
            // check whether s is a * list
            ISymbol list = ((ContextFreeSymbol) s).getSymbol();

            if(list instanceof IterStarSymbol) {
                iterList = gf.createContextFreeSymbol(gf.createIterSymbol(((IterStarSymbol) list).getSymbol()));

                // FIXME: is there a better way to do this?
                // the previous symbol can derive a non-empty list only if this list is empty
                // thus, generate the contextual productions A.C = α A S*{S* = S+} and A.C = α A{C} S+
                for(Production p : pt.normalizedGrammar().getLongestMatchProdsBack().get(s)) {
                    if(p.getRhs().size() < 0)
                        continue;
                    int pos = p.getRhs().size() - 3; // second to last symbol
                    ISymbol spos = p.getRhs().get(pos);
                    if(pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(spos).contains(p.leftHand())) {

                        IProduction nullableListProd = null;
                        IProduction nonNullableListProd = null;

                        // FIXME only works with current normalization method
                        for(IProduction list_p : symbolProductionsMapping.get(s)) {
                            if(list_p.arity() == 1) {
                                nonNullableListProd = list_p;
                            } else {
                                nullableListProd = list_p;
                            }
                        }
                        if(nullableListProd != null && nonNullableListProd != null) {
                            // add priority A.C = α A S* <rhs(A.C)> > S* = S+
                            if(nonNullableListProd instanceof Production) {
                                priorities.put(gf.createPriority(p, (Production) nonNullableListProd, false),
                                    p.arity() - 1);
                            } else {
                                priorities.put(
                                    gf.createPriority(p,
                                        ((ContextualProduction) nonNullableListProd).getOrigProduction(), false),
                                    p.arity() - 1);
                            }

                            // create A.C = α A{C} S+
                            List<Symbol> new_rhs = new ArrayList<>();
                            for(int i = 0; i < p.arity() - 1; i++) {
                                new_rhs.add(p.getRhs().get(i));
                            }
                            new_rhs.add(iterList);
                            Production newProd = gf.createProduction(p.getLhs(), new_rhs, p.leftRecursivePosition(),
                                p.rightRecursivePosition());
                            // adding new production
                            UniqueProduction uniqueProd = gf.createUniqueProduction(p.getLhs(), new_rhs);
                            uniqueProductionMapping.put(uniqueProd, newProd);
                            productionAttributesMapping.putAll(newProd, productionAttributesMapping.get(p));
                            symbolProductionsMapping.put(p.leftHand(), newProd);
                            productionLabels.put(newProd, pt.getProdLabelFactory().getNextLabel());

                            int labelNewProd = productionLabels.get(newProd);
                            if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelNewProd)) {
                                rightmostContextsMapping.put(labelNewProd, rightmostContextsMapping.size());
                            }
                            Context new_context = deepContextFrom(labelNewProd, ContextPosition.RIGHTMOST);
                            contexts.add(new_context);

                            newProductions.put(newProd, p);


                        }
                    }

                }

                // add new contextual productions A.C = α A{C} S+
                for(Production newProd : newProductions.keySet()) {
                    int pos = newProductions.get(newProd).arity() - 3; // second to last symbol
                    if(!prodContextualProdMapping.containsKey(newProd)) {
                        ContextualProduction ctx_p2 = pt.getContextualFactory().createContextualProduction(newProd,
                            contexts, new HashSet<>(Arrays.asList(pos)), productionLabels.get(newProd), pt.getContextualFactory());
                        contexts = Collections.unmodifiableSet(contexts);
                        prodContextualProdMapping.put(newProd, ctx_p2);
                    } else {
                        // add new context to correct arguments of existing contextual production
                        ContextualProduction existing_prod = prodContextualProdMapping.get(newProductions.get(newProd));
                        prodContextualProdMapping.replace(newProd,
                            existing_prod.addContexts(contexts, new HashSet<>(Arrays.asList(pos))));
                    }
                }


            } else if(list instanceof IterStarSepSymbol) {
                iterList = gf.createContextFreeSymbol(gf.createIterSepSymbol(((IterStarSepSymbol) list).getSymbol(),
                    ((IterStarSepSymbol) list).getSeparator()));
            }
        }
        if(s instanceof LexicalSymbol) {
            // check whether s is a * list
            ISymbol list = ((LexicalSymbol) s).getSymbol();
            if(list instanceof IterStarSymbol) {
                iterList = gf.createLexicalSymbol(gf.createIterSymbol(((IterStarSymbol) list).getSymbol()));
            } else if(list instanceof IterStarSepSymbol) {
                iterList = gf.createLexicalSymbol(gf.createIterSepSymbol(((IterStarSepSymbol) list).getSymbol(),
                    ((IterStarSepSymbol) list).getSeparator()));
            }
        }

        // change production A+ -> A+ A to A+ -> A+<ctx> A
        for(IProduction p : symbolProductionsMapping.get(iterList)) {

            if(p.arity() > 1) {
                ContextualProduction ctx_p = pt.getContextualFactory().createContextualProduction((Production) p,
                    contexts, new HashSet<>(Arrays.asList(0)), productionLabels.get(p), pt.getContextualFactory());

                // if contextual production does not exist add it
                if(!prodContextualProdMapping.containsKey(p)) {
                    prodContextualProdMapping.put((Production) p, ctx_p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = prodContextualProdMapping.get(p);
                    prodContextualProdMapping.replace((Production) p,
                        existing_prod.addContexts(contexts, new HashSet<>(Arrays.asList(0))));
                }
            }
        }


    }

}
