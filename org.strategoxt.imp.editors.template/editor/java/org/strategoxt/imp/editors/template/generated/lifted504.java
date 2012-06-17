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

@SuppressWarnings("all") final class lifted504 extends Strategy 
{ 
  public static final lifted504 instance = new lifted504();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1484:
    { 
      IStrategoTerm p_32797 = null;
      IStrategoTerm y_32797 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1484;
      y_32797 = term.getSubterm(0);
      IStrategoTerm arg770 = term.getSubterm(1);
      p_32797 = arg770;
      term = aux_$Expanded_0_2.instance.invoke(context, y_32797, arg770, p_32797);
      if(term == null)
        break Fail1484;
      if(true)
        return term;
    }
    return null;
  }
}