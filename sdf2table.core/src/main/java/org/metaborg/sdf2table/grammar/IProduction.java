package org.metaborg.sdf2table.grammar;

import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;

public interface IProduction extends Trigger{
	/**
	 * Production attributes.
	 */
	public enum Attribute{
		ASSOC_LEFT,
		ASSOC_RIGHT,
		
		BRACKET,
		REJECT,
		
		LONGEST_MATCH
	}
	
	public int id();
	
	public NonTerminal product();
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isEpsilon();
	
	public Symbol symbol(int position);
	
	public List<Symbol> symbols();
	
	public List<Attribute> attributes();
	
	public FirstSet firstSet();
	
	public FollowSet followSet();
	
	public Set<Symbol> leftSet();
	
	public Set<Symbol> rightSet();
	
	public Follower asFollower();
	
	public Production asProduction();
}
