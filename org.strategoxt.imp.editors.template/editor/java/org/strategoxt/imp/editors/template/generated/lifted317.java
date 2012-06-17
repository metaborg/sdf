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

@SuppressWarnings("all") final class lifted317 extends Strategy 
{ 
  TermReference m_32760;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1687:
    { 
      IStrategoTerm o_32760 = null;
      TermReference p_32760 = new TermReference();
      o_32760 = term;
      if(p_32760.value == null)
        p_32760.value = term;
      else
        if(p_32760.value != term && !p_32760.value.match(term))
          break Fail1687;
      if(m_32760.value == null)
        break Fail1687;
      term = m_32760.value;
      lifted318 lifted3180 = new lifted318();
      lifted3180.p_32760 = p_32760;
      term = SRTS_one.instance.invoke(context, term, lifted3180);
      if(term == null)
        break Fail1687;
      term = o_32760;
      if(true)
        return term;
    }
    return null;
  }
}