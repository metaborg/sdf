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

@SuppressWarnings("all") public class template_element_to_sdf_0_0 extends Strategy 
{ 
  public static template_element_to_sdf_0_0 instance = new template_element_to_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_element_to_sdf_0_0");
    Fail114:
    { 
      IStrategoTerm term119 = term;
      IStrategoConstructor cons8 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success83:
      { 
        if(cons8 == Main._consString_1)
        { 
          Fail115:
          { 
            IStrategoTerm i_9721 = null;
            i_9721 = term.getSubterm(0);
            term = string_to_sdf_0_0.instance.invoke(context, i_9721);
            if(term == null)
              break Fail115;
            if(true)
              break Success83;
          }
          term = term119;
        }
        Success84:
        { 
          if(cons8 == Main._consPlaceholder_4)
          { 
            Fail116:
            { 
              IStrategoTerm h_9721 = null;
              IStrategoTerm arg181 = term.getSubterm(1);
              if(arg181.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg181).getConstructor())
                break Fail116;
              h_9721 = arg181.getSubterm(0);
              IStrategoTerm arg182 = term.getSubterm(2);
              if(arg182.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg182).getConstructor())
                break Fail116;
              term = termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{h_9721});
              if(true)
                break Success84;
            }
            term = term119;
          }
          Success85:
          { 
            if(cons8 == Main._consPlaceholder_4)
            { 
              Fail117:
              { 
                IStrategoTerm f_9721 = null;
                IStrategoTerm arg184 = term.getSubterm(1);
                if(arg184.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg184).getConstructor())
                  break Fail117;
                f_9721 = arg184.getSubterm(0);
                IStrategoTerm arg185 = term.getSubterm(2);
                if(arg185.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg185).getConstructor())
                  break Fail117;
                term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{f_9721})});
                if(true)
                  break Success85;
              }
              term = term119;
            }
            Success86:
            { 
              if(cons8 == Main._consPlaceholder_4)
              { 
                Fail118:
                { 
                  IStrategoTerm b_9721 = null;
                  IStrategoTerm c_9721 = null;
                  IStrategoTerm arg187 = term.getSubterm(1);
                  if(arg187.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg187).getConstructor())
                    break Fail118;
                  b_9721 = arg187.getSubterm(0);
                  IStrategoTerm arg188 = term.getSubterm(2);
                  if(arg188.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg188).getConstructor())
                    break Fail118;
                  c_9721 = term.getSubterm(3);
                  term = c_9721;
                  IStrategoTerm term123 = term;
                  Success87:
                  { 
                    Fail119:
                    { 
                      term = SRTS_one.instance.invoke(context, term, lifted98.instance);
                      if(term == null)
                        break Fail119;
                      { 
                        if(true)
                          break Fail118;
                        if(true)
                          break Success87;
                      }
                    }
                    term = term123;
                  }
                  term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_9721})});
                  if(true)
                    break Success86;
                }
                term = term119;
              }
              IStrategoTerm term125 = term;
              Success88:
              { 
                Fail120:
                { 
                  IStrategoTerm v_9720 = null;
                  TermReference w_9720 = new TermReference();
                  TermReference x_9720 = new TermReference();
                  IStrategoTerm y_9720 = null;
                  IStrategoTerm z_9720 = null;
                  if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                    break Fail120;
                  IStrategoTerm arg189 = term.getSubterm(1);
                  if(arg189.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg189).getConstructor())
                    break Fail120;
                  v_9720 = arg189.getSubterm(0);
                  IStrategoTerm arg190 = term.getSubterm(2);
                  if(arg190.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg190).getConstructor())
                    break Fail120;
                  if(w_9720.value == null)
                    w_9720.value = term.getSubterm(3);
                  else
                    if(w_9720.value != term.getSubterm(3) && !w_9720.value.match(term.getSubterm(3)))
                      break Fail120;
                  y_9720 = term;
                  if(w_9720.value == null)
                    break Fail120;
                  term = SRTS_one.instance.invoke(context, w_9720.value, lifted100.instance);
                  if(term == null)
                    break Fail120;
                  term = y_9720;
                  z_9720 = y_9720;
                  lifted102 lifted1020 = new lifted102();
                  lifted1020.w_9720 = w_9720;
                  lifted1020.x_9720 = x_9720;
                  term = with_spxverify_1_0.instance.invoke(context, term, lifted1020);
                  if(term == null)
                    break Fail120;
                  term = z_9720;
                  if(x_9720.value == null)
                    break Fail120;
                  term = termFactory.makeAppl(Main._consiter_star_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{v_9720}), termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{x_9720.value})});
                  if(true)
                    break Success88;
                }
                term = term125;
                IStrategoTerm term127 = term;
                Success89:
                { 
                  Fail121:
                  { 
                    IStrategoTerm r_9720 = null;
                    IStrategoTerm s_9720 = null;
                    if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                      break Fail121;
                    IStrategoTerm arg191 = term.getSubterm(1);
                    if(arg191.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg191).getConstructor())
                      break Fail121;
                    r_9720 = arg191.getSubterm(0);
                    IStrategoTerm arg192 = term.getSubterm(2);
                    if(arg192.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg192).getConstructor())
                      break Fail121;
                    s_9720 = term.getSubterm(3);
                    term = s_9720;
                    IStrategoTerm term128 = term;
                    Success90:
                    { 
                      Fail122:
                      { 
                        term = SRTS_one.instance.invoke(context, term, lifted103.instance);
                        if(term == null)
                          break Fail122;
                        { 
                          if(true)
                            break Fail121;
                          if(true)
                            break Success90;
                        }
                      }
                      term = term128;
                    }
                    term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{r_9720})});
                    if(true)
                      break Success89;
                  }
                  term = term127;
                  IStrategoTerm l_9720 = null;
                  TermReference m_9720 = new TermReference();
                  TermReference n_9720 = new TermReference();
                  IStrategoTerm o_9720 = null;
                  IStrategoTerm p_9720 = null;
                  if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                    break Fail114;
                  IStrategoTerm arg193 = term.getSubterm(1);
                  if(arg193.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg193).getConstructor())
                    break Fail114;
                  l_9720 = arg193.getSubterm(0);
                  IStrategoTerm arg194 = term.getSubterm(2);
                  if(arg194.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg194).getConstructor())
                    break Fail114;
                  if(m_9720.value == null)
                    m_9720.value = term.getSubterm(3);
                  else
                    if(m_9720.value != term.getSubterm(3) && !m_9720.value.match(term.getSubterm(3)))
                      break Fail114;
                  o_9720 = term;
                  if(m_9720.value == null)
                    break Fail114;
                  term = SRTS_one.instance.invoke(context, m_9720.value, lifted105.instance);
                  if(term == null)
                    break Fail114;
                  term = o_9720;
                  p_9720 = o_9720;
                  lifted107 lifted1070 = new lifted107();
                  lifted1070.m_9720 = m_9720;
                  lifted1070.n_9720 = n_9720;
                  term = with_spxverify_1_0.instance.invoke(context, term, lifted1070);
                  if(term == null)
                    break Fail114;
                  term = p_9720;
                  if(n_9720.value == null)
                    break Fail114;
                  term = termFactory.makeAppl(Main._consiter_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{l_9720}), termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{n_9720.value})});
                }
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