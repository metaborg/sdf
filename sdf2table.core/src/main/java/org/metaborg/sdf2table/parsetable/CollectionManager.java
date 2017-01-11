package org.metaborg.sdf2table.parsetable;

import java.util.Collection;

public interface CollectionManager<Container extends Collection<Value>, Value>{
	public Container create();
	
	public Container create(Container from);
	
	public Value copy(Value other);
}
