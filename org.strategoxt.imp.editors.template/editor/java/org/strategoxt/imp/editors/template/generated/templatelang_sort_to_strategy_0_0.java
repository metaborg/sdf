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

@SuppressWarnings("all") public class templatelang_sort_to_strategy_0_0 extends Strategy 
{ 
  public static templatelang_sort_to_strategy_0_0 instance = new templatelang_sort_to_strategy_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_sort_to_strategy_0_0");
    Fail848:
    { 
      IStrategoTerm s_32745 = null;
      IStrategoTerm x_32745 = null;
      IStrategoTerm z_32745 = null;
      IStrategoTerm a_32746 = null;
      s_32745 = term;
      term = s_32745;
      IStrategoTerm term279 = term;
      Success277:
      { 
        Fail849:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail849;
          if(true)
            break Success277;
        }
        term = term279;
        IStrategoTerm term280 = term;
        Success278:
        { 
          Fail850:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail850;
            if(true)
              break Success278;
          }
          term = term280;
          IStrategoTerm term281 = term;
          Success279:
          { 
            Fail851:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail851;
              if(true)
                break Success279;
            }
            term = term281;
            IStrategoTerm term282 = term;
            Success280:
            { 
              Fail852:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail852;
                if(true)
                  break Success280;
              }
              term = term282;
              IStrategoTerm t_32745 = null;
              IStrategoTerm u_32745 = null;
              IStrategoTerm w_32745 = null;
              t_32745 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail848;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail848;
              u_32745 = ((IStrategoList)term).tail();
              w_32745 = u_32745;
              term = report_failure_0_2.instance.invoke(context, w_32745, generated.const159, t_32745);
              if(term == null)
                break Fail848;
            }
          }
        }
      }
      z_32745 = term;
      x_32745 = generated.const160;
      a_32746 = z_32745;
      term = string_replace_0_2.instance.invoke(context, a_32746, x_32745, generated.const161);
      if(term == null)
        break Fail848;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail848;
      term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3)), generated.constBuild11});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}