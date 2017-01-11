package org.metaborg.newsdf2table.grammar;

import java.util.List;

public interface IRestriction {
    
    List<Symbol> symbols();
    
    CharacterClass cc();
}
