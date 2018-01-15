package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.deepconflicts.ContextualProduction;
import org.metaborg.sdf2table.grammar.*;
import org.metaborg.sdf2table.jsglrinterfaces.ISGLRProduction;

import java.io.Serializable;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParseTableProduction implements ISGLRProduction, Serializable {

    private static final long serialVersionUID = -7825374345958769969L;

    private final IProduction p;
    private final int productionNumber;
    private final String sort;
    private final boolean isContextFree;
    private final boolean isLayout;
    private final boolean isLiteral;
    private final boolean isLexical;
    private final boolean isLexicalRhs;
    private final boolean isList;
    private final boolean isOptional;
    private final boolean isStringLiteral;
    private final boolean isNumberLiteral;
    private final boolean isOperator;
    private final boolean isCompletionOrRecovery;
    private final ConstructorAttribute constructor;
    private final ProductionType type;

    private final long cachedContextBitmapL;
    private final long cachedContextBitmapR;

    public ParseTableProduction(int productionNumber, IProduction p, Set<IAttribute> attrs,
        Map<Integer, Integer> leftmostContextsMapping, Map<Integer, Integer> rightmostContextsMapping) {
        this.p = p;

        if (leftmostContextsMapping.containsKey(productionNumber)) {
            cachedContextBitmapL = 1L << leftmostContextsMapping.get(productionNumber);
        } else {
            cachedContextBitmapL = 0L;
        }

        if (rightmostContextsMapping.containsKey(productionNumber)) {
            int offset = leftmostContextsMapping.keySet().size();
            cachedContextBitmapR = 1L << (rightmostContextsMapping.get(productionNumber) + offset);
        } else {
            cachedContextBitmapR = 0L;
        }

        if(p instanceof ContextualProduction) {
            p = ((ContextualProduction) p).getOrigProduction();
        }

        this.productionNumber = productionNumber;
        this.sort = getSort(p.leftHand());

        boolean completionOrRecovery = false;
        ConstructorAttribute c = null;
        ProductionType t = ProductionType.NO_TYPE;
        for(IAttribute attr : attrs) {
            if(attr instanceof ConstructorAttribute) {
                c = (ConstructorAttribute) attr;
            }
            if(attr instanceof TermAttribute || attr instanceof GeneralAttribute) {
                if(attr.toString().equals("completion") || attr.toString().equals("recover")
                    || attr.toString().equals("literal-completion")) {
                    completionOrRecovery = true;
                }
            }
            if(attr instanceof GeneralAttribute) {
                GeneralAttribute ga = (GeneralAttribute) attr;
                if(ga.getName().equals("reject")) {
                    t = ProductionType.REJECT;
                } else if(ga.getName().equals("prefer")) {
                    t = ProductionType.PREFER;
                } else if(ga.getName().equals("avoid")) {
                    t = ProductionType.AVOID;
                }
            }
        }
        constructor = c;
        isCompletionOrRecovery = completionOrRecovery;
        type = t;

        boolean isLayout = false;
        Symbol symb = p.leftHand();
        if(symb instanceof ContextFreeSymbol) {
            symb = ((ContextFreeSymbol) symb).getSymbol();
        }
        if(symb instanceof OptionalSymbol) {
            symb = ((OptionalSymbol) symb).getSymbol();
        }
        if(symb instanceof Layout) {
            isLayout = true;
        }
        this.isLayout = isLayout;

        boolean isLiteral = false;
        if(p.leftHand() instanceof Sort) {
            if(((Sort) p.leftHand()).getType() != null) {
                isLiteral = true;
            }
        }
        this.isLiteral = isLiteral;

        this.isLexical = p.leftHand() instanceof LexicalSymbol;

        if(p.rightHand().size() > 0) {
            boolean lexRhs = true;
            for(Symbol s : p.rightHand()) {
                if(!(s instanceof CharacterClass)) {
                    lexRhs = false;
                    break;
                }
            }
            this.isLexicalRhs = lexRhs;
        } else {
            this.isLexicalRhs = false;
        }

        this.isContextFree = !(isLayout || isLiteral || isLexical || isLexicalRhs);

        boolean isList = false;
        Symbol symb2 = p.leftHand();
        // not considering varsym
        if(symb2 instanceof OptionalSymbol) {
            symb2 = ((OptionalSymbol) symb2).getSymbol();
        }
        if(symb2 instanceof ContextFreeSymbol) {
            symb2 = ((ContextFreeSymbol) symb2).getSymbol();
        }

        if(symb2 instanceof SequenceSymbol || isIterSymbol(symb2)) {
            isList = true;
        }

        this.isList = isList;

        this.isOptional = containsOptSymbol(p.leftHand());

        this.isStringLiteral = topdownHasSpaces(p.rightHand());

        CharacterClass cc = checkFirstRange(p.rightHand());
        this.isNumberLiteral = (cc != null);

        this.isOperator = isLiteral && checkNotIsLetter(p.leftHand());
    }

    private boolean checkNotIsLetter(Symbol s) {
        if(s instanceof Sort) {
            for(int i = 0; i < s.name().length(); i++) {
                char c = s.name().charAt(i);
                if(Character.isLetter(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private CharacterClass checkFirstRange(List<Symbol> rhs) {
        for(Symbol s : rhs) {
            s = getFirstRange(s);
            if(s instanceof CharacterClass) {
                BitSet bs = ((CharacterClass) s).getBitSet();
                if(bs != null) {
                    if(bs.get(48, 58).cardinality() == 10) {
                        return (CharacterClass) s;
                    }
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    private Symbol getFirstRange(Symbol s) {
        if(s instanceof LexicalSymbol) {
            return getFirstRange(((LexicalSymbol) s).getSymbol());
        } else if(s instanceof IterStarSymbol) {
            return getFirstRange(((IterStarSymbol) s).getSymbol());
        } else if(s instanceof IterSymbol) {
            return getFirstRange(((IterSymbol) s).getSymbol());
        } else if(s instanceof CharacterClass) {
            return s;
        }
        return null;
    }

    private boolean topdownHasSpaces(List<Symbol> rightHand) {
        // This function has been copied from the JSGLR1 with the following comment:
        // Return true if any character range of this contains spaces
        for(Symbol s : rightHand) {
            if(s instanceof CharacterClass && ((CharacterClass) s).containsCharacter('0')) {
                return true;
            }
        }
        return false;
    }

    private boolean containsOptSymbol(Symbol s) {
        if(s instanceof ContextFreeSymbol) {
            return containsOptSymbol(((ContextFreeSymbol) s).getSymbol());
        } else if(s instanceof LexicalSymbol) {
            return containsOptSymbol(((LexicalSymbol) s).getSymbol());
        }
        if(s instanceof OptionalSymbol) {
            return true;
        }
        return false;
    }

    private boolean isIterSymbol(Symbol s) {
        return (s instanceof IterSymbol) || (s instanceof IterStarSymbol) || (s instanceof IterStarSepSymbol)
            || (s instanceof IterSepSymbol);
    }

    private String getSort(Symbol s) {
        if(s instanceof Sort && ((Sort) s).getType() == null) {
            return s.name();
        } else if(s instanceof ContextFreeSymbol) {
            return getSort(((ContextFreeSymbol) s).getSymbol());
        } else if(s instanceof LexicalSymbol) {
            return getSort(((LexicalSymbol) s).getSymbol());
        } else if(s instanceof AltSymbol) {
            return getSort(((AltSymbol) s).left()) + "_" + getSort(((AltSymbol) s).right());
        }
        return null;
    }

    @Override public int productionNumber() {
        return productionNumber;
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
        return "";
    }

    @Override public boolean isContextFree() {
        return isContextFree;
    }

    @Override public boolean isLayout() {
        return isLayout;
    }

    @Override public boolean isLiteral() {
        return isLiteral;
    }

    @Override public boolean isLexical() {
        return isLexical;
    }

    @Override public boolean isLexicalRhs() {
        return isLexicalRhs;
    }

    @Override public boolean isList() {
        return isList;
    }

    @Override public boolean isOptional() {
        return isOptional;
    }

    @Override public boolean isCompletionOrRecovery() {
        return isCompletionOrRecovery;
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

    @Override public String toString() {
        String s = p.leftHand().toString();
        if(constructor != null) {
            s += "." + constructor();
        }

        s += " = ";
        for(int i = 0; i < p.rightHand().size(); i++) {
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

    public final long contextL() {
        return cachedContextBitmapL;
    }

    public final long contextR() {
        return cachedContextBitmapR;
    }

}
