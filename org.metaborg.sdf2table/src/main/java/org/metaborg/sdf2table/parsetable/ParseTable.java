package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.metaborg.parsetable.IParseTable;
import org.metaborg.parsetable.states.IState;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.metaborg.sdf2table.deepconflicts.ContextPosition;
import org.metaborg.sdf2table.deepconflicts.ContextType;
import org.metaborg.sdf2table.deepconflicts.ContextualProduction;
import org.metaborg.sdf2table.deepconflicts.ContextualSymbol;
import org.metaborg.sdf2table.deepconflicts.DeepConflictsAnalyzer;
import org.metaborg.sdf2table.grammar.ContextFreeSymbol;
import org.metaborg.sdf2table.grammar.GeneralAttribute;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.sdf2table.grammar.IterSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSymbol;
import org.metaborg.sdf2table.grammar.IterSymbol;
import org.metaborg.sdf2table.grammar.Layout;
import org.metaborg.sdf2table.grammar.LexicalSymbol;
import org.metaborg.sdf2table.grammar.NormGrammar;
import org.metaborg.sdf2table.grammar.OptionalSymbol;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Sort;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.util.CheckOverlap;
import org.metaborg.sdf2table.util.Graph;
import org.metaborg.sdf2table.util.SCCNodes;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class ParseTable implements IParseTable, Serializable {

    // FIXME Currently generating an LR(0) table, compute first/follow sets to generate SLR(1)
    // create first/follow sets by calculating dependencies and using Tarjan's algorithm
    // see http://compilers.iecc.com/comparch/article/01-04-079

    private static final long serialVersionUID = -1845408435423897026L;

    private static final ILogger logger = LoggerUtils.logger(ParseTable.class);

    public static final int FIRST_PRODUCTION_LABEL = 257;
    public static final int INITIAL_STATE_NUMBER = 0;
    public static final int VERSION_NUMBER = 6;

    private NormGrammar grammar;

    private final int initialStateNumber = 0;
    private int processedStates = 0;
    private int totalStates = 0;
    private IProduction initialProduction;

    private BiMap<IProduction, Integer> productionLabels;
    private LabelFactory prodLabelFactory = new LabelFactory(ParseTable.FIRST_PRODUCTION_LABEL);
    private Queue<State> stateQueue = Lists.newLinkedList();
    private Map<Integer, State> stateLabels = Maps.newLinkedHashMap();
    
    private final Set<IProduction> danglingSuffix = Sets.newHashSet();
    private final Set<IProduction> danglingPrefix = Sets.newHashSet();

    // mapping from a symbol X to all items A = α . X β to all states s that have that item
    private SymbolStatesMapping symbolStatesMapping = new SymbolStatesMapping();

    private Map<Set<LRItem>, State> kernelStatesMapping = Maps.newLinkedHashMap();
    private Map<LRItem, Set<LRItem>> itemDerivedItemsCache = Maps.newLinkedHashMap();

    private List<org.metaborg.parsetable.productions.IProduction> productions = Lists.newArrayList();
    Map<IProduction, ParseTableProduction> productionsMapping = Maps.newLinkedHashMap();

    // fields to implement declarative disambiguation using contextual grammars
    // deep priority conflict resolution is left to parse time
    private final ParseTableConfiguration config;

    // maps a set of contexts to a unique integer
    private Map<Set<Context>, Integer> ctxUniqueInt = Maps.newHashMap();
    private final Map<Integer, Integer> leftmostContextsMapping = Maps.newLinkedHashMap();
    private final Map<Integer, Integer> rightmostContextsMapping = Maps.newLinkedHashMap();

    public ParseTable(NormGrammar grammar, ParseTableConfiguration config) {
        this.grammar = grammar;
        this.config = config;
        SCCNodes<ISymbol> scc = null;
        
        if(config.isCheckOverlap()) {
            // calculate strongly connected components to indentify mutually recursive symbols
            scc = new SCCNodes<ISymbol>(createGraphFromProductions());
            scc.calculateSCCNodes();
        }

        // calculate nullable symbols
        calculateNullable();

        // calculate left and right recursive productions (considering nullable symbols)
        calculateRecursion();
        
     // extract expression grammars
        extractExpressionGrammars(scc);

        // normalize priorities according to recursion
        normalizePriorities();

        // create labels for productions
        createLabels();


        // verify possible ambiguities due to missing priorities
        if(config.isCheckPriorities()) {
            checkMissingPriorities();
        }

        if(config.isCheckOverlap()) {
            // calculate harmful overlap
            checkHarmfulOverlap(scc);
        }

        // calculate deep priority conflicts based on current priorities
        // and generate contextual productions
        if(config.isSolveDeepConflicts()) {
            final DeepConflictsAnalyzer analysis = DeepConflictsAnalyzer.fromParseTable(this);
            analysis.patchParseTable();
            updateLabelsContextualProductions();
        }

        // create JSGLR parse table productions
        createJSGLRParseTableProductions(productionLabels);

        // create states if the table should not be generated dynamically
        initialProduction = grammar.getInitialProduction();

        if(!config.isDynamic()) {
            State s0 = new State(initialProduction, this);
            stateQueue.add(s0);
            processStateQueue();
        }

    }

    private void calculateNullable() {
        boolean markedNullable = false;
        do {
            markedNullable = false;

            for(Production p : grammar.getUniqueProductionMapping().values()) {
                if(grammar.getProductionAttributesMapping().get(p).contains(new GeneralAttribute("recover"))
                    || grammar.getProductionAttributesMapping().get(p)
                        .contains(new GeneralAttribute("placeholder-insertion"))
                    || grammar.getProductionAttributesMapping().get(p)
                        .contains(new GeneralAttribute("literal-completion")))
                    continue;
                {
                }
                if(p.rightHand().isEmpty() && !p.leftHand().isNullable()) {
                    p.leftHand().setNullable(true);
                    markedNullable = true;
                } else {
                    boolean nullable = true;
                    for(ISymbol s : p.rightHand()) {
                        if(((Symbol) s).isNullable() == false) {
                            nullable = false;
                            break;
                        }
                    }
                    if(nullable == true && !p.leftHand().isNullable()) {
                        p.leftHand().setNullable(nullable);
                        markedNullable = true;
                    }
                }
            }

        } while(markedNullable);
    }

    private void calculateRecursion() {
        // direct and indirect left recursion :
        // depth first search, whenever finding a cycle, those symbols are left recursive with respect to each other

        List<IProduction> prodsVisited = Lists.newArrayList();
        for(Production p : grammar.getUniqueProductionMapping().values()) {
            leftRecursive(p, Lists.newArrayList(), Lists.newArrayList());
        }

        // similar idea with right recursion
        prodsVisited.clear();
        for(Production p : grammar.getUniqueProductionMapping().values()) {
            rightRecursive(p, Lists.newArrayList(), Lists.newArrayList());
        }

        for(Production p : grammar.getUniqueProductionMapping().values()) {
            p.calculateRecursion(grammar);
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
        just_seen.add((Symbol) prod.leftHand());

        // call left recursive with all productions of
        // the leftmost symbols of rhs (considering nullables)
        for(ISymbol s : prod.rightHand()) {
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
                    grammar.getLeftRecursiveSymbolsMapping().putAll(symbol, cycle);
                }
            } else {
                for(IProduction p : grammar.getSymbolProductionsMapping().get((Symbol) s)) {
                    // recursion is only calculated for regular productions
                    leftRecursive(p, just_seen, prodsVisited);


                }
            }
            if(!s.isNullable()) {
                break;
            }
        }

    }

    private void rightRecursive(IProduction prod, List<ISymbol> seen, List<IProduction> prodsVisited) {

        if(prodsVisited.contains(prod)) {
            return;
        } else {
            prodsVisited.add(prod);
        }

        List<ISymbol> just_seen = Lists.newArrayList(seen);

        // mark left hand symbol as visited
        just_seen.add(prod.leftHand());

        // call right recursive with all productions of
        // the rightmost symbols of rhs (considering nullables)
        for(int i = prod.rightHand().size() - 1; i >= 0; i--) {
            ISymbol s = prod.rightHand().get(i);
            if(just_seen.contains(s)) {
                // found a cycle
                Set<ISymbol> cycle = Sets.newHashSet();
                int pos = just_seen.size() - 1;
                while(pos != just_seen.indexOf(s)) {
                    cycle.add(just_seen.get(pos));
                    pos--;
                }
                cycle.add(just_seen.get(pos));
                // add all symbols in the cycle to the recursive symbols of themselves
                for(ISymbol symbol : cycle) {
                    grammar.getRightRecursiveSymbolsMapping().putAll(symbol, cycle);
                }
            } else {
                for(IProduction p : grammar.getSymbolProductionsMapping().get(s)) {
                    rightRecursive(p, just_seen, prodsVisited);
                }
            }
            if(!s.isNullable()) {
                break;
            }
        }
    }

    private void normalizePriorities() {

        normalizeAssociativePriorities();

        for(Priority p : grammar.priorities().keySet()) {
            if(grammar.priorities().get(p).contains(-1)) {
                // mutually recursive priorities = operator precedence
                if(mutuallyRecursive(p)) {
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

                    // dangling suffix
                    // p1 : A = α A and p2 = α A γ or vice-versa
                    boolean matchPrefix = false;
                    int i, j;
                    for(i = 0, j = 0; i < p.higher().rightHand().size() && j < p.lower().rightHand().size(); i++, j++) {
                        if(p.higher().rightHand().get(i).equals(p.lower().rightHand().get(j))) {
                            matchPrefix = true;
                        } else {
                            matchPrefix = false;
                            break;
                        }
                    }
                    
                    if(matchPrefix && (p.higher().rightRecursivePosition() == i - 1
                        || p.lower().rightRecursivePosition() == j - 1)) {
                        new_values.add(i - 1);
                        danglingSuffix.add(p.higher());
                        danglingSuffix.add(p.lower());
                    }

                    // dangling prefix
                    // p1 : A = A γ and p = α A γ or vice-versa
                    boolean matchSuffix = false;
                    for(i = p.higher().rightHand().size() - 1, j = p.lower().rightHand().size() - 1; i >= 0
                        && j >= 0; i--, j--) {
                        if(p.higher().rightHand().get(i).equals(p.lower().rightHand().get(j))) {
                            matchSuffix = true;
                        } else {
                            matchSuffix = false;
                            break;
                        }
                    }

                    if(matchSuffix && (p.higher().leftRecursivePosition() == i + 1
                        || p.lower().leftRecursivePosition() == j + 1)) {
                        new_values.add(i + 1);
                        danglingPrefix.add(p.higher());
                        danglingPrefix.add(p.lower());
                    }

                    new_values.addAll(grammar.priorities().get(p));
                    grammar.priorities().replaceValues(p, new_values);
                }
            }
        }

        // to calculate the parenthesizer
        for(Priority p : grammar.priorities().keySet()) {
            grammar.getHigherPriorityProductions().put(p.higher(), p);
        }

    }

    private void normalizeAssociativePriorities() {

        // priorities derived from associativity of indirectly recursive productions
        SetMultimap<Priority, Integer> new_priorities = HashMultimap.create();

        for(Priority p : grammar.priorities().keySet()) {
            // right associative
            if(grammar.priorities().get(p).contains(Integer.MIN_VALUE)) {
                if(p.higher().leftRecursivePosition() == -1)
                    continue;

                // p right p and indirect recursion on p
                Symbol leftRecursive = p.higher().getRhs().get(p.higher().leftRecursivePosition());
                if(p.higher().equals(p.lower()) && !leftRecursive.equals(p.higher().leftHand())) {
                    for(IProduction prod : grammar.getSymbolProductionsMapping().get(leftRecursive)) {
                        // if prod : A = w A, add new priority because it consists of a deep conflict
                        if(((Production) prod).leftRecursivePosition() == -1
                            && ((Production) prod).rightRecursivePosition() != -1) {
                            new_priorities.put(new Priority(p.higher(), (Production) prod, false),
                                p.higher().leftRecursivePosition());
                        }
                    }
                }

                if(p.higher().leftRecursivePosition() != -1) {
                    grammar.priorities().put(p, p.higher().leftRecursivePosition());
                }
            }
            // left associative
            if(grammar.priorities().get(p).contains(Integer.MAX_VALUE)) {
                // if production is not both right and left recursive
                if(p.higher().rightRecursivePosition() == -1)
                    continue;

                // p left p and indirect recursion on p
                Symbol rightRecursive = p.higher().getRhs().get(p.higher().rightRecursivePosition());
                if(p.higher().equals(p.lower()) && !rightRecursive.equals(p.higher().leftHand())) {
                    for(IProduction prod : grammar.getSymbolProductionsMapping().get(rightRecursive)) {
                        // if prod : A = A w, add new priority because it consists of a deep conflict
                        if(((Production) prod).leftRecursivePosition() != -1
                            && ((Production) prod).rightRecursivePosition() == -1) {
                            new_priorities.put(new Priority(p.higher(), (Production) prod, false),
                                p.higher().rightRecursivePosition());
                        }
                    }
                }

                if(p.higher().rightRecursivePosition() != -1) {
                    grammar.priorities().put(p, p.higher().rightRecursivePosition());
                }
            }
        }

        grammar.priorities().putAll(new_priorities);
    }

    private boolean mutuallyRecursive(Priority p) {
        return grammar.getLeftRecursiveSymbolsMapping().get(p.higher().getLhs()).contains(p.lower().leftHand())
            || grammar.getRightRecursiveSymbolsMapping().get(p.higher().getLhs()).contains(p.lower().leftHand());
    }

    /*
     * TODO calculate first and follow sets private void calculateFirstFollow() { for(IProduction p :
     * getGrammar().prods.values()) { p.calculateDependencies(getGrammar()); }
     * 
     * tarjanStack = new Stack<>(); first_components = Sets.newHashSet(); for(IProduction p :
     * getGrammar().prods.values()) { if(p.firstSet().index == -1) { stronglyConnectedTarjan(p.firstSet(),
     * first_components); } } }
     * 
     * 
     * private void stronglyConnectedTarjan(TableSet v, Set<Set<TableSet>> components) { // Set the depth index for v to
     * the smallest unused index v.index = index; v.low_link = index; index++; tarjanStack.push(v); v.onStack = true;
     * 
     * for(TableSet d : v.depends_on) { if(d.index == -1) { // Successor w has not yet been visited; recurse on it
     * stronglyConnectedTarjan(d, components); v.add(d.value); d.low_link = Math.min(v.low_link, d.low_link); } else
     * if(d.onStack) { // Successor w is in stack S and hence in the current SCC v.low_link = Math.min(v.low_link,
     * d.index); } }
     * 
     * TableSet t; // If v is a root node, pop the stack and generate an SCC if(v.low_link == v.index) { Set<TableSet>
     * component = Sets.newHashSet(); do { t = tarjanStack.pop(); t.onStack = false; t.add(v.value); component.add(t); }
     * while(t != v); components.add(component); } }
     */

    private void extractExpressionGrammars(SCCNodes<ISymbol> scc) {

        for(ISymbol s : grammar.getSymbols()) {

            if(isListSymbol(s) || isLayoutSymbol(s)) {
                continue;
            }

            // if p is (indirectly) recursive then p in Exp(s)
            for(IProduction p : grammar.getSymbolProductionsMapping().get(s)) {
                for(ISymbol rhs_symb : p.rightHand()) {
                    if(rhs_symb.equals(s)) {
                        grammar.getExpressionGrammars().put(s, p);
                    } else if(scc.getNodesMapping().get(s) != null && scc.getNodesMapping().get(s).contains(rhs_symb)) {
                        grammar.getExpressionGrammars().put(s, p);
                    }
                }
            }
        }

        // if s is mutually recursive with s2, then combine Exp(s,s2) = Exp(s) ++ Exp(s2)
        for(ISymbol nonTerminalExpGrammar : grammar.getExpressionGrammars().keys()) {

            Set<ISymbol> symbs = Sets.newHashSet(nonTerminalExpGrammar);
            if(scc.getNodesMapping().get(nonTerminalExpGrammar) != null) {
                symbs.addAll(scc.getNodesMapping().get(nonTerminalExpGrammar));
            }

            Set<IProduction> combinedGrammars = Sets.newHashSet();
            for(ISymbol recursive : symbs) {
                combinedGrammars.addAll(grammar.getExpressionGrammars().get(recursive));
            }
            grammar.getCombinedExpressionGrammars().add(combinedGrammars);

        }
    }

    private Graph<ISymbol> createGraphFromProductions() {

        Graph<ISymbol> result = new Graph<ISymbol>(grammar.getSymbols());
        for(ISymbol s : grammar.getSymbols()) {
            for(IProduction p : grammar.getSymbolProductionsMapping().get(s)) {
                for(ISymbol rhs_symb : p.rightHand()) {
                    result.addEdge(s, rhs_symb);
                }
            }
        }

        return result;
    }

    private boolean isLayoutSymbol(ISymbol s) {
        boolean isLayout = false;
        if(s instanceof ContextFreeSymbol) {
            s = ((ContextFreeSymbol) s).getSymbol();
        }
        if(s instanceof OptionalSymbol) {
            s = ((OptionalSymbol) s).getSymbol();
        }
        if(s instanceof LexicalSymbol) {
            s = ((LexicalSymbol) s).getSymbol();
        }
        if(s instanceof Layout) {
            isLayout = true;
        }
        return isLayout;
    }

    private boolean isListSymbol(ISymbol s) {
        if(s instanceof OptionalSymbol) {
            s = ((OptionalSymbol) s).getSymbol();
        }
        if(s instanceof ContextFreeSymbol) {
            s = ((ContextFreeSymbol) s).getSymbol();
        }
        if(s instanceof LexicalSymbol) {
            s = ((LexicalSymbol) s).getSymbol();
        }

        return (s instanceof IterSymbol) || (s instanceof IterStarSymbol) || (s instanceof IterStarSepSymbol)
            || (s instanceof IterSepSymbol);
    }

    private void createLabels() {
        BiMap<IProduction, Integer> labels = HashBiMap.create();

        for(IProduction p : grammar.getUniqueProductionMapping().values()) {
            labels.put(p, prodLabelFactory.getNextLabel());
        }

        productionLabels = labels;
    }

    private void checkMissingPriorities() {
        SetMultimap<ISymbol, Production> leftRecursive = HashMultimap.create();
        SetMultimap<ISymbol, Production> rightRecursive = HashMultimap.create();
        Set<ISymbol> recursiveSymbols = Sets.newHashSet();

        // operator-style ambiguities due to lack of priorities
        for(Production p : grammar.getUniqueProductionMapping().values()) {
            if(p.leftRecursivePosition() != -1) {
                leftRecursive.put(p.leftHand(), p);
                recursiveSymbols.add(p.leftHand());
            }
            if(p.rightRecursivePosition() != -1) {
                rightRecursive.put(p.leftHand(), p);
                recursiveSymbols.add(p.leftHand());
            }
        }

        SetMultimap<IProduction, IProduction> conflicts = HashMultimap.create();

        for(ISymbol s : recursiveSymbols) {
            for(Production p1 : leftRecursive.get(s)) {
                for(Production p2 : rightRecursive.get(s)) {
                    if(p1.equals(p2)) {
                        // if p1,p2: A+ -> A+ A, ambiguity might be longest-match
                        if(Symbol.isListNonTerminal(p1.leftHand())) {
                            continue;
                        }

                        // if p1 == p2 and there is no associativity declaration
                        if(grammar.priorities().containsKey(new Priority(p1, p2, false))
                            || grammar.priorities().containsKey(new Priority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No associativity declaration for production "
                                + printWithConstructor(p1));
                        }
                    } else {
                        // if p1: A+ -> A+ A and p2: A+ -> A, ambiguity might be longest-match
                        if(Symbol.isListNonTerminal(p1.leftHand()) || Symbol.isListNonTerminal(p2.leftHand())
                            || p2.rightHand().size() == 1 || p1.rightHand().size() == 1) {
                            continue;
                        }

                        // if p1 != p2 and there is no priority declaration between p1 and p2
                        if(grammar.priorities().containsKey(new Priority(p1, p2, false))
                            || grammar.priorities().containsKey(new Priority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration between productions "
                                + printWithConstructor(p1) + " and " + printWithConstructor(p2));
                        }
                    }
                }
            }
        }


        for(ISymbol s : recursiveSymbols) {
            for(Production p1 : leftRecursive.get(s)) {
                for(Production p2 : leftRecursive.get(s)) {
                    if(p1 != p2 && matchSuffix(p1, p2)) {
                        // if p1 != p2, p1 and p2 have matching prefixes, and
                        // there is no priority declaration between p1 and p2

                        if(grammar.priorities().containsKey(new Priority(p1, p2, false))
                            || grammar.priorities().containsKey(new Priority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration between productions "
                                + printWithConstructor(p1) + " and " + printWithConstructor(p2));
                        }
                    }
                }

            }

            for(Production p1 : rightRecursive.get(s)) {
                if(isNonAnnotatedLongestMatchList(p1)) {
                    logger.warn(
                        "GRAMMAR MAY CONTAIN AMBIGUITIES: No longest match or shortest match annotation on production "
                            + printWithConstructor(p1));
                }



                for(Production p2 : rightRecursive.get(s)) {
                    if(p1 != p2 && matchPrefix(p1, p2)) {
                        // if p1 != p2, p1 and p2 have matching suffixes, and
                        // there is no priority declaration between p1 and p2

                        if(grammar.priorities().containsKey(new Priority(p1, p2, false))
                            || grammar.priorities().containsKey(new Priority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration between productions "
                                + printWithConstructor(p1) + " and " + printWithConstructor(p2));
                        }
                    }
                }
            }
        }



    }


    private void checkHarmfulOverlap(SCCNodes<ISymbol> scc) {
        // for each expression grammar check productions with any overlap at all
        for(Set<IProduction> expProds : grammar.getCombinedExpressionGrammars()) {
            Set<IProduction> emptyOperatorOverlappingProds = Sets.newHashSet();

            Set<ISymbol> literals = Sets.newHashSet();

            // collect literals to check for overlap
            for(IProduction p : expProds) {
                boolean emptyOperatorOverlap = false;

                for(ISymbol s : p.rightHand()) {
                    if(s instanceof Sort && ((Sort) s).getType() != null) {
                        literals.add(s);
                    }
                    // if there are two consecutive recursive non-terminals the production
                    // has overlap using the empty string
                    if(s.equals(p.leftHand()) || (scc.getNodesMapping().get(p.leftHand()) != null
                        && scc.getNodesMapping().get(p.leftHand()).contains(s))) {
                        if(emptyOperatorOverlap) {
                            emptyOperatorOverlappingProds.add(p);
                        } else {
                            emptyOperatorOverlap = true;
                        }
                    } else if(!s.isNullable()) {
                        emptyOperatorOverlap = false;
                    }
                }
            }

            // check expression productions with any overlap at all
            Set<ISymbol> literalsConsidered = Sets.newHashSet();

            for(ISymbol lit : literals) {
                boolean detectedHarmfulOverlap = false;

                if(literalsConsidered.contains(lit)) {
                    continue;
                } else {
                    literalsConsidered.add(lit);
                }


                // add productions that have any overlap
                Set<IProduction> overlappingProds = Sets.newHashSet(emptyOperatorOverlappingProds);

                if(grammar.getLiteralProductionsMapping().get(lit).size() > 1) {
                    // add all overlapping productions that are recursive
                    for(IProduction overlappingProd : grammar.getLiteralProductionsMapping().get(lit)) {
                        if(expProds.contains(overlappingProd)) {
                            overlappingProds.add(overlappingProd);
                        }
                    }

                    Queue<ISymbol> otherLits = Queues.newArrayDeque();

                    for(IProduction p : overlappingProds) {
                        for(ISymbol symb_rhs : p.rightHand()) {
                            if(symb_rhs instanceof Sort && ((Sort) symb_rhs).getType() != null
                                && !literalsConsidered.contains(symb_rhs)) {
                                otherLits.add(symb_rhs);
                            }
                        }
                    }

                    while(!otherLits.isEmpty()) {
                        ISymbol otherLit = otherLits.remove();

                        if(literalsConsidered.contains(otherLit)) {
                            continue;
                        } else {
                            literalsConsidered.add(otherLit);
                        }

                        for(IProduction p : grammar.getLiteralProductionsMapping().get(otherLit)) {
                            if(expProds.contains(p)) {
                                overlappingProds.add(p);
                                for(ISymbol symb_rhs : p.rightHand()) {
                                    if(symb_rhs instanceof Sort && ((Sort) symb_rhs).getType() != null
                                        && !literalsConsidered.contains(symb_rhs)) {
                                        otherLits.add(symb_rhs);
                                    }
                                }
                            }
                        }
                    }
                }

                // check if overlap is harmful
                // FIXME do not consider subsets (currently limit checking subsets to 5 overlapping productions)
                if(overlappingProds.size() > 1) {
                    // explore all subsets P and Q with |P| > 0 or |Q| > 0 and P not equal Q
                    List<Set<IProduction>> subsets = powerSet(overlappingProds);

                    for(int i = 0; i < subsets.size(); i++) {
                        Set<IProduction> P = subsets.get(i);
                        for(int j = i; j < subsets.size(); j++) {
                            Set<IProduction> Q = subsets.get(j);
                            Set<IProduction> intersection = Sets.newHashSet(P);
                            intersection.retainAll(Q);
                            if(P.equals(Q) || intersection.equals(P) || intersection.equals(Q)
                                || !containsSameOperators(P, Q)) {
                                continue;
                            } else {
                                // check if there is w such that w in L(P) and w in L(Q) with different trees
                                CheckOverlap checkOverlap = new CheckOverlap(P, Q, 5, scc);
                                String sentence = checkOverlap.checkHarmfulOverlap();

                                if(sentence != null) {
                                    String prods = "";
                                    for(IProduction p : overlappingProds) {
                                        prods += printWithConstructor(p) + " ";
                                    }

                                    detectedHarmfulOverlap = true;

                                    logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: Harmful overlap with the sentence "
                                        + sentence + " between the productions: " + prods);

                                    break;
                                }
                            }
                        }
                        if(detectedHarmfulOverlap) {
                            break;
                        }

                    }
                }

                if(detectedHarmfulOverlap) {
                    continue;
                }

            }
        }


    }

    private boolean containsSameOperators(Set<IProduction> p, Set<IProduction> q) {
        Set<ISymbol> operatorsP = Sets.newHashSet();
        Set<ISymbol> operatorsQ = Sets.newHashSet();

        for(IProduction prods : p) {
            for(ISymbol symb_rhs : prods.rightHand()) {
                if(symb_rhs instanceof Sort && ((Sort) symb_rhs).getType() != null) {
                    operatorsP.add(symb_rhs);
                }
            }
        }

        for(IProduction prods : q) {
            for(ISymbol symb_rhs : prods.rightHand()) {
                if(symb_rhs instanceof Sort && ((Sort) symb_rhs).getType() != null) {
                    operatorsQ.add(symb_rhs);
                }
            }
        }

        return operatorsP.equals(operatorsQ);
    }

    private List<Set<IProduction>> powerSet(Set<IProduction> set) {
        IProduction[] element = new IProduction[set.size()];
        set.toArray(element);
        final int SET_LENGTH = 1 << element.length;
        List<Set<IProduction>> powerSet = Lists.newArrayList();
        for(int binarySet = 0; binarySet < SET_LENGTH; binarySet++) {
            Set<IProduction> subset = Sets.newHashSet();
            for(int bit = 0; bit < element.length; bit++) {
                int mask = 1 << bit;
                if((binarySet & mask) != 0) {
                    subset.add(element[bit]);
                }
            }
            if(subset.size() > 0) {
                powerSet.add(subset);
            }
        }
        return powerSet;
    }


    private boolean isNonAnnotatedLongestMatchList(IProduction p) {
        if(!Symbol.isListNonTerminal(p.leftHand())) {
            ISymbol lastSymbol = p.rightHand().get(p.rightHand().size() - 1);
            if(Symbol.isListNonTerminal(lastSymbol)) {
                Set<IAttribute> attrs = grammar.getProductionAttributesMapping().get(p);
                for(IAttribute attr : attrs) {
                    if(attr instanceof GeneralAttribute && (((GeneralAttribute) attr).getName().equals("longest-match")
                        || ((GeneralAttribute) attr).getName().equals("shortest-match"))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean matchSuffix(IProduction p1, IProduction p2) {
        int index = -1;

        if(p1.rightHand().size() > p2.rightHand().size()) {
            index = Collections.indexOfSubList(p1.rightHand(), p2.rightHand());
            return index > 0 && index == p1.rightHand().size() - p2.rightHand().size();
        } else {
            index = Collections.indexOfSubList(p2.rightHand(), p1.rightHand());
            return index > 0 && index == p2.rightHand().size() - p1.rightHand().size();
        }

    }

    private boolean matchPrefix(IProduction p1, IProduction p2) {
        int index = Collections.indexOfSubList(p1.rightHand(), p2.rightHand());
        return index == 0;
    }

    private String printWithConstructor(IProduction p) {
        ISymbol s = p.leftHand();
        String symbolName;

        if(s instanceof ContextFreeSymbol) {
            symbolName = ((ContextFreeSymbol) s).getSymbol().name();
        } else if(s instanceof LexicalSymbol) {
            symbolName = ((LexicalSymbol) s).getSymbol().name();
        } else {
            symbolName = s.name();
        }

        if(grammar.getConstructors().containsKey(p)) {
            return symbolName + "." + grammar.getConstructors().get(p).getConstructor();
        } else {
            return p.toString();
        }
    }

    private void updateLabelsContextualProductions() {
        BiMap<IProduction, Integer> labels = productionLabels;

        if(!getConfig().isDataDependent()) {
            deriveContextualProductions();

            for(IProduction p : grammar.getUniqueProductionMapping().values()) {
                if(grammar.getProdContextualProdMapping().containsKey(p)) {
                    labels.inverse().put(labels.get(p), grammar.getProdContextualProdMapping().get(p));
                }
            }

            for(ContextualProduction p : grammar.getDerivedContextualProds()) {
                labels.put(p, prodLabelFactory.getNextLabel());
            }
        } else {
            // the productions for the contextual symbol are the same as the ones for the original symbol
            for(ContextualProduction p : grammar.getProdContextualProdMapping().values()) {
                for(ISymbol s : p.rightHand()) {
                    if(s instanceof ContextualSymbol) {
                        grammar.getContextualSymbols().add((ContextualSymbol) s);
                        Set<IProduction> productions =
                            grammar.getSymbolProductionsMapping().get(((ContextualSymbol) s).getOrigSymbol());
                        grammar.getSymbolProductionsMapping().putAll(s, productions);
                    }
                }
            }

            for(IProduction p : grammar.getUniqueProductionMapping().values()) {
                if(grammar.getProdContextualProdMapping().containsKey(p)) {
                    labels.inverse().put(labels.get(p), grammar.getProdContextualProdMapping().get(p));
                }
            }
        }
    }

    private void createJSGLRParseTableProductions(BiMap<IProduction, Integer> labels) {
        for(int i = 0; i < labels.size(); i++) {
            IProduction p = labels.inverse().get(i + FIRST_PRODUCTION_LABEL);
            Production orig_p;
            if(p instanceof ContextualProduction) {
                orig_p = ((ContextualProduction) p).getOrigProduction();
            } else {
                orig_p = (Production) p;
            }

            ParseTableProduction prod = new ParseTableProduction(i + FIRST_PRODUCTION_LABEL, p,
                grammar.getProductionAttributesMapping().get(orig_p), leftmostContextsMapping,
                rightmostContextsMapping);
            productions.add(prod);
            productionsMapping.put(p, prod);
        }
    }

    private void deriveContextualProductions() {
        for(ContextualProduction p : grammar.getProdContextualProdMapping().values()) {
            for(ISymbol s : p.rightHand()) {
                if(s instanceof ContextualSymbol) {
                    grammar.getContextualSymbols().add((ContextualSymbol) s);
                }
            }
        }

        Queue<ContextualSymbol> contextual_symbols = Queues.newArrayDeque(grammar.getContextualSymbols());
        Set<ContextualSymbol> processed_symbols = Sets.newHashSet();

        while(!contextual_symbols.isEmpty()) {
            ContextualSymbol ctx_s = contextual_symbols.poll();
            if(processed_symbols.contains(ctx_s))
                continue;
            processed_symbols.add(ctx_s);
            if(!getCtxUniqueInt().containsKey(ctx_s.getContexts())) {
                getCtxUniqueInt().put(ctx_s.getContexts(), getCtxUniqueInt().size());
            }

            for(IProduction p : grammar.getSymbolProductionsMapping().get(ctx_s.getOrigSymbol())) {
                int labelP = productionLabels.get(p);

                // generate new productions for deep contexts
                Context deepLeft_ctx = new Context(labelP, ContextType.DEEP, ContextPosition.LEFTMOST, false,
                    leftmostContextsMapping, rightmostContextsMapping);
                Context deepRight_ctx = new Context(labelP, ContextType.DEEP, ContextPosition.RIGHTMOST, false,
                    leftmostContextsMapping, rightmostContextsMapping);
                if(ctx_s.getContexts().contains(deepLeft_ctx) || ctx_s.getContexts().contains(deepRight_ctx)) {
                    continue;
                }

                ContextualProduction ctx_p = null;
                if(grammar.getProdContextualProdMapping().get(p) != null) {
                    ctx_p = grammar.getProdContextualProdMapping().get(p);
                }

                if(ctx_p != null) {
                    ContextualProduction new_prod =
                        ctx_p.mergeContext(ctx_s.getContexts(), contextual_symbols, processed_symbols, this);
                    grammar.getDerivedContextualProds().add(new_prod);
                    grammar.getSymbolProductionsMapping().put(ctx_s, new_prod);
                } else if(!(ctx_s.getContexts().contains(deepLeft_ctx)
                    || ctx_s.getContexts().contains(deepRight_ctx))) {
                    ContextualProduction new_prod = new ContextualProduction((Production) p, ctx_s.getContexts(),
                        contextual_symbols, processed_symbols, productionLabels.get(p), this);
                    grammar.getDerivedContextualProds().add(new_prod);
                    grammar.getSymbolProductionsMapping().put(ctx_s, new_prod);
                }
            }
        }
    }

    private void processStateQueue() {
        while(!stateQueue.isEmpty()) {
            State state = stateQueue.poll();
            if(state.status() != StateStatus.PROCESSED) {
                processState(state);
            }
        }
    }

    private void processState(State state) {
        state.closure();
        state.doShift();
        state.doReduces();
        state.calculateActionsForCharacter();
        state.setStatus(StateStatus.PROCESSED);
    }

    public void setGrammar(NormGrammar grammar) {
        this.grammar = grammar;
    }

    public IState startState() {
        State s0;
        if(totalStates == 0) {
            s0 = new State(initialProduction(), this);
            s0.closure();
            s0.doShift();
            s0.doReduces();
            s0.calculateActionsForCharacter();
            s0.setStatus(StateStatus.PROCESSED);
            setProcessedStates(getProcessedStates() + 1);
        } else if(((State) stateLabels.get(0)).status() != StateStatus.PROCESSED) {
            s0 = (State) stateLabels.get(0);
            if(s0.status() == StateStatus.DIRTY) {
                // TODO: garbage collection of unreferenced states
                // uncheckOldReferences(s0.gotos());
                s0.gotos().clear();
            }
            s0.closure();
            s0.doShift();
            s0.doReduces();
            s0.calculateActionsForCharacter();
            s0.setStatus(StateStatus.PROCESSED);
        } else {
            return stateLabels.get(0);
        }
        return s0;
    }

    public IState getState(int index) {
        State s = (State) stateLabels.get(index);
        if(s.status() != StateStatus.PROCESSED) {
            if(s.status() == StateStatus.DIRTY) {
                // TODO: garbage collection of unreferenced states
                // uncheckOldReferences(s0.gotos());
                s.gotos().clear();
            }
            s.closure();
            s.doShift();
            s.doReduces();
            s.calculateActionsForCharacter();
            s.setStatus(StateStatus.PROCESSED);
            setProcessedStates(getProcessedStates() + 1);
        }
        return s;
    }

    public int totalStates() {
        return totalStates;
    }

    public int getProcessedStates() {
        return processedStates;
    }

    public void setProcessedStates(int processedStates) {
        this.processedStates = processedStates;
    }

    public void incTotalStates() {
        totalStates++;
    }

    public Map<Set<LRItem>, State> kernelMap() {
        return kernelStatesMapping;
    }

    public IProduction initialProduction() {
        return initialProduction;
    }

    public NormGrammar normalizedGrammar() {
        return grammar;
    }

    public BiMap<IProduction, Integer> productionLabels() {
        return productionLabels;
    }

    public LabelFactory getProdLabelFactory() {
        return prodLabelFactory;
    }

    public Map<LRItem, Set<LRItem>> cachedItems() {
        return itemDerivedItemsCache;
    }

    public Queue<State> stateQueue() {
        return stateQueue;
    }

    public Map<Integer, State> stateLabels() {
        return stateLabels;
    }

    public int getVersionNumber() {
        return VERSION_NUMBER;
    }

    public int getInitialStateNumber() {
        return initialStateNumber;
    }

    public Map<Set<Context>, Integer> getCtxUniqueInt() {
        return ctxUniqueInt;
    }

    public void setCtxUniqueInt(Map<Set<Context>, Integer> ctx_vals) {
        this.ctxUniqueInt = ctx_vals;
    }

    public SymbolStatesMapping getSymbolStatesMapping() {
        return symbolStatesMapping;
    }

    public void setSymbolStatesMapping(SymbolStatesMapping symbolStatesMapping) {
        this.symbolStatesMapping = symbolStatesMapping;
    }

    public List<org.metaborg.parsetable.productions.IProduction> productions() {
        return productions;
    }

    public Map<IProduction, ParseTableProduction> productionsMapping() {
        return productionsMapping;
    }

    public Map<Integer, Integer> getLeftmostContextsMapping() {
        return leftmostContextsMapping;
    }

    public Map<Integer, Integer> getRightmostContextsMapping() {
        return rightmostContextsMapping;
    }

    @Override public IState getStartState() {
        return startState();
    }

    public ParseTableConfiguration getConfig() {
        return config;
    }

    public Set<IProduction> getDanglingSuffix() {
        return danglingSuffix;
    }

    public Set<IProduction> getDanglingPrefix() {
        return danglingPrefix;
    }


}
