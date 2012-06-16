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

@SuppressWarnings("all") final class lifted78 extends Strategy 
{ 
  TermReference b_9718;

  TermReference c_9718;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail917:
    { 
      if(b_9718.value == null)
        break Fail917;
      term = filter_1_0.instance.invoke(context, b_9718.value, lifted79.instance);
      if(term == null)
        break Fail917;
      term = maybe_separating_2_0.instance.invoke(context, term, lifted80.instance, lifted82.instance);
      if(term == null)
        break Fail917;
      term = flatten_list_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail917;
      if(c_9718.value == null)
        c_9718.value = term;
      else
        if(c_9718.value != term && !c_9718.value.match(term))
          break Fail917;
      if(true)
        return term;
    }
    return null;
  }
}