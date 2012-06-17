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

@SuppressWarnings("all") final class lifted277 extends Strategy 
{ 
  TermReference j_32756;

  TermReference k_32756;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1737:
    { 
      if(j_32756.value == null)
        break Fail1737;
      term = filter_1_0.instance.invoke(context, j_32756.value, lifted278.instance);
      if(term == null)
        break Fail1737;
      term = maybe_separating_2_0.instance.invoke(context, term, lifted279.instance, lifted281.instance);
      if(term == null)
        break Fail1737;
      term = flatten_list_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1737;
      if(k_32756.value == null)
        k_32756.value = term;
      else
        if(k_32756.value != term && !k_32756.value.match(term))
          break Fail1737;
      if(true)
        return term;
    }
    return null;
  }
}