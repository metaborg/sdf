package org.metaborg.sdf2table.parsetable;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.grammar.UndefinedSymbol;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Sequence;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.Terminal;

/**
 * A state item.
 */
public class Item{
	Set<Item> _sources;
	Stack<Trigger> _pending_triggers;
	//Set<Trigger> _triggers;
	
	/**
	 * Production associated to this item.
	 */
	IProduction _prod;
	
	/**
	 * Cursor position.
	 */
	int _pos;
	
	/**
	 * String representation of this item.
	 */
	String _str;
	
	/**
	 * Reduce actions associated to this item.
	 */
	Set<Reduce> _reduce_actions;
	
	/**
	 * Cursor character for string representations.
	 */
	public static final String SEPARATOR = "•";
	
	/**
	 * Constructor.
	 * @param p item production.
	 * @param position cursor position.
	 */
	public Item(IProduction p){
		_prod = p;
		_pos = 0;
		_str = null;
		_sources = new HashSet<>();
	}
	
	public Item(IProduction p, int pos, Set<Item> sources){
		_prod = p;
		_pos = pos;
		_str = null;
		_sources = sources;
	}
	
	public Item(IProduction p, Item source){
		_prod = p;
		_pos = 0;
		_str = null;
		_sources = new HashSet<>();
		_sources.add(source);
	}
	
	public Item(Item copy){
		_prod = copy._prod;
		_pos = copy._pos;
		_str = copy._str;
		_sources = new HashSet<>();
		_sources.addAll(copy._sources);
	}
	
	/**
	 * Get the item production.
	 * @return A production.
	 */
	public IProduction production(){
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
	
	public Stack<Trigger> pendingTriggers(){
		if(_pending_triggers == null){
			_pending_triggers = new Stack<>();
			
			if(!isFinal()){
				Symbol next = nextSymbol();
				if(next instanceof NonTerminal){
					for(IProduction p : ((NonTerminal)next).productions()){
						if(!shallowConflicts(p)){
							_pending_triggers.add(p.label());
						}
					}
				}else{
					_pending_triggers.add((Terminal)next);
				}
			}
		}
		
		return _pending_triggers;
	}
	
	/*public Set<Trigger> triggers(){
		if(_triggers == null){
			_triggers = new HashSet<>();
			
			if(!isFinal()){
				Symbol next = nextSymbol();
				if(next instanceof NonTerminal){
					for(IProduction p : ((NonTerminal)next).productions()){
						if(!shallowConflicts(p.asProduction())){
							_triggers.add(p.label());
						}
					}
				}else{
					_triggers.add((Terminal)next);
				}
			}
		}
		
		return _triggers;
	}*/
	
	public void addSources(Set<Item> sources){
		_sources.addAll(sources);
	}
	
	public Set<Item> sources(){
		return _sources;
	}
	
	public boolean shallowConflicts(IProduction p){
		return _prod.shallowConflicts(p, _pos);
	}
	
	public ItemSet closure() throws UndefinedSymbol{
		ItemSet set = new ItemSet();
		close(set);
		return set;
	}
	
	public void close(ItemSet set) throws UndefinedSymbol{
		Queue<Item> queue = new LinkedList<>();
		queue.add(this);
		while(!queue.isEmpty()){
			Item i = queue.poll();
			i.doClose(set, queue);
		}
	}
	
	private void doClose(ItemSet set, Queue<Item> queue) throws UndefinedSymbol{
		if(set.add(this)){
			Symbol next = nextSymbol();
			if(next != null && !next.isTerminal()){
				Set<IProduction> prods = ((NonTerminal)next).productions();
				if(prods.isEmpty()){
					throw new UndefinedSymbol(next, _prod.asProduction());
				}
				for(IProduction p : prods){
					if(!shallowConflicts(p)){
						Item i = new Item(p, this);
						queue.add(i);
					}
				}
			}
		}
	}
	
	@Override
	public String toString(){
		if(_str == null){
			_str = "";
			for(int i = 0; i < _prod.symbols().size(); ++i){
				if(i == _pos)
					_str += SEPARATOR+" ";
				_str += _prod.symbols().get(i).toString()+" ";
			}
			if(_pos >= _prod.symbols().size())
				_str += SEPARATOR+" ";
			_str += "→ "+_prod.product().toString();
		}
		
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
		return new Item(_prod, _pos+1, _sources);
	}
	
	@Override
    public boolean equals(Object o){
		if(!(o instanceof Item))
			return false;
		Item i = (Item)o;
        return _prod.equals(i._prod) && _pos == i._pos;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
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
