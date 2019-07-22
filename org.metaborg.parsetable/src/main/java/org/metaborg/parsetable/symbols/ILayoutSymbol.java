package org.metaborg.parsetable.symbols;

public interface ILayoutSymbol extends INonTerminalSymbol {

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return ConcreteSyntaxContext.Layout;
    }

}
