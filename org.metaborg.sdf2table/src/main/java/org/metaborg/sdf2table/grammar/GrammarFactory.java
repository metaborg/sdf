package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.*;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class GrammarFactory implements Serializable {

    private static final long serialVersionUID = -3963847554036972197L;

    private final Map<List<Object>, AltSymbol> altSymbols;
    private final Map<ICharacterClass, CharacterClassSymbol> characterClassSymbols;
    private final Map<String, ConstructorAttribute> constructorAttributes;
    private final Map<Symbol, ContextFreeSymbol> contextFreeSymbols;
    private final Map<Symbol, LexicalSymbol> lexicalSymbols;
    private final Map<Symbol, OptionalSymbol> optionalSymbols;
    private final Map<String, DeprecatedAttribute> deprecatedAttributes;
    private final Map<String, GeneralAttribute> generalAttributes;
    private final Map<List<Object>, IterSepSymbol> iterSepSymbols;
    private final Map<List<Object>, IterStarSepSymbol> iterStarSepSymbols;
    private final Map<Symbol, IterStarSymbol> iterStarSymbols;
    private final Map<Symbol, IterSymbol> iterSymbols;
    private final Map<List<Object>, SequenceSymbol> sequenceSymbols;
    private final Map<List<Object>, Sort> sorts;
    private final Map<List<Object>, Priority> priorities;
    private final Map<List<Object>, Production> productions;
    private final Map<List<Object>, UniqueProduction> uniqueProductions;
    private final Map<List<Object>, ProductionReference> productionReferences;
    private final Map<List<Object>, TermAttribute> termAttributes;
    private Layout layoutSymbol;
    private FileStartSymbol fileStartSymbol;
    private StartSymbol startSymbol;
    private EOFSymbol eofSymbol;

    public GrammarFactory() {
        altSymbols = new HashMap<>();
        characterClassSymbols = new HashMap<>();
        constructorAttributes = new HashMap<>();
        contextFreeSymbols = new HashMap<>();
        lexicalSymbols = new HashMap<>();
        optionalSymbols = new HashMap<>();
        deprecatedAttributes = new HashMap<>();
        generalAttributes = new HashMap<>();
        iterSepSymbols = new HashMap<>();
        iterStarSepSymbols = new HashMap<>();
        iterStarSymbols = new HashMap<>();
        iterSymbols = new HashMap<>();
        priorities = new HashMap<>();
        sequenceSymbols = new HashMap<>();
        productions = new HashMap<>();
        uniqueProductions = new HashMap<>();
        productionReferences = new HashMap<>();
        sorts = new HashMap<>();
        termAttributes = new HashMap<>();
    }


    public AltSymbol createAltSymbol(Symbol s1, Symbol s2) {
        List<Object> altSymbolFields = new ArrayList<>();
        altSymbolFields.add(s1);
        altSymbolFields.add(s2);

        if(altSymbols.containsKey(altSymbolFields)) {
            return altSymbols.get(altSymbolFields);
        }

        AltSymbol altSymbol = new AltSymbol(s1, s2);
        altSymbols.put(altSymbolFields, altSymbol);

        return altSymbol;
    }


    public CharacterClassSymbol createCharClassSymbol(ICharacterClass cc) {
        if(characterClassSymbols.containsKey(cc)) {
            return characterClassSymbols.get(cc);
        }

        CharacterClassSymbol ccSymbol = new CharacterClassSymbol(cc);
        characterClassSymbols.put(cc, ccSymbol);

        return ccSymbol;
    }


    public ConstructorAttribute createConstructorAttribute(String cons) {
        if(constructorAttributes.containsKey(cons)) {
            return constructorAttributes.get(cons);
        }

        ConstructorAttribute ca = new ConstructorAttribute(cons);
        constructorAttributes.put(cons, ca);

        return ca;
    }


    public ContextFreeSymbol createContextFreeSymbol(Symbol symbol) {
        if(contextFreeSymbols.containsKey(symbol)) {
            return contextFreeSymbols.get(symbol);
        }

        ContextFreeSymbol cfs = new ContextFreeSymbol(symbol);
        contextFreeSymbols.put(symbol, cfs);

        return cfs;
    }

    public LexicalSymbol createLexicalSymbol(Symbol s) {
        if(lexicalSymbols.containsKey(s)) {
            return lexicalSymbols.get(s);
        }

        LexicalSymbol cfs = new LexicalSymbol(s);
        lexicalSymbols.put(s, cfs);

        return cfs;
    }


    public IterSymbol createIterSymbol(Symbol s) {
        if(iterSymbols.containsKey(s)) {
            return iterSymbols.get(s);
        }

        IterSymbol is = new IterSymbol(s);
        iterSymbols.put(s, is);
        return is;
    }

    public IterStarSymbol createIterStarSymbol(Symbol s) {
        if(iterStarSymbols.containsKey(s)) {
            return iterStarSymbols.get(s);
        }

        IterStarSymbol iss = new IterStarSymbol(s);
        iterStarSymbols.put(s, iss);
        return iss;
    }


    public IterSepSymbol createIterSepSymbol(Symbol symbol, Sort separator) {
        List<Object> iterSepFields = new ArrayList<>();
        iterSepFields.add(symbol);
        iterSepFields.add(separator);

        if(iterSepSymbols.containsKey(iterSepFields)) {
            return iterSepSymbols.get(iterSepFields);
        }

        IterSepSymbol iterSepSymbol = new IterSepSymbol(symbol, separator);
        iterSepSymbols.put(iterSepFields, iterSepSymbol);

        return iterSepSymbol;
    }

    public IterStarSepSymbol createIterStarSepSymbol(Symbol s, Sort sep) {
        List<Object> iterStarSepFields = new ArrayList<>();
        iterStarSepFields.add(s);
        iterStarSepFields.add(sep);

        if(iterStarSepSymbols.containsKey(iterStarSepFields)) {
            return iterStarSepSymbols.get(iterStarSepFields);
        }

        IterStarSepSymbol iterStarSepSymbol = new IterStarSepSymbol(s, sep);
        iterStarSepSymbols.put(iterStarSepFields, iterStarSepSymbol);

        return iterStarSepSymbol;
    }


    public OptionalSymbol createOptionalSymbol(Symbol s) {
        if(optionalSymbols.containsKey(s)) {
            return optionalSymbols.get(s);
        }

        OptionalSymbol os = new OptionalSymbol(s);
        optionalSymbols.put(s, os);

        return os;
    }

    public DeprecatedAttribute createDeprecatedAttribute(String message) {
        if(deprecatedAttributes.containsKey(message)) {
            return deprecatedAttributes.get(message);
        }

        DeprecatedAttribute da = new DeprecatedAttribute(message);
        deprecatedAttributes.put(message, da);
        return da;
    }


    public GeneralAttribute createGeneralAttribute(String name) {
        if(generalAttributes.containsKey(name)) {
            return generalAttributes.get(name);
        }

        GeneralAttribute ga = new GeneralAttribute(name);
        generalAttributes.put(name, ga);

        return ga;
    }


    public LayoutConstraintAttribute createLayoutConstraintAttribute(IStrategoTerm t) throws Exception {
        LayoutConstraintAttribute lca = new LayoutConstraintAttribute(t);

        return lca;
    }


    public Priority createPriority(Production higher, Production lower, boolean transitive) {
        List<Object> priorityFields = new ArrayList<>();
        priorityFields.add(higher);
        priorityFields.add(lower);
        priorityFields.add(transitive);

        if(priorities.containsKey(priorityFields)) {
            return priorities.get(priorityFields);
        }

        Priority p = new Priority(higher, lower, transitive);
        priorities.put(priorityFields, p);

        return p;
    }


    public Production createProduction(Symbol lhs, List<Symbol> rhs) {
        // inline rhs as fields
        List<Object> productionFields = new ArrayList<>();
        productionFields.add(lhs);
        productionFields.addAll(rhs);

        if(productions.containsKey(productionFields)) {
            return productions.get(productionFields);
        }

        Production p = new Production(lhs, rhs);
        productions.put(productionFields, p);

        return p;
    }


    public Production createProduction(Symbol lhs, List<Symbol> rhs, int leftRecursivePos, int rightRecursivePos) {
        List<Object> productionFields = new ArrayList<>();
        productionFields.add(lhs);
        productionFields.addAll(rhs);

        if(productions.containsKey(productionFields)) {
            Production p = productions.get(productionFields);
            p.setLeftRecursivePosition(leftRecursivePos);
            p.setRightRecursivePosition(rightRecursivePos);
            return p;
        }

        Production p = new Production(lhs, rhs, leftRecursivePos, rightRecursivePos);
        productions.put(productionFields, p);

        return p;
    }


    public ProductionReference createProductionReference(Symbol s, ConstructorAttribute cons) {
        List<Object> productionReferenceFields = Arrays.asList(s, cons);
        if(productionReferences.containsKey(productionReferenceFields)) {
            return productionReferences.get(productionReferenceFields);
        }

        ProductionReference pr = new ProductionReference(s, cons);
        productionReferences.put(productionReferenceFields, pr);
        return pr;
    }


    public SequenceSymbol createSequenceSymbol(Symbol first, List<Symbol> tail) {
        List<Object> sequenceSymbolFields = new ArrayList<>(Arrays.asList(first));
        sequenceSymbolFields.addAll(tail);
        if(sequenceSymbols.containsKey(sequenceSymbolFields)) {
            return sequenceSymbols.get(sequenceSymbolFields);
        }

        SequenceSymbol ss = new SequenceSymbol(first, tail);
        sequenceSymbols.put(sequenceSymbolFields, ss);
        return ss;
    }


    public Sort createSort(String s) {
        List<Object> sortFields = new ArrayList<>(Arrays.asList(s, null));

        if(sorts.containsKey(sortFields)) {
            return sorts.get(sortFields);
        }

        Sort sort = new Sort(s);
        sorts.put(sortFields, sort);
        return sort;
    }


    public Symbol createSort(String s, LiteralType lit) {
        List<Object> sortFields = Arrays.asList(s, lit);

        if(sorts.containsKey(sortFields)) {
            return sorts.get(sortFields);
        }

        Sort sort = new Sort(s, lit);
        sorts.put(sortFields, sort);
        return sort;
    }


    public Layout createLayoutSymbol() {
        if(layoutSymbol == null) {
            layoutSymbol = new Layout();
        }
        return layoutSymbol;
    }


    public FileStartSymbol createFileStartSymbol() {
        if(fileStartSymbol == null) {
            fileStartSymbol = new FileStartSymbol();
        }
        return fileStartSymbol;
    }


    public Symbol createStartSymbol() {
        if(startSymbol == null) {
            startSymbol = new StartSymbol();
        }
        return startSymbol;
    }


    public Symbol createEOFSymbol() {
        if(eofSymbol == null) {
            eofSymbol = new EOFSymbol();
        }
        return eofSymbol;
    }


    public TermAttribute createTermAttribute(IStrategoTerm t, String s) {
        List<Object> termAttributeFields = Arrays.asList(t, s);
        if(termAttributes.containsKey(termAttributeFields)) {
            return termAttributes.get(termAttributeFields);
        }

        TermAttribute ta = new TermAttribute(t, s);
        termAttributes.put(termAttributeFields, ta);

        return ta;
    }


    public UniqueProduction createUniqueProduction(Symbol lhs, List<Symbol> rhs) {
        List<Object> uniqueProductionFields = new ArrayList<>();
        uniqueProductionFields.add(lhs);
        uniqueProductionFields.addAll(rhs);
        if(uniqueProductions.containsKey(uniqueProductionFields)) {
            return uniqueProductions.get(uniqueProductionFields);
        }

        UniqueProduction up = new UniqueProduction(lhs, rhs);
        uniqueProductions.put(uniqueProductionFields, up);

        return up;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrammarFactory that = (GrammarFactory) o;
        return Objects.equals(altSymbols, that.altSymbols) && Objects.equals(characterClassSymbols, that.characterClassSymbols) && Objects.equals(constructorAttributes, that.constructorAttributes) && Objects.equals(contextFreeSymbols, that.contextFreeSymbols) && Objects.equals(lexicalSymbols, that.lexicalSymbols) && Objects.equals(optionalSymbols, that.optionalSymbols) && Objects.equals(deprecatedAttributes, that.deprecatedAttributes) && Objects.equals(generalAttributes, that.generalAttributes) && Objects.equals(iterSepSymbols, that.iterSepSymbols) && Objects.equals(iterStarSepSymbols, that.iterStarSepSymbols) && Objects.equals(iterStarSymbols, that.iterStarSymbols) && Objects.equals(iterSymbols, that.iterSymbols) && Objects.equals(sequenceSymbols, that.sequenceSymbols) && Objects.equals(sorts, that.sorts) && Objects.equals(priorities, that.priorities) && Objects.equals(productions, that.productions) && Objects.equals(uniqueProductions, that.uniqueProductions) && Objects.equals(productionReferences, that.productionReferences) && Objects.equals(termAttributes, that.termAttributes) && Objects.equals(layoutSymbol, that.layoutSymbol) && Objects.equals(fileStartSymbol, that.fileStartSymbol) && Objects.equals(startSymbol, that.startSymbol) && Objects.equals(eofSymbol, that.eofSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(altSymbols, characterClassSymbols, constructorAttributes, contextFreeSymbols, lexicalSymbols, optionalSymbols, deprecatedAttributes, generalAttributes, iterSepSymbols, iterStarSepSymbols, iterStarSymbols, iterSymbols, sequenceSymbols, sorts, priorities, productions, uniqueProductions, productionReferences, termAttributes, layoutSymbol, fileStartSymbol, startSymbol, eofSymbol);
    }
}
