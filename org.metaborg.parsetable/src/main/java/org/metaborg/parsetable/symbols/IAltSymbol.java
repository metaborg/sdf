package org.metaborg.parsetable.symbols;

public interface IAltSymbol extends INonTerminalSymbol {

    ISymbol first();

    ISymbol second();

}
