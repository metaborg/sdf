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

@SuppressWarnings("all") public class reverse_bagof_$Descriptor$P$P$Table_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Descriptor$P$P$Table_1_0 instance = new reverse_bagof_$Descriptor$P$P$Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_9769)
  { 
    context.push("reverse_bagof_DescriptorPPTable_1_0");
    Fail633:
    { 
      TermReference j_9769 = new TermReference();
      if(j_9769.value == null)
        j_9769.value = term;
      else
        if(j_9769.value != term && !j_9769.value.match(term))
          break Fail633;
      Success292:
      { 
        Fail634:
        { 
          IStrategoTerm n_9769 = null;
          IStrategoTerm p_9769 = null;
          IStrategoTerm q_9769 = null;
          p_9769 = term;
          n_9769 = generated.const126;
          q_9769 = p_9769;
          term = dr_lookup_rule_0_2.instance.invoke(context, q_9769, n_9769, generated.constCons70);
          if(term == null)
            break Fail634;
          if(true)
            break Success292;
        }
        term = generated.constNil0;
      }
      lifted328 lifted3280 = new lifted328();
      lifted3280.j_9769 = j_9769;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted3280, l_9769);
      if(term == null)
        break Fail633;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}