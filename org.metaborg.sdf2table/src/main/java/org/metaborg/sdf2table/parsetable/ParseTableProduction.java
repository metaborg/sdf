package org.metaborg.sdf2table.parsetable;

import static org.metaborg.sdf2table.grammar.AssociativityInfo.getAllProductionLabels;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.metaborg.parsetable.productions.ProductionType;
import org.metaborg.parsetable.symbols.ConcreteSyntaxContext;
import org.metaborg.sdf2table.deepconflicts.ContextualProduction;
import org.metaborg.sdf2table.deepconflicts.ContextualSymbol;
import org.metaborg.sdf2table.grammar.*;
import org.metaborg.sdf2table.io.ParseTableIO;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableSet;

public class ParseTableProduction implements org.metaborg.parsetable.productions.IProduction, Serializable {

    private static final long serialVersionUID = -7825374345958769969L;

    private final IProduction p;
    private final int productionNumber;
    private final String sort;
    private final boolean isLayout;
    private final boolean isLiteral;
    private final boolean isLexical;
    private final boolean isList;
    private final boolean isOptional;
    private final boolean isStringLiteral;
    private final boolean isNumberLiteral;
    private final boolean isBracket;
    private final boolean isOperator;
    private final boolean isRecovery;
    private final boolean isCompletion;
    private final ConstructorAttribute constructor;
    private final ProductionType type;
    private final Set<LayoutConstraintAttribute> layoutConstraints;
    private final boolean isIgnoreLayoutConstraint;
    private final boolean isLongestMatch;

    private final Set<Integer> nonAssocWith;
    private final Set<Integer> nonNestedWith;

    private final long cachedContextBitmapL;
    private final long cachedContextBitmapR;

    public ParseTableProduction(int productionNumber, IProduction p, Set<IAttribute> attrs,
        Map<Integer, Integer> leftmostContextsMapping, Map<Integer, Integer> rightmostContextsMapping,
        BiMap<IProduction, Integer> labels) {
        this.p = p;

        if(leftmostContextsMapping.containsKey(productionNumber)) {
            cachedContextBitmapL = 1L << leftmostContextsMapping.get(productionNumber);
        } else {
            cachedContextBitmapL = 0L;
        }

        if(rightmostContextsMapping.containsKey(productionNumber)) {
            int offset = leftmostContextsMapping.keySet().size();
            cachedContextBitmapR = 1L << (rightmostContextsMapping.get(productionNumber) + offset);
        } else {
            cachedContextBitmapR = 0L;
        }

        if(p instanceof ContextualProduction) {
            p = ((ContextualProduction) p).getOrigProduction();
        }

        this.productionNumber = productionNumber;
        this.sort = Symbol.getSort(p.leftHand());

        boolean isRecovery = false;
        boolean isCompletion = false;
        ConstructorAttribute c = null;
        ProductionType t = ProductionType.NO_TYPE;
        boolean isBracket = false;
        for(IAttribute attr : attrs) {
            if(attr instanceof ConstructorAttribute) {
                c = (ConstructorAttribute) attr;
            }
            if(attr instanceof TermAttribute || attr instanceof GeneralAttribute) {
                if(attr.toString().equals("completion") || attr.toString().equals("literal-completion")) {
                    isCompletion = true;
                }

                if(attr.toString().equals("recover"))
                    isRecovery = true;
            }
            if(attr instanceof GeneralAttribute) {
                GeneralAttribute ga = (GeneralAttribute) attr;
                if(ga.getName().equals("bracket")) {
                    isBracket = true;
                }
                if(ga.getName().equals("reject")) {
                    t = ProductionType.REJECT;
                } else if(ga.getName().equals("prefer")) {
                    t = ProductionType.PREFER;
                } else if(ga.getName().equals("avoid")) {
                    t = ProductionType.AVOID;
                }
            }
        }
        this.isRecovery = isRecovery;
        this.isCompletion = isCompletion;
        this.isBracket = isBracket;

        boolean isList = false;

        if(org.metaborg.parsetable.productions.IProduction.isListConstructor(c != null ? c.getConstructor() : null)) {
            isList = true;
            c = null;
        }

        constructor = c;
        type = t;

        boolean isLayout = getIsLayout();
        this.isLayout = isLayout;

        boolean isLiteral = false;
        if(p.leftHand() instanceof Sort) {
            if(((Sort) p.leftHand()).getType() != null) {
                isLiteral = true;
            }
        }
        this.isLiteral = isLiteral;

        boolean isLexicalRhs;

        if(p.arity() > 0) {
            boolean lexRhs = true;

            for(ISymbol s : p.rightHand()) {
                if(!(s instanceof CharacterClassSymbol)) {
                    lexRhs = false;
                    break;
                }
            }
            isLexicalRhs = lexRhs;
        } else {
            isLexicalRhs = false;
        }

        ISymbol leftHandUnpacked = unpackIterSymbol(p.leftHand());

        this.isLexical =
            p.leftHand() instanceof LexicalSymbol || leftHandUnpacked instanceof CharacterClassSymbol || isLexicalRhs;

        ISymbol symb2 = p.leftHand();
        // not considering varsym
        if(symb2 instanceof OptionalSymbol) {
            symb2 = ((OptionalSymbol) symb2).getSymbol();
        }
        if(symb2 instanceof ContextFreeSymbol) {
            symb2 = ((ContextFreeSymbol) symb2).getSymbol();
        }

        if(symb2 instanceof SequenceSymbol || isIterSymbol(symb2)
            || ((symb2 instanceof LexicalSymbol) && isIterSymbol(((LexicalSymbol) symb2).getSymbol()))) {
            isList = true;
        }

        this.isList = isList;

        this.isOptional = containsOptSymbol(p.leftHand());

        this.isStringLiteral = topdownHasSpaces(p.rightHand());

        this.isNumberLiteral = getIsNumberLiteral(p.rightHand());

        this.isOperator = isLiteral && checkNotIsLetter(p.leftHand());

        layoutConstraints = new HashSet<LayoutConstraintAttribute>();
        boolean ignoreLayout = false;
        boolean longestMatch = false;
        for(IAttribute attr : attrs) {
            if(attr instanceof LayoutConstraintAttribute) {
                if(((LayoutConstraintAttribute) attr).ignoreLayout()) {
                    ignoreLayout = true;
                } else {
                    layoutConstraints.add(normalizeConstraint((LayoutConstraintAttribute) attr, p.rightHand()));
                }
            }
            if(attr instanceof GeneralAttribute && ((GeneralAttribute) attr).getName().equals("longest-match")) {
                longestMatch = true;
            }
        }
        isLongestMatch = longestMatch;
        isIgnoreLayoutConstraint = ignoreLayout;

        AssociativityInfo associativityInfo = ((Production) p).getAssociativityInfo();
        if(associativityInfo != null) {
            nonAssocWith = associativityInfo.getNonAssocWith().stream().flatMap(o -> getAllProductionLabels(labels, o))
                .collect(ImmutableSet.toImmutableSet());
            nonNestedWith = associativityInfo.getNonNestedWith().stream()
                .flatMap(o -> getAllProductionLabels(labels, o)).collect(ImmutableSet.toImmutableSet());
        } else
            nonAssocWith = nonNestedWith = null;
    }

    private LayoutConstraintAttribute normalizeConstraint(LayoutConstraintAttribute attr, List<ISymbol> rightHand) {
        attr.getLayoutConstraint().normalizeConstraint(rightHand);
        return attr;
    }

    private boolean getIsLayout() {
        boolean isLayout = false;
        ISymbol symb = getProduction().leftHand();
        if(symb instanceof ContextFreeSymbol) {
            symb = ((ContextFreeSymbol) symb).getSymbol();
        }
        if(symb instanceof LexicalSymbol) {
            symb = ((LexicalSymbol) symb).getSymbol();
        }
        if(symb instanceof OptionalSymbol) {
            symb = ((OptionalSymbol) symb).getSymbol();
        }
        if(symb instanceof Layout) {
            isLayout = true;
        }
        return isLayout;
    }

    private boolean checkNotIsLetter(ISymbol s) {
        if(s instanceof Sort) {
            return s.name().codePoints().noneMatch(Character::isLetter);
        }
        return false;
    }

    private boolean getIsNumberLiteral(List<ISymbol> rhs) {
        if(!rhs.isEmpty()) {
            ISymbol s = getFirstRange(rhs.get(0));

            if(s instanceof CharacterClassSymbol) {
                ICharacterClass cc = ((CharacterClassSymbol) s).getCC();
                ICharacterClass intCC = ParseTableIO.getCharacterClassFactory().fromRange('0', '9');

                return intCC.equals(cc);
            }
        }

        return false;
    }

    private ISymbol getFirstRange(ISymbol s) {
        if(s instanceof LexicalSymbol) {
            return getFirstRange(((LexicalSymbol) s).getSymbol());
        } else if(s instanceof IterStarSymbol) {
            return getFirstRange(((IterStarSymbol) s).getSymbol());
        } else if(s instanceof IterSymbol) {
            return getFirstRange(((IterSymbol) s).getSymbol());
        } else if(s instanceof CharacterClassSymbol) {
            return s;
        }
        return null;
    }

    private boolean topdownHasSpaces(List<ISymbol> rightHand) {
        // This function has been modified from the JSGLR1 with the following comment:
        // Return true if any character range of this contains spaces
        return rightHand.stream().anyMatch(this::topdownHasSpaces);
    }

    private boolean topdownHasSpaces(ISymbol s) {
        if(s instanceof CharacterClassSymbol && ((CharacterClassSymbol) s).getCC().contains(' '))
            return true;
        if(s instanceof LexicalSymbol)
            return topdownHasSpaces(((LexicalSymbol) s).getSymbol());
        if(s instanceof IterStarSepSymbol)
            return topdownHasSpaces(((IterStarSepSymbol) s).getSymbol());
        if(s instanceof IterStarSymbol)
            return topdownHasSpaces(((IterStarSymbol) s).getSymbol());
        if(s instanceof IterSepSymbol)
            return topdownHasSpaces(((IterSepSymbol) s).getSymbol());
        if(s instanceof IterSymbol)
            return topdownHasSpaces(((IterSymbol) s).getSymbol());
        return false;
    }

    private boolean containsOptSymbol(ISymbol s) {
        if(s instanceof ContextFreeSymbol) {
            return containsOptSymbol(((ContextFreeSymbol) s).getSymbol());
        } else if(s instanceof LexicalSymbol) {
            return containsOptSymbol(((LexicalSymbol) s).getSymbol());
        } else {
            return s instanceof OptionalSymbol;
        }
    }

    private boolean isIterSymbol(ISymbol s) {
        return (s instanceof IterSymbol) || (s instanceof IterStarSymbol) || (s instanceof IterStarSepSymbol)
            || (s instanceof IterSepSymbol);
    }

    private ISymbol unpackIterSymbol(ISymbol s) {
        if(s instanceof IterSymbol)
            return ((IterSymbol) s).getSymbol();
        else if(s instanceof IterStarSymbol)
            return ((IterStarSymbol) s).getSymbol();
        else if(s instanceof IterStarSepSymbol)
            return ((IterStarSepSymbol) s).getSymbol();
        else if(s instanceof IterSepSymbol)
            return ((IterSepSymbol) s).getSymbol();
        else
            return null;
    }

    public IProduction getProduction() {
        return p;
    }

    @Override public String sort() {
        return sort;
    }

    @Override public String constructor() {
        if(constructor != null) {
            return constructor.getConstructor();
        }
        return null;
    }

    @Override public String descriptor() {
        return toString();
    }

    @Override public ConcreteSyntaxContext concreteSyntaxContext() {
        if(isLayout)
            return ConcreteSyntaxContext.Layout;
        else if(isLiteral)
            return ConcreteSyntaxContext.Literal;
        else if(isLexical)
            return ConcreteSyntaxContext.Lexical;
        else
            return ConcreteSyntaxContext.ContextFree;
    }

    @Override public boolean isList() {
        return isList;
    }

    @Override public boolean isOptional() {
        return isOptional;
    }

    @Override public boolean isRecovery() {
        return isRecovery;
    }

    @Override public boolean isCompletion() {
        return isCompletion;
    }

    @Override public boolean isStringLiteral() {
        return isStringLiteral;
    }

    @Override public boolean isNumberLiteral() {
        return isNumberLiteral;
    }

    @Override public boolean isOperator() {
        return isOperator;
    }

    public boolean isIgnoreLayoutConstraint() {
        return isIgnoreLayoutConstraint;
    }

    @Override public String toString() {
        String s = p.leftHand().toString();
        if(constructor != null) {
            s += "." + constructor();
        }

        s += " = ";
        for(int i = 0; i < p.arity(); i++) {
            if(i != 0) {
                s += " ";
            }
            s += p.rightHand().get(i).toString();
        }

        return s;
    }

    public ProductionType getProductionType() {
        return type;
    }

    public Set<LayoutConstraintAttribute> getLayoutConstraints() {
        return layoutConstraints;
    }

    public final long contextL() {
        return cachedContextBitmapL;
    }

    public final long contextR() {
        return cachedContextBitmapR;
    }

    @Override public org.metaborg.parsetable.symbols.ISymbol lhs() {
        return p.leftHand().toParseTableSymbol();
    }

    @Override public int id() {
        return productionNumber;
    }

    @Override public String startSymbolSort() {
        if(getProduction().leftHand() instanceof StartSymbol) {
            for(ISymbol s : getProduction().rightHand()) {
                if(s instanceof ContextualSymbol) {
                    s = ((ContextualSymbol) s).getOrigSymbol();
                }
                if(Symbol.getSort(s) != null) {
                    return Symbol.getSort(s);
                }
            }
        }
        return null;
    }

    @Override public boolean isLongestMatch() {
        return isLongestMatch;
    }

    @Override public boolean isBracket() {
        return isBracket;
    }

    @Override public boolean isNonAssocWith(org.metaborg.parsetable.productions.IProduction other) {
        return nonAssocWith != null && nonAssocWith.contains(other.id());
    }

    @Override public boolean isNonNestedWith(org.metaborg.parsetable.productions.IProduction other) {
        return nonNestedWith != null && nonNestedWith.contains(other.id());
    }

}
