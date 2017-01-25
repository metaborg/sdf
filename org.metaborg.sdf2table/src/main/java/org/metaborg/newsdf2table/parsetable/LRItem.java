package org.metaborg.newsdf2table.parsetable;

import java.util.Queue;
import java.util.Set;

import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.Priority;
import org.metaborg.newsdf2table.grammar.Symbol;

import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class LRItem {

    ParseTable pt;
    IProduction prod;
    int dotPosition;
    Set<IProduction> context = Sets.newHashSet();

    boolean processed;

    public LRItem(IProduction prod, int dotPosition, ParseTable pt) {
        if(!(prod instanceof ContextualProduction) && pt.getGrammar().contextual_prods.containsKey(prod)) {
            this.prod = pt.getGrammar().contextual_prods.get(prod);
        } else {
            this.prod = prod;
        }
        this.pt = pt;
        this.dotPosition = dotPosition;
        processed = false;
    }

    public void process(Set<LRItem> items, Queue<LRItem> itemsQueue, SetMultimap<Symbol, LRItem> symbol_items) {
        if(dotPosition < prod.rightHand().size()) {

            Symbol s_at_dot = prod.rightHand().get(dotPosition);


            for(IProduction p : pt.getGrammar().symbol_prods.get(s_at_dot)) {
                if(!isPriorityConflict(this, p)) {

                    // p might be the problematic contextual production
                    if(pt.getGrammar().contextual_prods.get(p) != null) {
                        p = pt.getGrammar().contextual_prods.get(p);
                    }

                    LRItem newItem = new LRItem(p, 0, pt);
                    if(!items.contains(newItem)) {
                        itemsQueue.add(newItem);
                    }

                } else {
                    // it is a deep priority conflict and is not a conflicting arg, expand still
                    Set<Integer> conflicting_args = this.prod.isDeepPriorityConflict(pt, p);
                    if(!conflicting_args.isEmpty() && !conflicting_args.contains(dotPosition)) {
                        LRItem newItem = new LRItem(p, 0, pt);
                        if(!items.contains(newItem)) {
                            itemsQueue.add(newItem);
                        }
                    }
                }
            }
        }

        this.processed = true;
        items.add(this);
        if(this.dotPosition < prod.rightHand().size()) {
            symbol_items.put(prod.rightHand().get(this.dotPosition), this);
        }
    }

    public LRItem shiftDot() {
        return new LRItem(this.prod, this.dotPosition + 1, this.pt);
    }

    private boolean isPriorityConflict(LRItem item, IProduction p) {
        Priority prio = new Priority(item.prod, p, false);
        if(pt.getGrammar().priorities().containsKey(prio)) {
            Set<Integer> arguments = pt.getGrammar().priorities().get(prio);
            for(int i : arguments) {
                if(i == -1 || i == item.dotPosition)
                    return true;
            }
        }
        return false;
    }



    @Override public String toString() {
        String buf = "";
        buf += prod.leftHand();
        buf += " -> ";
        for(int i = 0; i < prod.rightHand().size(); i++) {
            if(i != 0)
                buf += " ";
            if(i == dotPosition) {
                buf += ". ";
            }
            buf += prod.rightHand().get(i);
        }
        if(dotPosition >= prod.rightHand().size()) {
            buf += " .";
        }
        if(!context.isEmpty()) {
            buf += " [ctx = ";
            int i = 0;
            for(IProduction p : context) {
                if(i != 0)
                    buf += ", ";
                buf += pt.prod_labels.get(p) + " : " + p;
            }
            buf += "]";
        }
        return buf;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + dotPosition;
        result = prime * result + ((prod == null) ? 0 : prod.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        LRItem other = (LRItem) obj;
        if(context == null) {
            if(other.context != null)
                return false;
        } else if(!context.equals(other.context))
            return false;
        if(dotPosition != other.dotPosition)
            return false;
        if(prod == null) {
            if(other.prod != null)
                return false;
        } else if(!prod.equals(other.prod))
            return false;
        return true;
    }

}
