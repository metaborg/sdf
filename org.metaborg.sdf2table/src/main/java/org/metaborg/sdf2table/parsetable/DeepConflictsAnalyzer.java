package org.metaborg.sdf2table.parsetable;

import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.ContextFreeSymbol;
import org.metaborg.sdf2table.grammar.IPriority;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.IterSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSymbol;
import org.metaborg.sdf2table.grammar.IterSymbol;
import org.metaborg.sdf2table.grammar.LexicalSymbol;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.grammar.UniqueProduction;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class DeepConflictsAnalyzer {

    public static void deepConflictAnalysis(ParseTable pt) {
        deepConflictAnalysis(pt, true, true, true);
    }

    public static void deepConflictAnalysis(ParseTable pt, boolean operatorStyle, boolean danglingElse,
        boolean longestMatch) {
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
                    pt.normalizedGrammar().priorities().containsEntry(prio, higher.rightHand().size() - 1)) { // the priority is
                                                                                               // E.In left E.Pos
                    handleInfixPostFixConflict(pt, prio, higher, lower);
                }
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


            // regular priority indirect recursion conflict
            handleIndirectRecursionConflict(pt, prio, higher);

        }

        if(longestMatch) {
            // longest-match conflicts
            for(Symbol s : pt.normalizedGrammar().getLongestMatchProds().keySet()) {
                handleLongestMatchConflict(pt, s);
            }
        }
    }

    private static boolean mutuallyRecursive(ParseTable pt, IPriority p) {
        return pt.normalizedGrammar().getLeftRecursiveSymbolsMapping().get(p.higher().leftHand()).contains(p.lower().leftHand())
            || pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(p.higher().leftHand()).contains(p.lower().leftHand());
    }
    
    private static void handleInfixPrefixConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
        // check whether the priorities that remove the conflict exist
        IPriority inverse = new Priority(lower, higher, false);
        // checking E.Pre left E.In
        if(pt.normalizedGrammar().priorities().get(inverse).contains(lower.rightRecursivePosition())) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.leftRecursivePosition();

        Set<Context> contexts = Sets.newHashSet();
        Context new_context = new Context(prio.lower(), ContextType.DEEP, ContextPosition.RIGHTMOST);
        contexts.add(new_context);

        Set<Integer> conflicting_args = Sets.newHashSet();
        conflicting_args.add(conflict_pos);

        // create production E = E<lower> in E
        ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

        // if contextual production does not exist add it
        if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prio.higher())) {
            pt.normalizedGrammar().getProdContextualProdMapping().put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(prio.higher());
            pt.normalizedGrammar().getProdContextualProdMapping().replace(prio.higher(), existing_prod.addContext(new_context, conflicting_args));
        }
    }

    private static void handleInfixPostFixConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
        // check whether the priorities that remove the conflict exist
        IPriority inverse = new Priority(lower, higher, false);
        // checking E.Pos right E.In
        if(pt.normalizedGrammar().priorities().get(inverse).contains(0)) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.rightRecursivePosition();

        Set<Context> contexts = Sets.newHashSet();
        Context new_context = new Context(prio.lower(), ContextType.DEEP, ContextPosition.LEFTMOST);
        contexts.add(new_context);

        Set<Integer> conflicting_args = Sets.newHashSet();
        conflicting_args.add(conflict_pos);

        // create production E = E in E<lower>
        ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

        // if contextual production does not exist add it
        if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prio.higher())) {
            pt.normalizedGrammar().getProdContextualProdMapping().put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(prio.higher());
            pt.normalizedGrammar().getProdContextualProdMapping().replace(prio.higher(), existing_prod.addContext(new_context, conflicting_args));
        }
    }

    private static void handleDanglingElseConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
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
                Context new_context = new Context(prio.lower(), ContextType.DEEP, ContextPosition.RIGHTMOST);
                contexts.add(new_context);

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(conflict);

                // create production E = pre E<lower> in E
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prio.higher())) {
                    pt.normalizedGrammar().getProdContextualProdMapping().put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(prio.higher());
                    pt.normalizedGrammar().getProdContextualProdMapping().replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                    // existing_prod.addContext(new_context, conflicting_args);
                }
            }
        }
    }

    private static void handleMirroredDanglingElseConflict(ParseTable pt, IPriority prio, IProduction higher, IProduction lower) {
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
                Context new_context = new Context(prio.lower(), ContextType.DEEP, ContextPosition.LEFTMOST);
                contexts.add(new_context);

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(conflict);

                // create production E = E in E<lower> pos
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prio.higher())) {
                    pt.normalizedGrammar().getProdContextualProdMapping().put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(prio.higher());
                    pt.normalizedGrammar().getProdContextualProdMapping().replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                }
            }
        }
    }

    private static void handleIndirectRecursionConflict(ParseTable pt, IPriority prio, IProduction higher) {
        for(Integer arg : pt.normalizedGrammar().priorities().get(prio)) {
            if(arg < 0 || arg >= higher.rightHand().size())
                continue;

            // the priority refers to a left recursive conflict
            if(arg == higher.leftRecursivePosition()
                // higher production is left recursive
                && pt.normalizedGrammar().getLeftRecursiveSymbolsMapping().get(higher.leftHand()).contains(higher.rightHand().get(arg))
                // is and indirect conflict
                && !higher.rightHand().get(arg).equals(prio.lower().leftHand())) {

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(arg);

                Set<Context> contexts = Sets.newHashSet();
                Context new_context = new Context(prio.lower(), ContextType.SHALLOW, ContextPosition.LEFTMOST);
                contexts.add(new_context);

                // create production E = A<lower> beta
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prio.higher())) {
                    pt.normalizedGrammar().getProdContextualProdMapping().put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(prio.higher());
                    pt.normalizedGrammar().getProdContextualProdMapping().replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                }
            }
            // the priority refers to a right recursive conflict
            if(arg == higher.rightRecursivePosition()
                // the the production is right recursive
                && pt.normalizedGrammar().getRightRecursiveSymbolsMapping().get(higher.leftHand()).contains(higher.rightHand().get(arg))
                // is an indirect conflict
                && !higher.rightHand().get(arg).equals(prio.lower().leftHand())) {

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(arg);

                Set<Context> contexts = Sets.newHashSet();
                Context new_context = new Context(prio.lower(), ContextType.SHALLOW, ContextPosition.RIGHTMOST);
                contexts.add(new_context);

                // create production E = alpha B<lower>
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prio.higher())) {
                    pt.normalizedGrammar().getProdContextualProdMapping().put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(prio.higher());
                    pt.normalizedGrammar().getProdContextualProdMapping().replace(prio.higher(),
                        existing_prod.addContext(new_context, conflicting_args));
                }
            }
        }
    }

    private static void handleLongestMatchConflict(ParseTable pt, Symbol s) {
        Set<Context> contexts = Sets.newHashSet();
        for(IProduction p : pt.normalizedGrammar().getLongestMatchProds().get(s)) {
            Context new_context = new Context(p, ContextType.DEEP, ContextPosition.RIGHTMOST);
            contexts.add(new_context);
        }

        Symbol iterList = s;

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
                        for(IProduction list_p : pt.normalizedGrammar().getSymbolProductionsMapping().get(s)) {
                            if(list_p.rightHand().size() == 1) {
                                nonNullableListProd = list_p;
                            } else {
                                nullableListProd = list_p;
                            }
                        }
                        if(nullableListProd != null && nonNullableListProd != null) {
                            // add A.C = α A S*{S* = S+}
                            if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(p)) {
                                // FIXME Might need to recalculate recursive pos
                                ContextualProduction ctx_p = new ContextualProduction(p, Sets.newHashSet(
                                    new Context(nonNullableListProd, ContextType.SHALLOW, ContextPosition.RIGHTMOST)),
                                    Sets.newHashSet(p.rightHand().size() - 1));
                                pt.normalizedGrammar().getProdContextualProdMapping().put(p, ctx_p);
                            } else {
                                // add new context to correct arguments of existing contextual production
                                ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(p);
                                pt.normalizedGrammar().getProdContextualProdMapping()
                                    .replace(p,
                                        existing_prod.addContexts(
                                            Sets.newHashSet(new Context(nonNullableListProd, ContextType.SHALLOW,
                                                ContextPosition.RIGHTMOST)),
                                            Sets.newHashSet(p.rightHand().size() - 1)));
                            }

                            // add A.C = α A{C} S+
                            List<Symbol> new_rhs = Lists.newArrayList();
                            for(int i = 0; i < p.rightHand().size() - 1; i++) {
                                new_rhs.add(p.rightHand().get(i));
                            }
                            new_rhs.add(iterList);
                            Production newProd = new Production(p.leftHand(), new_rhs, p.leftRecursivePosition(),
                                p.rightRecursivePosition());
                            UniqueProduction uniqueProd = new UniqueProduction(p.leftHand(), new_rhs);
                            pt.normalizedGrammar().getUniqueProductionMapping().put(uniqueProd, newProd);
                            pt.normalizedGrammar().getProductionAttributesMapping().putAll(newProd, pt.normalizedGrammar().getProductionAttributesMapping().get(p));
                            pt.normalizedGrammar().getSymbolProductionsMapping().put(p.leftHand(), newProd);
                            contexts.add(new Context(newProd, ContextType.DEEP, ContextPosition.RIGHTMOST));

                            if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(newProd)) {
                                ContextualProduction ctx_p2 =
                                    new ContextualProduction(newProd, contexts, Sets.newHashSet(pos));
                                pt.normalizedGrammar().getProdContextualProdMapping().put(newProd, ctx_p2);
                            } else {
                                // add new context to correct arguments of existing contextual production
                                ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(p);
                                pt.normalizedGrammar().getProdContextualProdMapping().replace(newProd,
                                    existing_prod.addContexts(contexts, Sets.newHashSet(pos)));
                            }
                        }
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
        for(IProduction p : pt.normalizedGrammar().getSymbolProductionsMapping().get(iterList)) {
            if(p.rightHand().size() > 1) {
                ContextualProduction ctx_p = new ContextualProduction(p, contexts, Sets.newHashSet(0));
                // if contextual production does not exist add it
                if(!pt.normalizedGrammar().getProdContextualProdMapping().containsKey(p)) {
                    pt.normalizedGrammar().getProdContextualProdMapping().put(p, ctx_p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = pt.normalizedGrammar().getProdContextualProdMapping().get(p);
                    pt.normalizedGrammar().getProdContextualProdMapping().replace(p, existing_prod.addContexts(contexts, Sets.newHashSet(0)));
                }
            }
        }


    }

}
