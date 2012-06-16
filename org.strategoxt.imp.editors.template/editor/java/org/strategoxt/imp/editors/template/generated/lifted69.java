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

@SuppressWarnings("all") final class lifted69 extends Strategy 
{ 
  TermReference q_9717;

  TermReference r_9717;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail931:
    { 
      if(q_9717.value == null)
        break Fail931;
      term = template_to_sdf_0_0.instance.invoke(context, q_9717.value);
      if(term == null)
        break Fail931;
      if(r_9717.value == null)
        r_9717.value = term;
      else
        if(r_9717.value != term && !r_9717.value.match(term))
          break Fail931;
      if(true)
        return term;
    }
    return null;
  }
}