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

@SuppressWarnings("all") final class lifted54 extends Strategy 
{ 
  TermReference l_9715;

  TermReference m_9715;

  TermReference n_9715;

  TermReference o_9715;

  TermReference p_9715;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail943:
    { 
      if(l_9715.value == null)
        break Fail943;
      term = mapconcat_1_0.instance.invoke(context, l_9715.value, lifted55.instance);
      if(term == null)
        break Fail943;
      if(n_9715.value == null)
        n_9715.value = term;
      else
        if(n_9715.value != term && !n_9715.value.match(term))
          break Fail943;
      if(m_9715.value == null || (n_9715.value == null || o_9715.value == null))
        break Fail943;
      term = termFactory.makeTuple(m_9715.value, n_9715.value, o_9715.value);
      term = templatelang_to_signature_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail943;
      if(p_9715.value == null)
        p_9715.value = term;
      else
        if(p_9715.value != term && !p_9715.value.match(term))
          break Fail943;
      if(true)
        return term;
    }
    return null;
  }
}