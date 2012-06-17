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

@SuppressWarnings("all") public class expand_template_element_0_0 extends Strategy 
{ 
  public static expand_template_element_0_0 instance = new expand_template_element_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("expand_template_element_0_0");
    Fail1041:
    { 
      IStrategoTerm term472 = term;
      Success419:
      { 
        Fail1042:
        { 
          IStrategoTerm f_32770 = null;
          IStrategoTerm g_32770 = null;
          IStrategoTerm h_32770 = null;
          IStrategoTerm i_32770 = null;
          IStrategoTerm j_32770 = null;
          IStrategoTerm k_32770 = null;
          IStrategoTerm m_32770 = null;
          IStrategoTerm n_32770 = null;
          IStrategoTerm o_32770 = null;
          IStrategoTerm p_32770 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1042;
          IStrategoTerm arg464 = ((IStrategoList)term).head();
          j_32770 = arg464;
          if(arg464.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg464).getConstructor())
            break Fail1042;
          f_32770 = arg464.getSubterm(0);
          IStrategoTerm arg465 = arg464.getSubterm(1);
          if(arg465.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg465).getConstructor())
            break Fail1042;
          k_32770 = arg465.getSubterm(0);
          IStrategoTerm arg466 = arg464.getSubterm(2);
          g_32770 = arg466;
          n_32770 = arg466;
          i_32770 = arg464.getSubterm(3);
          h_32770 = ((IStrategoList)term).tail();
          term = n_32770;
          IStrategoTerm term473 = term;
          Success420:
          { 
            Fail1043:
            { 
              term = $None_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1043;
              if(true)
                break Success420;
            }
            term = $Plus_0_0.instance.invoke(context, term473);
            if(term == null)
              break Fail1042;
          }
          o_32770 = term;
          term = k_32770;
          IStrategoTerm term474 = term;
          Success421:
          { 
            Fail1044:
            { 
              term = $Expanded_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1044;
              { 
                if(true)
                  break Fail1042;
                if(true)
                  break Success421;
              }
            }
            term = term474;
          }
          term = i_32770;
          IStrategoTerm term475 = term;
          Success422:
          { 
            Fail1045:
            { 
              term = SRTS_one.instance.invoke(context, term, lifted355.instance);
              if(term == null)
                break Fail1045;
              { 
                if(true)
                  break Fail1042;
                if(true)
                  break Success422;
              }
            }
            term = term475;
          }
          p_32770 = o_32770;
          term = k_32770;
          Success423:
          { 
            Fail1046:
            { 
              term = get_template_elements_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1046;
              if(true)
                break Success423;
            }
            term = (IStrategoTerm)termFactory.makeListCons(j_32770, (IStrategoList)generated.constNil3);
          }
          term = map_1_0.instance.invoke(context, term, template_element_to_string_0_0.instance);
          if(term == null)
            break Fail1042;
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1042;
          m_32770 = term;
          term = p_32770;
          IStrategoList list20;
          IStrategoList list19;
          list19 = checkListTail(h_32770);
          if(list19 == null)
            break Fail1042;
          list20 = checkListTail(i_32770);
          if(list20 == null)
            break Fail1042;
          term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{f_32770, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{k_32770}), g_32770, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{m_32770}), list20)}), list19);
          if(true)
            break Success419;
        }
        term = term472;
        IStrategoTerm term478 = term;
        Success424:
        { 
          Fail1047:
          { 
            IStrategoTerm z_32769 = null;
            IStrategoTerm a_32770 = null;
            IStrategoTerm b_32770 = null;
            IStrategoTerm c_32770 = null;
            IStrategoTerm d_32770 = null;
            IStrategoTerm e_32770 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1047;
            IStrategoTerm arg468 = ((IStrategoList)term).head();
            z_32769 = arg468;
            if(arg468.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg468).getConstructor())
              break Fail1047;
            IStrategoTerm arg469 = arg468.getSubterm(1);
            if(arg469.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg469).getConstructor())
              break Fail1047;
            b_32770 = arg469.getSubterm(0);
            d_32770 = arg468.getSubterm(2);
            c_32770 = arg468.getSubterm(3);
            a_32770 = ((IStrategoList)term).tail();
            term = d_32770;
            IStrategoTerm term479 = term;
            Success425:
            { 
              Fail1048:
              { 
                term = $None_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1048;
                if(true)
                  break Success425;
              }
              term = $Plus_0_0.instance.invoke(context, term479);
              if(term == null)
                break Fail1047;
            }
            e_32770 = term;
            Success426:
            { 
              Fail1049:
              { 
                term = $Expanded_0_0.instance.invoke(context, b_32770);
                if(term == null)
                  break Fail1049;
                if(true)
                  break Success426;
              }
              term = SRTS_one.instance.invoke(context, c_32770, lifted357.instance);
              if(term == null)
                break Fail1047;
            }
            term = e_32770;
            IStrategoList list21;
            list21 = checkListTail(a_32770);
            if(list21 == null)
              break Fail1047;
            term = (IStrategoTerm)termFactory.makeListCons(z_32769, list21);
            if(true)
              break Success424;
          }
          term = term478;
          IStrategoTerm term481 = term;
          Success427:
          { 
            Fail1050:
            { 
              IStrategoTerm t_32769 = null;
              IStrategoTerm u_32769 = null;
              IStrategoTerm v_32769 = null;
              IStrategoTerm w_32769 = null;
              IStrategoTerm x_32769 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1050;
              IStrategoTerm arg471 = ((IStrategoList)term).head();
              t_32769 = arg471;
              if(arg471.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg471).getConstructor())
                break Fail1050;
              w_32769 = arg471.getSubterm(2);
              v_32769 = arg471.getSubterm(3);
              u_32769 = ((IStrategoList)term).tail();
              term = w_32769;
              IStrategoTerm term482 = term;
              Success428:
              { 
                Fail1051:
                { 
                  term = $Option_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail1051;
                  if(true)
                    break Success428;
                }
                term = $Star_0_0.instance.invoke(context, term482);
                if(term == null)
                  break Fail1050;
              }
              x_32769 = term;
              term = v_32769;
              IStrategoTerm term483 = term;
              Success429:
              { 
                Fail1052:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted358.instance);
                  if(term == null)
                    break Fail1052;
                  { 
                    if(true)
                      break Fail1050;
                    if(true)
                      break Success429;
                  }
                }
                term = term483;
              }
              term = x_32769;
              IStrategoList list22;
              list22 = checkListTail(u_32769);
              if(list22 == null)
                break Fail1050;
              term = (IStrategoTerm)termFactory.makeListCons(t_32769, list22);
              if(true)
                break Success427;
            }
            term = term481;
            IStrategoTerm term484 = term;
            Success430:
            { 
              Fail1053:
              { 
                IStrategoTerm p_32769 = null;
                IStrategoTerm q_32769 = null;
                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                  break Fail1053;
                IStrategoTerm arg473 = ((IStrategoList)term).head();
                if(arg473.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg473).getConstructor())
                  break Fail1053;
                q_32769 = arg473.getSubterm(3);
                p_32769 = ((IStrategoList)term).tail();
                term = SRTS_one.instance.invoke(context, q_32769, lifted359.instance);
                if(term == null)
                  break Fail1053;
                term = p_32769;
                if(true)
                  break Success430;
              }
              term = term484;
              IStrategoTerm term485 = term;
              Success431:
              { 
                Fail1054:
                { 
                  IStrategoTerm i_32769 = null;
                  IStrategoTerm j_32769 = null;
                  IStrategoTerm m_32769 = null;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1054;
                  j_32769 = ((IStrategoList)term).head();
                  i_32769 = ((IStrategoList)term).tail();
                  m_32769 = term;
                  IStrategoTerm term486 = term;
                  Success432:
                  { 
                    Fail1055:
                    { 
                      IStrategoTerm n_32769 = null;
                      term = j_32769;
                      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                        break Fail1055;
                      IStrategoTerm arg476 = term.getSubterm(1);
                      if(arg476.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg476).getConstructor())
                        break Fail1055;
                      n_32769 = term.getSubterm(2);
                      term = n_32769;
                      IStrategoTerm term487 = term;
                      Success433:
                      { 
                        Fail1056:
                        { 
                          term = $None_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail1056;
                          if(true)
                            break Success433;
                        }
                        term = $Plus_0_0.instance.invoke(context, term487);
                        if(term == null)
                          break Fail1055;
                      }
                      { 
                        if(true)
                          break Fail1054;
                        if(true)
                          break Success432;
                      }
                    }
                    term = term486;
                  }
                  term = m_32769;
                  IStrategoList list23;
                  list23 = checkListTail(i_32769);
                  if(list23 == null)
                    break Fail1054;
                  term = (IStrategoTerm)termFactory.makeListCons(j_32769, list23);
                  if(true)
                    break Success431;
                }
                term = term485;
                if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                  break Fail1041;
              }
            }
          }
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