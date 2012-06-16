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

@SuppressWarnings("all") public class template_to_prettyprint_strategy_0_0 extends Strategy 
{ 
  public static template_to_prettyprint_strategy_0_0 instance = new template_to_prettyprint_strategy_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_to_prettyprint_strategy_0_0");
    Fail45:
    { 
      IStrategoTerm term38 = term;
      Success36:
      { 
        Fail46:
        { 
          IStrategoTerm g_9710 = null;
          IStrategoTerm h_9710 = null;
          IStrategoTerm i_9710 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail46;
          IStrategoTerm arg24 = term.getSubterm(0);
          if(arg24.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg24).getConstructor())
            break Fail46;
          g_9710 = arg24.getSubterm(0);
          IStrategoTerm arg25 = arg24.getSubterm(1);
          if(arg25.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg25).getConstructor())
            break Fail46;
          h_9710 = arg25.getSubterm(0);
          i_9710 = arg24.getSubterm(2);
          IStrategoList list1;
          list1 = checkListTail(h_9710);
          if(list1 == null)
            break Fail46;
          term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{g_9710, termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(generated.constLayout0, list1)}), (IStrategoList)generated.constNil0)}), i_9710})});
          term = this.invoke(context, term);
          if(term == null)
            break Fail46;
          if(true)
            break Success36;
        }
        term = term38;
        IStrategoTerm term39 = term;
        Success37:
        { 
          Fail47:
          { 
            IStrategoTerm i_9709 = null;
            TermReference j_9709 = new TermReference();
            TermReference k_9709 = new TermReference();
            TermReference l_9709 = new TermReference();
            TermReference m_9709 = new TermReference();
            TermReference n_9709 = new TermReference();
            TermReference o_9709 = new TermReference();
            TermReference p_9709 = new TermReference();
            IStrategoTerm b_9710 = null;
            IStrategoTerm c_9710 = null;
            IStrategoTerm d_9710 = null;
            IStrategoTerm x_9709 = null;
            IStrategoTerm z_9709 = null;
            IStrategoTerm a_9710 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
              break Fail47;
            IStrategoTerm arg26 = term.getSubterm(0);
            if(arg26.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg26).getConstructor())
              break Fail47;
            i_9709 = arg26.getSubterm(0);
            IStrategoTerm arg27 = arg26.getSubterm(1);
            if(arg27.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg27).getConstructor())
              break Fail47;
            if(j_9709.value == null)
              j_9709.value = arg27.getSubterm(0);
            else
              if(j_9709.value != arg27.getSubterm(0) && !j_9709.value.match(arg27.getSubterm(0)))
                break Fail47;
            if(n_9709.value == null)
              n_9709.value = arg26.getSubterm(2);
            else
              if(n_9709.value != arg26.getSubterm(2) && !n_9709.value.match(arg26.getSubterm(2)))
                break Fail47;
            b_9710 = term;
            lifted23 lifted2310 = new lifted23();
            lifted2310.j_9709 = j_9709;
            lifted2310.k_9709 = k_9709;
            lifted2310.l_9709 = l_9709;
            lifted2310.m_9709 = m_9709;
            lifted2310.n_9709 = n_9709;
            lifted2310.o_9709 = o_9709;
            lifted2310.p_9709 = p_9709;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted2310, lifted27.instance);
            if(term == null)
              break Fail47;
            d_9710 = b_9710;
            term = i_9709;
            IStrategoTerm term43 = term;
            Success38:
            { 
              Fail48:
              { 
                term = concat_strings_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail48;
                if(true)
                  break Success38;
              }
              term = term43;
              IStrategoTerm term44 = term;
              Success39:
              { 
                Fail49:
                { 
                  term = is_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail49;
                  if(true)
                    break Success39;
                }
                term = term44;
                IStrategoTerm term45 = term;
                Success40:
                { 
                  Fail50:
                  { 
                    term = int_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail50;
                    if(true)
                      break Success40;
                  }
                  term = term45;
                  IStrategoTerm term46 = term;
                  Success41:
                  { 
                    Fail51:
                    { 
                      term = real_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail51;
                      if(true)
                        break Success41;
                    }
                    term = term46;
                    IStrategoTerm t_9709 = null;
                    IStrategoTerm u_9709 = null;
                    IStrategoTerm w_9709 = null;
                    t_9709 = term;
                    term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                    if(term == null)
                      break Fail47;
                    if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                      break Fail47;
                    u_9709 = ((IStrategoList)term).tail();
                    w_9709 = u_9709;
                    term = report_failure_0_2.instance.invoke(context, w_9709, generated.const43, t_9709);
                    if(term == null)
                      break Fail47;
                  }
                }
              }
            }
            z_9709 = term;
            x_9709 = generated.const39;
            a_9710 = z_9709;
            term = string_replace_0_2.instance.invoke(context, a_9710, x_9709, generated.const40);
            if(term == null)
              break Fail47;
            term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
            term = concat_strings_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail47;
            c_9710 = term;
            term = d_9710;
            if(p_9709.value == null || k_9709.value == null)
              break Fail47;
            term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(c_9710, checkListAnnos(termFactory, generated.constNil0)), termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consMatch_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{p_9709.value})}), termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{k_9709.value})})})})});
            if(true)
              break Success37;
          }
          term = term39;
          IStrategoTerm h_9709 = null;
          h_9709 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, h_9709, generated.const44);
          if(term == null)
            break Fail45;
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