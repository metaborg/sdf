package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.Terminal;

public class ItemSet extends LinkedHashSet<Item>{
	private static final long serialVersionUID = 6828916657513723316L;
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
		super(copy);
	}
	
	public ItemSet closure(){
		ItemSet nset = new ItemSet();
		
		for(Item i : this){
			nset.addAll(i.closure());
		}
		
		return nset;
	}
	
	public boolean conflicts(Production p){
		for(Item i : this){
			if(p.product().equals(i.nextSymbol()) && !i.conflicts(p))
				return false;
		}
		return true;
	}
	
	public MergingMap<Trigger, ItemSet, Item> shift(){
		MergingMap<Trigger, ItemSet, Item> map = new MergingMap<Trigger, ItemSet, Item>(_constructor);
		
		for(Item i : this){
			if(!i.isFinal()){
				Symbol next = i.nextSymbol();
				
				if(next.isTerminal()){
					map.put((Terminal)next, i.shift());
				}else{
					for(Production p : next.getProductions()){
						if(!i.conflicts(p)){
							map.put(p, i.shift());
						}
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
		return super.add(i);
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
