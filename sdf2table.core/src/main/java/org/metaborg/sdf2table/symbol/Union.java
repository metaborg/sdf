package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.List;

import org.spoofax.interpreter.terms.IStrategoTerm;

public class Union extends Terminal{
	private Terminal _a, _b;
	
	public Union(Terminal a, Terminal b){
		super();
		_a = a;
		_b = b;
	}
	
	@Override
	public boolean contains(int c) {
		return _a.contains(c) || _b.contains(c);
	}
	
	public int minimum(){
		return Math.min(_a.minimum(), _b.minimum());
	}
	
	public int maximum(){
		return Math.max(_a.maximum(), _b.maximum());
	}

	@Override
	public boolean equals(Symbol other) {
		if(other instanceof Union){
			Union u = (Union)other;
			return u != null && ((_a.equals(u._a) && _b.equals(u._b)) || (_b.equals(u._a) && _a.equals(u._b)));
		}
		return false;
	}

	@Override
	public String terminalString() {
		return _a.terminalString()+_b.terminalString();
	}
	
	public List<IStrategoTerm> getATermCC(){
		List<IStrategoTerm> terms = new ArrayList<>();
		
		terms.addAll(_a.getATermCC());
		terms.addAll(_b.getATermCC());
		
		return terms;
	}
	
	public Terminal except(CharClass... restrictions){
		Terminal ta = _a.except(restrictions);
		Terminal tb = _b.except(restrictions);
		
		if(ta != null && tb == null)
			return ta;
		if(ta == null && tb != null)
			return tb;
		if(ta != null && tb != null)
			return new Union(ta, tb);
		return null;
	}
}
