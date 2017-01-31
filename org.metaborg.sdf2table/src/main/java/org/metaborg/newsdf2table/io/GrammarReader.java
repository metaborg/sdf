package org.metaborg.newsdf2table.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.exceptions.ModuleNotFoundException;
import org.metaborg.newsdf2table.exceptions.UnexpectedTermException;
import org.metaborg.newsdf2table.grammar.AltSymbol;
import org.metaborg.newsdf2table.grammar.CharacterClass;
import org.metaborg.newsdf2table.grammar.CharacterClassConc;
import org.metaborg.newsdf2table.grammar.CharacterClassNumeric;
import org.metaborg.newsdf2table.grammar.CharacterClassRange;
import org.metaborg.newsdf2table.grammar.CharacterClassSeq;
import org.metaborg.newsdf2table.grammar.ConstructorAttribute;
import org.metaborg.newsdf2table.grammar.ContextFreeSymbol;
import org.metaborg.newsdf2table.grammar.DeprecatedAttribute;
import org.metaborg.newsdf2table.grammar.FileStartSymbol;
import org.metaborg.newsdf2table.grammar.GeneralAttribute;
import org.metaborg.newsdf2table.grammar.IAttribute;
import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.IterSepSymbol;
import org.metaborg.newsdf2table.grammar.IterStarSepSymbol;
import org.metaborg.newsdf2table.grammar.IterStarSymbol;
import org.metaborg.newsdf2table.grammar.IterSymbol;
import org.metaborg.newsdf2table.grammar.Layout;
import org.metaborg.newsdf2table.grammar.LayoutConstraintAttribute;
import org.metaborg.newsdf2table.grammar.LexicalSymbol;
import org.metaborg.newsdf2table.grammar.LiteralType;
import org.metaborg.newsdf2table.grammar.NormGrammar;
import org.metaborg.newsdf2table.grammar.OptionalSymbol;
import org.metaborg.newsdf2table.grammar.Priority;
import org.metaborg.newsdf2table.grammar.Production;
import org.metaborg.newsdf2table.grammar.SequenceSymbol;
import org.metaborg.newsdf2table.grammar.Sort;
import org.metaborg.newsdf2table.grammar.StartSymbol;
import org.metaborg.newsdf2table.grammar.Symbol;
import org.metaborg.newsdf2table.grammar.TermAttribute;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class GrammarReader {

    public static NormGrammar readGrammar(File input, File output, List<String> paths, ITermFactory termFactory)
        throws Exception {
        Map<String, Boolean> modules = Maps.newHashMap();

        IStrategoTerm mainModule = termFromFile(input, termFactory);

        NormGrammar grammar = new NormGrammar();

        generateGrammar(grammar, mainModule, modules, paths, termFactory);
        grammar.priorityTransitiveClosure();

        return grammar;
    }

    private static void generateGrammar(NormGrammar g, IStrategoTerm module, Map<String, Boolean> modules,
        List<String> paths, ITermFactory termFactory) throws Exception {

        if(module instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) module;
            if(app.getName().equals("Module")) {
                // Module attributes
                String modName = "";
                // Get module name from: Unparameterized("<name>")
                StrategoString tname = (StrategoString) app.getSubterm(0).getSubterm(0);
                modName = tname.stringValue();

                // Module has already been processed
                if(modules.get(modName) != null) {
                    return;
                }

                // Processing module
                modules.put(modName, true);

                // Processing Dependencies
                for(IStrategoTerm t : (StrategoList) app.getSubterm(1)) {
                    if(t instanceof StrategoAppl && ((StrategoAppl) t).getName().equals("Imports")) {
                        for(IStrategoTerm timport : (StrategoList) t.getSubterm(0)) {
                            if(timport instanceof StrategoAppl && ((StrategoAppl) timport).getName().equals("Module")) {
                                String iname = null;

                                switch(((StrategoAppl) timport.getSubterm(0)).getName()) {
                                    case "Unparameterized":
                                        iname = ((StrategoString) timport.getSubterm(0).getSubterm(0)).stringValue();
                                        break;
                                    case "Parameterized":
                                        break;
                                    default:
                                        break;
                                }
                                // processing import in case it has not been processed yet
                                if(iname != null && modules.get(iname) == null) {
                                    for(String path : paths) {
                                        String filename = path + "/" + iname + ".aterm";
                                        File file = new File(filename);
                                        if(file.exists() && !file.isDirectory()) {
                                            IStrategoTerm iModule = termFromFile(file, termFactory);
                                            generateGrammar(g, iModule, modules, paths, termFactory);
                                            break;
                                        } else {
                                            throw new ModuleNotFoundException(iname, modName);
                                        }
                                    }
                                }

                            }
                        }
                    }
                }

                // Processing sections
                StrategoList sdf_sections = (StrategoList) app.getSubterm(2);
                for(IStrategoTerm t : sdf_sections) {
                    StrategoAppl tsection = (StrategoAppl) t.getSubterm(0);
                    switch(tsection.getName()) {
                        case "Kernel":
                            addProds(g, tsection);
                            break;
                        case "Restrictions":
                            addRestrictions(g, tsection);
                            break;
                        case "Priorities":
                            addPriorities(g, tsection);
                            break;
                        default:
                            System.err.println("Unknown module section `" + tsection.getName() + "'");
                            break;
                    }
                }

            }
        }
    }

    private static void addProds(NormGrammar g, StrategoAppl section) throws UnexpectedTermException {
        if(section instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) section;
            if(app.getName().equals("Kernel")) {
                StrategoList sdf_productions = (StrategoList) app.getSubterm(0);
                for(IStrategoTerm t : sdf_productions) {
                    g.prods.add(processProduction(g, t));
                }
            }
        }
    }

    private static IProduction processProduction(NormGrammar g, IStrategoTerm term) throws UnexpectedTermException {

        if(term instanceof IStrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            boolean with_cons = false;
            if(app.getName().equals("SdfProduction")
                || (with_cons = true && app.getName().equals("SdfProductionWithCons"))) {
                Symbol symbol;
                String cons = null;
                List<Symbol> rhs_symbols = Lists.newArrayList();
                StrategoAppl tattrs;

                if(with_cons) {
                    // SdfProductionWithCons(SortCons(<type>), Constructor("<cons>"), ...)
                    symbol = processSymbol(g, app.getSubterm(0).getSubterm(0));
                    cons = ((StrategoString) app.getSubterm(0).getSubterm(1).getSubterm(0)).stringValue();
                } else {
                    symbol = processSymbol(g, app.getSubterm(0));
                }

                // Read right hand side of the equation: Rhs([<symbols>])
                StrategoList rhs = (StrategoList) app.getSubterm(1).getSubterm(0);
                for(IStrategoTerm t : rhs) {
                    Symbol s = processSymbol(g, t);
                    if(s != null)
                        rhs_symbols.add(s);
                }

                // Read attributes
                tattrs = (StrategoAppl) app.getSubterm(2);
                Set<IAttribute> attrs = Sets.newHashSet();
                switch(tattrs.getName()) {
                    case "NoAttrs":
                        break;
                    case "Attrs":
                        StrategoList talist = (StrategoList) tattrs.getSubterm(0);
                        for(IStrategoTerm ta : talist) {
                            IAttribute attr = processAttribute(ta);
                            if(attr != null)
                                attrs.add(attr);
                        }
                        break;
                    default:
                        throw new UnexpectedTermException(term.toString(), "Attributes");
                }

                if(cons != null) {
                    attrs.add(new ConstructorAttribute(cons));
                }

                Production prod = new Production(symbol, rhs_symbols);
                if(symbol instanceof FileStartSymbol && g.initial_prod == null) {
                    g.initial_prod = prod;
                }

                for(IAttribute a : attrs) {
                    g.prod_attrs.put(prod, a);
                }

                g.symbol_prods.put(symbol, prod);
                return prod;

            } else {
                throw new UnexpectedTermException(term.toString(), "SdfProduction");
            }
        }
        throw new UnexpectedTermException(term.toString(), "SdfProduction");
    }

    private static Symbol processSymbol(NormGrammar g, IStrategoTerm term) {
        Symbol symbol = null;
        String enquoted;


        symbol = g.symbols.get(term.toString());


        if(symbol != null) {
            return symbol;
        }

        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            switch(app.getName()) {
                case "SortDef":
                    symbol = new Sort(((StrategoString) app.getSubterm(0)).stringValue());
                    break;
                case "Sort":
                    symbol = new Sort(((StrategoString) app.getSubterm(0)).stringValue());
                    break;
                case "Layout":
                    symbol = new Layout();
                    break;
                case "CharClass":
                    symbol = new CharacterClass(processCharClass(term.getSubterm(0)));
                    break;
                case "Lit":
                    enquoted = ((StrategoString) app.getSubterm(0)).stringValue();
                    symbol = new Sort(enquoted.substring(1, enquoted.length() - 1), LiteralType.Lit);
                    break;
                case "CiLit":
                    enquoted = ((StrategoString) app.getSubterm(0)).stringValue();
                    symbol = new Sort(enquoted.substring(1, enquoted.length() - 1), LiteralType.CiLit);
                    break;
                case "Opt":
                    symbol = new OptionalSymbol(processSymbol(g, app.getSubterm(0)));
                    break;
                case "Alt":
                    symbol = new AltSymbol(processSymbol(g, app.getSubterm(0)), processSymbol(g, app.getSubterm(1)));
                    break;
                case "Sequence":
                    symbol = new SequenceSymbol(processSymbol(g, app.getSubterm(0)),
                        processSymbolList(g, app.getSubterm(1)));
                    break;
                case "Iter":
                    symbol = new IterSymbol(processSymbol(g, app.getSubterm(0)));
                    break;
                case "IterStar":
                    symbol = new IterStarSymbol(processSymbol(g, app.getSubterm(0)));
                    break;
                case "IterSep":
                    symbol =
                        new IterSepSymbol(processSymbol(g, app.getSubterm(0)), processSymbol(g, app.getSubterm(1)));
                    break;
                case "IterStarSep":
                    symbol =
                        new IterStarSepSymbol(processSymbol(g, app.getSubterm(0)), processSymbol(g, app.getSubterm(1)));
                    break;
                case "Lex":
                    symbol = new LexicalSymbol(processSymbol(g, app.getSubterm(0)));
                    break;
                case "Cf":
                    symbol = new ContextFreeSymbol(processSymbol(g, app.getSubterm(0)));
                    break;
                case "Start":
                    symbol = new StartSymbol();
                    break;
                case "FileStart":
                    symbol = new FileStartSymbol();
                    break;
                default:
                    System.err.println("Unknown symbol type `" + app.getName() + "'. Is that normalized SDF3?");
                    return null;
            }
        } else {
            System.err.println("Malformed term. Application expected.");
            return null;
        }

        if(g != null && symbol != null) {
            g.symbols.put(term.toString(), symbol);
        }

        return symbol;
    }


    public static List<Symbol> processSymbolList(NormGrammar g, IStrategoTerm term) {
        List<Symbol> list = Lists.newLinkedList();

        if(term instanceof StrategoList) {
            StrategoList slist = (StrategoList) term;

            for(IStrategoTerm t : slist) {
                Symbol s = processSymbol(g, t);
                if(s != null)
                    list.add(s);
            }
        } else {
            System.err.println("sdf2table : Symbol.fromStrategoList: this term is not a list.");
        }

        return list;
    }

    public static Symbol processCharClass(IStrategoTerm term) {
        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            switch(app.getName()) {
                case "Absent":
                    return null;
                case "Simple":
                    return processCharClass(app.getSubterm(0));
                case "Present":
                    return processCharClass(app.getSubterm(0));
                case "Range":
                    return new CharacterClassRange((processCharClass(app.getSubterm(0))),
                        (processCharClass(app.getSubterm(1))));
                case "Numeric":
                    String str = ((StrategoString) app.getSubterm(0)).stringValue();
                    return new CharacterClassNumeric(Integer.parseInt(str.substring(1)));
                case "Conc":
                    return new CharacterClassConc(processCharClass(app.getSubterm(0)),
                        processCharClass(app.getSubterm(1)));
                default:
                    System.err.println("Unknown character class `" + app.getName() + "'. Is that normalized SDF3?");
                    return null;
            }
        }

        System.err.println("Malformed term. Application expected.");
        return null;
    }

    private static IAttribute processAttribute(IStrategoTerm ta) throws UnexpectedTermException {
        if(ta instanceof StrategoAppl) {
            StrategoAppl a = (StrategoAppl) ta;
            switch(a.getName()) { // This is just to get a proper name for the attribute.
                case "Assoc":
                    StrategoAppl assoc = (StrategoAppl) a.getSubterm(0);
                    switch(assoc.getName()) {
                        case "Left":
                            return new GeneralAttribute("left");
                        case "Right":
                            return new GeneralAttribute("right");
                        case "Assoc":
                            return new GeneralAttribute("assoc");
                        case "NonAssoc":
                            return new GeneralAttribute("non-assoc");
                        default:
                            System.err.println("Unknown associativity: `" + assoc.getName() + "'.");
                            break;
                    }
                    break;
                case "Reject":
                    return new GeneralAttribute("reject");
                case "Prefer":
                    return new GeneralAttribute("prefer");
                case "Avoid":
                    return new GeneralAttribute("avoid");
                case "Bracket":
                    return new GeneralAttribute("bracket");
                case "LayoutConstraint":
                    return new LayoutConstraintAttribute(a.getSubterm(0).toString());
                case "IgnoreLayout":
                    return new LayoutConstraintAttribute("ignore-layout");
                case "EnforceNewLine":
                    return new GeneralAttribute("enforce-newline");
                case "LongestMatch":
                    return new GeneralAttribute("longest-match");
                case "CaseInsensitive":
                    return new GeneralAttribute("case-insensitive");
                case "Deprecated":
                    String message = "";
                    if(a.getSubtermCount() > 0) {
                        message = ((StrategoString) a.getSubterm(0)).stringValue();
                    }
                    return new DeprecatedAttribute(message);
                case "Placeholder":
                    return new GeneralAttribute("placeholder");
                case "PlaceholderInsertion":
                    return new GeneralAttribute("placeholder-insertion");
                case "LiteralCompletion":
                    return new GeneralAttribute("literal-completion");
                case "Term":
                    IStrategoTerm def = a.getSubterm(0);
                    IStrategoTerm appl = def.getSubterm(0);
                    IStrategoTerm quoted = appl.getSubterm(0);
                    IStrategoTerm attr_name = quoted.getSubterm(0);
                    if(attr_name.toString().equals("\"layout\"")) {
                        // check whether it's a quoted constraint or term constraint
                        IStrategoTerm fun = appl.getSubterm(1).getSubterm(0);
                        IStrategoTerm quotedElem = fun.getSubterm(0);
                        if(((IStrategoAppl) quotedElem).getConstructor().getName().equals("Quoted")) {
                            IStrategoTerm constraint = quotedElem.getSubterm(0);
                            return new LayoutConstraintAttribute(
                                constraint.toString().substring(3, constraint.toString().length() - 3));
                        } else {
                            //TODO process non quoted constraint
                            IStrategoList subterms = (IStrategoList) appl.getSubterm(1);
                            System.out.println("process non quoted constraint");
                        }
                    } else {
                        String attrName = ((StrategoString) quoted.getSubterm(0)).stringValue();
                        List<String> elems = Lists.newArrayList();
                        IStrategoList subterms = (IStrategoList) appl.getSubterm(1);
                        for(IStrategoTerm elem : subterms) {
                            String elem_name = ((StrategoString) elem.getSubterm(0).getSubterm(0)).stringValue();
                            elems.add(elem_name);
                        }
                        return new TermAttribute(attrName, elems);
                    }
                default:
                    System.err.println("sdf2table : importAttribute: unknown attribute `" + a.getName() + "'.");
                    throw new UnexpectedTermException(a.toString());
            }

        }

        return null;
    }

    private static void addRestrictions(NormGrammar g, StrategoAppl tsection) throws UnexpectedTermException {
        if(tsection instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) tsection;
            if(app.getName().equals("Restrictions")) {
                StrategoList restrictions = (StrategoList) app.getSubterm(0);
                for(IStrategoTerm restriction : restrictions) {
                    processRestriction(g, restriction);
                }
            }
        }
    }

    private static void processRestriction(NormGrammar g, IStrategoTerm restriction) throws UnexpectedTermException {
        if(restriction instanceof StrategoAppl) {
            StrategoAppl res = (StrategoAppl) restriction;
            switch(res.getName()) {
                case "Follow":
                    Set<Symbol> ccs = importLookaheadList(res.getSubterm(1));
                    StrategoList subjects = (StrategoList) res.getSubterm(0);
                    for(IStrategoTerm subject : subjects) {
                        Symbol s = processSymbol(g, subject);
                        s.followRestriction().addAll(ccs);
                    }
                    break;
                default:
                    throw new UnexpectedTermException(res.getName());
            }
        } else {
            throw new UnexpectedTermException(restriction.toString());
        }
    }

    public static Set<Symbol> importLookaheadList(IStrategoTerm term) throws UnexpectedTermException {
        Set<Symbol> set = Sets.newHashSet();

        StrategoList slist;

        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            switch(app.getName()) {
                case "List":
                    slist = (StrategoList) app.getSubterm(0);
                    for(IStrategoTerm t : slist) {
                        Set<Symbol> ccs = importLookaheadList(t);
                        for(Symbol cc : ccs) {
                            set.add(cc);
                        }
                    }
                    break;
                // NON TERMINALS
                case "Seq":
                    Symbol head = processCharClass(app.getSubterm(0));
                    set.add(new CharacterClassSeq(head, importLookaheadList(app.getSubterm(1))));

                    break;
                // TERMINALS
                case "CharClass":
                    set.add(processCharClass(app.getSubterm(0)));
                    break;
                default:
                    throw new UnexpectedTermException(app.toString(), "List or Seq or CharClass");
            }
        }
        return set;
    }

    private static void addPriorities(NormGrammar g, StrategoAppl tsection) throws Exception {
        if(tsection instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) tsection;
            if(app.getName().equals("Priorities")) {
                StrategoList chains = (StrategoList) app.getSubterm(0);
                for(IStrategoTerm chain : chains) {
                    processPriorityChain(g, chain);
                }
            }
        }
    }

    private static void processPriorityChain(NormGrammar g, IStrategoTerm chain) throws Exception {
        if(chain instanceof IStrategoAppl && ((StrategoAppl) chain).getName().equals("Chain")) {
            StrategoList groups = (StrategoList) chain.getSubterm(0);
            IProduction higher = null, lower = null;
            boolean transitive = true;
            List<Integer> arguments = Lists.newArrayList();

            if(groups.size() != 2) {
                throw new Exception("Expecting only binary priority relations");
            }

            IStrategoTerm first_group = groups.getSubterm(0);

            if(first_group instanceof StrategoAppl && ((StrategoAppl) first_group).getName().equals("NonTransitive")) {
                transitive = false;
                first_group = first_group.getSubterm(0);
            }

            if(first_group instanceof StrategoAppl && ((StrategoAppl) first_group).getName().equals("WithArguments")) {
                StrategoAppl priority_args = (StrategoAppl) first_group.getSubterm(1);
                if(!priority_args.getName().equals("Default")) {
                    throw new UnexpectedTermException(priority_args.toString(), "Default");
                }
                StrategoList positions = (StrategoList) priority_args.getSubterm(0);
                for(IStrategoTerm pos : positions.getAllSubterms()) {
                    if(pos instanceof StrategoString) {
                        arguments.add(Integer.parseInt(((StrategoString) pos).stringValue()));
                    } else {
                        throw new UnexpectedTermException(pos.toString(), "Argument Position");
                    }
                }
                first_group = first_group.getSubterm(0);

                // the order of terms can be NonTransitive(WithArguments(*)) or WithArguments(NonTransitive(*))
                if(first_group instanceof StrategoAppl
                    && ((StrategoAppl) first_group).getName().equals("NonTransitive")) {
                    transitive = false;
                    first_group = first_group.getSubterm(0);
                }
            }

            if(first_group instanceof StrategoAppl && ((StrategoAppl) first_group).getName().equals("SimpleGroup")) {
                higher = processProduction(g, first_group.getSubterm(0));
            } else {
                throw new Exception("Normalized priority relation should be on SimpleGroups only.");
            }

            IStrategoTerm second_group = groups.getSubterm(1);

            if(second_group instanceof StrategoAppl && ((StrategoAppl) second_group).getName().equals("SimpleGroup")) {
                lower = processProduction(g, second_group.getSubterm(0));
            } else {
                throw new Exception("Normalized priority relation should be on SimpleGroups only.");
            }

            Priority p = new Priority(higher, lower, transitive);

            if(transitive) {
                g.transitive_prio.add(p);
                g.prio_prods.add(higher);
                g.prio_prods.add(lower);

                if(arguments.isEmpty()) {
                    g.trans_prio_arguments.put(p, -1);
                } else {
                    for(Integer arg : arguments) {
                        g.trans_prio_arguments.put(p, arg);
                    }
                }


            } else {
                g.non_transitive_prio.add(p);
                if(arguments.isEmpty()) {
                    g.trans_prio_arguments.put(p, -1);
                } else {
                    for(Integer arg : arguments) {
                        g.trans_prio_arguments.put(p, arg);
                    }
                }
            }

        }
    }



    private static IStrategoTerm termFromFile(File file, ITermFactory termFactory) {
        FileReader reader = null;
        IStrategoTerm term = null;

        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            String aterm = new String(chars);
            reader.close();

            term = termFactory.parseFromString(aterm);
        } catch(IOException e) {
            System.err.println("Cannot open module file `" + file.getPath() + "'");
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return term;
    }

}
