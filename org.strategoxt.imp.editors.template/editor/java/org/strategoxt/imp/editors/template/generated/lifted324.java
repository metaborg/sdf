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

@SuppressWarnings("all") final class lifted324 extends Strategy 
{ 
  public static final lifted324 instance = new lifted324();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail645:
    { 
      IStrategoTerm f_9768 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail645;
      f_9768 = term.getSubterm(0);
      IStrategoTerm arg628 = term.getSubterm(1);
      term = aux_$Descriptor$P$P$Table_0_1.instance.invoke(context, f_9768, arg628);
      if(term == null)
        break Fail645;
      if(true)
        return term;
    }
    return null;
  }
}