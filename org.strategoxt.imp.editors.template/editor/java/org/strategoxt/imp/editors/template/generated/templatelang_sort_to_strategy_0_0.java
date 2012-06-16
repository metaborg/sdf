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
    Fail29:
    { 
      IStrategoTerm k_9707 = null;
      IStrategoTerm p_9707 = null;
      IStrategoTerm r_9707 = null;
      IStrategoTerm s_9707 = null;
      k_9707 = term;
      term = k_9707;
      IStrategoTerm term24 = term;
      Success22:
      { 
        Fail30:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail30;
          if(true)
            break Success22;
        }
        term = term24;
        IStrategoTerm term25 = term;
        Success23:
        { 
          Fail31:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail31;
            if(true)
              break Success23;
          }
          term = term25;
          IStrategoTerm term26 = term;
          Success24:
          { 
            Fail32:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail32;
              if(true)
                break Success24;
            }
            term = term26;
            IStrategoTerm term27 = term;
            Success25:
            { 
              Fail33:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail33;
                if(true)
                  break Success25;
              }
              term = term27;
              IStrategoTerm l_9707 = null;
              IStrategoTerm m_9707 = null;
              IStrategoTerm o_9707 = null;
              l_9707 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail29;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail29;
              m_9707 = ((IStrategoList)term).tail();
              o_9707 = m_9707;
              term = report_failure_0_2.instance.invoke(context, o_9707, generated.const38, l_9707);
              if(term == null)
                break Fail29;
            }
          }
        }
      }
      r_9707 = term;
      p_9707 = generated.const39;
      s_9707 = r_9707;
      term = string_replace_0_2.instance.invoke(context, s_9707, p_9707, generated.const40);
      if(term == null)
        break Fail29;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail29;
      term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0)), generated.constBuild11});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}