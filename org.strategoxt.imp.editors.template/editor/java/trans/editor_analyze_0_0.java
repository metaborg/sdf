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

@SuppressWarnings("all") public class editor_analyze_0_0 extends Strategy 
{ 
  public static editor_analyze_0_0 instance = new editor_analyze_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("editor_analyze_0_0");
    Fail1919:
    { 
      IStrategoTerm q_33002 = null;
      IStrategoTerm r_33002 = null;
      IStrategoTerm s_33002 = null;
      IStrategoTerm w_33002 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail1919;
      r_33002 = term.getSubterm(0);
      q_33002 = term.getSubterm(1);
      w_33002 = term;
      IStrategoTerm term708 = term;
      Success694:
      { 
        Fail1920:
        { 
          term = editor_init_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1920;
          Success695:
          { 
            Fail1921:
            { 
              IStrategoTerm t_33002 = null;
              IStrategoTerm y_33002 = null;
              t_33002 = term;
              y_33002 = q_33002;
              term = string_ends_with_0_1.instance.invoke(context, y_33002, trans.const291);
              if(term == null)
                break Fail1921;
              term = t_33002;
              { 
                s_33002 = r_33002;
                term = analyze_0_0.instance.invoke(context, r_33002);
                if(term == null)
                  break Fail1920;
                if(true)
                  break Success695;
              }
            }
            term = analyze_0_0.instance.invoke(context, r_33002);
            if(term == null)
              break Fail1920;
            s_33002 = term;
          }
          if(true)
            break Success694;
        }
        term = term708;
        IStrategoTerm u_33002 = null;
        IStrategoTerm v_33002 = null;
        IStrategoTerm a_33003 = null;
        u_33002 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1919;
        v_33002 = term;
        a_33003 = u_33002;
        term = report_with_failure_0_2.instance.invoke(context, a_33003, trans.const292, v_33002);
        if(term == null)
          break Fail1919;
      }
      term = w_33002;
      if(s_33002 == null)
        break Fail1919;
      term = termFactory.makeTuple(s_33002, trans.constNil4, trans.constNil4, trans.constNil4);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}