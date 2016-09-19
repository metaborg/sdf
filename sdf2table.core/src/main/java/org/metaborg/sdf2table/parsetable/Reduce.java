package org.metaborg.sdf2table.parsetable;

import org.metaborg.sdf2table.grammar.Production;
import org.metaborg.sdf2table.symbol.Terminal;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoInt;

public class Reduce extends Action{
	private static final StrategoConstructor CONS_REDUCE = new StrategoConstructor("reduce", 3);
	private static final StrategoConstructor CONS_REDUCE_LOOKAHEAD = new StrategoConstructor("reduce", 4);
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
	
	Label _label;
	ReducePolicy _policy = ReducePolicy.NORMAL;
	Lookahead _lookahead;
	Item _item;
	
	public Reduce(Item item, Terminal symbol, Label label){
		super(symbol);
		_label = label;
		_item = item;
		
		selectReducePolicy();
	}
	
	public Reduce(Item item, Terminal symbol, Label label, Lookahead lookahead){
		super(symbol);
		_label = label;
		_lookahead = lookahead;
		_item = item;
		
		selectReducePolicy();
	}
	
	private void selectReducePolicy(){
		for(Production.Attribute attr : _label.agent().attributes()){
			switch(attr.type()){
			case PREFER:
				_policy = ReducePolicy.PREFER;
				break;
			case AVOID:
				_policy = ReducePolicy.AVOID;
				break;
			case REJECT:
				_policy = ReducePolicy.REJECT;
				break;
			default:
				break;
			}
		}
	}
	
	public Item item(){
		return _item;
	}
	
	public void updateLabel(Label label){
		_label = label;
	}
	
	public Terminal getTriggerTerminal(){
		return (Terminal)trigger();
	}
	
	public Label label(){
		return _label;
	}
	
	public ReducePolicy policy(){
		return _policy;
	}
	
	@Override
	public Action copy(){
		return new Reduce(_item, (Terminal)trigger(), _label.copy());
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
							new StrategoInt(_label.agent().symbols().size(), null, 0),
							new StrategoInt(_label.id(), null, 0),
							aTermPolicy()
					},
					null,
					0
			);
		}else{
			return new StrategoAppl(
					CONS_REDUCE_LOOKAHEAD,
					new IStrategoTerm[]{
							new StrategoInt(_label.agent().symbols().size(), null, 0),
							new StrategoInt(_label.id(), null, 0),
							aTermPolicy(),
							_lookahead.toATerm()
					},
					null,
					0
			);
		}
	}
}
