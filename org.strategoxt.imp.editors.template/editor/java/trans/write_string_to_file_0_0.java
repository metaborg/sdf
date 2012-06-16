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
    Fail114:
    { 
      IStrategoTerm t_10722 = null;
      IStrategoTerm u_10722 = null;
      IStrategoTerm v_10722 = null;
      IStrategoTerm w_10722 = null;
      w_10722 = term;
      IStrategoTerm term59 = term;
      Success43:
      { 
        Fail115:
        { 
          IStrategoTerm h_10902 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail115;
          v_10722 = term.getSubterm(0);
          t_10722 = term.getSubterm(1);
          term = termFactory.makeTuple(v_10722, trans.const36);
          term = fopen_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail115;
          u_10722 = term;
          term = termFactory.makeTuple(t_10722, term);
          term = fputs_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail115;
          term = fclose_0_0.instance.invoke(context, u_10722);
          if(term == null)
            break Fail115;
          term = v_10722;
          h_10902 = v_10722;
          term = context.invokePrimitive("SSL_EXT_refreshresource", term, NO_STRATEGIES, new IStrategoTerm[]{h_10902});
          if(term == null)
            break Fail115;
          if(true)
            break Success43;
        }
        term = term59;
        TermReference x_10722 = new TermReference();
        if(x_10722.value == null)
          x_10722.value = term;
        else
          if(x_10722.value != term && !x_10722.value.match(term))
            break Fail114;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail114;
        lifted39 lifted390 = new lifted39();
        lifted390.x_10722 = x_10722;
        term = report_failure_1_0.instance.invoke(context, term, lifted390);
        if(term == null)
          break Fail114;
      }
      term = w_10722;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}