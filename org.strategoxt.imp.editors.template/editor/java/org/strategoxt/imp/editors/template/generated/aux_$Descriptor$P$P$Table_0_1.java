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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm o_32808)
  { 
    Fail1458:
    { 
      IStrategoTerm p_32808 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1458;
      IStrategoTerm arg783 = term.getSubterm(0);
      if(arg783.getTermType() != IStrategoTerm.STRING || !"-56401".equals(((IStrategoString)arg783).stringValue()))
        break Fail1458;
      p_32808 = term.getSubterm(1);
      term = p_32808;
      if(true)
        return term;
    }
    context.push("aux_DescriptorPPTable_0_1");
    context.popOnFailure();
    return null;
  }
}