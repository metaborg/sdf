package org.metaborg.sdf2table.grammar;

import java.util.LinkedList;
import java.util.List;

import org.metaborg.sdf2table.parsetable.Priority;
import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

public class Priorities{	
	public static void fromStrategoTerm(IStrategoTerm term, Syntax syntax, SymbolCollection symbols){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Priorities")){
				StrategoList chains = (StrategoList)app.getSubterm(0);
				
				for(IStrategoTerm chain : chains){
					if(chain instanceof StrategoAppl && ((StrategoAppl)chain).getName().equals("Chain")){
						StrategoList groups = (StrategoList)chain.getSubterm(0);
						
						class Ascendant{
							public int position = -1;
							public boolean transitive = true;
							public List<Production> productions = new LinkedList<>();
						}
						
						Ascendant ascendant = null;
						
						for(IStrategoTerm group : groups){
							Ascendant a = new Ascendant();
							
							if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("NonTransitive")){
								a.transitive = false;
								group = group.getSubterm(0);
							}
							if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("WithArguments")){
								StrategoAppl argv = (StrategoAppl)group.getSubterm(1);
								if(!argv.getName().equals("Default")){
									System.err.println("Priorities Section: Malformed term: Unknown priority parameter `"+argv.toString()+"'");
									continue;
								}
								StrategoList positions = (StrategoList)argv.getSubterm(0);
								if(positions.size() > 1){
									System.err.println("Priorities Section: Malformed term: Unsuported multi positions priority"); // TODO multi-positions priority ?
									continue;
								}
								a.position = Integer.parseInt(((StrategoString)positions.head()).stringValue());
								group = group.getSubterm(0);
							}
							if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("SimpleGroup")){
								a.productions.add(syntax.uniqueProduction(Production.fromATerm(group.getSubterm(0), symbols)));
							}else if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("ProdsGroup")){
								for(IStrategoTerm tp : (StrategoList)group.getSubterm(0)){
									a.productions.add(syntax.uniqueProduction(Production.fromATerm(tp, symbols)));
								}
							}else{
								System.err.println("Priorities Section: Malformed term: SimpleGroup expected.");
							}
							
							for(Production p : a.productions){
								if(p != null){
									if(ascendant != null){
										for(Production ap : ascendant.productions){
											ap.addPriority(new Priority(ap, p, ascendant.position, ascendant.transitive));
										}
									}
								}else{
									System.err.println("Priorities Section: Malformed term: Undefined production.");
								}
							}
							
							ascendant = a;
						}
					}else{
						System.err.println("Priorities Section: Malformed term: Chain expected.");
					}
				}

			}
		}
	}
}
