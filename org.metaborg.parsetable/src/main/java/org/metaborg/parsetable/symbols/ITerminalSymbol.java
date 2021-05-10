package org.metaborg.parsetable.symbols;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

public interface ITerminalSymbol extends ISymbol {

    ICharacterClass characterClass();

}
