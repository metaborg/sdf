package org.metaborg.parsetable.symbols;

public interface ISortSymbol extends INonTerminalSymbol {

    String sort();

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return syntaxContext() != null ? syntaxContext().concreteSyntaxContext : ConcreteSyntaxContext.ContextFree;
    }

}
