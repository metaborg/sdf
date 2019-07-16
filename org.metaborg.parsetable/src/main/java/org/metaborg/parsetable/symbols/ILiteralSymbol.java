package org.metaborg.parsetable.symbols;

public interface ILiteralSymbol extends INonTerminalSymbol {

    String literal();

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return ConcreteSyntaxContext.Literal;
    }

    boolean isOperator();

}
