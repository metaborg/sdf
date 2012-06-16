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

@SuppressWarnings("all") public class chain_$Expanded_0_0 extends Strategy 
{ 
  public static chain_$Expanded_0_0 instance = new chain_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("chain_Expanded_0_0");
    Fail576:
    { 
      IStrategoTerm c_9760 = null;
      IStrategoTerm f_9760 = null;
      IStrategoTerm h_9760 = null;
      c_9760 = term;
      h_9760 = term;
      Success276:
      { 
        Fail577:
        { 
          IStrategoTerm j_9760 = null;
          j_9760 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, j_9760, generated.const96, c_9760);
          if(term == null)
            break Fail577;
          if(true)
            break Success276;
        }
        term = generated.constNil0;
      }
      f_9760 = term;
      term = h_9760;
      term = termFactory.makeTuple(f_9760, term);
      term = foldl_1_0.instance.invoke(context, term, lifted307.instance);
      if(term == null)
        break Fail576;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}