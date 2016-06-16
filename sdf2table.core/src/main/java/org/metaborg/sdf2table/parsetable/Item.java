package org.metaborg.sdf2table.parsetable;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.UndefinedSymbol;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.Sequence;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.Terminal;

/**
 * A state item.
 */
public class Item{
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
	}
	
	public Item(IProduction p, int pos){
		_prod = p;
		_pos = pos;
		_str = null;
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
	
	public boolean conflicts(IProduction p){
		if(_prod instanceof Production && p instanceof Production)
			((Production)_prod).conflicts((Production)p, _pos);
		return false;
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
				List<IProduction> prods = next.productions();
				if(prods.isEmpty()){
					throw new UndefinedSymbol(next, _prod.asProduction());
				}
				for(IProduction p : prods){
					if(!conflicts(p)){
						Item i = new Item(p, 0);
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
				Terminal t = _prod.followSet().firstSet();
				Terminal non_litigious = t.except(_prod.product().followRestrictions().toArray(new CharClass[0]));
				if(non_litigious != null)
					_reduce_actions.add(new Reduce(non_litigious, _prod));
				
				for(CharClass cc : _prod.product().followRestrictions()){
					if(cc instanceof Sequence){
						Terminal litigious = cc.firstTerminal().inter(t);
						if(litigious != null){
							_reduce_actions.add(new Reduce(litigious, _prod, (Sequence)cc));
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
		return new Item(_prod, _pos+1);
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
		String str = "<td>"+Utilities.toHtml(this.toString())+"</td>";
		return str;
	}
}
