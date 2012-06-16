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
    Fail632:
    { 
      IStrategoTerm y_9768 = null;
      TermReference z_9768 = new TermReference();
      TermReference a_9769 = new TermReference();
      IStrategoTerm b_9769 = null;
      IStrategoTerm c_9769 = null;
      IStrategoTerm e_9769 = null;
      IStrategoTerm f_9769 = null;
      IStrategoTerm h_9769 = null;
      IStrategoTerm i_9769 = null;
      if(z_9768.value == null)
        z_9768.value = term;
      else
        if(z_9768.value != term && !z_9768.value.match(term))
          break Fail632;
      e_9769 = term;
      h_9769 = term;
      f_9769 = generated.const126;
      i_9769 = h_9769;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, i_9769, f_9769, generated.constCons70);
      if(term == null)
        break Fail632;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail632;
      y_9768 = term.getSubterm(0);
      c_9769 = term.getSubterm(1);
      b_9769 = term.getSubterm(2);
      term = y_9768;
      lifted327 lifted3270 = new lifted327();
      lifted3270.z_9768 = z_9768;
      lifted3270.a_9769 = a_9769;
      term = split_fetch_1_0.instance.invoke(context, term, lifted3270);
      if(term == null)
        break Fail632;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail632;
      term = hashtable_put_0_2.instance.invoke(context, b_9769, c_9769, term);
      if(term == null)
        break Fail632;
      term = e_9769;
      if(a_9769.value == null)
        break Fail632;
      term = a_9769.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}