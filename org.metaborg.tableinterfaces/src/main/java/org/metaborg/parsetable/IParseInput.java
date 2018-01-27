package org.metaborg.parsetable;

public interface IParseInput {

    int getCurrentChar();

    String getLookahead(int length);

}
