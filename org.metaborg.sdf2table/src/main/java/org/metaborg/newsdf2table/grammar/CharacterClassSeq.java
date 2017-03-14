package org.metaborg.newsdf2table.grammar;

import java.util.Set;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class CharacterClassSeq extends Symbol {

    private Symbol head;
    Set<Symbol> tail;

    public CharacterClassSeq(Symbol head, Set<Symbol> second) {
        this.setHead(head);
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

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        // only shows up in follow restrictions and not in the parse table
        return null;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHead() == null) ? 0 : getHead().hashCode());
        result = prime * result + ((tail == null) ? 0 : tail.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        CharacterClassSeq other = (CharacterClassSeq) obj;
        if(getHead() == null) {
            if(other.getHead() != null)
                return false;
        } else if(!getHead().equals(other.getHead()))
            return false;
        if(tail == null) {
            if(other.tail != null)
                return false;
        } else if(!tail.equals(other.tail))
            return false;
        return true;
    }

    public Set<Symbol> getTail() {
        return tail;
    }

    public void setTail(Set<Symbol> tail) {
        this.tail = tail;
    }

    public Symbol getHead() {
        return head;
    }

    public void setHead(Symbol head) {
        this.head = head;
    }

}
