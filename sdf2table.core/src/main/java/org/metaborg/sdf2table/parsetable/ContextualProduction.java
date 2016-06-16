package org.metaborg.sdf2table.parsetable;

import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.FirstSet;
import org.metaborg.sdf2table.grammar.FollowSet;
import org.metaborg.sdf2table.grammar.Follower;
import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;

public class ContextualProduction implements IProduction{
	Production _source;
	ContextualSymbol _symbol;
	List<Symbol> _rhs;
	int _id = -1;
	
	public ContextualProduction(Production source, ContextualSymbol symbol, List<Symbol> rhs){
		_source = source;
		_symbol = symbol;
		_rhs = rhs;
	}
	
	public int id(){
		if(_id == -1)
			_id = Production.nextId();
		return _id;
	}
	
	@Override
	public NonTerminal product() {
		return _symbol;
	}
	
	@Override
	public int size() {
		return _rhs.size();
	}
	
	public boolean isEmpty(){
		return _rhs.isEmpty();
	}
	
	public boolean isEpsilon(){
		return _source.isEpsilon();
	}
	
	@Override
	public Symbol symbol(int position) {
		return _rhs.get(position);
	}
	
	@SuppressWarnings("unchecked")
	public List<Symbol> symbols(){
		return (List<Symbol>)(Object)_rhs;
	}
	
	public List<Attribute> attributes(){
		return _source.attributes();
	}
	
	public FirstSet firstSet(){
		return _source.firstSet();
	}
	
	public FollowSet followSet(){
		return _source.followSet();
	}
	
	public Set<Symbol> leftSet(){
		return _source.leftSet();
	}
	
	public Set<Symbol> rightSet(){
		return _source.rightSet();
	}
	
	public Follower asFollower(){
		return (Follower)_source;
	}
	
	public Production asProduction(){
		return _source;
	}

	@Override
	public boolean isTerminal() {
		return _source.isTerminal();
	}
}
