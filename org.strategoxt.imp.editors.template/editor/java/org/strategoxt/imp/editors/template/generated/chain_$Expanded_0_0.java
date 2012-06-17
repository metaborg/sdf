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
    Fail1396:
    { 
      IStrategoTerm l_32798 = null;
      IStrategoTerm o_32798 = null;
      IStrategoTerm q_32798 = null;
      l_32798 = term;
      q_32798 = term;
      Success532:
      { 
        Fail1397:
        { 
          IStrategoTerm s_32798 = null;
          s_32798 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, s_32798, generated.const217, l_32798);
          if(term == null)
            break Fail1397;
          if(true)
            break Success532;
        }
        term = generated.constNil3;
      }
      o_32798 = term;
      term = q_32798;
      term = termFactory.makeTuple(o_32798, term);
      term = foldl_1_0.instance.invoke(context, term, lifted506.instance);
      if(term == null)
        break Fail1396;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}