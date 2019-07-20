package org.metaborg.parsetable.symbols;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

public interface ITerminalSymbol extends ISymbol {

    default SyntaxContext syntaxContext() {
        return SyntaxContext.Lexical;
    }

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return ConcreteSyntaxContext.Lexical;
    }

    ICharacterClass characterClass();

}
