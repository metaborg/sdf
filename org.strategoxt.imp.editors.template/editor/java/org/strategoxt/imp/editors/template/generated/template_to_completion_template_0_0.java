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

@SuppressWarnings("all") public class template_to_completion_template_0_0 extends Strategy 
{ 
  public static template_to_completion_template_0_0 instance = new template_to_completion_template_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_to_completion_template_0_0");
    Fail960:
    { 
      IStrategoTerm term406 = term;
      Success355:
      { 
        Fail961:
        { 
          IStrategoTerm l_32761 = null;
          TermReference m_32761 = new TermReference();
          TermReference n_32761 = new TermReference();
          TermReference o_32761 = new TermReference();
          TermReference p_32761 = new TermReference();
          IStrategoTerm q_32761 = null;
          IStrategoTerm r_32761 = null;
          IStrategoTerm s_32761 = null;
          IStrategoTerm t_32761 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail961;
          IStrategoTerm arg350 = term.getSubterm(0);
          if(m_32761.value == null)
            m_32761.value = arg350;
          else
            if(m_32761.value != arg350 && !m_32761.value.match(arg350))
              break Fail961;
          if(arg350.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg350).getConstructor())
            break Fail961;
          q_32761 = arg350.getSubterm(0);
          IStrategoTerm arg351 = arg350.getSubterm(1);
          if(arg351.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg351).getConstructor())
            break Fail961;
          l_32761 = arg350.getSubterm(2);
          r_32761 = term;
          IStrategoTerm term407 = term;
          Success356:
          { 
            Fail962:
            { 
              term = l_32761;
              IStrategoTerm term408 = term;
              Success357:
              { 
                Fail963:
                { 
                  term = is_deprecated_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail963;
                  if(true)
                    break Success357;
                }
                term = is_reject_0_0.instance.invoke(context, term408);
                if(term == null)
                  break Fail962;
              }
              { 
                if(true)
                  break Fail961;
                if(true)
                  break Success356;
              }
            }
            term = term407;
          }
          term = r_32761;
          s_32761 = r_32761;
          lifted323 lifted3230 = new lifted323();
          lifted3230.m_32761 = m_32761;
          lifted3230.n_32761 = n_32761;
          lifted3230.p_32761 = p_32761;
          lifted3230.o_32761 = o_32761;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted3230);
          if(term == null)
            break Fail961;
          term = s_32761;
          t_32761 = s_32761;
          if(p_32761.value == null)
            break Fail961;
          term = accept_template_parts_0_1.instance.invoke(context, p_32761.value, q_32761);
          if(term == null)
            break Fail961;
          term = t_32761;
          if(o_32761.value == null || p_32761.value == null)
            break Fail961;
          term = termFactory.makeAppl(Main._consCompletionTemplateEx_4, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSort_1, new IStrategoTerm[]{q_32761}), (IStrategoList)generated.constNil3), termFactory.makeAppl(Main._consCompletionPrefix_1, new IStrategoTerm[]{o_32761.value}), p_32761.value, generated.constNil3});
          if(true)
            break Success355;
        }
        term = term406;
        IStrategoTerm term409 = term;
        Success358:
        { 
          Fail964:
          { 
            IStrategoTerm a_32761 = null;
            TermReference b_32761 = new TermReference();
            TermReference c_32761 = new TermReference();
            TermReference d_32761 = new TermReference();
            TermReference e_32761 = new TermReference();
            IStrategoTerm f_32761 = null;
            IStrategoTerm g_32761 = null;
            IStrategoTerm h_32761 = null;
            IStrategoTerm k_32761 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
              break Fail964;
            IStrategoTerm arg353 = term.getSubterm(0);
            if(b_32761.value == null)
              b_32761.value = arg353;
            else
              if(b_32761.value != arg353 && !b_32761.value.match(arg353))
                break Fail964;
            if(arg353.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg353).getConstructor())
              break Fail964;
            f_32761 = arg353.getSubterm(0);
            IStrategoTerm arg354 = arg353.getSubterm(1);
            if(arg354.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg354).getConstructor())
              break Fail964;
            a_32761 = arg353.getSubterm(2);
            g_32761 = term;
            IStrategoTerm term410 = term;
            Success359:
            { 
              Fail965:
              { 
                term = a_32761;
                IStrategoTerm term411 = term;
                Success360:
                { 
                  Fail966:
                  { 
                    term = is_deprecated_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail966;
                    if(true)
                      break Success360;
                  }
                  term = is_reject_0_0.instance.invoke(context, term411);
                  if(term == null)
                    break Fail965;
                }
                { 
                  if(true)
                    break Fail964;
                  if(true)
                    break Success359;
                }
              }
              term = term410;
            }
            term = g_32761;
            h_32761 = g_32761;
            lifted325 lifted3250 = new lifted325();
            lifted3250.b_32761 = b_32761;
            lifted3250.c_32761 = c_32761;
            lifted3250.e_32761 = e_32761;
            lifted3250.d_32761 = d_32761;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted3250);
            if(term == null)
              break Fail964;
            term = h_32761;
            k_32761 = h_32761;
            if(e_32761.value == null)
              break Fail964;
            term = accept_template_parts_0_1.instance.invoke(context, e_32761.value, f_32761);
            if(term == null)
              break Fail964;
            term = k_32761;
            if(d_32761.value == null || e_32761.value == null)
              break Fail964;
            term = termFactory.makeAppl(Main._consCompletionTemplateEx_4, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSort_1, new IStrategoTerm[]{f_32761}), (IStrategoList)generated.constNil3), termFactory.makeAppl(Main._consCompletionPrefix_1, new IStrategoTerm[]{d_32761.value}), e_32761.value, generated.constCons77});
            if(true)
              break Success358;
          }
          term = term409;
          IStrategoTerm z_32760 = null;
          z_32760 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, z_32760, generated.const200);
          if(term == null)
            break Fail960;
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