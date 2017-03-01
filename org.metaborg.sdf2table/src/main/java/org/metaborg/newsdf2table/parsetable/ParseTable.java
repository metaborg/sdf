package org.metaborg.newsdf2table.parsetable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.metaborg.newsdf2table.grammar.CharacterClass;
import org.metaborg.newsdf2table.grammar.IPriority;
import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.NormGrammar;
import org.metaborg.newsdf2table.grammar.Priority;
import org.metaborg.newsdf2table.grammar.Symbol;
import org.metaborg.newsdf2table.grammar.UniqueProduction;
import org.metaborg.newsdf2table.io.Benchmark;
import org.metaborg.newsdf2table.io.GrammarReader;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.TermFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;

public class ParseTable {

    private NormGrammar grammar;
    final int version_number = 6;
    final int initialState_number = 0;

    BiMap<IProduction, Integer> prod_labels;
    IProduction initial_prod;

    // Tarjan's index
    int index = 0;
    Stack<TableSet> tarjanStack;
    Set<Set<TableSet>> first_components;
    Set<Set<TableSet>> follow_components;

    Queue<State> stateQueue = Lists.newLinkedList();
    Set<State> processedStates = Sets.newHashSet();
    List<State> states = Lists.newArrayList();

    Map<Set<LRItem>, State> kernel_states = Maps.newHashMap();
    Map<LRItem, Set<LRItem>> item_derivedItems = Maps.newHashMap();

    int totalStates = 0;

    File input;
    File output;
    List<String> paths;
    boolean generateParenthesize;
    private final static ITermFactory termFactory = new TermFactory();

    public ParseTable(File input, File output, List<String> paths, boolean parenthesize) {
        this.input = input;
        this.output = output;
        this.paths = paths;
        this.generateParenthesize = parenthesize;
    }

    public void createTable() throws Exception {
        long _start_time;
        long _end_time;

        _start_time = System.currentTimeMillis();
        setGrammar(GrammarReader.readGrammar(input, output, paths));
        _end_time = System.currentTimeMillis();

        long importTime = _end_time - _start_time;
        Benchmark.printStatistics("Import: ", importTime);

        // calculate nullable symbols
        _start_time = System.currentTimeMillis();
        calculateNullable();
        _end_time = System.currentTimeMillis();

        long nullableTime = _end_time - _start_time;
        Benchmark.printStatistics("Nullable: ", nullableTime);

        // calculate left and right recursive productions (considering nullable symbols)
        _start_time = System.currentTimeMillis();
        calculateRecursion();
        _end_time = System.currentTimeMillis();

        long recursionTime = _end_time - _start_time;
        Benchmark.printStatistics("Recursion: ", recursionTime);

        // normalize priorities according to recursion
        _start_time = System.currentTimeMillis();
        normalizePriorities();
        _end_time = System.currentTimeMillis();

        long normPriorities = _end_time - _start_time;
        Benchmark.printStatistics("Normalizing Priorities: ", normPriorities);


        // calculate deep priority conflicts based on current priorities
        // and generate contextual productions
        _start_time = System.currentTimeMillis();
        deepConflictsAnalysis();
        _end_time = System.currentTimeMillis();

        long deepPrioritiesTime = _end_time - _start_time;
        Benchmark.printStatistics("Deep Priorities: ", deepPrioritiesTime);

        // TODO Currently generating an LR(0) table, compute first/follow sets to generate SLR(1)
        // create first/follow sets by calculating dependencies and using Tarjan's algorithm
        // see http://compilers.iecc.com/comparch/article/01-04-079
        // calculateFirstFollow();

        // create states
        _start_time = System.currentTimeMillis();
        prod_labels = createLabels(getGrammar().prods, getGrammar().contextual_prods, 257);
        initial_prod = getGrammar().initial_prod;
        State s0 = new State(initial_prod, this);
        stateQueue.add(s0);
        processStateQueue();
        Collections.sort(states);
        _end_time = System.currentTimeMillis();

        long generationTime = _end_time - _start_time;
        Benchmark.printStatistics("Generation: ", generationTime);

        // output table
        _start_time = System.currentTimeMillis();
        IStrategoTerm result = generateATerm();
        if(output != null) {
            FileWriter out = null;
            try {
                out = new FileWriter(output);
                out.write(result.toString());
                out.close();
            } catch(IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println(result.toString());
        }
        _end_time = System.currentTimeMillis();

        long exportTime = _end_time - _start_time;
        Benchmark.printStatistics("Export: ", exportTime);


        Benchmark.printStatistics("Total: ", importTime + nullableTime + recursionTime + generationTime + exportTime);

    }

    private void calculateNullable() {
        boolean markedNullable = false;
        do {
            markedNullable = false;
            for(IProduction p : getGrammar().prods.values()) {
                if(p.rightHand().isEmpty() && !p.leftHand().nullable) {
                    p.leftHand().nullable = true;
                    markedNullable = true;
                } else {
                    boolean nullable = true;
                    for(Symbol s : p.rightHand()) {
                        if(s.nullable == false) {
                            nullable = false;
                            break;
                        }
                    }
                    if(nullable == true && !p.leftHand().nullable) {
                        p.leftHand().nullable = nullable;
                        markedNullable = true;
                    }
                }
            }

        } while(markedNullable);
    }

    private void calculateRecursion() {
        // direct and indirect left recursion :
        // depth first search, whenever finding a cycle, those symbols are left recursive with respect to each other
        List<Symbol> seen = Lists.newArrayList();
        List<IProduction> prodsVisited = Lists.newArrayList();
        for(IProduction p : getGrammar().prods.values()) {
            seen.clear();
            leftRecursive(p, seen, prodsVisited);
        }

        // similar idea with right recursion
        prodsVisited.clear();
        for(IProduction p : getGrammar().prods.values()) {
            seen.clear();
            rightRecursive(p, seen, prodsVisited);
        }

        for(IProduction p : getGrammar().prods.values()) {
            p.calculateRecursion(getGrammar());
        }
    }

    private void leftRecursive(IProduction prod, List<Symbol> seen, List<IProduction> prodsVisited) {

        if(prodsVisited.contains(prod)) {
            return;
        } else {
            prodsVisited.add(prod);
        }

        List<Symbol> just_seen = Lists.newArrayList(seen);

        // mark left hand symbol as visited
        just_seen.add(prod.leftHand());

        // call left recursive with all productions of
        // the leftmost symbols of rhs (considering nullables)
        for(Symbol s : prod.rightHand()) {
            if(just_seen.contains(s)) {
                // found a cycle
                Set<Symbol> cycle = Sets.newHashSet();
                int pos = just_seen.size() - 1;
                while(pos != just_seen.indexOf(s)) {
                    cycle.add(just_seen.get(pos));
                    pos--;
                }
                cycle.add(just_seen.get(pos));
                // add all symbols in the cycle to the recursive symbols of themselves
                for(Symbol symbol : cycle) {
                    grammar.leftRecursive.putAll(symbol, cycle);
                }
            } else {
                for(IProduction p : grammar.symbol_prods.get(s)) {
                    leftRecursive(p, just_seen, prodsVisited);
                }
            }
            if(!s.nullable) {
                break;
            }
        }


    }

    private void rightRecursive(IProduction prod, List<Symbol> seen, List<IProduction> prodsVisited) {

        if(prodsVisited.contains(prod)) {
            return;
        } else {
            prodsVisited.add(prod);
        }

        List<Symbol> just_seen = Lists.newArrayList(seen);

        // mark left hand symbol as visited
        just_seen.add(prod.leftHand());

        // call right recursive with all productions of
        // the rightmost symbols of rhs (considering nullables)
        for(int i = prod.rightHand().size() - 1; i >= 0; i--) {
            Symbol s = prod.rightHand().get(i);
            if(just_seen.contains(s)) {
                // found a cycle
                Set<Symbol> cycle = Sets.newHashSet();
                int pos = just_seen.size() - 1;
                while(pos != just_seen.indexOf(s)) {
                    cycle.add(just_seen.get(pos));
                    pos--;
                }
                cycle.add(just_seen.get(pos));
                // add all symbols in the cycle to the recursive symbols of themselves
                for(Symbol symbol : cycle) {
                    grammar.rightRecursive.putAll(symbol, cycle);
                }
            } else {
                for(IProduction p : grammar.symbol_prods.get(s)) {
                    rightRecursive(p, just_seen, prodsVisited);
                }
            }
            if(!s.nullable) {
                break;
            }
        }


    }

    private void normalizePriorities() {
        for(IPriority p : grammar.priorities().keySet()) {
            if(grammar.priorities().get(p).contains(-1)) {
                // mutually recursive priorities = operator precedence
                if(p.higher().leftHand().equals(p.lower().leftHand())) {
                    // p1 > p2 becomes p1 left p2 and p1 right p2
                    Set<Integer> new_values = Sets.newHashSet();

                    // if p2 : A = A w, priority should affect only right recursive position of p1
                    if(p.lower().leftRecursivePosition() != -1 && p.lower().rightRecursivePosition() == -1) {
                        new_values.add(p.higher().rightRecursivePosition());
                    }

                    // p2 : A = w A, priority should affect only left recursive position of p1
                    if(p.lower().rightRecursivePosition() != -1 && p.lower().leftRecursivePosition() == -1) {
                        new_values.add(p.higher().leftRecursivePosition());
                    }

                    // p2 : A = A w A, priority should affect left and right recursive positions of p1
                    if(p.lower().rightRecursivePosition() != -1 && p.lower().leftRecursivePosition() != -1) {
                        new_values.add(p.higher().rightRecursivePosition());
                        new_values.add(p.higher().leftRecursivePosition());
                    }

                    // if p2 : A = B or p2 : A =
                    if(p.lower().rightHand().size() == 1 || p.lower().rightHand().size() == 0) {
                        new_values.add(p.higher().rightRecursivePosition());
                        new_values.add(p.higher().leftRecursivePosition());
                    }

                    // if p2 : A = w1 A w2, priority should have no effect

                    new_values.addAll(grammar.priorities().get(p));
                    grammar.priorities().replaceValues(p, new_values);
                } else {
                    // tree filtering : non (mutually) recursive productions
                    Set<Integer> new_values = Sets.newHashSet();
                    for(int i = 0; i < p.higher().rightHand().size(); i++) {
                        if(p.higher().rightHand().get(i).equals(p.lower().leftHand())) {
                            new_values.add(i);
                        }
                    }

                    new_values.addAll(grammar.priorities().get(p));
                    grammar.priorities().replaceValues(p, new_values);
                }
            }
        }
    }

    private void calculateFirstFollow() {
        for(IProduction p : getGrammar().prods.values()) {
            p.calculateDependencies(getGrammar());
        }

        tarjanStack = new Stack<>();
        first_components = Sets.newHashSet();
        for(IProduction p : getGrammar().prods.values()) {
            if(p.firstSet().index == -1) {
                stronglyConnectedTarjan(p.firstSet(), first_components);
            }
        }
    }

    private void stronglyConnectedTarjan(TableSet v, Set<Set<TableSet>> components) {
        // Set the depth index for v to the smallest unused index
        v.index = index;
        v.low_link = index;
        index++;
        tarjanStack.push(v);
        v.onStack = true;

        for(TableSet d : v.depends_on) {
            if(d.index == -1) {
                // Successor w has not yet been visited; recurse on it
                stronglyConnectedTarjan(d, components);
                v.add(d.value);
                d.low_link = Math.min(v.low_link, d.low_link);
            } else if(d.onStack) {
                // Successor w is in stack S and hence in the current SCC
                v.low_link = Math.min(v.low_link, d.index);
            }
        }

        TableSet t;
        // If v is a root node, pop the stack and generate an SCC
        if(v.low_link == v.index) {
            Set<TableSet> component = Sets.newHashSet();
            do {
                t = tarjanStack.pop();
                t.onStack = false;
                t.add(v.value);
                component.add(t);
            } while(t != v);
            components.add(component);
        }
    }

    private void deepConflictsAnalysis() {
        for(IPriority prio : grammar.priorities().keySet()) {
            IProduction higher = prio.higher();
            IProduction lower = prio.lower();

            // infix-prefix conflict
            if(higher.leftRecursivePosition() != -1 && higher.rightRecursivePosition() != -1 && // higher is infix
                lower.leftRecursivePosition() == -1 && lower.rightRecursivePosition() != -1 && // lower is prefix
                higher.leftHand().equals(lower.leftHand()) && // the productions are mutually recursive
                grammar.priorities().containsEntry(prio, 0)) { // the priority is E.In right E.Pre

                handleInfixPrefixConflict(prio, higher, lower);
            } // infix-postfix conflict
            else if(higher.leftRecursivePosition() != -1 && higher.rightRecursivePosition() != -1 && // higher is infix
                lower.leftRecursivePosition() != -1 && lower.rightRecursivePosition() == -1 && // lower is postfix
                higher.leftHand().equals(lower.leftHand()) && // the productions are mutually recursive
                grammar.priorities().containsEntry(prio, higher.rightHand().size() - 1)) { // the priority is
                                                                                           // E.In left E.Pos
                handleInfixPostFixConflict(prio, higher, lower);
            } // dangling else conflict
            else if(higher.leftRecursivePosition() == -1 && higher.rightRecursivePosition() != -1 && // higher has
                                                                                                     // prefix
                lower.leftRecursivePosition() == -1 && lower.rightRecursivePosition() != -1) { // lower is prefix)
                handleDanglingElseConflict(prio, higher, lower);

            } // mirrored dangling else conflict
            else if(higher.leftRecursivePosition() != -1 && higher.rightRecursivePosition() == -1 && // higher has
                                                                                                     // postfix
                lower.leftRecursivePosition() != -1 && lower.rightRecursivePosition() == -1) { // lower is postfix)
                handleMirroredDanglingElseConflict(prio, higher, lower);
            } // regular priority indirect recursion conflict
            else {
                // handleIndirectRecursionConflict(prio, higher);
            }

        }

    }

    private void handleInfixPrefixConflict(IPriority prio, IProduction higher, IProduction lower) {
        // check whether the priorities that remove the conflict exist
        IPriority inverse = new Priority(lower, higher, false);
        // checking E.Pre left E.In
        if(grammar.priorities().get(inverse).contains(lower.rightRecursivePosition())) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.leftRecursivePosition();

        Set<IProduction> contexts = Sets.newHashSet();
        contexts.add(prio.lower());

        Set<Integer> conflicting_args = Sets.newHashSet();
        conflicting_args.add(conflict_pos);

        // create production E = E<lower> in E
        ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

        // if contextual production does not exist add it
        if(!grammar.contextual_prods.containsKey(prio.higher())) {
            grammar.contextual_prods.put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
            existing_prod.addContext(prio.lower(), conflicting_args);
        }
    }

    private void handleInfixPostFixConflict(IPriority prio, IProduction higher, IProduction lower) {
        // check whether the priorities that remove the conflict exist
        IPriority inverse = new Priority(lower, higher, false);
        // checking E.Pos right E.In
        if(grammar.priorities().get(inverse).contains(0)) {
            return;
        }

        // conflicting position
        int conflict_pos = higher.rightRecursivePosition();

        Set<IProduction> contexts = Sets.newHashSet();
        contexts.add(prio.lower());

        Set<Integer> conflicting_args = Sets.newHashSet();
        conflicting_args.add(conflict_pos);

        // create production E = E in E<lower>
        ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

        // if contextual production does not exist add it
        if(!grammar.contextual_prods.containsKey(prio.higher())) {
            grammar.contextual_prods.put(prio.higher(), p);
        } else {
            // add new context to correct arguments of existing contextual production
            ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
            existing_prod.addContext(prio.lower(), conflicting_args);
        }
    }

    private void handleDanglingElseConflict(IPriority prio, IProduction higher, IProduction lower) {
        boolean matchPrefix = false;

        for(int conflict : grammar.priorities().get(prio)) {
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
                Set<IProduction> contexts = Sets.newHashSet();
                contexts.add(prio.lower());

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(conflict);

                // create production E = pre E<lower> in E
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!grammar.contextual_prods.containsKey(prio.higher())) {
                    grammar.contextual_prods.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
                    existing_prod.addContext(prio.lower(), conflicting_args);
                }
            }
        }
    }

    private void handleMirroredDanglingElseConflict(IPriority prio, IProduction higher, IProduction lower) {
        boolean matchPrefix = false;

        for(int conflict : grammar.priorities().get(prio)) {

            if(lower.rightHand().size() < (higher.rightHand().size() - conflict))
                continue;

            for(int i = 0; i < higher.rightHand().size() - conflict; i++) {
                if(higher.rightHand().get(higher.rightHand().size() - 1 - i) // check backwards
                    .equals(lower.rightHand().get(lower.rightHand().size() - 1 - i))) {
                    matchPrefix = true;
                } else {
                    matchPrefix = false;
                    break;
                }
            }
            if(matchPrefix && !higher.equals(lower)) {
                Set<IProduction> contexts = Sets.newHashSet();
                contexts.add(prio.lower());

                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(conflict);

                // create production E = E in E<lower> pos
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!grammar.contextual_prods.containsKey(prio.higher())) {
                    grammar.contextual_prods.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
                    existing_prod.addContext(prio.lower(), conflicting_args);
                }
            }
        }
    }

    private void handleIndirectRecursionConflict(IPriority prio, IProduction higher) {
        for(Integer arg : grammar.priorities().get(prio)) {
            if(arg < 0 || arg >= higher.rightHand().size())
                continue;
            if(arg == higher.leftRecursivePosition()
                && grammar.leftRecursive.get(higher.leftHand()).contains(higher.rightHand().get(arg))) {
                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(arg);

                Set<IProduction> contexts = Sets.newHashSet();
                contexts.add(prio.lower());

                // create production E = A<lower> beta
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!grammar.contextual_prods.containsKey(prio.higher())) {
                    grammar.contextual_prods.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
                    existing_prod.addContext(prio.lower(), conflicting_args);
                }
            }
            if(arg == higher.rightRecursivePosition()
                && grammar.rightRecursive.get(higher.leftHand()).contains(higher.rightHand().get(arg))) {
                Set<Integer> conflicting_args = Sets.newHashSet();
                conflicting_args.add(arg);

                Set<IProduction> contexts = Sets.newHashSet();
                contexts.add(prio.lower());

                // create production E = alpha B<lower>
                ContextualProduction p = new ContextualProduction(prio.higher(), contexts, conflicting_args);

                // if contextual production does not exist add it
                if(!grammar.contextual_prods.containsKey(prio.higher())) {
                    grammar.contextual_prods.put(prio.higher(), p);
                } else {
                    // add new context to correct arguments of existing contextual production
                    ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
                    existing_prod.addContext(prio.lower(), conflicting_args);
                }
            }
        }
    }

    private void processStateQueue() {
        while(!stateQueue.isEmpty()) {
            State state = stateQueue.poll();
            if(!processedStates.contains(state)) {
                processState(state);
            }
        }
    }

    private void processState(State state) {
        processedStates.add(state);

        state.doShift();
        states.add(state);
        state.doReduces();
    }

    private BiMap<IProduction, Integer> createLabels(Map<UniqueProduction, IProduction> prods,
        Map<IProduction, ContextualProduction> contextual_prods, int label) {
        BiMap<IProduction, Integer> labels = HashBiMap.create();


        for(ContextualProduction p : grammar.contextual_prods.values()) {
            for(Symbol s : p.rhs) {
                if(s instanceof ContextualSymbol) {
                    grammar.contextual_symbols.add((ContextualSymbol) s);
                }
            }
        }

        Queue<ContextualSymbol> contextual_symbols = Queues.newArrayDeque(grammar.contextual_symbols);
        Set<ContextualSymbol> processed_symbols = Sets.newHashSet();

        while(!contextual_symbols.isEmpty()) {
            ContextualSymbol ctx_s = contextual_symbols.poll();
            if(processed_symbols.contains(ctx_s))
                continue;
            processed_symbols.add(ctx_s);

            for(IProduction p : grammar.symbol_prods.get(ctx_s.s)) {

                if(ctx_s.context.contains(p))
                    continue;

                ContextualProduction ctx_p = null;
                if(grammar.contextual_prods.get(p) != null) {
                    ctx_p = grammar.contextual_prods.get(p);
                }

                if(ctx_p != null) {
                    ContextualProduction new_prod =
                        ctx_p.mergeContext(ctx_s.context, contextual_symbols, processed_symbols);
                    grammar.derived_contextual_prods.add(new_prod);
                    grammar.symbol_prods.put(ctx_s, new_prod);
                } else if(!ctx_s.context.contains(p)) {
                    ContextualProduction new_prod =
                        new ContextualProduction(p, ctx_s.context, contextual_symbols, processed_symbols);
                    grammar.derived_contextual_prods.add(new_prod);
                    grammar.symbol_prods.put(ctx_s, new_prod);
                }
            }


        }

        label = label + prods.size() + grammar.derived_contextual_prods.size() - 1;

        for(IProduction p : prods.values()) {
            if(contextual_prods.containsKey(p)) {
                labels.put(contextual_prods.get(p), label);
            } else {
                labels.put(p, label);
            }
            label--;
        }

        for(ContextualProduction p : grammar.derived_contextual_prods) {
            labels.put(p, label);
            label--;
        }

        return labels;
    }

    private IStrategoTerm generateATerm() throws Exception {

        IStrategoTerm version = termFactory.makeInt(version_number);
        IStrategoTerm initialState = termFactory.makeInt(initialState_number);


        IStrategoTerm labels = generateLabelsAterm();
        IStrategoTerm priorities = generatePrioritiesAterm();
        IStrategoTerm states = generateStatesAterm();



        return termFactory.makeAppl(termFactory.makeConstructor("parse-table", 5), version, initialState, labels,
            states, priorities);
    }

    private IStrategoTerm generateStatesAterm() {
        List<IStrategoTerm> terms = Lists.newArrayList();
        for(State s : states) {
            List<IStrategoTerm> goto_terms = Lists.newArrayList();
            List<IStrategoTerm> action_terms = Lists.newArrayList();
            for(GoTo goto_action : s.gotos) {
                goto_terms.add(goto_action.toAterm(termFactory));
            }
            for(CharacterClass cc : s.lr_actions.keySet()) {
                List<IStrategoTerm> actions = Lists.newArrayList();
                for(Action a : s.lr_actions.get(cc)) {
                    actions.add(a.toAterm(termFactory, this));
                }
                action_terms.add(termFactory.makeAppl(termFactory.makeConstructor("action", 2),
                    cc.toStateAterm(termFactory), termFactory.makeList(actions)));
                // action_terms.add(action.toAterm(termFactory, this));
            }
            terms.add(termFactory.makeAppl(termFactory.makeConstructor("state-rec", 3), termFactory.makeInt(s.label),
                termFactory.makeList(goto_terms), termFactory.makeList(action_terms)));
        }

        return termFactory.makeAppl(termFactory.makeConstructor("states", 1), termFactory.makeList(terms));
    }

    private IStrategoTerm generatePrioritiesAterm() throws Exception {
        List<IStrategoTerm> terms = Lists.newArrayList();
        for(java.util.Map.Entry<IPriority, Integer> e : getGrammar().priorities().entries()) {
            IProduction prod_higher = e.getKey().higher();
            IProduction prod_lower = e.getKey().lower();
            // because non-contextual production got replaced
            if(grammar.contextual_prods.containsKey(prod_higher)) {
                prod_higher = grammar.contextual_prods.get(e.getKey().higher());
            }
            if(grammar.contextual_prods.containsKey(prod_lower)) {
                prod_lower = grammar.contextual_prods.get(e.getKey().lower());
            }
            Integer label_higher = prod_labels.get(prod_higher);
            Integer label_lower = prod_labels.get(prod_lower);
            if(label_higher == null || label_lower == null) {
                throw new Exception("Production label not found.");
            }
            if(e.getValue() == -1) {
                IStrategoTerm prio_term = termFactory.makeAppl(termFactory.makeConstructor("gtr-prio", 2),
                    termFactory.makeInt(label_higher), termFactory.makeInt(label_lower));
                terms.add(prio_term);
            } else {

                IStrategoTerm prio_term = termFactory.makeAppl(termFactory.makeConstructor("arg-gtr-prio", 3),
                    termFactory.makeInt(label_higher), termFactory.makeInt(e.getValue()),
                    termFactory.makeInt(label_lower));
                terms.add(prio_term);
            }
        }

        return termFactory.makeAppl(termFactory.makeConstructor("priorities", 1), termFactory.makeList(terms));

    }

    private IStrategoTerm generateLabelsAterm() {
        List<IStrategoTerm> terms = Lists.newArrayList();

        for(int i = 257 + prod_labels.size() - 1; i >= 257; i--) {
            IProduction p = prod_labels.inverse().get(i);

            IStrategoTerm p_term = termFactory.makeAppl(termFactory.makeConstructor("label", 2),
                p.toAterm(termFactory, getGrammar().prod_attrs), termFactory.makeInt(i));
            terms.add(p_term);
        }

        return termFactory.makeList(terms);
    }

    public NormGrammar getGrammar() {
        return grammar;
    }

    public void setGrammar(NormGrammar grammar) {
        this.grammar = grammar;
    }



    public static ITermFactory getTermfactory() {
        return termFactory;
    }
}
