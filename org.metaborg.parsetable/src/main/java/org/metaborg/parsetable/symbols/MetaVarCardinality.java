package org.metaborg.parsetable.symbols;

public enum MetaVarCardinality {
    Var("meta-var"), ListVar("meta-listvar");

    public final String constructor;

    MetaVarCardinality(String constructor) {
        this.constructor = constructor;
    }
}
