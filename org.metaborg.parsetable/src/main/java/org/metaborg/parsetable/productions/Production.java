package org.metaborg.parsetable.productions;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.metaborg.parsetable.symbols.ConcreteSyntaxContext;
import org.metaborg.parsetable.symbols.ILiteralSymbol;
import org.metaborg.parsetable.symbols.ISymbol;

public class Production implements IProduction {

    private final ISymbol lhs;
    private final ISymbol[] rhs;

    private final ConcreteSyntaxContext concreteSyntaxContext;

    private final int productionId;
    private final boolean isStringLiteral;
    private final boolean isNumberLiteral;
    private final boolean isSkippableInParseForest;
    private final ProductionAttributes attributes;
    private final boolean isListConstructor;

    public Production(int productionId, ISymbol lhs, ISymbol[] rhs, boolean isStringLiteral, boolean isNumberLiteral,
        boolean isLexicalRhs, boolean isSkippableInParseForest, ProductionAttributes attributes) {
        this.productionId = productionId;
        this.lhs = lhs;
        this.rhs = rhs;
        this.isStringLiteral = isStringLiteral;
        this.isNumberLiteral = isNumberLiteral;
        this.isSkippableInParseForest = isSkippableInParseForest;
        this.attributes = attributes;
        this.isListConstructor = IProduction.isListConstructor(attributes.constructor);

        if(lhs.concreteSyntaxContext() == ConcreteSyntaxContext.Layout)
            concreteSyntaxContext = ConcreteSyntaxContext.Layout;
        else if(lhs.concreteSyntaxContext() == ConcreteSyntaxContext.Literal)
            concreteSyntaxContext = ConcreteSyntaxContext.Literal;
        else if(lhs.concreteSyntaxContext() == ConcreteSyntaxContext.Lexical || isLexicalRhs)
            concreteSyntaxContext = ConcreteSyntaxContext.Lexical;
        else
            concreteSyntaxContext = ConcreteSyntaxContext.ContextFree;
    }

    @Override public int id() {
        return productionId;
    }

    @Override public ISymbol lhs() {
        return lhs;
    }

    public static ProductionType typeFromInt(int productionType) {
        switch(productionType) {
            /*
             * During parsing we don't need the types 3 (BRACKET), 5 (LEFT_ASSOCIATIVE) and 6 (RIGHT_ASSOCIATIVE) and
             * thus ignore them here.
             */
            case 1:
                return ProductionType.REJECT;
            case 2:
                return ProductionType.PREFER;
            case 4:
                return ProductionType.AVOID;
            default:
                return ProductionType.NO_TYPE;
        }
    }

    @Override public String sort() {
        return ISymbol.getSort(lhs);
    }

    @Override public String startSymbolSort() {
        if("<START>".equals(sort())) {
            for(ISymbol symbol : rhs) {
                String sort = ISymbol.getSort(symbol);

                if(sort != null)
                    return sort;
            }
        }

        return null;
    }

    @Override public String constructor() {
        if(!isListConstructor)
            return attributes.constructor;
        else
            return null;
    }

    @Override public String descriptor() {
        return lhs.toString() + (constructor() != null ? "." + constructor() : "") + " = "
            + Arrays.stream(rhs).map(ISymbol::toString).collect(Collectors.joining(" "));
    }

    @Override public ConcreteSyntaxContext concreteSyntaxContext() {
        return concreteSyntaxContext;
    }

    @Override public boolean isContextFree() {
        return concreteSyntaxContext == ConcreteSyntaxContext.ContextFree;
    }

    @Override public boolean isLayout() {
        return concreteSyntaxContext == ConcreteSyntaxContext.Layout;
    }

    @Override public boolean isLiteral() {
        return concreteSyntaxContext == ConcreteSyntaxContext.Literal;
    }

    @Override public boolean isLexical() {
        return concreteSyntaxContext == ConcreteSyntaxContext.Lexical;
    }

    @Override public boolean isSkippableInParseForest() {
        return isSkippableInParseForest;
    }

    @Override public boolean isList() {
        return (lhs.cardinality() != null && lhs.cardinality().isList) || isListConstructor || attributes.isFlatten;
    }

    @Override public boolean isOptional() {
        return lhs.cardinality() != null && lhs.cardinality().isOptional;
    }

    @Override public boolean isStringLiteral() {
        return isStringLiteral;
    }

    @Override public boolean isNumberLiteral() {
        return isNumberLiteral;
    }

    @Override public boolean isOperator() {
        return isLiteral() && ((ILiteralSymbol) lhs).isOperator();
    }

    @Override public boolean isRecovery() {
        return attributes.isRecovery;
    }

    @Override public boolean isCompletion() {
        return attributes.isCompletion();
    }

    @Override public String toString() {
        return descriptor();
    }

    @Override public int hashCode() {
        return productionId;
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Production that = (Production) o;

        return productionId == that.productionId;
    }

    @Override public boolean isIgnoreLayoutConstraint() {
        return attributes.isIgnoreLayout;
    }

    @Override public boolean isLongestMatch() {
        return attributes.isLongestMatch;
    }

    @Override public boolean isBracket() {
        return attributes.isBracket;
    }

}
