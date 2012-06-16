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

@SuppressWarnings("all") public class fold_$Expanded_1_0 extends Strategy 
{ 
  public static fold_$Expanded_1_0 instance = new fold_$Expanded_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_9759)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_Expanded_1_0");
    Fail572:
    { 
      IStrategoTerm f_9759 = null;
      IStrategoTerm j_9759 = null;
      IStrategoTerm l_9759 = null;
      f_9759 = term;
      l_9759 = term;
      Success274:
      { 
        Fail573:
        { 
          IStrategoTerm n_9759 = null;
          n_9759 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, n_9759, generated.const96, f_9759);
          if(term == null)
            break Fail573;
          if(true)
            break Success274;
        }
        term = generated.constNil0;
      }
      j_9759 = term;
      term = l_9759;
      term = termFactory.makeTuple(j_9759, term);
      term = i_9759.invoke(context, term, lifted305.instance);
      if(term == null)
        break Fail572;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}