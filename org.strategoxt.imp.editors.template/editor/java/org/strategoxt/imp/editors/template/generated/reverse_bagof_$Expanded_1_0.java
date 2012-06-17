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

@SuppressWarnings("all") public class reverse_bagof_$Expanded_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Expanded_1_0 instance = new reverse_bagof_$Expanded_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32799)
  { 
    context.push("reverse_bagof_Expanded_1_0");
    Fail1401:
    { 
      TermReference l_32799 = new TermReference();
      TermReference m_32799 = new TermReference();
      if(m_32799.value == null)
        m_32799.value = term;
      else
        if(m_32799.value != term && !m_32799.value.match(term))
          break Fail1401;
      if(l_32799.value == null)
        l_32799.value = term;
      else
        if(l_32799.value != term && !l_32799.value.match(term))
          break Fail1401;
      Success534:
      { 
        Fail1402:
        { 
          IStrategoTerm r_32799 = null;
          r_32799 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, r_32799, generated.const217, m_32799.value);
          if(term == null)
            break Fail1402;
          if(true)
            break Success534;
        }
        term = generated.constNil3;
      }
      lifted509 lifted5090 = new lifted509();
      lifted5090.l_32799 = l_32799;
      lifted5090.m_32799 = m_32799;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted5090, o_32799);
      if(term == null)
        break Fail1401;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}