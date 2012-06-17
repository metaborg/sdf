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
    Fail1956:
    { 
      IStrategoTerm a_33009 = null;
      IStrategoTerm d_33009 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1956;
      a_33009 = term;
      IStrategoTerm term727 = term;
      Success711:
      { 
        Fail1957:
        { 
          term = generate_esv_concrete_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1957;
          term = write_string_to_file_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1957;
          if(true)
            break Success711;
        }
        term = term727;
        IStrategoTerm u_33008 = null;
        IStrategoTerm v_33008 = null;
        IStrategoTerm c_33009 = null;
        u_33008 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1956;
        v_33008 = term;
        c_33009 = u_33008;
        term = report_with_failure_0_2.instance.invoke(context, c_33009, trans.const307, v_33008);
        if(term == null)
          break Fail1956;
      }
      term = a_33009;
      d_33009 = a_33009;
      IStrategoTerm term728 = term;
      Success712:
      { 
        Fail1958:
        { 
          term = generate_sdf_concrete_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1958;
          term = write_string_to_file_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1958;
          if(true)
            break Success712;
        }
        term = term728;
        IStrategoTerm w_33008 = null;
        IStrategoTerm x_33008 = null;
        IStrategoTerm f_33009 = null;
        w_33008 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1956;
        x_33008 = term;
        f_33009 = w_33008;
        term = report_with_failure_0_2.instance.invoke(context, f_33009, trans.const307, x_33008);
        if(term == null)
          break Fail1956;
      }
      term = d_33009;
      IStrategoTerm term729 = term;
      Success713:
      { 
        Fail1959:
        { 
          term = generate_box_pp_concrete_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1959;
          term = write_string_to_file_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1959;
          if(true)
            break Success713;
        }
        term = term729;
        IStrategoTerm y_33008 = null;
        IStrategoTerm z_33008 = null;
        IStrategoTerm i_33009 = null;
        y_33008 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1956;
        z_33008 = term;
        i_33009 = y_33008;
        term = report_with_failure_0_2.instance.invoke(context, i_33009, trans.const307, z_33008);
        if(term == null)
          break Fail1956;
      }
      term = trans.constNone1;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}