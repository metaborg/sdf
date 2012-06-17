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

@SuppressWarnings("all") final class lifted536 extends Strategy 
{ 
  TermReference e_32994;

  TermReference f_32994;

  Strategy d_32995;

  Strategy b_32995;

  Strategy c_32995;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail2104:
    { 
      IStrategoTerm term674 = term;
      Success744:
      { 
        Fail2105:
        { 
          IStrategoTerm h_32994 = null;
          h_32994 = term;
          term = d_32995.invoke(context, term);
          if(term == null)
            break Fail2105;
          term = h_32994;
          { 
            IStrategoTerm term675 = term;
            Success745:
            { 
              Fail2106:
              { 
                IStrategoTerm h_32995 = null;
                IStrategoTerm j_32995 = null;
                IStrategoTerm m_32994 = null;
                IStrategoTerm o_32994 = null;
                IStrategoTerm p_32994 = null;
                IStrategoTerm w_32994 = null;
                IStrategoTerm y_32994 = null;
                IStrategoTerm z_32994 = null;
                j_32995 = term;
                if(e_32994.value == null)
                  break Fail2106;
                term = e_32994.value;
                IStrategoTerm term676 = term;
                Success746:
                { 
                  Fail2107:
                  { 
                    term = concat_strings_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail2107;
                    if(true)
                      break Success746;
                  }
                  term = term676;
                  IStrategoTerm term677 = term;
                  Success747:
                  { 
                    Fail2108:
                    { 
                      term = is_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail2108;
                      if(true)
                        break Success747;
                    }
                    term = term677;
                    IStrategoTerm term678 = term;
                    Success748:
                    { 
                      Fail2109:
                      { 
                        term = int_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail2109;
                        if(true)
                          break Success748;
                      }
                      term = term678;
                      IStrategoTerm term679 = term;
                      Success749:
                      { 
                        Fail2110:
                        { 
                          term = real_to_string_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail2110;
                          if(true)
                            break Success749;
                        }
                        term = term679;
                        IStrategoTerm i_32994 = null;
                        IStrategoTerm j_32994 = null;
                        IStrategoTerm l_32994 = null;
                        i_32994 = term;
                        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                        if(term == null)
                          break Fail2106;
                        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                          break Fail2106;
                        j_32994 = ((IStrategoList)term).tail();
                        l_32994 = j_32994;
                        term = report_failure_0_2.instance.invoke(context, l_32994, trans.const277, i_32994);
                        if(term == null)
                          break Fail2106;
                      }
                    }
                  }
                }
                o_32994 = term;
                m_32994 = trans.const278;
                p_32994 = o_32994;
                term = string_replace_0_2.instance.invoke(context, p_32994, m_32994, trans.const278);
                if(term == null)
                  break Fail2106;
                h_32995 = term;
                term = j_32995;
                IStrategoTerm term680 = term;
                Success750:
                { 
                  Fail2111:
                  { 
                    term = concat_strings_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail2111;
                    if(true)
                      break Success750;
                  }
                  term = term680;
                  IStrategoTerm term681 = term;
                  Success751:
                  { 
                    Fail2112:
                    { 
                      term = is_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail2112;
                      if(true)
                        break Success751;
                    }
                    term = term681;
                    IStrategoTerm term682 = term;
                    Success752:
                    { 
                      Fail2113:
                      { 
                        term = int_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail2113;
                        if(true)
                          break Success752;
                      }
                      term = term682;
                      IStrategoTerm term683 = term;
                      Success753:
                      { 
                        Fail2114:
                        { 
                          term = real_to_string_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail2114;
                          if(true)
                            break Success753;
                        }
                        term = term683;
                        IStrategoTerm s_32994 = null;
                        IStrategoTerm t_32994 = null;
                        IStrategoTerm v_32994 = null;
                        s_32994 = term;
                        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                        if(term == null)
                          break Fail2106;
                        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                          break Fail2106;
                        t_32994 = ((IStrategoList)term).tail();
                        v_32994 = t_32994;
                        term = report_failure_0_2.instance.invoke(context, v_32994, trans.const277, s_32994);
                        if(term == null)
                          break Fail2106;
                      }
                    }
                  }
                }
                y_32994 = term;
                w_32994 = trans.const278;
                z_32994 = y_32994;
                term = string_replace_0_2.instance.invoke(context, z_32994, w_32994, trans.const279);
                if(term == null)
                  break Fail2106;
                term = (IStrategoTerm)termFactory.makeListCons(h_32995, termFactory.makeListCons(trans.const280, termFactory.makeListCons(term, (IStrategoList)trans.constNil4)));
                term = concat_strings_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail2106;
                term = termFactory.annotateTerm(term, checkListAnnos(termFactory, trans.constNil4));
                term = open_import_3_0.instance.invoke(context, term, _Id.instance, b_32995, c_32995);
                if(term == null)
                  break Fail2106;
                if(true)
                  break Success745;
              }
              term = term675;
              lifted538 lifted5380 = new lifted538();
              lifted5380.f_32994 = f_32994;
              term = try_1_0.instance.invoke(context, term, lifted5380);
              if(term == null)
                break Fail2104;
            }
            if(true)
              break Success744;
          }
        }
        term = term674;
      }
      if(true)
        return term;
    }
    return null;
  }
}