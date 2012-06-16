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

@SuppressWarnings("all") final class lifted28 extends Strategy 
{ 
  TermReference j_9710;

  TermReference k_9710;

  TermReference l_9710;

  TermReference m_9710;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail995:
    { 
      if(j_9710.value == null || k_9710.value == null)
        break Fail995;
      term = termFactory.makeTuple(j_9710.value, k_9710.value);
      term = thread_map_1_0.instance.invoke(context, term, lifted29.instance);
      if(term == null)
        break Fail995;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail995;
      if(l_9710.value == null)
        l_9710.value = term.getSubterm(0);
      else
        if(l_9710.value != term.getSubterm(0) && !l_9710.value.match(term.getSubterm(0)))
          break Fail995;
      if(m_9710.value == null)
        m_9710.value = term.getSubterm(1);
      else
        if(m_9710.value != term.getSubterm(1) && !m_9710.value.match(term.getSubterm(1)))
          break Fail995;
      if(true)
        return term;
    }
    return null;
  }
}