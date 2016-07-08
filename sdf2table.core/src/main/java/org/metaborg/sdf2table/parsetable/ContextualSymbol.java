package org.metaborg.sdf2table.parsetable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.PriorityLevel;
import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.grammar.UndefinedSymbolException;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Symbol;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class ContextualSymbol extends NonTerminal{
	enum Filter{
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
	
	/*@Override
	public void computeDependencies(){
		for(ContextualSymbol s : _productions){
			//
		}
	}*/
	
	@Override
	public boolean isLayout(){
		return _filter == Filter.LAYOUT_ONLY || _symbol.isLayout();
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
		
		/*if(u.productions().isEmpty())
			return null;*/
		
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
			boolean inside_layout = _symbol.isLayout();
			
			for(Production p : _symbol.productions()){
				// check conflicts
				if(!_left.conflictsLeft(p.syntaxProduction()) && !_right.conflictsRight(p.syntaxProduction())){
					boolean layout_only = true;
					// Iteration on the left side of the production, to take care of empty symbols.
					for(int l = 0; l < p.size(); ++l){
						Symbol sym_left = p.symbol(l);
						
						if(inside_layout || !sym_left.isLayout()){
							Set<PriorityLevel> prio_left = p.syntaxProduction().priorities().priorityLevels(l);
							next_possible_production:
							// Iteration on the right side
							for(int r = p.size()-1; r >= l; --r){
								Symbol sym_right = p.symbol(r);
								
								if(inside_layout || !sym_right.isLayout()){
									layout_only = false;
									Set<PriorityLevel> prio_right = p.syntaxProduction().priorities().priorityLevels(r);
	
									List<Symbol> rhs = new ArrayList<>();
									boolean contains_non_layout_symbol = false;
									
									for(int i = 0; i < p.size(); ++i){
										Symbol s = p.symbol(i);
										if(_filter == Filter.LAYOUT_ONLY && !s.isLayout()){
											continue next_possible_production;
										}
										
										if(s instanceof CharClass){ // A char class removes all contexts.
											rhs.add(s);
											contains_non_layout_symbol = true;
										}else{
											NonTerminal nt = (NonTerminal)s.nonContextual();
											NonTerminal symbol; // new symbol
											
											if(i <= l || i >= r){
												Context left = null, right = null; // new symbol contexts
												
												if(i == l && i == r){
													left = _left.union(prio_right);
													right = _right.union(prio_left);
												}else if(i <= l){
													left = new Context(_left);
													right = new Context(prio_left);
												}else{ //if(i >= r)
													left = new Context(prio_right);
													right = new Context(_right);
												}
												
												left.leftSimplify(nt.leftDerivations());
												right.rightSimplify(nt.rightDerivations());
												
												Filter filter = Filter.REJECT_LAYOUT;
												contains_non_layout_symbol = true;
												
												if(i != l && i != r){
													filter = Filter.LAYOUT_ONLY;
													contains_non_layout_symbol = false; // /!\
												}else if(inside_layout || ((left == null || left.isEmpty()) && ( right == null || right.isEmpty())))
													filter = Filter.NONE;
												
												symbol = ContextualSymbol.unique(left, nt, right, filter);
											}else{
												symbol = ContextualSymbol.unique(null, (NonTerminal)s.nonContextual(), null, Filter.NONE);
											}
											
											if(symbol == null) // This production is not possible
												continue next_possible_production;
											
											rhs.add(symbol);
										}
									} // ~ symbols iteration
									
									if(!contains_non_layout_symbol && _filter == Filter.REJECT_LAYOUT){ // Avoid layout/empty productions if filter = REJECT_LAYOUT
										next_rl_production:
										for(int i = 0; i < p.size(); ++i){
											List<Symbol> rhs_rl = new ArrayList<>();
											for(int j = 0; j < p.size(); ++j){
												if(i == j){
													NonTerminal s = ContextualSymbol.unique(null, (NonTerminal)rhs.get(j), null, Filter.REJECT_LAYOUT);
													if(s == null){
														continue next_rl_production;
													}
													rhs_rl.add(s);
												}else{
													rhs_rl.add(rhs.get(j));
												}
											}
											addProduction(ContextualProduction.unique(p.syntaxProduction(), this, rhs_rl));
										}
									}else{
										addProduction(ContextualProduction.unique(p.syntaxProduction(), this, rhs));
									}
								}
								
								if(inside_layout || (!layout_only && (_right.isEmpty() || sym_right.nonEpsilon())))
									break;
							} // ~ right recursion
						}
						
						if(inside_layout || (!layout_only && (_left.isEmpty() || sym_left.nonEpsilon())))
							break;
					} // ~ left recusrion
					
					if(layout_only && _filter != Filter.REJECT_LAYOUT){
						addProduction(ContextualProduction.unique(p.syntaxProduction(), this, p.symbols()));
					}
				}
			} // ~ original productions iteration
			
			_to_validate.add(this);
		}
	}
	
	private void addProduction(ContextualProduction prod){
		_productions.add(prod);
		prod.addDependant(this);
	}
	
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
			return other == this || (cs._filter == _filter && cs._symbol.equals(_symbol) && cs._left.equals(_left) && cs._right.equals(_right));
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
}
