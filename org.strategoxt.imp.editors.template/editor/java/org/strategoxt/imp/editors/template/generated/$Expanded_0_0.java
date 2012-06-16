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

@SuppressWarnings("all") public class $Expanded_0_0 extends Strategy 
{ 
  public static $Expanded_0_0 instance = new $Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("Expanded_0_0");
    Fail585:
    { 
      TermReference p_9761 = new TermReference();
      TermReference q_9761 = new TermReference();
      IStrategoTerm u_9761 = null;
      if(q_9761.value == null)
        q_9761.value = term;
      else
        if(q_9761.value != term && !q_9761.value.match(term))
          break Fail585;
      if(p_9761.value == null)
        p_9761.value = term;
      else
        if(p_9761.value != term && !p_9761.value.match(term))
          break Fail585;
      u_9761 = term;
      term = dr_lookup_rule_0_2.instance.invoke(context, u_9761, generated.const96, q_9761.value);
      if(term == null)
        break Fail585;
      lifted312 lifted3120 = new lifted312();
      lifted3120.p_9761 = p_9761;
      lifted3120.q_9761 = q_9761;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted3120);
      if(term == null)
        break Fail585;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}