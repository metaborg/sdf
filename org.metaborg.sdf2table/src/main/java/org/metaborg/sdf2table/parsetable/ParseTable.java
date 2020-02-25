package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.*;

import org.metaborg.parsetable.IParseTable;
import org.metaborg.parsetable.states.IState;
import org.metaborg.parsetable.symbols.LiteralSymbol;
import org.metaborg.sdf2table.deepconflicts.*;
import org.metaborg.sdf2table.grammar.*;
import org.metaborg.sdf2table.util.CheckOverlap;
import org.metaborg.sdf2table.util.Graph;
import org.metaborg.sdf2table.util.SCCNodes;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;

import com.google.common.collect.*;

import static org.metaborg.parsetable.characterclasses.CharacterClassFactory.EOF_SINGLETON;

public class ParseTable implements IParseTable, Serializable {

    // FIXME Currently generating an LR(0) table, compute first/follow sets to generate SLR(1)
    // create first/follow sets by calculating dependencies and using Tarjan's algorithm
    // see http://compilers.iecc.com/comparch/article/01-04-079

    private static final long serialVersionUID = -1845408435423897026L;

    private static final ILogger logger = LoggerUtils.logger(ParseTable.class);

    public static final int FIRST_PRODUCTION_LABEL = 257;
    public static final int INITIAL_STATE_NUMBER = 0;
    public static final int VERSION_NUMBER = 7;

    private final NormGrammar grammar;
    private final ContextualFactory cf;

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
        this.cf = new ContextualFactory();
        this.config = config;
        SCCNodes<ISymbol> scc = null;

        if(config.isCheckOverlap()) {
            // calculate strongly connected components to indentify mutually recursive symbols
            scc = new SCCNodes<ISymbol>(createGraphFromProductions());
            scc.calculateSCCNodes();
            // extract expression grammars
            extractExpressionGrammars(scc);
        }

        // calculate nullable symbols
        calculateNullable();

        // calculate left and right recursive productions (considering nullable symbols)
        // and leftmost and rightmost derivations of symbols
        calculateRecursion();

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
            
            //TODO simplify contextual grammar
            
            
            updateLabelsContextualProductions();
        }
        

        // create JSGLR parse table productions
        createJSGLRParseTableProductions(productionLabels);

        // calculate FIRST-set and FOLLOW-set
        calculateFirst();
        calculateFollow();

        // create states if the table should not be generated dynamically
        initialProduction = grammar.getInitialProduction();

        if(!config.isDynamic()) {
            State s0 = new State(initialProduction, this);
            stateQueue.add(s0);
            processStateQueue();
            cleanupTable();
        }
        
        

    }

    private void cleanupTable() {
        this.danglingPrefix.clear();
        this.danglingSuffix.clear();
        this.symbolStatesMapping.itemStates.clear();
        this.symbolStatesMapping.symbolItems.clear();
        this.itemDerivedItemsCache.clear();
        this.kernelStatesMapping.clear();
        this.leftmostContextsMapping.clear();
        this.cachedItems().clear();
        this.productionsMapping.clear();
        this.rightmostContextsMapping.clear();
        this.grammar.cleanupGrammar();
        System.gc();
    }

    private void calculateNullable() {
        boolean markedNullable = false;
        do {
            markedNullable = false;

            for(Production p : grammar.getUniqueProductionMapping().values()) {
                if(grammar.getProductionAttributesMapping().get(p)
                    .contains(normalizedGrammar().getGrammarFactory().createGeneralAttribute("recover"))
                    || grammar.getProductionAttributesMapping().get(p).contains(
                        normalizedGrammar().getGrammarFactory().createGeneralAttribute("placeholder-insertion"))
                    || grammar.getProductionAttributesMapping().get(p)
                        .contains(normalizedGrammar().getGrammarFactory().createGeneralAttribute("literal-completion")))
                    continue;
                {
                }
                if(p.getRhs().isEmpty() && !p.leftHand().isNullable()) {
                    p.leftHand().setNullable(true);
                    markedNullable = true;
                } else {
                    boolean nullable = true;
                    for(ISymbol s : p.getRhs()) {
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

    // Based on https://compilers.iecc.com/comparch/article/01-04-079
    private void calculateFirst() {
        SetMultimap<ISymbol, IProduction> symbolProductionsMapping = grammar.getSymbolProductionsMapping();
        Set<ISymbol> symbols = grammar.getSymbols();
        SetMultimap<ISymbol, ISymbol> containsTheFirstOf = HashMultimap.create();

        for(ISymbol s : symbols) {
            // The FIRST set of a CharacterClass symbol is equal to the character class it represents.
            if(s instanceof CharacterClassSymbol) {
                s.setFirst(((CharacterClassSymbol) s).getCC());
                continue;
            }
            // The FIRST set of an EOFSymbol is equal to the EOF singleton character class.
            if(s instanceof EOFSymbol) {
                s.setFirst(EOF_SINGLETON);
                continue;
            }

            for(IProduction p : symbolProductionsMapping.get(s)) {
                // Direct contributions:
                // If p is of the shape A = A0 ... Ak a Am ... An where all symbols up to Ak are nullable
                for(ISymbol rhs : p.rightHand()) {
                    // Then, a is in FIRST(A).
                    if(rhs instanceof CharacterClassSymbol) {
                        s.setFirst(((CharacterClassSymbol) rhs).getCC());
                        break;
                    }

                    // Indirect contributions: calculate contains-the-FIRSTs-of
                    // If p is of the shape A = A0 ... Ak B Am ... An where all symbols up to Ak are nullable
                    // Then, A contains-the-FIRSTs-of B
                    containsTheFirstOf.put(s, rhs);

                    if(!rhs.isNullable())
                        break;
                }
            }
        }

        // Indirect contributions: Tarjan's algorithm for strongly connected components
        final int DONE = symbols.size();
        final Map<ISymbol, Integer> low = new HashMap<>();
        final Stack<ISymbol> stack = new Stack<>();
        for(ISymbol v : symbols) {
            if(low.get(v) == null /* CLEAN */)
                traverseFirst(v, containsTheFirstOf, DONE, low, stack);
        }
    }

    private void traverseFirst(ISymbol v, SetMultimap<ISymbol, ISymbol> containsTheFirstOf, int DONE,
        Map<ISymbol, Integer> low, Stack<ISymbol> stack) {
        stack.push(v);
        int top1 = stack.size() - 1;
        low.put(v, top1);
        for(ISymbol w : containsTheFirstOf.get(v)) {
            if(low.get(w) == null /* CLEAN */) {
                traverseFirst(w, containsTheFirstOf, DONE, low, stack);
            }
            // Change compared to the article at compilers.iecc.com: this line is moved outside of the previous if-block
            v.setFirst(v.getFirst().union(w.getFirst())); // union!
            if(low.get(w) < low.get(v))
                low.put(v, low.get(w));
        }
        if(low.get(v) == top1) // v is the root of this SCC
            while(stack.size() - 1 >= top1) {
                ISymbol w = stack.pop();
                w.setFirst(v.getFirst()); // distribute!
                low.put(w, DONE);
            }
    }

    // Based on https://compilers.iecc.com/comparch/article/01-04-079
    // and Modern Compiler Implementation in Java, Second Edition - Andrew Appel, 2004
    private void calculateFollow() {
        SetMultimap<ISymbol, IProduction> symbolProductionsMapping = grammar.getSymbolProductionsMapping();
        Set<ISymbol> symbols = grammar.getSymbols();
        SetMultimap<ISymbol, ISymbol> containsTheFirstOf = HashMultimap.create();
        SetMultimap<ISymbol, ISymbol> containsTheFollowOf = HashMultimap.create();

        for(ISymbol s : symbols) {
            for(IProduction p : symbolProductionsMapping.get(s)) {
                List<ISymbol> rightHand = p.rightHand();
                i: for(int i = 0, rightHandSize = rightHand.size(); i < rightHandSize; i++) {
                    ISymbol symbolI = rightHand.get(i);

                    // If p is of the shape A = A0 ... Ai Ak ... Am Aj ... An
                    for(int j = i + 1; j < rightHandSize; j++) {
                        // If Ak ... Am are all nullable, FOLLOW(Ai) contains FIRST(Aj)
                        ISymbol symbolJ = rightHand.get(j);
                        containsTheFirstOf.put(symbolI, symbolJ);

                        // If Ak ... An are NOT all nullable, continue with next Ai
                        if(!symbolJ.isNullable())
                            continue i;
                    }

                    // If Ak ... An are all nullable, FOLLOW(Ai) contains FOLLOW(A)
                    containsTheFollowOf.put(symbolI, s);
                }
            }
        }

        // Indirect contributions: Tarjan's algorithm for strongly connected components
        final int DONE = symbols.size();
        final Map<ISymbol, Integer> low = new HashMap<>();
        final Stack<ISymbol> stack = new Stack<>();
        for(ISymbol v : symbols) {
            if(low.get(v) == null /* CLEAN */)
                traverseFollow(v, containsTheFirstOf, containsTheFollowOf, DONE, low, stack);
        }
    }

    private void traverseFollow(ISymbol v, SetMultimap<ISymbol, ISymbol> containsTheFirstOf,
        SetMultimap<ISymbol, ISymbol> containsTheFollowOf, int DONE, Map<ISymbol, Integer> low, Stack<ISymbol> stack) {
        stack.push(v);
        int top1 = stack.size() - 1;
        low.put(v, top1);
        for(ISymbol w : containsTheFirstOf.get(v)) {
            v.setFollow(v.getFollow().union(w.getFirst())); // union!
        }
        for(ISymbol w : containsTheFollowOf.get(v)) {
            if(low.get(w) == null /* CLEAN */) {
                traverseFollow(w, containsTheFirstOf, containsTheFollowOf, DONE, low, stack);
            }
            // Change compared to the article at compilers.iecc.com: this line is moved outside of the previous if-block
            v.setFollow(v.getFollow().union(w.getFollow())); // union!
            if(low.get(w) < low.get(v))
                low.put(v, low.get(w));
        }
        if(low.get(v) == top1) // v is the root of this SCC
            while(stack.size() - 1 >= top1) {
                ISymbol w = stack.pop();
                w.setFollow(v.getFollow()); // distribute!
                low.put(w, DONE);
            }
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

        calculateDerivations();
    }


    // for every symbol A
    // for every production A = A1 ... AN
    // deriveLeft(A) = {A ++ A1 ++ deriveLeft(A1)}
    // deriveRight(A) = {A ++ AN ++ deriveRight(AN)}
    // FIXME consider nullable symbols
    private void calculateDerivations() {

        List<ISymbol> processedSymbols = Lists.newArrayList();
        for(ISymbol s : grammar.getSymbolProductionsMapping().keySet()) {
            calculateDerivations(s, processedSymbols);
        }
    }

    private void calculateDerivations(ISymbol s, List<ISymbol> processedSymbols) {
        if(processedSymbols.contains(s)) {
            return;
        }

        grammar.getLeftDerivable().put(s, s);
        grammar.getRightDerivable().put(s, s);

        for(IProduction p : grammar.getSymbolProductionsMapping().get(s)) {
            if(p.rightHand().isEmpty())
                continue;
            ISymbol leftmost = p.rightHand().get(0);
            ISymbol rightmost = p.rightHand().get(p.arity() - 1);
            if(!(leftmost instanceof Sort && ((Sort) leftmost).getType() != null) && !(leftmost instanceof CharacterClassSymbol)) {
                grammar.getLeftDerivable().put(s, leftmost);
                putLeftDerivables(s, leftmost, processedSymbols);

            }
            if(!(rightmost instanceof Sort && ((Sort) rightmost).getType() != null)&& !(rightmost instanceof CharacterClassSymbol)) {
                grammar.getRightDerivable().put(s, rightmost);
                putRightDerivables(s, rightmost, processedSymbols);

            }
        }

        processedSymbols.add(s);
    }

    private void putRightDerivables(ISymbol s, ISymbol rightmost, List<ISymbol> processedSymbols) {
        if(processedSymbols.contains(rightmost)) {
            grammar.getRightDerivable().putAll(s, grammar.getRightDerivable().get(rightmost));
        }

        for(IProduction p : grammar.getSymbolProductionsMapping().get(rightmost)) {
            if(p.rightHand().isEmpty())
                continue;
            ISymbol right = p.rightHand().get(p.arity() - 1);
            if(!(right instanceof Sort && ((Sort) right).getType() != null)
                && !grammar.getRightDerivable().get(s).contains(right)
                && !(right instanceof CharacterClassSymbol)) {
                grammar.getRightDerivable().put(s, right);
                putRightDerivables(s, right, processedSymbols);
            }
        }

    }

    private void putLeftDerivables(ISymbol s, ISymbol leftmost, List<ISymbol> processedSymbols) {
        if(processedSymbols.contains(leftmost)) {
            grammar.getLeftDerivable().putAll(s, grammar.getLeftDerivable().get(leftmost));
        }

        for(IProduction p : grammar.getSymbolProductionsMapping().get(leftmost)) {
            if(p.rightHand().isEmpty())
                continue;
            ISymbol left = p.rightHand().get(0);
            if(!(left instanceof Sort && ((Sort) left).getType() != null)
                && !grammar.getLeftDerivable().get(s).contains(left)
                && !(left instanceof CharacterClassSymbol)) {
                grammar.getLeftDerivable().put(s, left);
                putLeftDerivables(s, left, processedSymbols);
            }
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
        for(int i = prod.arity() - 1; i >= 0; i--) {
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
                    if(p.lower().arity() == 1 || p.lower().arity() == 0) {
                        new_values.add(p.higher().rightRecursivePosition());
                        new_values.add(p.higher().leftRecursivePosition());
                    }

                    // if p2 : A = w1 A w2, priority should have no effect

                    // dangling suffix
                    // p1 : A = α A and p2 = α A γ or vice-versa
                    boolean matchPrefix = false;
                    int i, j;
                    for(i = 0, j = 0; i < p.higher().arity() && j < p.lower().arity(); i++, j++) {
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
                    for(i = p.higher().arity() - 1, j = p.lower().arity() - 1; i >= 0 && j >= 0; i--, j--) {
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
        
        for(Priority p : grammar.getIndexedPriorities().keySet()) {
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
                            new_priorities.put(normalizedGrammar().getGrammarFactory().createPriority(p.higher(),
                                (Production) prod, false), p.higher().leftRecursivePosition());
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
                            new_priorities.put(normalizedGrammar().getGrammarFactory().createPriority(p.higher(),
                                (Production) prod, false), p.higher().rightRecursivePosition());
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

    public boolean isLayoutSymbol(ISymbol s) {
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
                        if(grammar.priorities()
                            .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p1, p2, false))
                            || grammar.priorities()
                                .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p2, p1, false))) {
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
                            || p2.arity() == 1 || p1.arity() == 1) {
                            continue;
                        }

                        // if p1 != p2 and there is no priority declaration between p1 and p2
                        if(grammar.priorities()
                            .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p1, p2, false))
                            || grammar.priorities()
                                .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            logger.warn(
                                "GRAMMAR MAY CONTAIN AMBIGUITIES: No priority or associativity declaration between productions "
                                    + printWithConstructor(p1) + " and " + printWithConstructor(p2));
                        }
                    }
                }
            }
        }


        for(ISymbol s : recursiveSymbols) {
            for(Production p1 : leftRecursive.get(s)) {
                if(isNonAnnotatedLongestMatchList(p1, p1.leftRecursivePosition())) {
                    logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No longest match annotation on production "
                        + printWithConstructor(p1));
                }

                for(Production p2 : leftRecursive.get(s)) {
                    if(p1 != p2 && matchSuffix(p1, p2)) {
                        // if p1 != p2, p1 and p2 have matching prefixes, and
                        // there is no priority declaration between p1 and p2

                        if(p1.getRhs().size() > p2.getRhs().size() && grammar.priorities()
                            .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p1, p2, false))) {
                            continue;
                        }

                        if(p2.getRhs().size() > p1.getRhs().size() && grammar.priorities()
                            .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            if(p1.getRhs().size() > p2.getRhs().size() && !Symbol.isListNonTerminal(p1.leftHand())) {
                                logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration "
                                    + printWithConstructor(p1) + " > " + printWithConstructor(p2));
                            } else if(!Symbol.isListNonTerminal(p2.leftHand())) {
                                logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration "
                                    + printWithConstructor(p2) + " > " + printWithConstructor(p1));
                            }
                        }
                    }
                }

            }

            for(Production p1 : rightRecursive.get(s)) {
                if(isNonAnnotatedLongestMatchList(p1, p1.rightRecursivePosition())) {
                    logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No longest match annotation on production "
                        + printWithConstructor(p1));
                }

                for(Production p2 : rightRecursive.get(s)) {
                    if(p1 != p2 && matchPrefix(p1, p2)) {
                        // if p1 != p2, p1 and p2 have matching suffixes, and
                        // there is no priority declaration between p1 and p2

                        if(grammar.priorities()
                            .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p1, p2, false))
                            || grammar.priorities()
                                .containsKey(normalizedGrammar().getGrammarFactory().createPriority(p2, p1, false))) {
                            continue;
                        }

                        if(!conflicts.get(p2).contains(p1)) {
                            conflicts.put(p1, p2);
                            if(p1.arity() > p2.arity() && !Symbol.isListNonTerminal(p1.leftHand())) {
                                logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration "
                                    + printWithConstructor(p1) + " > " + printWithConstructor(p2));
                            } else if(!Symbol.isListNonTerminal(p2.leftHand())) {
                                logger.warn("GRAMMAR MAY CONTAIN AMBIGUITIES: No priority declaration "
                                    + printWithConstructor(p2) + " > " + printWithConstructor(p1));
                            }
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


    private boolean isNonAnnotatedLongestMatchList(IProduction p, int pos) {
        if(pos == -1) {
            return false;
        }

        if(!Symbol.isListNonTerminal(p.leftHand())) {
            ISymbol recSymbol = p.rightHand().get(pos);
            if(Symbol.isListNonTerminal(recSymbol)) {
                Set<IAttribute> attrs = grammar.getProductionAttributesMapping().get(p);
                for(IAttribute attr : attrs) {
                    if(attr instanceof GeneralAttribute
                        && (((GeneralAttribute) attr).getName().equals("longest-match"))) {
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

        if(p1.arity() > p2.arity()) {
            index = Collections.indexOfSubList(p1.rightHand(), p2.rightHand());
            return index > 0 && index == p1.arity() - p2.arity();
        } else {
            index = Collections.indexOfSubList(p2.rightHand(), p1.rightHand());
            return index > 0 && index == p2.arity() - p1.arity();
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
                rightmostContextsMapping, labels);
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
                Context deepLeft_ctx = cf.createContext(labelP, ContextType.DEEP, ContextPosition.LEFTMOST, 
                    leftmostContextsMapping, rightmostContextsMapping);
                Context deepRight_ctx = cf.createContext(labelP, ContextType.DEEP, ContextPosition.RIGHTMOST, 
                    leftmostContextsMapping, rightmostContextsMapping);
                Context danglingLeft_ctx = cf.createContext(labelP, ContextType.DANGLING, ContextPosition.LEFTMOST,
                     leftmostContextsMapping, rightmostContextsMapping);
                Context danglingRight_ctx = cf.createContext(labelP, ContextType.DANGLING, ContextPosition.RIGHTMOST,
                     leftmostContextsMapping, rightmostContextsMapping);
                if(ctx_s.containsProduction(labelP) || ctx_s.getContexts().contains(deepLeft_ctx)
                    || ctx_s.getContexts().contains(deepRight_ctx) || ctx_s.getContexts().contains(danglingLeft_ctx)
                    || ctx_s.getContexts().contains(danglingRight_ctx)) {
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
                } else if(!(ctx_s.getContexts().contains(deepLeft_ctx) || ctx_s.getContexts().contains(deepRight_ctx)
                    || ctx_s.getContexts().contains(danglingRight_ctx)
                    || ctx_s.getContexts().contains(danglingLeft_ctx))) {
                    ContextualProduction new_prod = cf.createContextualProduction((Production) p, ctx_s.getContexts(),
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

    @Override public int totalStates() {
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

    public ContextualFactory getContextualFactory() {
        return cf;
    }

    @Override public boolean isLayoutSensitive() {
        return config.isLayoutSensitive();
    }


}
