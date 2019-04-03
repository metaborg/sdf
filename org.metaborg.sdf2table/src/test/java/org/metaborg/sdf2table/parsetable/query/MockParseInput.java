package org.metaborg.sdf2table.parsetable.query;

import org.metaborg.parsetable.IActionQuery;

public class MockParseInput implements IActionQuery {

    private final int character;

    public MockParseInput(int character) {
        this.character = character;
    }

    @Override public int actionQueryCharacter() {
        return character;
    }

    @Override public String actionQueryLookahead(int length) {
        return "";
    }

}
