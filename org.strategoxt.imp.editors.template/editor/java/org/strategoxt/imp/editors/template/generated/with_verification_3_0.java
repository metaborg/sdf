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

@SuppressWarnings("all") public class with_verification_3_0 extends Strategy 
{ 
  public static with_verification_3_0 instance = new with_verification_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_9750, Strategy s_9750, Strategy t_9750)
  { 
    context.push("with_verification_3_0");
    Fail391:
    { 
      IStrategoTerm p_9750 = null;
      IStrategoTerm q_9750 = null;
      p_9750 = term;
      term = r_9750.invoke(context, term);
      if(term == null)
        break Fail391;
      term = s_9750.invoke(context, p_9750);
      if(term == null)
        break Fail391;
      q_9750 = term;
      term = t_9750.invoke(context, term);
      if(term == null)
        break Fail391;
      term = q_9750;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}