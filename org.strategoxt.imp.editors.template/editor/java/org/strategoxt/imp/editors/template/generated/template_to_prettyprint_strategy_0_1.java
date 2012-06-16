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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm j_9770)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_to_prettyprint_strategy_0_1");
    Fail34:
    { 
      IStrategoTerm term28 = term;
      IStrategoConstructor cons1 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success26:
      { 
        if(cons1 == Main._consDesugared_1)
        { 
          Fail35:
          { 
            IStrategoTerm d_9709 = null;
            IStrategoTerm e_9709 = null;
            IStrategoTerm f_9709 = null;
            IStrategoTerm arg18 = term.getSubterm(0);
            if(arg18.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg18).getConstructor())
              break Fail35;
            d_9709 = arg18.getSubterm(0);
            IStrategoTerm arg19 = arg18.getSubterm(1);
            if(arg19.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg19).getConstructor())
              break Fail35;
            e_9709 = arg19.getSubterm(0);
            f_9709 = arg18.getSubterm(2);
            IStrategoList list0;
            list0 = checkListTail(e_9709);
            if(list0 == null)
              break Fail35;
            term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{d_9709, termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(generated.constLayout0, list0)}), (IStrategoList)generated.constNil0)}), f_9709})});
            term = this.invoke(context, term, j_9770);
            if(term == null)
              break Fail35;
            if(true)
              break Success26;
          }
          term = term28;
        }
        Success27:
        { 
          if(cons1 == Main._consDesugared_1)
          { 
            Fail36:
            { 
              IStrategoTerm d_9708 = null;
              IStrategoTerm u_9708 = null;
              IStrategoTerm i_9708 = null;
              IStrategoTerm k_9708 = null;
              IStrategoTerm l_9708 = null;
              IStrategoTerm q_9708 = null;
              IStrategoTerm s_9708 = null;
              IStrategoTerm t_9708 = null;
              IStrategoTerm arg20 = term.getSubterm(0);
              if(arg20.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg20).getConstructor())
                break Fail36;
              d_9708 = arg20.getSubterm(0);
              IStrategoTerm arg21 = arg20.getSubterm(1);
              if(arg21.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg21).getConstructor())
                break Fail36;
              term = j_9770;
              IStrategoTerm term30 = term;
              Success28:
              { 
                Fail37:
                { 
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail37;
                  if(true)
                    break Success28;
                }
                term = term30;
                IStrategoTerm term31 = term;
                Success29:
                { 
                  Fail38:
                  { 
                    term = is_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail38;
                    if(true)
                      break Success29;
                  }
                  term = term31;
                  IStrategoTerm term32 = term;
                  Success30:
                  { 
                    Fail39:
                    { 
                      term = int_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail39;
                      if(true)
                        break Success30;
                    }
                    term = term32;
                    IStrategoTerm term33 = term;
                    Success31:
                    { 
                      Fail40:
                      { 
                        term = real_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail40;
                        if(true)
                          break Success31;
                      }
                      term = term33;
                      IStrategoTerm e_9708 = null;
                      IStrategoTerm f_9708 = null;
                      IStrategoTerm h_9708 = null;
                      e_9708 = term;
                      term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                      if(term == null)
                        break Fail36;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail36;
                      f_9708 = ((IStrategoList)term).tail();
                      h_9708 = f_9708;
                      term = report_failure_0_2.instance.invoke(context, h_9708, generated.const43, e_9708);
                      if(term == null)
                        break Fail36;
                    }
                  }
                }
              }
              k_9708 = term;
              i_9708 = generated.const39;
              l_9708 = k_9708;
              term = string_replace_0_2.instance.invoke(context, l_9708, i_9708, generated.const40);
              if(term == null)
                break Fail36;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail36;
              u_9708 = term;
              term = d_9708;
              IStrategoTerm term34 = term;
              Success32:
              { 
                Fail41:
                { 
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail41;
                  if(true)
                    break Success32;
                }
                term = term34;
                IStrategoTerm term35 = term;
                Success33:
                { 
                  Fail42:
                  { 
                    term = is_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail42;
                    if(true)
                      break Success33;
                  }
                  term = term35;
                  IStrategoTerm term36 = term;
                  Success34:
                  { 
                    Fail43:
                    { 
                      term = int_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail43;
                      if(true)
                        break Success34;
                    }
                    term = term36;
                    IStrategoTerm term37 = term;
                    Success35:
                    { 
                      Fail44:
                      { 
                        term = real_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail44;
                        if(true)
                          break Success35;
                      }
                      term = term37;
                      IStrategoTerm m_9708 = null;
                      IStrategoTerm n_9708 = null;
                      IStrategoTerm p_9708 = null;
                      m_9708 = term;
                      term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                      if(term == null)
                        break Fail36;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail36;
                      n_9708 = ((IStrategoList)term).tail();
                      p_9708 = n_9708;
                      term = report_failure_0_2.instance.invoke(context, p_9708, generated.const43, m_9708);
                      if(term == null)
                        break Fail36;
                    }
                  }
                }
              }
              s_9708 = term;
              q_9708 = generated.const39;
              t_9708 = s_9708;
              term = string_replace_0_2.instance.invoke(context, t_9708, q_9708, generated.const40);
              if(term == null)
                break Fail36;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail36;
              term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(u_9708, checkListAnnos(termFactory, generated.constNil0)), termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0))})})});
              if(true)
                break Success27;
            }
            term = term28;
          }
          IStrategoTerm z_9707 = null;
          z_9707 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, z_9707, generated.const44);
          if(term == null)
            break Fail34;
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