package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.symbol.Symbol;

public class UndefinedSymbolException extends Exception{
	private static final long serialVersionUID = -5263375916196593334L;
	
	Symbol _symbol;
	SyntaxProduction _production;
	
	public UndefinedSymbolException(Symbol symbol, SyntaxProduction production){
		super("Undefined symbol `"+symbol.toString()+"' in production `"+production.toString()+"'");
		_symbol = symbol;
		_production = production;
	}
	
	public UndefinedSymbolException(Symbol symbol){
		super("Undefined symbol `"+symbol.toString()+"'");
		_symbol = symbol;
	}
	
	public Symbol symbol(){
		return _symbol;
	}
	
	public SyntaxProduction production(){
		return _production;
	}
}
