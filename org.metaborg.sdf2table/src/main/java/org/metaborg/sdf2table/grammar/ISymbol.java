package org.metaborg.sdf2table.grammar;

import java.util.List;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

public interface ISymbol {

    String name();

    boolean isNullable();

    void setNullable(boolean nullable);

    ICharacterClass getFirst();

    void setFirst(ICharacterClass first);

    ICharacterClass getFollow();

    void setFollow(ICharacterClass follow);

    ICharacterClass followRestriction();

    List<ICharacterClass[]> followRestrictionLookahead();

    org.metaborg.parsetable.symbols.ISymbol toParseTableSymbol();
    void normalizeFollowRestrictionLookahead();

}
