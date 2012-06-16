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

@SuppressWarnings("all") public class templatelang_element_desugar_0_0 extends Strategy 
{ 
  public static templatelang_element_desugar_0_0 instance = new templatelang_element_desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_element_desugar_0_0");
    Fail270:
    { 
      IStrategoTerm term255 = term;
      IStrategoConstructor cons21 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success197:
      { 
        if(cons21 == Main._consNoOptions_0)
        { 
          Fail271:
          { 
            term = generated.constNil0;
            if(true)
              break Success197;
          }
          term = term255;
        }
        Success198:
        { 
          if(cons21 == Main._consOptions_1)
          { 
            Fail272:
            { 
              IStrategoTerm w_9738 = null;
              w_9738 = term.getSubterm(0);
              term = alltd_1_0.instance.invoke(context, w_9738, lifted201.instance);
              if(term == null)
                break Fail272;
              if(true)
                break Success198;
            }
            term = term255;
          }
          IStrategoTerm term257 = term;
          Success199:
          { 
            Fail273:
            { 
              TermReference t_9736 = new TermReference();
              TermReference u_9736 = new TermReference();
              IStrategoTerm v_9737 = null;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consEscape_1 != ((IStrategoAppl)term).getConstructor())
                break Fail273;
              if(t_9736.value == null)
                t_9736.value = term.getSubterm(0);
              else
                if(t_9736.value != term.getSubterm(0) && !t_9736.value.match(term.getSubterm(0)))
                  break Fail273;
              v_9737 = term;
              lifted203 lifted2030 = new lifted203();
              lifted2030.t_9736 = t_9736;
              lifted2030.u_9736 = u_9736;
              term = with_spxverify_1_0.instance.invoke(context, term, lifted2030);
              if(term == null)
                break Fail273;
              term = v_9737;
              if(u_9736.value == null)
                break Fail273;
              term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{u_9736.value});
              if(true)
                break Success199;
            }
            term = term257;
            TermReference m_9736 = new TermReference();
            TermReference n_9736 = new TermReference();
            IStrategoTerm o_9736 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)term).getConstructor())
              break Fail270;
            if(m_9736.value == null)
              m_9736.value = term.getSubterm(0);
            else
              if(m_9736.value != term.getSubterm(0) && !m_9736.value.match(term.getSubterm(0)))
                break Fail270;
            o_9736 = term;
            lifted207 lifted2070 = new lifted207();
            lifted2070.m_9736 = m_9736;
            lifted2070.n_9736 = n_9736;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted2070);
            if(term == null)
              break Fail270;
            term = o_9736;
            if(n_9736.value == null)
              break Fail270;
            term = termFactory.makeAppl(Main._consLayout_1, new IStrategoTerm[]{n_9736.value});
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