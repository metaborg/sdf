package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.metaborg.sdf2table.core.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoList;

/**
 * The sequence is the only character class that is not a Symbol.
 * It can be seen as "the character c0 followed by c1 ... cn".
 * <p>
 * This class has been introduced to deal with follow restrictions,
 * where the restriction is about a sequence of characters.
 * <p>
 * Note that the method {@link #contains(int)} is slightly over-restrictive, in
 * the sense that it returns true for a character c iff c = c0,
 * even though c cannot be considered a a part of the caracter class
 * c0c1..cn.
 */
public class Sequence extends CharClass{
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
	
	public Sequence(Symbol head, Symbol tail){
		_list = new ArrayList<>();
		_list.add(head);
		_list.add(tail);
	}
	
	public Sequence(Symbol head, List<Symbol> tail){
		_list = new ArrayList<>();
		_list.add(head);
		_list.addAll(tail);
	}
	
	@Override
	public Terminal firstTerminal(){
		if(_list.isEmpty())
			return null;
		return _list.get(0).getFirst();
	}

	@Override
	public boolean contains(int c) {
		return !_list.isEmpty() && firstTerminal().contains(c);
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
	
	public StrategoList toATermList() {
		return Utilities.strategoListFromExportables(_list);
	}

	@Override
	public int minimum() {
		if(_list.isEmpty())
			return 256;
		return firstTerminal().minimum();
	}

	@Override
	public int maximum() {
		if(_list.isEmpty())
			return 256;
		return firstTerminal().maximum();
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
		String str = "";
		for(Symbol t : _list){
			if(!str.isEmpty())
				str += ".";
			str += t.toString();
		}
		return str;
	}

	@Override
	public Terminal getFirst() {
		if(_list.isEmpty())
			return null;
		return _list.get(0).getFirst();
	}
}
