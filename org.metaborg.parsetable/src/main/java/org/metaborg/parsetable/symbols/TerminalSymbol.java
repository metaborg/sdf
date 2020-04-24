package org.metaborg.parsetable.symbols;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

public class TerminalSymbol extends Symbol implements ITerminalSymbol {

    private final ICharacterClass characterClass;

    public TerminalSymbol(ICharacterClass characterClass, SortCardinality cardinality) {
        super(cardinality);
        this.characterClass = characterClass;
    }

    @Override public ICharacterClass characterClass() {
        return characterClass;
    }

    @Override public String descriptor() {
        return characterClass.toString();
    }

}
