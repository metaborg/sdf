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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_32787, Strategy e_32787, Strategy f_32787)
  { 
    context.push("with_verify_3_0");
    Fail1191:
    { 
      IStrategoTerm s_32786 = null;
      s_32786 = term;
      lifted443 lifted4430 = new lifted443();
      lifted4430.f_32787 = f_32787;
      term = verify_stratego_3_0.instance.invoke(context, term, d_32787, e_32787, lifted4430);
      if(term == null)
        break Fail1191;
      term = s_32786;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}