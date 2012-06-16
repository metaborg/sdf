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

@SuppressWarnings("all") public class $Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static $Descriptor$P$P$Table_0_0 instance = new $Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("DescriptorPPTable_0_0");
    Fail637:
    { 
      TermReference y_9769 = new TermReference();
      IStrategoTerm b_9770 = null;
      IStrategoTerm d_9770 = null;
      IStrategoTerm e_9770 = null;
      if(y_9769.value == null)
        y_9769.value = term;
      else
        if(y_9769.value != term && !y_9769.value.match(term))
          break Fail637;
      d_9770 = term;
      b_9770 = generated.const126;
      e_9770 = d_9770;
      term = dr_lookup_rule_0_2.instance.invoke(context, e_9770, b_9770, generated.constCons70);
      if(term == null)
        break Fail637;
      lifted330 lifted3300 = new lifted330();
      lifted3300.y_9769 = y_9769;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted3300);
      if(term == null)
        break Fail637;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}