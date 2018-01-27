package org.metaborg.sdf2table.deepconflicts;

import com.google.common.collect.*;
import org.metaborg.sdf2table.grammar.*;
import org.metaborg.sdf2table.parsetable.ParseTable;

import java.util.*;
import java.util.stream.Collectors;

public class DeepConflictsAnalyzer {

    public static DeepConflictsAnalyzer fromParseTable(ParseTable pt) {
        final DeepConflictsAnalyzer phase1 = new DeepConflictsAnalyzer(pt);
        phase1.deepConflictAnalysis();

        // TODO: due to usage of factory labels might be different from one phase to another; needs checking.
        Set<Integer> newLabels = phase1.productionLabels.inverse().keySet().stream().collect(Collectors.toSet());
        Set<Integer> oldLabels = pt.productionLabels().inverse().keySet().stream().collect(Collectors.toSet());

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
        this.leftmostContextsMapping = Maps.newLinkedHashMap();
        this.rightmostContextsMapping = Maps.newLinkedHashMap();

        this.uniqueProductionMapping = Maps.newLinkedHashMap(pt.normalizedGrammar().getUniqueProductionMapping());
        this.prodContextualProdMapping = HashBiMap.create(pt.normalizedGrammar().getProdContextualProdMapping());
        this.productionLabels = HashBiMap.create(pt.productionLabels());
        this.symbolProductionsMapping = HashMultimap.create(pt.normalizedGrammar().getSymbolProductionsMapping());
        this.productionAttributesMapping = HashMultimap.create(pt.normalizedGrammar().getProductionAttributesMapping());
        this.priorities = HashMultimap.create(pt.normalizedGrammar().priorities());
    }

    private DeepConflictsAnalyzer(ParseTable pt, Map<Integer, Integer> leftmostContextsMapping,
        Map<Integer, Integer> rightmostContextsMapping) {
        this.pt = pt;

        this.isContextMappingStable = true;
        this.leftmostContextsMapping = ImmutableMap.copyOf(leftmostContextsMapping);
        this.rightmostContextsMapping = ImmutableMap.copyOf(rightmostContextsMapping);

        this.uniqueProductionMapping = Maps.newHashMap(pt.normalizedGrammar().getUniqueProductionMapping());
        this.prodContextualProdMapping = HashBiMap.create(pt.normalizedGrammar().getProdContextualProdMapping());
        this.productionLabels = HashBiMap.create(pt.productionLabels());
        this.symbolProductionsMapping = HashMultimap.create(pt.normalizedGrammar().getSymbolProductionsMapping());
        this.productionAttributesMapping = HashMultimap.create(pt.normalizedGrammar().getProductionAttributesMapping());
        this.priorities = HashMultimap.create(pt.normalizedGrammar().priorities());
    }

    private final ParseTable pt;
    private final boolean isContextMappingStable;

    // phase 1
    /* rw */ private final Map<Integer, Integer> leftmostContextsMapping;
    /* rw */ private final Map<Integer, Integer> rightmostContextsMapping;

    // phase 2
    /* -w */ private final Map<UniqueProduction, IProduction> uniqueProductionMapping;
    /* rw */ private final BiMap<IProduction, ContextualProduction> prodContextualProdMapping;
    /* rw */ private final BiMap<IProduction, Integer> productionLabels;
    /* rw */ private final SetMultimap<Symbol, IProduction> symbolProductionsMapping;
    /* rw */ private final SetMultimap<IProduction, IAttribute> productionAttributesMapping;
    /* rw */ private final SetMultimap<IPriority, Integer> priorities;

    public void patchParseTable() {
        /*
        int sizeDiff_uniqueProductionToProduction = uniqueProductionMapping.size() - pt.normalizedGrammar().getUniqueProductionMapping().size();
        int sizeDiff_symbolToProductions = symbolProductionsMapping.size() - pt.normalizedGrammar().getSymbolProductionsMapping().size();
        int sizeDiff_productionToLabel = productionLabels.size() - pt.productionLabels().size();

        int sizeDiff_productionToAttributes = productionAttributesMapping.size() - pt.normalizedGrammar().getProductionAttributesMapping().size();
        int sizeDiff_productionToContextualProduction = prodContextualProdMapping.size() - pt.normalizedGrammar().getProdContextualProdMapping().size();
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
        int sizeDiff_uniqueProductionToProduction = uniqueProductionMapping.size() - pt.normalizedGrammar().getUniqueProductionMapping().size();
        int sizeDiff_symbolToProductions = symbolProductionsMapping.size() - pt.normalizedGrammar().getSymbolProductionsMapping().size();
        int sizeDiff_productionToLabel = productionLabels.size() - pt.productionLabels().size();

        int sizeDiff_productionToAttributes = productionAttributesMapping.size() - pt.normalizedGrammar().getProductionAttributesMapping().size();
        int sizeDiff_productionToContextualProduction = prodContextualProdMapping.size() - pt.normalizedGrammar().getProdContextualProdMapping().size();

        Set<Integer> newLabels = productionLabels.inverse().keySet().stream().collect(Collectors.toSet());
        Set<Integer> oldLabels = pt.productionLabels().inverse().keySet().stream().collect(Collectors.toSet());

        Set<Integer> diffLabels = new HashSet<>(newLabels);
        diffLabels.removeAll(oldLabels);
        */
    }

    public void deepConflictAnalysis(ParseTable pt, boolean operatorStyle, boolean danglingElse, boolean longestMatch) {
        for(IPriority prio : pt.normalizedGrammar().priorities().keySet()) {
            IProduction higher = prio.higher();
            IProduction lower = prio.lower();

            if(operatorStyle) {
                // postfix-prefix conflict
                if(higher.leftRecursivePosition() != -1 && // higher is postfix
                    lower.leftRecursivePosition() == -1 && lower.rightRecursivePosition() != -1 && // lower is prefix
                    mutuallyRecursive(pt, prio) && // the productions are mutually recursive
                    pt.normalizedGrammar().priorities().containsEntry(prio, 0)) { // the priority is E.In right E.Pre

                    handleInfixPrefixConflict(pt, prio, higher, lower);
                } // prefix-postfix conflict
                else if(operatorStyle && higher.rightRecursivePosition() != -1 && // higher is prefix
                    lower.leftRecursivePosition() != -1 && lower.rightRecursivePosition() == -1 && // lower is postfix
                    mutuallyRecursive(pt, prio) && // the productions are mutually recursive
                    pt.normalizedGrammar().priorities().containsEntry(prio, higher.rightHand().size() - 1)) { // the
                    // priority
                    // is
                    // E.In left E.Pos
                    handleInfixPostFixConflict(pt, prio, higher, lower);
                }
                
             // regular priority indirect recursion conflict
                handleIndirectRecursionConflict(pt, prio, higher);
            }

            if(danglingElse) {
                // dangling else conflict
                if(higher.leftRecursivePosition() == -1 // higher has prefix
                    && lower.leftRecursivePosition() == -1) { // lower is prefix
                    handleDanglingElseConflict(pt, prio, higher, lower);

                } // mirrored dangling else conflict
                else if(higher.rightRecursivePosition() == -1 // higher has postfix
                    && lower.rightRecursivePosition() == -1) { // lower is postfix
                    handleMirroredDanglingElseConflict(pt, prio, higher, lower);
                }
            }           

        }

        if(longestMatch) {
            // longest-match conflicts
            for(Symbol s : pt.normalizedGrammar().getLongestMatchProds().keySet()) {
                handleLongestMatchConflict(pt, s);
            }
        }
    }

    private boolean mutuallyRecursive(ParseTable pt, IPriority p) {
        return pt.normalizedGrammar().getLeftRecursiveSymbolsMapping().get(p.higher().leftHand())
            .contains(p.lower().leftHand())
            || pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(p.higher().leftHand())
                .contains(p.lower().leftHand());
    }

    private Context deepContextFrom(int productionId, ContextPosition position, boolean isIndirect) {
        if(isContextMappingStable) {
            return new Context(productionId, ContextType.DEEP, position, isIndirect, leftmostContextsMapping,
                rightmostContextsMapping);
        } else {
            // use dummy values
            return new Context(productionId, ContextType.DEEP, position, isIndirect, Collections.emptyMap(),
                Collections.emptyMap());
        }
    }

    private void handleInfixPrefixConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
        // check whether the priorities that remove the conflict exist
        IPriority inverse = new Priority(lower, higher, false);
        // checking E.Pre left E.In
        if(pt.normalizedGrammar().priorities().get(inverse).contains(lower.rightRecursivePosition())) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.leftRecursivePosition();

        Set<Context> contexts = Sets.newHashSet();
        int labelLower = productionLabels.get(prio.lower());
        if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelLower)) {
            rightmostContextsMapping.put(labelLower, rightmostContextsMapping.size());
        }
        Context new_context = deepContextFrom(labelLower, ContextPosition.RIGHTMOST, false);
        contexts.add(new_context);

        Set<Integer> conflicting_args = Sets.newHashSet();
        conflicting_args.add(conflict_pos);

        // create production E = E<lower> in E
        ContextualProduction p =
            new ContextualProduction(prio.higher(), contexts, conflicting_args, productionLabels.get(prio.higher()));

        // if contextual production does not exist add it
        if(!prodContextualProdMapping.containsKey(prio.higher())) {
            prodContextualProdMapping.put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
            prodContextualProdMapping.replace(prio.higher(), existing_prod.addContext(new_context, conflicting_args));
        }
    }

    private void handleInfixPostFixConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
        // check whether the priorities that remove the conflict exist
        IPriority inverse = new Priority(lower, higher, false);
        // checking E.Pos right E.In
        if(pt.normalizedGrammar().priorities().get(inverse).contains(0)) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.rightRecursivePosition();

        Set<Context> contexts = Sets.newHashSet();
        int labelLower = productionLabels.get(prio.lower());
        if(!isContextMappingStable && !leftmostContextsMapping.containsKey(labelLower)) {
            leftmostContextsMapping.put(labelLower, leftmostContextsMapping.size());
        }
        Context new_context = deepContextFrom(labelLower, ContextPosition.LEFTMOST, false);
        contexts.add(new_context);

        Set<Integer> conflicting_args = Sets.newHashSet();
        conflicting_args.add(conflict_pos);

        // create production E = E in E<lower>
        ContextualProduction p =
            new ContextualProduction(prio.higher(), contexts, conflicting_args, productionLabels.get(prio.higher()));

        // if contextual production does not exist add it
        if(!prodContextualProdMapping.containsKey(prio.higher())) {
            prodContextualProdMapping.put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
            prodContextualProdMapping.replace(prio.higher(), existing_prod.addContext(new_context, conflicting_args));
        }
    }

    private void handleDanglingElseConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
        boolean matchPrefix = false;

        for(int conflict : pt.normalizedGrammar().priorities().get(prio)) {
            if(lower.rightHand().size() < conflict - 1)
                continue;
            for(int i = 0; i <= conflict; i++) {
                if(higher.rightHand().get(i).equals(lower.rightHand().get(i))) {
                    matchPrefix = true;
                } else {
                    matchPrefix = false;
                    break;
                }
            }
            if(matchPrefix && !higher.equals(lower)) {
                Set<Context> contexts = Sets.newHashSet();
                int labelLower = productionLabels.get(prio.lower());
                if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelLower)) {
                    rightmostContextsMapping.put(labelLower, rightmostContextsMapping.size());
                }
                Context new_context = deepContextFrom(labelLower, ContextPosition.RIGHTMOST, false);
                contexts.add(new_context);

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(conflict);

                // create production E = pre E<lower> in E
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args,
                    productionLabels.get(prio.higher()));

                // if contextual production does not exist add it
                if(!prodContextualProdMapping.containsKey(prio.higher())) {
                    prodContextualProdMapping.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = prodContextualProdMapping.get(prio.higher());
                    prodContextualProdMapping.replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                    // existing_prod.addContext(new_context, conflicting_args);
                }
            }
        }
    }

    private void handleMirroredDanglingElseConflict(ParseTable pt, IPriority prio, IProduction higher,
        IProduction lower) {
        boolean matchSuffix = false;

        for(int conflict : pt.normalizedGrammar().priorities().get(prio)) {
            if(lower.rightHand().size() < (higher.rightHand().size() - conflict))
                continue;

            for(int i = 0; i < higher.rightHand().size() - conflict; i++) {
                if(higher.rightHand().get(higher.rightHand().size() - 1 - i) // check backwards
                    .equals(lower.rightHand().get(lower.rightHand().size() - 1 - i))) {
                    matchSuffix = true;
                } else {
                    matchSuffix = false;
                    break;
                }
            }
            if(matchSuffix && !higher.equals(lower)) {
                Set<Context> contexts = Sets.newHashSet();
                int labelLower = productionLabels.get(prio.lower());
                if(!isContextMappingStable && !leftmostContextsMapping.containsKey(labelLower)) {
                    leftmostContextsMapping.put(labelLower, leftmostContextsMapping.size());
                }
                Context new_context = deepContextFrom(labelLower, ContextPosition.LEFTMOST, false);
                contexts.add(new_context);

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(conflict);

                // create production E = E in E<lower> pos
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args,
                    productionLabels.get(prio.higher()));

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

    private void handleIndirectRecursionConflict(ParseTable pt, IPriority prio, IProduction higher) {
        for(Integer arg : pt.normalizedGrammar().priorities().get(prio)) {
            if(arg < 0 || arg >= higher.rightHand().size())
                continue;

            // the priority refers to a left recursive conflict
            if(arg == higher.leftRecursivePosition()
                // higher production is left recursive
                && pt.normalizedGrammar().getLeftRecursiveSymbolsMapping().get(higher.leftHand())
                    .contains(higher.rightHand().get(arg))
                // is and indirect conflict
                && !higher.rightHand().get(arg).equals(prio.lower().leftHand())) {

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(arg);

                Set<Context> contexts = Sets.newHashSet();
                int labelLower = productionLabels.get(prio.lower());
                Context new_context = deepContextFrom(labelLower, ContextPosition.RIGHTMOST, true);
                contexts.add(new_context);

                // create production E = A<lower> beta
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args,
                    productionLabels.get(prio.higher()));

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
                    .contains(higher.rightHand().get(arg))
                // is an indirect conflict
                && !higher.rightHand().get(arg).equals(prio.lower().leftHand())) {

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(arg);

                Set<Context> contexts = Sets.newHashSet();
                int labelLower = productionLabels.get(prio.lower());
                Context new_context = deepContextFrom(labelLower, ContextPosition.LEFTMOST, true);
                contexts.add(new_context);

                // create production E = alpha B<lower>
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args,
                    productionLabels.get(prio.higher()));

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

    private void handleLongestMatchConflict(ParseTable pt, Symbol s) {
        Set<Context> contexts = Sets.newHashSet();
        for(IProduction p : pt.normalizedGrammar().getLongestMatchProds().get(s)) {
            int labelP = productionLabels.get(p);
            if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelP)) {
                rightmostContextsMapping.put(labelP, rightmostContextsMapping.size());
            }
            Context new_context = deepContextFrom(labelP, ContextPosition.RIGHTMOST, false);
            contexts.add(new_context);
        }

        Symbol iterList = s;
        Map<IProduction, IProduction> newProductions = Maps.newLinkedHashMap();

        if(s instanceof ContextFreeSymbol) {
            // check whether s is a * list
            Symbol list = ((ContextFreeSymbol) s).getSymbol();

            if(list instanceof IterStarSymbol) {
                iterList = new ContextFreeSymbol(new IterSymbol(((IterStarSymbol) list).getSymbol()));
                // FIXME: is there a better way to do this?
                // the previous symbol can derive a non-empty list only if this list is empty
                // thus, generate the contextual productions A.C = α A S*{S* = S+} and A.C = α A{C} S+
                for(IProduction p : pt.normalizedGrammar().getLongestMatchProds().get(s)) {
                    if(p.rightHand().size() < 0)
                        continue;
                    int pos = p.rightHand().size() - 3; // second to last symbol
                    Symbol spos = p.rightHand().get(pos);
                    if(pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(spos).contains(p.leftHand())) {

                        IProduction nullableListProd = null;
                        IProduction nonNullableListProd = null;

                        // FIXME only works with current normalization method
                        for(IProduction list_p : symbolProductionsMapping.get(s)) {
                            if(list_p.rightHand().size() == 1) {
                                nonNullableListProd = list_p;
                            } else {
                                nullableListProd = list_p;
                            }
                        }
                        if(nullableListProd != null && nonNullableListProd != null) {
                            // add priority A.C = α A S* <rhs(A.C)> > S* = S+
                            priorities.put(new Priority(p, nonNullableListProd, false), p.rightHand().size() - 1);

                            // create A.C = α A{C} S+
                            List<Symbol> new_rhs = Lists.newArrayList();
                            for(int i = 0; i < p.rightHand().size() - 1; i++) {
                                new_rhs.add(p.rightHand().get(i));
                            }
                            new_rhs.add(iterList);
                            Production newProd = new Production(p.leftHand(), new_rhs, p.leftRecursivePosition(),
                                p.rightRecursivePosition());
                            // adding new production
                            UniqueProduction uniqueProd = new UniqueProduction(p.leftHand(), new_rhs);
                            uniqueProductionMapping.put(uniqueProd, newProd);
                            productionAttributesMapping.putAll(newProd, productionAttributesMapping.get(p));
                            symbolProductionsMapping.put(p.leftHand(), newProd);
                            productionLabels.put(newProd, pt.getProdLabelFactory().getNextLabel());

                            int labelNewProd = productionLabels.get(newProd);
                            if(!isContextMappingStable && !rightmostContextsMapping.containsKey(labelNewProd)) {
                                rightmostContextsMapping.put(labelNewProd, rightmostContextsMapping.size());
                            }
                            Context new_context = deepContextFrom(labelNewProd, ContextPosition.RIGHTMOST, false);
                            contexts.add(new_context);

                            newProductions.put(newProd, p);


                        }
                    }

                }
                
                // add new contextual productions A.C = α A{C} S+
                for(IProduction newProd : newProductions.keySet()) {
                    int pos = newProductions.get(newProd).rightHand().size() - 3; // second to last symbol
                    if(!prodContextualProdMapping.containsKey(newProd)) {
                        ContextualProduction ctx_p2 = new ContextualProduction(newProd, contexts, Sets.newHashSet(pos),
                            productionLabels.get(newProd));
                        contexts = Collections.unmodifiableSet(contexts);
                        prodContextualProdMapping.put(newProd, ctx_p2);
                    } else {
                        // add new context to correct arguments of existing contextual production
                        ContextualProduction existing_prod = prodContextualProdMapping.get(newProductions.get(newProd));
                        prodContextualProdMapping.replace(newProd,
                            existing_prod.addContexts(contexts, Sets.newHashSet(pos)));
                    }
                }


            } else if(list instanceof IterStarSepSymbol) {
                iterList = new ContextFreeSymbol(new IterSepSymbol(((IterStarSepSymbol) list).getSymbol(),
                    ((IterStarSepSymbol) list).getSeparator()));
            }
        }
        if(s instanceof LexicalSymbol) {
            // check whether s is a * list
            Symbol list = ((LexicalSymbol) s).getSymbol();
            if(list instanceof IterStarSymbol) {
                iterList = new LexicalSymbol(new IterSymbol(((IterStarSymbol) list).getSymbol()));
            } else if(list instanceof IterStarSepSymbol) {
                iterList = new LexicalSymbol(new IterSepSymbol(((IterStarSepSymbol) list).getSymbol(),
                    ((IterStarSepSymbol) list).getSeparator()));
            }
        }

        // change production A+ -> A+ A to A+ -> A+<ctx> A
        for(IProduction p : symbolProductionsMapping.get(iterList)) {
            if(p.rightHand().size() > 1) {
                ContextualProduction ctx_p =
                    new ContextualProduction(p, contexts, Sets.newHashSet(0), productionLabels.get(p));
                // if contextual production does not exist add it
                if(!prodContextualProdMapping.containsKey(p)) {
                    prodContextualProdMapping.put(p, ctx_p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = prodContextualProdMapping.get(p);
                    prodContextualProdMapping.replace(p, existing_prod.addContexts(contexts, Sets.newHashSet(0)));
                }
            }
        }


    }

}
