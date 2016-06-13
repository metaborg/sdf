package org.metaborg.sdf2table.symbol;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.metaborg.sdf2table.grammar.Exportable;
import org.metaborg.sdf2table.grammar.Production;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.*;

public abstract class Symbol implements Exportable{
	private List<Production> _productions = new ArrayList<>();
	private Set<CharClass> _follow_restrictions = new LinkedHashSet<>();
	
	protected Symbol(){
		//
	}
	
	public Set<CharClass> followRestrictions(){
		return _follow_restrictions;
	}
	
	public Terminal getFirst(){
		if(isTerminal())
			return (Terminal)this;
		
		TerminalContainer cc = new TerminalContainer();
		for(Production p : _productions)
			cc.add(p.firstSet());
		return cc.contents();
	}
	
	/**
	 * @return true if this is a terminal symbol.
	 */
	public boolean isTerminal(){
		return false;
	}
	
	public boolean isStart(){
		return false;
	}
	
	public boolean isFileStart(){
		return false;
	}
	
	/**
	 * Get the list of productions that produce this symbol
	 * @return A list of productions.
	 */
	public List<Production> getProductions(){
		return _productions;
	}
	
	public void addProduction(Production p){
		if(p.product() == this)
			_productions.add(p);
	}
	
	public abstract boolean equals(Symbol other);
	
	public abstract String toString();
	
	public abstract IStrategoTerm toATerm();
	
	public static Symbol fromStrategoTerm(IStrategoTerm term, SymbolCollection collection){
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
				symbol = Terminal.fromATerm(term.getSubterm(0));
				break;
			case "Lit":
				enquoted = ((StrategoString)app.getSubterm(0)).stringValue();
				symbol = new Literal(enquoted.substring(1, enquoted.length()-1));
				break;
			case "Opt":
				symbol = new Option(fromStrategoTerm(app.getSubterm(0), null));
				break;
			case "Alt":
				symbol = new Alternative(fromStrategoTerm(app.getSubterm(0), null), fromStrategoTerm(app.getSubterm(1), null));
				break;
			case "Lex":
				symbol = new Lexical(fromStrategoTerm(app.getSubterm(0), null));
				break;
			case "Cf":
				symbol = new ContextFree(fromStrategoTerm(app.getSubterm(0), null));
				break;
			case "Iter":
				symbol = new Iteration(fromStrategoTerm(app.getSubterm(0), null), 1, null);
				break;
			case "IterStar":
				symbol = new Iteration(fromStrategoTerm(app.getSubterm(0), null), 0, null);
				break;
			case "IterSep":
				symbol = new Iteration(fromStrategoTerm(app.getSubterm(0), null), 1, fromStrategoTerm(app.getSubterm(1), null));
				break;
			case "IterStarSep":
				symbol = new Iteration(fromStrategoTerm(app.getSubterm(0), null), 0, fromStrategoTerm(app.getSubterm(1), null));
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
		
		if(collection != null)
			symbol = collection.get(symbol, true);
		
		return symbol;
	}
}
