package org.metaborg.sdf2table.grammar;

import java.io.Serializable;

public class Priority implements IPriority, Serializable {

    private static final long serialVersionUID = 4019550894781189141L;

    IProduction higher;
    IProduction lower;
    boolean transitive;

    public Priority(IProduction higher, IProduction lower, boolean transitive) {
        this.higher = higher;
        this.lower = lower;
        this.transitive = transitive;
    }

    @Override public IProduction higher() {
        return higher;
    }

    @Override public IProduction lower() {
        return lower;
    }

    @Override public boolean transitive() {
        return transitive;
    }

    @Override public String toString() {
        String buf = higher.toString();
        if(!transitive)
            buf += ". ";
        buf += " > ";
        buf += lower.toString();
        return buf;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((higher == null) ? 0 : higher.hashCode());
        result = prime * result + ((lower == null) ? 0 : lower.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Priority other = (Priority) obj;
        if(higher == null) {
            if(other.higher != null)
                return false;
        } else if(!higher.equals(other.higher))
            return false;
        if(lower == null) {
            if(other.lower != null)
                return false;
        } else if(!lower.equals(other.lower))
            return false;
        return true;
    }


}
