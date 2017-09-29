package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.List;

public class UniqueProduction implements Serializable{

    private static final long serialVersionUID = 3033929538492911319L;

    private Symbol lhs;
    private List<Symbol> rhs;

    public UniqueProduction(Symbol lhs, List<Symbol> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
        result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        UniqueProduction other = (UniqueProduction) obj;
        if(lhs == null) {
            if(other.lhs != null)
                return false;
        } else if(!lhs.equals(other.lhs))
            return false;
        if(rhs == null) {
            if(other.rhs != null)
                return false;
        } else if(!rhs.equals(other.rhs))
            return false;
        return true;
    }
}
