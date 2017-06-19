package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;

import org.metaborg.sdf2table.grammar.IProduction;

public class Context implements Serializable {

    private static final long serialVersionUID = -4581589940398341265L;

    private final IProduction context;
    private final ContextType type;
    // propagate shallow context only to leftmost or rightmost symbols
    private final ContextPosition position;
    
    public Context(IProduction context, ContextType type, ContextPosition position) {
        this.context = context;
        this.type = type;
        this.position = position;
    }   
    
    @Override public String toString() {
        if(getType() == ContextType.SHALLOW && getPosition() == ContextPosition.LEFTMOST) {
            return "SHALLOW-LEFT: " + getContext();
        } else if (getType() == ContextType.SHALLOW && getPosition() == ContextPosition.RIGHTMOST) {
            return "SHALLOW-RIGHT: " + getContext();
        }
        return getContext().toString();
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Context other = (Context) obj;
        if(getContext() == null) {
            if(other.getContext() != null)
                return false;
        } else if(!getContext().equals(other.getContext()))
            return false;
        if(getPosition() != other.getPosition())
            return false;
        if(getType() != other.getType())
            return false;
        return true;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    public ContextType getType() {
        return type;
    }

    public ContextPosition getPosition() {
        return position;
    }

    public IProduction getContext() {
        return context;
    }
}
