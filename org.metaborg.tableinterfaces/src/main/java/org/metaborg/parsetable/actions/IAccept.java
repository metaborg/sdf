package org.metaborg.parsetable.actions;

public interface IAccept extends IAction {

    @Override default ActionType actionType() {
        return ActionType.ACCEPT;
    }

}
