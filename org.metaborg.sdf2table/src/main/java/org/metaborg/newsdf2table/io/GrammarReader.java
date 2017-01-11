package org.metaborg.newsdf2table.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
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
import org.metaborg.newsdf2table.grammar.ContextFreeSymbol;
import org.metaborg.newsdf2table.grammar.DeprecatedAttribute;
import org.metaborg.newsdf2table.grammar.FileStartSymbol;
import org.metaborg.newsdf2table.grammar.GeneralAttribute;
import org.metaborg.newsdf2table.grammar.IAttribute;
import org.metaborg.newsdf2table.grammar.IPriority;
import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.IRestriction;
import org.metaborg.newsdf2table.grammar.IterSepSymbol;
import org.metaborg.newsdf2table.grammar.IterStarSepSymbol;
import org.metaborg.newsdf2table.grammar.IterStarSymbol;
import org.metaborg.newsdf2table.grammar.IterSymbol;
import org.metaborg.newsdf2table.grammar.Layout;
import org.metaborg.newsdf2table.grammar.LayoutConstraintAttribute;
import org.metaborg.newsdf2table.grammar.LexicalSymbol;
import org.metaborg.newsdf2table.grammar.LiteralType;
import org.metaborg.newsdf2table.grammar.NonTerminal;
import org.metaborg.newsdf2table.grammar.NormGrammar;
import org.metaborg.newsdf2table.grammar.OptionalSymbol;
import org.metaborg.newsdf2table.grammar.Production;
import org.metaborg.newsdf2table.grammar.SequenceSymbol;
import org.metaborg.newsdf2table.grammar.StartSymbol;
import org.metaborg.newsdf2table.grammar.Symbol;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;
import org.spoofax.terms.TermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class GrammarReader {

    

    public static NormGrammar readGrammar(File input, File output, List<String> paths, ITermFactory termFactory) throws Exception {
        Map<String, Boolean> modules = new HashMap<>();

        Set<IProduction> prods = Sets.newHashSet();
        Set<IRestriction> rests = Sets.newHashSet();
        Set<IPriority> prios = Sets.newHashSet();

        IStrategoTerm mainModule = termFromFile(input, termFactory);

        NormGrammar grammar = new NormGrammar(prods, rests, prios);

        generateGrammar(grammar, mainModule, modules, paths, termFactory);
        grammar.mergeProductionAttributes();

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
                    processProduction(g, t);
                }
            }
        }
    }

    private static void processProduction(NormGrammar g, IStrategoTerm term) throws UnexpectedTermException {
        if(term instanceof IStrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            boolean with_cons = false;
            if(app.getName().equals("SdfProduction")
                || (with_cons = true && app.getName().equals("SdfProductionWithCons"))) {
                Symbol symbol;
                String cons = null;
                List<Symbol> rhs_symbols = Lists.newLinkedList();
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


                Production prod = new Production(symbol, cons, rhs_symbols);

                g.prods.add(prod);
                g.prod_attrs.put(prod, attrs);


            } else {
                throw new UnexpectedTermException(term.toString(), "SdfProduction");
            }
        }
    }

    private static Symbol processSymbol(NormGrammar g, IStrategoTerm term) {
        Symbol symbol;
        String enquoted;

        symbol = g.symbols.get(term);

        if(symbol != null) {
            return symbol;
        }

        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            switch(app.getName()) {
                case "SortDef":
                    symbol = new NonTerminal(((StrategoString) app.getSubterm(0)).stringValue());
                    break;
                case "Sort":
                    symbol = new NonTerminal(((StrategoString) app.getSubterm(0)).stringValue());
                    break;
                case "Layout":
                    symbol = new Layout();
                    break;
                case "CharClass":
                    symbol = new CharacterClass(processCharClass(term.getSubterm(0)));
                    break;
                case "Lit":
                    enquoted = ((StrategoString) app.getSubterm(0)).stringValue();
                    symbol = new NonTerminal(enquoted.substring(1, enquoted.length() - 1), LiteralType.Lit);
                    break;
                case "CiLit":
                    enquoted = ((StrategoString) app.getSubterm(0)).stringValue();
                    symbol = new NonTerminal(enquoted.substring(1, enquoted.length() - 1), LiteralType.CiLit);
                    break;
                case "Opt":
                    symbol = new OptionalSymbol(processSymbol(g, app.getSubterm(0)));
                    break;
                case "Alt":
                    symbol = new AltSymbol(processSymbol(g, app.getSubterm(0)), processSymbol(g, app.getSubterm(1)));
                    break;
                case "Sequence":
                    symbol = new SequenceSymbol(processSymbol(g, app.getSubterm(0)),
                        processSymbolList(null, app.getSubterm(1)));
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
            g.symbols.put(term, symbol);
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
                    System.err.println("sdf2table : importAttribute: unhandled term attribute."); // TODO
                    throw new UnexpectedTermException(a.toString());
                default:
                    System.err.println("sdf2table : importAttribute: unknown attribute `" + a.getName() + "'.");
                    throw new UnexpectedTermException(a.toString());
            }
        }

        return null;
    }

    private static void addRestrictions(NormGrammar g, StrategoAppl tsection) {
    }

    private static void addPriorities(NormGrammar g, StrategoAppl tsection) {
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
