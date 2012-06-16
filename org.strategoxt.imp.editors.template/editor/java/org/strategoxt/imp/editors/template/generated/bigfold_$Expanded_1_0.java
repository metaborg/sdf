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

@SuppressWarnings("all") public class bigfold_$Expanded_1_0 extends Strategy 
{ 
  public static bigfold_$Expanded_1_0 instance = new bigfold_$Expanded_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_9758)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_Expanded_1_0");
    Fail570:
    { 
      IStrategoTerm t_9758 = null;
      IStrategoTerm x_9758 = null;
      IStrategoTerm z_9758 = null;
      t_9758 = term;
      z_9758 = term;
      Success273:
      { 
        Fail571:
        { 
          IStrategoTerm b_9759 = null;
          b_9759 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, b_9759, generated.const96, t_9758);
          if(term == null)
            break Fail571;
          if(true)
            break Success273;
        }
        term = generated.constNil0;
      }
      x_9758 = term;
      term = z_9758;
      term = termFactory.makeTuple(x_9758, term);
      term = w_9758.invoke(context, term, lifted304.instance);
      if(term == null)
        break Fail570;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}