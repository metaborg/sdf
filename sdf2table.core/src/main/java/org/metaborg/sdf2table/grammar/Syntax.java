package org.metaborg.sdf2table.grammar;

import java.util.HashSet;
import java.util.Set;

import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;

public class Syntax{
	Set<Production> _productions = new HashSet<>();
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
		
		for(Production p : _productions){
			p.generateFirstSet();
			p.followSet().generateFirstSet();
		}
		
		for(Production p : _productions){
			p.firstSet().compute();
			p.followSet().firstSet().compute();
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
			if(p.equals(prod))
				return p;
		}
		return prod;
	}
	
	public Set<Production> productions(){
		return _productions;
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
					Production prod = Production.fromATerm(t, syntax.symbols());
					if(prod != null){
						prod.product().addProduction(prod);
						syntax.productions().add(prod);
					}else{
						System.err.println("Malformed Stratego term : SdfProduction expected.");
						return;
					}
				}
			}
		}
	}
}
