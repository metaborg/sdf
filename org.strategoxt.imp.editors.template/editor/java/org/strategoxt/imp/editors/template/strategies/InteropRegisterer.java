package org.strategoxt.imp.editors.template.strategies;

import org.strategoxt.lang.JavaInteropRegisterer;

/**
 * Helper class for {@link unquote_0_0}.
 */
public class InteropRegisterer extends JavaInteropRegisterer {

  public InteropRegisterer() {
    super(new LibraryInitializer());
  }
}
