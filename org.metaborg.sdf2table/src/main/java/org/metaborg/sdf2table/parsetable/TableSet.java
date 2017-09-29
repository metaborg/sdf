package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.Set;

import org.metaborg.sdf2table.grammar.CharacterClass;
import org.metaborg.sdf2table.grammar.IProduction;

import com.google.common.collect.Sets;

public class TableSet implements Serializable {
    
    private static final long serialVersionUID = 3001311608137161789L;
    
    IProduction p;
    CharacterClass value;
    Set<TableSet> depends_on = Sets.newHashSet();
    Set<TableSet> dependents = Sets.newHashSet();
    
    // Tarjan variables
    int index = -1;
    int low_link = -1;
    boolean onStack = false;
    
    public TableSet(IProduction p) {
        this.p = p;
    }
    
    public void add(CharacterClass cc) {
        if (value == null) {
            value = cc;
        } else if (cc != null){
            value = CharacterClass.union(cc, value);   
        }
    }

    public void addDependency(TableSet s) {
        if(depends_on.add(s)) {
            s.addDependent(this);
        }        
    }
    
    public void addDependent(TableSet s) {
        this.dependents.add(s);
    }
    
    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((p == null) ? 0 : p.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        TableSet other = (TableSet) obj;
        if(p == null) {
            if(other.p != null)
                return false;
        } else if(!p.equals(other.p))
            return false;
        return true;
    }

    @Override public String toString() {
        String buf = "";
        buf += "prod: " + p + "\n";
        
        if (value != null) {
            buf += "value = " + value + "\n";
        } else {
            buf += "no value\n";
        }
       
        buf += "depends on: ";
        if (depends_on.isEmpty()) {
            buf += "---\n";
        } 
        int i = 0;
        for (TableSet t : depends_on) {
            if (i != 0) buf += "            ";
            buf += t.p + "\n";
            i++;
        }
        
        buf += "dependents: ";
        i = 0;
        if (dependents.isEmpty()) {
            buf += "---\n";
        }
        for (TableSet t : dependents) {
            if (i != 0) buf += "            ";
            buf += t.p + "\n";
            i++;
        }
        
        return buf;
    }

}
