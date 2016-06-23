package org.metaborg.sdf2table.symbol;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.metaborg.sdf2table.grammar.IProduction;
import org.metaborg.sdf2table.grammar.Production;

public abstract class ConcreteNonTerminal extends NonTerminal{
	private Set<IProduction> _productions = new LinkedHashSet<>();
	private Set<Production> _left_deriv = null;
	private Set<Production> _right_deriv = null;
	
	private Set<CharClass> _follow_restrictions = new LinkedHashSet<>();
	
	public Set<CharClass> followRestrictions(){
		return _follow_restrictions;
	}
	
	/**
	 * Get the list of productions that produce this symbol
	 * @return A list of productions.
	 */
	@Override
	public Set<IProduction> productions(){
		return _productions;
	}
	
	public void leftDerivations(Set<Production> set){
		for(IProduction p : _productions){
			if(set.add(p.asProduction()) && !p.isEmpty()){
				Symbol left = p.symbol(0);
				if(left instanceof NonTerminal)
					set.addAll(((NonTerminal)left).leftDerivations());
			}
		}
	}
	
	public Set<Production> leftDerivations(){
		if(_left_deriv == null){
			_left_deriv = new HashSet<>();
			leftDerivations(_left_deriv);
		}
		return _left_deriv;
	}
	
	public void rightDerivations(Set<Production> set){
		for(IProduction p : _productions){
			if(set.add(p.asProduction()) && !p.isEmpty()){
				Symbol right = p.symbol(0);
				if(right instanceof NonTerminal)
					set.addAll(((NonTerminal)right).rightDerivations());
			}
		}
	}
	
	public Set<Production> rightDerivations(){
		if(_right_deriv == null){
			_right_deriv = new HashSet<>();
			rightDerivations(_right_deriv);
		}
		return _right_deriv;
	}
}
