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

@SuppressWarnings("all") final class lifted210 extends Strategy 
{ 
  TermReference w_32743;

  TermReference x_32743;

  TermReference y_32743;

  TermReference r_32808;

  TermReference z_32743;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1827:
    { 
      if(w_32743.value == null)
        break Fail1827;
      term = filter_1_0.instance.invoke(context, w_32743.value, templatelang_prod_to_sort_0_0.instance);
      if(term == null)
        break Fail1827;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1827;
      if(y_32743.value == null)
        y_32743.value = term;
      else
        if(y_32743.value != term && !y_32743.value.match(term))
          break Fail1827;
      if(y_32743.value == null)
        break Fail1827;
      term = map_1_0.instance.invoke(context, y_32743.value, templatelang_sort_to_strategy_0_0.instance);
      if(term == null)
        break Fail1827;
      if(x_32743.value == null)
        x_32743.value = term;
      else
        if(x_32743.value != term && !x_32743.value.match(term))
          break Fail1827;
      if(y_32743.value == null)
        break Fail1827;
      term = y_32743.value;
      lifted213 lifted2130 = new lifted213();
      lifted2130.r_32808 = r_32808;
      term = map_1_0.instance.invoke(context, term, lifted2130);
      if(term == null)
        break Fail1827;
      if(z_32743.value == null)
        z_32743.value = term;
      else
        if(z_32743.value != term && !z_32743.value.match(term))
          break Fail1827;
      if(true)
        return term;
    }
    return null;
  }
}