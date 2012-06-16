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

@SuppressWarnings("all") final class lifted308 extends Strategy 
{ 
  TermReference m_9760;

  TermReference n_9760;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail661:
    { 
      term = aux_$Expanded_0_2.instance.invoke(context, term, m_9760.value, n_9760.value);
      if(term == null)
        break Fail661;
      if(true)
        return term;
    }
    return null;
  }
}