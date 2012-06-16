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

@SuppressWarnings("all") public class verify_1_2 extends Strategy 
{ 
  public static verify_1_2 instance = new verify_1_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_9749, IStrategoTerm ref_s_9749, IStrategoTerm ref_t_9749)
  { 
    TermReference s_9749 = new TermReference(ref_s_9749);
    TermReference t_9749 = new TermReference(ref_t_9749);
    context.push("verify_1_2");
    Fail379:
    { 
      lifted246 lifted2460 = new lifted246();
      lifted2460.u_9749 = u_9749;
      lifted2460.s_9749 = s_9749;
      lifted2460.t_9749 = t_9749;
      term = contracts_1_0.instance.invoke(context, term, lifted2460);
      if(term == null)
        break Fail379;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}