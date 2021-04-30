package org.metaborg.parsetable.query;

public interface IProductionToGoto {

    /**
     * Whether a goto for the given production id is present.
     */
    boolean contains(int productionId);

    /**
     * Get the goto state id for the given production id.
     */
    int get(int productionId);

    /**
     * Get the goto state id for the given production id,
     * or the default value if no goto state exists for this production.
     */
    int get(int productionId, int defaultValue);

}
