package org.metaborg.sdf2table.core;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollisionSet<Value> implements Set<Value>{
	private transient Hashtable<Value, Value> _tbl;
	int _initial_capacity = 11;
	float _load_factor = 0.75f;
	
	List<Value> _list = new LinkedList<>();
	
	public CollisionSet(){
		_tbl = new Hashtable<>();
	}
	
	public CollisionSet(int initialCapacity, float loadFactor){
		_initial_capacity = initialCapacity;
		_load_factor = loadFactor;
		_tbl = new Hashtable<>(initialCapacity, loadFactor);
	}
	
	public CollisionSet(CollisionSet<Value> copy){
		_initial_capacity = copy._initial_capacity;
		_load_factor = copy._load_factor;
		_tbl = new Hashtable<>(copy._tbl);
	}
	
	public CollisionSet(Collection<? extends Value> c){
		_tbl = new Hashtable<>();
		addAll(c);
	}
	
	public CollisionSet(Collection<? extends Value> c, int initialCapacity, float loadFactor){
		_initial_capacity = initialCapacity;
		_load_factor = loadFactor;
		_tbl = new Hashtable<>(initialCapacity, loadFactor);
		addAll(c);
	}
	
	@Override
	public boolean add(Value e) {
		return push(e) == null;
	}
	
	public Value push(Value e){
		Value v = _tbl.get(e);
		if(v != null)
			return v;
		_tbl.put(e, e);
		_list.add(e);
		return null;
	}
	
	public Value agent(Value e){
		if(e == null)
			return null;
		return _tbl.get(e);
	}

	@Override
	public boolean addAll(Collection<? extends Value> c){
		boolean changed = false;
		for(Value e : c){
			if(add(e))
				changed = true;
		}
		return changed;
	}

	@Override
	public void clear() {
		_tbl.clear();
	}

	@Override
	public boolean contains(Object o) {
		return _tbl.containsKey(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c){
			if(!contains(o))
				return false;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return _tbl.isEmpty();
	}

	@Override
	public Iterator<Value> iterator() {
		return _list.iterator();
	}

	@Override
	public boolean remove(Object o){
		if(_tbl.remove(o) != null){
			_list.remove(o);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		for(Object o : c){
			if(remove(o))
				changed = true;
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Hashtable<Value, Value> tbl = new Hashtable<>(_initial_capacity, _load_factor);
		_list.clear();
		
		for(Object o : c){
			Value e = _tbl.get(o);
			if(e != null){
				tbl.put(e, e);
				_list.add(e);
			}
		}
		
		if(tbl.size() != size()){
			_tbl = tbl;
			return true;
		}
		
		return false;
	}

	@Override
	public int size() {
		return _tbl.size();
	}

	@Override
	public Object[] toArray() {
		return _tbl.keySet().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return _tbl.keySet().toArray(a);
	}
	
	@Override
	public String toString(){
		String str = "{";
		for(Value e : this){
			if(str.length() > 1)
				str += ", ";
			str += e.toString();
		}
		str += "}";
		return str;
	}
}
