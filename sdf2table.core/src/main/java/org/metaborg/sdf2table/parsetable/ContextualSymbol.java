package org.metaborg.sdf2table.parsetable;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.grammar.UndefinedSymbolException;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class ContextualSymbol extends NonTerminal{
	public enum Filter{
		NONE,
		LAYOUT_ONLY,
		REJECT_LAYOUT
	}
	
	static final Set<ContextualSymbol> _to_validate = new HashSet<ContextualSymbol>();
	
	Set<ContextualProduction> _productions = null;
	Set<ContextualProduction> _dependants = new HashSet<>();
	
	boolean _valid = false;
	
	NonTerminal _symbol;
	
	Syntax _syntax;
	
	Context _left;
	Context _right;
	
	Filter _filter;
	
	private ContextualSymbol(Context left, NonTerminal symbol, Context right, Filter filter){
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
		
		_filter = filter;
	}
	
	/**
	 * Must be called after {@link ContextualProduction#validateAll()}.
	 */
	static public void validateAll(){
		for(ContextualSymbol s : _to_validate){
			s.validate();
		}
		
		for(ContextualSymbol s : _to_validate){
			s.filterProductions();
		}
		_to_validate.clear();
	}
	
	public void validate(){
		if(!_valid){
			for(ContextualProduction p : _productions){
				if(p.isValid()){
					_valid = true;
					_symbol.addContextualSymbol(this);
					//
					for(ContextualProduction dep : _dependants){
						dep.validate();
					}
					_dependants = null;
					return;
				}
			}
		}
	}
	
	/**
	 * Remove all invalid productions.
	 */
	public void filterProductions(){
		Set<ContextualProduction> fprods = new HashSet<>();
		for(ContextualProduction p : _productions){
			if(p.isValid())
				fprods.add(p);
		}
		
		_productions = fprods;
	}
	
	public boolean isValid(){
		return _valid;
	}
	
	public void addDependant(ContextualProduction dep){
		if(dep != null)
			_dependants.add(dep);
	}
	
	public Filter filter(){
		return _filter;
	}
	
	public Context leftContext(){
		return _left;
	}
	
	public Context rightContext(){
		return _right;
	}
	
	@Override
	public boolean isLayout(){
		return _symbol.isLayout();
	}
	
	@Override
	public boolean isEpsilon(){
		return _filter == Filter.LAYOUT_ONLY || _symbol.isLayout();
	}
	
	@Override
	public boolean nonEpsilon(){
		return _filter == Filter.REJECT_LAYOUT || _symbol.nonEpsilon();
	}
	
	
	public static NonTerminal unique(Context left, NonTerminal symbol, Context right, Filter filter) throws UndefinedSymbolException{
		if(symbol instanceof ContextualSymbol){
			ContextualSymbol cs = (ContextualSymbol)symbol;
			switch(cs._filter){
			case LAYOUT_ONLY:
				if(filter == Filter.REJECT_LAYOUT)
					return null;
				filter = Filter.LAYOUT_ONLY;
				break;
			case REJECT_LAYOUT:
				if(filter == Filter.LAYOUT_ONLY)
					return null;
				filter = Filter.REJECT_LAYOUT;
				break;
			default:
				break;
			}
		}
		
		if(filter == Filter.REJECT_LAYOUT && symbol.isLayout())
			return null;
		if(filter == Filter.LAYOUT_ONLY && symbol.isLayout())
			filter = Filter.NONE;
		
		ContextualSymbol e = new ContextualSymbol(left, symbol, right, filter);
		ContextualSymbol u = (ContextualSymbol)ParseTable.unique(e);
		if(e == u)
			e.computeProductions();
		
		return u;
	}
	
	@Override
	public Set<CharClass> followRestrictions(){
		return _symbol.followRestrictions();
	}
	
	public Symbol nonContextual(){
		return _symbol;
	}
	
	public void computeProductions() throws UndefinedSymbolException{
		if(_productions == null){
			_productions = new LinkedHashSet<>();
			
			for(Production p : _symbol.productions()){
				p.contextualize(this, _productions);
			}
			
			_to_validate.add(this);
		}
	}
	
	/*private void addProductions(Collection<? extends ContextualProduction> prods){
		for(ContextualProduction p : prods){
			addProduction(p);
		}
	}*/
	
	/*private void addProduction(ContextualProduction prod){
		_productions.add(prod);
		prod.addDependant(this);
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Production> productions(){
		return (Set<Production>)(Object)_productions;
	}
	
	private Set<SyntaxProduction> _left_deriv = null;
	private Set<SyntaxProduction> _right_deriv = null;
	
	@Override
	public Set<SyntaxProduction> leftDerivations(){
		if(_left_deriv == null){
			_left_deriv = new HashSet<>();
			Set<SyntaxProduction> set = _symbol.leftDerivations();
			for(SyntaxProduction p : set){
				if(!_left.conflictsLeft(p))
					_left_deriv.add(p);
			}
		}
		return _left_deriv;
	}
	
	@Override
	public Set<SyntaxProduction> rightDerivations(){
		if(_right_deriv == null){
			_right_deriv = new HashSet<>();
			Set<SyntaxProduction> set = _symbol.leftDerivations();
			for(SyntaxProduction p : set){
				if(!_right.conflictsLeft(p))
					_right_deriv.add(p);
			}
		}
		return _right_deriv;
	}
	
	public NonTerminal symbol(){
		return _symbol;
	}

	@Override
	public boolean equals(Object other){
		if(other != null && other instanceof ContextualSymbol && other.hashCode() == hashCode()){
			ContextualSymbol cs = (ContextualSymbol)other;
			return other == this || (cs._filter == _filter && cs._left.equals(_left) && cs._symbol.equals(_symbol) && cs._right.equals(_right));
		}
		return false;
	}
	
	@Override
	public int computeHashCode(){
		int[] hashs = {_left.hashCode(), _symbol.hashCode(), _right.hashCode()};
		return Utilities.hashCode(hashs);
	}

	@Override
	public String toString(){
		String _str = "<"+_left.toString()+":"+_symbol.toString()+":"+_right.toString()+">";
		switch(_filter){
		case LAYOUT_ONLY:
			_str += "ε";
			break;
		case REJECT_LAYOUT:
			_str += "!ε";
			break;
		default:
			break;
		}
		return _str;
	}
	
	/*@Override
	public String graphviz(){
		return _symbol.graphviz();
	}*/

	@Override
	public IStrategoTerm toATerm() {
		return _symbol.toATerm();
	}

	public boolean isContextFree() {
		return _left.isEmpty() && _right.isEmpty();
	}

	@Override
	public Type type() {
		return _symbol.type();
	}
}
