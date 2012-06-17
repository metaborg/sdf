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

@SuppressWarnings("all") final class lifted376 extends Strategy 
{ 
  TermReference o_32772;

  TermReference p_32772;

  TermReference q_32772;

  TermReference r_32772;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1649:
    { 
      if(o_32772.value == null)
        break Fail1649;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, o_32772.value, templatelang_template_desugar_0_0.instance);
      if(term == null)
        break Fail1649;
      if(p_32772.value == null)
        p_32772.value = term;
      else
        if(p_32772.value != term && !p_32772.value.match(term))
          break Fail1649;
      if(q_32772.value == null)
        break Fail1649;
      term = templatelang_get_attrs_0_0.instance.invoke(context, q_32772.value);
      if(term == null)
        break Fail1649;
      if(r_32772.value == null)
        r_32772.value = term;
      else
        if(r_32772.value != term && !r_32772.value.match(term))
          break Fail1649;
      if(true)
        return term;
    }
    return null;
  }
}