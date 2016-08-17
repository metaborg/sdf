package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.core.Exportable;
import org.spoofax.interpreter.terms.*;

public abstract class Symbol implements Exportable{
	
	public enum Type{
		TERMINAL,
		LITERAL,
		LEXICAL,
		CONTEXT_FREE,
		UNDEF;
		
		public int level(){
			switch(this){
			case CONTEXT_FREE:
				return 3;
			case LEXICAL:
				return 2;
			case LITERAL:
				return 1;
			case TERMINAL:
				return 0;
			default:
				break;
			}
			
			System.err.println("Undefined symbol kind");
			return -1;
		}
	}
	
	public abstract Type type();
	
	/**
	 * @return true if the symbol is a Layout.
	 */
	public abstract boolean isLayout();
	
	/**
	 * @return true if the symbol is a Layout, or is always null.
	 */
	public abstract boolean isEpsilon();
	
	/**
	 * @return true if the symbol is not nullable.
	 */
	public abstract boolean nonEpsilon();
	
	public abstract Terminal getFirst();
	int _hash_code = -1;
	
	public Symbol nonContextual(){
		return this;
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
}
