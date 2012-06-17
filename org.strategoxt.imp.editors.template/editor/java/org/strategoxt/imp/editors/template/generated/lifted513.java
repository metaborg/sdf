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

@SuppressWarnings("all") final class lifted513 extends Strategy 
{ 
  public static final lifted513 instance = new lifted513();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1475:
    { 
      IStrategoTerm s_32801 = null;
      IStrategoTerm b_32802 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1475;
      b_32802 = term.getSubterm(0);
      IStrategoTerm arg775 = term.getSubterm(1);
      s_32801 = arg775;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, b_32802, arg775, s_32801);
      if(term == null)
        break Fail1475;
      if(true)
        return term;
    }
    return null;
  }
}