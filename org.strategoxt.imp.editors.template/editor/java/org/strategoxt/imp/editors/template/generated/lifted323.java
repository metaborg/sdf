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

@SuppressWarnings("all") final class lifted323 extends Strategy 
{ 
  TermReference m_32761;

  TermReference n_32761;

  TermReference p_32761;

  TermReference o_32761;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1685:
    { 
      if(m_32761.value == null)
        break Fail1685;
      term = expand_single_line_template_production_0_0.instance.invoke(context, m_32761.value);
      if(term == null)
        break Fail1685;
      if(n_32761.value == null)
        n_32761.value = term;
      else
        if(n_32761.value != term && !n_32761.value.match(term))
          break Fail1685;
      if(n_32761.value == null)
        break Fail1685;
      term = filter_1_0.instance.invoke(context, n_32761.value, template_element_to_esv_0_0.instance);
      if(term == null)
        break Fail1685;
      term = template_to_completion_template_helper_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1685;
      if(p_32761.value == null)
        p_32761.value = term;
      else
        if(p_32761.value != term && !p_32761.value.match(term))
          break Fail1685;
      if(p_32761.value == null)
        break Fail1685;
      term = build_prefix_0_0.instance.invoke(context, p_32761.value);
      if(term == null)
        break Fail1685;
      if(o_32761.value == null)
        o_32761.value = term;
      else
        if(o_32761.value != term && !o_32761.value.match(term))
          break Fail1685;
      if(true)
        return term;
    }
    return null;
  }
}