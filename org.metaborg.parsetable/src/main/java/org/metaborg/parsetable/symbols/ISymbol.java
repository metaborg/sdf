package org.metaborg.parsetable.symbols;

public interface ISymbol {

    SyntaxContext syntaxContext();

    ConcreteSyntaxContext concreteSyntaxContext();

    SortCardinality cardinality();

    String descriptor();

    static String getSort(ISymbol symbol) {
        return symbol instanceof ISortSymbol ? ((ISortSymbol) symbol).sort() : null;
    }

}
