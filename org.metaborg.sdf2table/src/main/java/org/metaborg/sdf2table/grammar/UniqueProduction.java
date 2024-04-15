package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueProduction implements Serializable{

    private static final long serialVersionUID = 3033929538492911319L;

    private final Symbol lhs;
    private final List<Symbol> rhs;

    protected UniqueProduction(Symbol lhs, List<Symbol> rhs_symbols) {
        this.lhs = lhs;
        this.rhs = rhs_symbols;
    }

    @Override public String toString() {
        return lhs.name() + " -> " +
                rhs.stream().map(ISymbol::name).collect(Collectors.joining(" "));
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
