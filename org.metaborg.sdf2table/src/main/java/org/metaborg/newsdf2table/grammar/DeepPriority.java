package org.metaborg.newsdf2table.grammar;

public class DeepPriority implements IPriority {

    IProduction higher;
    IProduction lower;
    boolean transitive;

    public DeepPriority(IProduction higher, IProduction lower, boolean transitive) {
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
//        if(!arguments.isEmpty()) {
//            buf += "<";
//            int i = 0;
//            for(Integer arg : arguments) {
//                if(i != 0) {
//                    buf += ", ";
//                }
//                buf += arg;
//            }
//            buf += ">";
//        }
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
        DeepPriority other = (DeepPriority) obj;
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
