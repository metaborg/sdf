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

@SuppressWarnings("all") public class generate_box_pp_concrete_0_0 extends Strategy 
{ 
  public static generate_box_pp_concrete_0_0 instance = new generate_box_pp_concrete_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_box_pp_concrete_0_0");
    Fail1950:
    { 
      IStrategoTerm g_33007 = null;
      IStrategoTerm h_33007 = null;
      IStrategoTerm i_33007 = null;
      IStrategoTerm j_33007 = null;
      IStrategoTerm m_33007 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1950;
      i_33007 = term.getSubterm(0);
      g_33007 = term.getSubterm(3);
      m_33007 = term;
      IStrategoTerm term725 = term;
      Success709:
      { 
        Fail1951:
        { 
          IStrategoTerm o_33007 = null;
          o_33007 = g_33007;
          term = guarantee_extension_0_1.instance.invoke(context, o_33007, trans.const304);
          if(term == null)
            break Fail1951;
          h_33007 = term;
          term = generate_box_pp_0_0.instance.invoke(context, i_33007);
          if(term == null)
            break Fail1951;
          term = pp_stratego_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1951;
          j_33007 = term;
          if(true)
            break Success709;
        }
        term = term725;
        IStrategoTerm k_33007 = null;
        IStrategoTerm l_33007 = null;
        IStrategoTerm q_33007 = null;
        k_33007 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1950;
        l_33007 = term;
        q_33007 = k_33007;
        term = report_with_failure_0_2.instance.invoke(context, q_33007, trans.const305, l_33007);
        if(term == null)
          break Fail1950;
      }
      term = m_33007;
      if(h_33007 == null || j_33007 == null)
        break Fail1950;
      term = termFactory.makeTuple(h_33007, j_33007);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}