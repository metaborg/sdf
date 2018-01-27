package org.metaborg.parsetable.actions;

public interface IAccept extends IAction {

    @Override
    default public ActionType actionType() {
        return ActionType.ACCEPT;
    }

}
