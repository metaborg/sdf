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

@SuppressWarnings("all") final class lifted315 extends Strategy 
{ 
  public static final lifted315 instance = new lifted315();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail654:
    { 
      IStrategoTerm v_9763 = null;
      IStrategoTerm d_9764 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail654;
      d_9764 = term.getSubterm(0);
      IStrategoTerm arg623 = term.getSubterm(1);
      v_9763 = arg623;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, d_9764, arg623, v_9763);
      if(term == null)
        break Fail654;
      if(true)
        return term;
    }
    return null;
  }
}