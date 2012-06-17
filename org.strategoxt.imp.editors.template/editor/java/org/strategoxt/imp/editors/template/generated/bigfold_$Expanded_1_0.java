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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_32797)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_Expanded_1_0");
    Fail1390:
    { 
      IStrategoTerm c_32797 = null;
      IStrategoTerm g_32797 = null;
      IStrategoTerm i_32797 = null;
      c_32797 = term;
      i_32797 = term;
      Success529:
      { 
        Fail1391:
        { 
          IStrategoTerm k_32797 = null;
          k_32797 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, k_32797, generated.const217, c_32797);
          if(term == null)
            break Fail1391;
          if(true)
            break Success529;
        }
        term = generated.constNil3;
      }
      g_32797 = term;
      term = i_32797;
      term = termFactory.makeTuple(g_32797, term);
      term = f_32797.invoke(context, term, lifted503.instance);
      if(term == null)
        break Fail1390;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}