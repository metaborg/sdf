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

@SuppressWarnings("all") final class lifted512 extends Strategy 
{ 
  public static final lifted512 instance = new lifted512();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1476:
    { 
      IStrategoTerm g_32801 = null;
      IStrategoTerm p_32801 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1476;
      p_32801 = term.getSubterm(0);
      IStrategoTerm arg774 = term.getSubterm(1);
      g_32801 = arg774;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, p_32801, arg774, g_32801);
      if(term == null)
        break Fail1476;
      if(true)
        return term;
    }
    return null;
  }
}