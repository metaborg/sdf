package org.metaborg.parsetable.symbols;

public class SequenceSymbol extends NonTerminalSymbol implements ISequenceSymbol {

    public SequenceSymbol(SyntaxContext syntaxContext) {
        super(syntaxContext, SortCardinality.Seq);
    }

    @Override public ConcreteSyntaxContext concreteSyntaxContext() {
        return null;
    }

    @Override public String descriptor() {
        return "seq";
    }
}
