package org.metaborg.parsetable.actions;

import java.util.Arrays;

public class Goto implements IGoto {

    private final int[] productionIds;
    private final int gotoStateId;

    public Goto(int[] productionIds, int gotoState) {
        this.productionIds = productionIds;
        this.gotoStateId = gotoState;
    }

    @Override public int[] productionIds() {
        return productionIds;
    }

    @Override public int gotoStateId() {
        return gotoStateId;
    }

    @Override public String toString() {
        return "goto(" + gotoStateId + ")";
    }

    @Override public int hashCode() {
        return productionIds.hashCode() ^ gotoStateId;
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Goto that = (Goto) o;

        return gotoStateId == that.gotoStateId && Arrays.equals(productionIds, that.productionIds);
    }

}
