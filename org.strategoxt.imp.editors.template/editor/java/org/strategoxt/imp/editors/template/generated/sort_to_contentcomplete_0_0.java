package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") public class sort_to_contentcomplete_0_0 extends Strategy 
{ 
  public static sort_to_contentcomplete_0_0 instance = new sort_to_contentcomplete_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("sort_to_contentcomplete_0_0");
    Fail950:
    { 
      IStrategoTerm t_32759 = null;
      IStrategoTerm z_32759 = null;
      IStrategoTerm b_32760 = null;
      IStrategoTerm c_32760 = null;
      t_32759 = term;
      term = t_32759;
      IStrategoTerm term401 = term;
      Success350:
      { 
        Fail951:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail951;
          if(true)
            break Success350;
        }
        term = term401;
        IStrategoTerm term402 = term;
        Success351:
        { 
          Fail952:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail952;
            if(true)
              break Success351;
          }
          term = term402;
          IStrategoTerm term403 = term;
          Success352:
          { 
            Fail953:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail953;
              if(true)
                break Success352;
            }
            term = term403;
            IStrategoTerm term404 = term;
            Success353:
            { 
              Fail954:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail954;
                if(true)
                  break Success353;
              }
              term = term404;
              IStrategoTerm v_32759 = null;
              IStrategoTerm w_32759 = null;
              IStrategoTerm y_32759 = null;
              v_32759 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail950;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail950;
              w_32759 = ((IStrategoList)term).tail();
              y_32759 = w_32759;
              term = report_failure_0_2.instance.invoke(context, y_32759, generated.const195, v_32759);
              if(term == null)
                break Fail950;
            }
          }
        }
      }
      b_32760 = term;
      z_32759 = generated.const160;
      c_32760 = b_32760;
      term = string_replace_0_2.instance.invoke(context, c_32760, z_32759, generated.const161);
      if(term == null)
        break Fail950;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const197, termFactory.makeListCons(term, (IStrategoList)generated.constCons75));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail950;
      term = termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3));
      term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{generated.constCons76, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{t_32759}), termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil3)})})}), (IStrategoList)generated.constNil3)})});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}