package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") public class run_strategy_2_1 extends Strategy 
{ 
  public static run_strategy_2_1 instance = new run_strategy_2_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_9750, Strategy w_9750, IStrategoTerm u_9750)
  { 
    context.push("run_strategy_2_1");
    Fail392:
    { 
      Success266:
      { 
        Fail393:
        { 
          term = v_9750.invoke(context, term);
          if(term == null)
            break Fail393;
          if(true)
            break Success266;
        }
        term = debug_0_0.instance.invoke(context, u_9750);
        if(term == null)
          break Fail392;
        term = w_9750.invoke(context, term);
        if(term == null)
          break Fail392;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}