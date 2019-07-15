package org.metaborg.parsetable.symbols;

public class SortSymbol extends NonTerminalSymbol implements ISortSymbol {

    String sort;

    public SortSymbol(SyntaxContext syntaxContext, SortCardinality cardinality, String sort) {
        super(syntaxContext, cardinality);
        this.sort = sort;
    }

    @Override public String sort() {
        return sort;
    }

    @Override public String descriptor() {
        return sort;
    }

}
