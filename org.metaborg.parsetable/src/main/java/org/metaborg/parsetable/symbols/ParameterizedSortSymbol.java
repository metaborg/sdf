package org.metaborg.parsetable.symbols;

public class ParameterizedSortSymbol extends SortSymbol implements IParameterizedSortSymbol {

    private final String[] parameters;

    public ParameterizedSortSymbol(SyntaxContext syntaxContext, SortCardinality cardinality, String sort,
        String[] parameters, boolean isVarSym) {
        super(syntaxContext, cardinality, sort, isVarSym);
        this.parameters = parameters;
    }

    @Override public String[] parameters() {
        return parameters;
    }

}
