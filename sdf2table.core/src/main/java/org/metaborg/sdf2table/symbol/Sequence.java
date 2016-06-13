package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.metaborg.sdf2table.grammar.Exportable;
import org.metaborg.sdf2table.parsetable.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;

/**
 * The sequence is the only character class that is not a terminal.
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
	List<Terminal> _list = null;
	
	/**
	 * Empty sequence constructor
	 */
	public Sequence(){
		_list = new ArrayList<>();
	}
	
	public Sequence(List<Terminal> list){
		_list = list;
	}
	
	public Sequence(Terminal head, Terminal tail){
		_list = new ArrayList<>();
		_list.add(head);
		_list.add(tail);
	}
	
	public Sequence(Terminal head, List<Terminal> tail){
		_list = new ArrayList<>();
		_list.add(head);
		_list.addAll(tail);
	}
	
	@Override
	public Terminal firstTerminal(){
		if(_list.isEmpty())
			return null;
		return _list.get(0);
	}

	@Override
	public boolean contains(int c) {
		return !_list.isEmpty() && firstTerminal().contains(c);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IStrategoTerm toATerm(){
		return Utilities.strategoListFromExportables((List<Exportable>)(Object)_list);
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
	public boolean equals(Symbol other) {
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
		for(Terminal t : _list){
			if(!str.isEmpty())
				str += ".";
			str += t.toString();
		}
		return str;
	}
}
