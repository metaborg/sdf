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
    Fail933:
    { 
      IStrategoTerm term374 = term;
      IStrategoConstructor cons20 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success338:
      { 
        if(cons20 == Main._consString_1)
        { 
          Fail934:
          { 
            IStrategoTerm r_32759 = null;
            r_32759 = term.getSubterm(0);
            term = string_to_sdf_0_0.instance.invoke(context, r_32759);
            if(term == null)
              break Fail934;
            if(true)
              break Success338;
          }
          term = term374;
        }
        Success339:
        { 
          if(cons20 == Main._consPlaceholder_4)
          { 
            Fail935:
            { 
              IStrategoTerm q_32759 = null;
              IStrategoTerm arg329 = term.getSubterm(0);
              if(arg329.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg329).getConstructor())
                break Fail935;
              IStrategoTerm arg330 = term.getSubterm(1);
              if(arg330.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg330).getConstructor())
                break Fail935;
              q_32759 = arg330.getSubterm(0);
              IStrategoTerm arg331 = term.getSubterm(2);
              if(arg331.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg331).getConstructor())
                break Fail935;
              term = termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{q_32759});
              if(true)
                break Success339;
            }
            term = term374;
          }
          Success340:
          { 
            if(cons20 == Main._consPlaceholder_4)
            { 
              Fail936:
              { 
                IStrategoTerm o_32759 = null;
                IStrategoTerm p_32759 = null;
                IStrategoTerm arg333 = term.getSubterm(0);
                if(arg333.getTermType() != IStrategoTerm.APPL || Main._consLabel_1 != ((IStrategoAppl)arg333).getConstructor())
                  break Fail936;
                o_32759 = arg333.getSubterm(0);
                IStrategoTerm arg334 = term.getSubterm(1);
                if(arg334.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg334).getConstructor())
                  break Fail936;
                p_32759 = arg334.getSubterm(0);
                IStrategoTerm arg335 = term.getSubterm(2);
                if(arg335.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg335).getConstructor())
                  break Fail936;
                term = termFactory.makeAppl(Main._conslabel_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consunquoted_1, new IStrategoTerm[]{o_32759}), termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{p_32759})});
                if(true)
                  break Success340;
              }
              term = term374;
            }
            Success341:
            { 
              if(cons20 == Main._consPlaceholder_4)
              { 
                Fail937:
                { 
                  IStrategoTerm n_32759 = null;
                  IStrategoTerm arg337 = term.getSubterm(1);
                  if(arg337.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg337).getConstructor())
                    break Fail937;
                  n_32759 = arg337.getSubterm(0);
                  IStrategoTerm arg338 = term.getSubterm(2);
                  if(arg338.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg338).getConstructor())
                    break Fail937;
                  term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{n_32759})});
                  if(true)
                    break Success341;
                }
                term = term374;
              }
              Success342:
              { 
                if(cons20 == Main._consPlaceholder_4)
                { 
                  Fail938:
                  { 
                    IStrategoTerm j_32759 = null;
                    IStrategoTerm k_32759 = null;
                    IStrategoTerm arg340 = term.getSubterm(1);
                    if(arg340.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg340).getConstructor())
                      break Fail938;
                    j_32759 = arg340.getSubterm(0);
                    IStrategoTerm arg341 = term.getSubterm(2);
                    if(arg341.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg341).getConstructor())
                      break Fail938;
                    k_32759 = term.getSubterm(3);
                    term = k_32759;
                    IStrategoTerm term379 = term;
                    Success343:
                    { 
                      Fail939:
                      { 
                        term = SRTS_one.instance.invoke(context, term, lifted297.instance);
                        if(term == null)
                          break Fail939;
                        { 
                          if(true)
                            break Fail938;
                          if(true)
                            break Success343;
                        }
                      }
                      term = term379;
                    }
                    term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32759})});
                    if(true)
                      break Success342;
                  }
                  term = term374;
                }
                IStrategoTerm term381 = term;
                Success344:
                { 
                  Fail940:
                  { 
                    IStrategoTerm d_32759 = null;
                    TermReference e_32759 = new TermReference();
                    TermReference f_32759 = new TermReference();
                    IStrategoTerm g_32759 = null;
                    IStrategoTerm h_32759 = null;
                    if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                      break Fail940;
                    IStrategoTerm arg342 = term.getSubterm(1);
                    if(arg342.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg342).getConstructor())
                      break Fail940;
                    d_32759 = arg342.getSubterm(0);
                    IStrategoTerm arg343 = term.getSubterm(2);
                    if(arg343.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg343).getConstructor())
                      break Fail940;
                    if(e_32759.value == null)
                      e_32759.value = term.getSubterm(3);
                    else
                      if(e_32759.value != term.getSubterm(3) && !e_32759.value.match(term.getSubterm(3)))
                        break Fail940;
                    g_32759 = term;
                    if(e_32759.value == null)
                      break Fail940;
                    term = SRTS_one.instance.invoke(context, e_32759.value, lifted299.instance);
                    if(term == null)
                      break Fail940;
                    term = g_32759;
                    h_32759 = g_32759;
                    lifted301 lifted3010 = new lifted301();
                    lifted3010.e_32759 = e_32759;
                    lifted3010.f_32759 = f_32759;
                    term = with_spxverify_1_0.instance.invoke(context, term, lifted3010);
                    if(term == null)
                      break Fail940;
                    term = h_32759;
                    if(f_32759.value == null)
                      break Fail940;
                    term = termFactory.makeAppl(Main._consiter_star_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{d_32759}), termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{f_32759.value})});
                    if(true)
                      break Success344;
                  }
                  term = term381;
                  IStrategoTerm term383 = term;
                  Success345:
                  { 
                    Fail941:
                    { 
                      IStrategoTerm z_32758 = null;
                      IStrategoTerm a_32759 = null;
                      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                        break Fail941;
                      IStrategoTerm arg344 = term.getSubterm(1);
                      if(arg344.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg344).getConstructor())
                        break Fail941;
                      z_32758 = arg344.getSubterm(0);
                      IStrategoTerm arg345 = term.getSubterm(2);
                      if(arg345.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg345).getConstructor())
                        break Fail941;
                      a_32759 = term.getSubterm(3);
                      term = a_32759;
                      IStrategoTerm term384 = term;
                      Success346:
                      { 
                        Fail942:
                        { 
                          term = SRTS_one.instance.invoke(context, term, lifted302.instance);
                          if(term == null)
                            break Fail942;
                          { 
                            if(true)
                              break Fail941;
                            if(true)
                              break Success346;
                          }
                        }
                        term = term384;
                      }
                      term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{z_32758})});
                      if(true)
                        break Success345;
                    }
                    term = term383;
                    IStrategoTerm t_32758 = null;
                    TermReference u_32758 = new TermReference();
                    TermReference v_32758 = new TermReference();
                    IStrategoTerm w_32758 = null;
                    IStrategoTerm x_32758 = null;
                    if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                      break Fail933;
                    IStrategoTerm arg346 = term.getSubterm(1);
                    if(arg346.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg346).getConstructor())
                      break Fail933;
                    t_32758 = arg346.getSubterm(0);
                    IStrategoTerm arg347 = term.getSubterm(2);
                    if(arg347.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg347).getConstructor())
                      break Fail933;
                    if(u_32758.value == null)
                      u_32758.value = term.getSubterm(3);
                    else
                      if(u_32758.value != term.getSubterm(3) && !u_32758.value.match(term.getSubterm(3)))
                        break Fail933;
                    w_32758 = term;
                    if(u_32758.value == null)
                      break Fail933;
                    term = SRTS_one.instance.invoke(context, u_32758.value, lifted304.instance);
                    if(term == null)
                      break Fail933;
                    term = w_32758;
                    x_32758 = w_32758;
                    lifted306 lifted3060 = new lifted306();
                    lifted3060.u_32758 = u_32758;
                    lifted3060.v_32758 = v_32758;
                    term = with_spxverify_1_0.instance.invoke(context, term, lifted3060);
                    if(term == null)
                      break Fail933;
                    term = x_32758;
                    if(v_32758.value == null)
                      break Fail933;
                    term = termFactory.makeAppl(Main._consiter_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{t_32758}), termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{v_32758.value})});
                  }
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