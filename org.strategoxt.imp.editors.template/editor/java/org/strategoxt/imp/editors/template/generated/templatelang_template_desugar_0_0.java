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

@SuppressWarnings("all") public class templatelang_template_desugar_0_0 extends Strategy 
{ 
  public static templatelang_template_desugar_0_0 instance = new templatelang_template_desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_template_desugar_0_0");
    Fail1085:
    { 
      IStrategoTerm term504 = term;
      Success450:
      { 
        Fail1086:
        { 
          TermReference s_32774 = new TermReference();
          TermReference t_32774 = new TermReference();
          IStrategoTerm u_32774 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1086;
          if(s_32774.value == null)
            s_32774.value = term.getSubterm(0);
          else
            if(s_32774.value != term.getSubterm(0) && !s_32774.value.match(term.getSubterm(0)))
              break Fail1086;
          u_32774 = term;
          lifted380 lifted3800 = new lifted380();
          lifted3800.s_32774 = s_32774;
          lifted3800.t_32774 = t_32774;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted3800);
          if(term == null)
            break Fail1086;
          term = u_32774;
          if(t_32774.value == null)
            break Fail1086;
          term = termFactory.makeAppl(Main._consSingleLineTemplate_1, new IStrategoTerm[]{t_32774.value});
          if(true)
            break Success450;
        }
        term = term504;
        IStrategoTerm term505 = term;
        Success451:
        { 
          Fail1087:
          { 
            TermReference p_32774 = new TermReference();
            TermReference q_32774 = new TermReference();
            IStrategoTerm r_32774 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
              break Fail1087;
            IStrategoTerm arg501 = term.getSubterm(0);
            if(arg501.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg501).isEmpty())
              break Fail1087;
            IStrategoTerm arg502 = ((IStrategoList)arg501).head();
            if(arg502.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg502).getConstructor())
              break Fail1087;
            if(p_32774.value == null)
              p_32774.value = arg502.getSubterm(0);
            else
              if(p_32774.value != arg502.getSubterm(0) && !p_32774.value.match(arg502.getSubterm(0)))
                break Fail1087;
            IStrategoTerm arg503 = ((IStrategoList)arg501).tail();
            if(arg503.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg503).isEmpty())
              break Fail1087;
            r_32774 = term;
            lifted381 lifted3810 = new lifted381();
            lifted3810.p_32774 = p_32774;
            lifted3810.q_32774 = q_32774;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted3810);
            if(term == null)
              break Fail1087;
            term = r_32774;
            if(q_32774.value == null)
              break Fail1087;
            term = termFactory.makeAppl(Main._consSingleLineTemplate_1, new IStrategoTerm[]{q_32774.value});
            if(true)
              break Success451;
          }
          term = term505;
          TermReference m_32773 = new TermReference();
          TermReference n_32773 = new TermReference();
          TermReference o_32773 = new TermReference();
          IStrategoTerm i_32774 = null;
          IStrategoTerm j_32774 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1085;
          if(n_32773.value == null)
            n_32773.value = term.getSubterm(0);
          else
            if(n_32773.value != term.getSubterm(0) && !n_32773.value.match(term.getSubterm(0)))
              break Fail1085;
          i_32774 = term;
          IStrategoTerm term506 = term;
          Success452:
          { 
            Fail1088:
            { 
              if(n_32773.value == null)
                break Fail1088;
              term = n_32773.value;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1088;
              IStrategoTerm arg505 = ((IStrategoList)term).tail();
              if(arg505.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg505).isEmpty())
                break Fail1088;
              { 
                if(true)
                  break Fail1085;
                if(true)
                  break Success452;
              }
            }
            term = term506;
          }
          term = i_32774;
          j_32774 = i_32774;
          lifted382 lifted3820 = new lifted382();
          lifted3820.n_32773 = n_32773;
          lifted3820.m_32773 = m_32773;
          lifted3820.o_32773 = o_32773;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted3820);
          if(term == null)
            break Fail1085;
          term = j_32774;
          if(o_32773.value == null)
            break Fail1085;
          term = termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{o_32773.value});
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