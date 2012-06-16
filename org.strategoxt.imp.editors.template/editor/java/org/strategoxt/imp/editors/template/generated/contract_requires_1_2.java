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

@SuppressWarnings("all") public class contract_requires_1_2 extends Strategy 
{ 
  public static contract_requires_1_2 instance = new contract_requires_1_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_9750, IStrategoTerm c_9750, IStrategoTerm d_9750)
  { 
    context.push("contract_requires_1_2");
    Fail384:
    { 
      Success264:
      { 
        Fail385:
        { 
          IStrategoTerm e_9750 = null;
          e_9750 = term;
          term = f_9750.invoke(context, c_9750);
          if(term == null)
            break Fail385;
          term = e_9750;
          if(true)
            break Success264;
        }
        term = debug_0_0.instance.invoke(context, generated.const144);
        if(term == null)
          break Fail384;
        term = debug_1_0.instance.invoke(context, c_9750, lifted249.instance);
        if(term == null)
          break Fail384;
        term = debug_1_0.instance.invoke(context, d_9750, lifted250.instance);
        if(term == null)
          break Fail384;
        if(true)
          break Fail384;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}