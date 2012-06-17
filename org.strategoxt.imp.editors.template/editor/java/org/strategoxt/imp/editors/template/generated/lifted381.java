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

@SuppressWarnings("all") final class lifted381 extends Strategy 
{ 
  TermReference p_32774;

  TermReference q_32774;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1646:
    { 
      if(p_32774.value == null)
        break Fail1646;
      term = templatelang_element_desugar_top_0_0.instance.invoke(context, p_32774.value);
      if(term == null)
        break Fail1646;
      if(q_32774.value == null)
        q_32774.value = term;
      else
        if(q_32774.value != term && !q_32774.value.match(term))
          break Fail1646;
      if(true)
        return term;
    }
    return null;
  }
}