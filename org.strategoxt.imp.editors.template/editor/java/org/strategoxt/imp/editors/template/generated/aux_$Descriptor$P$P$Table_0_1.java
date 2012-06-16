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

@SuppressWarnings("all") public class aux_$Descriptor$P$P$Table_0_1 extends Strategy 
{ 
  public static aux_$Descriptor$P$P$Table_0_1 instance = new aux_$Descriptor$P$P$Table_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm f_9770)
  { 
    Fail638:
    { 
      IStrategoTerm g_9770 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail638;
      IStrategoTerm arg630 = term.getSubterm(0);
      if(arg630.getTermType() != IStrategoTerm.STRING || !"-56401".equals(((IStrategoString)arg630).stringValue()))
        break Fail638;
      g_9770 = term.getSubterm(1);
      term = g_9770;
      if(true)
        return term;
    }
    context.push("aux_DescriptorPPTable_0_1");
    context.popOnFailure();
    return null;
  }
}