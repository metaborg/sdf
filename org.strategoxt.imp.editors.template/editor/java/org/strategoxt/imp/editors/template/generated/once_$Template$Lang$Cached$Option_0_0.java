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
    Fail606:
    { 
      IStrategoTerm v_9764 = null;
      TermReference w_9764 = new TermReference();
      TermReference x_9764 = new TermReference();
      IStrategoTerm y_9764 = null;
      TermReference z_9764 = new TermReference();
      IStrategoTerm b_9765 = null;
      IStrategoTerm d_9765 = null;
      if(w_9764.value == null)
        w_9764.value = term;
      else
        if(w_9764.value != term && !w_9764.value.match(term))
          break Fail606;
      if(z_9764.value == null)
        z_9764.value = term;
      else
        if(z_9764.value != term && !z_9764.value.match(term))
          break Fail606;
      b_9765 = term;
      d_9765 = term;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, d_9765, generated.const116, w_9764.value);
      if(term == null)
        break Fail606;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail606;
      v_9764 = term.getSubterm(0);
      if(z_9764.value == null)
        z_9764.value = term.getSubterm(1);
      else
        if(z_9764.value != term.getSubterm(1) && !z_9764.value.match(term.getSubterm(1)))
          break Fail606;
      y_9764 = term.getSubterm(2);
      term = v_9764;
      lifted318 lifted3180 = new lifted318();
      lifted3180.z_9764 = z_9764;
      lifted3180.w_9764 = w_9764;
      lifted3180.x_9764 = x_9764;
      term = split_fetch_1_0.instance.invoke(context, term, lifted3180);
      if(term == null)
        break Fail606;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail606;
      term = hashtable_put_0_2.instance.invoke(context, y_9764, z_9764.value, term);
      if(term == null)
        break Fail606;
      term = b_9765;
      if(x_9764.value == null)
        break Fail606;
      term = x_9764.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}