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

@SuppressWarnings("all") public class contract_requires_2_2 extends Strategy 
{ 
  public static contract_requires_2_2 instance = new contract_requires_2_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_9750, Strategy b_9750, IStrategoTerm y_9749, IStrategoTerm z_9749)
  { 
    context.push("contract_requires_2_2");
    Fail382:
    { 
      IStrategoTerm term376 = term;
      Success263:
      { 
        Fail383:
        { 
          term = contract_requires_1_2.instance.invoke(context, term, a_9750, y_9749, z_9749);
          if(term == null)
            break Fail383;
          if(true)
            break Success263;
        }
        term = b_9750.invoke(context, term376);
        if(term == null)
          break Fail382;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}