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

@SuppressWarnings("all") final class lifted515 extends Strategy 
{ 
  public static final lifted515 instance = new lifted515();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1473:
    { 
      IStrategoTerm p_32802 = null;
      IStrategoTerm x_32802 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1473;
      x_32802 = term.getSubterm(0);
      IStrategoTerm arg777 = term.getSubterm(1);
      p_32802 = arg777;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, x_32802, arg777, p_32802);
      if(term == null)
        break Fail1473;
      if(true)
        return term;
    }
    return null;
  }
}