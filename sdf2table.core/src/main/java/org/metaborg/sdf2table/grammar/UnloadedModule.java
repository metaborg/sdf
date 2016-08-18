package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.io.Importer;
import org.spoofax.terms.StrategoAppl;

public class UnloadedModule extends Module{
	StrategoAppl _kernel_term;
	StrategoAppl _restrictions_term;
	StrategoAppl _priorities_term;
	
	public UnloadedModule(String name, Syntax syntax) {
		super(name, syntax);
	}
	
	public void setSyntaxTerm(StrategoAppl term){
		_kernel_term = term;
	}
	
	public void setPrioritiesTerm(StrategoAppl term){
		_priorities_term = term;
	}
	
	public void setRestrictionsTerm(StrategoAppl term){
		_restrictions_term = term;
	}

	public void loadKernel(){
		Importer.importKernel(syntax(), _kernel_term);
	}
	
	public void loadRestrictions(){
		Importer.importRestrictions(syntax(), symbols(), _restrictions_term);
	}
	
	public void loadPriorities(){
		Importer.importPriorities(syntax(), _priorities_term);
	}
}
