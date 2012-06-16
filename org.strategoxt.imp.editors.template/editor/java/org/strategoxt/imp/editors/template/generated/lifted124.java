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

@SuppressWarnings("all") final class lifted124 extends Strategy 
{ 
  TermReference d_9723;

  TermReference e_9723;

  TermReference g_9723;

  TermReference f_9723;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail865:
    { 
      if(d_9723.value == null)
        break Fail865;
      term = expand_single_line_template_production_0_0.instance.invoke(context, d_9723.value);
      if(term == null)
        break Fail865;
      if(e_9723.value == null)
        e_9723.value = term;
      else
        if(e_9723.value != term && !e_9723.value.match(term))
          break Fail865;
      if(e_9723.value == null)
        break Fail865;
      term = filter_1_0.instance.invoke(context, e_9723.value, template_element_to_esv_0_0.instance);
      if(term == null)
        break Fail865;
      term = template_to_completion_template_helper_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail865;
      if(g_9723.value == null)
        g_9723.value = term;
      else
        if(g_9723.value != term && !g_9723.value.match(term))
          break Fail865;
      if(g_9723.value == null)
        break Fail865;
      term = build_prefix_0_0.instance.invoke(context, g_9723.value);
      if(term == null)
        break Fail865;
      if(f_9723.value == null)
        f_9723.value = term;
      else
        if(f_9723.value != term && !f_9723.value.match(term))
          break Fail865;
      if(true)
        return term;
    }
    return null;
  }
}