package org.metaborg.sdf2table.parsetable.query;

public enum ActionsForCharacterRepresentation {
    Separated, DisjointSorted;

    public static ActionsForCharacterRepresentation standard() {
        return DisjointSorted;
    }
}
