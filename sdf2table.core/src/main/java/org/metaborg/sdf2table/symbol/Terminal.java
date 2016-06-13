package org.metaborg.sdf2table.symbol;

import java.util.List;

import org.metaborg.sdf2table.grammar.Trigger;
import org.metaborg.sdf2table.parsetable.Utilities;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoString;

public abstract class Terminal extends CharClass implements Trigger{
	private static final StrategoConstructor CONS_CHARCLASS = new StrategoConstructor("char-class", 1);
	
	@Override
	public boolean isTerminal(){
		return true;
	}
	
	@Override
	public Terminal firstTerminal(){
		return this;
	}
	
	@Override
	public String toString(){
		return "["+terminalString()+"]";
	}
	
	public abstract String terminalString();
	
	public abstract Terminal except(CharClass... restrictions);
	
	public abstract List<IStrategoTerm> getATermCC();
	
	public IStrategoTerm toATerm(){
		List<IStrategoTerm> list = getATermCC();
		return new StrategoAppl(CONS_CHARCLASS, new IStrategoTerm[]{Utilities.strategoListFromCollection(list)}, null, 0);
	}
	
	public static Terminal fromATerm(IStrategoTerm term){
		if(term instanceof StrategoAppl){
			StrategoAppl app = (StrategoAppl)term;
			switch(app.getName()){
			case "Simple":
				//return new Simple(fromStrategoTerm(app.getSubterm(0)));
				return fromATerm(app.getSubterm(0));
			case "Present":
				return fromATerm(app.getSubterm(0));
			case "Range":
				return new Range(
						((Numeric)fromATerm(app.getSubterm(0))).getValue(),
						((Numeric)fromATerm(app.getSubterm(1))).getValue()
						);
			case "Numeric":
				String str = ((StrategoString)app.getSubterm(0)).stringValue();
				return new Numeric(Integer.parseInt(str.substring(1)));
			case "Conc":
				return new Union(
						fromATerm(app.getSubterm(0)),
						fromATerm(app.getSubterm(1))
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
