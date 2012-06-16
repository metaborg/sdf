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

@SuppressWarnings("all") public class bigchain_$Expanded_0_0 extends Strategy 
{ 
  public static bigchain_$Expanded_0_0 instance = new bigchain_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_Expanded_0_0");
    Fail574:
    { 
      IStrategoTerm r_9759 = null;
      IStrategoTerm u_9759 = null;
      IStrategoTerm w_9759 = null;
      r_9759 = term;
      w_9759 = term;
      Success275:
      { 
        Fail575:
        { 
          IStrategoTerm y_9759 = null;
          y_9759 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, y_9759, generated.const96, r_9759);
          if(term == null)
            break Fail575;
          if(true)
            break Success275;
        }
        term = generated.constNil0;
      }
      u_9759 = term;
      term = w_9759;
      term = termFactory.makeTuple(u_9759, term);
      term = foldl_1_0.instance.invoke(context, term, lifted306.instance);
      if(term == null)
        break Fail574;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}