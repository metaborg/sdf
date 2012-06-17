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

@SuppressWarnings("all") public class once_$Expanded_0_0 extends Strategy 
{ 
  public static once_$Expanded_0_0 instance = new once_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("once_Expanded_0_0");
    Fail1400:
    { 
      IStrategoTerm b_32799 = null;
      TermReference c_32799 = new TermReference();
      TermReference d_32799 = new TermReference();
      TermReference e_32799 = new TermReference();
      IStrategoTerm f_32799 = null;
      IStrategoTerm g_32799 = null;
      IStrategoTerm i_32799 = null;
      IStrategoTerm k_32799 = null;
      if(d_32799.value == null)
        d_32799.value = term;
      else
        if(d_32799.value != term && !d_32799.value.match(term))
          break Fail1400;
      if(c_32799.value == null)
        c_32799.value = term;
      else
        if(c_32799.value != term && !c_32799.value.match(term))
          break Fail1400;
      i_32799 = term;
      k_32799 = term;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, k_32799, generated.const217, d_32799.value);
      if(term == null)
        break Fail1400;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail1400;
      b_32799 = term.getSubterm(0);
      g_32799 = term.getSubterm(1);
      f_32799 = term.getSubterm(2);
      term = b_32799;
      lifted508 lifted5080 = new lifted508();
      lifted5080.c_32799 = c_32799;
      lifted5080.d_32799 = d_32799;
      lifted5080.e_32799 = e_32799;
      term = split_fetch_1_0.instance.invoke(context, term, lifted5080);
      if(term == null)
        break Fail1400;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1400;
      term = hashtable_put_0_2.instance.invoke(context, f_32799, g_32799, term);
      if(term == null)
        break Fail1400;
      term = i_32799;
      if(e_32799.value == null)
        break Fail1400;
      term = e_32799.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}