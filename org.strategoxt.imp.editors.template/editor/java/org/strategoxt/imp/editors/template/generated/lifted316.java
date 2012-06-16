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

@SuppressWarnings("all") final class lifted316 extends Strategy 
{ 
  public static final lifted316 instance = new lifted316();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail653:
    { 
      IStrategoTerm g_9764 = null;
      IStrategoTerm o_9764 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail653;
      o_9764 = term.getSubterm(0);
      IStrategoTerm arg624 = term.getSubterm(1);
      g_9764 = arg624;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, o_9764, arg624, g_9764);
      if(term == null)
        break Fail653;
      if(true)
        return term;
    }
    return null;
  }
}