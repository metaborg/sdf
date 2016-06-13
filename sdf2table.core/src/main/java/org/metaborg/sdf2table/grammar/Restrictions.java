package org.metaborg.sdf2table.grammar;

import java.util.Set;

import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;

public class Restrictions{	
	public static void fromStrategoTerm(IStrategoTerm term, Syntax syntax, SymbolCollection collection){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Restrictions")){
				StrategoList restrictions = (StrategoList)app.getSubterm(0);
				
				for(IStrategoTerm restriction : restrictions){
					if(restriction instanceof StrategoAppl){
						StrategoAppl ares = (StrategoAppl)restriction;
						switch(ares.getName()){
						case "Follow":
							Set<CharClass> ccs = CharClass.lookaheadsFromATerm(ares.getSubterm(1));
							StrategoList subjects = (StrategoList)ares.getSubterm(0);
							for(IStrategoTerm subject : subjects){
								Symbol.fromStrategoTerm(subject, collection).followRestrictions().addAll(ccs);
							}
							break;
						default:
							System.err.println("Restrictions Section: Unknown restriction `"+ares.getName()+"'.");
							break;
						}
					}else{
						System.err.println("Restrictions Section: Malformed term: Restriction application expected.");
					}
				}
			}
		}
	}
}
