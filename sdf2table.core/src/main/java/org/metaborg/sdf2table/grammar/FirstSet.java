package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.core.FixPoint;
import org.metaborg.sdf2table.symbol.TerminalContainer;

public class FirstSet extends FixPoint<TerminalContainer>{
	TerminalContainer _value = null;
	
	@Override
	public void apply(TerminalContainer set){
		if(_value == null)
			_value = set;
		else
			_value.add(set);
	}
	
	@Override
	public TerminalContainer value(){
		return _value;
	}
}
