package org.metaborg.parsetable.actions;

public interface IShift extends IAction {

    @Override
    default public ActionType actionType() {
        return ActionType.SHIFT;
    }

    int shiftStateId();

}
