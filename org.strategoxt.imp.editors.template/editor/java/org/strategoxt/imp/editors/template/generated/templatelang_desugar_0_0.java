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
    Fail1075:
    { 
      IStrategoTerm term497 = term;
      Success443:
      { 
        Fail1076:
        { 
          IStrategoTerm i_32773 = null;
          IStrategoTerm j_32773 = null;
          IStrategoTerm k_32773 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProduction_3 != ((IStrategoAppl)term).getConstructor())
            break Fail1076;
          j_32773 = term.getSubterm(0);
          i_32773 = term.getSubterm(1);
          k_32773 = term.getSubterm(2);
          term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{i_32773, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{j_32773}), k_32773});
          if(true)
            break Success443;
        }
        term = term497;
        IStrategoTerm term498 = term;
        Success444:
        { 
          Fail1077:
          { 
            IStrategoTerm a_32773 = null;
            IStrategoTerm b_32773 = null;
            TermReference c_32773 = new TermReference();
            TermReference d_32773 = new TermReference();
            TermReference e_32773 = new TermReference();
            IStrategoTerm f_32773 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
              break Fail1077;
            IStrategoTerm arg490 = term.getSubterm(0);
            if(arg490.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)arg490).getConstructor())
              break Fail1077;
            b_32773 = arg490.getSubterm(0);
            if(c_32773.value == null)
              c_32773.value = arg490.getSubterm(1);
            else
              if(c_32773.value != arg490.getSubterm(1) && !c_32773.value.match(arg490.getSubterm(1)))
                break Fail1077;
            a_32773 = term.getSubterm(1);
            IStrategoTerm arg491 = term.getSubterm(2);
            if(arg491.getTermType() != IStrategoTerm.APPL || Main._consattrs_1 != ((IStrategoAppl)arg491).getConstructor())
              break Fail1077;
            if(d_32773.value == null)
              d_32773.value = arg491.getSubterm(0);
            else
              if(d_32773.value != arg491.getSubterm(0) && !d_32773.value.match(arg491.getSubterm(0)))
                break Fail1077;
            f_32773 = term;
            lifted374 lifted3740 = new lifted374();
            lifted3740.c_32773 = c_32773;
            lifted3740.d_32773 = d_32773;
            lifted3740.e_32773 = e_32773;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted3740);
            if(term == null)
              break Fail1077;
            term = f_32773;
            if(e_32773.value == null)
              break Fail1077;
            term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{a_32773, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{b_32773}), termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{e_32773.value})});
            if(true)
              break Success444;
          }
          term = term498;
          IStrategoTerm term499 = term;
          Success445:
          { 
            Fail1078:
            { 
              IStrategoTerm t_32772 = null;
              IStrategoTerm u_32772 = null;
              TermReference v_32772 = new TermReference();
              TermReference w_32772 = new TermReference();
              IStrategoTerm x_32772 = null;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
                break Fail1078;
              IStrategoTerm arg492 = term.getSubterm(0);
              if(arg492.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)arg492).getConstructor())
                break Fail1078;
              u_32772 = arg492.getSubterm(0);
              if(v_32772.value == null)
                v_32772.value = arg492.getSubterm(1);
              else
                if(v_32772.value != arg492.getSubterm(1) && !v_32772.value.match(arg492.getSubterm(1)))
                  break Fail1078;
              t_32772 = term.getSubterm(1);
              IStrategoTerm arg493 = term.getSubterm(2);
              if(arg493.getTermType() != IStrategoTerm.APPL || Main._consno_attrs_0 != ((IStrategoAppl)arg493).getConstructor())
                break Fail1078;
              x_32772 = term;
              lifted375 lifted3750 = new lifted375();
              lifted3750.v_32772 = v_32772;
              lifted3750.w_32772 = w_32772;
              term = with_spxverify_1_0.instance.invoke(context, term, lifted3750);
              if(term == null)
                break Fail1078;
              term = x_32772;
              if(w_32772.value == null)
                break Fail1078;
              term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{t_32772, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{u_32772}), termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{w_32772.value})});
              if(true)
                break Success445;
            }
            term = term499;
            IStrategoTerm term500 = term;
            Success446:
            { 
              Fail1079:
              { 
                IStrategoTerm n_32772 = null;
                TermReference o_32772 = new TermReference();
                TermReference p_32772 = new TermReference();
                TermReference q_32772 = new TermReference();
                TermReference r_32772 = new TermReference();
                IStrategoTerm s_32772 = null;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
                  break Fail1079;
                n_32772 = term.getSubterm(0);
                if(o_32772.value == null)
                  o_32772.value = term.getSubterm(1);
                else
                  if(o_32772.value != term.getSubterm(1) && !o_32772.value.match(term.getSubterm(1)))
                    break Fail1079;
                if(q_32772.value == null)
                  q_32772.value = term.getSubterm(2);
                else
                  if(q_32772.value != term.getSubterm(2) && !q_32772.value.match(term.getSubterm(2)))
                    break Fail1079;
                s_32772 = term;
                lifted376 lifted3760 = new lifted376();
                lifted3760.o_32772 = o_32772;
                lifted3760.p_32772 = p_32772;
                lifted3760.q_32772 = q_32772;
                lifted3760.r_32772 = r_32772;
                term = with_spxverify_1_0.instance.invoke(context, term, lifted3760);
                if(term == null)
                  break Fail1079;
                term = s_32772;
                if(p_32772.value == null || r_32772.value == null)
                  break Fail1079;
                term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{n_32772, p_32772.value, termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{r_32772.value})})});
                if(true)
                  break Success446;
              }
              term = term500;
              IStrategoTerm term501 = term;
              Success447:
              { 
                Fail1080:
                { 
                  IStrategoTerm c_32772 = null;
                  TermReference d_32772 = new TermReference();
                  TermReference e_32772 = new TermReference();
                  TermReference f_32772 = new TermReference();
                  TermReference g_32772 = new TermReference();
                  TermReference h_32772 = new TermReference();
                  IStrategoTerm i_32772 = null;
                  if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
                    break Fail1080;
                  IStrategoTerm arg494 = term.getSubterm(0);
                  if(arg494.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)arg494).getConstructor())
                    break Fail1080;
                  c_32772 = arg494.getSubterm(0);
                  if(f_32772.value == null)
                    f_32772.value = arg494.getSubterm(1);
                  else
                    if(f_32772.value != arg494.getSubterm(1) && !f_32772.value.match(arg494.getSubterm(1)))
                      break Fail1080;
                  if(d_32772.value == null)
                    d_32772.value = term.getSubterm(1);
                  else
                    if(d_32772.value != term.getSubterm(1) && !d_32772.value.match(term.getSubterm(1)))
                      break Fail1080;
                  if(g_32772.value == null)
                    g_32772.value = term.getSubterm(2);
                  else
                    if(g_32772.value != term.getSubterm(2) && !g_32772.value.match(term.getSubterm(2)))
                      break Fail1080;
                  i_32772 = term;
                  lifted378 lifted3780 = new lifted378();
                  lifted3780.d_32772 = d_32772;
                  lifted3780.e_32772 = e_32772;
                  lifted3780.f_32772 = f_32772;
                  lifted3780.g_32772 = g_32772;
                  lifted3780.h_32772 = h_32772;
                  term = with_spxverify_1_0.instance.invoke(context, term, lifted3780);
                  if(term == null)
                    break Fail1080;
                  term = i_32772;
                  if(e_32772.value == null || h_32772.value == null)
                    break Fail1080;
                  term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{c_32772, e_32772.value, termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{h_32772.value})})});
                  if(true)
                    break Success447;
                }
                term = term501;
                IStrategoTerm z_32771 = null;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
                  break Fail1075;
                z_32771 = term;
                term = debug_0_0.instance.invoke(context, generated.const219);
                if(term == null)
                  break Fail1075;
                term = z_32771;
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