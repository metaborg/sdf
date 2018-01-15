package org.metaborg.sdf2table.deepconflicts;

import java.io.Serializable;
import java.util.Map;

public class Context implements Serializable {

    private static final long serialVersionUID = -4581589940398341265L;

    // label of the production causing the conflict
    private final int context;
    private final ContextType type;
    // propagate shallow context only to leftmost or rightmost symbols
    private final ContextPosition position;
    private boolean isIndirect;
    private final long contextBitmap;

    public Context(int context, ContextType type, ContextPosition position, boolean isIndirect, final Map<Integer, Integer> leftmostContextsMapping, final Map<Integer, Integer> rightmostContextsMapping) {
        this.context = context;
        this.type = type;
        this.position = position;
        this.isIndirect = isIndirect;

        if (position == ContextPosition.LEFTMOST && leftmostContextsMapping.containsKey(context)) {
            contextBitmap = 1L << leftmostContextsMapping.get(context);
        } else if (position == ContextPosition.RIGHTMOST && rightmostContextsMapping.containsKey(context)) {
            int offset = leftmostContextsMapping.keySet().size();
            contextBitmap = 1L << (rightmostContextsMapping.get(context) + offset);
        } else {
            contextBitmap = 0L;
        }
    }

    @Override
    public String toString() {
        return "" + context;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + context;
        result = prime * result + (isIndirect ? 1231 : 1237);
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Context other = (Context) obj;
        if(context != other.context)
            return false;
        if(isIndirect != other.isIndirect)
            return false;
        if(position != other.position)
            return false;
        if(type != other.type)
            return false;
        return true;
    }

    public ContextType getType() {
        return type;
    }

    public ContextPosition getPosition() {
        return position;
    }

    public int getContext() {
        return context;
    }

    public long getContextBitmap() {
        return contextBitmap;
    }

    public boolean isIndirect() {
        return isIndirect;
    }

    public void setIndirect(boolean isIndirect) {
        this.isIndirect = isIndirect;
    }

}
