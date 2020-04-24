package org.metaborg.parsetable.symbols;

public interface ISymbol {

    SyntaxContext syntaxContext();

    ConcreteSyntaxContext concreteSyntaxContext();

    SortCardinality cardinality();

    String descriptor();

    static String getSort(ISymbol symbol) {
        if(!(symbol instanceof ISortSymbol)) {
            return null;
        }
        ISortSymbol sortSymbol = (ISortSymbol) symbol;
        if(sortSymbol.cardinality() == null) {
            return sortSymbol.sort();
        }
        return null;
    }

}
