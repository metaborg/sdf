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

@SuppressWarnings("all") final class lifted309 extends Strategy 
{ 
  TermReference t_9760;

  TermReference u_9760;

  TermReference v_9760;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail660:
    { 
      term = aux_$Expanded_0_2.instance.invoke(context, term, t_9760.value, u_9760.value);
      if(term == null)
        break Fail660;
      if(v_9760.value == null)
        v_9760.value = term;
      else
        if(v_9760.value != term && !v_9760.value.match(term))
          break Fail660;
      if(true)
        return term;
    }
    return null;
  }
}