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

@SuppressWarnings("all") public class generate_all_0_0 extends Strategy 
{ 
  public static generate_all_0_0 instance = new generate_all_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("generate_all_0_0");
    Fail110:
    { 
      IStrategoTerm k_10722 = null;
      IStrategoTerm n_10722 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail110;
      k_10722 = term;
      IStrategoTerm term56 = term;
      Success40:
      { 
        Fail111:
        { 
          term = generate_esv_concrete_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail111;
          term = write_string_to_file_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail111;
          if(true)
            break Success40;
        }
        term = term56;
        IStrategoTerm e_10722 = null;
        IStrategoTerm f_10722 = null;
        IStrategoTerm m_10722 = null;
        e_10722 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail110;
        f_10722 = term;
        m_10722 = e_10722;
        term = report_with_failure_0_2.instance.invoke(context, m_10722, trans.const35, f_10722);
        if(term == null)
          break Fail110;
      }
      term = k_10722;
      n_10722 = k_10722;
      IStrategoTerm term57 = term;
      Success41:
      { 
        Fail112:
        { 
          term = generate_sdf_concrete_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail112;
          term = write_string_to_file_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail112;
          if(true)
            break Success41;
        }
        term = term57;
        IStrategoTerm g_10722 = null;
        IStrategoTerm h_10722 = null;
        IStrategoTerm p_10722 = null;
        g_10722 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail110;
        h_10722 = term;
        p_10722 = g_10722;
        term = report_with_failure_0_2.instance.invoke(context, p_10722, trans.const35, h_10722);
        if(term == null)
          break Fail110;
      }
      term = n_10722;
      IStrategoTerm term58 = term;
      Success42:
      { 
        Fail113:
        { 
          term = generate_box_pp_concrete_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail113;
          term = write_string_to_file_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail113;
          if(true)
            break Success42;
        }
        term = term58;
        IStrategoTerm i_10722 = null;
        IStrategoTerm j_10722 = null;
        IStrategoTerm s_10722 = null;
        i_10722 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail110;
        j_10722 = term;
        s_10722 = i_10722;
        term = report_with_failure_0_2.instance.invoke(context, s_10722, trans.const35, j_10722);
        if(term == null)
          break Fail110;
      }
      term = trans.constNone0;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}