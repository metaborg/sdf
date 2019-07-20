package org.metaborg.parsetable.symbols;

public class SortSymbol extends NonTerminalSymbol implements ISortSymbol {

    private final String sort;
    private final boolean isVarSym;

    public SortSymbol(SyntaxContext syntaxContext, SortCardinality cardinality, String sort, boolean isVarSym) {
        super(isVarSym ? SyntaxContext.Lexical : syntaxContext, cardinality);
        this.sort = sort;
        this.isVarSym = isVarSym;
    }

    @Override public String sort() {
        return sort;
    }

    @Override public boolean varSym() {
        return isVarSym;
    }

    @Override public String descriptor() {
        return sort;
    }

}
