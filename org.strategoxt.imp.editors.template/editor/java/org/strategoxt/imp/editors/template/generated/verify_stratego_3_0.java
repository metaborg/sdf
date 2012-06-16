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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_9749, Strategy f_9749, Strategy g_9749)
  { 
    context.push("verify_stratego_3_0");
    Fail373:
    { 
      IStrategoTerm term373 = term;
      Success260:
      { 
        Fail374:
        { 
          term = e_9749.invoke(context, term);
          if(term == null)
            break Fail374;
          if(true)
            break Success260;
        }
        term = term373;
        IStrategoTerm h_9749 = null;
        IStrategoTerm i_9749 = null;
        IStrategoTerm k_9749 = null;
        IStrategoTerm l_9749 = null;
        IStrategoTerm o_9749 = null;
        term = try_1_0.instance.invoke(context, term, f_9749);
        if(term == null)
          break Fail373;
        k_9749 = term;
        h_9749 = generated.constCritical0;
        term = k_9749;
        l_9749 = k_9749;
        term = as_string_1_0.instance.invoke(context, term, g_9749);
        if(term == null)
          break Fail373;
        i_9749 = term;
        term = l_9749;
        o_9749 = l_9749;
        term = log_0_3.instance.invoke(context, o_9749, h_9749, i_9749, term);
        if(term == null)
          break Fail373;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail373;
        term = report_failure_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail373;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}