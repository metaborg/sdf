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

@SuppressWarnings("all") public class with_verify_3_0 extends Strategy 
{ 
  public static with_verify_3_0 instance = new with_verify_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_9748, Strategy v_9748, Strategy w_9748)
  { 
    context.push("with_verify_3_0");
    Fail371:
    { 
      IStrategoTerm j_9748 = null;
      j_9748 = term;
      lifted244 lifted2440 = new lifted244();
      lifted2440.w_9748 = w_9748;
      term = verify_stratego_3_0.instance.invoke(context, term, u_9748, v_9748, lifted2440);
      if(term == null)
        break Fail371;
      term = j_9748;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}