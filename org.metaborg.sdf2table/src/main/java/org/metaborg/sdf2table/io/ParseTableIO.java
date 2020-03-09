package org.metaborg.sdf2table.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.input.ClassLoaderObjectInputStream;
import org.apache.commons.vfs2.FileObject;
import org.metaborg.parsetable.IParseTableGenerator;
import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.actions.IGoto;
import org.metaborg.parsetable.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.states.IState;
import org.metaborg.sdf2table.deepconflicts.ContextualProduction;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.LexicalSymbol;
import org.metaborg.sdf2table.grammar.NormGrammar;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.parsetable.Action;
import org.metaborg.sdf2table.parsetable.Goto;
import org.metaborg.sdf2table.parsetable.ParseTable;
import org.metaborg.sdf2table.parsetable.ParseTableConfiguration;
import org.metaborg.sdf2table.parsetable.State;
import org.metaborg.util.log.ILogger;
import org.metaborg.util.log.LoggerUtils;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.TermFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class ParseTableIO implements IParseTableGenerator {

    private static final ILogger logger = LoggerUtils.logger(ParseTableIO.class);

    private File input;
    private File outputFile;
    private File ctxGrammarFile;
    private File persistedTableFile;
    private List<String> paths;
    private final static ITermFactory termFactory = new TermFactory();
    private final static CharacterClassFactory ccFactory = new CharacterClassFactory();
    private boolean tableCreated = false;
    private ParseTable pt;

    public ParseTableIO(File input, File output, File persistedTable, File ctxGrammar, List<String> paths) {
        this.input = input;
        this.outputFile = output;
        this.paths = paths;
        this.persistedTableFile = persistedTable;
        this.ctxGrammarFile = ctxGrammar;
    }

    public ParseTableIO(File tableFile) throws Exception {
        this(new FileInputStream(tableFile));
    }

    public ParseTableIO(FileObject tableFile) throws Exception {
        this(tableFile.getContent().getInputStream());
    }

    public ParseTableIO(InputStream is) throws Exception {
        // Use ClassLoaderObjectInputStream instead of regular ObjectInputStream to ensure that objects get deserialized
        // with the classloader of this class, instead of some other arbitrary classloader chosen by the JVM which is
        // wrong in environments with custom classloaders such as Maven and Gradle plugins.
        try(final ObjectInputStream ois = new ClassLoaderObjectInputStream(getClass().getClassLoader(), is)) {
            // read persisted normalized grammar
            pt = (ParseTable) ois.readObject();
        }

        tableCreated = true;
    }

    public void createParseTable(ParseTableConfiguration config) throws Exception {
        NormGrammar grammar = new NormGrammarReader(paths).readGrammar(input);
        pt = new ParseTable(grammar, config);
        tableCreated = true;
    }

    public void outputTable(ParseTableConfiguration config) throws Exception {
        if(tableCreated == false) {
            try {
                createParseTable(config);
            } catch(Exception e) {
                logger.error(e.getMessage());
                throw e;
            }
        }
        // FIXME add option to generate the contextual grammar in the Yaml file
        boolean generateContextualGrammar = false;
        if(ctxGrammarFile != null && generateContextualGrammar) {
            IStrategoTerm ctxGrammar = generateATermContextualGrammar(pt);
            outputToFile(ctxGrammar, ctxGrammarFile);
        }

        // output binary normalized grammar
        if(persistedTableFile != null) {
            persistObjectToFile(pt, persistedTableFile);
        }

        if(outputFile != null) {
            IStrategoTerm ptAterm = generateATerm(pt);
            // output aterm corresponding to the parse table
            outputToFile(ptAterm, outputFile);
        }

    }

    public static IStrategoTerm generateATerm(ParseTable pt) throws Exception {

        IStrategoTerm version = termFactory.makeInt(ParseTable.VERSION_NUMBER);
        IStrategoTerm initialState = termFactory.makeInt(ParseTable.INITIAL_STATE_NUMBER);

        IStrategoTerm labels = generateLabelsAterm(pt);
        IStrategoTerm priorities = generatePrioritiesAterm(pt);
        IStrategoTerm states = generateStatesAterm(pt);

        return termFactory.makeAppl(termFactory.makeConstructor("parse-table", 5), version, initialState, labels,
            states, priorities);
    }

    public static IStrategoTerm generateATermContextualGrammar(ParseTable pt) {

        List<IStrategoTerm> productions = Lists.newArrayList();
        List<IStrategoTerm> priorities = Lists.newArrayList();
        Set<org.metaborg.sdf2table.grammar.ISymbol> recursiveSymbols = Sets.newHashSet();
        IAttribute placeholder = pt.normalizedGrammar().getGrammarFactory().createGeneralAttribute("placeholder");
        IAttribute placeholder_insertion =
            pt.normalizedGrammar().getGrammarFactory().createGeneralAttribute("placeholder-insertion");

        for(IProduction p : pt.productionLabels().keySet()) {  
            if(pt.isLayoutSymbol(p.leftHand())) {
                continue;
            }
            if(p instanceof Production) {
                if(((Production) p).leftRecursivePosition() == -1 && ((Production) p).rightRecursivePosition() == -1
                    || p.leftHand() instanceof LexicalSymbol) {
                    continue;
                }
            } else if(p instanceof ContextualProduction) {
                if(((ContextualProduction) p).getOrigProduction().leftRecursivePosition() == -1
                    && ((ContextualProduction) p).getOrigProduction().rightRecursivePosition() == -1
                    || p.leftHand() instanceof LexicalSymbol) {
                    continue;
                }
            }
            recursiveSymbols.add(p.leftHand());
        }

        for(IProduction p : pt.productionLabels().keySet()) {
            
            if(!recursiveSymbols.contains(p.leftHand())) {
                continue;
            }
            if(p instanceof Production) {
                Set<IAttribute> attrs = pt.normalizedGrammar().getProductionAttributesMapping().get(p);
                if(attrs.contains(placeholder)) {
                    continue;
                }
                productions.add(((Production) p).toSDF3Aterm(pt.normalizedGrammar().getProductionAttributesMapping(),
                    ((ParseTable) pt).getCtxUniqueInt(), null));
            } else if(p instanceof ContextualProduction) {
                Set<IAttribute> attrs = pt.normalizedGrammar().getProductionAttributesMapping().get(((ContextualProduction) p).getOrigProduction());
                if(attrs.contains(placeholder)) {
                    continue;
                }
                productions
                    .add(((ContextualProduction) p).toSDF3Aterm(pt.normalizedGrammar().getProductionAttributesMapping(),
                        ((ParseTable) pt).getCtxUniqueInt(), null));
            }

        }

        IStrategoTerm syntaxSection = termFactory.makeAppl(termFactory.makeConstructor("SDFSection", 1),
            termFactory.makeAppl(termFactory.makeConstructor("Kernel", 1), termFactory.makeList(productions)));

        IStrategoTerm prioritiesSection = termFactory.makeAppl(termFactory.makeConstructor("SDFSection", 1),
            termFactory.makeAppl(termFactory.makeConstructor("Priorities", 1), termFactory.makeList(priorities)));

        IStrategoTerm restrictionsSection = termFactory.makeAppl(termFactory.makeConstructor("SDFSection", 1),
            termFactory.makeAppl(termFactory.makeConstructor("Restrictions", 1), termFactory.makeList(priorities)));

        return termFactory.makeAppl(termFactory.makeConstructor("Module", 3),
            termFactory.makeAppl(termFactory.makeConstructor("Unparameterized", 1),
                termFactory.makeString("contextual-grammar")),
            termFactory.makeList(), termFactory.makeList(syntaxSection, prioritiesSection, restrictionsSection));
    }

    private static IStrategoTerm generateStatesAterm(ParseTable pt) {
        List<IStrategoTerm> terms = Lists.newArrayList();
        for(int i = 0; i < pt.totalStates(); i++) {
            State s = pt.stateLabels().get(i);
            List<IStrategoTerm> goto_terms = Lists.newArrayList();
            List<IStrategoTerm> action_terms = Lists.newArrayList();
            for(IGoto goto_action : s.gotos()) {
                goto_terms.add(((Goto) goto_action).toAterm(termFactory));
            }
            for(ICharacterClass cc : s.actionsMapping().keySet()) {
                List<IStrategoTerm> actions = Lists.newArrayList();
                for(IAction a : s.actionsMapping().get(cc)) {
                    actions.add(((Action) a).toAterm(termFactory, pt));
                }
                action_terms.add(termFactory.makeAppl(termFactory.makeConstructor("action", 2),
                    cc.toAtermList(termFactory), termFactory.makeList(actions)));
                // action_terms.add(action.toAterm(termFactory, this));
            }
            terms.add(termFactory.makeAppl(termFactory.makeConstructor("state-rec", 3), termFactory.makeInt(s.id()),
                termFactory.makeList(goto_terms), termFactory.makeList(action_terms)));
        }

        return termFactory.makeAppl(termFactory.makeConstructor("states", 1), termFactory.makeList(terms));
    }

    private static IStrategoTerm generatePrioritiesAterm(ParseTable pt) throws Exception {
        List<IStrategoTerm> terms = Lists.newArrayList();
        SetMultimap<Priority, Integer> allPriorities = HashMultimap.create();

        allPriorities.putAll(pt.normalizedGrammar().priorities());
        allPriorities.putAll(pt.normalizedGrammar().getIndexedPriorities());

        for(java.util.Map.Entry<Priority, Integer> e : allPriorities.entries()) {
            IProduction prod_higher = e.getKey().higher();
            IProduction prod_lower = e.getKey().lower();
            // because non-contextual production got replaced
            if(pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prod_higher)) {
                prod_higher = pt.normalizedGrammar().getProdContextualProdMapping().get(e.getKey().higher());
            }
            if(pt.normalizedGrammar().getProdContextualProdMapping().containsKey(prod_lower)) {
                prod_lower = pt.normalizedGrammar().getProdContextualProdMapping().get(e.getKey().lower());
            }
            Integer label_higher = pt.productionLabels().get(prod_higher);
            Integer label_lower = pt.productionLabels().get(prod_lower);
            if(label_higher == null || label_lower == null) {
                throw new Exception("Production label not found.");
            }
            if(e.getValue() == -1) {
                IStrategoTerm prio_term = termFactory.makeAppl(termFactory.makeConstructor("gtr-prio", 2),
                    termFactory.makeInt(label_higher), termFactory.makeInt(label_lower));
                terms.add(prio_term);
            } else {
                if(e.getValue() == Integer.MAX_VALUE || e.getValue() == Integer.MIN_VALUE)
                    continue;

                IStrategoTerm prio_term = termFactory.makeAppl(termFactory.makeConstructor("arg-gtr-prio", 3),
                    termFactory.makeInt(label_higher), termFactory.makeInt(e.getValue()),
                    termFactory.makeInt(label_lower));
                terms.add(prio_term);
            }
        }

        return termFactory.makeAppl(termFactory.makeConstructor("priorities", 1), termFactory.makeList(terms));

    }

    private static IStrategoTerm generateLabelsAterm(ParseTable pt) {
        List<IStrategoTerm> terms = Lists.newArrayList();

        for(int i = 257 + pt.productionLabels().size() - 1; i >= 257; i--) {
            IProduction p = pt.productionLabels().inverse().get(i);
            IStrategoTerm p_term;

            if(p instanceof Production) {
                p_term = termFactory.makeAppl(termFactory.makeConstructor("label", 2),
                    ((Production) p).toAterm(pt.normalizedGrammar().getProductionAttributesMapping()),
                    termFactory.makeInt(i));
            } else {
                p_term = termFactory.makeAppl(termFactory.makeConstructor("label", 2),
                    ((ContextualProduction) p).toAterm(pt.normalizedGrammar().getProductionAttributesMapping()),
                    termFactory.makeInt(i));
            }

            terms.add(p_term);
        }

        return termFactory.makeList(terms);
    }

    public ParseTable getParseTable() {
        return pt;
    }

    public void setParseTable(ParseTable pt) {
        this.pt = pt;
    }

    // For JSGLR1 dynamic parse table generation
    @Override public IStrategoTerm getStateAterm(IState s) {
        List<IStrategoTerm> goto_terms = Lists.newArrayList();
        List<IStrategoTerm> action_terms = Lists.newArrayList();
        for(IGoto goto_action : ((State) s).gotos()) {
            goto_terms.add(((Goto) goto_action).toAterm(termFactory));
        }
        for(ICharacterClass cc : ((State) s).actionsMapping().keySet()) {
            List<IStrategoTerm> actions = Lists.newArrayList();
            for(IAction a : ((State) s).actionsMapping().get(cc)) {
                actions.add(((Action) a).toAterm(termFactory, pt));
            }
            action_terms.add(termFactory.makeAppl(termFactory.makeConstructor("action", 2), cc.toAtermList(termFactory),
                termFactory.makeList(actions)));
            // action_terms.add(action.toAterm(termFactory, this));
        }
        return termFactory.makeAppl(termFactory.makeConstructor("state-rec", 3), termFactory.makeInt(s.id()),
            termFactory.makeList(goto_terms), termFactory.makeList(action_terms));
    }

    public static void outputToFile(IStrategoTerm parseTable, File output) {
        logger.info("Outputting parsetable without creating a string for it first. ");
        if(output != null) {
            output.getParentFile().mkdirs();
            try(final FileWriter out = new FileWriter(output)) {
                parseTable.writeAsString(out);
            } catch(IOException e) {
                logger.error("Could not write parse table", e);
            }
        }

    }

    public static void persistObjectToFile(ParseTable pt, File output) {
        String name = output.getAbsolutePath();
        try(final ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream(name))) {
            outObj.writeObject(pt);
        } catch(IOException e) {
            logger.error("Could not persist normalized grammar", e);
        }

    }

    public static ITermFactory getTermfactory() {
        return termFactory;
    }

    public static CharacterClassFactory getCharacterClassFactory() {
        return ccFactory;
    }

    @Override public SetMultimap<String, String> getNonAssocPriorities() {
        SetMultimap<String, String> result = null;
        if(tableCreated) {
            result = pt.normalizedGrammar().getNonAssocPriorities();
        }

        if(result != null)
            return result;

        return HashMultimap.create();
    }

    @Override public SetMultimap<String, String> getNonNestedPriorities() {
        SetMultimap<String, String> result = null;

        if(tableCreated) {
            result = pt.normalizedGrammar().getNonNestedPriorities();
        }

        if(result != null)
            return result;

        return HashMultimap.create();
    }

}
