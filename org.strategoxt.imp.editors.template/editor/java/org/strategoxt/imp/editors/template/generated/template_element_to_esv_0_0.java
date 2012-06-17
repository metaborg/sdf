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

@SuppressWarnings("all") public class template_element_to_esv_0_0 extends Strategy 
{ 
  public static template_element_to_esv_0_0 instance = new template_element_to_esv_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_element_to_esv_0_0");
    Fail977:
    { 
      IStrategoTerm term417 = term;
      Success366:
      { 
        Fail978:
        { 
          IStrategoTerm y_32763 = null;
          IStrategoTerm z_32763 = null;
          TermReference a_32764 = new TermReference();
          IStrategoTerm j_32764 = null;
          IStrategoTerm f_32764 = null;
          IStrategoTerm h_32764 = null;
          IStrategoTerm i_32764 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
            break Fail978;
          IStrategoTerm arg373 = term.getSubterm(1);
          if(arg373.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg373).getConstructor())
            break Fail978;
          y_32763 = arg373.getSubterm(0);
          z_32763 = term.getSubterm(3);
          j_32764 = term;
          term = z_32763;
          lifted338 lifted3380 = new lifted338();
          lifted3380.a_32764 = a_32764;
          term = SRTS_one.instance.invoke(context, term, lifted3380);
          if(term == null)
            break Fail978;
          term = j_32764;
          if(a_32764.value == null)
            break Fail978;
          term = a_32764.value;
          IStrategoTerm term418 = term;
          Success367:
          { 
            Fail979:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail979;
              if(true)
                break Success367;
            }
            term = term418;
            IStrategoTerm term419 = term;
            Success368:
            { 
              Fail980:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail980;
                if(true)
                  break Success368;
              }
              term = term419;
              IStrategoTerm term420 = term;
              Success369:
              { 
                Fail981:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail981;
                  if(true)
                    break Success369;
                }
                term = term420;
                IStrategoTerm term421 = term;
                Success370:
                { 
                  Fail982:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail982;
                    if(true)
                      break Success370;
                  }
                  term = term421;
                  IStrategoTerm b_32764 = null;
                  IStrategoTerm c_32764 = null;
                  IStrategoTerm e_32764 = null;
                  b_32764 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail978;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail978;
                  c_32764 = ((IStrategoList)term).tail();
                  e_32764 = c_32764;
                  term = report_failure_0_2.instance.invoke(context, e_32764, generated.const207, b_32764);
                  if(term == null)
                    break Fail978;
                }
              }
            }
          }
          h_32764 = term;
          f_32764 = generated.const160;
          i_32764 = h_32764;
          term = string_replace_0_2.instance.invoke(context, i_32764, f_32764, generated.const208);
          if(term == null)
            break Fail978;
          term = (IStrategoTerm)termFactory.makeListCons(generated.const210, termFactory.makeListCons(term, (IStrategoList)generated.constCons79));
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail978;
          term = termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3)), y_32763});
          if(true)
            break Success366;
        }
        term = term417;
        IStrategoTerm term422 = term;
        IStrategoConstructor cons24 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
        Success371:
        { 
          if(cons24 == Main._consPlaceholder_4)
          { 
            Fail983:
            { 
              IStrategoTerm e_32763 = null;
              IStrategoTerm f_32763 = null;
              IStrategoTerm g_32763 = null;
              IStrategoTerm h_32763 = null;
              IStrategoTerm q_32763 = null;
              IStrategoTerm m_32763 = null;
              IStrategoTerm o_32763 = null;
              IStrategoTerm p_32763 = null;
              g_32763 = term;
              IStrategoTerm arg376 = term.getSubterm(1);
              if(arg376.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg376).getConstructor())
                break Fail983;
              f_32763 = arg376.getSubterm(0);
              q_32763 = term.getSubterm(2);
              e_32763 = term.getSubterm(3);
              term = q_32763;
              IStrategoTerm term423 = term;
              Success372:
              { 
                Fail984:
                { 
                  term = $None_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail984;
                  if(true)
                    break Success372;
                }
                term = $Plus_0_0.instance.invoke(context, term423);
                if(term == null)
                  break Fail983;
              }
              term = e_32763;
              IStrategoTerm term424 = term;
              Success373:
              { 
                Fail985:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted339.instance);
                  if(term == null)
                    break Fail985;
                  { 
                    if(true)
                      break Fail983;
                    if(true)
                      break Success373;
                  }
                }
                term = term424;
              }
              term = (IStrategoTerm)termFactory.makeListCons(g_32763, (IStrategoList)generated.constNil3);
              Success374:
              { 
                Fail986:
                { 
                  term = expand_template_element_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail986;
                  term = map_1_0.instance.invoke(context, term, template_element_to_string_0_0.instance);
                  if(term == null)
                    break Fail986;
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail986;
                  if(true)
                    break Success374;
                }
                term = f_32763;
              }
              h_32763 = term;
              term = h_32763;
              IStrategoTerm term427 = term;
              Success375:
              { 
                Fail987:
                { 
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail987;
                  if(true)
                    break Success375;
                }
                term = term427;
                IStrategoTerm term428 = term;
                Success376:
                { 
                  Fail988:
                  { 
                    term = is_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail988;
                    if(true)
                      break Success376;
                  }
                  term = term428;
                  IStrategoTerm term429 = term;
                  Success377:
                  { 
                    Fail989:
                    { 
                      term = int_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail989;
                      if(true)
                        break Success377;
                    }
                    term = term429;
                    IStrategoTerm term430 = term;
                    Success378:
                    { 
                      Fail990:
                      { 
                        term = real_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail990;
                        if(true)
                          break Success378;
                      }
                      term = term430;
                      IStrategoTerm i_32763 = null;
                      IStrategoTerm j_32763 = null;
                      IStrategoTerm l_32763 = null;
                      i_32763 = term;
                      term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                      if(term == null)
                        break Fail983;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail983;
                      j_32763 = ((IStrategoList)term).tail();
                      l_32763 = j_32763;
                      term = report_failure_0_2.instance.invoke(context, l_32763, generated.const207, i_32763);
                      if(term == null)
                        break Fail983;
                    }
                  }
                }
              }
              o_32763 = term;
              m_32763 = generated.const160;
              p_32763 = o_32763;
              term = string_replace_0_2.instance.invoke(context, p_32763, m_32763, generated.const208);
              if(term == null)
                break Fail983;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const210, termFactory.makeListCons(term, (IStrategoList)generated.constCons79));
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail983;
              term = termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3)), f_32763});
              if(true)
                break Success371;
            }
            term = term422;
          }
          Success379:
          { 
            if(cons24 == Main._consPlaceholder_4)
            { 
              Fail991:
              { 
                IStrategoTerm z_32762 = null;
                IStrategoTerm a_32763 = null;
                IStrategoTerm b_32763 = null;
                IStrategoTerm arg379 = term.getSubterm(1);
                if(arg379.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg379).getConstructor())
                  break Fail991;
                z_32762 = arg379.getSubterm(0);
                b_32763 = term.getSubterm(2);
                a_32763 = term.getSubterm(3);
                term = b_32763;
                IStrategoTerm term432 = term;
                Success380:
                { 
                  Fail992:
                  { 
                    term = $Option_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail992;
                    if(true)
                      break Success380;
                  }
                  term = $Star_0_0.instance.invoke(context, term432);
                  if(term == null)
                    break Fail991;
                }
                term = a_32763;
                IStrategoTerm term433 = term;
                Success381:
                { 
                  Fail993:
                  { 
                    term = SRTS_one.instance.invoke(context, term, lifted341.instance);
                    if(term == null)
                      break Fail993;
                    { 
                      if(true)
                        break Fail991;
                      if(true)
                        break Success381;
                    }
                  }
                  term = term433;
                }
                term = termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{generated.const211, z_32762});
                if(true)
                  break Success379;
              }
              term = term422;
            }
            Success382:
            { 
              if(cons24 == Main._consLayout_1)
              { 
                Fail994:
                { 
                  IStrategoTerm x_32762 = null;
                  x_32762 = term.getSubterm(0);
                  term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{x_32762});
                  if(true)
                    break Success382;
                }
                term = term422;
              }
              if(cons24 == Main._consString_1)
              { }
              else
              { 
                break Fail977;
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