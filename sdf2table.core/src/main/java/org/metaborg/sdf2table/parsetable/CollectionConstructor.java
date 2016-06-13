package org.metaborg.sdf2table.parsetable;

import java.util.Collection;

public interface CollectionConstructor<Container extends Collection<Value>, Value>{
	public Container create();
	
	public Container create(Container from);
}
