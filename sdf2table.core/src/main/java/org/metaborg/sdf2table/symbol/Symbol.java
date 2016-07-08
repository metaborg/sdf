package org.metaborg.sdf2table.symbol;

import java.util.LinkedList;
import java.util.List;

import org.metaborg.sdf2table.core.Exportable;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.*;

public abstract class Symbol implements Exportable{
	public abstract Terminal getFirst();
	int _hash_code = -1;
	
	public Symbol nonContextual(){
		return this;
	}
	
	public abstract boolean nonEpsilon();
	
	public abstract boolean isLayout();
	
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
	
	public String graphviz(){
		return toString();
	}
	
	public int computeHashCode(){
		return toString().hashCode();
	}
	
	@Override
	public int hashCode(){
		if(_hash_code == -1)
			_hash_code = computeHashCode();
		return _hash_code;
	}
	
	public abstract IStrategoTerm toATerm();
	
	public static List<Symbol> fromStrategoList(IStrategoTerm term, SymbolCollection collection){
		List<Symbol> list = new LinkedList<>();
		
		if(term instanceof StrategoList){
			StrategoList slist = (StrategoList)term;
			
			for(IStrategoTerm t : slist){
				list.add(fromStrategoTerm(t, collection));
			}
		}else{
			System.err.println("sdf2table : Symbol.fromStrategoList: this term is not a list.");
		}
		
		return list;
	}
	
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
			case "Sequence":
				symbol = new Sequence(fromStrategoTerm(app.getSubterm(0), null), fromStrategoList(app.getSubterm(1), null));
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
