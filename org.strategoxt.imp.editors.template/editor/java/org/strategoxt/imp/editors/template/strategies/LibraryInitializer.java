package org.strategoxt.imp.editors.template.strategies;

import java.util.Arrays;
import java.util.List;

import org.strategoxt.lang.Context;
import org.strategoxt.lang.RegisteringStrategy;

public class LibraryInitializer extends org.strategoxt.lang.LibraryInitializer {

	@Override
	protected List<RegisteringStrategy> getLibraryStrategies() {
		return Arrays.<RegisteringStrategy>asList(unquote_0_0.instance);
	}

	@Override
	protected void initializeLibrary(Context context) {
	}

}
