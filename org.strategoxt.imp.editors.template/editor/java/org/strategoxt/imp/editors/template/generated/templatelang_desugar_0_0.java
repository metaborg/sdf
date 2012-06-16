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

@SuppressWarnings("all") public class templatelang_desugar_0_0 extends Strategy 
{ 
  public static templatelang_desugar_0_0 instance = new templatelang_desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_desugar_0_0");
    Fail255:
    { 
      IStrategoTerm term241 = term;
      Success187:
      { 
        Fail256:
        { 
          IStrategoTerm z_9734 = null;
          IStrategoTerm a_9735 = null;
          IStrategoTerm b_9735 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProduction_3 != ((IStrategoAppl)term).getConstructor())
            break Fail256;
          a_9735 = term.getSubterm(0);
          z_9734 = term.getSubterm(1);
          b_9735 = term.getSubterm(2);
          term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{z_9734, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{a_9735}), b_9735});
          if(true)
            break Success187;
        }
        term = term241;
        IStrategoTerm term242 = term;
        Success188:
        { 
          Fail257:
          { 
            IStrategoTerm r_9734 = null;
            IStrategoTerm s_9734 = null;
            TermReference t_9734 = new TermReference();
            TermReference u_9734 = new TermReference();
            TermReference v_9734 = new TermReference();
            IStrategoTerm w_9734 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
              break Fail257;
            IStrategoTerm arg337 = term.getSubterm(0);
            if(arg337.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)arg337).getConstructor())
              break Fail257;
            s_9734 = arg337.getSubterm(0);
            if(t_9734.value == null)
              t_9734.value = arg337.getSubterm(1);
            else
              if(t_9734.value != arg337.getSubterm(1) && !t_9734.value.match(arg337.getSubterm(1)))
                break Fail257;
            r_9734 = term.getSubterm(1);
            IStrategoTerm arg338 = term.getSubterm(2);
            if(arg338.getTermType() != IStrategoTerm.APPL || Main._consattrs_1 != ((IStrategoAppl)arg338).getConstructor())
              break Fail257;
            if(u_9734.value == null)
              u_9734.value = arg338.getSubterm(0);
            else
              if(u_9734.value != arg338.getSubterm(0) && !u_9734.value.match(arg338.getSubterm(0)))
                break Fail257;
            w_9734 = term;
            lifted175 lifted1750 = new lifted175();
            lifted1750.t_9734 = t_9734;
            lifted1750.u_9734 = u_9734;
            lifted1750.v_9734 = v_9734;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted1750);
            if(term == null)
              break Fail257;
            term = w_9734;
            if(v_9734.value == null)
              break Fail257;
            term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{r_9734, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{s_9734}), termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{v_9734.value})});
            if(true)
              break Success188;
          }
          term = term242;
          IStrategoTerm term243 = term;
          Success189:
          { 
            Fail258:
            { 
              IStrategoTerm k_9734 = null;
              IStrategoTerm l_9734 = null;
              TermReference m_9734 = new TermReference();
              TermReference n_9734 = new TermReference();
              IStrategoTerm o_9734 = null;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
                break Fail258;
              IStrategoTerm arg339 = term.getSubterm(0);
              if(arg339.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)arg339).getConstructor())
                break Fail258;
              l_9734 = arg339.getSubterm(0);
              if(m_9734.value == null)
                m_9734.value = arg339.getSubterm(1);
              else
                if(m_9734.value != arg339.getSubterm(1) && !m_9734.value.match(arg339.getSubterm(1)))
                  break Fail258;
              k_9734 = term.getSubterm(1);
              IStrategoTerm arg340 = term.getSubterm(2);
              if(arg340.getTermType() != IStrategoTerm.APPL || Main._consno_attrs_0 != ((IStrategoAppl)arg340).getConstructor())
                break Fail258;
              o_9734 = term;
              lifted176 lifted1760 = new lifted176();
              lifted1760.m_9734 = m_9734;
              lifted1760.n_9734 = n_9734;
              term = with_spxverify_1_0.instance.invoke(context, term, lifted1760);
              if(term == null)
                break Fail258;
              term = o_9734;
              if(n_9734.value == null)
                break Fail258;
              term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{k_9734, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{l_9734}), termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{n_9734.value})});
              if(true)
                break Success189;
            }
            term = term243;
            IStrategoTerm term244 = term;
            Success190:
            { 
              Fail259:
              { 
                IStrategoTerm e_9734 = null;
                TermReference f_9734 = new TermReference();
                TermReference g_9734 = new TermReference();
                TermReference h_9734 = new TermReference();
                TermReference i_9734 = new TermReference();
                IStrategoTerm j_9734 = null;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
                  break Fail259;
                e_9734 = term.getSubterm(0);
                if(f_9734.value == null)
                  f_9734.value = term.getSubterm(1);
                else
                  if(f_9734.value != term.getSubterm(1) && !f_9734.value.match(term.getSubterm(1)))
                    break Fail259;
                if(h_9734.value == null)
                  h_9734.value = term.getSubterm(2);
                else
                  if(h_9734.value != term.getSubterm(2) && !h_9734.value.match(term.getSubterm(2)))
                    break Fail259;
                j_9734 = term;
                lifted177 lifted1770 = new lifted177();
                lifted1770.f_9734 = f_9734;
                lifted1770.g_9734 = g_9734;
                lifted1770.h_9734 = h_9734;
                lifted1770.i_9734 = i_9734;
                term = with_spxverify_1_0.instance.invoke(context, term, lifted1770);
                if(term == null)
                  break Fail259;
                term = j_9734;
                if(g_9734.value == null || i_9734.value == null)
                  break Fail259;
                term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{e_9734, g_9734.value, termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{i_9734.value})})});
                if(true)
                  break Success190;
              }
              term = term244;
              IStrategoTerm term245 = term;
              Success191:
              { 
                Fail260:
                { 
                  IStrategoTerm t_9733 = null;
                  TermReference u_9733 = new TermReference();
                  TermReference v_9733 = new TermReference();
                  TermReference w_9733 = new TermReference();
                  TermReference x_9733 = new TermReference();
                  TermReference y_9733 = new TermReference();
                  IStrategoTerm z_9733 = null;
                  if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
                    break Fail260;
                  IStrategoTerm arg341 = term.getSubterm(0);
                  if(arg341.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)arg341).getConstructor())
                    break Fail260;
                  t_9733 = arg341.getSubterm(0);
                  if(w_9733.value == null)
                    w_9733.value = arg341.getSubterm(1);
                  else
                    if(w_9733.value != arg341.getSubterm(1) && !w_9733.value.match(arg341.getSubterm(1)))
                      break Fail260;
                  if(u_9733.value == null)
                    u_9733.value = term.getSubterm(1);
                  else
                    if(u_9733.value != term.getSubterm(1) && !u_9733.value.match(term.getSubterm(1)))
                      break Fail260;
                  if(x_9733.value == null)
                    x_9733.value = term.getSubterm(2);
                  else
                    if(x_9733.value != term.getSubterm(2) && !x_9733.value.match(term.getSubterm(2)))
                      break Fail260;
                  z_9733 = term;
                  lifted179 lifted1790 = new lifted179();
                  lifted1790.u_9733 = u_9733;
                  lifted1790.v_9733 = v_9733;
                  lifted1790.w_9733 = w_9733;
                  lifted1790.x_9733 = x_9733;
                  lifted1790.y_9733 = y_9733;
                  term = with_spxverify_1_0.instance.invoke(context, term, lifted1790);
                  if(term == null)
                    break Fail260;
                  term = z_9733;
                  if(v_9733.value == null || y_9733.value == null)
                    break Fail260;
                  term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{t_9733, v_9733.value, termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{y_9733.value})})});
                  if(true)
                    break Success191;
                }
                term = term245;
                IStrategoTerm q_9733 = null;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
                  break Fail255;
                q_9733 = term;
                term = debug_0_0.instance.invoke(context, generated.const98);
                if(term == null)
                  break Fail255;
                term = q_9733;
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