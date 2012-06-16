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

@SuppressWarnings("all") final class lifted306 extends Strategy 
{ 
  public static final lifted306 instance = new lifted306();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail663:
    { 
      IStrategoTerm s_9759 = null;
      IStrategoTerm a_9760 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail663;
      a_9760 = term.getSubterm(0);
      IStrategoTerm arg618 = term.getSubterm(1);
      s_9759 = arg618;
      term = aux_$Expanded_0_2.instance.invoke(context, a_9760, arg618, s_9759);
      if(term == null)
        break Fail663;
      if(true)
        return term;
    }
    return null;
  }
}