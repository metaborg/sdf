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

@SuppressWarnings("all") public class once_$Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static once_$Template$Lang$Cached$Option_0_0 instance = new once_$Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("once_TemplateLangCachedOption_0_0");
    Fail1426:
    { 
      IStrategoTerm e_32803 = null;
      TermReference f_32803 = new TermReference();
      TermReference g_32803 = new TermReference();
      IStrategoTerm h_32803 = null;
      TermReference i_32803 = new TermReference();
      IStrategoTerm k_32803 = null;
      IStrategoTerm m_32803 = null;
      if(f_32803.value == null)
        f_32803.value = term;
      else
        if(f_32803.value != term && !f_32803.value.match(term))
          break Fail1426;
      if(i_32803.value == null)
        i_32803.value = term;
      else
        if(i_32803.value != term && !i_32803.value.match(term))
          break Fail1426;
      k_32803 = term;
      m_32803 = term;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, m_32803, generated.const237, f_32803.value);
      if(term == null)
        break Fail1426;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail1426;
      e_32803 = term.getSubterm(0);
      if(i_32803.value == null)
        i_32803.value = term.getSubterm(1);
      else
        if(i_32803.value != term.getSubterm(1) && !i_32803.value.match(term.getSubterm(1)))
          break Fail1426;
      h_32803 = term.getSubterm(2);
      term = e_32803;
      lifted517 lifted5170 = new lifted517();
      lifted5170.i_32803 = i_32803;
      lifted5170.f_32803 = f_32803;
      lifted5170.g_32803 = g_32803;
      term = split_fetch_1_0.instance.invoke(context, term, lifted5170);
      if(term == null)
        break Fail1426;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1426;
      term = hashtable_put_0_2.instance.invoke(context, h_32803, i_32803.value, term);
      if(term == null)
        break Fail1426;
      term = k_32803;
      if(g_32803.value == null)
        break Fail1426;
      term = g_32803.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}