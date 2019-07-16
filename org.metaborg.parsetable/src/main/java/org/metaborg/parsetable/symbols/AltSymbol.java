package org.metaborg.parsetable.symbols;

public class AltSymbol extends NonTerminalSymbol implements IAltSymbol {

    private final ISymbol first;
    private final ISymbol second;

    public AltSymbol(SyntaxContext syntaxContext, SortCardinality cardinality, ISymbol first, ISymbol second) {
        super(syntaxContext, cardinality);
        this.first = first;
        this.second = second;
    }

    @Override public ConcreteSyntaxContext concreteSyntaxContext() {
        return null;
    }

    @Override public ISymbol first() {
        return first;
    }

    @Override public ISymbol second() {
        return second;
    }

    @Override public String descriptor() {
        return first.descriptor() + " | " + second.descriptor();
    }
}
