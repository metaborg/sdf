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

@SuppressWarnings("all") final class lifted73 extends Strategy 
{ 
  TermReference i_9718;

  TermReference j_9718;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail921:
    { 
      if(i_9718.value == null)
        break Fail921;
      term = maybe_separating_2_0.instance.invoke(context, i_9718.value, lifted74.instance, lifted76.instance);
      if(term == null)
        break Fail921;
      term = flatten_list_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail921;
      if(j_9718.value == null)
        j_9718.value = term;
      else
        if(j_9718.value != term && !j_9718.value.match(term))
          break Fail921;
      if(true)
        return term;
    }
    return null;
  }
}