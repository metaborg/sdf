package org.metaborg.sdf2table.parsetable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.Set;

import org.metaborg.sdf2table.core.CollisionSet;
import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.grammar.UndefinedSymbol;

public class ItemSet extends CollisionSet<Item>{
	int _hash = -1;
	//int[] _sig = null;
	
	State _state;
	Set<Item> _kernels = new CollisionSet<>();
	
	enum Status{
		OPEN,
		COMPLETE,
		CLOSING,
		CLOSED
	}
	
	Status _status = Status.OPEN;
	
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
	
	public void complete(){
		if(_status == Status.OPEN){
			_status = Status.COMPLETE;
			computeHashCode();
		}
	}
	
	public void close() throws UndefinedSymbol{
		//List<Item> kernel = new LinkedList<>(this);
		
		//clear();
		//_hash = -1;
		
		_status = Status.CLOSING;
		for(Item i : _kernels){
			i.close(this);
		}
		_status = Status.CLOSED;
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
		if(o == this)
			return true;
		if(o != null && o instanceof ItemSet && o.hashCode() == _hash){
			ItemSet set = (ItemSet)o;
			
			if(set._kernels.size() == _kernels.size()){
				for(Item i : _kernels){
					if(!set._kernels.contains(i))
						return false;
				}
				return true;
			}
			
			/*if(set.size() == this.size()){
				for(Item i : this){
					if(!set.contains(i))
						return false;
				}
				return true;
			}*/
			
			//return Arrays.equals(_sig, set._sig);
		}
		return false;
    }
	
	@Override
	public boolean add(Item i){
		if(_status == Status.CLOSED)
			System.err.println("sdf2table.ItemSet.add: warning: this item-set is closed!");
		Item doppelganger = push(i);
		if(doppelganger == null){
			i._set = this;
			if(_status == Status.OPEN)
				_kernels.add(i);
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
	
	public void computeHashCode(){
		_hash = 0;
		int[] _sig = new int[size()];
		int i = 0;
		for(Item item : _kernels){
			_sig[i] = item.hashCode();
        	++i;
		}
		Arrays.sort(_sig);
		/*for(i = 0; i < size(); ++i){
			_hash += _sig[i] * Math.pow(31.0, size()-1.0-i);
		}*/
		_hash = Utilities.hashCode(_sig);
	}

    @Override
    public int hashCode(){
        return _hash;
    }
}
