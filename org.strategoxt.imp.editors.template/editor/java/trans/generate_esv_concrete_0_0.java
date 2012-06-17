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

@SuppressWarnings("all") public class generate_esv_concrete_0_0 extends Strategy 
{ 
  public static generate_esv_concrete_0_0 instance = new generate_esv_concrete_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_esv_concrete_0_0");
    Fail1935:
    { 
      IStrategoTerm r_33004 = null;
      IStrategoTerm s_33004 = null;
      IStrategoTerm t_33004 = null;
      IStrategoTerm u_33004 = null;
      IStrategoTerm x_33004 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1935;
      t_33004 = term.getSubterm(0);
      r_33004 = term.getSubterm(3);
      x_33004 = term;
      IStrategoTerm term716 = term;
      Success700:
      { 
        Fail1936:
        { 
          IStrategoTerm z_33004 = null;
          z_33004 = r_33004;
          term = guarantee_extension_0_1.instance.invoke(context, z_33004, trans.const297);
          if(term == null)
            break Fail1936;
          s_33004 = term;
          term = generate_esv_0_0.instance.invoke(context, t_33004);
          if(term == null)
            break Fail1936;
          term = pp_descriptor_to_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1936;
          u_33004 = term;
          if(true)
            break Success700;
        }
        term = term716;
        IStrategoTerm v_33004 = null;
        IStrategoTerm w_33004 = null;
        IStrategoTerm b_33005 = null;
        v_33004 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1935;
        w_33004 = term;
        b_33005 = v_33004;
        term = report_with_failure_0_2.instance.invoke(context, b_33005, trans.const298, w_33004);
        if(term == null)
          break Fail1935;
      }
      term = x_33004;
      if(s_33004 == null || u_33004 == null)
        break Fail1935;
      term = termFactory.makeTuple(s_33004, u_33004);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}