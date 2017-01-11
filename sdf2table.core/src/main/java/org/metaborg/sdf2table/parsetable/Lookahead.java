package org.metaborg.sdf2table.parsetable;

import java.util.List;

import org.metaborg.sdf2table.core.Utilities;
import org.metaborg.sdf2table.symbol.CharClass;
import org.metaborg.sdf2table.symbol.Followed;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;

public class Lookahead{
	private static final StrategoConstructor CONS_FOLLOW_RESTRICTION = new StrategoConstructor("follow-restriction", 1);
	List<CharClass> _list = null;
	
	public Lookahead(List<CharClass> list){
		_list = list;
	}
	
	public static Lookahead fromCharClass(CharClass cc){
		if(cc instanceof Followed){
			List<CharClass> list = ((Followed)cc).symbols();
			return new Lookahead(list.subList(1, list.size()));
		}
		return null;
	}
	
	public IStrategoTerm toATerm(){
		return Utilities.strategoListFromArray(new StrategoAppl(
				CONS_FOLLOW_RESTRICTION,
				new IStrategoTerm[]{Utilities.strategoListFromExportables(_list)},
				null,
				0
		));
	}
}
