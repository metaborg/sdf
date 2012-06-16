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

@SuppressWarnings("all") final class lifted7 extends Strategy 
{ 
  TermReference w_9705;

  TermReference x_9705;

  TermReference i_9770;

  TermReference y_9705;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1010:
    { 
      if(x_9705.value == null)
        break Fail1010;
      term = map_1_0.instance.invoke(context, x_9705.value, template_to_prettyprint_strategy_0_0.instance);
      if(term == null)
        break Fail1010;
      if(w_9705.value == null)
        w_9705.value = term;
      else
        if(w_9705.value != term && !w_9705.value.match(term))
          break Fail1010;
      if(x_9705.value == null)
        break Fail1010;
      term = x_9705.value;
      lifted9 lifted910 = new lifted9();
      lifted910.i_9770 = i_9770;
      term = map_1_0.instance.invoke(context, term, lifted910);
      if(term == null)
        break Fail1010;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1010;
      if(y_9705.value == null)
        y_9705.value = term;
      else
        if(y_9705.value != term && !y_9705.value.match(term))
          break Fail1010;
      if(true)
        return term;
    }
    return null;
  }
}