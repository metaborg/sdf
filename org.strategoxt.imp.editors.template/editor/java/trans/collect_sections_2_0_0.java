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
    Fail1929:
    { 
      IStrategoTerm x_33003 = null;
      IStrategoTerm y_33003 = null;
      IStrategoTerm a_33004 = null;
      IStrategoTerm b_33004 = null;
      IStrategoTerm f_33004 = null;
      y_33003 = term;
      f_33004 = term;
      IStrategoTerm term713 = term;
      Success698:
      { 
        Fail1930:
        { 
          term = collect_om_1_0.instance.invoke(context, y_33003, lifted555.instance);
          if(term == null)
            break Fail1930;
          x_33003 = term;
          term = collect_om_1_0.instance.invoke(context, y_33003, lifted556.instance);
          if(term == null)
            break Fail1930;
          term = partition_1_0.instance.invoke(context, term, lifted557.instance);
          if(term == null)
            break Fail1930;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail1930;
          a_33004 = term.getSubterm(0);
          b_33004 = term.getSubterm(1);
          if(true)
            break Success698;
        }
        term = term713;
        IStrategoTerm d_33004 = null;
        IStrategoTerm e_33004 = null;
        IStrategoTerm i_33004 = null;
        d_33004 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1929;
        e_33004 = term;
        i_33004 = d_33004;
        term = report_with_failure_0_2.instance.invoke(context, i_33004, trans.const295, e_33004);
        if(term == null)
          break Fail1929;
      }
      term = f_33004;
      if(x_33003 == null || (a_33004 == null || b_33004 == null))
        break Fail1929;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consTemplateSection_1, new IStrategoTerm[]{x_33003}), termFactory.makeListCons(termFactory.makeAppl(Main._consSDFSection_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conscontext_free_syntax_1, new IStrategoTerm[]{a_33004})}), termFactory.makeListCons(termFactory.makeAppl(Main._consSDFSection_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conslexical_syntax_1, new IStrategoTerm[]{b_33004})}), (IStrategoList)trans.constNil4)));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}