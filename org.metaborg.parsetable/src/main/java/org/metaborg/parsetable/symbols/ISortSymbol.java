package org.metaborg.parsetable.symbols;

public interface ISortSymbol extends INonTerminalSymbol {

    String sort();

    boolean varSym();

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return syntaxContext() != null ? syntaxContext().concreteSyntaxContext : null;
    }

}
