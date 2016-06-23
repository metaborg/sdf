package org.metaborg.sdf2table.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.parsetable.ContextualProduction;
import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;

public class Syntax{
	List<Production> _productions = new ArrayList<>();
	List<ContextualProduction> _cproductions = new ArrayList<>();
	SymbolCollection _symbols = new SymbolCollection();
	
	public Syntax(){
		//
	}
	
	public SymbolCollection symbols(){
		return _symbols;
	}
	
	public void computeFollowSets(){ // Total complexity O(3n)
		for(Production p : _productions){
			p.computeDependencies();
		}
		for(ContextualProduction p : _cproductions){
			p.computeDependencies();
		}
		
		for(Production p : _productions){
			p.computeSets();
		}
		for(ContextualProduction p : _cproductions){
			p.computeSets();
		}
		
		for(Production p : _productions){
			p.computeSetsComponents();
		}
		for(ContextualProduction p : _cproductions){
			p.computeSetsComponents();
		}
	}
	
	/**
	 * Get the syntax definition production corresponding to the production prod.
	 * This method can be use to choose a unique internal Java representation of a production.
	 * @param prod A production.
	 * @return A production equals to prod which is registered by this Syntax instance,
	 * or null is prod is not declared in the syntax definition.
	 */
	public Production uniqueProduction(Production prod){
		for(Production p : _productions){
			if(p.merge(prod))
				return p;
		}
		
		_productions.add(prod);
		return prod;
	}
	
	public List<Production> productions(){
		return _productions;
	}
	
	public List<ContextualProduction> contextualProductions(){
		return _cproductions;
	}
	
	public Production startProduction(){
		for(Production p : _productions){
			if(p.product().isFileStart())
				return p;
		}
		return null;
	}
	
	public static void fromStrategoTerm(IStrategoTerm term, Syntax syntax){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Kernel")){
				StrategoList sdf_productions = (StrategoList)app.getSubterm(0);
				for(IStrategoTerm t : sdf_productions){
					Production prod = Production.fromATerm(t, syntax);
					if(prod != null){
						prod.product().addProduction(prod);
						//syntax.productions().add(prod); already done.
					}else{
						System.err.println("Malformed Stratego term : SdfProduction expected.");
						return;
					}
				}
			}
		}
	}

	public void declareContextualProduction(ContextualProduction contextualProduction) {
		_cproductions.add(contextualProduction);
	}
}
