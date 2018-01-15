package org.metaborg.sdf2table.jsglrinterfaces;

import org.metaborg.sdf2table.parsetable.ActionType;

public interface ISGLRAction {

    ActionType actionType();
    
    ISGLRCharacters characters();
    
    public default boolean appliesTo(int character) {
        return characters().containsCharacter(character);
    }
    
}
