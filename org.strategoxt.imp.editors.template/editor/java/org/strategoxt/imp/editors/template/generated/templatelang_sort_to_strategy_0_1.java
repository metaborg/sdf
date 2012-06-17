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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm s_32744)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_sort_to_strategy_0_1");
    Fail839:
    { 
      IStrategoTerm t_32744 = null;
      IStrategoTerm k_32745 = null;
      IStrategoTerm y_32744 = null;
      IStrategoTerm a_32745 = null;
      IStrategoTerm b_32745 = null;
      IStrategoTerm g_32745 = null;
      IStrategoTerm i_32745 = null;
      IStrategoTerm j_32745 = null;
      t_32744 = term;
      term = s_32744;
      IStrategoTerm term271 = term;
      Success269:
      { 
        Fail840:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail840;
          if(true)
            break Success269;
        }
        term = term271;
        IStrategoTerm term272 = term;
        Success270:
        { 
          Fail841:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail841;
            if(true)
              break Success270;
          }
          term = term272;
          IStrategoTerm term273 = term;
          Success271:
          { 
            Fail842:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail842;
              if(true)
                break Success271;
            }
            term = term273;
            IStrategoTerm term274 = term;
            Success272:
            { 
              Fail843:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail843;
                if(true)
                  break Success272;
              }
              term = term274;
              IStrategoTerm u_32744 = null;
              IStrategoTerm v_32744 = null;
              IStrategoTerm x_32744 = null;
              u_32744 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail839;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail839;
              v_32744 = ((IStrategoList)term).tail();
              x_32744 = v_32744;
              term = report_failure_0_2.instance.invoke(context, x_32744, generated.const159, u_32744);
              if(term == null)
                break Fail839;
            }
          }
        }
      }
      a_32745 = term;
      y_32744 = generated.const160;
      b_32745 = a_32745;
      term = string_replace_0_2.instance.invoke(context, b_32745, y_32744, generated.const161);
      if(term == null)
        break Fail839;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail839;
      k_32745 = term;
      term = t_32744;
      IStrategoTerm term275 = term;
      Success273:
      { 
        Fail844:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail844;
          if(true)
            break Success273;
        }
        term = term275;
        IStrategoTerm term276 = term;
        Success274:
        { 
          Fail845:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail845;
            if(true)
              break Success274;
          }
          term = term276;
          IStrategoTerm term277 = term;
          Success275:
          { 
            Fail846:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail846;
              if(true)
                break Success275;
            }
            term = term277;
            IStrategoTerm term278 = term;
            Success276:
            { 
              Fail847:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail847;
                if(true)
                  break Success276;
              }
              term = term278;
              IStrategoTerm c_32745 = null;
              IStrategoTerm d_32745 = null;
              IStrategoTerm f_32745 = null;
              c_32745 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail839;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail839;
              d_32745 = ((IStrategoList)term).tail();
              f_32745 = d_32745;
              term = report_failure_0_2.instance.invoke(context, f_32745, generated.const159, c_32745);
              if(term == null)
                break Fail839;
            }
          }
        }
      }
      i_32745 = term;
      g_32745 = generated.const160;
      j_32745 = i_32745;
      term = string_replace_0_2.instance.invoke(context, j_32745, g_32745, generated.const161);
      if(term == null)
        break Fail839;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail839;
      term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(k_32745, checkListAnnos(termFactory, generated.constNil3)), termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3))})})});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}