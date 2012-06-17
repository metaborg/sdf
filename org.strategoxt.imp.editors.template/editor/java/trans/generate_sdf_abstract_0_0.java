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

@SuppressWarnings("all") public class generate_sdf_abstract_0_0 extends Strategy 
{ 
  public static generate_sdf_abstract_0_0 instance = new generate_sdf_abstract_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_sdf_abstract_0_0");
    Fail1943:
    { 
      IStrategoTerm w_33005 = null;
      IStrategoTerm x_33005 = null;
      IStrategoTerm y_33005 = null;
      IStrategoTerm z_33005 = null;
      IStrategoTerm c_33006 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1943;
      y_33005 = term.getSubterm(0);
      x_33005 = term.getSubterm(3);
      c_33006 = term;
      IStrategoTerm term722 = term;
      Success706:
      { 
        Fail1944:
        { 
          IStrategoTerm e_33006 = null;
          e_33006 = x_33005;
          term = guarantee_extension_0_1.instance.invoke(context, e_33006, trans.const293);
          if(term == null)
            break Fail1944;
          w_33005 = term;
          term = generate_sdf_0_1.instance.invoke(context, y_33005, x_33005);
          if(term == null)
            break Fail1944;
          z_33005 = term;
          if(true)
            break Success706;
        }
        term = term722;
        IStrategoTerm a_33006 = null;
        IStrategoTerm b_33006 = null;
        IStrategoTerm g_33006 = null;
        a_33006 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1943;
        b_33006 = term;
        g_33006 = a_33006;
        term = report_with_failure_0_2.instance.invoke(context, g_33006, trans.const301, b_33006);
        if(term == null)
          break Fail1943;
      }
      term = c_33006;
      if(w_33005 == null || z_33005 == null)
        break Fail1943;
      term = termFactory.makeTuple(w_33005, z_33005);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}