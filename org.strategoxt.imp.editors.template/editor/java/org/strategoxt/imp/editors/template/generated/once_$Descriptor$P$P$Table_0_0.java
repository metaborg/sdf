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

@SuppressWarnings("all") public class once_$Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static once_$Descriptor$P$P$Table_0_0 instance = new once_$Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("once_DescriptorPPTable_0_0");
    Fail1452:
    { 
      IStrategoTerm h_32807 = null;
      TermReference i_32807 = new TermReference();
      TermReference j_32807 = new TermReference();
      IStrategoTerm k_32807 = null;
      IStrategoTerm l_32807 = null;
      IStrategoTerm n_32807 = null;
      IStrategoTerm o_32807 = null;
      IStrategoTerm q_32807 = null;
      IStrategoTerm r_32807 = null;
      if(i_32807.value == null)
        i_32807.value = term;
      else
        if(i_32807.value != term && !i_32807.value.match(term))
          break Fail1452;
      n_32807 = term;
      q_32807 = term;
      o_32807 = generated.const247;
      r_32807 = q_32807;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, r_32807, o_32807, generated.constCons83);
      if(term == null)
        break Fail1452;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail1452;
      h_32807 = term.getSubterm(0);
      l_32807 = term.getSubterm(1);
      k_32807 = term.getSubterm(2);
      term = h_32807;
      lifted526 lifted5260 = new lifted526();
      lifted5260.i_32807 = i_32807;
      lifted5260.j_32807 = j_32807;
      term = split_fetch_1_0.instance.invoke(context, term, lifted5260);
      if(term == null)
        break Fail1452;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1452;
      term = hashtable_put_0_2.instance.invoke(context, k_32807, l_32807, term);
      if(term == null)
        break Fail1452;
      term = n_32807;
      if(j_32807.value == null)
        break Fail1452;
      term = j_32807.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}