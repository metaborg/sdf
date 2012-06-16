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

@SuppressWarnings("all") final class lifted6 extends Strategy 
{ 
  TermReference r_10708;

  TermReference s_10708;

  Strategy q_10709;

  Strategy o_10709;

  Strategy p_10709;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail256:
    { 
      IStrategoTerm term8 = term;
      Success73:
      { 
        Fail257:
        { 
          IStrategoTerm u_10708 = null;
          u_10708 = term;
          term = q_10709.invoke(context, term);
          if(term == null)
            break Fail257;
          term = u_10708;
          { 
            IStrategoTerm term9 = term;
            Success74:
            { 
              Fail258:
              { 
                IStrategoTerm u_10709 = null;
                IStrategoTerm w_10709 = null;
                IStrategoTerm z_10708 = null;
                IStrategoTerm b_10709 = null;
                IStrategoTerm c_10709 = null;
                IStrategoTerm j_10709 = null;
                IStrategoTerm l_10709 = null;
                IStrategoTerm m_10709 = null;
                w_10709 = term;
                if(r_10708.value == null)
                  break Fail258;
                term = r_10708.value;
                IStrategoTerm term10 = term;
                Success75:
                { 
                  Fail259:
                  { 
                    term = concat_strings_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail259;
                    if(true)
                      break Success75;
                  }
                  term = term10;
                  IStrategoTerm term11 = term;
                  Success76:
                  { 
                    Fail260:
                    { 
                      term = is_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail260;
                      if(true)
                        break Success76;
                    }
                    term = term11;
                    IStrategoTerm term12 = term;
                    Success77:
                    { 
                      Fail261:
                      { 
                        term = int_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail261;
                        if(true)
                          break Success77;
                      }
                      term = term12;
                      IStrategoTerm term13 = term;
                      Success78:
                      { 
                        Fail262:
                        { 
                          term = real_to_string_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail262;
                          if(true)
                            break Success78;
                        }
                        term = term13;
                        IStrategoTerm v_10708 = null;
                        IStrategoTerm w_10708 = null;
                        IStrategoTerm y_10708 = null;
                        v_10708 = term;
                        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                        if(term == null)
                          break Fail258;
                        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                          break Fail258;
                        w_10708 = ((IStrategoList)term).tail();
                        y_10708 = w_10708;
                        term = report_failure_0_2.instance.invoke(context, y_10708, trans.const7, v_10708);
                        if(term == null)
                          break Fail258;
                      }
                    }
                  }
                }
                b_10709 = term;
                z_10708 = trans.const8;
                c_10709 = b_10709;
                term = string_replace_0_2.instance.invoke(context, c_10709, z_10708, trans.const8);
                if(term == null)
                  break Fail258;
                u_10709 = term;
                term = w_10709;
                IStrategoTerm term14 = term;
                Success79:
                { 
                  Fail263:
                  { 
                    term = concat_strings_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail263;
                    if(true)
                      break Success79;
                  }
                  term = term14;
                  IStrategoTerm term15 = term;
                  Success80:
                  { 
                    Fail264:
                    { 
                      term = is_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail264;
                      if(true)
                        break Success80;
                    }
                    term = term15;
                    IStrategoTerm term16 = term;
                    Success81:
                    { 
                      Fail265:
                      { 
                        term = int_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail265;
                        if(true)
                          break Success81;
                      }
                      term = term16;
                      IStrategoTerm term17 = term;
                      Success82:
                      { 
                        Fail266:
                        { 
                          term = real_to_string_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail266;
                          if(true)
                            break Success82;
                        }
                        term = term17;
                        IStrategoTerm f_10709 = null;
                        IStrategoTerm g_10709 = null;
                        IStrategoTerm i_10709 = null;
                        f_10709 = term;
                        term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                        if(term == null)
                          break Fail258;
                        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                          break Fail258;
                        g_10709 = ((IStrategoList)term).tail();
                        i_10709 = g_10709;
                        term = report_failure_0_2.instance.invoke(context, i_10709, trans.const7, f_10709);
                        if(term == null)
                          break Fail258;
                      }
                    }
                  }
                }
                l_10709 = term;
                j_10709 = trans.const8;
                m_10709 = l_10709;
                term = string_replace_0_2.instance.invoke(context, m_10709, j_10709, trans.const9);
                if(term == null)
                  break Fail258;
                term = (IStrategoTerm)termFactory.makeListCons(u_10709, termFactory.makeListCons(trans.const10, termFactory.makeListCons(term, (IStrategoList)trans.constNil0)));
                term = concat_strings_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail258;
                term = termFactory.annotateTerm(term, checkListAnnos(termFactory, trans.constNil0));
                term = open_import_3_0.instance.invoke(context, term, _Id.instance, o_10709, p_10709);
                if(term == null)
                  break Fail258;
                if(true)
                  break Success74;
              }
              term = term9;
              lifted8 lifted80 = new lifted8();
              lifted80.s_10708 = s_10708;
              term = try_1_0.instance.invoke(context, term, lifted80);
              if(term == null)
                break Fail256;
            }
            if(true)
              break Success73;
          }
        }
        term = term8;
      }
      if(true)
        return term;
    }
    return null;
  }
}