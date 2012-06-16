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

@SuppressWarnings("all") public class bagof_$Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static bagof_$Descriptor$P$P$Table_0_0 instance = new bagof_$Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_DescriptorPPTable_0_0");
    Fail635:
    { 
      TermReference r_9769 = new TermReference();
      if(r_9769.value == null)
        r_9769.value = term;
      else
        if(r_9769.value != term && !r_9769.value.match(term))
          break Fail635;
      Success293:
      { 
        Fail636:
        { 
          IStrategoTerm u_9769 = null;
          IStrategoTerm w_9769 = null;
          IStrategoTerm x_9769 = null;
          w_9769 = term;
          u_9769 = generated.const126;
          x_9769 = w_9769;
          term = dr_lookup_rule_0_2.instance.invoke(context, x_9769, u_9769, generated.constCons70);
          if(term == null)
            break Fail636;
          if(true)
            break Success293;
        }
        term = generated.constNil0;
      }
      lifted329 lifted3290 = new lifted329();
      lifted3290.r_9769 = r_9769;
      term = filter_1_0.instance.invoke(context, term, lifted3290);
      if(term == null)
        break Fail635;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}