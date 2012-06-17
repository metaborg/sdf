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

@SuppressWarnings("all") final class lifted272 extends Strategy 
{ 
  TermReference q_32756;

  TermReference r_32756;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1741:
    { 
      if(q_32756.value == null)
        break Fail1741;
      term = maybe_separating_2_0.instance.invoke(context, q_32756.value, lifted273.instance, lifted275.instance);
      if(term == null)
        break Fail1741;
      term = flatten_list_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1741;
      if(r_32756.value == null)
        r_32756.value = term;
      else
        if(r_32756.value != term && !r_32756.value.match(term))
          break Fail1741;
      if(true)
        return term;
    }
    return null;
  }
}