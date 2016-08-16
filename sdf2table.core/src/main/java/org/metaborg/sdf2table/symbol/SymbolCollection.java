package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.core.CollisionSet;

public class SymbolCollection {
	private CollisionSet<Symbol> _symbols;
	
	public SymbolCollection(){
		_symbols = new CollisionSet<>();
	}
	
	public Symbol get(Symbol symbol){
		Symbol s =_symbols.agent(symbol);
		return s;
	}
	
	public int count(){
		return _symbols.size();
	}
	
	public Symbol get(Symbol symbol, boolean create){
		Symbol s = get(symbol);
		if(s == null && create)
			_symbols.add(s = symbol);
		return s;
	}
}
