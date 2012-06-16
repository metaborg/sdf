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

@SuppressWarnings("all") final class lifted207 extends Strategy 
{ 
  TermReference m_9736;

  TermReference n_9736;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail780:
    { 
      if(m_9736.value == null)
        break Fail780;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, m_9736.value, lifted208.instance);
      if(term == null)
        break Fail780;
      if(n_9736.value == null)
        n_9736.value = term;
      else
        if(n_9736.value != term && !n_9736.value.match(term))
          break Fail780;
      if(true)
        return term;
    }
    return null;
  }
}