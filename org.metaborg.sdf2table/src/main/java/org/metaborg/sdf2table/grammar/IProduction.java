package org.metaborg.sdf2table.grammar;

import java.util.List;

public interface IProduction {

    ISymbol leftHand();

    List<ISymbol> rightHand();

    @Override int hashCode();
    @Override boolean equals(Object obj);
    int arity();


}
