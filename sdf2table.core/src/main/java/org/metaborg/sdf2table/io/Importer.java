package org.metaborg.sdf2table.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.SyntaxProduction;
import org.metaborg.sdf2table.grammar.Production.Attribute;
import org.metaborg.sdf2table.grammar.Priority;
import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.grammar.Syntax;
import org.metaborg.sdf2table.symbol.Alternative;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.ContextFree;
import org.metaborg.sdf2table.symbol.FileStart;
import org.metaborg.sdf2table.symbol.Followed;
import org.metaborg.sdf2table.symbol.Iteration;
import org.metaborg.sdf2table.symbol.Layout;
import org.metaborg.sdf2table.symbol.Lexical;
import org.metaborg.sdf2table.symbol.Literal;
import org.metaborg.sdf2table.symbol.NonTerminal;
import org.metaborg.sdf2table.symbol.Numeric;
import org.metaborg.sdf2table.symbol.Option;
import org.metaborg.sdf2table.symbol.Range;
import org.metaborg.sdf2table.symbol.Sequence;
import org.metaborg.sdf2table.symbol.Sort;
import org.metaborg.sdf2table.symbol.Start;
import org.metaborg.sdf2table.symbol.Symbol;
import org.metaborg.sdf2table.symbol.SymbolCollection;
import org.metaborg.sdf2table.symbol.Terminal;
import org.metaborg.sdf2table.symbol.Union;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoList;
import org.spoofax.terms.StrategoString;

public class Importer{
	/**
	 * Import a kernel syntax
	 * @param syntax
	 * @param term
	 */
	public static void importKernel(Syntax syntax, IStrategoTerm term){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Kernel")){
				StrategoList sdf_productions = (StrategoList)app.getSubterm(0);
				for(IStrategoTerm t : sdf_productions){
					SyntaxProduction prod = importProduction(syntax, t);
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
	
	/**
	 * Import syntax restrictions
	 * @param syntax
	 * @param collection
	 * @param term
	 */
	public static void importRestrictions(Syntax syntax, SymbolCollection collection, IStrategoTerm term){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			if(app.getName().equals("Restrictions")){
				StrategoList restrictions = (StrategoList)app.getSubterm(0);
				
				for(IStrategoTerm restriction : restrictions){
					if(restriction instanceof StrategoAppl){
						StrategoAppl ares = (StrategoAppl)restriction;
						switch(ares.getName()){
						case "Follow":
							Set<CharClass> ccs = importLookaheadList(ares.getSubterm(1));
							StrategoList subjects = (StrategoList)ares.getSubterm(0);
							for(IStrategoTerm subject : subjects){
								Symbol s = importSymbol(collection, subject);
								if(s instanceof NonTerminal)
									((NonTerminal)s).followRestrictions().addAll(ccs);
								else
									System.err.println("Restrictions Section: Non terminal expected.");
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
	
	public static Set<CharClass> importLookaheadList(IStrategoTerm term){
		Set<CharClass> set = new HashSet<>();
		
		StrategoList slist;
		
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			switch(app.getName()){
			case "List":
				slist = (StrategoList)app.getSubterm(0);
				Set<Terminal> terminals = new HashSet<>();
				for(IStrategoTerm t : slist){
					Set<CharClass> ccs = importLookaheadList(t);
					for(CharClass cc : ccs){
						if(cc instanceof Terminal){
							terminals.add((Terminal)cc);
						}else{
							set.add(cc);
						}
					}
				}
				if(!terminals.isEmpty()){
					Terminal u = Terminal.union(terminals.toArray(new Terminal[terminals.size()]));
					//System.err.println("Union:"+u.toString());
					set.add(u);
				}
				break;
			// NON TERMINALS
			case "Seq":
				Terminal head = importTerminal(app.getSubterm(0));
				for(CharClass tail : importLookaheadList(app.getSubterm(1))){
					set.add(new Followed(head, (CharClass)tail));
				}
				break;
			// TERMINALS
			case "CharClass":
				set.add(importTerminal(app.getSubterm(0)));
				break;
			default:
				System.err.println("In sequence: `"+app.toString()+"' is not a character class.");
				break;
			}
		}
		return set;
	}
	
	public static void importPriorities(Syntax syntax, IStrategoTerm term){
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
							public List<Priority> priorities = new LinkedList<>();
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
								a.priorities.add(new Priority(importProduction(syntax, group.getSubterm(0)), a.position, a.transitive));
							}else if(group instanceof StrategoAppl && ((StrategoAppl)group).getName().equals("ProdsGroup")){
								for(IStrategoTerm tp : (StrategoList)group.getSubterm(0)){
									a.priorities.add(new Priority(importProduction(syntax, tp), a.position, a.transitive));
								}
							}else{
								System.err.println("Priorities Section: Malformed term: SimpleGroup expected.");
							}
							
							for(Priority p : a.priorities){
								if(p != null){
									if(ascendant != null){
										for(Priority higher : ascendant.priorities){
											Priority lower = new Priority(p.production(), higher.position(), higher.isTransitive());
											higher.production().priorities().addLower(lower);
											p.production().priorities().addHigher(higher);
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
	
	/**
	 * Import a production
	 * @param syntax
	 * @param term
	 * @return
	 */
	public static SyntaxProduction importProduction(Syntax syntax, IStrategoTerm term){
		if(term instanceof IStrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			boolean with_cons = false;
			if(app.getName().equals("SdfProduction") || (with_cons = true && app.getName().equals("SdfProductionWithCons"))){
				NonTerminal symbol;
				String cons = "";
				List<Symbol> sym_list = new ArrayList<>();
				StrategoAppl tattrs;
				
				if(with_cons){
					// SdfProductionWithCons(SortCons(<type>), Constructor("<cons>"), ...)
					symbol = (NonTerminal)importSymbol(syntax.symbols(), app.getSubterm(0).getSubterm(0));
					cons = ((StrategoString)app.getSubterm(0).getSubterm(1).getSubterm(0)).stringValue();
				}else{
					symbol = (NonTerminal)importSymbol(syntax.symbols(), app.getSubterm(0));
				}
				
				// Read right hand side of the equation: Rhs([<symbols>])
				StrategoList rhs = (StrategoList)app.getSubterm(1).getSubterm(0);
				for(IStrategoTerm t : rhs){
					Symbol s = importSymbol(syntax.symbols(), t);
					if(s != null)
						sym_list.add(s);
				}
				
				// Read attributes
				tattrs = (StrategoAppl)app.getSubterm(2);
				Set<Attribute> attrs = new HashSet<>();
				switch(tattrs.getName()){
				case "NoAttrs":
					break;
				case "Attrs":
					StrategoList talist = (StrategoList)tattrs.getSubterm(0);
					for(IStrategoTerm ta : talist){
						Attribute attr = importAttribute(ta);
						if(attr != null)
							attrs.add(attr);
					}
					break;
				default:
					System.err.println("Malformed Stratego term : Attributes expected.");
					return null;
				}
				
				return syntax.uniqueProduction(new SyntaxProduction(symbol, cons, sym_list, attrs));
			}
		}
		
		return null;
	}
	
	public static Production.Attribute importAttribute(IStrategoTerm term){
		if(term instanceof StrategoAppl){
			StrategoAppl a = (StrategoAppl)term;
			switch(a.getName()){ // This is just to get a proper name for the attribute.
			case "Assoc":
				StrategoAppl assoc = (StrategoAppl)a.getSubterm(0);
				switch(assoc.getName()){
				case "Left":
					return new Production.Associativity(Production.AssocType.LEFT);
				case "Right":
					return new Production.Associativity(Production.AssocType.RIGHT);
				case "NonAssoc":
					return new Production.Associativity(Production.AssocType.NON_ASSOC);
				default:
					System.err.println("Unknown associativity: `"+assoc.getName()+"'.");
					break;
				}
				break;
			case "Reject":
				return new Production.Attribute(Production.AttributeType.REJECT);
			case "Prefer":
				return new Production.Attribute(Production.AttributeType.PREFER);
			case "Avoid":
				return new Production.Attribute(Production.AttributeType.AVOID);
			case "Bracket":
				return new Production.Attribute(Production.AttributeType.BRACKET);
			case "LayoutConstraint":
				return new Production.LayoutConstraint(importLayoutConstraint(a.getSubterm(0)));
			case "IgnoreLayout":
				return new Production.Attribute(Production.AttributeType.IGNORE_LAYOUT);
			case "EnforceNewLine":
				return new Production.Attribute(Production.AttributeType.ENFORCE_NEWLINE);
			case "LongestMatch":
				return new Production.Attribute(Production.AttributeType.LONGEST_MATCH);
			case "CaseInsensitive":
				return new Production.Attribute(Production.AttributeType.CASE_INSENSITIVE);
			case "Deprecated":
				String message = "";
				if(a.getSubtermCount() > 0){
					message = ((StrategoString)a.getSubterm(0)).stringValue();
				}
				return new Production.Deprecated(message);
			case "Placeholder":
				return new Production.Attribute(Production.AttributeType.PLACEHOLDER);
			case "PlaceholderInsertion":
				return new Production.Attribute(Production.AttributeType.PLACEHOLDER_INSERTION);
			case "LiteralCompletion":
				return new Production.Attribute(Production.AttributeType.LITERAL_COMPLETION);
			case "Term":
				System.err.println("sdf2table : importAttribute: unhandled term attribute (yet)."); // TODO
				break;
			default:
				System.err.println("sdf2table : importAttribute: unknown attribute `"+a.getName()+"'.");
				break;
			}
		}
		
		return null;
	}
	
	public static String importLayoutConstraint(IStrategoTerm term){
		return ""; // TODO
	}
	
	public static List<Symbol> importSymbolList(SymbolCollection collection, IStrategoTerm term){
		List<Symbol> list = new LinkedList<>();
		
		if(term instanceof StrategoList){
			StrategoList slist = (StrategoList)term;
			
			for(IStrategoTerm t : slist){
				Symbol s = importSymbol(collection, t);
				if(s != null)
					list.add(s);
			}
		}else{
			System.err.println("sdf2table : Symbol.fromStrategoList: this term is not a list.");
		}
		
		return list;
	}
	
	public static Symbol importSymbol(SymbolCollection collection, IStrategoTerm term){
		Symbol symbol;
		String enquoted;
		
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			switch(app.getName()){
			case "SortDef":
				symbol = new Sort(((StrategoString)app.getSubterm(0)).stringValue());
				break;
			case "Sort":
				symbol = new Sort(((StrategoString)app.getSubterm(0)).stringValue());
				break;
			case "Layout":
				symbol = new Layout();
				break;
			case "CharClass":
				symbol = importTerminal(term.getSubterm(0));
				break;
			case "Lit":
				enquoted = ((StrategoString)app.getSubterm(0)).stringValue();
				symbol = new Literal(enquoted.substring(1, enquoted.length()-1));
				break;
			case "CiLit":
				enquoted = ((StrategoString)app.getSubterm(0)).stringValue();
				symbol = new Literal(enquoted.substring(1, enquoted.length()-1), false);
				break;
			case "Opt":
				symbol = new Option(importSymbol(null, app.getSubterm(0)));
				break;
			case "Alt":
				symbol = new Alternative(importSymbol(null, app.getSubterm(0)), importSymbol(null, app.getSubterm(1)));
				break;
			case "Sequence":
				symbol = new Sequence(importSymbol(null, app.getSubterm(0)), importSymbolList(null, app.getSubterm(1)));
				break;
			case "Lex":
				symbol = new Lexical(importSymbol(null, app.getSubterm(0)));
				break;
			case "Cf":
				symbol = new ContextFree(importSymbol(null, app.getSubterm(0)));
				break;
			case "Iter":
				symbol = new Iteration(importSymbol(null, app.getSubterm(0)), 1, null);
				break;
			case "IterStar":
				symbol = new Iteration(importSymbol(null, app.getSubterm(0)), 0, null);
				break;
			case "IterSep":
				symbol = new Iteration(importSymbol(null, app.getSubterm(0)), 1, importSymbol(null, app.getSubterm(1)));
				break;
			case "IterStarSep":
				symbol = new Iteration(importSymbol(null, app.getSubterm(0)), 0, importSymbol(null, app.getSubterm(1)));
				break;
			case "Start":
				symbol = new Start();
				break;
			case "FileStart":
				symbol = new FileStart();
				break;
			default:
				System.err.println("Unknown symbol type `"+app.getName()+"'. Is that normalized SDF3?");
				return null;
			}
		}else{
			System.err.println("Malformed term. Application expected.");
			return null;
		}
		
		if(collection != null && symbol != null)
			symbol = collection.get(symbol, true);
		
		return symbol;
	}
	
	public static Terminal importTerminal(IStrategoTerm term){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			switch(app.getName()){
			case "Absent":
				return null;
			case "Simple":
				return importTerminal(app.getSubterm(0));
			case "Present":
				return importTerminal(app.getSubterm(0));
			case "Range":
				return new Range(
						((Numeric)importTerminal(app.getSubterm(0))).getValue(),
						((Numeric)importTerminal(app.getSubterm(1))).getValue()
						);
			case "Numeric":
				String str = ((StrategoString)app.getSubterm(0)).stringValue();
				return new Numeric(Integer.parseInt(str.substring(1)));
			case "Conc":
				return new Union(
						importTerminal(app.getSubterm(0)),
						importTerminal(app.getSubterm(1))
						);
			default:
				System.err.println("Unknown character class `"+app.getName()+"'. Is that normalized SDF3?");
				return null;
			}
		}
		
		System.err.println("Malformed term. Application expected.");
		return null;
	}
}
