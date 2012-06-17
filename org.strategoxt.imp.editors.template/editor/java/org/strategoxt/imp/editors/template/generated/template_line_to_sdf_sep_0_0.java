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

@SuppressWarnings("all") public class template_line_to_sdf_sep_0_0 extends Strategy 
{ 
  public static template_line_to_sdf_sep_0_0 instance = new template_line_to_sdf_sep_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_line_to_sdf_sep_0_0");
    Fail914:
    { 
      IStrategoTerm term358 = term;
      Success323:
      { 
        Fail915:
        { 
          IStrategoTerm f_32757 = null;
          IStrategoTerm g_32757 = null;
          IStrategoTerm h_32757 = null;
          IStrategoTerm i_32757 = null;
          IStrategoTerm j_32757 = null;
          IStrategoTerm k_32757 = null;
          IStrategoTerm l_32757 = null;
          IStrategoTerm m_32757 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail915;
          IStrategoTerm arg282 = term.getSubterm(0);
          if(arg282.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg282).getConstructor())
            break Fail915;
          IStrategoTerm arg283 = arg282.getSubterm(0);
          if(arg283.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg283).isEmpty())
            break Fail915;
          IStrategoTerm arg284 = ((IStrategoList)arg283).head();
          if(arg284.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg284).getConstructor())
            break Fail915;
          IStrategoTerm arg286 = ((IStrategoList)arg283).tail();
          if(arg286.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg286).isEmpty())
            break Fail915;
          IStrategoTerm arg287 = ((IStrategoList)arg286).head();
          if(arg287.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg287).getConstructor())
            break Fail915;
          IStrategoTerm arg288 = arg287.getSubterm(1);
          if(arg288.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg288).getConstructor())
            break Fail915;
          j_32757 = arg288.getSubterm(0);
          g_32757 = arg287.getSubterm(2);
          f_32757 = arg287.getSubterm(3);
          IStrategoTerm arg289 = ((IStrategoList)arg286).tail();
          if(arg289.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg289).isEmpty())
            break Fail915;
          h_32757 = term.getSubterm(1);
          term = SRTS_one.instance.invoke(context, f_32757, lifted283.instance);
          if(term == null)
            break Fail915;
          term = generated.const193;
          i_32757 = generated.const193;
          m_32757 = term;
          term = termFactory.makeTuple(g_32757, h_32757);
          l_32757 = term;
          term = m_32757;
          IStrategoTerm term359 = term;
          Success324:
          { 
            Fail916:
            { 
              IStrategoTerm n_32757 = null;
              n_32757 = term;
              term = l_32757;
              if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                break Fail916;
              IStrategoTerm arg290 = term.getSubterm(0);
              if(arg290.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg290).getConstructor())
                break Fail916;
              IStrategoTerm arg291 = term.getSubterm(1);
              if(arg291.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg291).intValue())
                break Fail916;
              term = n_32757;
              { 
                term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoList)generated.constNil3)});
                k_32757 = term;
                if(true)
                  break Success324;
              }
            }
            term = term359;
            IStrategoTerm term360 = term;
            Success325:
            { 
              Fail917:
              { 
                IStrategoTerm o_32757 = null;
                o_32757 = term;
                term = l_32757;
                if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                  break Fail917;
                IStrategoTerm arg292 = term.getSubterm(0);
                if(arg292.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg292).getConstructor())
                  break Fail917;
                IStrategoTerm arg293 = term.getSubterm(1);
                if(arg293.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg293).intValue())
                  break Fail917;
                term = o_32757;
                { 
                  term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoList)generated.constNil3)})});
                  k_32757 = term;
                  if(true)
                    break Success325;
                }
              }
              term = term360;
              IStrategoTerm term361 = term;
              Success326:
              { 
                Fail918:
                { 
                  IStrategoTerm p_32757 = null;
                  p_32757 = term;
                  term = l_32757;
                  if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                    break Fail918;
                  IStrategoTerm arg294 = term.getSubterm(0);
                  if(arg294.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg294).getConstructor())
                    break Fail918;
                  IStrategoTerm arg295 = term.getSubterm(1);
                  if(arg295.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg295).intValue())
                    break Fail918;
                  term = p_32757;
                  { 
                    term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoList)generated.constNil3)})});
                    k_32757 = term;
                    if(true)
                      break Success326;
                  }
                }
                term = term361;
                IStrategoTerm term362 = term;
                Success327:
                { 
                  Fail919:
                  { 
                    IStrategoTerm q_32757 = null;
                    q_32757 = term;
                    term = l_32757;
                    if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                      break Fail919;
                    IStrategoTerm arg296 = term.getSubterm(0);
                    if(arg296.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg296).getConstructor())
                      break Fail919;
                    IStrategoTerm arg297 = term.getSubterm(1);
                    if(arg297.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg297).intValue())
                      break Fail919;
                    term = q_32757;
                    { 
                      term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoList)generated.constNil3)})});
                      k_32757 = term;
                      if(true)
                        break Success327;
                    }
                  }
                  term = term362;
                  IStrategoTerm term363 = term;
                  Success328:
                  { 
                    Fail920:
                    { 
                      IStrategoTerm r_32757 = null;
                      r_32757 = term;
                      term = l_32757;
                      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                        break Fail920;
                      IStrategoTerm arg298 = term.getSubterm(0);
                      if(arg298.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg298).getConstructor())
                        break Fail920;
                      IStrategoTerm arg299 = term.getSubterm(1);
                      if(arg299.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg299).intValue())
                        break Fail920;
                      term = r_32757;
                      { 
                        term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoList)generated.constNil3)});
                        k_32757 = term;
                        if(true)
                          break Success328;
                      }
                    }
                    term = term363;
                    IStrategoTerm term364 = term;
                    Success329:
                    { 
                      Fail921:
                      { 
                        IStrategoTerm s_32757 = null;
                        s_32757 = term;
                        term = l_32757;
                        if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                          break Fail921;
                        IStrategoTerm arg300 = term.getSubterm(0);
                        if(arg300.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg300).getConstructor())
                          break Fail921;
                        IStrategoTerm arg301 = term.getSubterm(1);
                        if(arg301.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg301).intValue())
                          break Fail921;
                        term = s_32757;
                        { 
                          term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoList)generated.constNil3)})});
                          k_32757 = term;
                          if(true)
                            break Success329;
                        }
                      }
                      term = term364;
                      Success330:
                      { 
                        Fail922:
                        { 
                          IStrategoTerm t_32757 = null;
                          t_32757 = term;
                          term = l_32757;
                          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                            break Fail922;
                          IStrategoTerm arg302 = term.getSubterm(0);
                          if(arg302.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg302).getConstructor())
                            break Fail922;
                          IStrategoTerm arg303 = term.getSubterm(1);
                          if(arg303.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg303).intValue())
                            break Fail922;
                          term = t_32757;
                          { 
                            term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoList)generated.constNil3)})});
                            k_32757 = term;
                            if(true)
                              break Success330;
                          }
                        }
                        term = l_32757;
                        if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                          break Fail915;
                        IStrategoTerm arg304 = term.getSubterm(0);
                        if(arg304.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg304).getConstructor())
                          break Fail915;
                        IStrategoTerm arg305 = term.getSubterm(1);
                        if(arg305.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg305).intValue())
                          break Fail915;
                        term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{i_32757}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32757}), (IStrategoList)generated.constNil3)})});
                        k_32757 = term;
                      }
                    }
                  }
                }
              }
            }
          }
          term = termFactory.makeTuple(k_32757, h_32757);
          if(true)
            break Success323;
        }
        term = term358;
        IStrategoTerm term366 = term;
        Success331:
        { 
          Fail923:
          { 
            IStrategoTerm a_32757 = null;
            if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
              break Fail923;
            IStrategoTerm arg306 = term.getSubterm(0);
            if(arg306.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg306).getConstructor())
              break Fail923;
            a_32757 = arg306.getSubterm(0);
            IStrategoTerm arg307 = term.getSubterm(1);
            if(arg307.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg307).intValue())
              break Fail923;
            term = template_line_to_sdf_sep_helper_0_0.instance.invoke(context, a_32757);
            if(term == null)
              break Fail923;
            term = termFactory.makeTuple(term, generated.const194);
            if(true)
              break Success331;
          }
          term = term366;
          IStrategoTerm x_32756 = null;
          IStrategoTerm y_32756 = null;
          IStrategoTerm z_32756 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail914;
          IStrategoTerm arg308 = term.getSubterm(0);
          if(arg308.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg308).getConstructor())
            break Fail914;
          x_32756 = arg308.getSubterm(0);
          IStrategoTerm arg309 = term.getSubterm(1);
          if(arg309.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg309).intValue())
            break Fail914;
          z_32756 = term;
          term = template_line_to_sdf_sep_helper_0_0.instance.invoke(context, x_32756);
          if(term == null)
            break Fail914;
          y_32756 = term;
          term = z_32756;
          IStrategoList list6;
          list6 = checkListTail(y_32756);
          if(list6 == null)
            break Fail914;
          term = termFactory.makeTuple((IStrategoTerm)termFactory.makeListCons(generated.constlit0, list6), generated.const194);
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