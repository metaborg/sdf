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

@SuppressWarnings("all") final class lifted305 extends Strategy 
{ 
  public static final lifted305 instance = new lifted305();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail664:
    { 
      IStrategoTerm g_9759 = null;
      IStrategoTerm p_9759 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail664;
      p_9759 = term.getSubterm(0);
      IStrategoTerm arg617 = term.getSubterm(1);
      g_9759 = arg617;
      term = aux_$Expanded_0_2.instance.invoke(context, p_9759, arg617, g_9759);
      if(term == null)
        break Fail664;
      if(true)
        return term;
    }
    return null;
  }
}