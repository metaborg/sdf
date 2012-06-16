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

@SuppressWarnings("all") public class generate_aterm_1_0 extends Strategy 
{ 
  public static generate_aterm_1_0 instance = new generate_aterm_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_10717)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_aterm_1_0");
    Fail81:
    { 
      IStrategoTerm t_10717 = null;
      IStrategoTerm u_10717 = null;
      IStrategoTerm v_10717 = null;
      IStrategoTerm w_10717 = null;
      IStrategoTerm a_10718 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail81;
      v_10717 = term.getSubterm(0);
      t_10717 = term.getSubterm(3);
      a_10718 = term;
      IStrategoTerm term44 = term;
      Success30:
      { 
        Fail82:
        { 
          IStrategoTerm c_10718 = null;
          c_10718 = t_10717;
          term = guarantee_extension_0_1.instance.invoke(context, c_10718, trans.const24);
          if(term == null)
            break Fail82;
          u_10717 = term;
          term = z_10717.invoke(context, v_10717);
          if(term == null)
            break Fail82;
          w_10717 = term;
          if(true)
            break Success30;
        }
        term = term44;
        IStrategoTerm x_10717 = null;
        IStrategoTerm y_10717 = null;
        IStrategoTerm e_10718 = null;
        x_10717 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail81;
        y_10717 = term;
        e_10718 = x_10717;
        term = report_with_failure_0_2.instance.invoke(context, e_10718, trans.const25, y_10717);
        if(term == null)
          break Fail81;
      }
      term = a_10718;
      if(u_10717 == null || w_10717 == null)
        break Fail81;
      term = termFactory.makeTuple(u_10717, w_10717);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}