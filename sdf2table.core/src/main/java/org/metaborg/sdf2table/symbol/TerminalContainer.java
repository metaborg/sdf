package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;

public class TerminalContainer extends Terminal{
	Terminal _cc = null;
	
	public TerminalContainer(){
		super();
	}
	
	public TerminalContainer(Terminal cc){
		super();
		_cc = cc;
	}
	
	public Terminal contents(){
		return _cc;
	}
	
	public void set(Terminal cc){
		_cc = cc;
	}
	
	public void add(Terminal cc){
		if(_cc == null)
			_cc = cc;
		else
			_cc = _cc.union(cc);
	}
	
	public void addAll(Collection<Terminal> ccs){
		for(Terminal t : ccs)
			add(t);
	}
	
	public int minimum(){
		if(_cc == null)
			return 256;
		return _cc.minimum();
	}
	
	public int maximum(){
		if(_cc == null)
			return 256;
		return _cc.maximum();
	}

	@Override
	public boolean contains(int c){
		return _cc != null && _cc.contains(c);
	}
	
	@Override
	public boolean equals(Symbol other) {
		if(other instanceof TerminalContainer){
			TerminalContainer s = (TerminalContainer)other;
			return other != null && _cc.equals(s._cc);
		}
		return _cc != null && _cc.equals(other);
	}

	@Override
	public List<IStrategoTerm> getATermCC() {
		if(_cc == null)
			return new ArrayList<>();
		return _cc.getATermCC();
	}

	@Override
	public String terminalString() {
		if(_cc == null)
			return "";
		return _cc.terminalString();
	}
	
	public Terminal except(CharClass... restrictions){
		if(_cc == null)
			return null;
		return _cc.except(restrictions);
	}
}
