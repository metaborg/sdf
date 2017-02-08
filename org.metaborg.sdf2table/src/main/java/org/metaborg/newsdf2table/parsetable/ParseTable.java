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
import org.metaborg.newsdf2table.grammar.Symbol;
import org.metaborg.newsdf2table.io.GrammarReader;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.TermFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
    List<State> states = Lists.newArrayList();
    Map<Set<LRItem>, State> kernel_states = Maps.newHashMap();
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
        printStatistics("Import: ", importTime);

        // calculate deep priority conflicts based on current priorities
        // and generate contextual productions
        _start_time = System.currentTimeMillis();
        deepConflictsAnalysis();
        _end_time = System.currentTimeMillis();
        
        
        long deepPrioritiesTime = _end_time - _start_time;
        printStatistics("Deep Priorities: ", deepPrioritiesTime);

        // TODO Currently generating an LR(0) table, compute first/follow/nullable sets to generate SLR(1)
        // calculate nullable symbols
        // calculateNullable();

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
        printStatistics("Generation: ", generationTime);

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
        printStatistics("Export: ", exportTime);


        printStatistics("Total: ", importTime + generationTime + exportTime);

    }

    private void deepConflictsAnalysis() {
        for(IPriority prio : grammar.priorities().keySet()) {
            Set<Integer> conflicting_args = prio.higher().isDeepPriorityConflict(this, prio.lower());
            if(!conflicting_args.isEmpty()) {
                Set<IProduction> contexts = Sets.newHashSet();
                contexts.add(prio.lower());
                // create contextual production
                ContextualProduction p =
                    new ContextualProduction(prio.higher(), contexts, conflicting_args, prio.higher().isBracket(this));
                
                // if contextual production does not exist add it
                if(!grammar.contextual_prods.containsKey(prio.higher())) {
                    grammar.contextual_prods.put(prio.higher(), p);
                } else {
                    // add new contextual production adding contexts to correct arguments
                    ContextualProduction existing_prod = grammar.contextual_prods.get(prio.higher());
                    existing_prod.addContext(prio.lower(), conflicting_args);
                }
            }
        }
    }

    private void calculateNullable() {
        boolean markedNullable = false;
        do {
            markedNullable = false;
            for(IProduction p : getGrammar().prods) {
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

    private void calculateFirstFollow() {
        for(IProduction p : getGrammar().prods) {
            p.calculateDependencies(getGrammar());
        }

        tarjanStack = new Stack<>();
        first_components = Sets.newHashSet();
        for(IProduction p : getGrammar().prods) {
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

    private void processStateQueue() {
        while(!stateQueue.isEmpty()) {
            State state = stateQueue.poll();
            processState(state);
        }
    }

    private void processState(State state) {
        state.processed = true;

        state.doShift();
        states.add(state);
        state.doReduces();
    }

    private BiMap<IProduction, Integer> createLabels(Set<IProduction> prods,
        Map<IProduction, ContextualProduction> contextual_prods, int label) {
        BiMap<IProduction, Integer> labels = HashBiMap.create();
        Set<ContextualProduction> new_contextual_prods = Sets.newHashSet();
        
        for(ContextualProduction p : grammar.contextual_prods.values()) {
            for(Symbol s : p.rhs) {
                if(s instanceof ContextualSymbol) {
                    grammar.contextual_symbols.add((ContextualSymbol) s);
                }
            }
        }

        for(ContextualSymbol ctx_s : grammar.contextual_symbols) {
            for(IProduction p : grammar.symbol_prods.get(ctx_s.s)) {
                if(!ctx_s.context.contains(p)) {
                    ContextualProduction new_prod = new ContextualProduction(p, ctx_s.context, Sets.newHashSet(-1), p.isBracket(this));
                    new_contextual_prods
                        .add(new_prod);
                    grammar.symbol_prods.put(ctx_s, new_prod);
                }
            }
        }

        label = label + prods.size() + new_contextual_prods.size() - 1;

        for(IProduction p : prods) {
            if(contextual_prods.containsKey(p)) {
                labels.put(contextual_prods.get(p), label);
            } else {
                labels.put(p, label);
            }
            label--;
        }

        for(ContextualProduction p : new_contextual_prods) {
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

    private long printStatistics(String step, long totalTime) {
        String millis = String.valueOf(totalTime % 1000);
        while(millis.length() < 3)
            millis = "0" + millis;
        System.out.println(step + String.valueOf(totalTime / 1000) + "." + millis + "s");
        return totalTime;
    }

    public static ITermFactory getTermfactory() {
        return termFactory;
    }
}
