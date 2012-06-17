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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_32797)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_Expanded_1_0");
    Fail1392:
    { 
      IStrategoTerm o_32797 = null;
      IStrategoTerm s_32797 = null;
      IStrategoTerm u_32797 = null;
      o_32797 = term;
      u_32797 = term;
      Success530:
      { 
        Fail1393:
        { 
          IStrategoTerm w_32797 = null;
          w_32797 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, w_32797, generated.const217, o_32797);
          if(term == null)
            break Fail1393;
          if(true)
            break Success530;
        }
        term = generated.constNil3;
      }
      s_32797 = term;
      term = u_32797;
      term = termFactory.makeTuple(s_32797, term);
      term = r_32797.invoke(context, term, lifted504.instance);
      if(term == null)
        break Fail1392;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}