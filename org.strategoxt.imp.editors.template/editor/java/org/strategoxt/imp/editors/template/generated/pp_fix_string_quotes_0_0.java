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

@SuppressWarnings("all") public class pp_fix_string_quotes_0_0 extends Strategy 
{ 
  public static pp_fix_string_quotes_0_0 instance = new pp_fix_string_quotes_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("pp_fix_string_quotes_0_0");
    Fail1177:
    { 
      IStrategoTerm term617 = term;
      IStrategoConstructor cons48 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success511:
      { 
        if(cons48 == Main._consString_1)
        { 
          Fail1178:
          { 
            IStrategoTerm j_32784 = null;
            IStrategoTerm k_32784 = null;
            IStrategoTerm n_32784 = null;
            IStrategoTerm q_32784 = null;
            j_32784 = term.getSubterm(0);
            n_32784 = term;
            term = j_32784;
            IStrategoTerm term618 = term;
            Success512:
            { 
              Fail1179:
              { 
                IStrategoTerm p_32784 = null;
                p_32784 = term;
                term = string_starts_with_0_1.instance.invoke(context, p_32784, generated.const196);
                if(term == null)
                  break Fail1179;
                { 
                  if(true)
                    break Fail1178;
                  if(true)
                    break Success512;
                }
              }
              term = term618;
            }
            term = n_32784;
            q_32784 = n_32784;
            IStrategoTerm term619 = term;
            Success513:
            { 
              Fail1180:
              { 
                term = termFactory.makeTuple(generated.const196, j_32784, generated.const196);
                term = conc_strings_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1180;
                k_32784 = term;
                if(true)
                  break Success513;
              }
              term = term619;
              IStrategoTerm l_32784 = null;
              IStrategoTerm m_32784 = null;
              IStrategoTerm s_32784 = null;
              l_32784 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1178;
              m_32784 = term;
              s_32784 = l_32784;
              term = report_with_failure_0_2.instance.invoke(context, s_32784, generated.const249, m_32784);
              if(term == null)
                break Fail1178;
            }
            term = q_32784;
            if(k_32784 == null)
              break Fail1178;
            term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{k_32784});
            if(true)
              break Success511;
          }
          term = term617;
        }
        if(cons48 == Main._consPlaceholder_1)
        { 
          IStrategoTerm x_32783 = null;
          IStrategoTerm y_32783 = null;
          IStrategoTerm b_32784 = null;
          IStrategoTerm e_32784 = null;
          x_32783 = term.getSubterm(0);
          b_32784 = term;
          term = x_32783;
          IStrategoTerm term620 = term;
          Success514:
          { 
            Fail1181:
            { 
              IStrategoTerm d_32784 = null;
              d_32784 = term;
              term = string_starts_with_0_1.instance.invoke(context, d_32784, generated.const210);
              if(term == null)
                break Fail1181;
              { 
                if(true)
                  break Fail1177;
                if(true)
                  break Success514;
              }
            }
            term = term620;
          }
          term = b_32784;
          e_32784 = b_32784;
          IStrategoTerm term621 = term;
          Success515:
          { 
            Fail1182:
            { 
              term = termFactory.makeTuple(generated.const210, x_32783, generated.const250);
              term = conc_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1182;
              y_32783 = term;
              if(true)
                break Success515;
            }
            term = term621;
            IStrategoTerm z_32783 = null;
            IStrategoTerm a_32784 = null;
            IStrategoTerm g_32784 = null;
            z_32783 = term;
            term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
            if(term == null)
              break Fail1177;
            a_32784 = term;
            g_32784 = z_32783;
            term = report_with_failure_0_2.instance.invoke(context, g_32784, generated.const249, a_32784);
            if(term == null)
              break Fail1177;
          }
          term = e_32784;
          if(y_32783 == null)
            break Fail1177;
          term = termFactory.makeAppl(Main._consPlaceholder_1, new IStrategoTerm[]{y_32783});
        }
        else
        { 
          break Fail1177;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}