package trans;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class queue_strategy_0_2 extends Strategy 
{ 
  public static queue_strategy_0_2 instance = new queue_strategy_0_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm y_10716, IStrategoTerm z_10716)
  { 
    Fail76:
    { 
      term = context.invokePrimitive("SSL_EXT_queue_strategy", term, NO_STRATEGIES, new IStrategoTerm[]{y_10716, z_10716});
      if(term == null)
        break Fail76;
      if(true)
        return term;
    }
    context.push("queue_strategy_0_2");
    context.popOnFailure();
    return null;
  }
}