package org.metaborg.parsetable.symbols;

public interface IMetaVarSymbol extends ISymbol {

    default SyntaxContext syntaxContext() {
        return SyntaxContext.Lexical;
    }

    default ConcreteSyntaxContext concreteSyntaxContext() {
        return ConcreteSyntaxContext.Lexical;
    }

    MetaVarCardinality metaVarCardinality();

}
