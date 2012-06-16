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
    Fail104:
    { 
      IStrategoTerm q_10720 = null;
      IStrategoTerm r_10720 = null;
      IStrategoTerm s_10720 = null;
      IStrategoTerm t_10720 = null;
      IStrategoTerm w_10720 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail104;
      s_10720 = term.getSubterm(0);
      q_10720 = term.getSubterm(3);
      w_10720 = term;
      IStrategoTerm term54 = term;
      Success38:
      { 
        Fail105:
        { 
          IStrategoTerm y_10720 = null;
          y_10720 = q_10720;
          term = guarantee_extension_0_1.instance.invoke(context, y_10720, trans.const32);
          if(term == null)
            break Fail105;
          r_10720 = term;
          term = generate_box_pp_0_0.instance.invoke(context, s_10720);
          if(term == null)
            break Fail105;
          term = pp_stratego_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail105;
          t_10720 = term;
          if(true)
            break Success38;
        }
        term = term54;
        IStrategoTerm u_10720 = null;
        IStrategoTerm v_10720 = null;
        IStrategoTerm a_10721 = null;
        u_10720 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail104;
        v_10720 = term;
        a_10721 = u_10720;
        term = report_with_failure_0_2.instance.invoke(context, a_10721, trans.const33, v_10720);
        if(term == null)
          break Fail104;
      }
      term = w_10720;
      if(r_10720 == null || t_10720 == null)
        break Fail104;
      term = termFactory.makeTuple(r_10720, t_10720);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}