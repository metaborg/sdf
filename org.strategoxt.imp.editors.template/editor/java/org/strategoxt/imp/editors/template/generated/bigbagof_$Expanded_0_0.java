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

@SuppressWarnings("all") public class bigbagof_$Expanded_0_0 extends Strategy 
{ 
  public static bigbagof_$Expanded_0_0 instance = new bigbagof_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_Expanded_0_0");
    Fail578:
    { 
      TermReference m_9760 = new TermReference();
      TermReference n_9760 = new TermReference();
      if(n_9760.value == null)
        n_9760.value = term;
      else
        if(n_9760.value != term && !n_9760.value.match(term))
          break Fail578;
      if(m_9760.value == null)
        m_9760.value = term;
      else
        if(m_9760.value != term && !m_9760.value.match(term))
          break Fail578;
      Success277:
      { 
        Fail579:
        { 
          IStrategoTerm r_9760 = null;
          r_9760 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, r_9760, generated.const96, n_9760.value);
          if(term == null)
            break Fail579;
          if(true)
            break Success277;
        }
        term = generated.constNil0;
      }
      lifted308 lifted3080 = new lifted308();
      lifted3080.m_9760 = m_9760;
      lifted3080.n_9760 = n_9760;
      term = filter_1_0.instance.invoke(context, term, lifted3080);
      if(term == null)
        break Fail578;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}