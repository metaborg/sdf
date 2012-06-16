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

@SuppressWarnings("all") final class lifted107 extends Strategy 
{ 
  TermReference m_9720;

  TermReference n_9720;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail889:
    { 
      if(m_9720.value == null)
        break Fail889;
      term = separator_to_literal_0_0.instance.invoke(context, m_9720.value);
      if(term == null)
        break Fail889;
      if(n_9720.value == null)
        n_9720.value = term;
      else
        if(n_9720.value != term && !n_9720.value.match(term))
          break Fail889;
      if(true)
        return term;
    }
    return null;
  }
}