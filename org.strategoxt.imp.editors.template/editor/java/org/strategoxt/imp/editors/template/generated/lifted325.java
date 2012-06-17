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

@SuppressWarnings("all") final class lifted325 extends Strategy 
{ 
  TermReference b_32761;

  TermReference c_32761;

  TermReference e_32761;

  TermReference d_32761;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1684:
    { 
      IStrategoTerm j_32761 = null;
      if(b_32761.value == null)
        break Fail1684;
      term = expand_multi_line_template_production_0_0.instance.invoke(context, b_32761.value);
      if(term == null)
        break Fail1684;
      if(c_32761.value == null)
        c_32761.value = term;
      else
        if(c_32761.value != term && !c_32761.value.match(term))
          break Fail1684;
      if(c_32761.value == null)
        break Fail1684;
      term = filter_1_0.instance.invoke(context, c_32761.value, template_line_to_esv_0_0.instance);
      if(term == null)
        break Fail1684;
      term = remove_cursor_except_first_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1684;
      j_32761 = term;
      term = separate_by_0_1.instance.invoke(context, j_32761, generated.constString0);
      if(term == null)
        break Fail1684;
      term = template_to_completion_template_helper_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1684;
      if(e_32761.value == null)
        e_32761.value = term;
      else
        if(e_32761.value != term && !e_32761.value.match(term))
          break Fail1684;
      if(e_32761.value == null)
        break Fail1684;
      term = build_prefix_0_0.instance.invoke(context, e_32761.value);
      if(term == null)
        break Fail1684;
      if(d_32761.value == null)
        d_32761.value = term;
      else
        if(d_32761.value != term && !d_32761.value.match(term))
          break Fail1684;
      if(true)
        return term;
    }
    return null;
  }
}