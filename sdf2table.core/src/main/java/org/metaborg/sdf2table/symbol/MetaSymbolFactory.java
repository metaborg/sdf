package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.core.FixPoint;
import org.metaborg.sdf2table.core.FixPointFactory;

public class MetaSymbolFactory implements FixPointFactory{
	@Override
	public FixPoint<?> create() {
		return new MetaSymbol();
	}
}
