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
    Fail140:
    { 
      IStrategoTerm term150 = term;
      Success99:
      { 
        Fail141:
        { 
          IStrategoTerm c_9723 = null;
          TermReference d_9723 = new TermReference();
          TermReference e_9723 = new TermReference();
          TermReference f_9723 = new TermReference();
          TermReference g_9723 = new TermReference();
          IStrategoTerm h_9723 = null;
          IStrategoTerm i_9723 = null;
          IStrategoTerm j_9723 = null;
          IStrategoTerm k_9723 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail141;
          IStrategoTerm arg197 = term.getSubterm(0);
          if(d_9723.value == null)
            d_9723.value = arg197;
          else
            if(d_9723.value != arg197 && !d_9723.value.match(arg197))
              break Fail141;
          if(arg197.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg197).getConstructor())
            break Fail141;
          h_9723 = arg197.getSubterm(0);
          IStrategoTerm arg198 = arg197.getSubterm(1);
          if(arg198.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg198).getConstructor())
            break Fail141;
          c_9723 = arg197.getSubterm(2);
          i_9723 = term;
          IStrategoTerm term151 = term;
          Success100:
          { 
            Fail142:
            { 
              term = c_9723;
              IStrategoTerm term152 = term;
              Success101:
              { 
                Fail143:
                { 
                  term = is_deprecated_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail143;
                  if(true)
                    break Success101;
                }
                term = is_reject_0_0.instance.invoke(context, term152);
                if(term == null)
                  break Fail142;
              }
              { 
                if(true)
                  break Fail141;
                if(true)
                  break Success100;
              }
            }
            term = term151;
          }
          term = i_9723;
          j_9723 = i_9723;
          lifted124 lifted1240 = new lifted124();
          lifted1240.d_9723 = d_9723;
          lifted1240.e_9723 = e_9723;
          lifted1240.g_9723 = g_9723;
          lifted1240.f_9723 = f_9723;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted1240);
          if(term == null)
            break Fail141;
          term = j_9723;
          k_9723 = j_9723;
          if(g_9723.value == null)
            break Fail141;
          term = accept_template_parts_0_1.instance.invoke(context, g_9723.value, h_9723);
          if(term == null)
            break Fail141;
          term = k_9723;
          if(f_9723.value == null || g_9723.value == null)
            break Fail141;
          term = termFactory.makeAppl(Main._consCompletionTemplateEx_4, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSort_1, new IStrategoTerm[]{h_9723}), (IStrategoList)generated.constNil0), termFactory.makeAppl(Main._consCompletionPrefix_1, new IStrategoTerm[]{f_9723.value}), g_9723.value, generated.constNil0});
          if(true)
            break Success99;
        }
        term = term150;
        IStrategoTerm term153 = term;
        Success102:
        { 
          Fail144:
          { 
            IStrategoTerm r_9722 = null;
            TermReference s_9722 = new TermReference();
            TermReference t_9722 = new TermReference();
            TermReference u_9722 = new TermReference();
            TermReference v_9722 = new TermReference();
            IStrategoTerm w_9722 = null;
            IStrategoTerm x_9722 = null;
            IStrategoTerm y_9722 = null;
            IStrategoTerm b_9723 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
              break Fail144;
            IStrategoTerm arg200 = term.getSubterm(0);
            if(s_9722.value == null)
              s_9722.value = arg200;
            else
              if(s_9722.value != arg200 && !s_9722.value.match(arg200))
                break Fail144;
            if(arg200.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg200).getConstructor())
              break Fail144;
            w_9722 = arg200.getSubterm(0);
            IStrategoTerm arg201 = arg200.getSubterm(1);
            if(arg201.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg201).getConstructor())
              break Fail144;
            r_9722 = arg200.getSubterm(2);
            x_9722 = term;
            IStrategoTerm term154 = term;
            Success103:
            { 
              Fail145:
              { 
                term = r_9722;
                IStrategoTerm term155 = term;
                Success104:
                { 
                  Fail146:
                  { 
                    term = is_deprecated_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail146;
                    if(true)
                      break Success104;
                  }
                  term = is_reject_0_0.instance.invoke(context, term155);
                  if(term == null)
                    break Fail145;
                }
                { 
                  if(true)
                    break Fail144;
                  if(true)
                    break Success103;
                }
              }
              term = term154;
            }
            term = x_9722;
            y_9722 = x_9722;
            lifted126 lifted1260 = new lifted126();
            lifted1260.s_9722 = s_9722;
            lifted1260.t_9722 = t_9722;
            lifted1260.v_9722 = v_9722;
            lifted1260.u_9722 = u_9722;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted1260);
            if(term == null)
              break Fail144;
            term = y_9722;
            b_9723 = y_9722;
            if(v_9722.value == null)
              break Fail144;
            term = accept_template_parts_0_1.instance.invoke(context, v_9722.value, w_9722);
            if(term == null)
              break Fail144;
            term = b_9723;
            if(u_9722.value == null || v_9722.value == null)
              break Fail144;
            term = termFactory.makeAppl(Main._consCompletionTemplateEx_4, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSort_1, new IStrategoTerm[]{w_9722}), (IStrategoList)generated.constNil0), termFactory.makeAppl(Main._consCompletionPrefix_1, new IStrategoTerm[]{u_9722.value}), v_9722.value, generated.constCons64});
            if(true)
              break Success102;
          }
          term = term153;
          IStrategoTerm q_9722 = null;
          q_9722 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, q_9722, generated.const79);
          if(term == null)
            break Fail140;
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