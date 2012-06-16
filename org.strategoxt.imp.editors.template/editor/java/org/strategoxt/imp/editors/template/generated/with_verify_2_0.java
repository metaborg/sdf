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

@SuppressWarnings("all") public class with_verify_2_0 extends Strategy 
{ 
  public static with_verify_2_0 instance = new with_verify_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_9749, Strategy d_9749)
  { 
    context.push("with_verify_2_0");
    Fail372:
    { 
      IStrategoTerm b_9749 = null;
      b_9749 = term;
      term = verify_stratego_3_0.instance.invoke(context, term, c_9749, d_9749, lifted245.instance);
      if(term == null)
        break Fail372;
      term = b_9749;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}