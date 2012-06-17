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

@SuppressWarnings("all") public class expand_template_line_0_0 extends Strategy 
{ 
  public static expand_template_line_0_0 instance = new expand_template_line_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("expand_template_line_0_0");
    Fail1022:
    { 
      IStrategoTerm term453 = term;
      Success401:
      { 
        Fail1023:
        { 
          IStrategoTerm r_32768 = null;
          IStrategoTerm s_32768 = null;
          IStrategoTerm t_32768 = null;
          IStrategoTerm u_32768 = null;
          IStrategoTerm v_32768 = null;
          IStrategoTerm w_32768 = null;
          IStrategoTerm x_32768 = null;
          IStrategoTerm y_32768 = null;
          IStrategoTerm z_32768 = null;
          IStrategoTerm a_32769 = null;
          IStrategoTerm b_32769 = null;
          IStrategoTerm d_32769 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1023;
          IStrategoTerm arg410 = ((IStrategoList)term).head();
          s_32768 = arg410;
          if(arg410.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg410).getConstructor())
            break Fail1023;
          IStrategoTerm arg411 = arg410.getSubterm(0);
          if(arg411.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg411).isEmpty())
            break Fail1023;
          IStrategoTerm arg412 = ((IStrategoList)arg411).head();
          u_32768 = arg412;
          if(arg412.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg412).getConstructor())
            break Fail1023;
          IStrategoTerm arg414 = ((IStrategoList)arg411).tail();
          if(arg414.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg414).isEmpty())
            break Fail1023;
          IStrategoTerm arg415 = ((IStrategoList)arg414).head();
          if(arg415.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg415).getConstructor())
            break Fail1023;
          v_32768 = arg415.getSubterm(0);
          IStrategoTerm arg416 = arg415.getSubterm(1);
          if(arg416.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg416).getConstructor())
            break Fail1023;
          w_32768 = arg416.getSubterm(0);
          IStrategoTerm arg417 = arg415.getSubterm(2);
          x_32768 = arg417;
          d_32769 = arg417;
          z_32768 = arg415.getSubterm(3);
          IStrategoTerm arg418 = ((IStrategoList)arg414).tail();
          if(arg418.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg418).isEmpty())
            break Fail1023;
          r_32768 = ((IStrategoList)term).tail();
          term = d_32769;
          IStrategoTerm term454 = term;
          Success402:
          { 
            Fail1024:
            { 
              term = $None_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1024;
              if(true)
                break Success402;
            }
            term = $Plus_0_0.instance.invoke(context, term454);
            if(term == null)
              break Fail1023;
          }
          term = w_32768;
          IStrategoTerm term455 = term;
          Success403:
          { 
            Fail1025:
            { 
              term = $Expanded_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1025;
              { 
                if(true)
                  break Fail1023;
                if(true)
                  break Success403;
              }
            }
            term = term455;
          }
          term = z_32768;
          IStrategoTerm term456 = term;
          Success404:
          { 
            Fail1026:
            { 
              term = SRTS_one.instance.invoke(context, term, lifted350.instance);
              if(term == null)
                break Fail1026;
              { 
                if(true)
                  break Fail1023;
                if(true)
                  break Success404;
              }
            }
            term = term456;
          }
          term = w_32768;
          Success405:
          { 
            Fail1027:
            { 
              term = get_template_lines_0_1.instance.invoke(context, term, u_32768);
              if(term == null)
                break Fail1027;
              if(true)
                break Success405;
            }
            term = (IStrategoTerm)termFactory.makeListCons(s_32768, (IStrategoList)generated.constNil3);
          }
          a_32769 = term;
          Success406:
          { 
            Fail1028:
            { 
              IStrategoTerm c_32769 = null;
              c_32769 = term;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1028;
              IStrategoTerm arg420 = ((IStrategoList)term).head();
              if(arg420.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg420).getConstructor())
                break Fail1028;
              IStrategoTerm arg421 = arg420.getSubterm(0);
              if(arg421.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg421).isEmpty())
                break Fail1028;
              if(((IStrategoList)arg421).head() != u_32768 && !u_32768.match(((IStrategoList)arg421).head()))
                break Fail1028;
              IStrategoTerm arg422 = ((IStrategoList)arg421).tail();
              if(arg422.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg422).isEmpty())
                break Fail1028;
              IStrategoTerm arg423 = ((IStrategoList)arg422).head();
              t_32768 = arg423;
              if(arg423.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg423).getConstructor())
                break Fail1028;
              IStrategoTerm arg428 = ((IStrategoList)arg422).tail();
              if(arg428.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg428).isEmpty())
                break Fail1028;
              IStrategoTerm arg429 = ((IStrategoList)term).tail();
              if(arg429.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg429).isEmpty())
                break Fail1028;
              term = c_32769;
              { 
                term = template_element_to_string_0_0.instance.invoke(context, t_32768);
                if(term == null)
                  break Fail1023;
                y_32768 = term;
                IStrategoList list15;
                list15 = checkListTail(z_32768);
                if(list15 == null)
                  break Fail1023;
                term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(u_32768, termFactory.makeListCons(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{v_32768, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{w_32768}), x_32768, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{y_32768}), list15)}), (IStrategoList)generated.constNil3))}), (IStrategoList)generated.constNil3);
                b_32769 = term;
                if(true)
                  break Success406;
              }
            }
            term = a_32769;
            b_32769 = a_32769;
          }
          term = termFactory.makeTuple(b_32769, r_32768);
          term = make$Conc_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1023;
          if(true)
            break Success401;
        }
        term = term453;
        IStrategoTerm term460 = term;
        Success407:
        { 
          Fail1029:
          { 
            IStrategoTerm l_32768 = null;
            IStrategoTerm m_32768 = null;
            IStrategoTerm n_32768 = null;
            IStrategoTerm o_32768 = null;
            IStrategoTerm p_32768 = null;
            IStrategoTerm q_32768 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1029;
            IStrategoTerm arg430 = ((IStrategoList)term).head();
            l_32768 = arg430;
            if(arg430.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg430).getConstructor())
              break Fail1029;
            IStrategoTerm arg431 = arg430.getSubterm(0);
            if(arg431.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg431).isEmpty())
              break Fail1029;
            IStrategoTerm arg432 = ((IStrategoList)arg431).head();
            if(arg432.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg432).getConstructor())
              break Fail1029;
            IStrategoTerm arg434 = ((IStrategoList)arg431).tail();
            if(arg434.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg434).isEmpty())
              break Fail1029;
            IStrategoTerm arg435 = ((IStrategoList)arg434).head();
            if(arg435.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg435).getConstructor())
              break Fail1029;
            IStrategoTerm arg436 = arg435.getSubterm(1);
            if(arg436.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg436).getConstructor())
              break Fail1029;
            n_32768 = arg436.getSubterm(0);
            p_32768 = arg435.getSubterm(2);
            o_32768 = arg435.getSubterm(3);
            IStrategoTerm arg437 = ((IStrategoList)arg434).tail();
            if(arg437.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg437).isEmpty())
              break Fail1029;
            m_32768 = ((IStrategoList)term).tail();
            term = p_32768;
            IStrategoTerm term461 = term;
            Success408:
            { 
              Fail1030:
              { 
                term = $None_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1030;
                if(true)
                  break Success408;
              }
              term = $Plus_0_0.instance.invoke(context, term461);
              if(term == null)
                break Fail1029;
            }
            q_32768 = term;
            Success409:
            { 
              Fail1031:
              { 
                term = $Expanded_0_0.instance.invoke(context, n_32768);
                if(term == null)
                  break Fail1031;
                if(true)
                  break Success409;
              }
              term = SRTS_one.instance.invoke(context, o_32768, lifted351.instance);
              if(term == null)
                break Fail1029;
            }
            term = q_32768;
            IStrategoList list16;
            list16 = checkListTail(m_32768);
            if(list16 == null)
              break Fail1029;
            term = (IStrategoTerm)termFactory.makeListCons(l_32768, list16);
            if(true)
              break Success407;
          }
          term = term460;
          IStrategoTerm term463 = term;
          Success410:
          { 
            Fail1032:
            { 
              IStrategoTerm f_32768 = null;
              IStrategoTerm g_32768 = null;
              IStrategoTerm h_32768 = null;
              IStrategoTerm i_32768 = null;
              IStrategoTerm j_32768 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1032;
              IStrategoTerm arg439 = ((IStrategoList)term).head();
              f_32768 = arg439;
              if(arg439.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg439).getConstructor())
                break Fail1032;
              IStrategoTerm arg440 = arg439.getSubterm(0);
              if(arg440.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg440).isEmpty())
                break Fail1032;
              IStrategoTerm arg441 = ((IStrategoList)arg440).head();
              if(arg441.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg441).getConstructor())
                break Fail1032;
              IStrategoTerm arg443 = ((IStrategoList)arg440).tail();
              if(arg443.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg443).isEmpty())
                break Fail1032;
              IStrategoTerm arg444 = ((IStrategoList)arg443).head();
              if(arg444.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg444).getConstructor())
                break Fail1032;
              i_32768 = arg444.getSubterm(2);
              h_32768 = arg444.getSubterm(3);
              IStrategoTerm arg446 = ((IStrategoList)arg443).tail();
              if(arg446.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg446).isEmpty())
                break Fail1032;
              g_32768 = ((IStrategoList)term).tail();
              term = i_32768;
              IStrategoTerm term464 = term;
              Success411:
              { 
                Fail1033:
                { 
                  term = $Option_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail1033;
                  if(true)
                    break Success411;
                }
                term = $Star_0_0.instance.invoke(context, term464);
                if(term == null)
                  break Fail1032;
              }
              j_32768 = term;
              term = h_32768;
              IStrategoTerm term465 = term;
              Success412:
              { 
                Fail1034:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted352.instance);
                  if(term == null)
                    break Fail1034;
                  { 
                    if(true)
                      break Fail1032;
                    if(true)
                      break Success412;
                  }
                }
                term = term465;
              }
              term = j_32768;
              IStrategoList list17;
              list17 = checkListTail(g_32768);
              if(list17 == null)
                break Fail1032;
              term = (IStrategoTerm)termFactory.makeListCons(f_32768, list17);
              if(true)
                break Success410;
            }
            term = term463;
            IStrategoTerm term466 = term;
            Success413:
            { 
              Fail1035:
              { 
                IStrategoTerm b_32768 = null;
                IStrategoTerm c_32768 = null;
                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                  break Fail1035;
                IStrategoTerm arg447 = ((IStrategoList)term).head();
                if(arg447.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg447).getConstructor())
                  break Fail1035;
                IStrategoTerm arg448 = arg447.getSubterm(0);
                if(arg448.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg448).isEmpty())
                  break Fail1035;
                IStrategoTerm arg449 = ((IStrategoList)arg448).head();
                if(arg449.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg449).getConstructor())
                  break Fail1035;
                IStrategoTerm arg451 = ((IStrategoList)arg448).tail();
                if(arg451.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg451).isEmpty())
                  break Fail1035;
                IStrategoTerm arg452 = ((IStrategoList)arg451).head();
                if(arg452.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg452).getConstructor())
                  break Fail1035;
                c_32768 = arg452.getSubterm(3);
                IStrategoTerm arg455 = ((IStrategoList)arg451).tail();
                if(arg455.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg455).isEmpty())
                  break Fail1035;
                b_32768 = ((IStrategoList)term).tail();
                term = SRTS_one.instance.invoke(context, c_32768, lifted353.instance);
                if(term == null)
                  break Fail1035;
                term = b_32768;
                if(true)
                  break Success413;
              }
              term = term466;
              IStrategoTerm term467 = term;
              Success414:
              { 
                Fail1036:
                { 
                  IStrategoTerm s_32767 = null;
                  IStrategoTerm t_32767 = null;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1036;
                  IStrategoTerm arg456 = ((IStrategoList)term).head();
                  if(arg456.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg456).getConstructor())
                    break Fail1036;
                  t_32767 = arg456.getSubterm(0);
                  s_32767 = ((IStrategoList)term).tail();
                  IStrategoTerm term468 = term;
                  Success415:
                  { 
                    Fail1037:
                    { 
                      IStrategoTerm w_32767 = null;
                      term = t_32767;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail1037;
                      IStrategoTerm arg457 = ((IStrategoList)term).head();
                      if(arg457.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg457).getConstructor())
                        break Fail1037;
                      IStrategoTerm arg459 = ((IStrategoList)term).tail();
                      if(arg459.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg459).isEmpty())
                        break Fail1037;
                      IStrategoTerm arg460 = ((IStrategoList)arg459).head();
                      if(arg460.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg460).getConstructor())
                        break Fail1037;
                      w_32767 = arg460.getSubterm(2);
                      IStrategoTerm arg463 = ((IStrategoList)arg459).tail();
                      if(arg463.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg463).isEmpty())
                        break Fail1037;
                      term = w_32767;
                      IStrategoTerm term469 = term;
                      Success416:
                      { 
                        Fail1038:
                        { 
                          term = $None_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail1038;
                          if(true)
                            break Success416;
                        }
                        term = $Plus_0_0.instance.invoke(context, term469);
                        if(term == null)
                          break Fail1037;
                      }
                      { 
                        if(true)
                          break Fail1036;
                        if(true)
                          break Success415;
                      }
                    }
                    term = term468;
                  }
                  term = t_32767;
                  Success417:
                  { 
                    Fail1039:
                    { 
                      IStrategoTerm y_32767 = null;
                      IStrategoTerm z_32767 = null;
                      z_32767 = term;
                      term = listbu_1_0.instance.invoke(context, term, expand_template_element_0_0.instance);
                      if(term == null)
                        break Fail1039;
                      IStrategoTerm term471 = term;
                      Success418:
                      { 
                        Fail1040:
                        { 
                          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                            break Fail1040;
                          { 
                            if(true)
                              break Fail1039;
                            if(true)
                              break Success418;
                          }
                        }
                        term = term471;
                      }
                      y_32767 = term;
                      term = z_32767;
                      IStrategoList list18;
                      list18 = checkListTail(s_32767);
                      if(list18 == null)
                        break Fail1039;
                      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{y_32767}), list18);
                      if(true)
                        break Success417;
                    }
                    term = s_32767;
                  }
                  if(true)
                    break Success414;
                }
                term = term467;
                if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                  break Fail1022;
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