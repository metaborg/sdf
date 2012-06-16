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

@SuppressWarnings("all") public class generate_signature_concrete_0_0 extends Strategy 
{ 
  public static generate_signature_concrete_0_0 instance = new generate_signature_concrete_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_signature_concrete_0_0");
    Fail108:
    { 
      IStrategoTerm i_10721 = null;
      IStrategoTerm j_10721 = null;
      IStrategoTerm k_10721 = null;
      IStrategoTerm l_10721 = null;
      IStrategoTerm o_10721 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail108;
      k_10721 = term.getSubterm(0);
      i_10721 = term.getSubterm(3);
      o_10721 = term;
      IStrategoTerm term55 = term;
      Success39:
      { 
        Fail109:
        { 
          IStrategoTerm q_10721 = null;
          q_10721 = i_10721;
          term = guarantee_extension_0_1.instance.invoke(context, q_10721, trans.const32);
          if(term == null)
            break Fail109;
          j_10721 = term;
          term = generate_signature_0_0.instance.invoke(context, k_10721);
          if(term == null)
            break Fail109;
          term = pp_stratego_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail109;
          l_10721 = term;
          if(true)
            break Success39;
        }
        term = term55;
        IStrategoTerm m_10721 = null;
        IStrategoTerm n_10721 = null;
        IStrategoTerm s_10721 = null;
        m_10721 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail108;
        n_10721 = term;
        s_10721 = m_10721;
        term = report_with_failure_0_2.instance.invoke(context, s_10721, trans.const34, n_10721);
        if(term == null)
          break Fail108;
      }
      term = o_10721;
      if(j_10721 == null || l_10721 == null)
        break Fail108;
      term = termFactory.makeTuple(j_10721, l_10721);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}