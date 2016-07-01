package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.metaborg.sdf2table.core.CollisionSet;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.grammar.UndefinedSymbol;

public class ItemSet extends CollisionSet<Item>{
	int _hash = -1;
	State _state;
	
	private static class ItemSetManager implements CollectionManager<ItemSet, Item>{
		public ItemSet create(){
			return new ItemSet((State)null);
		}
		
		public ItemSet create(ItemSet other){
			return new ItemSet(other);
		}

		@Override
		public Item copy(Item item){
			if(ParseTable.current().deepReduceConflictPolicy() == ParseTable.DeepReduceConflictPolicy.IGNORE)
				return item;
			return item.split();
		}
	}
	
	private static final ItemSetManager _constructor = new ItemSetManager();
	
	public ItemSet(State state){
		super();
		_state = state;
	}
	
	public ItemSet(ItemSet copy){
		super();
		_state = null;
		
		if(ParseTable.current().deepReduceConflictPolicy() == ParseTable.DeepReduceConflictPolicy.IGNORE){
			for(Item i : copy){
				add(i);
			}
		}else{
			for(Item i : copy){
				add(i.split());
			}
		}
	}
	
	public void setState(State state){
		_state = state;
	}
	
	public State state(){
		return _state;
	}
	
	public void close() throws UndefinedSymbol{
		/*ItemSet nset = new ItemSet(_state);
		
		for(Item i : this){
			nset.addAll(i.closure());
		}
		
		return nset;*/
		List<Item> kernel = new LinkedList<>(this);
		
		clear();
		_hash = -1;
		
		for(Item i : kernel){
			i.close(this);
		}
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
				Queue<Trigger> queue = i.pendingTriggers();
				
				if(ParseTable.current().deepReduceConflictPolicy() == ParseTable.DeepReduceConflictPolicy.IGNORE){
					Item shifted = i.shift();
					
					for(Trigger t : queue){
						map.put(t, shifted);
					}
				}else{
					while(!queue.isEmpty()){
						map.put(queue.poll(), i.shift());
					}
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
		if(doppelganger == null){
			i._set = this;
			return true;
		}
		
		doppelganger.merge(i);
		
		return false;
	}
	
	public void merge(ItemSet items) {
		/*Production prod = null;
		boolean uni = true;
		
		for(Item i : items){
			if(prod != null && !i.production().asProduction().equals(prod)){
				uni = false;
				break;
			}
			prod = i.production().asProduction();
		}
		
		if(uni && items.size() > 1)
			System.err.println("hey");*/
		
		for(Item i : items){
			Item doppelganger = agent(i);
			if(doppelganger != null){
				doppelganger.merge(i);
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
