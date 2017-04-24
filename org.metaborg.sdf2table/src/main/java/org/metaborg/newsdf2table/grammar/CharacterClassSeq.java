package org.metaborg.newsdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassSeq extends Symbol {

    private static final long serialVersionUID = 5369777341906641907L;

    private final Symbol head;
    private final Set<Symbol> tail;

    public CharacterClassSeq(Symbol head, Set<Symbol> second) {
        this.head = head;
        this.tail = second;
    }

    public String name() {
        String buf = getHead().name();
        int i = 0;
        buf += "{";
        for(Symbol s : tail) {
            if (i != 0) {
                buf += ", ";
            }
            buf += s;
            i++;
        }  
        buf += "}";
        return buf;
    }

    public Set<Symbol> getTail() {
        return tail;
    }    

    public Symbol getHead() {
        return head;
    }    

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        // only shows up in follow restrictions and not in the parse table
        return null;
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val) {
        // TODO Implement this
        return null;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((head == null) ? 0 : head.hashCode());
        result = prime * result + ((tail == null) ? 0 : tail.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        CharacterClassSeq other = (CharacterClassSeq) obj;
        if(head == null) {
            if(other.head != null)
                return false;
        } else if(!head.equals(other.head))
            return false;
        if(tail == null) {
            if(other.tail != null)
                return false;
        } else if(!tail.equals(other.tail))
            return false;
        return true;
    }
}
