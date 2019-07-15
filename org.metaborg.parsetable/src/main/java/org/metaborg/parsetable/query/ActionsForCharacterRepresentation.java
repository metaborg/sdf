package org.metaborg.parsetable.query;

public enum ActionsForCharacterRepresentation {
    Separated, DisjointSorted;

    public static ActionsForCharacterRepresentation standard() {
        return DisjointSorted;
    }
}
