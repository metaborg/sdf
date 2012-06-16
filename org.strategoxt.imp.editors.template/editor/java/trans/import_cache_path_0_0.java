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

@SuppressWarnings("all") public class import_cache_path_0_0 extends Strategy 
{ 
  public static import_cache_path_0_0 instance = new import_cache_path_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("import_cache_path_0_0");
    Fail23:
    { 
      IStrategoTerm a_10710 = null;
      IStrategoTerm b_10710 = null;
      IStrategoTerm c_10710 = null;
      IStrategoTerm d_10710 = null;
      IStrategoTerm e_10710 = null;
      IStrategoTerm f_10711 = null;
      b_10710 = term;
      f_10711 = term;
      IStrategoTerm term19 = term;
      Success9:
      { 
        Fail24:
        { 
          IStrategoTerm j_10710 = null;
          IStrategoTerm l_10710 = null;
          IStrategoTerm m_10710 = null;
          IStrategoTerm m_10711 = null;
          IStrategoTerm o_10711 = null;
          IStrategoTerm p_10711 = null;
          IStrategoTerm q_10711 = null;
          IStrategoTerm s_10711 = null;
          IStrategoTerm t_10711 = null;
          IStrategoTerm u_10711 = null;
          IStrategoTerm w_10711 = null;
          IStrategoTerm x_10711 = null;
          IStrategoTerm a_10712 = null;
          IStrategoTerm r_10710 = null;
          IStrategoTerm t_10710 = null;
          IStrategoTerm u_10710 = null;
          IStrategoTerm z_10710 = null;
          IStrategoTerm b_10711 = null;
          IStrategoTerm c_10711 = null;
          term = project_path_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail24;
          a_10710 = term;
          term = a_10710;
          IStrategoTerm term20 = term;
          Success10:
          { 
            Fail25:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail25;
              if(true)
                break Success10;
            }
            term = term20;
            IStrategoTerm term21 = term;
            Success11:
            { 
              Fail26:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail26;
                if(true)
                  break Success11;
              }
              term = term21;
              IStrategoTerm term22 = term;
              Success12:
              { 
                Fail27:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail27;
                  if(true)
                    break Success12;
                }
                term = term22;
                IStrategoTerm term23 = term;
                Success13:
                { 
                  Fail28:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail28;
                    if(true)
                      break Success13;
                  }
                  term = term23;
                  IStrategoTerm f_10710 = null;
                  IStrategoTerm g_10710 = null;
                  IStrategoTerm i_10710 = null;
                  f_10710 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail24;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail24;
                  g_10710 = ((IStrategoList)term).tail();
                  i_10710 = g_10710;
                  term = report_failure_0_2.instance.invoke(context, i_10710, trans.const11, f_10710);
                  if(term == null)
                    break Fail24;
                }
              }
            }
          }
          l_10710 = term;
          j_10710 = trans.const8;
          m_10710 = l_10710;
          term = string_replace_0_2.instance.invoke(context, m_10710, j_10710, trans.const8);
          if(term == null)
            break Fail24;
          term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)trans.constCons1);
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail24;
          term = termFactory.annotateTerm(term, checkListAnnos(termFactory, trans.constNil0));
          IStrategoTerm term24 = term;
          Success14:
          { 
            Fail29:
            { 
              term = file_exists_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail29;
              if(true)
                break Success14;
            }
            term = mkdir_0_0.instance.invoke(context, term24);
            if(term == null)
              break Fail24;
          }
          c_10710 = term;
          o_10711 = b_10710;
          m_10711 = trans.const10;
          p_10711 = o_10711;
          term = string_replace_0_2.instance.invoke(context, p_10711, m_10711, trans.const13);
          if(term == null)
            break Fail24;
          s_10711 = term;
          q_10711 = trans.const14;
          t_10711 = s_10711;
          term = string_replace_0_2.instance.invoke(context, t_10711, q_10711, trans.const13);
          if(term == null)
            break Fail24;
          w_10711 = term;
          u_10711 = trans.const15;
          x_10711 = w_10711;
          term = string_replace_0_2.instance.invoke(context, x_10711, u_10711, trans.const13);
          if(term == null)
            break Fail24;
          d_10710 = term;
          term = c_10710;
          IStrategoTerm term25 = term;
          Success15:
          { 
            Fail30:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail30;
              if(true)
                break Success15;
            }
            term = term25;
            IStrategoTerm term26 = term;
            Success16:
            { 
              Fail31:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail31;
                if(true)
                  break Success16;
              }
              term = term26;
              IStrategoTerm term27 = term;
              Success17:
              { 
                Fail32:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail32;
                  if(true)
                    break Success17;
                }
                term = term27;
                IStrategoTerm term28 = term;
                Success18:
                { 
                  Fail33:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail33;
                    if(true)
                      break Success18;
                  }
                  term = term28;
                  IStrategoTerm n_10710 = null;
                  IStrategoTerm o_10710 = null;
                  IStrategoTerm q_10710 = null;
                  n_10710 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail24;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail24;
                  o_10710 = ((IStrategoList)term).tail();
                  q_10710 = o_10710;
                  term = report_failure_0_2.instance.invoke(context, q_10710, trans.const11, n_10710);
                  if(term == null)
                    break Fail24;
                }
              }
            }
          }
          t_10710 = term;
          r_10710 = trans.const8;
          u_10710 = t_10710;
          term = string_replace_0_2.instance.invoke(context, u_10710, r_10710, trans.const8);
          if(term == null)
            break Fail24;
          a_10712 = term;
          term = d_10710;
          IStrategoTerm term29 = term;
          Success19:
          { 
            Fail34:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail34;
              if(true)
                break Success19;
            }
            term = term29;
            IStrategoTerm term30 = term;
            Success20:
            { 
              Fail35:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail35;
                if(true)
                  break Success20;
              }
              term = term30;
              IStrategoTerm term31 = term;
              Success21:
              { 
                Fail36:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail36;
                  if(true)
                    break Success21;
                }
                term = term31;
                IStrategoTerm term32 = term;
                Success22:
                { 
                  Fail37:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail37;
                    if(true)
                      break Success22;
                  }
                  term = term32;
                  IStrategoTerm v_10710 = null;
                  IStrategoTerm w_10710 = null;
                  IStrategoTerm y_10710 = null;
                  v_10710 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail24;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail24;
                  w_10710 = ((IStrategoList)term).tail();
                  y_10710 = w_10710;
                  term = report_failure_0_2.instance.invoke(context, y_10710, trans.const11, v_10710);
                  if(term == null)
                    break Fail24;
                }
              }
            }
          }
          b_10711 = term;
          z_10710 = trans.const8;
          c_10711 = b_10711;
          term = string_replace_0_2.instance.invoke(context, c_10711, z_10710, trans.const16);
          if(term == null)
            break Fail24;
          term = (IStrategoTerm)termFactory.makeListCons(a_10712, termFactory.makeListCons(trans.const10, termFactory.makeListCons(term, (IStrategoList)trans.constCons2)));
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail24;
          term = termFactory.annotateTerm(term, checkListAnnos(termFactory, trans.constNil0));
          e_10710 = term;
          if(true)
            break Success9;
        }
        term = term19;
        IStrategoTerm d_10711 = null;
        IStrategoTerm e_10711 = null;
        IStrategoTerm f_10712 = null;
        d_10711 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail23;
        e_10711 = term;
        f_10712 = d_10711;
        term = report_with_failure_0_2.instance.invoke(context, f_10712, trans.const18, e_10711);
        if(term == null)
          break Fail23;
      }
      term = f_10711;
      if(e_10710 == null)
        break Fail23;
      term = e_10710;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}