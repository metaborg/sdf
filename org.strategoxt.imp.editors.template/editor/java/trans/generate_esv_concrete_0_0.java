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
    Fail94:
    { 
      IStrategoTerm e_10719 = null;
      IStrategoTerm f_10719 = null;
      IStrategoTerm g_10719 = null;
      IStrategoTerm h_10719 = null;
      IStrategoTerm k_10719 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 5)
        break Fail94;
      g_10719 = term.getSubterm(0);
      e_10719 = term.getSubterm(3);
      k_10719 = term;
      IStrategoTerm term50 = term;
      Success34:
      { 
        Fail95:
        { 
          IStrategoTerm m_10719 = null;
          m_10719 = e_10719;
          term = guarantee_extension_0_1.instance.invoke(context, m_10719, trans.const28);
          if(term == null)
            break Fail95;
          f_10719 = term;
          term = generate_esv_0_0.instance.invoke(context, g_10719);
          if(term == null)
            break Fail95;
          term = pp_descriptor_to_string_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail95;
          h_10719 = term;
          if(true)
            break Success34;
        }
        term = term50;
        IStrategoTerm i_10719 = null;
        IStrategoTerm j_10719 = null;
        IStrategoTerm o_10719 = null;
        i_10719 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail94;
        j_10719 = term;
        o_10719 = i_10719;
        term = report_with_failure_0_2.instance.invoke(context, o_10719, trans.const29, j_10719);
        if(term == null)
          break Fail94;
      }
      term = k_10719;
      if(f_10719 == null || h_10719 == null)
        break Fail94;
      term = termFactory.makeTuple(f_10719, h_10719);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}