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

@SuppressWarnings("all") public class choose_one_expansion_0_0 extends Strategy 
{ 
  public static choose_one_expansion_0_0 instance = new choose_one_expansion_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("choose_one_expansion_0_0");
    Fail1061:
    { 
      IStrategoTerm term489 = term;
      Success435:
      { 
        Fail1062:
        { 
          term = qsort_1_0.instance.invoke(context, term, template_compare_0_0.instance);
          if(term == null)
            break Fail1062;
          term = $Hd_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1062;
          if(true)
            break Success435;
        }
        term = $Hd_0_0.instance.invoke(context, term489);
        if(term == null)
          break Fail1061;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}