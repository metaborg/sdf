package org.metaborg.sdf2table.io;

import static java.lang.Integer.parseInt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.metaborg.parsetable.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.sdf2table.exceptions.ModuleNotFoundException;
import org.metaborg.sdf2table.exceptions.UnexpectedTermException;
import org.metaborg.sdf2table.grammar.*;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.StrategoAppl;

import org.spoofax.terms.io.binary.TermReader;
import org.spoofax.terms.util.TermUtils;

import jakarta.annotation.Nullable;

public class NormGrammarReader {

    private final Map<String, IStrategoTerm> moduleAsts;
    private final Set<String> processedModules;
    private final NormGrammar grammar;
    private final List<String> paths;
    private final Collection<FileVisitor> fileVisitors;
    private final List<IStrategoAppl> prioritySections;
    private final GrammarFactory gf;

    public NormGrammarReader() {
        this.moduleAsts = new HashMap<>();
        this.processedModules = new HashSet<>();
        this.grammar = new NormGrammar();
        this.paths = Collections.emptyList();
        this.fileVisitors = new LinkedList<>();
        this.prioritySections = new ArrayList<>();
        this.gf = grammar.getGrammarFactory();
    }

    public NormGrammarReader(List<String> paths) {
        this.moduleAsts = new HashMap<>();
        this.processedModules = new HashSet<>();
        this.grammar = new NormGrammar();
        this.paths = paths;
        this.fileVisitors = new LinkedList<>();
        this.prioritySections = new ArrayList<>();
        this.gf = grammar.getGrammarFactory();
    }

    public interface FileVisitor {
        void visit(File file);
    }

    public void accept(FileVisitor fileVisitor) {
        this.fileVisitors.add(fileVisitor);
    }

    public void addModuleAst(IStrategoTerm module) {
        if(module instanceof IStrategoAppl) {
            IStrategoAppl app = (IStrategoAppl) module;
            if(app.getName().equals("Module")) {
                String modName = moduleName(app);
                moduleAsts.put(modName, module);
                grammar.getModulesRead().add(modName);
            }
        }
    }

    public NormGrammar readGrammar(File input) throws Exception {
        return readGrammar(termFromFile(input));
    }

    public NormGrammar readGrammar(IStrategoTerm mainModule) throws Exception {
        readModule(mainModule);

        return getGrammar();
    }
    
    public NormGrammar getGrammar() throws Exception {
    	// only read priority sections after reading all productions to get constructor references
        for(IStrategoAppl section : prioritySections) {
            addPriorities(section);
        }

        grammar.priorityTransitiveClosure();
        grammar.normalizeFollowRestrictionLookahead();

        // treat indexed priorities separately
        normalizeIndexedPriorities();

        return grammar;
    }

    private void normalizeIndexedPriorities() {
        for(Priority p : grammar.priorities().keySet()) {
            for(Integer arg : grammar.priorities().get(p)) {
                if(arg != -1 && arg != Integer.MIN_VALUE && arg != Integer.MAX_VALUE) {
                    grammar.getIndexedPriorities().put(p, arg);
                }
            }
        }

        for(Priority p : grammar.getIndexedPriorities().keySet()) {
            for(Integer arg : grammar.getIndexedPriorities().get(p)) {
                grammar.priorities().remove(p, arg);
            }
        }
    }

    public void readModule(File input) throws Exception {
    	readModule(termFromFile(input));
    }

    public void readModule(IStrategoTerm module) throws Exception {
        if(module instanceof IStrategoAppl) {
            IStrategoAppl app = (IStrategoAppl) module;
            if(app.getName().equals("Module")) {
                // Module attributes
                String modName = moduleName(app);
                grammar.getModulesRead().add(modName);

                // Module has already been processed
                if(processedModules.contains(modName)) {
                    return;
                }

                // Processing module
                processedModules.add(modName);

                // Processing Dependencies
                for(IStrategoTerm t : TermUtils.toListAt(app, 1)) {
                    if(t instanceof IStrategoAppl && ((IStrategoAppl) t).getName().equals("Imports")) {
                        for(IStrategoTerm timport : TermUtils.toListAt(t, 0)) {
                            if(TermUtils.isAppl(timport, "Module")) {
                                @Nullable String iname = importName(timport);
                                // processing import in case it has not been processed yet
                                if(iname != null) {
                                    IStrategoTerm iModule = moduleAsts.get(iname);
                                    if(iModule == null) {
                                        for(String path : paths) {
                                            String filename = path + "/" + iname + ".aterm";
                                            File file = new File(filename);
                                            if(file.exists() && !file.isDirectory()) {
                                                iModule = termFromFile(file);
                                                break;
                                            }
                                        }
                                    }
                                    if(iModule == null) {
                                        throw new ModuleNotFoundException(iname, modName);
                                    }
                                    readModule(iModule);
                                }
                            }
                        }
                    }
                }

                // Processing sections
                IStrategoList sdf_sections = TermUtils.toListAt(app, 2);
                for(IStrategoTerm t : sdf_sections) {
                    IStrategoAppl tsection = null;
                    if(!(t.getSubterm(0) instanceof IStrategoAppl))
                        continue;
                    tsection = (IStrategoAppl) t.getSubterm(0);
                    switch(tsection.getName()) {
                        case "ContextFreeSyntax":
                            addProds(tsection);
                            break;
                        case "LexicalSyntax":
                            addProds(tsection);
                            break;
                        case "Kernel":
                            addProds(tsection);
                            break;
                        case "Restrictions":
                            addRestrictions(tsection);
                            break;
                        case "Priorities":
                            prioritySections.add(tsection);
                            break;
                        default:
                            System.err.println("Unknown module section `" + tsection.getName() + "'");
                            break;
                    }
                }

            }
        }
    }

    private void addProds(IStrategoAppl section) throws Exception {
        // Even looking at the history of this method, there is no reason for the code duplication
        //  in the bodies of the ifs. And given its current usage only in readModule, none of the
        //  if conditions are necessary either. But this is not my code, and I'm already doing other
        //  refactoring atm, so I'm not touching this. Braver souls: do simplify, but also test!
        if(TermUtils.isAppl(section, "ContextFreeSyntax")) {
            IStrategoList sdf_productions = TermUtils.toListAt(section, 0);
            for(IStrategoTerm t : sdf_productions) {
                processProduction(t);
            }
        } else if(TermUtils.isAppl(section, "LexicalSyntax")) {
            IStrategoList sdf_productions = TermUtils.toListAt(section, 0);
            for(IStrategoTerm t : sdf_productions) {
                processProduction(t);
            }
        } else if(TermUtils.isAppl(section, "Kernel")) {
            IStrategoList sdf_productions = TermUtils.toListAt(section, 0);
            for(IStrategoTerm t : sdf_productions) {
                processProduction(t);
            }
        }
    }

    private Production processProduction(IStrategoTerm term) throws Exception {
        Production prod = null;
        prod = grammar.getCacheProductionsRead().get(term.toString());


        if(prod != null) {
            return prod;
        }

        if(TermUtils.isAppl(term)) {
            IStrategoAppl app = (IStrategoAppl) term;
            boolean with_cons = false;
            if(app.getName().equals("SdfProduction")
                    // This is suspicious:
                || (with_cons = true && app.getName().equals("SdfProductionWithCons"))) {
                Symbol symbol;
                String cons = null;
                ConstructorAttribute cons_attr = null;
                List<Symbol> rhs_symbols = new ArrayList<>();
                Set<ISymbol> literals = new HashSet<ISymbol>();
                IStrategoAppl tattrs;

                if(with_cons) {
                    // SdfProductionWithCons(SortCons(<type>), Constructor("<cons>"), ...)
                    symbol = processSymbol(app.getSubterm(0).getSubterm(0));
                    cons = ((IStrategoString) app.getSubterm(0).getSubterm(1).getSubterm(0)).stringValue();
                } else {
                    symbol = processSymbol(app.getSubterm(0));
                }

                // Read right hand side of the equation: Rhs([<symbols>])
                IStrategoList rhs = TermUtils.toListAt(app.getSubterm(1), 0);
                for(IStrategoTerm t : rhs) {
                    Symbol s = processSymbol(t);
                    if(s != null)
                        rhs_symbols.add(s);
                    if(s instanceof Sort && ((Sort) s).getType() != null) {
                        literals.add(s);
                    }
                }

                // Read attributes
                tattrs = (IStrategoAppl) app.getSubterm(2);
                Set<IAttribute> attrs = new HashSet<IAttribute>();
                switch(tattrs.getName()) {
                    case "NoAttrs":
                        break;
                    case "Attrs":
                        IStrategoList talist = TermUtils.toListAt(tattrs, 0);
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
                    cons_attr = gf.createConstructorAttribute(cons);// new ConstructorAttribute(cons);
                    attrs.add(cons_attr);
                }

                UniqueProduction unique_prod = gf.createUniqueProduction(symbol, rhs_symbols);

                prod = grammar.getUniqueProductionMapping().get(unique_prod);

                // production already exists
                if(prod != null) {
                    for(IAttribute a : attrs) {
                        grammar.getProductionAttributesMapping().put(prod, a);
                    }

                    if(grammar != null && symbol != null) {
                        grammar.getCacheProductionsRead().put(term.toString(), prod);
                    }

                    return prod;
                }

                // processing a new production
                prod = gf.createProduction(symbol, rhs_symbols);
                for(ISymbol literal : literals) {
                    grammar.getLiteralProductionsMapping().put(literal, prod);
                }

                if(cons_attr != null) {
                    grammar.getSortConsProductionMapping().put(gf.createProductionReference(symbol, cons_attr), prod);
                }

                if(symbol instanceof FileStartSymbol && grammar.getInitialProduction() == null) {
                    grammar.setInitialProduction(prod);
                }

                for(IAttribute a : attrs) {
                    if(a.toString().equals("longest-match")) {
                        ISymbol lastSymbol = prod.rightHand().get(prod.arity() - 1);
                        ISymbol firstSymbol = prod.rightHand().get(0);

                        if(Symbol.isListNonTerminal(lastSymbol)) {
                            grammar.getLongestMatchProdsBack().put((Symbol) lastSymbol, prod);
                        }

                        else if(Symbol.isListNonTerminal(firstSymbol)) {
                            grammar.getLongestMatchProdsFront().put((Symbol) firstSymbol, prod);
                        }
                    }
                    if(a.toString().equals("shortest-match")) {
                        ISymbol lastSymbol = prod.rightHand().get(prod.arity() - 1);
                        ISymbol firstSymbol = prod.rightHand().get(0);

                        if(Symbol.isListNonTerminal(lastSymbol)) {
                            grammar.getShortestMatchProdsBack().put((Symbol) lastSymbol, prod);
                        }

                        else if(Symbol.isListNonTerminal(firstSymbol)) {
                            grammar.getShortestMatchProdsFront().put((Symbol) firstSymbol, prod);
                        }
                    }

                    grammar.getProductionAttributesMapping().put(prod, a);

                }

                if(grammar != null && symbol != null) {
                    grammar.getCacheProductionsRead().put(term.toString(), prod);
                }

                grammar.getSymbolProductionsMapping().put(symbol, prod);
                grammar.getUniqueProductionMapping().put(unique_prod, prod);

                if(cons != null) {
                    grammar.getConstructors().put(prod, cons_attr);
                }

                return prod;
            } else {
                throw new UnexpectedTermException(term.toString(), "SdfProduction");
            }
        }
        throw new UnexpectedTermException(term.toString(), "SdfProduction");
    }

    private Symbol processSymbol(IStrategoTerm term) {
        Symbol symbol = null;
        String enquoted;

        term = removeLabelFromSymbolTerm(term);
        symbol = grammar.getCacheSymbolsRead().get(term.toString());

        if(symbol != null) {
            grammar.getSymbols().add(symbol);
            return symbol;
        }

        if(term instanceof IStrategoAppl) {
            IStrategoAppl app = TermUtils.toAppl(term);
            Sort sep;
            switch(app.getName()) {
                case "SortDef":
                case "Sort":
                    symbol = gf.createSort(((IStrategoString) app.getSubterm(0)).stringValue());
                    break;
                case "Layout":
                    symbol = gf.createLayoutSymbol();
                    break;
                case "CharClass":
                    symbol = gf.createCharClassSymbol(processCharClass(term.getSubterm(0)));// new
                                                                                            // CharacterClassSymbol(processCharClass(term.getSubterm(0)));
                    break;
                case "Lit":
                    enquoted = ((IStrategoString) app.getSubterm(0)).stringValue();
                    symbol = gf.createSort(enquoted.substring(1, enquoted.length() - 1), LiteralType.Lit);
                    break;
                case "CiLit":
                    enquoted = ((IStrategoString) app.getSubterm(0)).stringValue();
                    symbol = gf.createSort(enquoted.substring(1, enquoted.length() - 1), LiteralType.CiLit);
                    break;
                case "Opt":
                    symbol = gf.createOptionalSymbol(processSymbol(app.getSubterm(0)));
                    break;
                case "Alt":
                    symbol = gf.createAltSymbol(processSymbol(app.getSubterm(0)), processSymbol(app.getSubterm(1)));// new
                                                                                                                    // AltSymbol
                    break;
                case "Sequence":
                    symbol =
                        gf.createSequenceSymbol(processSymbol(app.getSubterm(0)), processSymbolList(app.getSubterm(1)));
                    break;
                case "Iter":
                    symbol = gf.createIterSymbol(processSymbol(app.getSubterm(0)));
                    break;
                case "IterStar":
                    symbol = gf.createIterStarSymbol(processSymbol(app.getSubterm(0)));
                    break;
                case "IterSep":
                    sep = (Sort) processSymbol(app.getSubterm(1));
                    symbol = gf.createIterSepSymbol(processSymbol(app.getSubterm(0)), sep);
                    break;
                case "IterStarSep":
                    sep = (Sort) processSymbol(app.getSubterm(1));
                    symbol = gf.createIterStarSepSymbol(processSymbol(app.getSubterm(0)), sep);
                    break;
                case "Lex":
                    symbol = gf.createLexicalSymbol(processSymbol(app.getSubterm(0)));
                    break;
                case "Cf":
                    symbol = gf.createContextFreeSymbol(processSymbol(app.getSubterm(0)));
                    break;
                case "Start":
                    symbol = gf.createStartSymbol();
                    break;
                case "FileStart":
                    symbol = gf.createFileStartSymbol();
                    break;
                case "EOF":
                    symbol = gf.createEOFSymbol();
                    break;
                default:
                    System.err.println("Unknown symbol type `" + app.getName() + "'. Is that normalized SDF3?");
                    return null;
            }
        } else {
            System.err.println("Malformed term. Application expected.");
            return null;
        }

        grammar.getCacheSymbolsRead().put(term.toString(), symbol);
        grammar.getSymbols().add(symbol);
        return symbol;
    }

    // TODO this should be done in Stratego instead, which is a lot cleaner than this ad-hoc pattern-matching
    private IStrategoTerm removeLabelFromSymbolTerm(IStrategoTerm term) {
        if(!TermUtils.isAppl(term))
            return term;
        IStrategoAppl app = TermUtils.toAppl(term);

        if(app.getName().equals("Label")) {
            return removeLabelFromSymbolTerm(app.getSubterm(1));
        }

        IStrategoTerm[] children = app.getAllSubterms();
        boolean changed = false;
        for(int i = 0; i < children.length; i++) {
            IStrategoTerm newChild = removeLabelFromSymbolTerm(children[i]);
            if(newChild != children[i]) {
                changed = true;
                children[i] = newChild;
            }
        }

        // Only create a new Stratego term if the children have changed.
        if(changed) {
            return new StrategoAppl(app.getConstructor(), children, app.getAnnotations());
        }
        // If there is no `Label` subterm, the full term is reused.
        return term;
    }

    public List<Symbol> processSymbolList(IStrategoTerm term) {
        List<Symbol> list = new LinkedList<>();

        if(TermUtils.isList(term)) {
            IStrategoList slist = TermUtils.toList(term);

            for(IStrategoTerm t : slist) {
                Symbol s = processSymbol(t);
                if(s != null)
                    list.add(s);
            }
        } else {
            System.err.println("sdf2table : Symbol.fromStrategoList: this term is not a list.");
        }

        return list;
    }

    public ICharacterClass processCharClass(IStrategoTerm term) {
        if(TermUtils.isAppl(term)) {
            IStrategoAppl app = TermUtils.toAppl(term);
            CharacterClassFactory ccFactory = ParseTableIO.getCharacterClassFactory();
            switch(app.getName()) {
                case "Absent":
                    return ccFactory.fromEmpty();
                case "Simple":
                case "Present":
                    return processCharClass(app.getSubterm(0));
                case "Range":
                    // Range(Numeric(...),Numeric(...))
                    return ccFactory.fromRange(processNumeric(app.getSubterm(0)), processNumeric(app.getSubterm(1)));
                case "Numeric":
                    return ccFactory.fromSingle(processNumeric(app));
                case "Conc":
                    ICharacterClass head = processCharClass(app.getSubterm(0));
                    return head.union(processCharClass(app.getSubterm(1)));
                default:
                    System.err.println("Unknown character class `" + app + "'. Is that normalized SDF3?");
                    return ccFactory.fromEmpty();
            }
        }

        System.err.println("Malformed term. Application expected.");
        return null;
    }

    private int processNumeric(IStrategoTerm numeric) {
        if(numeric.getSubterm(0) instanceof IStrategoInt)
            // SDF3 version 2.6.0+ (after Unicode support, February 2020) normalizes to 'Numeric(...)' with integers
            return ((IStrategoInt) numeric.getSubterm(0)).intValue();
        else
            // SDF3 version 2.3.0 normalized to 'Numeric("\...")', backwards compatibility for bootstrapping
            return parseInt(((IStrategoString) numeric.getSubterm(0)).stringValue().substring(1));
    }

    private IAttribute processAttribute(IStrategoTerm ta) throws Exception {
        if(TermUtils.isAppl(ta)) {
            IStrategoAppl a = TermUtils.toAppl(ta);
            switch(a.getName()) { // This is just to get a proper name for the attribute.
                case "Assoc":
                    IStrategoAppl assoc = (IStrategoAppl) a.getSubterm(0);
                    switch(assoc.getName()) {
                        case "Left":
                            return gf.createGeneralAttribute("left");
                        case "Right":
                            return gf.createGeneralAttribute("right");
                        case "Assoc":
                            return gf.createGeneralAttribute("assoc");
                        case "NonAssoc":
                            return gf.createGeneralAttribute("non-assoc");
                        case "NonNested":
                            return gf.createGeneralAttribute("non-nested");
                        default:
                            System.err.println("Unknown associativity: `" + assoc.getName() + "'.");
                            break;
                    }
                    break;
                case "Recover":
                    return gf.createGeneralAttribute("recover");
                case "Reject":
                    return gf.createGeneralAttribute("reject");
                case "Prefer":
                    return gf.createGeneralAttribute("prefer");
                case "Avoid":
                    return gf.createGeneralAttribute("avoid");
                case "Bracket":
                    return gf.createGeneralAttribute("bracket");
                case "LayoutConstraint":
                    return gf.createLayoutConstraintAttribute(a.getSubterm(0));
                case "IgnoreLayout":
                    return gf.createLayoutConstraintAttribute(a);
                case "EnforceNewLine":
                    return gf.createGeneralAttribute("enforce-newline");
                case "LongestMatch":
                    return gf.createGeneralAttribute("longest-match");
                case "ShortestMatch":
                    return gf.createGeneralAttribute("shortest-match");
                case "CaseInsensitive":
                    return gf.createGeneralAttribute("case-insensitive");
                case "Deprecated":
                    String message = "";
                    if(a.getSubtermCount() > 0) {
                        message = ((IStrategoString) a.getSubterm(0)).stringValue();
                    }
                    return gf.createDeprecatedAttribute(message);
                case "Placeholder":
                    return gf.createGeneralAttribute("placeholder");
                case "PlaceholderInsertion":
                    return gf.createGeneralAttribute("placeholder-insertion");
                case "LiteralCompletion":
                    return gf.createGeneralAttribute("literal-completion");
                case "Term":
                    IStrategoTerm def = a.getSubterm(0);
                    IStrategoAppl term = (IStrategoAppl) def.getSubterm(0);
                    try {
                        if(term.toString().equals("Fun(Unquoted(\"recover\"))")) {
                            return gf.createGeneralAttribute("recover");
                        }
                        IStrategoTerm termAttribute = createStrategoTermAttribute(term);
                        return gf.createTermAttribute(termAttribute, termAttribute.toString());
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
        ITermFactory termFactory = ParseTableIO.getTermfactory();
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
                termName = termName.replace("\\\"", "\"").replace("\\\\", "\\").replace("\\'", "\'");
                termName = termName.substring(1,
                    termName.length() - 1);
            }
            return termFactory.makeString(termName);
        } else if(term.getConstructor().getName().equals("Int")) {
            String svalue = ((IStrategoString) term.getSubterm(0).getSubterm(0)).stringValue();
            int ivalue = parseInt(svalue);
            return termFactory.makeInt(ivalue);
        } else if(term.getConstructor().getName().equals("List")) {
            IStrategoList term_list = (IStrategoList) term.getSubterm(0);
            IStrategoList.Builder terms = termFactory.arrayListBuilder(term_list.size());
            for(IStrategoTerm t : term_list) {
                terms.add(createStrategoTermAttribute((IStrategoAppl) t));
            }
            return termFactory.makeList(terms);
        }
        System.err.println("sdf2table : importAttribute: unknown stratego term attribute `" + term.getName() + "'.");
        throw new UnexpectedTermException(term.toString());
    }

    private void addRestrictions(IStrategoAppl tsection) throws UnexpectedTermException {
        if(tsection.getName().equals("Restrictions")) {
            IStrategoList restrictions = TermUtils.toListAt(tsection, 0);
            for(IStrategoTerm restriction : restrictions) {
                processRestriction(restriction);
            }
        }
    }

    private void processRestriction(IStrategoTerm restriction) throws UnexpectedTermException {
        if(TermUtils.isAppl(restriction)) {
            IStrategoAppl res = TermUtils.toAppl(restriction);
            switch(res.getName()) {
                case "Follow":
                    List<ICharacterClass[]> restrictionLookahead = new ArrayList<>();
                    ICharacterClass restrictionNoLookahead =
                        importFollowRestriction(res.getSubterm(1), restrictionLookahead);
                    IStrategoList subjects = TermUtils.toListAt(res, 0);
                    for(IStrategoTerm subject : subjects) {
                        Symbol s = processSymbol(subject);
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

    public ICharacterClass importFollowRestriction(IStrategoTerm term, List<ICharacterClass[]> restrictionsLookahead)
        throws UnexpectedTermException {
        IStrategoList slist;

        ICharacterClass restriction = CharacterClassFactory.EMPTY_CHARACTER_CLASS;

        if(TermUtils.isAppl(term)) {
            IStrategoAppl app = TermUtils.toAppl(term);
            switch(app.getName()) {
                case "List":
                    slist = TermUtils.toListAt(app, 0);
                    for(IStrategoTerm t : slist) {
                        restriction = importFollowRestriction(t, restrictionsLookahead).union(restriction);
                    }
                    break;
                // NON TERMINALS
                case "Seq":
                    List<ICharacterClass> lookahead = new ArrayList<>(Arrays.asList(processCharClass(app.getSubterm(0))));
                    createNewLookahead(app.getSubterm(1), lookahead, restrictionsLookahead);
                    break;
                // TERMINALS
                case "CharClass":
                    restriction = restriction.union(processCharClass(app.getSubterm(0)));
                    break;
                default:
                    throw new UnexpectedTermException(app.toString(), "List or Seq or CharClass");
            }
        }

        return restriction;
    }

    private void createNewLookahead(IStrategoTerm term, List<ICharacterClass> lookahead,
        List<ICharacterClass[]> restrictionsLookahead) throws UnexpectedTermException {

        IStrategoList slist;

        if(term instanceof IStrategoAppl) {
            IStrategoAppl app = (IStrategoAppl) term;
            switch(app.getName()) {
                case "List":
                    slist = TermUtils.toListAt(app, 0);
                    for(IStrategoTerm t : slist) {
                        List<ICharacterClass> firstChars = new ArrayList<>(lookahead);
                        createNewLookahead(t, firstChars, restrictionsLookahead);
                    }
                    break;
                // NON TERMINALS
                case "Seq":
                    lookahead.add(processCharClass(app.getSubterm(0)));
                    createNewLookahead(app.getSubterm(1), lookahead, restrictionsLookahead);
                    break;
                // TERMINALS
                case "CharClass":
                    ICharacterClass lastChar = processCharClass(app.getSubterm(0));
                    lookahead.add(lastChar);
                    restrictionsLookahead.add(lookahead.toArray(new ICharacterClass[0]));
                    break;
                default:
                    throw new UnexpectedTermException(app.toString(), "List or Seq or CharClass");
            }
        }

    }

    private void addPriorities(IStrategoAppl tsection) throws Exception {
        if(tsection.getName().equals("Priorities")) {
            IStrategoList chains = TermUtils.toListAt(tsection, 0);
            for(IStrategoTerm chain : chains) {
                processPriorityChain(chain);
            }
        }
    }

    private void processPriorityChain(IStrategoTerm chain) throws Exception {
        if(TermUtils.isAppl(chain) && ((IStrategoAppl) chain).getName().equals("Chain")) {
            IStrategoList groups = (IStrategoList) chain.getSubterm(0);
            Production higher = null, lower = null;
            boolean transitive = true;
            List<Integer> arguments = new ArrayList<>();

            if(groups.size() != 2) {
                throw new Exception("Unexpected normalized priority: " + chain.toString()
                    + ".\nExpecting only binary priority relations.");
            }

            IStrategoTerm first_group = groups.getSubterm(0);

            if(first_group instanceof IStrategoAppl && ((IStrategoAppl) first_group).getName().equals("NonTransitive")) {
                transitive = false;
                first_group = first_group.getSubterm(0);
            }

            if(first_group instanceof IStrategoAppl && ((IStrategoAppl) first_group).getName().equals("WithArguments")) {
                IStrategoAppl priority_args = (IStrategoAppl) first_group.getSubterm(1);
                if(!priority_args.getName().equals("Default")) {
                    throw new UnexpectedTermException(priority_args.toString(), "Default");
                }
                IStrategoList positions = (IStrategoList) priority_args.getSubterm(0);
                for(IStrategoTerm pos : positions.getAllSubterms()) {
                    if(pos instanceof IStrategoString) {
                        arguments.add(parseInt(((IStrategoString) pos).stringValue()));
                    } else {
                        throw new UnexpectedTermException(pos.toString(), "Argument Position");
                    }
                }
                first_group = first_group.getSubterm(0);

                // the order of terms can be NonTransitive(WithArguments(*)) or WithArguments(NonTransitive(*))
                if(first_group instanceof IStrategoAppl
                    && ((IStrategoAppl) first_group).getName().equals("NonTransitive")) {
                    transitive = false;
                    first_group = first_group.getSubterm(0);
                }
            }

            higher = processGroup(first_group);

            // in case the priority is Sort.Cons <arg> > p2
            if(first_group instanceof IStrategoAppl && ((IStrategoAppl) first_group).getName().equals("SimpleRefGroup")) {
                arguments = normalizePriorityArguments(higher, arguments);
            }

            IStrategoTerm second_group = groups.getSubterm(1);

            if(second_group instanceof IStrategoAppl
                && ((IStrategoAppl) second_group).getName().equals("NonTransitive")) {
                second_group = second_group.getSubterm(0);
            }

            if(second_group instanceof IStrategoAppl
                && ((IStrategoAppl) second_group).getName().equals("WithArguments")) {

                second_group = second_group.getSubterm(0);

                // the order of terms can be NonTransitive(WithArguments(*)) or WithArguments(NonTransitive(*))
                if(second_group instanceof IStrategoAppl
                    && ((IStrategoAppl) second_group).getName().equals("NonTransitive")) {
                    second_group = second_group.getSubterm(0);
                }
            }

            lower = processGroup(second_group);

            Priority p = gf.createPriority(higher, lower, transitive);// new Priority(higher, lower, transitive);

            if(transitive) {
                grammar.getTransitivePriorities().add(p);
                grammar.getProductionsOnPriorities().add(higher);
                grammar.getProductionsOnPriorities().add(lower);

                if(arguments.isEmpty()) {
                    grammar.getTransitivePriorityArgs().put(p, -1);
                } else {
                    for(Integer arg : arguments) {
                        grammar.getTransitivePriorityArgs().put(p, arg);
                    }
                }
            } else {
                grammar.getNonTransitivePriorities().add(p);
                if(arguments.isEmpty()) {
                    grammar.getNonTransitivePriorityArgs().put(p, -1);
                } else {
                    for(Integer arg : arguments) {
                        grammar.getNonTransitivePriorityArgs().put(p, arg);
                    }
                }
            }

        } else if(TermUtils.isAppl(chain) && ((IStrategoAppl) chain).getName().equals("Assoc")) {
            IStrategoTerm first_group = chain.getSubterm(0);
            String assoc = chain.getSubterm(1).toString();
            IStrategoTerm second_group = chain.getSubterm(2);

            Production higher = processGroup(first_group);
            Production lower = processGroup(second_group);

            Priority p = gf.createPriority(higher, lower, false);

            grammar.getNonTransitivePriorities().add(p);

            // actual argument values will be processed later when defining recursion
            if(assoc.contains("Left")) {
                grammar.getNonTransitivePriorityArgs().put(p, Integer.MAX_VALUE);
            } else if(assoc.contains("Right")) {
                grammar.getNonTransitivePriorityArgs().put(p, Integer.MIN_VALUE);
            } else if(assoc.contains("NonAssoc")) {
                // consider non-assoc as left and add warning
                // grammar.getNonTransitivePriorityArgs().put(p, Integer.MIN_VALUE);
                grammar.getNonTransitivePriorityArgs().put(p, Integer.MAX_VALUE);

                p.higher().putNonAssociativity(p.lower());
            } else if(assoc.contains("NonNested")) {
                // add warning for non-nested
                p.higher().putNonNested(p.lower());
            }

        } else {
            throw new UnexpectedTermException(chain.toString(), "Chain or Assoc");
        }
    }

    private List<Integer> normalizePriorityArguments(Production production, List<Integer> arguments) {
        ISymbol optLayout = gf.createContextFreeSymbol(gf.createOptionalSymbol(gf.createLayoutSymbol()));
        List<Integer> norm_arguments = new ArrayList<>();
        for(int arg : arguments) {
            int norm_arg = 0;
            for(ISymbol s : production.rightHand()) {
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

    private Production processGroup(IStrategoTerm group) throws UnexpectedTermException, Exception {

        Production production = null;

        if(group instanceof IStrategoAppl && ((IStrategoAppl) group).getName().equals("SimpleGroup")) {
            production = processProduction(group.getSubterm(0));
        } else if(group instanceof IStrategoAppl && ((IStrategoAppl) group).getName().equals("SimpleRefGroup")) {
            IStrategoTerm sort = group.getSubterm(0).getSubterm(0);
            IStrategoTerm constructor = group.getSubterm(0).getSubterm(1);
            String cons_name = ((IStrategoString) constructor.getSubterm(0)).stringValue();

            ProductionReference prod_ref =
                gf.createProductionReference(processSymbol(sort), gf.createConstructorAttribute(cons_name));

            production = grammar.getSortConsProductionMapping().get(prod_ref);
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

    private IStrategoTerm termFromFile(File file) throws Exception {
        fileVisitors.forEach(visitor -> visitor.visit(file));

        IStrategoTerm term;
        TermReader termReader = new TermReader(ParseTableIO.getTermfactory());

        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            term = termReader.parseFromStream(fileInputStream);
        } catch(IOException e) {
            throw new Exception(
                "Cannot open module file '" + file.getPath() + "'. Try cleaning the project and rebuilding.");
        }

        return term;
    }

    private static String moduleName(IStrategoTerm term) {
        // Get module name from: Unparameterized("<name>")
        IStrategoString tname = (IStrategoString) term.getSubterm(0).getSubterm(0);
        return tname.stringValue();
    }

    private static @Nullable String importName(IStrategoTerm term) {
        switch(((IStrategoAppl) term.getSubterm(0)).getName()) {
            case "Unparameterized":
                return ((IStrategoString) term.getSubterm(0).getSubterm(0)).stringValue();
            case "Parameterized":
            default:
                return null;
        }
    }
}
