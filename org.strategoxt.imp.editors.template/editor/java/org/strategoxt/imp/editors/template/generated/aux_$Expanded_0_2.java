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

@SuppressWarnings("all") public class aux_$Expanded_0_2 extends Strategy 
{ 
  public static aux_$Expanded_0_2 instance = new aux_$Expanded_0_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm v_9761, IStrategoTerm w_9761)
  { 
    Fail586:
    { 
      IStrategoTerm x_9761 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail586;
      IStrategoTerm arg620 = term.getSubterm(0);
      if(arg620.getTermType() != IStrategoTerm.STRING || !"-531873".equals(((IStrategoString)arg620).stringValue()))
        break Fail586;
      x_9761 = term.getSubterm(1);
      term = x_9761;
      if(true)
        return term;
    }
    context.push("aux_Expanded_0_2");
    context.popOnFailure();
    return null;
  }
}