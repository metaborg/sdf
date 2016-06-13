package org.metaborg.sdf2table.grammar;

import org.spoofax.terms.StrategoAppl;

public class UnloadedModule extends Module{
	StrategoAppl _syntax_term;
	StrategoAppl _restrictions_term;
	StrategoAppl _priorities_term;
	
	public UnloadedModule(String name, Syntax syntax) {
		super(name, syntax);
	}
	
	public void setSyntaxTerm(StrategoAppl term){
		_syntax_term = term;
	}
	
	public void setPrioritiesTerm(StrategoAppl term){
		_priorities_term = term;
	}
	
	public void setRestrictionsTerm(StrategoAppl term){
		_restrictions_term = term;
	}

	public void loadSyntax(){
		Syntax.fromStrategoTerm(_syntax_term, syntax());
	}
	
	public void loadRestrictions(){
		Restrictions.fromStrategoTerm(_restrictions_term, syntax(), symbols());
	}
	
	public void loadPriorities(){
		Priorities.fromStrategoTerm(_priorities_term, syntax(), symbols());
	}
}
