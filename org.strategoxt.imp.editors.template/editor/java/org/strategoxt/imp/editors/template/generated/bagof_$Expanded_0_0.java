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

@SuppressWarnings("all") public class bagof_$Expanded_0_0 extends Strategy 
{ 
  public static bagof_$Expanded_0_0 instance = new bagof_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_Expanded_0_0");
    Fail1403:
    { 
      TermReference s_32799 = new TermReference();
      TermReference t_32799 = new TermReference();
      if(t_32799.value == null)
        t_32799.value = term;
      else
        if(t_32799.value != term && !t_32799.value.match(term))
          break Fail1403;
      if(s_32799.value == null)
        s_32799.value = term;
      else
        if(s_32799.value != term && !s_32799.value.match(term))
          break Fail1403;
      Success535:
      { 
        Fail1404:
        { 
          IStrategoTerm x_32799 = null;
          x_32799 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, x_32799, generated.const217, t_32799.value);
          if(term == null)
            break Fail1404;
          if(true)
            break Success535;
        }
        term = generated.constNil3;
      }
      lifted510 lifted5100 = new lifted510();
      lifted5100.s_32799 = s_32799;
      lifted5100.t_32799 = t_32799;
      term = filter_1_0.instance.invoke(context, term, lifted5100);
      if(term == null)
        break Fail1403;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}