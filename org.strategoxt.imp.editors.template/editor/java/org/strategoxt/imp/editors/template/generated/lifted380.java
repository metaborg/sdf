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

@SuppressWarnings("all") final class lifted380 extends Strategy 
{ 
  TermReference s_32774;

  TermReference t_32774;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1647:
    { 
      if(s_32774.value == null)
        break Fail1647;
      term = templatelang_element_desugar_top_0_0.instance.invoke(context, s_32774.value);
      if(term == null)
        break Fail1647;
      if(t_32774.value == null)
        t_32774.value = term;
      else
        if(t_32774.value != term && !t_32774.value.match(term))
          break Fail1647;
      if(true)
        return term;
    }
    return null;
  }
}