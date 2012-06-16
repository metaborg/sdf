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
    Fail99:
    { 
      IStrategoTerm w_10719 = null;
      IStrategoTerm x_10719 = null;
      IStrategoTerm y_10719 = null;
      IStrategoTerm z_10719 = null;
      IStrategoTerm c_10720 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail99;
      y_10719 = term.getSubterm(0);
      w_10719 = term.getSubterm(3);
      c_10720 = term;
      IStrategoTerm term52 = term;
      Success36:
      { 
        Fail100:
        { 
          term = remove_extension_0_0.instance.invoke(context, w_10719);
          if(term == null)
            break Fail100;
          term = termFactory.makeTuple(term, trans.const30);
          term = conc_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail100;
          x_10719 = term;
          term = generate_sdf_0_0.instance.invoke(context, y_10719);
          if(term == null)
            break Fail100;
          term = pp_sdf_to_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail100;
          z_10719 = term;
          if(true)
            break Success36;
        }
        term = term52;
        IStrategoTerm a_10720 = null;
        IStrategoTerm b_10720 = null;
        IStrategoTerm g_10720 = null;
        a_10720 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail99;
        b_10720 = term;
        g_10720 = a_10720;
        term = report_with_failure_0_2.instance.invoke(context, g_10720, trans.const31, b_10720);
        if(term == null)
          break Fail99;
      }
      term = c_10720;
      if(x_10719 == null || z_10719 == null)
        break Fail99;
      term = termFactory.makeTuple(x_10719, z_10719);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}