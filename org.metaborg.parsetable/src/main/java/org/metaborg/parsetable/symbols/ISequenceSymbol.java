package org.metaborg.parsetable.symbols;

import java.util.List;

public interface ISequenceSymbol extends INonTerminalSymbol {

    List<ISymbol> symbols();

}
