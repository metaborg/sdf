package org.metaborg.sdf2table.symbol;

import java.util.List;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.grammar.Trigger;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public abstract class Terminal extends CharClass implements Trigger{
	private static final StrategoConstructor CONS_CHARCLASS = new StrategoConstructor("char-class", 1);
	
	@Override
	public boolean isTerminal(){
		return true;
	}
	
	@Override
	public Terminal firstTerminal(){
		return this;
	}
	
	public Terminal getFirst(){
		return this;
	}
	
	@Override
	public String toString(){
		return "["+terminalString()+"]";
	}
	
	public abstract String terminalString();
	
	public abstract Terminal doExcept(CharClass... restrictions);
	
	public abstract List<IStrategoTerm> getATermCC();
	
	public IStrategoTerm toATerm(){
		List<IStrategoTerm> list = getATermCC();
		return new StrategoAppl(CONS_CHARCLASS, new IStrategoTerm[]{Utilities.strategoListFromCollection(list)}, null, 0);
	}
}
