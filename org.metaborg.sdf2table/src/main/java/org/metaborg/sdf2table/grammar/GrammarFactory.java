package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
    private final Map<IStrategoTerm, LayoutConstraintAttribute> layoutConstraintAttributes;
    private final Map<List<Object>, TermAttribute> termAttributes;
    private Layout layoutSymbol;
    private FileStartSymbol fileStartSymbol;
    private StartSymbol startSymbol;
    private EOFSymbol eofSymbol;

    public GrammarFactory() {
        altSymbols = Maps.newHashMap();
        characterClassSymbols = Maps.newHashMap();
        constructorAttributes = Maps.newHashMap();
        contextFreeSymbols = Maps.newHashMap();
        lexicalSymbols = Maps.newHashMap();
        optionalSymbols = Maps.newHashMap();
        deprecatedAttributes = Maps.newHashMap();
        generalAttributes = Maps.newHashMap();
        iterSepSymbols = Maps.newHashMap();
        iterStarSepSymbols = Maps.newHashMap();
        iterStarSymbols = Maps.newHashMap();
        iterSymbols = Maps.newHashMap();
        priorities = Maps.newHashMap();
        sequenceSymbols = Maps.newHashMap();
        layoutConstraintAttributes = Maps.newHashMap();
        productions = Maps.newHashMap();
        uniqueProductions = Maps.newHashMap();
        productionReferences = Maps.newHashMap();
        sorts = Maps.newHashMap();
        termAttributes = Maps.newHashMap();
    }


    public AltSymbol createAltSymbol(Symbol s1, Symbol s2) {
        List<Object> altSymbolFields = Lists.newArrayList();
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
        List<Object> iterSepFields = Lists.newArrayList();
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
        List<Object> iterStarSepFields = Lists.newArrayList();
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
        if(layoutConstraintAttributes.containsKey(t)) {
            return layoutConstraintAttributes.get(t);
        }

        LayoutConstraintAttribute lca = new LayoutConstraintAttribute(t);
        layoutConstraintAttributes.put(t, lca);

        return lca;
    }


    public Priority createPriority(Production higher, Production lower, boolean transitive) {
        List<Object> priorityFields = Lists.newArrayList();
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
        List<Object> productionFields = Lists.newArrayList();
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
        List<Object> productionFields = Lists.newArrayList();
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
        List<Object> productionReferenceFields = Lists.newArrayList(s, cons);
        if(productionReferences.containsKey(productionReferenceFields)) {
            return productionReferences.get(productionReferenceFields);
        }

        ProductionReference pr = new ProductionReference(s, cons);
        productionReferences.put(productionReferenceFields, pr);
        return pr;
    }


    public SequenceSymbol createSequenceSymbol(Symbol first, List<Symbol> tail) {
        List<Object> sequenceSymbolFields = Lists.newArrayList(first);
        sequenceSymbolFields.addAll(tail);
        if(sequenceSymbols.containsKey(sequenceSymbolFields)) {
            return sequenceSymbols.get(sequenceSymbolFields);
        }

        SequenceSymbol ss = new SequenceSymbol(first, tail);
        sequenceSymbols.put(sequenceSymbolFields, ss);
        return ss;
    }


    public Sort createSort(String s) {
        List<Object> sortFields = Lists.newArrayList(s, null);

        if(sorts.containsKey(sortFields)) {
            return sorts.get(sortFields);
        }

        Sort sort = new Sort(s);
        sorts.put(sortFields, sort);
        return sort;
    }


    public Symbol createSort(String s, LiteralType lit) {
        List<Object> sortFields = Lists.newArrayList(s, lit);

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
        List<Object> termAttributeFields = Lists.newArrayList(t, s);
        if(termAttributes.containsKey(termAttributeFields)) {
            return termAttributes.get(termAttributeFields);
        }

        TermAttribute ta = new TermAttribute(t, s);
        termAttributes.put(termAttributeFields, ta);

        return ta;
    }


    public UniqueProduction createUniqueProduction(Symbol lhs, List<Symbol> rhs) {
        List<Object> uniqueProductionFields = Lists.newArrayList();
        uniqueProductionFields.add(lhs);
        uniqueProductionFields.addAll(rhs);
        if(uniqueProductions.containsKey(uniqueProductionFields)) {
            return uniqueProductions.get(uniqueProductionFields);
        }

        UniqueProduction up = new UniqueProduction(lhs, rhs);
        uniqueProductions.put(uniqueProductionFields, up);

        return up;
    }

}
