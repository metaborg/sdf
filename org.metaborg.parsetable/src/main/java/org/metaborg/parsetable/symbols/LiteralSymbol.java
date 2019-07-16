package org.metaborg.parsetable.symbols;

public class LiteralSymbol extends NonTerminalSymbol implements ILiteralSymbol {

    private final String literal;

    public LiteralSymbol(SyntaxContext syntaxContext, SortCardinality cardinality, String literal) {
        super(syntaxContext, cardinality);
        this.literal = literal;
    }

    @Override public String literal() {
        return literal;
    }

    @Override public boolean isOperator() {
        for (char c : literal.toCharArray()) {
            if(Character.isLetter(c))
                return false;
        }

        return true;
    }

    @Override public String descriptor() {
        return "\"" + literal + "\"";
    }

}
