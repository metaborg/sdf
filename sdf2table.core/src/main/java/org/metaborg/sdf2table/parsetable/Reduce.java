package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.symbol.Sequence;
import org.metaborg.sdf2table.symbol.Terminal;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoInt;
import org.spoofax.terms.StrategoList;

public class Reduce extends Action{
	private static final StrategoConstructor CONS_REDUCE = new StrategoConstructor("reduce", 3);
	private static final StrategoConstructor CONS_REDUCE_LOOKAHEAD = new StrategoConstructor("reduce", 4);
	private static final StrategoConstructor CONS_FOLLOW_RESTRICTION = new StrategoConstructor("follow-restriction", 1);
	private static final StrategoInt APPL_NORMAL = new StrategoInt(0, null, 0);
	private static final StrategoInt APPL_REJECT = new StrategoInt(1, null, 0);
	private static final StrategoInt APPL_AVOID = new StrategoInt(2, null, 0);
	private static final StrategoInt APPL_PREFER = new StrategoInt(3, null, 0);
	
	
	enum ReducePolicy{
		NORMAL,
		PREFER,
		AVOID,
		REJECT
	}
	
	Production _prod;
	ReducePolicy _policy = ReducePolicy.NORMAL;
	Sequence _lookahead;
	
	public Reduce(Terminal symbol, Production prod){
		super(symbol);
		_prod = prod;
		
		if(_prod.attributes().contains(Production.Attribute.REJECT))
			_policy = ReducePolicy.REJECT;
	}
	
	public Reduce(Terminal symbol, Production prod, Sequence lookahead){
		super(symbol);
		_prod = prod;
		_lookahead = lookahead;
		
		if(_prod.attributes().contains(Production.Attribute.REJECT))
			_policy = ReducePolicy.REJECT;
	}
	
	public Terminal getTriggerTerminal(){
		return (Terminal)trigger();
	}
	
	public Production getProduction(){
		return _prod;
	}
	
	public ReducePolicy policy(){
		return _policy;
	}
	
	public IStrategoTerm aTermPolicy(){
		switch(_policy){
		case PREFER:
			return APPL_PREFER;
		case AVOID:
			return APPL_AVOID;
		case REJECT:
			return APPL_REJECT;
		default:
			break;
		}
		return APPL_NORMAL;
	}
	
	public IStrategoTerm toATerm(){
		if(_lookahead == null){
			if(isConflictual())
				return null;
			return new StrategoAppl(
					CONS_REDUCE,
					new IStrategoTerm[]{
							new StrategoInt(_prod.symbols().size(), null, 0),
							new StrategoInt(_prod.id(), null, 0),
							aTermPolicy()
					},
					null,
					0
			);
		}else{
			return new StrategoAppl(
					CONS_REDUCE_LOOKAHEAD,
					new IStrategoTerm[]{
							new StrategoInt(_prod.symbols().size(), null, 0),
							new StrategoInt(_prod.id(), null, 0),
							aTermPolicy(),
							Utilities.strategoListFromArray(new StrategoAppl(
									CONS_FOLLOW_RESTRICTION,
									new IStrategoTerm[]{((StrategoList)_lookahead.toATerm()).tail()},
									null,
									0
							))
					},
					null,
					0
			);
		}
	}
}
