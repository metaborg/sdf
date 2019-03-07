package org.metaborg.parsetable.actions;

public interface IShift extends IAction {

    @Override default ActionType actionType() {
        return ActionType.SHIFT;
    }

    int shiftStateId();

}
