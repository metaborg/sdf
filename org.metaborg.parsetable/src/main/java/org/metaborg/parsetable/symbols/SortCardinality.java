package org.metaborg.parsetable.symbols;

public enum SortCardinality {
    Optional("opt", true, false),
    Iter("iter", false, true),
    IterSep("iter-sep", false, true),
    IterStar("iter-star", false, true),
    IterStarSep("iter-star-sep", false, true),
    IterPlus("iter-plus", false, true),
    IterPlusSep("iter-plus-sep", false, true);

    public final String descriptor;

    public final boolean isOptional;
    public final boolean isList;

    SortCardinality(String descriptor, boolean isOptional, boolean isList) {
        this.descriptor = descriptor;
        this.isOptional = isOptional;
        this.isList = isList;
    }
}
