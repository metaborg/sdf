package org.metaborg.parsetable.query;

import java.util.HashMap;
import java.util.Map;

import org.metaborg.parsetable.actions.IGoto;

public class ProductionToGotoJavaHashMap implements IProductionToGoto {

    private final Map<Integer, Integer> productionToGoto;

    public ProductionToGotoJavaHashMap(IGoto[] gotos) {
        productionToGoto = new HashMap<>();

        for(IGoto gotoAction : gotos) {
            int gotoStateId = gotoAction.gotoStateId();

            for(int productionId : gotoAction.productionIds()) {
                productionToGoto.put(productionId, gotoStateId);
            }
        }
    }

    @Override public boolean contains(int productionId) {
        return productionToGoto.containsKey(productionId);
    }

    @Override public int get(int productionId) {
        return productionToGoto.get(productionId);
    }

}
