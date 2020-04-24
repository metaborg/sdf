package org.metaborg.parsetable.symbols;

import java.util.List;

public class SequenceSymbol extends NonTerminalSymbol implements ISequenceSymbol {

    private List<ISymbol> symbols;

    public SequenceSymbol(SyntaxContext syntaxContext, SortCardinality cardinality, List<ISymbol> symbols) {
        super(syntaxContext, cardinality);
        this.symbols = symbols;
    }

    @Override public ConcreteSyntaxContext concreteSyntaxContext() {
        return null;
    }

    @Override public String descriptor() {
        return "seq";
    }

    @Override public List<ISymbol> symbols() {
        return symbols;
    }
}
