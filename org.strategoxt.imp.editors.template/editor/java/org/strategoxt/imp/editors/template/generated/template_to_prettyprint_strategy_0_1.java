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

@SuppressWarnings("all") public class template_to_prettyprint_strategy_0_1 extends Strategy 
{ 
  public static template_to_prettyprint_strategy_0_1 instance = new template_to_prettyprint_strategy_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm s_32808)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_to_prettyprint_strategy_0_1");
    Fail853:
    { 
      IStrategoTerm term283 = term;
      IStrategoConstructor cons13 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success281:
      { 
        if(cons13 == Main._consDesugared_1)
        { 
          Fail854:
          { 
            IStrategoTerm l_32747 = null;
            IStrategoTerm m_32747 = null;
            IStrategoTerm n_32747 = null;
            IStrategoTerm arg166 = term.getSubterm(0);
            if(arg166.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg166).getConstructor())
              break Fail854;
            l_32747 = arg166.getSubterm(0);
            IStrategoTerm arg167 = arg166.getSubterm(1);
            if(arg167.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg167).getConstructor())
              break Fail854;
            m_32747 = arg167.getSubterm(0);
            n_32747 = arg166.getSubterm(2);
            IStrategoList list3;
            list3 = checkListTail(m_32747);
            if(list3 == null)
              break Fail854;
            term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{l_32747, termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(generated.constLayout0, list3)}), (IStrategoList)generated.constNil3)}), n_32747})});
            term = this.invoke(context, term, s_32808);
            if(term == null)
              break Fail854;
            if(true)
              break Success281;
          }
          term = term283;
        }
        Success282:
        { 
          if(cons13 == Main._consDesugared_1)
          { 
            Fail855:
            { 
              IStrategoTerm l_32746 = null;
              IStrategoTerm c_32747 = null;
              IStrategoTerm q_32746 = null;
              IStrategoTerm s_32746 = null;
              IStrategoTerm t_32746 = null;
              IStrategoTerm y_32746 = null;
              IStrategoTerm a_32747 = null;
              IStrategoTerm b_32747 = null;
              IStrategoTerm arg168 = term.getSubterm(0);
              if(arg168.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg168).getConstructor())
                break Fail855;
              l_32746 = arg168.getSubterm(0);
              IStrategoTerm arg169 = arg168.getSubterm(1);
              if(arg169.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg169).getConstructor())
                break Fail855;
              term = s_32808;
              IStrategoTerm term285 = term;
              Success283:
              { 
                Fail856:
                { 
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail856;
                  if(true)
                    break Success283;
                }
                term = term285;
                IStrategoTerm term286 = term;
                Success284:
                { 
                  Fail857:
                  { 
                    term = is_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail857;
                    if(true)
                      break Success284;
                  }
                  term = term286;
                  IStrategoTerm term287 = term;
                  Success285:
                  { 
                    Fail858:
                    { 
                      term = int_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail858;
                      if(true)
                        break Success285;
                    }
                    term = term287;
                    IStrategoTerm term288 = term;
                    Success286:
                    { 
                      Fail859:
                      { 
                        term = real_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail859;
                        if(true)
                          break Success286;
                      }
                      term = term288;
                      IStrategoTerm m_32746 = null;
                      IStrategoTerm n_32746 = null;
                      IStrategoTerm p_32746 = null;
                      m_32746 = term;
                      term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                      if(term == null)
                        break Fail855;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail855;
                      n_32746 = ((IStrategoList)term).tail();
                      p_32746 = n_32746;
                      term = report_failure_0_2.instance.invoke(context, p_32746, generated.const164, m_32746);
                      if(term == null)
                        break Fail855;
                    }
                  }
                }
              }
              s_32746 = term;
              q_32746 = generated.const160;
              t_32746 = s_32746;
              term = string_replace_0_2.instance.invoke(context, t_32746, q_32746, generated.const161);
              if(term == null)
                break Fail855;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail855;
              c_32747 = term;
              term = l_32746;
              IStrategoTerm term289 = term;
              Success287:
              { 
                Fail860:
                { 
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail860;
                  if(true)
                    break Success287;
                }
                term = term289;
                IStrategoTerm term290 = term;
                Success288:
                { 
                  Fail861:
                  { 
                    term = is_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail861;
                    if(true)
                      break Success288;
                  }
                  term = term290;
                  IStrategoTerm term291 = term;
                  Success289:
                  { 
                    Fail862:
                    { 
                      term = int_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail862;
                      if(true)
                        break Success289;
                    }
                    term = term291;
                    IStrategoTerm term292 = term;
                    Success290:
                    { 
                      Fail863:
                      { 
                        term = real_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail863;
                        if(true)
                          break Success290;
                      }
                      term = term292;
                      IStrategoTerm u_32746 = null;
                      IStrategoTerm v_32746 = null;
                      IStrategoTerm x_32746 = null;
                      u_32746 = term;
                      term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                      if(term == null)
                        break Fail855;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail855;
                      v_32746 = ((IStrategoList)term).tail();
                      x_32746 = v_32746;
                      term = report_failure_0_2.instance.invoke(context, x_32746, generated.const164, u_32746);
                      if(term == null)
                        break Fail855;
                    }
                  }
                }
              }
              a_32747 = term;
              y_32746 = generated.const160;
              b_32747 = a_32747;
              term = string_replace_0_2.instance.invoke(context, b_32747, y_32746, generated.const161);
              if(term == null)
                break Fail855;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail855;
              term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(c_32747, checkListAnnos(termFactory, generated.constNil3)), termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3))})})});
              if(true)
                break Success282;
            }
            term = term283;
          }
          IStrategoTerm h_32746 = null;
          h_32746 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, h_32746, generated.const165);
          if(term == null)
            break Fail853;
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