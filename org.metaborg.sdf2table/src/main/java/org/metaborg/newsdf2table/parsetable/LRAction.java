package org.metaborg.newsdf2table.parsetable;

import java.util.List;

import org.metaborg.newsdf2table.grammar.CharacterClass;

import com.google.common.collect.Lists;

public class LRAction {

    CharacterClass cc;
    List<Action> actions;
    
    public LRAction(CharacterClass cc, Action a) {
        this.cc = cc;
        actions = Lists.newArrayList();
        actions.add(a);
    }
    
    public void addAction(Action a){
        actions.add(a);
    }
    
    @Override public String toString() {
        String buf = "";
        buf += "action(" + cc + ", [";
        int i = 0;
        for(Action action : actions) {
            if (i != 0) buf += ", ";
            buf += action;
            i++;
        }
        buf += "])";
        
        return buf;
    }

}
