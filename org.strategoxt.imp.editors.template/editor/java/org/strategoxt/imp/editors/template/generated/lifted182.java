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

@SuppressWarnings("all") final class lifted182 extends Strategy 
{ 
  TermReference g_9736;

  TermReference h_9736;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail826:
    { 
      if(g_9736.value == null)
        break Fail826;
      term = templatelang_element_desugar_top_0_0.instance.invoke(context, g_9736.value);
      if(term == null)
        break Fail826;
      if(h_9736.value == null)
        h_9736.value = term;
      else
        if(h_9736.value != term && !h_9736.value.match(term))
          break Fail826;
      if(true)
        return term;
    }
    return null;
  }
}