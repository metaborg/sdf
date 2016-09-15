package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.metaborg.sdf2table.core.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoList;

public class Sequence extends ConcreteNonTerminal{
	List<Symbol> _list = null;
	private static final StrategoConstructor CONS_SEQUENCE = new StrategoConstructor("sequence", 2);
	
	/**
	 * Empty sequence constructor
	 */
	public Sequence(){
		_list = new ArrayList<>();
	}
	
	public Sequence(List<Symbol> list){
		_list = list;
	}
	
	public Sequence(Symbol head, List<Symbol> tail){
		_list = new ArrayList<>();
		_list.add(head);
		_list.addAll(tail);
	}
	
	public List<Symbol> symbols(){
		return _list;
	}
	
	@Override
	public IStrategoTerm toATerm(){
		StrategoList slist = Utilities.strategoListFromExportables(_list);
		
		return new StrategoAppl(
				CONS_SEQUENCE,
				new IStrategoTerm[]{
					slist.head(),
					slist.tail()
				},
				null,
				0
		);
	}

	@Override
	public boolean equals(Object other) {
		if(other != null && other instanceof Sequence){
			Sequence s = (Sequence)other;
			if(s._list.size() == _list.size()){
				for(int i = 0; i < _list.size(); ++i){
					if(!s._list.get(i).equals(_list.get(i)))
						return false;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String str = "(";
		for(Symbol t : _list){
			if(!str.isEmpty())
				str += " ";
			str += t.toString();
		}
		str += ")";
		return str;
	}

	@Override
	public Type type() {
		return Type.CONTEXT_FREE;
	}

	@Override
	public boolean nonEpsilon(){
		for(Symbol s : _list){
			if(s.nonEpsilon())
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isLayout() {
		for(Symbol s : _list){
			if(!s.isLayout())
				return false;
		}
		
		return true;
	}
}
