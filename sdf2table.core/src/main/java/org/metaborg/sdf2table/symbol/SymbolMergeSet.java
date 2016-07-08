package org.metaborg.sdf2table.symbol;

import java.util.Collection;
import java.util.HashSet;

public class SymbolMergeSet extends HashSet<Symbol>{
	private static final long serialVersionUID = 651663321869861338L;
	
	TerminalContainer _cc = null;
	
	@Override
	public boolean add(Symbol s){
		if(s instanceof Terminal){
			if(_cc == null)
				super.add(_cc = new TerminalContainer((Terminal)s));
			else
				_cc.set(_cc.union((Terminal)s));
			
			return true;
		}
		return super.add(s);
	}
	
	@Override
	public boolean addAll(Collection<? extends Symbol> symbols){
		boolean changed = false;
		for(Symbol s : symbols)
			changed |= add(s);
		return changed;
	}
}
