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
    Fail864:
    { 
      IStrategoTerm term293 = term;
      Success291:
      { 
        Fail865:
        { 
          IStrategoTerm o_32748 = null;
          IStrategoTerm p_32748 = null;
          IStrategoTerm q_32748 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail865;
          IStrategoTerm arg172 = term.getSubterm(0);
          if(arg172.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg172).getConstructor())
            break Fail865;
          o_32748 = arg172.getSubterm(0);
          IStrategoTerm arg173 = arg172.getSubterm(1);
          if(arg173.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg173).getConstructor())
            break Fail865;
          p_32748 = arg173.getSubterm(0);
          q_32748 = arg172.getSubterm(2);
          IStrategoList list4;
          list4 = checkListTail(p_32748);
          if(list4 == null)
            break Fail865;
          term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{o_32748, termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(generated.constLayout0, list4)}), (IStrategoList)generated.constNil3)}), q_32748})});
          term = this.invoke(context, term);
          if(term == null)
            break Fail865;
          if(true)
            break Success291;
        }
        term = term293;
        IStrategoTerm term294 = term;
        Success292:
        { 
          Fail866:
          { 
            IStrategoTerm q_32747 = null;
            TermReference r_32747 = new TermReference();
            TermReference s_32747 = new TermReference();
            TermReference t_32747 = new TermReference();
            TermReference u_32747 = new TermReference();
            TermReference v_32747 = new TermReference();
            TermReference w_32747 = new TermReference();
            TermReference x_32747 = new TermReference();
            IStrategoTerm j_32748 = null;
            IStrategoTerm k_32748 = null;
            IStrategoTerm l_32748 = null;
            IStrategoTerm f_32748 = null;
            IStrategoTerm h_32748 = null;
            IStrategoTerm i_32748 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
              break Fail866;
            IStrategoTerm arg174 = term.getSubterm(0);
            if(arg174.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg174).getConstructor())
              break Fail866;
            q_32747 = arg174.getSubterm(0);
            IStrategoTerm arg175 = arg174.getSubterm(1);
            if(arg175.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg175).getConstructor())
              break Fail866;
            if(r_32747.value == null)
              r_32747.value = arg175.getSubterm(0);
            else
              if(r_32747.value != arg175.getSubterm(0) && !r_32747.value.match(arg175.getSubterm(0)))
                break Fail866;
            if(v_32747.value == null)
              v_32747.value = arg174.getSubterm(2);
            else
              if(v_32747.value != arg174.getSubterm(2) && !v_32747.value.match(arg174.getSubterm(2)))
                break Fail866;
            j_32748 = term;
            lifted222 lifted2220 = new lifted222();
            lifted2220.r_32747 = r_32747;
            lifted2220.s_32747 = s_32747;
            lifted2220.t_32747 = t_32747;
            lifted2220.u_32747 = u_32747;
            lifted2220.v_32747 = v_32747;
            lifted2220.w_32747 = w_32747;
            lifted2220.x_32747 = x_32747;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted2220, lifted226.instance);
            if(term == null)
              break Fail866;
            l_32748 = j_32748;
            term = q_32747;
            IStrategoTerm term298 = term;
            Success293:
            { 
              Fail867:
              { 
                term = concat_strings_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail867;
                if(true)
                  break Success293;
              }
              term = term298;
              IStrategoTerm term299 = term;
              Success294:
              { 
                Fail868:
                { 
                  term = is_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail868;
                  if(true)
                    break Success294;
                }
                term = term299;
                IStrategoTerm term300 = term;
                Success295:
                { 
                  Fail869:
                  { 
                    term = int_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail869;
                    if(true)
                      break Success295;
                  }
                  term = term300;
                  IStrategoTerm term301 = term;
                  Success296:
                  { 
                    Fail870:
                    { 
                      term = real_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail870;
                      if(true)
                        break Success296;
                    }
                    term = term301;
                    IStrategoTerm b_32748 = null;
                    IStrategoTerm c_32748 = null;
                    IStrategoTerm e_32748 = null;
                    b_32748 = term;
                    term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                    if(term == null)
                      break Fail866;
                    if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                      break Fail866;
                    c_32748 = ((IStrategoList)term).tail();
                    e_32748 = c_32748;
                    term = report_failure_0_2.instance.invoke(context, e_32748, generated.const164, b_32748);
                    if(term == null)
                      break Fail866;
                  }
                }
              }
            }
            h_32748 = term;
            f_32748 = generated.const160;
            i_32748 = h_32748;
            term = string_replace_0_2.instance.invoke(context, i_32748, f_32748, generated.const161);
            if(term == null)
              break Fail866;
            term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
            term = concat_strings_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail866;
            k_32748 = term;
            term = l_32748;
            if(x_32747.value == null || s_32747.value == null)
              break Fail866;
            term = termFactory.makeAppl(Main._consSDefNoArgs_2, new IStrategoTerm[]{termFactory.annotateTerm(k_32748, checkListAnnos(termFactory, generated.constNil3)), termFactory.makeAppl(Main._consSeq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consMatch_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{x_32747.value})}), termFactory.makeAppl(Main._consBuild_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{s_32747.value})})})})});
            if(true)
              break Success292;
          }
          term = term294;
          IStrategoTerm p_32747 = null;
          p_32747 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, p_32747, generated.const165);
          if(term == null)
            break Fail864;
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