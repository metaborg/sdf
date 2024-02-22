package org.metaborg.parsetable.productions;

import org.metaborg.parsetable.symbols.ConcreteSyntaxContext;
import org.metaborg.parsetable.symbols.ISymbol;

import mb.jsglr.shared.IToken;

public interface IProduction {

    int id();

    ISymbol lhs();

    /*
     * It would make sense to have `ProductionType productionType()` in the interface here. However, SDF parse tables
     * represent production types in two ways: (1) on productions and (2) on reduce actions. They are not always equal
     * for the same productions due to a bug in the parser generator. Since the production types on reduce actions are
     * correct, the (sometimes incorrect) types on the productions itself are hidden here.
     */
    // public ProductionType productionType()

    String sort();

    String startSymbolSort();

    String constructor();

    static boolean isListConstructor(String constructor) {
        return "Snoc".equals(constructor) || "Ins".equals(constructor) || "Nil".equals(constructor);
    }

    String descriptor();

    ConcreteSyntaxContext concreteSyntaxContext();

    default boolean isContextFree() {
        return concreteSyntaxContext() == ConcreteSyntaxContext.ContextFree;
    }

    default boolean isLayout() {
        return concreteSyntaxContext() == ConcreteSyntaxContext.Layout;
    }

    default boolean isLiteral() {
        return concreteSyntaxContext() == ConcreteSyntaxContext.Literal;
    }

    default boolean isLexical() {
        return concreteSyntaxContext() == ConcreteSyntaxContext.Lexical;
    }

    default boolean isSkippableInParseForest() {
        return !isContextFree();
    }

    boolean isList();

    boolean isOptional();

    boolean isRecovery();

    default boolean isWater() {
        return (sort() != null && sort().contains("WATER")) || "WATER".equals(constructor());
    }

    default boolean isInsertion() {
        return "INSERTION".equals(constructor());
    }

    boolean isCompletion();

    // The methods below are for tokenization / syntax highlighting
    boolean isStringLiteral();

    boolean isNumberLiteral();

    boolean isOperator();

    boolean isIgnoreLayoutConstraint();

    boolean isLongestMatch();

    boolean isBracket();

    boolean isNonAssocWith(IProduction other);

    boolean isNonNestedWith(IProduction other);

    static IToken.Kind getTokenKind(IProduction production) {
        if(production == null) {
            return IToken.Kind.TK_STRING; // indicates a character/int terminal, e.g. 'x'
        } else if(production.isLayout()) {
            return IToken.Kind.TK_LAYOUT;
        } else if(production.isLiteral()) {
            if(production.isOperator())
                return IToken.Kind.TK_OPERATOR;
            else
                return IToken.Kind.TK_KEYWORD;
        } else if(production.isLexical()) {
            if(production.isStringLiteral())
                return IToken.Kind.TK_STRING;
            else if(production.isNumberLiteral())
                return IToken.Kind.TK_NUMBER;
            else
                return IToken.Kind.TK_IDENTIFIER;
        } else {
            throw new IllegalStateException("invalid production/token type");
        }
    }

}
