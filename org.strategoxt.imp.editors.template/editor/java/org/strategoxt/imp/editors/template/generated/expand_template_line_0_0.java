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
    Fail202:
    { 
      IStrategoTerm term197 = term;
      Success145:
      { 
        Fail203:
        { 
          IStrategoTerm i_9730 = null;
          IStrategoTerm j_9730 = null;
          IStrategoTerm k_9730 = null;
          IStrategoTerm l_9730 = null;
          IStrategoTerm m_9730 = null;
          IStrategoTerm n_9730 = null;
          IStrategoTerm o_9730 = null;
          IStrategoTerm p_9730 = null;
          IStrategoTerm q_9730 = null;
          IStrategoTerm r_9730 = null;
          IStrategoTerm s_9730 = null;
          IStrategoTerm u_9730 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail203;
          IStrategoTerm arg257 = ((IStrategoList)term).head();
          j_9730 = arg257;
          if(arg257.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg257).getConstructor())
            break Fail203;
          IStrategoTerm arg258 = arg257.getSubterm(0);
          if(arg258.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg258).isEmpty())
            break Fail203;
          IStrategoTerm arg259 = ((IStrategoList)arg258).head();
          l_9730 = arg259;
          if(arg259.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg259).getConstructor())
            break Fail203;
          IStrategoTerm arg261 = ((IStrategoList)arg258).tail();
          if(arg261.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg261).isEmpty())
            break Fail203;
          IStrategoTerm arg262 = ((IStrategoList)arg261).head();
          if(arg262.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg262).getConstructor())
            break Fail203;
          m_9730 = arg262.getSubterm(0);
          IStrategoTerm arg263 = arg262.getSubterm(1);
          if(arg263.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg263).getConstructor())
            break Fail203;
          n_9730 = arg263.getSubterm(0);
          IStrategoTerm arg264 = arg262.getSubterm(2);
          o_9730 = arg264;
          u_9730 = arg264;
          q_9730 = arg262.getSubterm(3);
          IStrategoTerm arg265 = ((IStrategoList)arg261).tail();
          if(arg265.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg265).isEmpty())
            break Fail203;
          i_9730 = ((IStrategoList)term).tail();
          term = u_9730;
          IStrategoTerm term198 = term;
          Success146:
          { 
            Fail204:
            { 
              term = $None_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail204;
              if(true)
                break Success146;
            }
            term = $Plus_0_0.instance.invoke(context, term198);
            if(term == null)
              break Fail203;
          }
          term = n_9730;
          IStrategoTerm term199 = term;
          Success147:
          { 
            Fail205:
            { 
              term = $Expanded_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail205;
              { 
                if(true)
                  break Fail203;
                if(true)
                  break Success147;
              }
            }
            term = term199;
          }
          term = q_9730;
          IStrategoTerm term200 = term;
          Success148:
          { 
            Fail206:
            { 
              term = SRTS_one.instance.invoke(context, term, lifted151.instance);
              if(term == null)
                break Fail206;
              { 
                if(true)
                  break Fail203;
                if(true)
                  break Success148;
              }
            }
            term = term200;
          }
          term = n_9730;
          Success149:
          { 
            Fail207:
            { 
              term = get_template_lines_0_1.instance.invoke(context, term, l_9730);
              if(term == null)
                break Fail207;
              if(true)
                break Success149;
            }
            term = (IStrategoTerm)termFactory.makeListCons(j_9730, (IStrategoList)generated.constNil0);
          }
          r_9730 = term;
          Success150:
          { 
            Fail208:
            { 
              IStrategoTerm t_9730 = null;
              t_9730 = term;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail208;
              IStrategoTerm arg267 = ((IStrategoList)term).head();
              if(arg267.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg267).getConstructor())
                break Fail208;
              IStrategoTerm arg268 = arg267.getSubterm(0);
              if(arg268.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg268).isEmpty())
                break Fail208;
              if(((IStrategoList)arg268).head() != l_9730 && !l_9730.match(((IStrategoList)arg268).head()))
                break Fail208;
              IStrategoTerm arg269 = ((IStrategoList)arg268).tail();
              if(arg269.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg269).isEmpty())
                break Fail208;
              IStrategoTerm arg270 = ((IStrategoList)arg269).head();
              k_9730 = arg270;
              if(arg270.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg270).getConstructor())
                break Fail208;
              IStrategoTerm arg275 = ((IStrategoList)arg269).tail();
              if(arg275.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg275).isEmpty())
                break Fail208;
              IStrategoTerm arg276 = ((IStrategoList)term).tail();
              if(arg276.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg276).isEmpty())
                break Fail208;
              term = t_9730;
              { 
                term = template_element_to_string_0_0.instance.invoke(context, k_9730);
                if(term == null)
                  break Fail203;
                p_9730 = term;
                IStrategoList list12;
                list12 = checkListTail(q_9730);
                if(list12 == null)
                  break Fail203;
                term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(l_9730, termFactory.makeListCons(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{m_9730, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{n_9730}), o_9730, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{p_9730}), list12)}), (IStrategoList)generated.constNil0))}), (IStrategoList)generated.constNil0);
                s_9730 = term;
                if(true)
                  break Success150;
              }
            }
            term = r_9730;
            s_9730 = r_9730;
          }
          term = termFactory.makeTuple(s_9730, i_9730);
          term = make$Conc_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail203;
          if(true)
            break Success145;
        }
        term = term197;
        IStrategoTerm term204 = term;
        Success151:
        { 
          Fail209:
          { 
            IStrategoTerm c_9730 = null;
            IStrategoTerm d_9730 = null;
            IStrategoTerm e_9730 = null;
            IStrategoTerm f_9730 = null;
            IStrategoTerm g_9730 = null;
            IStrategoTerm h_9730 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail209;
            IStrategoTerm arg277 = ((IStrategoList)term).head();
            c_9730 = arg277;
            if(arg277.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg277).getConstructor())
              break Fail209;
            IStrategoTerm arg278 = arg277.getSubterm(0);
            if(arg278.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg278).isEmpty())
              break Fail209;
            IStrategoTerm arg279 = ((IStrategoList)arg278).head();
            if(arg279.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg279).getConstructor())
              break Fail209;
            IStrategoTerm arg281 = ((IStrategoList)arg278).tail();
            if(arg281.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg281).isEmpty())
              break Fail209;
            IStrategoTerm arg282 = ((IStrategoList)arg281).head();
            if(arg282.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg282).getConstructor())
              break Fail209;
            IStrategoTerm arg283 = arg282.getSubterm(1);
            if(arg283.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg283).getConstructor())
              break Fail209;
            e_9730 = arg283.getSubterm(0);
            g_9730 = arg282.getSubterm(2);
            f_9730 = arg282.getSubterm(3);
            IStrategoTerm arg284 = ((IStrategoList)arg281).tail();
            if(arg284.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg284).isEmpty())
              break Fail209;
            d_9730 = ((IStrategoList)term).tail();
            term = g_9730;
            IStrategoTerm term205 = term;
            Success152:
            { 
              Fail210:
              { 
                term = $None_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail210;
                if(true)
                  break Success152;
              }
              term = $Plus_0_0.instance.invoke(context, term205);
              if(term == null)
                break Fail209;
            }
            h_9730 = term;
            Success153:
            { 
              Fail211:
              { 
                term = $Expanded_0_0.instance.invoke(context, e_9730);
                if(term == null)
                  break Fail211;
                if(true)
                  break Success153;
              }
              term = SRTS_one.instance.invoke(context, f_9730, lifted152.instance);
              if(term == null)
                break Fail209;
            }
            term = h_9730;
            IStrategoList list13;
            list13 = checkListTail(d_9730);
            if(list13 == null)
              break Fail209;
            term = (IStrategoTerm)termFactory.makeListCons(c_9730, list13);
            if(true)
              break Success151;
          }
          term = term204;
          IStrategoTerm term207 = term;
          Success154:
          { 
            Fail212:
            { 
              IStrategoTerm w_9729 = null;
              IStrategoTerm x_9729 = null;
              IStrategoTerm y_9729 = null;
              IStrategoTerm z_9729 = null;
              IStrategoTerm a_9730 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail212;
              IStrategoTerm arg286 = ((IStrategoList)term).head();
              w_9729 = arg286;
              if(arg286.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg286).getConstructor())
                break Fail212;
              IStrategoTerm arg287 = arg286.getSubterm(0);
              if(arg287.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg287).isEmpty())
                break Fail212;
              IStrategoTerm arg288 = ((IStrategoList)arg287).head();
              if(arg288.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg288).getConstructor())
                break Fail212;
              IStrategoTerm arg290 = ((IStrategoList)arg287).tail();
              if(arg290.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg290).isEmpty())
                break Fail212;
              IStrategoTerm arg291 = ((IStrategoList)arg290).head();
              if(arg291.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg291).getConstructor())
                break Fail212;
              z_9729 = arg291.getSubterm(2);
              y_9729 = arg291.getSubterm(3);
              IStrategoTerm arg293 = ((IStrategoList)arg290).tail();
              if(arg293.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg293).isEmpty())
                break Fail212;
              x_9729 = ((IStrategoList)term).tail();
              term = z_9729;
              IStrategoTerm term208 = term;
              Success155:
              { 
                Fail213:
                { 
                  term = $Option_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail213;
                  if(true)
                    break Success155;
                }
                term = $Star_0_0.instance.invoke(context, term208);
                if(term == null)
                  break Fail212;
              }
              a_9730 = term;
              term = y_9729;
              IStrategoTerm term209 = term;
              Success156:
              { 
                Fail214:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted153.instance);
                  if(term == null)
                    break Fail214;
                  { 
                    if(true)
                      break Fail212;
                    if(true)
                      break Success156;
                  }
                }
                term = term209;
              }
              term = a_9730;
              IStrategoList list14;
              list14 = checkListTail(x_9729);
              if(list14 == null)
                break Fail212;
              term = (IStrategoTerm)termFactory.makeListCons(w_9729, list14);
              if(true)
                break Success154;
            }
            term = term207;
            IStrategoTerm term210 = term;
            Success157:
            { 
              Fail215:
              { 
                IStrategoTerm s_9729 = null;
                IStrategoTerm t_9729 = null;
                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                  break Fail215;
                IStrategoTerm arg294 = ((IStrategoList)term).head();
                if(arg294.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg294).getConstructor())
                  break Fail215;
                IStrategoTerm arg295 = arg294.getSubterm(0);
                if(arg295.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg295).isEmpty())
                  break Fail215;
                IStrategoTerm arg296 = ((IStrategoList)arg295).head();
                if(arg296.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg296).getConstructor())
                  break Fail215;
                IStrategoTerm arg298 = ((IStrategoList)arg295).tail();
                if(arg298.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg298).isEmpty())
                  break Fail215;
                IStrategoTerm arg299 = ((IStrategoList)arg298).head();
                if(arg299.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg299).getConstructor())
                  break Fail215;
                t_9729 = arg299.getSubterm(3);
                IStrategoTerm arg302 = ((IStrategoList)arg298).tail();
                if(arg302.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg302).isEmpty())
                  break Fail215;
                s_9729 = ((IStrategoList)term).tail();
                term = SRTS_one.instance.invoke(context, t_9729, lifted154.instance);
                if(term == null)
                  break Fail215;
                term = s_9729;
                if(true)
                  break Success157;
              }
              term = term210;
              IStrategoTerm term211 = term;
              Success158:
              { 
                Fail216:
                { 
                  IStrategoTerm j_9729 = null;
                  IStrategoTerm k_9729 = null;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail216;
                  IStrategoTerm arg303 = ((IStrategoList)term).head();
                  if(arg303.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg303).getConstructor())
                    break Fail216;
                  k_9729 = arg303.getSubterm(0);
                  j_9729 = ((IStrategoList)term).tail();
                  IStrategoTerm term212 = term;
                  Success159:
                  { 
                    Fail217:
                    { 
                      IStrategoTerm n_9729 = null;
                      term = k_9729;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail217;
                      IStrategoTerm arg304 = ((IStrategoList)term).head();
                      if(arg304.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg304).getConstructor())
                        break Fail217;
                      IStrategoTerm arg306 = ((IStrategoList)term).tail();
                      if(arg306.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg306).isEmpty())
                        break Fail217;
                      IStrategoTerm arg307 = ((IStrategoList)arg306).head();
                      if(arg307.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg307).getConstructor())
                        break Fail217;
                      n_9729 = arg307.getSubterm(2);
                      IStrategoTerm arg310 = ((IStrategoList)arg306).tail();
                      if(arg310.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg310).isEmpty())
                        break Fail217;
                      term = n_9729;
                      IStrategoTerm term213 = term;
                      Success160:
                      { 
                        Fail218:
                        { 
                          term = $None_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail218;
                          if(true)
                            break Success160;
                        }
                        term = $Plus_0_0.instance.invoke(context, term213);
                        if(term == null)
                          break Fail217;
                      }
                      { 
                        if(true)
                          break Fail216;
                        if(true)
                          break Success159;
                      }
                    }
                    term = term212;
                  }
                  term = k_9729;
                  Success161:
                  { 
                    Fail219:
                    { 
                      IStrategoTerm p_9729 = null;
                      IStrategoTerm q_9729 = null;
                      q_9729 = term;
                      term = listbu_1_0.instance.invoke(context, term, expand_template_element_0_0.instance);
                      if(term == null)
                        break Fail219;
                      IStrategoTerm term215 = term;
                      Success162:
                      { 
                        Fail220:
                        { 
                          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                            break Fail220;
                          { 
                            if(true)
                              break Fail219;
                            if(true)
                              break Success162;
                          }
                        }
                        term = term215;
                      }
                      p_9729 = term;
                      term = q_9729;
                      IStrategoList list15;
                      list15 = checkListTail(j_9729);
                      if(list15 == null)
                        break Fail219;
                      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{p_9729}), list15);
                      if(true)
                        break Success161;
                    }
                    term = j_9729;
                  }
                  if(true)
                    break Success158;
                }
                term = term211;
                if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                  break Fail202;
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