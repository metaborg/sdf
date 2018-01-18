package org.metaborg.sdf2table.parsetable.query;

import org.metaborg.parsetable.actions.IGoto;

public class ProductionToGotoForLoop implements IProductionToGoto {

    private final IGoto[] gotos;

    public ProductionToGotoForLoop(IGoto[] gotos) {
        this.gotos = gotos;
    }

    @Override
    public boolean contains(int productionId) {
        for(IGoto gotoAction : gotos) {
            for(int gotoActionProductionId : gotoAction.productionIds())
                if(gotoActionProductionId == productionId)
                    return true;
        }

        return false;
    }

    @Override
    public int get(int productionId) {
        for(IGoto gotoAction : gotos) {
            for(int gotoActionProductionId : gotoAction.productionIds())
                if(gotoActionProductionId == productionId)
                    return gotoAction.gotoStateId();
        }

        throw new IllegalStateException();
    }

}
