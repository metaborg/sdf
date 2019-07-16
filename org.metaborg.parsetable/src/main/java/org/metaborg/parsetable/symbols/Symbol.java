package org.metaborg.parsetable.symbols;

abstract class Symbol implements ISymbol {

    private final SortCardinality cardinality;

    Symbol(SortCardinality cardinality) {
        this.cardinality = cardinality;
    }

    @Override public SortCardinality cardinality() {
        return cardinality;
    }

    @Override public String toString() {
        String s = descriptor();

        if(syntaxContext() != null) {
            switch(syntaxContext()) {
                case ContextFree:
                    s = s + "-CF";
                    break;
                case Lexical:
                    s = s + "-LEX";
                    break;
                default:
                    break;
            }
        }

        return s;
    }
}
