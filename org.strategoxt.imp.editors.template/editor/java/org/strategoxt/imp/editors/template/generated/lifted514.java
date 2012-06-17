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

@SuppressWarnings("all") final class lifted514 extends Strategy 
{ 
  public static final lifted514 instance = new lifted514();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1474:
    { 
      IStrategoTerm e_32802 = null;
      IStrategoTerm m_32802 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1474;
      m_32802 = term.getSubterm(0);
      IStrategoTerm arg776 = term.getSubterm(1);
      e_32802 = arg776;
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, m_32802, arg776, e_32802);
      if(term == null)
        break Fail1474;
      if(true)
        return term;
    }
    return null;
  }
}