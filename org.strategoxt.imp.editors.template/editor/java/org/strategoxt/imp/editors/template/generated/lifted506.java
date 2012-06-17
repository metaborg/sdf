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

@SuppressWarnings("all") final class lifted506 extends Strategy 
{ 
  public static final lifted506 instance = new lifted506();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1482:
    { 
      IStrategoTerm m_32798 = null;
      IStrategoTerm u_32798 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1482;
      u_32798 = term.getSubterm(0);
      IStrategoTerm arg772 = term.getSubterm(1);
      m_32798 = arg772;
      term = aux_$Expanded_0_2.instance.invoke(context, u_32798, arg772, m_32798);
      if(term == null)
        break Fail1482;
      if(true)
        return term;
    }
    return null;
  }
}