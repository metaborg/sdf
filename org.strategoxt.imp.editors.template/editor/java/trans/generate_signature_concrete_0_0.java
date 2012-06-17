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
    Fail1954:
    { 
      IStrategoTerm y_33007 = null;
      IStrategoTerm z_33007 = null;
      IStrategoTerm a_33008 = null;
      IStrategoTerm b_33008 = null;
      IStrategoTerm e_33008 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail1954;
      a_33008 = term.getSubterm(0);
      y_33007 = term.getSubterm(3);
      e_33008 = term;
      IStrategoTerm term726 = term;
      Success710:
      { 
        Fail1955:
        { 
          IStrategoTerm g_33008 = null;
          g_33008 = y_33007;
          term = guarantee_extension_0_1.instance.invoke(context, g_33008, trans.const304);
          if(term == null)
            break Fail1955;
          z_33007 = term;
          term = generate_signature_0_0.instance.invoke(context, a_33008);
          if(term == null)
            break Fail1955;
          term = pp_stratego_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1955;
          b_33008 = term;
          if(true)
            break Success710;
        }
        term = term726;
        IStrategoTerm c_33008 = null;
        IStrategoTerm d_33008 = null;
        IStrategoTerm i_33008 = null;
        c_33008 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1954;
        d_33008 = term;
        i_33008 = c_33008;
        term = report_with_failure_0_2.instance.invoke(context, i_33008, trans.const306, d_33008);
        if(term == null)
          break Fail1954;
      }
      term = e_33008;
      if(z_33007 == null || b_33008 == null)
        break Fail1954;
      term = termFactory.makeTuple(z_33007, b_33008);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}