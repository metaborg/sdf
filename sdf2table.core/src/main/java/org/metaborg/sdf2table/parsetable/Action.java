package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.Exportable;
import org.metaborg.sdf2table.grammar.Trigger;
import org.spoofax.interpreter.terms.IStrategoTerm;

public abstract class Action implements Exportable{
	private Trigger _trigger;
	
	private boolean _conflictual = false;
	
	public Action(Trigger trigger){
		_trigger = trigger;
	}
	
	public Trigger trigger(){
		return _trigger;
	}
	
	public boolean isConflictual(){
		return _conflictual;
	}
	
	public void setConflictual(boolean c){
		_conflictual = c;
	}
	
	public abstract IStrategoTerm toATerm();
}
