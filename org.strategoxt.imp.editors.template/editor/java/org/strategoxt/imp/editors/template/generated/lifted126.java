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

@SuppressWarnings("all") final class lifted126 extends Strategy 
{ 
  TermReference s_9722;

  TermReference t_9722;

  TermReference v_9722;

  TermReference u_9722;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail864:
    { 
      IStrategoTerm a_9723 = null;
      if(s_9722.value == null)
        break Fail864;
      term = expand_multi_line_template_production_0_0.instance.invoke(context, s_9722.value);
      if(term == null)
        break Fail864;
      if(t_9722.value == null)
        t_9722.value = term;
      else
        if(t_9722.value != term && !t_9722.value.match(term))
          break Fail864;
      if(t_9722.value == null)
        break Fail864;
      term = filter_1_0.instance.invoke(context, t_9722.value, template_line_to_esv_0_0.instance);
      if(term == null)
        break Fail864;
      term = remove_cursor_except_first_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail864;
      a_9723 = term;
      term = separate_by_0_1.instance.invoke(context, a_9723, generated.constString0);
      if(term == null)
        break Fail864;
      term = template_to_completion_template_helper_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail864;
      if(v_9722.value == null)
        v_9722.value = term;
      else
        if(v_9722.value != term && !v_9722.value.match(term))
          break Fail864;
      if(v_9722.value == null)
        break Fail864;
      term = build_prefix_0_0.instance.invoke(context, v_9722.value);
      if(term == null)
        break Fail864;
      if(u_9722.value == null)
        u_9722.value = term;
      else
        if(u_9722.value != term && !u_9722.value.match(term))
          break Fail864;
      if(true)
        return term;
    }
    return null;
  }
}