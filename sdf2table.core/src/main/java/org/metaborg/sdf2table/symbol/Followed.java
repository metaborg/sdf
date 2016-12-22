package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.metaborg.sdf2table.core.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoList;

/**
 * The "followed" charclass is the only character class that is not a Symbol.
 * It can be seen as "the character c0 followed by c1 ... cn".
 * <p>
 * This is constructed from the ATerm "Seq" used in the "restrictions" section.
 * This class has been introduced to deal with follow restrictions,
 * where the restriction is about a sequence of characters.
 * <p>
 * Note that the method {@link #contains(int)} is slightly over-restrictive, in
 * the sense that it returns true for a character c iff c = c0,
 * even though c cannot be considered a a part of the caracter class
 * c0c1..cn.
 */
public class Followed extends CharClass{
	List<CharClass> _list = null;
	//TODO Copied from the Sequence class, but I'm not sure it is useful anymore...
	private static final StrategoConstructor CONS_SEQUENCE = new StrategoConstructor("sequence", 2);
	
	/**
	 * Empty sequence constructor
	 */
	public Followed(){
		_list = new ArrayList<>();
	}
	
	public Followed(List<CharClass> list){
		_list = list;
	}
	
	public Followed(CharClass head, CharClass tail){
		_list = new ArrayList<>();
		_list.add(head);
		if(tail instanceof Followed){
			_list.addAll(((Followed)tail)._list);
		}else{
			_list.add(tail);
		}
	}
	
	public List<CharClass> symbols(){
		return _list;
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
		//TODO Copied from the Sequence class, but I'm not sure it is useful anymore...
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
