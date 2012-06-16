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

@SuppressWarnings("all") final class lifted314 extends Strategy 
{ 
  public static final lifted314 instance = new lifted314();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail655:
    { 
      IStrategoTerm j_9763 = null;
      IStrategoTerm s_9763 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail655;
      s_9763 = term.getSubterm(0);
      IStrategoTerm arg622 = term.getSubterm(1);
      j_9763 = arg622;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, s_9763, arg622, j_9763);
      if(term == null)
        break Fail655;
      if(true)
        return term;
    }
    return null;
  }
}