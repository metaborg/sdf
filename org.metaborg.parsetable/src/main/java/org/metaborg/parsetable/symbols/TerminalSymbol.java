package org.metaborg.parsetable.symbols;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

public class TerminalSymbol extends Symbol implements ITerminalSymbol {

    private final ICharacterClass characterClass;
    private final SyntaxContext syntaxContext;

    public TerminalSymbol(ICharacterClass characterClass, SyntaxContext syntaxContext, SortCardinality cardinality) {
        super(cardinality);
        this.characterClass = characterClass;
        this.syntaxContext = syntaxContext;
    }

    @Override public ICharacterClass characterClass() {
        return characterClass;
    }

    @Override public SyntaxContext syntaxContext() {
        return syntaxContext;
    }

    @Override public ConcreteSyntaxContext concreteSyntaxContext() {
        return syntaxContext.concreteSyntaxContext;
    }

    @Override public String descriptor() {
        return characterClass.toString();
    }

}
