package trans;

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

@SuppressWarnings("all") public class generate_aterm_1_0 extends Strategy 
{ 
  public static generate_aterm_1_0 instance = new generate_aterm_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_33003)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_aterm_1_0");
    Fail1922:
    { 
      IStrategoTerm g_33003 = null;
      IStrategoTerm h_33003 = null;
      IStrategoTerm i_33003 = null;
      IStrategoTerm j_33003 = null;
      IStrategoTerm n_33003 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1922;
      i_33003 = term.getSubterm(0);
      g_33003 = term.getSubterm(3);
      n_33003 = term;
      IStrategoTerm term710 = term;
      Success696:
      { 
        Fail1923:
        { 
          IStrategoTerm p_33003 = null;
          p_33003 = g_33003;
          term = guarantee_extension_0_1.instance.invoke(context, p_33003, trans.const293);
          if(term == null)
            break Fail1923;
          h_33003 = term;
          term = m_33003.invoke(context, i_33003);
          if(term == null)
            break Fail1923;
          j_33003 = term;
          if(true)
            break Success696;
        }
        term = term710;
        IStrategoTerm k_33003 = null;
        IStrategoTerm l_33003 = null;
        IStrategoTerm r_33003 = null;
        k_33003 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1922;
        l_33003 = term;
        r_33003 = k_33003;
        term = report_with_failure_0_2.instance.invoke(context, r_33003, trans.const294, l_33003);
        if(term == null)
          break Fail1922;
      }
      term = n_33003;
      if(h_33003 == null || j_33003 == null)
        break Fail1922;
      term = termFactory.makeTuple(h_33003, j_33003);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}