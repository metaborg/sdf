package org.metaborg.parsetable.symbols;

abstract class NonTerminalSymbol extends Symbol implements INonTerminalSymbol {

    SyntaxContext syntaxContext;

    NonTerminalSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        super(cardinality);
        this.syntaxContext = syntaxContext;
    }

    @Override public SyntaxContext syntaxContext() {
        return syntaxContext;
    }

}
