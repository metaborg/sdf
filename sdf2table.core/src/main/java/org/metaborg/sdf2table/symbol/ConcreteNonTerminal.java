package org.metaborg.sdf2table.symbol;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.SyntaxProduction;

public abstract class ConcreteNonTerminal extends NonTerminal{
	private Set<Production> _productions = new LinkedHashSet<>();
	private Set<SyntaxProduction> _left_deriv = null;
	private Set<SyntaxProduction> _right_deriv = null;
	
	private Set<CharClass> _follow_restrictions = new LinkedHashSet<>();
	
	public Set<CharClass> followRestrictions(){
		return _follow_restrictions;
	}
	
	/**
	 * Get the list of productions that produce this symbol
	 * @return A list of productions.
	 */
	@Override
	public Set<Production> productions(){
		return _productions;
	}
	
	public void leftDerivations(Set<SyntaxProduction> set){
		for(Production p : _productions){
			if(set.add(p.syntaxProduction()) && !p.isEmpty()){
				Symbol left = p.symbol(0);
				if(left instanceof NonTerminal)
					set.addAll(((NonTerminal)left).leftDerivations());
			}
		}
	}
	
	public Set<SyntaxProduction> leftDerivations(){
		if(_left_deriv == null){
			_left_deriv = new HashSet<>();
			leftDerivations(_left_deriv);
		}
		return _left_deriv;
	}
	
	public void rightDerivations(Set<SyntaxProduction> set){
		for(Production p : _productions){
			if(set.add(p.syntaxProduction()) && !p.isEmpty()){
				Symbol right = p.symbol(0);
				if(right instanceof NonTerminal)
					set.addAll(((NonTerminal)right).rightDerivations());
			}
		}
	}
	
	public Set<SyntaxProduction> rightDerivations(){
		if(_right_deriv == null){
			_right_deriv = new HashSet<>();
			rightDerivations(_right_deriv);
		}
		return _right_deriv;
	}
}
