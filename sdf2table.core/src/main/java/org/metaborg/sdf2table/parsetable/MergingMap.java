package org.metaborg.sdf2table.parsetable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.metaborg.sdf2table.symbol.Terminal;

import java.util.Set;

/**
 * A Hash map that avoid overlap between Terminals as keys.
 * @param <Key> Keys type
 * @param <Container>
 * @param <Value>
 */
public class MergingMap<Key, Container extends Collection<Value>, Value>{
	Map<Key, Container> _map;
	CollectionConstructor<Container, Value> _constructor;
	
	public MergingMap(CollectionConstructor<Container, Value> constructor){
		_map = new HashMap<Key, Container>();
		_constructor = constructor;
	}
	
	public Set<Entry<Key, Container>> entrySet(){
		return _map.entrySet();
	}
	
	@SuppressWarnings("unchecked")
	public void put(Key key, Value value){
		if(key == null)
			return;
		
		if(key instanceof Terminal){
			Terminal term = (Terminal)key;
			Map<Key, Container> nmap = new HashMap<>();
			
			for(Entry<Key, Container> e : _map.entrySet()){
				if(term != null && e.getKey() instanceof Terminal){
					Terminal with = term.inter((Terminal)e.getKey());
					
					if(with != null){
						Container set = _constructor.create(e.getValue());
						set.add(value);
						
						nmap.put((Key)with, set);
						
						Terminal without = ((Terminal)e.getKey()).except(with);
						if(without != null)
							nmap.put((Key)without, e.getValue());
						
						term = term.except(with);
					}else{
						nmap.put(e.getKey(), e.getValue());
					}
				}else{
					nmap.put(e.getKey(), e.getValue());
				}
			}
			
			if(term != null){
				Container set = _constructor.create();
				set.add(value);
				nmap.put((Key)term, set);
			}
			
			_map = nmap;
		}else{
			Container set = _map.get(key);
			if(set == null){
				_map.put(key, set = _constructor.create());
			}
			set.add(value);
		}
	}
}
