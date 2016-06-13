package org.metaborg.sdf2table.symbol;

public abstract class NonTerminal extends Symbol{
	@Override
	public boolean isTerminal(){
		return false;
	}
}
