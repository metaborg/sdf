package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.metaborg.sdf2table.grammar.Trigger;
/**
 * A Hash map that avoid overlap between Terminals as keys.
 * @param <Key> Keys type
 * @param <Container>
 * @param <Value>
 */
public class MergingMap<Container extends Collection<Value>, Value>{
	//Map<Trigger, Container> _map;
	
	public static class Entry<Key extends Trigger, Container>{
		Trigger _trigger;
		Container _c;
		
		public Entry(Trigger trigger, Container c){
			_trigger = trigger;
			_c = c;
		}
		
		public Trigger trigger(){
			return _trigger;
		}
		
		public void setTrigger(Trigger t){
			_trigger = t;
		}
		
		public Container container(){
			return _c;
		}
		
		public Trigger getKey(){
			return _trigger;
		}
		
		public Container getValue(){
			return _c;
		}
	}
	
	List<Entry<Trigger, Container>> _entries = new LinkedList<>();
	CollectionManager<Container, Value> _manager;
	
	public MergingMap(CollectionManager<Container, Value> constructor){
		//_map = new HashMap<Trigger, Container>();
		_manager = constructor;
	}
	
	/*public Set<Entry<Trigger, Container>> entrySet(){
		return _map.entrySet();
	}*/
	
	public List<Entry<Trigger, Container>> entrySet(){
		return _entries;
	}
	
	/*public List<Entry<Container>> entries(){
		return _entries;
	}*/
	
	public void put(Trigger key, Value value){
		if(key == null)
			return;
		
		boolean need_copy = false;
		
		ListIterator<Entry<Trigger, Container>> it = _entries.listIterator();
		
		while(key != null && it.hasNext()){
			Entry<Trigger, Container> e = it.next();
			
			if(key.equals(e.trigger())){
				if(need_copy)
					value = _manager.copy(value);
				e.container().add(value);
				need_copy = true;
				
				key = null;
			}else{
				Trigger inter = key.inter(e.trigger());
				
				if(inter != null){
					Trigger complmt = e.trigger().except(inter);
					
					if(complmt == null){
						if(need_copy)
							value = _manager.copy(value);
						e.container().add(value);
						need_copy = true;
					}else{
						Container set = _manager.create(e.container());
						if(need_copy)
							value = _manager.copy(value);
						set.add(value);
						need_copy = true;
						it.add(new Entry<>(inter, set));
						
						e.setTrigger(complmt);
					}
					
					key = key.except(inter);
				}
			}
		}
		
		if(key != null){
			Container set = _manager.create();
			if(need_copy)
				value = _manager.copy(value);
			set.add(value);
			need_copy = true;

			_entries.add(new Entry<>(key, set));
		}
		
		/*boolean need_copy = false;
		
		Map<Trigger, Container> nmap = new HashMap<>();
		
		for(Entry<Trigger, Container> e : _map.entrySet()){
			if(key == null){
				nmap.put(e.getKey(), e.getValue());
			}else{
				if(key.equals(e.getKey())){
					Container set = e.getValue();
					if(need_copy)
						value = _manager.copy(value);
					set.add(value);
					need_copy = true;
					
					nmap.put(key, set);
					key = null;
				}else{
					Trigger with = key.inter(e.getKey());
					
					if(with != null){
						Container set = _manager.create(e.getValue());
						if(need_copy)
							value = _manager.copy(value);
						set.add(value);
						need_copy = true;
						
						nmap.put(with, set);
						
						Trigger without = e.getKey().except(with);
						if(without != null){
							nmap.put(without, e.getValue());
						}
						
						key = key.except(with);
					}else{
						nmap.put(e.getKey(), e.getValue());
					}
				}
			}
		}
		
		if(key != null){
			Container set = _manager.create();
			if(need_copy)
				value = _manager.copy(value);
			set.add(value);
			need_copy = true;
			nmap.put(key, set);
		}
		
		_map = nmap;*/
	}
}
