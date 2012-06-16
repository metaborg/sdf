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

@SuppressWarnings("all") final class lifted177 extends Strategy 
{ 
  TermReference f_9734;

  TermReference g_9734;

  TermReference h_9734;

  TermReference i_9734;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail829:
    { 
      if(f_9734.value == null)
        break Fail829;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, f_9734.value, templatelang_template_desugar_0_0.instance);
      if(term == null)
        break Fail829;
      if(g_9734.value == null)
        g_9734.value = term;
      else
        if(g_9734.value != term && !g_9734.value.match(term))
          break Fail829;
      if(h_9734.value == null)
        break Fail829;
      term = templatelang_get_attrs_0_0.instance.invoke(context, h_9734.value);
      if(term == null)
        break Fail829;
      if(i_9734.value == null)
        i_9734.value = term;
      else
        if(i_9734.value != term && !i_9734.value.match(term))
          break Fail829;
      if(true)
        return term;
    }
    return null;
  }
}