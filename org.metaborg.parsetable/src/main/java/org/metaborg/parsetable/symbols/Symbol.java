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

        if(cardinality != null)
            s = s + cardinality.sign;

        if(syntaxContext() != null) {
            switch(syntaxContext()) {
                case ContextFree:
                    return s + "-CF";
                case Lexical:
                    return s + "-LEX";
            }
        }

        return s;
    }
}
