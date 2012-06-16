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
    Fail78:
    { 
      IStrategoTerm d_10717 = null;
      IStrategoTerm e_10717 = null;
      IStrategoTerm f_10717 = null;
      IStrategoTerm j_10717 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail78;
      e_10717 = term.getSubterm(0);
      d_10717 = term.getSubterm(1);
      j_10717 = term;
      IStrategoTerm term42 = term;
      Success28:
      { 
        Fail79:
        { 
          term = editor_init_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail79;
          Success29:
          { 
            Fail80:
            { 
              IStrategoTerm g_10717 = null;
              IStrategoTerm l_10717 = null;
              g_10717 = term;
              l_10717 = d_10717;
              term = string_ends_with_0_1.instance.invoke(context, l_10717, trans.const22);
              if(term == null)
                break Fail80;
              term = g_10717;
              { 
                f_10717 = e_10717;
                term = analyze_0_0.instance.invoke(context, e_10717);
                if(term == null)
                  break Fail79;
                if(true)
                  break Success29;
              }
            }
            term = analyze_0_0.instance.invoke(context, e_10717);
            if(term == null)
              break Fail79;
            f_10717 = term;
          }
          if(true)
            break Success28;
        }
        term = term42;
        IStrategoTerm h_10717 = null;
        IStrategoTerm i_10717 = null;
        IStrategoTerm n_10717 = null;
        h_10717 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail78;
        i_10717 = term;
        n_10717 = h_10717;
        term = report_with_failure_0_2.instance.invoke(context, n_10717, trans.const23, i_10717);
        if(term == null)
          break Fail78;
      }
      term = j_10717;
      if(f_10717 == null)
        break Fail78;
      term = termFactory.makeTuple(f_10717, trans.constNil0, trans.constNil0, trans.constNil0);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}