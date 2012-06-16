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

@SuppressWarnings("all") public class contract_requires_1_0 extends Strategy 
{ 
  public static contract_requires_1_0 instance = new contract_requires_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_9750)
  { 
    context.push("contract_requires_1_0");
    Fail387:
    { 
      IStrategoTerm term378 = term;
      Success265:
      { 
        Fail388:
        { 
          IStrategoTerm i_9750 = null;
          i_9750 = term;
          term = k_9750.invoke(context, term);
          if(term == null)
            break Fail388;
          term = i_9750;
          if(true)
            break Success265;
        }
        term = term378;
        IStrategoTerm j_9750 = null;
        j_9750 = term;
        term = debug_0_0.instance.invoke(context, generated.const144);
        if(term == null)
          break Fail387;
        term = debug_1_0.instance.invoke(context, j_9750, lifted251.instance);
        if(term == null)
          break Fail387;
        if(true)
          break Fail387;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}