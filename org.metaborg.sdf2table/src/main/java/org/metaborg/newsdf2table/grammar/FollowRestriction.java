package org.metaborg.newsdf2table.grammar;

import java.util.List;

public class FollowRestriction implements IRestriction {
    List<Symbol> symbols;
    CharacterClass cc;
    
    public FollowRestriction(List<Symbol> symbols, CharacterClass cc) {
        this.symbols = symbols;
        this.cc = cc;
    }
    
    @Override public List<Symbol> symbols() {
        return symbols;
    }
    
    @Override public CharacterClass cc() {
        return cc;
    }    
    
}
