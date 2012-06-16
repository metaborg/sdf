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
    Fail221:
    { 
      IStrategoTerm term216 = term;
      Success163:
      { 
        Fail222:
        { 
          IStrategoTerm w_9731 = null;
          IStrategoTerm x_9731 = null;
          IStrategoTerm y_9731 = null;
          IStrategoTerm z_9731 = null;
          IStrategoTerm a_9732 = null;
          IStrategoTerm b_9732 = null;
          IStrategoTerm d_9732 = null;
          IStrategoTerm e_9732 = null;
          IStrategoTerm f_9732 = null;
          IStrategoTerm g_9732 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail222;
          IStrategoTerm arg311 = ((IStrategoList)term).head();
          a_9732 = arg311;
          if(arg311.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg311).getConstructor())
            break Fail222;
          w_9731 = arg311.getSubterm(0);
          IStrategoTerm arg312 = arg311.getSubterm(1);
          if(arg312.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg312).getConstructor())
            break Fail222;
          b_9732 = arg312.getSubterm(0);
          IStrategoTerm arg313 = arg311.getSubterm(2);
          x_9731 = arg313;
          e_9732 = arg313;
          z_9731 = arg311.getSubterm(3);
          y_9731 = ((IStrategoList)term).tail();
          term = e_9732;
          IStrategoTerm term217 = term;
          Success164:
          { 
            Fail223:
            { 
              term = $None_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail223;
              if(true)
                break Success164;
            }
            term = $Plus_0_0.instance.invoke(context, term217);
            if(term == null)
              break Fail222;
          }
          f_9732 = term;
          term = b_9732;
          IStrategoTerm term218 = term;
          Success165:
          { 
            Fail224:
            { 
              term = $Expanded_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail224;
              { 
                if(true)
                  break Fail222;
                if(true)
                  break Success165;
              }
            }
            term = term218;
          }
          term = z_9731;
          IStrategoTerm term219 = term;
          Success166:
          { 
            Fail225:
            { 
              term = SRTS_one.instance.invoke(context, term, lifted156.instance);
              if(term == null)
                break Fail225;
              { 
                if(true)
                  break Fail222;
                if(true)
                  break Success166;
              }
            }
            term = term219;
          }
          g_9732 = f_9732;
          term = b_9732;
          Success167:
          { 
            Fail226:
            { 
              term = get_template_elements_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail226;
              if(true)
                break Success167;
            }
            term = (IStrategoTerm)termFactory.makeListCons(a_9732, (IStrategoList)generated.constNil0);
          }
          term = map_1_0.instance.invoke(context, term, template_element_to_string_0_0.instance);
          if(term == null)
            break Fail222;
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail222;
          d_9732 = term;
          term = g_9732;
          IStrategoList list17;
          IStrategoList list16;
          list16 = checkListTail(y_9731);
          if(list16 == null)
            break Fail222;
          list17 = checkListTail(z_9731);
          if(list17 == null)
            break Fail222;
          term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{w_9731, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9732}), x_9731, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{d_9732}), list17)}), list16);
          if(true)
            break Success163;
        }
        term = term216;
        IStrategoTerm term222 = term;
        Success168:
        { 
          Fail227:
          { 
            IStrategoTerm q_9731 = null;
            IStrategoTerm r_9731 = null;
            IStrategoTerm s_9731 = null;
            IStrategoTerm t_9731 = null;
            IStrategoTerm u_9731 = null;
            IStrategoTerm v_9731 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail227;
            IStrategoTerm arg315 = ((IStrategoList)term).head();
            q_9731 = arg315;
            if(arg315.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg315).getConstructor())
              break Fail227;
            IStrategoTerm arg316 = arg315.getSubterm(1);
            if(arg316.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg316).getConstructor())
              break Fail227;
            s_9731 = arg316.getSubterm(0);
            u_9731 = arg315.getSubterm(2);
            t_9731 = arg315.getSubterm(3);
            r_9731 = ((IStrategoList)term).tail();
            term = u_9731;
            IStrategoTerm term223 = term;
            Success169:
            { 
              Fail228:
              { 
                term = $None_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail228;
                if(true)
                  break Success169;
              }
              term = $Plus_0_0.instance.invoke(context, term223);
              if(term == null)
                break Fail227;
            }
            v_9731 = term;
            Success170:
            { 
              Fail229:
              { 
                term = $Expanded_0_0.instance.invoke(context, s_9731);
                if(term == null)
                  break Fail229;
                if(true)
                  break Success170;
              }
              term = SRTS_one.instance.invoke(context, t_9731, lifted158.instance);
              if(term == null)
                break Fail227;
            }
            term = v_9731;
            IStrategoList list18;
            list18 = checkListTail(r_9731);
            if(list18 == null)
              break Fail227;
            term = (IStrategoTerm)termFactory.makeListCons(q_9731, list18);
            if(true)
              break Success168;
          }
          term = term222;
          IStrategoTerm term225 = term;
          Success171:
          { 
            Fail230:
            { 
              IStrategoTerm k_9731 = null;
              IStrategoTerm l_9731 = null;
              IStrategoTerm m_9731 = null;
              IStrategoTerm n_9731 = null;
              IStrategoTerm o_9731 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail230;
              IStrategoTerm arg318 = ((IStrategoList)term).head();
              k_9731 = arg318;
              if(arg318.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg318).getConstructor())
                break Fail230;
              n_9731 = arg318.getSubterm(2);
              m_9731 = arg318.getSubterm(3);
              l_9731 = ((IStrategoList)term).tail();
              term = n_9731;
              IStrategoTerm term226 = term;
              Success172:
              { 
                Fail231:
                { 
                  term = $Option_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail231;
                  if(true)
                    break Success172;
                }
                term = $Star_0_0.instance.invoke(context, term226);
                if(term == null)
                  break Fail230;
              }
              o_9731 = term;
              term = m_9731;
              IStrategoTerm term227 = term;
              Success173:
              { 
                Fail232:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted159.instance);
                  if(term == null)
                    break Fail232;
                  { 
                    if(true)
                      break Fail230;
                    if(true)
                      break Success173;
                  }
                }
                term = term227;
              }
              term = o_9731;
              IStrategoList list19;
              list19 = checkListTail(l_9731);
              if(list19 == null)
                break Fail230;
              term = (IStrategoTerm)termFactory.makeListCons(k_9731, list19);
              if(true)
                break Success171;
            }
            term = term225;
            IStrategoTerm term228 = term;
            Success174:
            { 
              Fail233:
              { 
                IStrategoTerm g_9731 = null;
                IStrategoTerm h_9731 = null;
                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                  break Fail233;
                IStrategoTerm arg320 = ((IStrategoList)term).head();
                if(arg320.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg320).getConstructor())
                  break Fail233;
                h_9731 = arg320.getSubterm(3);
                g_9731 = ((IStrategoList)term).tail();
                term = SRTS_one.instance.invoke(context, h_9731, lifted160.instance);
                if(term == null)
                  break Fail233;
                term = g_9731;
                if(true)
                  break Success174;
              }
              term = term228;
              IStrategoTerm term229 = term;
              Success175:
              { 
                Fail234:
                { 
                  IStrategoTerm z_9730 = null;
                  IStrategoTerm a_9731 = null;
                  IStrategoTerm d_9731 = null;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail234;
                  a_9731 = ((IStrategoList)term).head();
                  z_9730 = ((IStrategoList)term).tail();
                  d_9731 = term;
                  IStrategoTerm term230 = term;
                  Success176:
                  { 
                    Fail235:
                    { 
                      IStrategoTerm e_9731 = null;
                      term = a_9731;
                      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                        break Fail235;
                      IStrategoTerm arg323 = term.getSubterm(1);
                      if(arg323.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg323).getConstructor())
                        break Fail235;
                      e_9731 = term.getSubterm(2);
                      term = e_9731;
                      IStrategoTerm term231 = term;
                      Success177:
                      { 
                        Fail236:
                        { 
                          term = $None_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail236;
                          if(true)
                            break Success177;
                        }
                        term = $Plus_0_0.instance.invoke(context, term231);
                        if(term == null)
                          break Fail235;
                      }
                      { 
                        if(true)
                          break Fail234;
                        if(true)
                          break Success176;
                      }
                    }
                    term = term230;
                  }
                  term = d_9731;
                  IStrategoList list20;
                  list20 = checkListTail(z_9730);
                  if(list20 == null)
                    break Fail234;
                  term = (IStrategoTerm)termFactory.makeListCons(a_9731, list20);
                  if(true)
                    break Success175;
                }
                term = term229;
                if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                  break Fail221;
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