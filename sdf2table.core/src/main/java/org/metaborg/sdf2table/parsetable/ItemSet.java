package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.Stack;

import org.metaborg.sdf2table.core.CollisionSet;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.grammar.UndefinedSymbol;

public class ItemSet extends CollisionSet<Item>{
	int _hash = -1;
	
	private static class ItemSetConstructor implements CollectionConstructor<ItemSet, Item>{
		public ItemSet create(){
			return new ItemSet();
		}
		
		public ItemSet create(ItemSet other){
			return new ItemSet(other);
		}
	}
	
	private static final ItemSetConstructor _constructor = new ItemSetConstructor();
	
	public ItemSet(){
		super();
	}
	
	public ItemSet(ItemSet copy){
		super();
		
		for(Item i : copy){
			add(new Item(i));
		}
	}
	
	public ItemSet closure() throws UndefinedSymbol{
		ItemSet nset = new ItemSet();
		
		for(Item i : this){
			nset.addAll(i.closure());
		}
		
		return nset;
	}
	
	public boolean conflicts(Production p){
		for(Item i : this){
			if(p.product().equals(i.nextSymbol()) && !i.shallowConflicts(p))
				return false;
		}
		return true;
	}
	
	public MergingMap<ItemSet, Item> shift(){
		MergingMap<ItemSet, Item> map = new MergingMap<>(_constructor);
		
		for(Item i : this){
			if(!i.isFinal()){
				Stack<Trigger> stack = i.pendingTriggers();
				Item shifted = i.shift();
				
				while(!stack.isEmpty()){
					map.put(stack.pop(), shifted);
				}
			}
		}
		
		return map;
	}
	
	@Override
    public boolean equals(Object o){
		if(o != null && o instanceof ItemSet){
			ItemSet set = (ItemSet)o;
			
			if(set.size() == this.size()){
				for(Item i : this){
					if(!set.contains(i))
						return false;
				}
				return true;
			}
		}
		return false;
    }
	
	@Override
	public boolean add(Item i){
		_hash = -1;
		Item doppelganger = push(i);
		if(doppelganger == null)
			return true;
		
		doppelganger.addSources(i.sources());
		
		return false;
	}
	
	public void addSources(ItemSet items) {
		for(Item i : this){
			Item doppelganger = items.agent(i);
			if(doppelganger != null){
				i.addSources(doppelganger.sources());
			}
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends Item> i){
		_hash = -1;
		return super.addAll(i);
	}

    @Override
    public int hashCode(){
    	if(_hash == -1){
	        _hash = 0;
	        int k = 0;
	        
	        for(Item i : this){
	        	_hash += i.hashCode() * Math.pow(31.0, this.size()-1.0-k);
	        	++k;
	        }
    	}
        
        return _hash;
    }
}
