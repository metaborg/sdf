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

@SuppressWarnings("all") public class templatelang_sort_to_strategy_0_1 extends Strategy 
{ 
  public static templatelang_sort_to_strategy_0_1 instance = new templatelang_sort_to_strategy_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm k_9706)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_sort_to_strategy_0_1");
    Fail20:
    { 
      IStrategoTerm l_9706 = null;
      IStrategoTerm c_9707 = null;
      IStrategoTerm q_9706 = null;
      IStrategoTerm s_9706 = null;
      IStrategoTerm t_9706 = null;
      IStrategoTerm y_9706 = null;
      IStrategoTerm a_9707 = null;
      IStrategoTerm b_9707 = null;
      l_9706 = term;
      term = k_9706;
      IStrategoTerm term16 = term;
      Success14:
      { 
        Fail21:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail21;
          if(true)
            break Success14;
        }
        term = term16;
        IStrategoTerm term17 = term;
        Success15:
        { 
          Fail22:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail22;
            if(true)
              break Success15;
          }
          term = term17;
          IStrategoTerm term18 = term;
          Success16:
          { 
            Fail23:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail23;
              if(true)
                break Success16;
            }
            term = term18;
            IStrategoTerm term19 = term;
            Success17:
            { 
              Fail24:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail24;
                if(true)
                  break Success17;
              }
              term = term19;
              IStrategoTerm m_9706 = null;
              IStrategoTerm n_9706 = null;
              IStrategoTerm p_9706 = null;
              m_9706 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail20;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail20;
              n_9706 = ((IStrategoList)term).tail();
              p_9706 = n_9706;
              term = report_failure_0_2.instance.invoke(context, p_9706, generated.const38, m_9706);
              if(term == null)
                break Fail20;
            }
          }
        }
      }
      s_9706 = term;
      q_9706 = generated.const39;
      t_9706 = s_9706;
      term = string_replace_0_2.instance.invoke(context, t_9706, q_9706, generated.const40);
      if(term == null)
        break Fail20;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail20;
      c_9707 = term;
      term = l_9706;
      IStrategoTerm term20 = term;
      Success18:
      { 
        Fail25:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail25;
          if(true)
            break Success18;
        }
        term = term20;
        IStrategoTerm term21 = term;
        Success19:
        { 
          Fail26:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail26;
            if(true)
              break Success19;
          }
          term = term21;
          IStrategoTerm term22 = term;
          Success20:
          { 
            Fail27:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail27;
              if(true)
                break Success20;
            }
            term = term22;
            IStrategoTerm term23 = term;
            Success21:
            { 
              Fail28:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail28;
                if(true)
                  break Success21;
              }
              term = term23;
              IStrategoTerm u_9706 = null;
              IStrategoTerm v_9706 = null;
              IStrategoTerm x_9706 = null;
              u_9706 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail20;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail20;
              v_9706 = ((IStrategoList)term).tail();
              x_9706 = v_9706;
              term = report_failure_0_2.instance.invoke(context, x_9706, generated.const38, u_9706);
              if(term == null)
                break Fail20;
            }
          }
        }
      }
      a_9707 = term;
      y_9706 = generated.const39;
      b_9707 = a_9707;
      term = string_replace_0_2.instance.invoke(context, b_9707, y_9706, generated.const40);
      if(term == null)
        break Fail20;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail20;
      term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(c_9707, checkListAnnos(termFactory, generated.constNil0)), termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0))})})});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}