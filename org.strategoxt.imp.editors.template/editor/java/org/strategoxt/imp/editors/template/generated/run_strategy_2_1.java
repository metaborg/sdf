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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_32789, Strategy f_32789, IStrategoTerm d_32789)
  { 
    context.push("run_strategy_2_1");
    Fail1212:
    { 
      Success522:
      { 
        Fail1213:
        { 
          term = e_32789.invoke(context, term);
          if(term == null)
            break Fail1213;
          if(true)
            break Success522;
        }
        term = debug_0_0.instance.invoke(context, d_32789);
        if(term == null)
          break Fail1212;
        term = f_32789.invoke(context, term);
        if(term == null)
          break Fail1212;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}