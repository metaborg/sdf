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

@SuppressWarnings("all") final class lifted304 extends Strategy 
{ 
  public static final lifted304 instance = new lifted304();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail665:
    { 
      IStrategoTerm u_9758 = null;
      IStrategoTerm d_9759 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail665;
      d_9759 = term.getSubterm(0);
      IStrategoTerm arg616 = term.getSubterm(1);
      u_9758 = arg616;
      term = aux_$Expanded_0_2.instance.invoke(context, d_9759, arg616, u_9758);
      if(term == null)
        break Fail665;
      if(true)
        return term;
    }
    return null;
  }
}