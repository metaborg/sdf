package org.metaborg.sdf2table.parsetable;

import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Symbol;

import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class LRItem {

    ITableGenerator pt;
    IProduction prod;
    int dotPosition;
    int prod_label;

    public LRItem(IProduction prod, int dotPosition, ITableGenerator pt) {
        if(!(prod instanceof ContextualProduction) && pt.normalizedGrammar().contextual_prods.containsKey(prod)) {
            this.prod = pt.normalizedGrammar().contextual_prods.get(prod);
        } else {
            this.prod = prod;
        }
        this.pt = pt;
        this.dotPosition = dotPosition;
        this.prod_label = pt.labels().get(prod);
    }

    public void process(Set<LRItem> items, SetMultimap<Symbol, LRItem> symbol_items) {
        
        // items that have been already calculated
        if(pt.cachedItems().containsKey(this)) {            
            items.add(this);
            for(LRItem item : pt.cachedItems().get(this)) {
                if(!items.contains(item)) {
                    item.process(items, symbol_items);
                }
                items.add(item);
            }              

            if(this.dotPosition < prod.rightHand().size()) {
                symbol_items.put(prod.rightHand().get(this.dotPosition), this);
            }
        } else {
            items.add(this);
            
            Set<LRItem> derivedItems = Sets.newHashSet();

            if(dotPosition < prod.rightHand().size()) {
                Symbol s_at_dot = prod.rightHand().get(dotPosition);

                for(IProduction p : pt.normalizedGrammar().symbol_prods.get(s_at_dot)) {

                    if(!isPriorityConflict(this, p)) {
                        // p might be the problematic contextual production
                        if(pt.normalizedGrammar().contextual_prods.get(p) != null) {
                            p = pt.normalizedGrammar().contextual_prods.get(p);
                        }

                        LRItem newItem = new LRItem(p, 0, pt);
                        derivedItems.add(newItem);
                        
                        if(!items.contains(newItem)) {
                            newItem.process(items, symbol_items);
                        }
                    }
                }
            }

            pt.cachedItems().put(this, derivedItems);
            
            if(this.dotPosition < prod.rightHand().size()) {
                symbol_items.put(prod.rightHand().get(this.dotPosition), this);
            }
        }
    }

    public LRItem shiftDot() {
        return new LRItem(this.prod, this.dotPosition + 1, this.pt);
    }

    private boolean isPriorityConflict(LRItem item, IProduction p) {
        IProduction higher = item.prod;
        IProduction lower = p;
        
        

        if(higher instanceof ContextualProduction) {
            higher = ((ContextualProduction) higher).getOrigProduction();
        }

        if(lower instanceof ContextualProduction) {
            lower = ((ContextualProduction) lower).getOrigProduction();
        }

        Priority prio = new Priority(higher, lower, false);
        if(pt.normalizedGrammar().priorities().containsKey(prio)) {
            Set<Integer> arguments = pt.normalizedGrammar().priorities().get(prio);
            for(int i : arguments) {
                if(i == item.dotPosition) {
                    return true;
                }
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

        return buf;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dotPosition;
        result = prime * result + prod_label;
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
        if(dotPosition != other.dotPosition)
            return false;
        if(prod_label != other.prod_label)
            return false;
        return true;
    }

    

}
