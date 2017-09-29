package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

public class ProductionReference implements Serializable {
    
    private static final long serialVersionUID = -7256082373948196902L;

    private Symbol sort;
    private ConstructorAttribute cons;
    
    public ProductionReference(Symbol sort, ConstructorAttribute cons) {
        this.sort = sort;
        this.cons = cons;
    }
    public Symbol getSort() {
        return sort;
    }
    public void setSort(Symbol sort) {
        this.sort = sort;
    }
    public ConstructorAttribute getCons() {
        return cons;
    }
    public void setCons(ConstructorAttribute cons) {
        this.cons = cons;
    }
    
    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cons == null) ? 0 : cons.hashCode());
        result = prime * result + ((sort == null) ? 0 : sort.hashCode());
        return result;
    }
    
    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        ProductionReference other = (ProductionReference) obj;
        if(cons == null) {
            if(other.cons != null)
                return false;
        } else if(!cons.equals(other.cons))
            return false;
        if(sort == null) {
            if(other.sort != null)
                return false;
        } else if(!sort.equals(other.sort))
            return false;
        return true;
    }
    
    @Override public String toString() {
        return sort.toString() + "." + cons.toString();
    }

}
