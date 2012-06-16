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

@SuppressWarnings("all") final class lifted307 extends Strategy 
{ 
  public static final lifted307 instance = new lifted307();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail662:
    { 
      IStrategoTerm d_9760 = null;
      IStrategoTerm l_9760 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail662;
      l_9760 = term.getSubterm(0);
      IStrategoTerm arg619 = term.getSubterm(1);
      d_9760 = arg619;
      term = aux_$Expanded_0_2.instance.invoke(context, l_9760, arg619, d_9760);
      if(term == null)
        break Fail662;
      if(true)
        return term;
    }
    return null;
  }
}