package org.metaborg.sdf2table.symbol;

import java.util.HashSet;
import java.util.Set;

import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.parsetable.ContextualSymbol;

public abstract class NonTerminal extends Symbol{
	Set<ContextualSymbol> _contextual_symbols = null;
	
	public abstract Set<CharClass> followRestrictions();
	
	/**
	 * Get the list of productions that produce this symbol
	 * @return A list of productions.
	 */
	public abstract Set<Production> productions();
	
	public abstract Set<SyntaxProduction> leftDerivations();
	
	public abstract Set<SyntaxProduction> rightDerivations();
	
	public void addContextualSymbol(ContextualSymbol s){
		if(_contextual_symbols == null)
			_contextual_symbols = new HashSet<>();
		_contextual_symbols.add(s);
	}
	
	@Override
	public boolean nonEpsilon(){
		return false;
	}
	
	@Override
	public boolean isEpsilon(){
		for(Production p : productions()){
			if(!p.isEmpty())
				return false;
		}
		return true;
	}
	
	public Terminal getFirst(){
		TerminalContainer cc = new TerminalContainer();
		for(Production p : productions())
			cc.add(p.firstSet());
		return cc.contents();
	}
	
	public void addProduction(Production p){
		if(p.product() == this)
			productions().add(p);
	}
	
	@Override
	public boolean isTerminal(){
		return false;
	}
}
