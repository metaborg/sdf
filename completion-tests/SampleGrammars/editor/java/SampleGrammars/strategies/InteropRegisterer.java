package SampleGrammars.strategies;

import org.strategoxt.lang.JavaInteropRegisterer;
import org.strategoxt.lang.Strategy;

/**
 * Helper class for {@link java_strategy_0_0}.
 */
public class InteropRegisterer extends JavaInteropRegisterer {

  public InteropRegisterer() {
    super(new Strategy[] { java_strategy_0_0.instance , parse_to_pt_0_2.instance });
    
  }
}
