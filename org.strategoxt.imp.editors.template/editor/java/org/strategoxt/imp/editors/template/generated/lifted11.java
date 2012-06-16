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

@SuppressWarnings("all") final class lifted11 extends Strategy 
{ 
  TermReference o_9705;

  TermReference p_9705;

  TermReference q_9705;

  TermReference i_9770;

  TermReference r_9705;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1007:
    { 
      if(o_9705.value == null)
        break Fail1007;
      term = filter_1_0.instance.invoke(context, o_9705.value, templatelang_prod_to_sort_0_0.instance);
      if(term == null)
        break Fail1007;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1007;
      if(q_9705.value == null)
        q_9705.value = term;
      else
        if(q_9705.value != term && !q_9705.value.match(term))
          break Fail1007;
      if(q_9705.value == null)
        break Fail1007;
      term = map_1_0.instance.invoke(context, q_9705.value, templatelang_sort_to_strategy_0_0.instance);
      if(term == null)
        break Fail1007;
      if(p_9705.value == null)
        p_9705.value = term;
      else
        if(p_9705.value != term && !p_9705.value.match(term))
          break Fail1007;
      if(q_9705.value == null)
        break Fail1007;
      term = q_9705.value;
      lifted14 lifted1410 = new lifted14();
      lifted1410.i_9770 = i_9770;
      term = map_1_0.instance.invoke(context, term, lifted1410);
      if(term == null)
        break Fail1007;
      if(r_9705.value == null)
        r_9705.value = term;
      else
        if(r_9705.value != term && !r_9705.value.match(term))
          break Fail1007;
      if(true)
        return term;
    }
    return null;
  }
}