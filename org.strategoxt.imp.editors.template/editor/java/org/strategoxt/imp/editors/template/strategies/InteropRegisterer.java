package org.strategoxt.imp.editors.template.strategies;

import org.strategoxt.lang.JavaInteropRegisterer;
import org.strategoxt.lang.Strategy;

public class InteropRegisterer extends JavaInteropRegisterer {
    public InteropRegisterer() {
        super(new Strategy[] { unquote_0_0.instance });
    }
}
