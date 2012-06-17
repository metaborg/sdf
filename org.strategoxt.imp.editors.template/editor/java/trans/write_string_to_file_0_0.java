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

@SuppressWarnings("all") public class write_string_to_file_0_0 extends Strategy 
{ 
  public static write_string_to_file_0_0 instance = new write_string_to_file_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("write_string_to_file_0_0");
    Fail1960:
    { 
      IStrategoTerm j_33009 = null;
      IStrategoTerm k_33009 = null;
      IStrategoTerm l_33009 = null;
      IStrategoTerm m_33009 = null;
      m_33009 = term;
      IStrategoTerm term730 = term;
      Success714:
      { 
        Fail1961:
        { 
          IStrategoTerm x_33188 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail1961;
          l_33009 = term.getSubterm(0);
          j_33009 = term.getSubterm(1);
          term = termFactory.makeTuple(l_33009, trans.const308);
          term = fopen_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1961;
          k_33009 = term;
          term = termFactory.makeTuple(j_33009, term);
          term = fputs_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1961;
          term = fclose_0_0.instance.invoke(context, k_33009);
          if(term == null)
            break Fail1961;
          term = l_33009;
          x_33188 = l_33009;
          term = context.invokePrimitive("SSL_EXT_refreshresource", term, NO_STRATEGIES, new IStrategoTerm[]{x_33188});
          if(term == null)
            break Fail1961;
          if(true)
            break Success714;
        }
        term = term730;
        TermReference n_33009 = new TermReference();
        if(n_33009.value == null)
          n_33009.value = term;
        else
          if(n_33009.value != term && !n_33009.value.match(term))
            break Fail1960;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1960;
        lifted568 lifted5680 = new lifted568();
        lifted5680.n_33009 = n_33009;
        term = report_failure_1_0.instance.invoke(context, term, lifted5680);
        if(term == null)
          break Fail1960;
      }
      term = m_33009;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}