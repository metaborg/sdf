package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.metaborg.sdf2table.grammar.IProduction;

public abstract class NonTerminal extends Symbol{
	private List<IProduction> _productions = new ArrayList<>();
	
	/**
	 * Get the list of productions that produce this symbol
	 * @return A list of productions.
	 */
	public List<IProduction> productions(){
		return _productions;
	}
	
	public void addProduction(IProduction p){
		if(p.product() == this)
			_productions.add(p);
	}
	
	@Override
	public boolean isTerminal(){
		return false;
	}
}
