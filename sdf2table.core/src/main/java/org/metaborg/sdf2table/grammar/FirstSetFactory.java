package org.metaborg.sdf2table.grammar;

import org.metaborg.sdf2table.core.FixPoint;
import org.metaborg.sdf2table.core.FixPointFactory;

public class FirstSetFactory implements FixPointFactory{

	@Override
	public FixPoint<?> create() {
		return new FirstSet();
	}
	
}
