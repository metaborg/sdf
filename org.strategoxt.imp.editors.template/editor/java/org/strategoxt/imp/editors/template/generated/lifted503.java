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

@SuppressWarnings("all") final class lifted503 extends Strategy 
{ 
  public static final lifted503 instance = new lifted503();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1485:
    { 
      IStrategoTerm d_32797 = null;
      IStrategoTerm m_32797 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1485;
      m_32797 = term.getSubterm(0);
      IStrategoTerm arg769 = term.getSubterm(1);
      d_32797 = arg769;
      term = aux_$Expanded_0_2.instance.invoke(context, m_32797, arg769, d_32797);
      if(term == null)
        break Fail1485;
      if(true)
        return term;
    }
    return null;
  }
}