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
    Fail95:
    { 
      IStrategoTerm term103 = term;
      Success68:
      { 
        Fail96:
        { 
          IStrategoTerm x_9718 = null;
          IStrategoTerm y_9718 = null;
          IStrategoTerm z_9718 = null;
          IStrategoTerm a_9719 = null;
          IStrategoTerm b_9719 = null;
          IStrategoTerm c_9719 = null;
          IStrategoTerm d_9719 = null;
          IStrategoTerm e_9719 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail96;
          IStrategoTerm arg134 = term.getSubterm(0);
          if(arg134.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg134).getConstructor())
            break Fail96;
          IStrategoTerm arg135 = arg134.getSubterm(0);
          if(arg135.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg135).isEmpty())
            break Fail96;
          IStrategoTerm arg136 = ((IStrategoList)arg135).head();
          if(arg136.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg136).getConstructor())
            break Fail96;
          IStrategoTerm arg138 = ((IStrategoList)arg135).tail();
          if(arg138.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg138).isEmpty())
            break Fail96;
          IStrategoTerm arg139 = ((IStrategoList)arg138).head();
          if(arg139.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg139).getConstructor())
            break Fail96;
          IStrategoTerm arg140 = arg139.getSubterm(1);
          if(arg140.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg140).getConstructor())
            break Fail96;
          b_9719 = arg140.getSubterm(0);
          y_9718 = arg139.getSubterm(2);
          x_9718 = arg139.getSubterm(3);
          IStrategoTerm arg141 = ((IStrategoList)arg138).tail();
          if(arg141.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg141).isEmpty())
            break Fail96;
          z_9718 = term.getSubterm(1);
          term = SRTS_one.instance.invoke(context, x_9718, lifted84.instance);
          if(term == null)
            break Fail96;
          term = generated.const72;
          a_9719 = generated.const72;
          e_9719 = term;
          term = termFactory.makeTuple(y_9718, z_9718);
          d_9719 = term;
          term = e_9719;
          IStrategoTerm term104 = term;
          Success69:
          { 
            Fail97:
            { 
              IStrategoTerm f_9719 = null;
              f_9719 = term;
              term = d_9719;
              if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                break Fail97;
              IStrategoTerm arg142 = term.getSubterm(0);
              if(arg142.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg142).getConstructor())
                break Fail97;
              IStrategoTerm arg143 = term.getSubterm(1);
              if(arg143.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg143).intValue())
                break Fail97;
              term = f_9719;
              { 
                term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoList)generated.constNil0)});
                c_9719 = term;
                if(true)
                  break Success69;
              }
            }
            term = term104;
            IStrategoTerm term105 = term;
            Success70:
            { 
              Fail98:
              { 
                IStrategoTerm g_9719 = null;
                g_9719 = term;
                term = d_9719;
                if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                  break Fail98;
                IStrategoTerm arg144 = term.getSubterm(0);
                if(arg144.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg144).getConstructor())
                  break Fail98;
                IStrategoTerm arg145 = term.getSubterm(1);
                if(arg145.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg145).intValue())
                  break Fail98;
                term = g_9719;
                { 
                  term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoList)generated.constNil0)})});
                  c_9719 = term;
                  if(true)
                    break Success70;
                }
              }
              term = term105;
              IStrategoTerm term106 = term;
              Success71:
              { 
                Fail99:
                { 
                  IStrategoTerm h_9719 = null;
                  h_9719 = term;
                  term = d_9719;
                  if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                    break Fail99;
                  IStrategoTerm arg146 = term.getSubterm(0);
                  if(arg146.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg146).getConstructor())
                    break Fail99;
                  IStrategoTerm arg147 = term.getSubterm(1);
                  if(arg147.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg147).intValue())
                    break Fail99;
                  term = h_9719;
                  { 
                    term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoList)generated.constNil0)})});
                    c_9719 = term;
                    if(true)
                      break Success71;
                  }
                }
                term = term106;
                IStrategoTerm term107 = term;
                Success72:
                { 
                  Fail100:
                  { 
                    IStrategoTerm i_9719 = null;
                    i_9719 = term;
                    term = d_9719;
                    if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                      break Fail100;
                    IStrategoTerm arg148 = term.getSubterm(0);
                    if(arg148.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg148).getConstructor())
                      break Fail100;
                    IStrategoTerm arg149 = term.getSubterm(1);
                    if(arg149.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg149).intValue())
                      break Fail100;
                    term = i_9719;
                    { 
                      term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoList)generated.constNil0)})});
                      c_9719 = term;
                      if(true)
                        break Success72;
                    }
                  }
                  term = term107;
                  IStrategoTerm term108 = term;
                  Success73:
                  { 
                    Fail101:
                    { 
                      IStrategoTerm j_9719 = null;
                      j_9719 = term;
                      term = d_9719;
                      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                        break Fail101;
                      IStrategoTerm arg150 = term.getSubterm(0);
                      if(arg150.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg150).getConstructor())
                        break Fail101;
                      IStrategoTerm arg151 = term.getSubterm(1);
                      if(arg151.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg151).intValue())
                        break Fail101;
                      term = j_9719;
                      { 
                        term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoList)generated.constNil0)});
                        c_9719 = term;
                        if(true)
                          break Success73;
                      }
                    }
                    term = term108;
                    IStrategoTerm term109 = term;
                    Success74:
                    { 
                      Fail102:
                      { 
                        IStrategoTerm k_9719 = null;
                        k_9719 = term;
                        term = d_9719;
                        if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                          break Fail102;
                        IStrategoTerm arg152 = term.getSubterm(0);
                        if(arg152.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg152).getConstructor())
                          break Fail102;
                        IStrategoTerm arg153 = term.getSubterm(1);
                        if(arg153.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg153).intValue())
                          break Fail102;
                        term = k_9719;
                        { 
                          term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoList)generated.constNil0)})});
                          c_9719 = term;
                          if(true)
                            break Success74;
                        }
                      }
                      term = term109;
                      Success75:
                      { 
                        Fail103:
                        { 
                          IStrategoTerm l_9719 = null;
                          l_9719 = term;
                          term = d_9719;
                          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                            break Fail103;
                          IStrategoTerm arg154 = term.getSubterm(0);
                          if(arg154.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg154).getConstructor())
                            break Fail103;
                          IStrategoTerm arg155 = term.getSubterm(1);
                          if(arg155.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg155).intValue())
                            break Fail103;
                          term = l_9719;
                          { 
                            term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoList)generated.constNil0)})});
                            c_9719 = term;
                            if(true)
                              break Success75;
                          }
                        }
                        term = d_9719;
                        if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
                          break Fail96;
                        IStrategoTerm arg156 = term.getSubterm(0);
                        if(arg156.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg156).getConstructor())
                          break Fail96;
                        IStrategoTerm arg157 = term.getSubterm(1);
                        if(arg157.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg157).intValue())
                          break Fail96;
                        term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{a_9719}), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9719}), (IStrategoList)generated.constNil0)})});
                        c_9719 = term;
                      }
                    }
                  }
                }
              }
            }
          }
          term = termFactory.makeTuple(c_9719, z_9718);
          if(true)
            break Success68;
        }
        term = term103;
        IStrategoTerm term111 = term;
        Success76:
        { 
          Fail104:
          { 
            IStrategoTerm s_9718 = null;
            if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
              break Fail104;
            IStrategoTerm arg158 = term.getSubterm(0);
            if(arg158.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg158).getConstructor())
              break Fail104;
            s_9718 = arg158.getSubterm(0);
            IStrategoTerm arg159 = term.getSubterm(1);
            if(arg159.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)arg159).intValue())
              break Fail104;
            term = template_line_to_sdf_sep_helper_0_0.instance.invoke(context, s_9718);
            if(term == null)
              break Fail104;
            term = termFactory.makeTuple(term, generated.const73);
            if(true)
              break Success76;
          }
          term = term111;
          IStrategoTerm p_9718 = null;
          IStrategoTerm q_9718 = null;
          IStrategoTerm r_9718 = null;
          if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
            break Fail95;
          IStrategoTerm arg160 = term.getSubterm(0);
          if(arg160.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg160).getConstructor())
            break Fail95;
          p_9718 = arg160.getSubterm(0);
          IStrategoTerm arg161 = term.getSubterm(1);
          if(arg161.getTermType() != IStrategoTerm.INT || 1 != ((IStrategoInt)arg161).intValue())
            break Fail95;
          r_9718 = term;
          term = template_line_to_sdf_sep_helper_0_0.instance.invoke(context, p_9718);
          if(term == null)
            break Fail95;
          q_9718 = term;
          term = r_9718;
          IStrategoList list3;
          list3 = checkListTail(q_9718);
          if(list3 == null)
            break Fail95;
          term = termFactory.makeTuple((IStrategoTerm)termFactory.makeListCons(generated.constlit0, list3), generated.const73);
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