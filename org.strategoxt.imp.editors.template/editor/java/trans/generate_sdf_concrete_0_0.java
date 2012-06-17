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

@SuppressWarnings("all") public class generate_sdf_concrete_0_0 extends Strategy 
{ 
  public static generate_sdf_concrete_0_0 instance = new generate_sdf_concrete_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_sdf_concrete_0_0");
    Fail1945:
    { 
      IStrategoTerm m_33006 = null;
      IStrategoTerm n_33006 = null;
      IStrategoTerm o_33006 = null;
      IStrategoTerm p_33006 = null;
      IStrategoTerm s_33006 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1945;
      o_33006 = term.getSubterm(0);
      n_33006 = term.getSubterm(3);
      s_33006 = term;
      IStrategoTerm term723 = term;
      Success707:
      { 
        Fail1946:
        { 
          term = remove_extension_0_0.instance.invoke(context, n_33006);
          if(term == null)
            break Fail1946;
          term = termFactory.makeTuple(term, trans.const302);
          term = conc_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1946;
          m_33006 = term;
          term = generate_sdf_0_1.instance.invoke(context, o_33006, n_33006);
          if(term == null)
            break Fail1946;
          term = pp_sdf_to_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1946;
          p_33006 = term;
          if(true)
            break Success707;
        }
        term = term723;
        IStrategoTerm q_33006 = null;
        IStrategoTerm r_33006 = null;
        IStrategoTerm w_33006 = null;
        q_33006 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1945;
        r_33006 = term;
        w_33006 = q_33006;
        term = report_with_failure_0_2.instance.invoke(context, w_33006, trans.const303, r_33006);
        if(term == null)
          break Fail1945;
      }
      term = s_33006;
      if(m_33006 == null || p_33006 == null)
        break Fail1945;
      term = termFactory.makeTuple(m_33006, p_33006);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}