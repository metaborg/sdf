package org.metaborg.parsetable.query;

public enum ProductionToGotoRepresentation {
    ForLoop, JavaHashMap;

    public static ProductionToGotoRepresentation standard() {
        return JavaHashMap;
    }
}
