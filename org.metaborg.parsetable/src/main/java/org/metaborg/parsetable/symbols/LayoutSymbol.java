package org.metaborg.parsetable.symbols;

public class LayoutSymbol extends NonTerminalSymbol implements ILayoutSymbol {

    public LayoutSymbol(SyntaxContext syntaxContext, SortCardinality cardinality) {
        super(syntaxContext, cardinality);
    }

    @Override public String descriptor() {
        return "LAYOUT";
    }

}
