package org.metaborg.newsdf2table.parsetable;

import org.metaborg.newsdf2table.grammar.IProduction;

public class Context {

    IProduction context;
    ContextType type;
    // propagate shallow context only to leftmost or rightmost symbols
    ContextPosition position;

    public Context(IProduction context, ContextType type) {
        this.context = context;
        this.type = type;
        this.position = ContextPosition.LEFTANDRIGHTMOST;
    }
    
    public Context(IProduction context, ContextType type, ContextPosition position) {
        this.context = context;
        this.type = type;
        this.position = position;
    }   
    
    @Override public String toString() {
        if(type == ContextType.SHALLOW && position == ContextPosition.LEFTMOST) {
            return "SHALLOW-LEFT: " + context;
        } else if (type == ContextType.SHALLOW && position == ContextPosition.RIGHTMOST) {
            return "SHALLOW-RIGHT: " + context;
        }
        return context.toString();
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Context other = (Context) obj;
        if(context == null) {
            if(other.context != null)
                return false;
        } else if(!context.equals(other.context))
            return false;
        if(position != other.position)
            return false;
        if(type != other.type)
            return false;
        return true;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
}
