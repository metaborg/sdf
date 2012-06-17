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

@SuppressWarnings("all") public class bigbagof_$Expanded_0_0 extends Strategy 
{ 
  public static bigbagof_$Expanded_0_0 instance = new bigbagof_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_Expanded_0_0");
    Fail1398:
    { 
      TermReference v_32798 = new TermReference();
      TermReference w_32798 = new TermReference();
      if(w_32798.value == null)
        w_32798.value = term;
      else
        if(w_32798.value != term && !w_32798.value.match(term))
          break Fail1398;
      if(v_32798.value == null)
        v_32798.value = term;
      else
        if(v_32798.value != term && !v_32798.value.match(term))
          break Fail1398;
      Success533:
      { 
        Fail1399:
        { 
          IStrategoTerm a_32799 = null;
          a_32799 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, a_32799, generated.const217, w_32798.value);
          if(term == null)
            break Fail1399;
          if(true)
            break Success533;
        }
        term = generated.constNil3;
      }
      lifted507 lifted5070 = new lifted507();
      lifted5070.v_32798 = v_32798;
      lifted5070.w_32798 = w_32798;
      term = filter_1_0.instance.invoke(context, term, lifted5070);
      if(term == null)
        break Fail1398;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}