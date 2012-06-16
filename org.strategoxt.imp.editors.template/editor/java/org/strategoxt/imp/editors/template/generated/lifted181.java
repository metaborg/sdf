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

@SuppressWarnings("all") final class lifted181 extends Strategy 
{ 
  TermReference j_9736;

  TermReference k_9736;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail827:
    { 
      if(j_9736.value == null)
        break Fail827;
      term = templatelang_element_desugar_top_0_0.instance.invoke(context, j_9736.value);
      if(term == null)
        break Fail827;
      if(k_9736.value == null)
        k_9736.value = term;
      else
        if(k_9736.value != term && !k_9736.value.match(term))
          break Fail827;
      if(true)
        return term;
    }
    return null;
  }
}