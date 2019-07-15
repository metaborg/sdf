package org.metaborg.parsetable.symbols;

public interface ILiteralSymbol extends INonTerminalSymbol {

    public String literal();

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return ConcreteSyntaxContext.Literal;
    }

    public boolean isOperator();

}
