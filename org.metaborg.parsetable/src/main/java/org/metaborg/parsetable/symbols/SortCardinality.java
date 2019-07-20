package org.metaborg.parsetable.symbols;

public enum SortCardinality {
    Optional("opt"), List("list");

    public final String descriptor;

    SortCardinality(String descriptor) {
        this.descriptor = descriptor;
    }
}
