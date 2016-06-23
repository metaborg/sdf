package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.core.FixPointMember;
import org.metaborg.sdf2table.symbol.TerminalContainer;

public class FollowSet extends FixPointMember<TerminalContainer, FirstSet>{
	Production _production;
	
	public FollowSet(Production prod){
		super(new TerminalContainer());
		_production = prod;
	}
	
	@Override
	public String toString(){
		return "FOLLOW("+_production.toString()+")";
	}
}
