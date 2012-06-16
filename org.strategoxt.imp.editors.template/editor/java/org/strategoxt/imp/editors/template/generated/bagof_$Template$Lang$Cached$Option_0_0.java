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

@SuppressWarnings("all") public class bagof_$Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static bagof_$Template$Lang$Cached$Option_0_0 instance = new bagof_$Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_TemplateLangCachedOption_0_0");
    Fail609:
    { 
      TermReference l_9765 = new TermReference();
      TermReference m_9765 = new TermReference();
      if(m_9765.value == null)
        m_9765.value = term;
      else
        if(m_9765.value != term && !m_9765.value.match(term))
          break Fail609;
      if(l_9765.value == null)
        l_9765.value = term;
      else
        if(l_9765.value != term && !l_9765.value.match(term))
          break Fail609;
      Success286:
      { 
        Fail610:
        { 
          IStrategoTerm q_9765 = null;
          q_9765 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, q_9765, generated.const116, m_9765.value);
          if(term == null)
            break Fail610;
          if(true)
            break Success286;
        }
        term = generated.constNil0;
      }
      lifted320 lifted3200 = new lifted320();
      lifted3200.l_9765 = l_9765;
      lifted3200.m_9765 = m_9765;
      term = filter_1_0.instance.invoke(context, term, lifted3200);
      if(term == null)
        break Fail609;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}