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

@SuppressWarnings("all") public class templatelang_production_to_signature_0_0 extends Strategy 
{ 
  public static templatelang_production_to_signature_0_0 instance = new templatelang_production_to_signature_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_production_to_signature_0_0");
    Fail70:
    { 
      IStrategoTerm term79 = term;
      Success52:
      { 
        Fail71:
        { 
          TermReference s_9715 = new TermReference();
          TermReference t_9715 = new TermReference();
          TermReference u_9715 = new TermReference();
          TermReference v_9715 = new TermReference();
          TermReference w_9715 = new TermReference();
          IStrategoTerm x_9715 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail71;
          IStrategoTerm arg68 = term.getSubterm(0);
          if(arg68.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg68).getConstructor())
            break Fail71;
          if(t_9715.value == null)
            t_9715.value = arg68.getSubterm(0);
          else
            if(t_9715.value != arg68.getSubterm(0) && !t_9715.value.match(arg68.getSubterm(0)))
              break Fail71;
          IStrategoTerm arg69 = arg68.getSubterm(1);
          if(arg69.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg69).getConstructor())
            break Fail71;
          if(s_9715.value == null)
            s_9715.value = arg69.getSubterm(0);
          else
            if(s_9715.value != arg69.getSubterm(0) && !s_9715.value.match(arg69.getSubterm(0)))
              break Fail71;
          if(v_9715.value == null)
            v_9715.value = arg68.getSubterm(2);
          else
            if(v_9715.value != arg68.getSubterm(2) && !v_9715.value.match(arg68.getSubterm(2)))
              break Fail71;
          x_9715 = term;
          lifted51 lifted511 = new lifted51();
          lifted511.s_9715 = s_9715;
          lifted511.t_9715 = t_9715;
          lifted511.u_9715 = u_9715;
          lifted511.v_9715 = v_9715;
          lifted511.w_9715 = w_9715;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted511, lifted53.instance);
          if(term == null)
            break Fail71;
          term = x_9715;
          if(w_9715.value == null)
            break Fail71;
          term = w_9715.value;
          if(true)
            break Success52;
        }
        term = term79;
        IStrategoTerm term80 = term;
        Success53:
        { 
          Fail72:
          { 
            TermReference l_9715 = new TermReference();
            TermReference m_9715 = new TermReference();
            TermReference n_9715 = new TermReference();
            TermReference o_9715 = new TermReference();
            TermReference p_9715 = new TermReference();
            IStrategoTerm q_9715 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
              break Fail72;
            IStrategoTerm arg74 = term.getSubterm(0);
            if(arg74.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg74).getConstructor())
              break Fail72;
            if(m_9715.value == null)
              m_9715.value = arg74.getSubterm(0);
            else
              if(m_9715.value != arg74.getSubterm(0) && !m_9715.value.match(arg74.getSubterm(0)))
                break Fail72;
            IStrategoTerm arg75 = arg74.getSubterm(1);
            if(arg75.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg75).getConstructor())
              break Fail72;
            if(l_9715.value == null)
              l_9715.value = arg75.getSubterm(0);
            else
              if(l_9715.value != arg75.getSubterm(0) && !l_9715.value.match(arg75.getSubterm(0)))
                break Fail72;
            if(o_9715.value == null)
              o_9715.value = arg74.getSubterm(2);
            else
              if(o_9715.value != arg74.getSubterm(2) && !o_9715.value.match(arg74.getSubterm(2)))
                break Fail72;
            q_9715 = term;
            lifted54 lifted540 = new lifted54();
            lifted540.l_9715 = l_9715;
            lifted540.m_9715 = m_9715;
            lifted540.n_9715 = n_9715;
            lifted540.o_9715 = o_9715;
            lifted540.p_9715 = p_9715;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted540, lifted57.instance);
            if(term == null)
              break Fail72;
            term = q_9715;
            if(p_9715.value == null)
              break Fail72;
            term = p_9715.value;
            if(true)
              break Success53;
          }
          term = term80;
          IStrategoTerm k_9715 = null;
          k_9715 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, k_9715, generated.const65);
          if(term == null)
            break Fail70;
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