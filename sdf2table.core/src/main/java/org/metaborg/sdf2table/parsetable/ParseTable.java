package org.metaborg.sdf2table.parsetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.metaborg.sdf2table.core.Benchmark;
import org.metaborg.sdf2table.core.CollisionSet;
import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Module;
import org.metaborg.sdf2table.grammar.ModuleNotFoundException;
import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.grammar.UndefinedSymbolException;
import org.metaborg.sdf2table.io.Parenthesizer;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.*;

public class ParseTable extends CollisionSet<State> {
    public static final int VERSION = 6;

    public enum PriorityPolicy {
        IGNORE, DEEP, SHALLOW
    }

    public enum DeepReduceConflictPolicy {
        IGNORE, MERGE
    }

    static final StrategoConstructor CONS_PT = new StrategoConstructor("parse-table", 5);
    static final StrategoConstructor CONS_STATES = new StrategoConstructor("states", 1);
    static final StrategoConstructor CONS_PRIORITIES = new StrategoConstructor("priorities", 1);

    /**
     * HashMap initial capacity factor
     */
    static final int CAPACITY_FACTOR = 2;
    static final float LOAD_FACTOR = 0.75f;

    List<Label> _labels = new LinkedList<>();

    Syntax _syntax;
    PriorityPolicy _ppolicy = PriorityPolicy.DEEP;
    DeepReduceConflictPolicy _rcpolicy = DeepReduceConflictPolicy.IGNORE;

    Queue<State> _queue = new LinkedList<>();

    static ParseTable _current = null;

    public static class Statistics {
        int _state_count = 0;
        int _production_count = 0;
        int _c_production_count = 0;
        int _priority_level_count = 0;
        int _rr_conflicts = 0;
        int _sr_conflicts = 0;

        public void print(PrintStream out) {
            if(out == System.err) {
                out.println("==== parse table statistics ====");
                out.println("state count: " + _state_count);
                out.println("production count: " + _production_count);
                out.println("contextual production count: " + _c_production_count);
                out.println("priority level count: " + _priority_level_count);
                out.println("conflicts count: " + (_sr_conflicts + _rr_conflicts));
                out.println(".... shift/reduce: " + _sr_conflicts);
                out.println(".... reduce/reduce: " + _rr_conflicts);
                out.println("================================");
            } else {
                out.print(";" + _state_count);
                out.print(";" + _production_count);
                out.print(";" + _c_production_count);
                out.print(";" + _priority_level_count);
                out.print(";" + (_sr_conflicts + _rr_conflicts));
                out.print(";" + _sr_conflicts);
                out.print(";" + _rr_conflicts);
            }
        }
    }

    public ParseTable(Syntax syntax, PriorityPolicy pp, DeepReduceConflictPolicy rcp) {
        super(syntax.symbols().count() * CAPACITY_FACTOR, LOAD_FACTOR);

        _syntax = syntax;
        _ppolicy = pp;
        _rcpolicy = rcp;
    }

    public ParseTable(Syntax syntax, PriorityPolicy pp) {
        super(syntax.symbols().count() * CAPACITY_FACTOR, LOAD_FACTOR);

        _syntax = syntax;
        _ppolicy = pp;
    }

    public ParseTable(Syntax syntax) {
        super(syntax.symbols().count() * CAPACITY_FACTOR, LOAD_FACTOR);

        _syntax = syntax;
    }

    public static ParseTable current() {
        return _current;
    }

    public static Symbol unique(Symbol symbol) {
        return _current._syntax.symbols().get(symbol, true);
    }

    public static SyntaxProduction unique(SyntaxProduction prod) {
        return _current._syntax.uniqueProduction(prod);
    }

    public static Label newLabel(Production p) {
        Label l = new Label(p);
        if(_current._ppolicy == PriorityPolicy.SHALLOW || p instanceof ContextualProduction)
            _current._labels.add(l);
        return l;
    }

    public static LabelGroup newLabelGroup(Label l) {
        LabelGroup g = new LabelGroup(l);
        _current._labels.add(g);
        return g;
    }

    public static LabelGroup newLabelGroup(LabelGroup copy) {
        LabelGroup g = new LabelGroup(copy);
        _current._labels.add(g);
        return g;
    }

    public Syntax syntax() {
        return _syntax;
    }

    public PriorityPolicy priorityPolicy() {
        return _ppolicy;
    }

    public DeepReduceConflictPolicy deepReduceConflictPolicy() {
        return _rcpolicy;
    }

    public Statistics statistics() {
        Statistics st = new Statistics();

        st._state_count = size();
        st._priority_level_count = PriorityLevel.count();
        st._production_count = _syntax.productions().size();
        st._c_production_count = _syntax.contextualProductions().size();
        for(State s : this) {
            s.statistics(st);
        }

        return st;
    }

    public void build() throws UndefinedSymbolException, InterruptedException {
        _current = this;
        Benchmark.ComposedTask task = Benchmark.newComposedTask("parse table generation");
        task.start();

        NonTerminal start = _syntax.startProduction().product();
        
        if(_ppolicy == PriorityPolicy.DEEP) {
            Benchmark.SingleTask t = task.newSingleTask("Contextual symbols");

            t.start();
            start = ContextualSymbol.unique(null, start, null, ContextualSymbol.Filter.NONE);
            ContextualProduction.validateAll();
            ContextualSymbol.validateAll();
            t.stop();
        }

        Benchmark.SingleTask t_ff = task.newSingleTask("FIRST and FOLLOW computation");
        Benchmark.SingleTask t_sg = task.newSingleTask("states generation");

        t_ff.start();
        _syntax.computeFollowSets();
        t_ff.stop();

        t_sg.start();
        State s0 = new State(this);

        for(Production p : start.productions()) {
            s0.addItem(new Item(s0.items(), p));
        }

        push(s0);
        processQueue();
        t_sg.stop();

        task.stop();
        _current = null;
    }

    @Override public State push(State state) {
        state.complete();

        State s = super.push(state);
        if(s != null) {
            if(_rcpolicy == DeepReduceConflictPolicy.MERGE)
                s.merge(state);
            return s;
        }

        state.assignId(size() - 1);
        state.requestUpdate();

        return state;
    }

    public void requestUpdate(State s) {
        _queue.add(s);
    }

    public void processQueue() throws UndefinedSymbolException, InterruptedException {
        while(!_queue.isEmpty()) {
            if(Thread.currentThread().isInterrupted())
                throw new InterruptedException();

            State state = _queue.poll();
            state.close();
            state.reduce();
            state.shift();
        }
    }

    public static ParseTable fromSyntax(Syntax syntax, PriorityPolicy pp)
        throws UndefinedSymbolException, InterruptedException {
        ParseTable table = new ParseTable(syntax, pp);

        table.build();

        return table;
    }

    public static void resetAll() {
        State.reset();
        Label.reset();
        PriorityLevel.reset();

        Benchmark.reset();
    }

    public static void genStats(File input, File output, List<String> paths) {
        try {
            Path shallow_log = java.nio.file.Paths.get(output.getPath() + "-shallow.csv");
            Path deep_log = java.nio.file.Paths.get(output.getPath() + "-deep.csv");

            PrintStream shallow_out = new PrintStream(new FileOutputStream(shallow_log.toFile(), true));
            PrintStream deep_out = new PrintStream(new FileOutputStream(deep_log.toFile(), true));

            int n = 20;

            String header =
                "state count;production count;contextual production count; priority level count; conflicts count;shift/reduce;reduce/reduce";
            header +=
                "sdf2table;import;generation;parse table generation;grammar transformation;FIRST and FOLLOW computation;states generation;close;reduce;action;shift;compare";

            for(int i = 0; i < n; ++i) {
                System.err.println("shallow generation " + i + "/" + n);
                shallow_out.println(header);
                shallow_out.print(i);
                fromFile(input, output, paths, PriorityPolicy.SHALLOW, shallow_out, false, false);
                shallow_out.print("\n");
            }

            for(int i = 0; i < n; ++i) {
                System.err.println("deep generation " + i + "/" + n);
                deep_out.println(header);
                deep_out.print(i);
                fromFile(input, output, paths, PriorityPolicy.DEEP, deep_out, false, false);
                deep_out.print("\n");
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void fromFile(File input, File output, List<String> paths, boolean parenthesize) {
        fromFile(input, output, paths, PriorityPolicy.DEEP, System.err, parenthesize, false);
        // genStats(input, output, paths);
    }

    public static void fromFile(File input, File output, List<String> paths, PriorityPolicy pp, PrintStream log,
        boolean parenthesize, boolean generate_dot) {
        System.out.println("import file `" + input.getName() + "' (" + pp.toString() + " priority policy)");
        resetAll();

        Benchmark.SingleTask t_import = Benchmark.main.newSingleTask("import");
        Benchmark.ComposedTask t_generate = Benchmark.main.newComposedTask("generation");
        Benchmark.SingleTask t_export = Benchmark.main.newSingleTask("export");

        // import modules
        t_import.start();
        Syntax syntax = null;
        try {
            syntax = Module.fromFile(input, paths);
        } catch(ModuleNotFoundException e) {
            System.err.println(e.getMessage());
            return;
        }
        t_import.stop();

        // parenthesize
        if(parenthesize) {
            TermFactory tf = new TermFactory();
            final String pname = syntax.mainModule().absoluteName().replace("-norm", "");
            File poutput = new File(output.getParentFile().getParentFile().getParentFile().getAbsolutePath()
                + "/src-gen/pp/" + pname + "-parenthesize.str");
            IStrategoTerm parenthesized = Parenthesizer.parenthesize(syntax, pname, tf);
            String ppp = Parenthesizer.prettyPrint(parenthesized);
            FileWriter pout = null;
            try {
                pout = new FileWriter(poutput);

                pout.write(ppp);
                // pout.write(parenthesized.toString());

                pout.close();
            } catch(IOException e) {
                System.err.println(e.getMessage());
            }
        }
        
        // generate parse table
        t_generate.start();
        ParseTable pt = null;
        try {
            pt = ParseTable.fromSyntax(syntax, pp);
        } catch(UndefinedSymbolException | InterruptedException e) {
            System.err.println(e.getMessage());
            return;
        }
        t_generate.stop();

        // export parse table
        t_export.start();
        IStrategoTerm result = pt.toATerm();
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
        t_export.stop();

        if(generate_dot) {
            if(pt.size() > 200) {
                System.err.println("The parse-table is huge. No Graphviz file will be generated.");
            } else {
                pt.generateGraphvizFile(java.nio.file.Paths.get(output.getPath() + ".dot"));
            }
        }
        if(log != null) {
            pt.statistics().print(log);
            Benchmark.print(log);
        }

        resetAll();
    }

    void generateGraphvizFile(Path file) {
        try {
            Files.write(file, digraph().getBytes());
            System.err.println("Graphiv written at: " + file.toAbsolutePath().toUri().getPath());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getInitialState() {
        return 0;
    }

    public IStrategoTerm toATerm() {
        _current = this;

        ArrayList<IStrategoTerm> labels = new ArrayList<>();
        ArrayList<IStrategoTerm> priorities = new ArrayList<>();

        for(Label l : _labels) {
            labels.add(l.toATerm());
        }

        for(SyntaxProduction p : _syntax.productions()) {
            labels.add(p.label().toATerm()); // to match priorities
            priorities.addAll(p.priorities().toATerms());
        }

        _current = null;

        return new StrategoAppl(CONS_PT,
            new IStrategoTerm[] { new StrategoInt(VERSION, null, 0), new StrategoInt(getInitialState(), null, 0),
                Utilities.strategoListFromCollection(labels),
                new StrategoAppl(CONS_STATES, new IStrategoTerm[] { Utilities.strategoListFromExportables(this) }, null,
                    0),
                new StrategoAppl(CONS_PRIORITIES,
                    new IStrategoTerm[] { Utilities.strategoListFromCollection(priorities) }, null, 0) },
            null, 0);
    }

    public String digraph() {
        String str = "digraph g{\n";
        str += "graph [rankdir = \"LR\"];\n";

        for(State s : this) {
            str += s.digraph();
        }

        str += "}";
        return str;
    }

    public static void declareContextualProduction(ContextualProduction contextualProduction) {
        _current._syntax.declareContextualProduction(contextualProduction);
    }
}
