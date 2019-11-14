package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

import org.metaborg.sdf2table.grammar.ISymbol;

public class ProductionReference implements Serializable {
    
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


    private static final long serialVersionUID = -7256082373948196902L;

    private final ISymbol sort;
    private final ConstructorAttribute cons;
    
    protected ProductionReference(ISymbol sort, ConstructorAttribute cons) {
        this.sort = sort;
        this.cons = cons;
    }
    public ISymbol getSort() {
        return sort;
    }
    public ConstructorAttribute getCons() {
        return cons;
    }
    
    
    @Override public String toString() {
        return sort.toString() + "." + cons.toString();
    }

}
