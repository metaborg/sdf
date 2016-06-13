package org.metaborg.sdf2table.parsetable;

import java.util.LinkedList;
import java.util.List;

import org.metaborg.sdf2table.grammar.Production;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoAppl;
import org.spoofax.terms.StrategoConstructor;
import org.spoofax.terms.StrategoInt;

public class Priority{ // L > R
	static int _count = 0;
	private static final StrategoConstructor CONS_ARG_GTR_PRIO = new StrategoConstructor("arg-gtr-prio", 3);
	private static final StrategoConstructor CONS_GTR_PRIO = new StrategoConstructor("gtr-prio", 2);
	
	Production _production_l;
	Production _production_r;
	
	int _position;
	boolean _transitive;
	
	int _token = -1;
	
	public Priority(Production production_l, Production production_r, int position, boolean transitive){
		_production_l = production_l;
		_production_r = production_r;
		_position = position;
		_transitive = transitive;
	}
	
	public int getPosition(){
		return _position;
	}
	
	public Production getHigherPriorityProduction(){
		return _production_l;
	}
	
	public Production getLowerPriorityProduction(){
		return _production_r;
	}
	
	public boolean isTransitive(){
		return _transitive;
	}
	
	public boolean hasHigherPriority(Production prod, int position){ // this._production_l > prod ?
		return hasHigherPriorityRec(_count++, prod, position);
	}
	
	public boolean hasHigherPriorityRec(int token, Production prod, int position){ // this._production_l > prod ?
		_token = token;
		if(_position == -1 || position == _position){
			if(_production_r.equals(prod)){
				return true;
			}
		
			if(_transitive){
				for(Priority prio : _production_r.priorities()){
					if(prio._token != token /*&& prio.getPosition() == -1*/ && prio.hasHigherPriorityRec(token, prod, position))
						return true;
				}
			}
		}
		return false;
	}
	
	public void spreadRec(Priority root){
		if(root.getHigherPriorityProduction().addPriority(new Priority(root.getHigherPriorityProduction(), _production_r, root.getPosition(), false))){
			if(_transitive){
				for(Priority p : _production_r.priorities()){
					p.spreadRec(root);
				}
			}
		}
	}

	public List<IStrategoTerm> toATerms(){
		return toATermsRec(_count++, this);
	}
	
	public List<IStrategoTerm> toATermsRec(int token, Priority root){
		_token = token;
		List<IStrategoTerm> list = new LinkedList<>();
		if(root.getPosition() == -1){
			list.add(new StrategoAppl(
					CONS_GTR_PRIO,
					new IStrategoTerm[]{
							new StrategoInt(root.getHigherPriorityProduction().id(), null, 0),
							new StrategoInt(_production_r.id(), null, 0),
					},
					null,
					0
			));
		}else{
			list.add(new StrategoAppl(
					CONS_ARG_GTR_PRIO,
					new IStrategoTerm[]{
							new StrategoInt(root.getHigherPriorityProduction().id(), null, 0),
							new StrategoInt(root.getPosition(), null, 0),
							new StrategoInt(_production_r.id(), null, 0),
					},
					null,
					0
			));
		}
		if(_transitive){
			for(Priority p : _production_r.priorities()){
				if(p._token != token){
				//if(p.getPosition() == -1) // TODO Is that correct ?
					list.addAll(p.toATermsRec(token, root));
				}
			}
		}
		return list;
	}
}
