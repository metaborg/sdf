package org.metaborg.sdf2table.parsetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.Terminal;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class ContextualSymbol extends NonTerminal{
	List<IProduction> _productions = null;
	Symbol _symbol;
	Syntax _syntax;
	String _str;
	
	Context _left;
	Context _right;
	
	private ContextualSymbol(Context left, Symbol symbol, Context right){
		if(symbol instanceof ContextualSymbol){
			ContextualSymbol cs = (ContextualSymbol)symbol;
			
			_left = cs._left.union(left);
			_right = cs._right.union(right);
			
			_symbol = cs.symbol();
		}else{
			if(left == null)
				_left = new Context();
			else
				_left = left;
			
			if(right == null)
				_right = new Context();
			else
				_right = right;
			
			_symbol = symbol;
		}
	}
	
	public static ContextualSymbol unique(Context left, Symbol symbol, Context right){
		return (ContextualSymbol)ParseTable.unique(new ContextualSymbol(left, symbol, right));
	}
	
	public Symbol nonContextual(){
		return _symbol;
	}
	
	@Override
	public List<IProduction> productions(){
		if(_productions == null){
			_productions = new ArrayList<>();
			for(IProduction p : _symbol.productions()){
				if(!p.isEpsilon()){
					for(int l = 0; l < p.size(); ++l){
						Symbol ls = p.symbol(l);
						
						for(int r = p.size()-1; r >= l; ++r){
							Symbol rs = p.symbol(r);
							
							if(!p.rightSet().contains(ls.nonContextual()) && !p.leftSet().contains(rs.nonContextual())){
								List<Symbol> rhs = new ArrayList<>();
								for(int i = 0; i < p.size(); ++i){
									Symbol s = p.symbol(i);
									if(s instanceof Terminal){
										rhs.add(s);
									}else{
										Symbol symbol;
										
										if(i == l || i == r){
											Context left, right;
											
											if(i == l && i == r){
												Set<PriorityLevel> lprio = p.asProduction().priorities().priorityLevels(l);
												Set<PriorityLevel> rprio = p.asProduction().priorities().priorityLevels(r);
												
												left = _left.without(lprio).union(rprio);
												right = _right.without(rprio).union(lprio);
											}else if(i == l){
												Set<PriorityLevel> lprio = p.asProduction().priorities().priorityLevels(l);
												
												left = _left.without(lprio);
												right = new Context(lprio);
											}else{ // if(i == r)
												Set<PriorityLevel> rprio = p.asProduction().priorities().priorityLevels(r);
												
												left = new Context(rprio);
												right = _right.without(rprio);
											}
											
											symbol = ContextualSymbol.unique(left, NonEpsilon.unique(s), right);
										}else if(i < l || i > r){
											symbol = Epsilon.unique(s.nonContextual());
										}else{
											symbol = ContextualSymbol.unique(null, s.nonContextual(), null);
										}
										
										if(symbol.productions().isEmpty()) // This production is not possible
											continue;
										rhs.add(symbol);
									}
								}
								
								_productions.add(new ContextualProduction(p.asProduction(), this, rhs));
							}
							
							if(rs instanceof Terminal)
								break;
						}
						
						if(ls instanceof Terminal)
							break;
					}
				}else{
					_productions.add(new ContextualProduction(p.asProduction(), this, p.symbols()));
				}
			}
		}
		return _productions;
	}
	
	public Symbol symbol(){
		return _symbol;
	}

	@Override
	public boolean equals(Symbol other){
		if(other != null && other instanceof ContextualSymbol){
			ContextualSymbol cs = (ContextualSymbol)other;
			return other == this || (cs._symbol.equals(_symbol) && cs._left.equals(_left) && cs._right.equals(_right));
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}

	@Override
	public String toString(){
		if(_str == null)
			_str = "<"+_left.toString()+":"+_symbol.toString()+":"+_right.toString()+">";
		return _str;
	}

	@Override
	public IStrategoTerm toATerm() {
		return _symbol.toATerm();
	}
}
