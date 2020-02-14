package org.metaborg.parsetable.query;

public enum ActionsForCharacterRepresentation {
    Separated, DisjointSorted;

    public static ActionsForCharacterRepresentation standard() {
        return Separated; // TODO figure out a way to make DisjointSorted efficient with Unicode
    }
}
