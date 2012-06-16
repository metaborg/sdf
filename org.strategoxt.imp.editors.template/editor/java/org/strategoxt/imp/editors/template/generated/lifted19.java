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

@SuppressWarnings("all") final class lifted19 extends Strategy 
{ 
  TermReference c_9706;

  TermReference d_9706;

  TermReference e_9706;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1003:
    { 
      if(c_9706.value == null)
        break Fail1003;
      term = filter_1_0.instance.invoke(context, c_9706.value, templatelang_prod_to_sort_0_0.instance);
      if(term == null)
        break Fail1003;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1003;
      if(d_9706.value == null)
        d_9706.value = term;
      else
        if(d_9706.value != term && !d_9706.value.match(term))
          break Fail1003;
      if(d_9706.value == null)
        break Fail1003;
      term = map_1_0.instance.invoke(context, d_9706.value, templatelang_sort_to_strategy_0_0.instance);
      if(term == null)
        break Fail1003;
      if(e_9706.value == null)
        e_9706.value = term;
      else
        if(e_9706.value != term && !e_9706.value.match(term))
          break Fail1003;
      if(true)
        return term;
    }
    return null;
  }
}