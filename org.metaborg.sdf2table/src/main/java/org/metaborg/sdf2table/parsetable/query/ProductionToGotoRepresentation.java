package org.metaborg.sdf2table.parsetable.query;

public enum ProductionToGotoRepresentation {
    ForLoop, JavaHashMap;

    public static ProductionToGotoRepresentation standard() {
        return JavaHashMap;
    }
}
