package org.metaborg.sdf2table.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.sdf2table.exceptions.ModuleNotFoundException;
import org.metaborg.sdf2table.exceptions.UnexpectedTermException;
import org.metaborg.sdf2table.grammar.AltSymbol;
import org.metaborg.sdf2table.grammar.CharacterClass;
import org.metaborg.sdf2table.grammar.ConstructorAttribute;
import org.metaborg.sdf2table.grammar.ContextFreeSymbol;
import org.metaborg.sdf2table.grammar.DeprecatedAttribute;
import org.metaborg.sdf2table.grammar.FileStartSymbol;
import org.metaborg.sdf2table.grammar.GeneralAttribute;
import org.metaborg.sdf2table.grammar.IAttribute;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.IterSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSepSymbol;
import org.metaborg.sdf2table.grammar.IterStarSymbol;
import org.metaborg.sdf2table.grammar.IterSymbol;
import org.metaborg.sdf2table.grammar.Layout;
import org.metaborg.sdf2table.grammar.LayoutConstraintAttribute;
import org.metaborg.sdf2table.grammar.LexicalSymbol;
import org.metaborg.sdf2table.grammar.LiteralType;
import org.metaborg.sdf2table.grammar.NormGrammar;
import org.metaborg.sdf2table.grammar.OptionalSymbol;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.ProductionReference;
import org.metaborg.sdf2table.grammar.SequenceSymbol;
import org.metaborg.sdf2table.grammar.Sort;
import org.metaborg.sdf2table.grammar.StartSymbol;
import org.metaborg.sdf2table.grammar.Symbol;
import org.metaborg.sdf2table.grammar.TermAttribute;
import org.metaborg.sdf2table.grammar.UniqueProduction;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoString;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class GrammarReader {

    public NormGrammar readGrammar(File input, List<String> paths) throws Exception {
        Map<String, Boolean> modules = Maps.newHashMap();
        NormGrammar grammar = new NormGrammar();

        IStrategoTerm mainModule = termFromFile(input, grammar);
        generateGrammar(grammar, mainModule, modules, paths);
        grammar.priorityTransitiveClosure();
        grammar.normalizeFollowRestrictionLookahead();

        return grammar;
    }

    private void generateGrammar(NormGrammar g, IStrategoTerm module, Map<String, Boolean> modules, List<String> paths)
        throws Exception {

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
                                    IStrategoTerm iModule = null;
                                    for(String path : paths) {
                                        String filename = path + "/" + iname + ".aterm";
                                        File file = new File(filename);
                                        if(file.exists() && !file.isDirectory()) {
                                            iModule = termFromFile(file, g);
                                            generateGrammar(g, iModule, modules, paths);
                                            break;
                                        }
                                    }
                                    if(iModule == null) {
                                        throw new ModuleNotFoundException(iname, modName);
                                    }
                                }

                            }
                        }
                    }
                }

                // Processing sections
                StrategoList sdf_sections = (StrategoList) app.getSubterm(2);
                for(IStrategoTerm t : sdf_sections) {
                    StrategoAppl tsection = null;
                    if(!(t.getSubterm(0) instanceof StrategoAppl))
                        continue;
                    try {
                        tsection = (StrategoAppl) t.getSubterm(0);
                    } catch(Exception e) {
                        System.out.println("here");
                    }
                    switch(tsection.getName()) {
                        case "ContextFreeSyntax":
                            addProds(g, tsection);
                            break;
                        case "LexicalSyntax":
                            addProds(g, tsection);
                            break;
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

    private void addProds(NormGrammar g, StrategoAppl section) throws Exception {
        if(section instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) section;

            if(app.getName().equals("ContextFreeSyntax")) {
                StrategoList sdf_productions = (StrategoList) app.getSubterm(0);
                for(IStrategoTerm t : sdf_productions) {
                    processProduction(g, t);
                }
            }
            if(app.getName().equals("LexicalSyntax")) {
                StrategoList sdf_productions = (StrategoList) app.getSubterm(0);
                for(IStrategoTerm t : sdf_productions) {
                    processProduction(g, t);
                }
            }

            else if(app.getName().equals("Kernel")) {
                StrategoList sdf_productions = (StrategoList) app.getSubterm(0);
                for(IStrategoTerm t : sdf_productions) {
                    processProduction(g, t);
                }
            }
        }
    }

    private IProduction processProduction(NormGrammar g, IStrategoTerm term) throws Exception {
        IProduction prod = null;
        prod = g.getCacheProductionsRead().get(term.toString());

        if(prod != null) {
            return prod;
        }

        if(term instanceof IStrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            boolean with_cons = false;
            if(app.getName().equals("SdfProduction")
                || (with_cons = true && app.getName().equals("SdfProductionWithCons"))) {
                Symbol symbol;
                String cons = null;
                ConstructorAttribute cons_attr = null;
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
                            if(attr != null) {
                                attrs.add(attr);
                            }
                        }
                        break;
                    default:
                        throw new UnexpectedTermException(term.toString(), "Attributes");
                }

                if(cons != null) {
                    cons_attr = new ConstructorAttribute(cons);
                    attrs.add(cons_attr);
                }

                UniqueProduction unique_prod = new UniqueProduction(symbol, rhs_symbols);

                prod = g.getUniqueProductionMapping().get(unique_prod);

                // production already exists
                if(prod != null) {
                    for(IAttribute a : attrs) {
                        g.getProductionAttributesMapping().put(prod, a);
                    }

                    if(g != null && symbol != null) {
                        g.getCacheProductionsRead().put(term.toString(), prod);
                    }

                    return prod;
                }

                // processing a new production
                prod = new Production(symbol, rhs_symbols);

                if(cons_attr != null) {
                    g.getSortConsProductionMapping().put(new ProductionReference(symbol, cons_attr), prod);
                }

                if(symbol instanceof FileStartSymbol && g.getInitialProduction() == null) {
                    g.setInitialProduction(prod);
                }

                for(IAttribute a : attrs) {
                    if(a.toString().equals("nlm")) {
                        g.getLongestMatchProds().put(prod.rightHand().get(prod.rightHand().size() - 1), prod);
                    }
                    g.getProductionAttributesMapping().put(prod, a);
                }

                if(g != null && symbol != null) {
                    g.getCacheProductionsRead().put(term.toString(), prod);
                }

                g.getSymbolProductionsMapping().put(symbol, prod);
                g.getUniqueProductionMapping().put(unique_prod, prod);

                return prod;
            } else {
                throw new UnexpectedTermException(term.toString(), "SdfProduction");
            }
        }
        throw new UnexpectedTermException(term.toString(), "SdfProduction");
    }

    private Symbol processSymbol(NormGrammar g, IStrategoTerm term) {
        Symbol symbol = null;
        String enquoted;

        symbol = g.getCacheSymbolsRead().get(term.toString());

        if(symbol != null) {
            g.getSymbols().add(symbol);
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
            g.getCacheSymbolsRead().put(term.toString(), symbol);
        }

        g.getSymbols().add(symbol);
        return symbol;
    }


    public List<Symbol> processSymbolList(NormGrammar g, IStrategoTerm term) {
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

    public ICharacterClass processCharClass(IStrategoTerm term) {
        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            CharacterClassFactory ccFactory = ParseTableGenerator.getCharacterClassFactory();
            switch(app.getName()) {
                case "Absent":
                    return ccFactory.fromEmpty();
                case "Simple":
                    return processCharClass(app.getSubterm(0));
                case "Present":
                    return processCharClass(app.getSubterm(0));
                case "Range":
                    String strStart = ((StrategoString) app.getSubterm(0).getSubterm(0)).stringValue();
                    String strEnd = ((StrategoString) app.getSubterm(1).getSubterm(0)).stringValue();
                    int start = Integer.parseInt(strStart.substring(1));
                    int end = Integer.parseInt(strEnd.substring(1));
                    return ccFactory.fromRange(start, end);
                case "Numeric":
                    String str = ((StrategoString) app.getSubterm(0)).stringValue();
                    return ccFactory.fromSingle(Integer.parseInt(str.substring(1)));
                case "Conc":
                    ICharacterClass head = processCharClass(app.getSubterm(0));
                    return ccFactory.union(head, processCharClass(app.getSubterm(1)));
                default:
                    System.err.println("Unknown character class `" + app.getName() + "'. Is that normalized SDF3?");
                    return ccFactory.fromEmpty();
            }
        }

        System.err.println("Malformed term. Application expected.");
        return null;
    }

    private IAttribute processAttribute(IStrategoTerm ta) throws Exception {
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
                case "Recover":
                    return new GeneralAttribute("recover");
                case "Reject":
                    return new GeneralAttribute("reject");
                case "Prefer":
                    return new GeneralAttribute("prefer");
                case "Avoid":
                    return new GeneralAttribute("avoid");
                case "Bracket":
                    return new GeneralAttribute("bracket");
                case "LayoutConstraint":
                    return new LayoutConstraintAttribute(a.getSubterm(0));
                case "IgnoreLayout":
                    return new LayoutConstraintAttribute(a);
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
                case "NewLongestMatch":
                    return new GeneralAttribute("nlm");
                case "Term":
                    IStrategoTerm def = a.getSubterm(0);
                    IStrategoAppl term = (IStrategoAppl) def.getSubterm(0);
                    try {
                        if(term.toString().equals("Fun(Unquoted(\"recover\"))")) {
                            return new GeneralAttribute("recover");
                        }
                        IStrategoTerm termAttribute = createStrategoTermAttribute(term);
                        return new TermAttribute(termAttribute, termAttribute.toString());
                    } catch(Exception e) {
                        System.err
                            .println("sdf2table : importAttribute: unknown term attribute `" + a.getName() + "'.");
                        throw new UnexpectedTermException(a.toString());
                    }
                default:
                    System.err.println("sdf2table : importAttribute: unknown attribute `" + a.getName() + "'.");
                    throw new UnexpectedTermException(a.toString());
            }

        }

        return null;
    }

    private IStrategoTerm createStrategoTermAttribute(IStrategoAppl term) throws UnexpectedTermException {
        ITermFactory termFactory = ParseTableGenerator.getTermfactory();
        if(term.getConstructor().getName().equals("Appl")) {
            String cons_name = ((IStrategoString) term.getSubterm(0).getSubterm(0)).stringValue();
            int arity = term.getSubterm(1).getSubtermCount();
            IStrategoTerm[] subterms = new IStrategoTerm[arity];
            for(int i = 0; i < arity; i++) {
                IStrategoTerm child = ((IStrategoList) term.getSubterm(1)).getSubterm(i);
                subterms[i] = createStrategoTermAttribute((IStrategoAppl) child);
            }
            return termFactory.makeAppl(termFactory.makeConstructor(cons_name, arity), subterms);
        } else if(term.getConstructor().getName().equals("Fun")) {
            String termName = ((IStrategoString) term.getSubterm(0).getSubterm(0)).stringValue();
            if(((IStrategoAppl) term.getSubterm(0)).getConstructor().getName().equals("Quoted")) {
                termName = termName.replace("\\\"", "\"").replace("\\\\", "\\").replace("\\'", "\'").substring(1,
                    termName.length() - 1);
            }
            return termFactory.makeString(termName);
        } else if(term.getConstructor().getName().equals("Int")) {
            String svalue = ((IStrategoString) term.getSubterm(0).getSubterm(0)).stringValue();
            int ivalue = Integer.parseInt(svalue);
            return termFactory.makeInt(ivalue);
        } else if(term.getConstructor().getName().equals("List")) {
            IStrategoList term_list = (IStrategoList) term.getSubterm(0);
            List<IStrategoTerm> terms = Lists.newArrayList();
            for(IStrategoTerm t : term_list) {
                terms.add(createStrategoTermAttribute((IStrategoAppl) t));
            }
            return termFactory.makeList(terms);
        }
        System.err.println("sdf2table : importAttribute: unknown stratego term attribute `" + term.getName() + "'.");
        throw new UnexpectedTermException(term.toString());
    }

    private void addRestrictions(NormGrammar g, StrategoAppl tsection) throws UnexpectedTermException {
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

    private void processRestriction(NormGrammar g, IStrategoTerm restriction) throws UnexpectedTermException {
        if(restriction instanceof StrategoAppl) {
            StrategoAppl res = (StrategoAppl) restriction;
            switch(res.getName()) {
                case "Follow":
                    List<CharacterClass[]> restrictionLookahead = Lists.newArrayList();
                    CharacterClass restrictionNoLookahead =
                        importFollowRestriction(res.getSubterm(1), restrictionLookahead);
                    StrategoList subjects = (StrategoList) res.getSubterm(0);
                    for(IStrategoTerm subject : subjects) {
                        Symbol s = processSymbol(g, subject);
                        s.addFollowRestriction(restrictionNoLookahead);
                        s.addFollowRestrictionsLookahead(restrictionLookahead);
                    }
                    break;
                default:
                    throw new UnexpectedTermException(res.getName());
            }
        } else {
            throw new UnexpectedTermException(restriction.toString());
        }
    }

    public CharacterClass importFollowRestriction(IStrategoTerm term, List<CharacterClass[]> restrictionsLookahead)
        throws UnexpectedTermException {
        StrategoList slist;

        CharacterClass restriction = new CharacterClass(null);

        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            switch(app.getName()) {
                case "List":
                    slist = (StrategoList) app.getSubterm(0);
                    for(IStrategoTerm t : slist) {
                        restriction =
                            CharacterClass.union(importFollowRestriction(t, restrictionsLookahead), restriction);
                    }
                    break;
                // NON TERMINALS
                case "Seq":
                    List<CharacterClass> lookahead =
                        Lists.newArrayList(new CharacterClass(processCharClass(app.getSubterm(0))));
                    createNewLookahead(app.getSubterm(1), lookahead, restrictionsLookahead);
                    break;
                // TERMINALS
                case "CharClass":
                    restriction =
                        CharacterClass.union(restriction, new CharacterClass(processCharClass(app.getSubterm(0))));
                    break;
                default:
                    throw new UnexpectedTermException(app.toString(), "List or Seq or CharClass");
            }
        }

        return restriction;
    }

    private void createNewLookahead(IStrategoTerm term, List<CharacterClass> lookahead,
        List<CharacterClass[]> restrictionsLookahead) throws UnexpectedTermException {

        StrategoList slist;

        if(term instanceof StrategoAppl) {
            StrategoAppl app = (StrategoAppl) term;
            switch(app.getName()) {
                case "List":
                    slist = (StrategoList) app.getSubterm(0);
                    for(IStrategoTerm t : slist) {
                        List<CharacterClass> firstChars = Lists.newArrayList(lookahead);
                        createNewLookahead(t, firstChars, restrictionsLookahead);
                    }
                    break;
                // NON TERMINALS
                case "Seq":
                    lookahead.add(new CharacterClass(processCharClass(app.getSubterm(0))));
                    createNewLookahead(app.getSubterm(1), lookahead, restrictionsLookahead);
                    break;
                // TERMINALS
                case "CharClass":
                    CharacterClass lastChar = new CharacterClass(processCharClass(app.getSubterm(0)));
                    lookahead.add(lastChar);
                    restrictionsLookahead.add(lookahead.toArray(new CharacterClass[lookahead.size()]));
                    break;
                default:
                    throw new UnexpectedTermException(app.toString(), "List or Seq or CharClass");
            }
        }

    }



    private void addPriorities(NormGrammar g, StrategoAppl tsection) throws Exception {
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

    private void processPriorityChain(NormGrammar g, IStrategoTerm chain) throws Exception {
        if(chain instanceof IStrategoAppl && ((StrategoAppl) chain).getName().equals("Chain")) {
            StrategoList groups = (StrategoList) chain.getSubterm(0);
            IProduction higher = null, lower = null;
            boolean transitive = true;
            List<Integer> arguments = Lists.newArrayList();

            if(groups.size() != 2) {
                throw new Exception("Unexpected normalized priority: " + chain.toString()
                    + ".\nExpecting only binary priority relations.");
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

            higher = processGroup(g, first_group);

            // in case the priority is Sort.Cons <arg> > p2
            if(first_group instanceof StrategoAppl && ((StrategoAppl) first_group).getName().equals("SimpleRefGroup")) {
                arguments = normalizePriorityArguments(higher, arguments);
            }

            IStrategoTerm second_group = groups.getSubterm(1);

            if(second_group instanceof StrategoAppl
                && ((StrategoAppl) second_group).getName().equals("NonTransitive")) {
                second_group = second_group.getSubterm(0);
            }

            if(second_group instanceof StrategoAppl
                && ((StrategoAppl) second_group).getName().equals("WithArguments")) {

                second_group = second_group.getSubterm(0);

                // the order of terms can be NonTransitive(WithArguments(*)) or WithArguments(NonTransitive(*))
                if(second_group instanceof StrategoAppl
                    && ((StrategoAppl) second_group).getName().equals("NonTransitive")) {
                    second_group = second_group.getSubterm(0);
                }
            }

            lower = processGroup(g, second_group);

            Priority p = new Priority(higher, lower, transitive);

            if(transitive) {
                g.getTransitivePriorities().add(p);
                g.getProductionsOnPriorities().add(higher);
                g.getProductionsOnPriorities().add(lower);

                if(arguments.isEmpty()) {
                    g.getTransitivePriorityArgs().put(p, -1);
                } else {
                    for(Integer arg : arguments) {
                        g.getTransitivePriorityArgs().put(p, arg);
                    }
                }
            } else {
                g.getNonTransitivePriorities().add(p);
                if(arguments.isEmpty()) {
                    g.getNonTransitivePriorityArgs().put(p, -1);
                } else {
                    for(Integer arg : arguments) {
                        g.getNonTransitivePriorityArgs().put(p, arg);
                    }
                }
            }

        } else if(chain instanceof IStrategoAppl && ((StrategoAppl) chain).getName().equals("Assoc")) {
            IStrategoTerm first_group = chain.getSubterm(0);
            IStrategoTerm assoc = chain.getSubterm(1);
            IStrategoTerm second_group = chain.getSubterm(2);


            IProduction higher = processGroup(g, first_group);
            IProduction lower = processGroup(g, second_group);

            Priority p = new Priority(higher, lower, false);

            g.getNonTransitivePriorities().add(p);

            // actual argument values will be processed later when defining recursion
            if(assoc.toString().contains("Left")) {
                g.getNonTransitivePriorityArgs().put(p, Integer.MAX_VALUE);
            } else if(assoc.toString().contains("Right")) {
                g.getNonTransitivePriorityArgs().put(p, Integer.MIN_VALUE);
            } else {
                g.getNonTransitivePriorityArgs().put(p, Integer.MIN_VALUE);
                g.getNonTransitivePriorityArgs().put(p, Integer.MAX_VALUE);
            }

        } else {
            throw new UnexpectedTermException(chain.toString(), "Chain or Assoc");
        }
    }

    private List<Integer> normalizePriorityArguments(IProduction production, List<Integer> arguments) {
        Symbol optLayout = new ContextFreeSymbol(new OptionalSymbol(new Layout()));
        List<Integer> norm_arguments = Lists.newArrayList();
        for(int arg : arguments) {
            int norm_arg = 0;
            for(Symbol s : production.rightHand()) {
                if(arg == 0 && norm_arg == 0) {
                    norm_arguments.add(norm_arg);
                    break;
                }
                if(arg == 0) {
                    norm_arg++;
                    norm_arguments.add(norm_arg);
                    break;
                }
                if(!s.equals(optLayout)) {
                    arg--;
                }
                norm_arg++;
            }
        }

        arguments = norm_arguments;
        return arguments;
    }

    private IProduction processGroup(NormGrammar g, IStrategoTerm group) throws UnexpectedTermException, Exception {

        IProduction production = null;

        if(group instanceof StrategoAppl && ((StrategoAppl) group).getName().equals("SimpleGroup")) {
            production = processProduction(g, group.getSubterm(0));
        } else if(group instanceof StrategoAppl && ((StrategoAppl) group).getName().equals("SimpleRefGroup")) {
            IStrategoTerm sort = group.getSubterm(0).getSubterm(0);
            IStrategoTerm constructor = group.getSubterm(0).getSubterm(1);
            String cons_name = ((IStrategoString) constructor.getSubterm(0)).stringValue();

            ProductionReference prod_ref =
                new ProductionReference(processSymbol(g, sort), new ConstructorAttribute(cons_name));

            production = g.getSortConsProductionMapping().get(prod_ref);
            if(production == null) {
                throw new Exception("Production referenced by " + prod_ref + " could not be found.");
            }
        } else {
            throw new Exception("Normalized priority relation should be on SimpleGroups only.");
        }

        if(production == null) {
            throw new Exception("Group " + group + " could not be processed.");
        }
        return production;
    }

    private IStrategoTerm termFromFile(File file, NormGrammar grammar) throws Exception {
        FileReader reader = null;
        IStrategoTerm term = null;
        ITermFactory termFactory = ParseTableGenerator.getTermfactory();

        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            String aterm = new String(chars);
            reader.close();

            term = termFactory.parseFromString(aterm);
            grammar.getFilesRead().add(file);
        } catch(IOException e) {
            throw new Exception(
                "Cannot open module file '" + file.getPath() + "'. Try cleaning the project and rebuilding.");
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
