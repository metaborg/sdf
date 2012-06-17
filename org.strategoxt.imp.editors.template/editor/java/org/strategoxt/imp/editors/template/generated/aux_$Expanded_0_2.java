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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm e_32800, IStrategoTerm f_32800)
  { 
    Fail1406:
    { 
      IStrategoTerm g_32800 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1406;
      IStrategoTerm arg773 = term.getSubterm(0);
      if(arg773.getTermType() != IStrategoTerm.STRING || !"-531873".equals(((IStrategoString)arg773).stringValue()))
        break Fail1406;
      g_32800 = term.getSubterm(1);
      term = g_32800;
      if(true)
        return term;
    }
    context.push("aux_Expanded_0_2");
    context.popOnFailure();
    return null;
  }
}