package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.core.Exportable;
import org.metaborg.sdf2table.core.FixPointMember;
import org.spoofax.interpreter.terms.*;
import org.spoofax.terms.*;

public abstract class Symbol implements Exportable{
	//private static final MetaSymbolFactory _meta_factory = new MetaSymbolFactory();
	//protected FixPointMember<SymbolClass, MetaSymbol> _class = new FixPointMember<>(null);
	
	public abstract Terminal getFirst();
	
	public Symbol nonContextual(){
		return this;
	}
	
	/*public void computeMetaSymbol(){
		_class.compute(_meta_factory);
	}
	
	public void computeClass(){
		_class.component().compute();
	}
	
	public void computeDependencies(){
		// no dependency by default.
	}
	
	SymbolClass symbolClass(){
		return _class.value();
	}*/
	
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
	
	public abstract String toString();
	
	public String graphviz(){
		return toString();
	}
	
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
