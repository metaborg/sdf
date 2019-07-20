package org.metaborg.parsetable.symbols;

class MetaVarSymbol extends Symbol implements IMetaVarSymbol {

    MetaVarCardinality metaVarCardinality;

    public MetaVarSymbol(MetaVarCardinality metaVarCardinality) {
        super(null);
        this.metaVarCardinality = metaVarCardinality;
    }

    @Override public MetaVarCardinality metaVarCardinality() {
        return metaVarCardinality;
    }

    @Override public String descriptor() {
        return metaVarCardinality.constructor;
    }

}
