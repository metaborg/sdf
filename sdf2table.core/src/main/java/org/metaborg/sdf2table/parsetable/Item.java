package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.core.Benchmark;
import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.grammar.UndefinedSymbolException;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Sequence;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.Terminal;

/**
 * A state item.
 * <p>
 * An item represents the potential position of the parser in a production.
 * It consists in a Production, and a position. But not only.
 * <p>
 * In the case where ParseTable.current().deepReduceConflictPolicy() == MERGE, some new labels
 * are created at each call of {@link State#reduce()}. We need to be able to propagate those
 * labels to the relevant items, which can then be shifted.
 * <p>
 * If an item I of the form "A B - N. -> D" produce some reduce labels (also called triggers here).
 * Those labels must be propagated to the items that produces the initial item I0 of the form
 * ".A B - N -> D".
 * So for each item, we must keep track of "ancestors" items, that once shifted produce this item,
 * and for initial item (position = 0), we need to keep track of a list of sources, that
 * produce this item when {@link Item#close(ItemSet)} is called.
 * <p>
 * The methods {@link #propagateLabels(List)} also needs a list of successors.
 */
public class Item{
	/**
	 * Cursor character for string representations.
	 */
	public static final String SEPARATOR = "•";
	
	/**
	 * Item set in which this item occurs.
	 */
	ItemSet _set;
	
	/**
	 * Items that produce {@code this} in there closure.
	 */
	List<Item> _sources = null;
	
	/**
	 * Items that produce {@code this} once shifted.
	 */
	List<Item> _ancestors = new LinkedList<>();
	
	/**
	 * Items produced when {@link Item#shift()} is called.
	 */
	List<Item> _successors = new LinkedList<>();

	/**
	 * Non treated triggers.
	 * Those triggers will be handled in the next {@link #shift()} call.
	 */
	Queue<Trigger> _pending_triggers;
	
	/**
	 * Triggers that can be used to shift this item.
	 */
	Set<Trigger> _triggers = new HashSet<>();
	
	/**
	 * Production associated to this item.
	 */
	Production _prod;
	
	/**
	 * Cursor position.
	 */
	int _pos;
	
	/**
	 * String representation of this item.
	 */
	int _hash_code = -1;
	
	/**
	 * Reduce actions associated to this item.
	 */
	Set<Reduce> _reduce_actions;
	
	/**
	 * Default constructor.
	 * @param p item production.
	 * @param position cursor position.
	 * 
	 * Produce an item without any source nor ancestor.
	 */
	public Item(ItemSet set, Production p){
		_prod = p;
		_pos = 0;
		_set = set;
	}
	
	/**
	 * Construct an item shifted from an other item.
	 * @param ancestor Previous item.
	 */
	public Item(Item ancestor){
		_prod = ancestor._prod;
		_pos = ancestor._pos+1;
		_set = null;
		
		_ancestors.add(ancestor);
		ancestor._successors.add(this);
	}
	
	public Item(Production p, Item source){
		_prod = p;
		_pos = 0;
		_sources = new LinkedList<>();
		_sources.add(source);
		_set = source._set;
	}
	
	public Item split(){
		Item item = new Item(_set, _prod);
		item._pos = _pos;
		item._hash_code = _hash_code;
		item._ancestors.addAll(_ancestors);
		
		for(Item i : _ancestors)
			i._successors.add(item);
		
		return item;
	}
	
	/**
	 * Merge two identic items.
	 * @param branch the other item to merge
	 * 
	 * This method is called in {@link ItemSet#merge(ItemSet)}, which merge two item sets.
	 * It must be called on the item we want to keep, the other one can be deleted after that operation.
	 * <p>
	 * We suppose that the two items have not the same ancestors. {@link #merge(Item)} will connect all ancestors of
	 * {@code branch} to this item, and disconnect them from {@code branch}. Potential source items are also copied.
	 * <p>
	 * This item may belong to a state that have already propagated known reduce triggers (labels) for this item,
	 * so we must also re-propagate those triggers to the new branch.
	 */
	public void merge(Item branch){
		if(branch != this){ // always, in theory...
			propagateLabels(branch._ancestors); // propagate triggers to the new branch.
			
			// for each top-member of the branch (ancestors of the previous root).
			for(Item i : branch._ancestors){
				boolean known = false; // if the ancestors is already known (in this._ancestors).
				
				// here it is important to use an Iterator instead of List.remove and List.contains because
				// we want to compare instances (i.e. we don't want to use Item.equals).
				Iterator<Item> it = i._successors.iterator();
				while(it.hasNext()){
					Item item = it.next();
					
					if(item == branch)
						it.remove(); // we remove the previous root
					
					if(item == this)
						known = true; // this item already know #this. So we must know it already.
				}
				
				if(!known){
					i._successors.add(this); // we add #this as a successor...
					_ancestors.add(i); // ...so it is an ancestor.
				}
			}
			
			if(branch._sources != null){ // We register all sources items
				_sources.addAll(branch._sources);
			}
			
			branch._ancestors.clear(); // clean some useless memory.
		}
	}
	
	/**
	 * Propagate known trigger labels to the sources of all {@code items}.
	 * @param items The list of items where the labels must be propagated into.
	 * 
	 * This method fetch all trigger labels that shift this production, and then
	 * propagate them to all {@code items} sources.
	 */
	private void propagateLabels(List<Item> items){
		if(_set.state() != null){
			if(isFinal()){
				for(Item i : items){
					i.addSourceLabels(_set.state().reduceLabels(_prod)); // propagate back all reduce labels.
				}
			}else{
				for(Item i : _successors){
					i.propagateLabels(items);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param labels
	 */
	public void addSourceLabels(Collection<Label> labels){
		if(_sources == null){
			for(Item i : _ancestors){
				i.addSourceLabels(labels);
			}
		}else{
			for(Item src : _sources){
				src.addTriggers(labels);
			}
		}
	}

	public List<Item> ancestors(){
		return _ancestors;
	}
	
	/**
	 * Get the item production.
	 * @return A production.
	 */
	public Production production(){
		return _prod;
	}
	
	/**
	 * Get the symbol positioned just after the cursor.
	 * @return A symbol, or null if the cursor is at the end of the item.
	 */
	public Symbol nextSymbol(){
		if(_pos < _prod.symbols().size()){
			return _prod.symbols().get(_pos);
		}
		return null;
	}
	
	/**
	 * Cursor position.
	 */
	public int position(){
		return _pos;
	}
	
	public boolean addTrigger(Trigger trigger){
		if(_triggers.add(trigger)){
			pendingTriggers().add(trigger);
			_set.state().requestUpdate();
			return true;
		}
		return false;
	}
	
	public boolean addTriggers(Collection<? extends Trigger> triggers){
		boolean changed = false;
		
		for(Trigger t : triggers){
			if(addTrigger(t))
				changed = true;
		}
		
		return changed;
	}
	
	public Queue<Trigger> pendingTriggers(){
		if(_pending_triggers == null){
			/*if(toString().equals("[\\A-\\Z\\_\\a-\\z] • <{}:[\\0-\\9\\A-\\Z\\_\\a-\\z]*-LEX:{}> → <{}:ID-LEX:{}>"))
				System.err.println("bah");*/
			_pending_triggers = new LinkedList<>();
			
			if(!isFinal()){
				Symbol next = nextSymbol();
				if(next instanceof NonTerminal){
					if(ParseTable.current().deepReduceConflictPolicy() == ParseTable.DeepReduceConflictPolicy.IGNORE){
						for(Production p : ((NonTerminal)next).productions()){
							if(!shallowConflicts(p)){
								_pending_triggers.add(p.label());
							}
						}
					}
				}else{
					_pending_triggers.add((Terminal)next);
				}
			}
		}
		
		return _pending_triggers;
	}
	
	public Set<Trigger> triggers(){
		return _triggers;
	}
	
	public boolean shallowConflicts(Production p){
		return _prod.shallowConflicts(p, _pos);
	}
	
	public void close(ItemSet set) throws UndefinedSymbolException{
		Queue<Item> queue = new LinkedList<>();
		this.doClose(set, queue);
		while(!queue.isEmpty()){
			Item i = queue.poll();
			i.doClose(set, queue);
		}
	}
	
	static Benchmark.DistributedTask _t_close;
	static Benchmark.DistributedTask _t_equals;
	
	private void doClose(ItemSet set, Queue<Item> queue) throws UndefinedSymbolException{
		Item self = this;
		/*if(ParseTable.current().deepReduceConflictPolicy() == ParseTable.DeepReduceConflictPolicy.MERGE)
			self = new Item(this);*/
		
		Symbol next = nextSymbol();
		if(next != null && !next.isTerminal()){
			Set<Production> prods = ((NonTerminal)next).productions();
			if(prods.isEmpty()){
				throw new UndefinedSymbolException(next, _prod.syntaxProduction());
			}
			for(Production p : prods){
				if(!shallowConflicts(p)){
					Item i = new Item(p, self);
					if(set.add(i))
						queue.add(i);
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String _str = "";
		for(int i = 0; i < _prod.symbols().size(); ++i){
			if(i == _pos)
				_str += SEPARATOR+" ";
			_str += _prod.symbols().get(i).toString()+" ";
		}
		if(_pos >= _prod.symbols().size())
			_str += SEPARATOR+" ";
		_str += "→ "+_prod.product().toString();
		
		return _str;
	}
	
	public boolean isFinal(){
		return _pos >= _prod.symbols().size();
	}
	
	public boolean isReduce(){
		return !reduceActions().isEmpty();
	}
	
	public Set<Reduce> reduceActions(){
		if(_reduce_actions == null){
			_reduce_actions = new LinkedHashSet<>();
			if(_pos >= _prod.symbols().size()){
				Terminal t = _prod.followSet();
				Terminal non_litigious = t.doExcept(_prod.product().followRestrictions().toArray(new CharClass[0]));
				if(non_litigious != null)
					_reduce_actions.add(new Reduce(this, non_litigious, _prod.label()));
				
				for(CharClass cc : _prod.product().followRestrictions()){
					if(cc instanceof Sequence){
						Terminal litigious = (Terminal)cc.firstTerminal().inter(t);
						if(litigious != null){
							_reduce_actions.add(new Reduce(this, litigious, _prod.label(), (Sequence)cc));
						}
					}
				}
			}
		}
		
		return _reduce_actions;
	}
	
	public Item shift(){
		if(isFinal())
			return null;
		return new Item(this); // shifted item
	}
	
	@Override
    public boolean equals(Object o){
		if(!(o instanceof Item))
			return false;
		
		Item i = (Item)o;
        boolean ok = _hash_code == i._hash_code && _pos == i._pos && _prod.equals(i._prod);
        
        return ok;
    }

    @Override
    public int hashCode(){
    	if(_hash_code == -1)
    		_hash_code = toString().hashCode();
    	return _hash_code;
    }
    
	public String digraph(){
		String str = "";
		for(int i = 0; i < _prod.symbols().size(); ++i){
			if(i == _pos)
				str += SEPARATOR+" ";
			str += _prod.symbols().get(i).graphviz()+" ";
		}
		if(_pos >= _prod.symbols().size())
			str += SEPARATOR+" ";
		str += "→ "+_prod.product().graphviz();
		
		return "<td>"+Utilities.toHtml(str)+"</td>";
	}
}
