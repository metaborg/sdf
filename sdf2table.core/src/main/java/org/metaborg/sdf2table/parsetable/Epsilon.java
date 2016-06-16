package org.metaborg.sdf2table.parsetable;

import java.util.List;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class Epsilon extends Symbol{
	Symbol _symbol;
	List<IProduction> _productions;
	
	public Epsilon(Symbol symbol){
		if(symbol != null && symbol instanceof Epsilon)
			symbol = ((Epsilon)symbol)._symbol;
		_symbol = symbol;
	}
	
	public static Epsilon unique(Symbol symbol){
		return (Epsilon)ParseTable.unique(new Epsilon(symbol));
	}
	
	@Override
	public List<IProduction> productions(){
		if(_productions == null){
			for(IProduction p : _symbol.productions()){
				if(p.isEpsilon()){
					_productions.add(p);
				}
			}
		}
		return _productions;
	}

	@Override
	public boolean equals(Symbol other){
		if(other != null && other instanceof Epsilon){
			Epsilon e = (Epsilon)other;
			return e._symbol == _symbol;
		}
		return false;
	}

	@Override
	public String toString(){
		return _symbol.toString()+"ε";
	}

	@Override
	public IStrategoTerm toATerm(){
		return _symbol.toATerm();
	}
}
