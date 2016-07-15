package org.metaborg.sdf2table.symbol;

import java.util.HashSet;
import java.util.Set;

public class SymbolCollection {
	private Set<Symbol> _symbols;
	
	public SymbolCollection(){
		_symbols = new HashSet<>();
	}
	
	public Symbol get(Symbol symbol){
		for(Symbol s : _symbols){ // TODO take advantage of the symbol hash code.
			if(s.equals(symbol))
				return s;
		}
		return null;
	}
	
	public Symbol get(Symbol symbol, boolean create){
		Symbol s = get(symbol);
		if(s == null && create)
			_symbols.add(s = symbol);
		return s;
	}
}
