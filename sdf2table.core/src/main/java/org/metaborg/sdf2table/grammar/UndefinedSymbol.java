package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.symbol.Symbol;

public class UndefinedSymbol extends Exception{
	private static final long serialVersionUID = -5263375916196593334L;
	
	Symbol _symbol;
	Production _production;
	
	public UndefinedSymbol(Symbol symbol, Production production){
		super("Undefined symbol `"+symbol.toString()+"' in production `"+production.toString()+"'");
		_symbol = symbol;
		_production = production;
	}
	
	public Symbol symbol(){
		return _symbol;
	}
	
	public Production production(){
		return _production;
	}
}
