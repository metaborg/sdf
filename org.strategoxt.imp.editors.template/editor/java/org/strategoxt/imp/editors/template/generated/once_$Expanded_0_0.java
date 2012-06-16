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
    Fail580:
    { 
      IStrategoTerm s_9760 = null;
      TermReference t_9760 = new TermReference();
      TermReference u_9760 = new TermReference();
      TermReference v_9760 = new TermReference();
      IStrategoTerm w_9760 = null;
      IStrategoTerm x_9760 = null;
      IStrategoTerm z_9760 = null;
      IStrategoTerm b_9761 = null;
      if(u_9760.value == null)
        u_9760.value = term;
      else
        if(u_9760.value != term && !u_9760.value.match(term))
          break Fail580;
      if(t_9760.value == null)
        t_9760.value = term;
      else
        if(t_9760.value != term && !t_9760.value.match(term))
          break Fail580;
      z_9760 = term;
      b_9761 = term;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, b_9761, generated.const96, u_9760.value);
      if(term == null)
        break Fail580;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail580;
      s_9760 = term.getSubterm(0);
      x_9760 = term.getSubterm(1);
      w_9760 = term.getSubterm(2);
      term = s_9760;
      lifted309 lifted3090 = new lifted309();
      lifted3090.t_9760 = t_9760;
      lifted3090.u_9760 = u_9760;
      lifted3090.v_9760 = v_9760;
      term = split_fetch_1_0.instance.invoke(context, term, lifted3090);
      if(term == null)
        break Fail580;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail580;
      term = hashtable_put_0_2.instance.invoke(context, w_9760, x_9760, term);
      if(term == null)
        break Fail580;
      term = z_9760;
      if(v_9760.value == null)
        break Fail580;
      term = v_9760.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}