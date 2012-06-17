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
    Fail1864:
    { 
      IStrategoTerm n_32995 = null;
      IStrategoTerm o_32995 = null;
      IStrategoTerm p_32995 = null;
      IStrategoTerm q_32995 = null;
      IStrategoTerm r_32995 = null;
      IStrategoTerm s_32996 = null;
      o_32995 = term;
      s_32996 = term;
      IStrategoTerm term685 = term;
      Success675:
      { 
        Fail1865:
        { 
          IStrategoTerm w_32995 = null;
          IStrategoTerm y_32995 = null;
          IStrategoTerm z_32995 = null;
          IStrategoTerm z_32996 = null;
          IStrategoTerm b_32997 = null;
          IStrategoTerm c_32997 = null;
          IStrategoTerm d_32997 = null;
          IStrategoTerm f_32997 = null;
          IStrategoTerm g_32997 = null;
          IStrategoTerm h_32997 = null;
          IStrategoTerm j_32997 = null;
          IStrategoTerm k_32997 = null;
          IStrategoTerm n_32997 = null;
          IStrategoTerm e_32996 = null;
          IStrategoTerm g_32996 = null;
          IStrategoTerm h_32996 = null;
          IStrategoTerm m_32996 = null;
          IStrategoTerm o_32996 = null;
          IStrategoTerm p_32996 = null;
          term = project_path_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1865;
          n_32995 = term;
          term = n_32995;
          IStrategoTerm term686 = term;
          Success676:
          { 
            Fail1866:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1866;
              if(true)
                break Success676;
            }
            term = term686;
            IStrategoTerm term687 = term;
            Success677:
            { 
              Fail1867:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1867;
                if(true)
                  break Success677;
              }
              term = term687;
              IStrategoTerm term688 = term;
              Success678:
              { 
                Fail1868:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail1868;
                  if(true)
                    break Success678;
                }
                term = term688;
                IStrategoTerm term689 = term;
                Success679:
                { 
                  Fail1869:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail1869;
                    if(true)
                      break Success679;
                  }
                  term = term689;
                  IStrategoTerm s_32995 = null;
                  IStrategoTerm t_32995 = null;
                  IStrategoTerm v_32995 = null;
                  s_32995 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail1865;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1865;
                  t_32995 = ((IStrategoList)term).tail();
                  v_32995 = t_32995;
                  term = report_failure_0_2.instance.invoke(context, v_32995, trans.const281, s_32995);
                  if(term == null)
                    break Fail1865;
                }
              }
            }
          }
          y_32995 = term;
          w_32995 = trans.const278;
          z_32995 = y_32995;
          term = string_replace_0_2.instance.invoke(context, z_32995, w_32995, trans.const278);
          if(term == null)
            break Fail1865;
          term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)trans.constCons85);
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1865;
          term = termFactory.annotateTerm(term, checkListAnnos(termFactory, trans.constNil4));
          IStrategoTerm term690 = term;
          Success680:
          { 
            Fail1870:
            { 
              term = file_exists_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1870;
              if(true)
                break Success680;
            }
            term = mkdir_0_0.instance.invoke(context, term690);
            if(term == null)
              break Fail1865;
          }
          p_32995 = term;
          b_32997 = o_32995;
          z_32996 = trans.const280;
          c_32997 = b_32997;
          term = string_replace_0_2.instance.invoke(context, c_32997, z_32996, trans.const283);
          if(term == null)
            break Fail1865;
          f_32997 = term;
          d_32997 = trans.const284;
          g_32997 = f_32997;
          term = string_replace_0_2.instance.invoke(context, g_32997, d_32997, trans.const283);
          if(term == null)
            break Fail1865;
          j_32997 = term;
          h_32997 = trans.const285;
          k_32997 = j_32997;
          term = string_replace_0_2.instance.invoke(context, k_32997, h_32997, trans.const283);
          if(term == null)
            break Fail1865;
          q_32995 = term;
          term = p_32995;
          IStrategoTerm term691 = term;
          Success681:
          { 
            Fail1871:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1871;
              if(true)
                break Success681;
            }
            term = term691;
            IStrategoTerm term692 = term;
            Success682:
            { 
              Fail1872:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1872;
                if(true)
                  break Success682;
              }
              term = term692;
              IStrategoTerm term693 = term;
              Success683:
              { 
                Fail1873:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail1873;
                  if(true)
                    break Success683;
                }
                term = term693;
                IStrategoTerm term694 = term;
                Success684:
                { 
                  Fail1874:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail1874;
                    if(true)
                      break Success684;
                  }
                  term = term694;
                  IStrategoTerm a_32996 = null;
                  IStrategoTerm b_32996 = null;
                  IStrategoTerm d_32996 = null;
                  a_32996 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail1865;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1865;
                  b_32996 = ((IStrategoList)term).tail();
                  d_32996 = b_32996;
                  term = report_failure_0_2.instance.invoke(context, d_32996, trans.const281, a_32996);
                  if(term == null)
                    break Fail1865;
                }
              }
            }
          }
          g_32996 = term;
          e_32996 = trans.const278;
          h_32996 = g_32996;
          term = string_replace_0_2.instance.invoke(context, h_32996, e_32996, trans.const278);
          if(term == null)
            break Fail1865;
          n_32997 = term;
          term = q_32995;
          IStrategoTerm term695 = term;
          Success685:
          { 
            Fail1875:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1875;
              if(true)
                break Success685;
            }
            term = term695;
            IStrategoTerm term696 = term;
            Success686:
            { 
              Fail1876:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1876;
                if(true)
                  break Success686;
              }
              term = term696;
              IStrategoTerm term697 = term;
              Success687:
              { 
                Fail1877:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail1877;
                  if(true)
                    break Success687;
                }
                term = term697;
                IStrategoTerm term698 = term;
                Success688:
                { 
                  Fail1878:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail1878;
                    if(true)
                      break Success688;
                  }
                  term = term698;
                  IStrategoTerm i_32996 = null;
                  IStrategoTerm j_32996 = null;
                  IStrategoTerm l_32996 = null;
                  i_32996 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail1865;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1865;
                  j_32996 = ((IStrategoList)term).tail();
                  l_32996 = j_32996;
                  term = report_failure_0_2.instance.invoke(context, l_32996, trans.const281, i_32996);
                  if(term == null)
                    break Fail1865;
                }
              }
            }
          }
          o_32996 = term;
          m_32996 = trans.const278;
          p_32996 = o_32996;
          term = string_replace_0_2.instance.invoke(context, p_32996, m_32996, trans.const286);
          if(term == null)
            break Fail1865;
          term = (IStrategoTerm)termFactory.makeListCons(n_32997, termFactory.makeListCons(trans.const280, termFactory.makeListCons(term, (IStrategoList)trans.constCons86)));
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1865;
          term = termFactory.annotateTerm(term, checkListAnnos(termFactory, trans.constNil4));
          r_32995 = term;
          if(true)
            break Success675;
        }
        term = term685;
        IStrategoTerm q_32996 = null;
        IStrategoTerm r_32996 = null;
        IStrategoTerm s_32997 = null;
        q_32996 = term;
        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
        if(term == null)
          break Fail1864;
        r_32996 = term;
        s_32997 = q_32996;
        term = report_with_failure_0_2.instance.invoke(context, s_32997, trans.const288, r_32996);
        if(term == null)
          break Fail1864;
      }
      term = s_32996;
      if(r_32995 == null)
        break Fail1864;
      term = r_32995;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}