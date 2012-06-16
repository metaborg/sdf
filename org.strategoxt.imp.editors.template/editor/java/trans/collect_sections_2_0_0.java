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

@SuppressWarnings("all") public class collect_sections_2_0_0 extends Strategy 
{ 
  public static collect_sections_2_0_0 instance = new collect_sections_2_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("collect_sections_2_0_0");
    Fail88:
    { 
      IStrategoTerm k_10718 = null;
      IStrategoTerm l_10718 = null;
      IStrategoTerm n_10718 = null;
      IStrategoTerm o_10718 = null;
      IStrategoTerm s_10718 = null;
      l_10718 = term;
      s_10718 = term;
      IStrategoTerm term47 = term;
      Success32:
      { 
        Fail89:
        { 
          term = collect_om_1_0.instance.invoke(context, l_10718, lifted25.instance);
          if(term == null)
            break Fail89;
          k_10718 = term;
          term = collect_om_1_0.instance.invoke(context, l_10718, lifted26.instance);
          if(term == null)
            break Fail89;
          term = partition_1_0.instance.invoke(context, term, lifted27.instance);
          if(term == null)
            break Fail89;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail89;
          n_10718 = term.getSubterm(0);
          o_10718 = term.getSubterm(1);
          if(true)
            break Success32;
        }
        term = term47;
        IStrategoTerm q_10718 = null;
        IStrategoTerm r_10718 = null;
        IStrategoTerm v_10718 = null;
        q_10718 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail88;
        r_10718 = term;
        v_10718 = q_10718;
        term = report_with_failure_0_2.instance.invoke(context, v_10718, trans.const26, r_10718);
        if(term == null)
          break Fail88;
      }
      term = s_10718;
      if(k_10718 == null || (n_10718 == null || o_10718 == null))
        break Fail88;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consTemplateSection_1, new IStrategoTerm[]{k_10718}), termFactory.makeListCons(termFactory.makeAppl(Main._consSDFSection_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conscontext_free_syntax_1, new IStrategoTerm[]{n_10718})}), termFactory.makeListCons(termFactory.makeAppl(Main._consSDFSection_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conslexical_syntax_1, new IStrategoTerm[]{o_10718})}), (IStrategoList)trans.constNil0)));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}