package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.metaborg.sdf2table.grammar.Trigger;

import java.util.Set;

/**
 * A Hash map that avoid overlap between Terminals as keys.
 * @param <Key> Keys type
 * @param <Container>
 * @param <Value>
 */
public class MergingMap<Container extends Collection<Value>, Value>{
	Map<Trigger, Container> _map;
	CollectionManager<Container, Value> _manager;
	
	public MergingMap(CollectionManager<Container, Value> constructor){
		_map = new HashMap<Trigger, Container>();
		_manager = constructor;
	}
	
	public Set<Entry<Trigger, Container>> entrySet(){
		return _map.entrySet();
	}
	
	public void put(Trigger key, Value value){
		if(key == null)
			return;
		
		boolean need_copy = false;
		
		//if(key.isTerminal()){
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
			
			_map = nmap;
		/*}else{
			Container set = _map.get(key);
			if(set == null){
				_map.put(key, set = _manager.create());
			}
			set.add(value);
		}*/
	}
}
