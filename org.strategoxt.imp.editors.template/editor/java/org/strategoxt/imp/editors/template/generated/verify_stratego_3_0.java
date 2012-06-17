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

@SuppressWarnings("all") public class verify_stratego_3_0 extends Strategy 
{ 
  public static verify_stratego_3_0 instance = new verify_stratego_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32787, Strategy o_32787, Strategy p_32787)
  { 
    context.push("verify_stratego_3_0");
    Fail1193:
    { 
      IStrategoTerm term629 = term;
      Success516:
      { 
        Fail1194:
        { 
          term = n_32787.invoke(context, term);
          if(term == null)
            break Fail1194;
          if(true)
            break Success516;
        }
        term = term629;
        IStrategoTerm q_32787 = null;
        IStrategoTerm r_32787 = null;
        IStrategoTerm t_32787 = null;
        IStrategoTerm u_32787 = null;
        IStrategoTerm x_32787 = null;
        term = try_1_0.instance.invoke(context, term, o_32787);
        if(term == null)
          break Fail1193;
        t_32787 = term;
        q_32787 = generated.constCritical0;
        term = t_32787;
        u_32787 = t_32787;
        term = as_string_1_0.instance.invoke(context, term, p_32787);
        if(term == null)
          break Fail1193;
        r_32787 = term;
        term = u_32787;
        x_32787 = u_32787;
        term = log_0_3.instance.invoke(context, x_32787, q_32787, r_32787, term);
        if(term == null)
          break Fail1193;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1193;
        term = report_failure_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail1193;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}