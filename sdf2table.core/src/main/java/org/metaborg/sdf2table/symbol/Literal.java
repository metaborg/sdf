package org.metaborg.sdf2table.symbol;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoString;

public class Literal extends ConcreteNonTerminal{
	private static final StrategoConstructor CONS_LIT = new StrategoConstructor("lit", 1);
	private static final StrategoConstructor CONS_CILIT = new StrategoConstructor("cilit", 1);
	
	private String _value;
	private boolean _case_sensitive = true;
	
	@Override
	public Type type(){
		return Type.LITERAL;
	}
	
	@Override
	public boolean nonEpsilon(){
		return true;
	}
	
	@Override
	public boolean isLayout(){
		return false;
	}
	
	public Literal(String value){
		super();
		_value = value;
	}
	
	public Literal(String value, boolean case_sensitive){
		super();
		_value = value;
		_case_sensitive = case_sensitive;
	}
	
	public String getValue(){
		return _value;
	}
	
	public boolean isCaseSensitive(){
		return _case_sensitive;
	}
	
	@Override
	public String toString(){
		return "\""+_value+"\"";
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof Literal){
			Literal l = (Literal)other;
			return other != null && l.isCaseSensitive() == _case_sensitive && l.getValue().equals(_value);
		}
		return false;
	}
	
	public IStrategoTerm toATerm(){
		return new StrategoAppl(_case_sensitive ? CONS_LIT : CONS_CILIT, new IStrategoTerm[]{new StrategoString(_value, null, 0)}, null, 0);
	}
}
